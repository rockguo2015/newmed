package com.fudanmed.platform.core.domain.impl;

import com.fudanmed.platform.core.domain.RCEmployee;
import com.fudanmed.platform.core.domain.RCFaultType;
import com.fudanmed.platform.core.domain.RCGroupTask;
import com.fudanmed.platform.core.domain.RCWorkItemPicture;
import com.fudanmed.platform.core.domain.RCWorkItemTask;
import com.fudanmed.platform.core.domain.RCWorkItemTaskStatus;
import com.fudanmed.platform.core.domain.impl.RCEmployeeImpl;
import com.fudanmed.platform.core.domain.impl.RCFaultTypeImpl;
import com.fudanmed.platform.core.domain.impl.RCGroupTaskImpl;
import com.fudanmed.platform.core.domain.impl.RCWorkItemPictureImpl;
import com.fudanmed.platform.core.domain.proxy.RCWorkItemTaskProxy;
import com.fudanmed.platform.core.warehouse.RCProductEntry;
import com.fudanmed.platform.core.warehouse.RCProductSpecification;
import com.fudanmed.platform.core.warehouse.RCProductStorage;
import com.fudanmed.platform.core.warehouse.RCWorkItemStockRecord;
import com.fudanmed.platform.core.warehouse.RCWorkItemStorage;
import com.fudanmed.platform.core.warehouse.impl.RCRCProductStorageContainerImpl;
import com.fudanmed.platform.core.warehouse.impl.RCWorkItemStorageImpl;
import com.google.common.base.Objects;
import com.google.common.collect.Iterables;
import edu.fudan.langlab.domain.document.IDocument;
import edu.fudan.langlab.domain.statemachine.ModelObjectLogService;
import edu.fudan.mylang.common.NumberExtensions;
import edu.fudan.mylang.common.ObjectExtensions2;
import edu.fudan.mylang.common.StringExtensions;
import edu.fudan.mylang.pf.IGenericQuery;
import edu.fudan.mylang.pf.IObjectFactory;
import edu.fudan.mylang.utils.DateUtil;
import edu.fudan.mylang.utils.DateUtil.Month;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.eclipse.xtext.xbase.lib.DoubleExtensions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.Functions.Function2;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.hibernate.annotations.DiscriminatorOptions;

@Entity
@DiscriminatorValue("RCWORKITEMTASK_TYPE")
@DiscriminatorOptions(force = true)
@DiscriminatorColumn(length = 64)
@Table(name = "rcworkitemtask")
public class RCWorkItemTaskImpl extends RCRCProductStorageContainerImpl implements RCWorkItemTask {
  public RCWorkItemTaskImpl() {
    super();
  }
  
  public RCWorkItemTaskImpl(final RCGroupTask groupTask) {
    super();
    this.groupTask = groupTask;
  }
  
  private RCWorkItemTaskStatus Status;
  
  public RCWorkItemTaskStatus getStatus() {
    return this.Status;
  }
  
  private ModelObjectLogService getModelObjectLogService() {
    return getBeanFactory().getBean(ModelObjectLogService.class);
  }
  
  private void _start() {
    
    Status=RCWorkItemTaskStatus.processing;
    this.groupTask.taskCreated(this);
  }
  
  public void start() {
    if(Status==null){
    	_start();
    	getModelObjectLogService().createLog(this,"Status","Initialize");
    }else{
    	throw new edu.fudan.langlab.domain.statemachine.InvalidStateException();
    }
  }
  
  private void _followup() {
    
    Status=RCWorkItemTaskStatus.followuping;
  }
  
  public void followup() {
    if(Status==RCWorkItemTaskStatus.processing){
    	_followup();
    	getModelObjectLogService().createLog(this,"Status","followup");
    	getBeanFactory().getBean(com.fudanmed.platform.core.domain.events.RCWorkItemTaskEventsManager.class).fireFollowup(this);						
    }else{
    	throw new edu.fudan.langlab.domain.statemachine.InvalidStateException();
    }
  }
  
  private void _pend() {
    
    Status=RCWorkItemTaskStatus.pending;
  }
  
  public void pend() {
    if(Status==RCWorkItemTaskStatus.processing){
    	_pend();
    	getModelObjectLogService().createLog(this,"Status","pend");
    	getBeanFactory().getBean(com.fudanmed.platform.core.domain.events.RCWorkItemTaskEventsManager.class).firePend(this);						
    }else{
    	throw new edu.fudan.langlab.domain.statemachine.InvalidStateException();
    }
  }
  
  private void _misDispatching() {
    
    Status=RCWorkItemTaskStatus.misDispatching;
    this.groupTask.taskFinished(this);
  }
  
  public void misDispatching() {
    if(Status==RCWorkItemTaskStatus.processing){
    	_misDispatching();
    	getModelObjectLogService().createLog(this,"Status","misDispatching");
    	getBeanFactory().getBean(com.fudanmed.platform.core.domain.events.RCWorkItemTaskEventsManager.class).fireMisDispatching(this);						
    }else{
    	throw new edu.fudan.langlab.domain.statemachine.InvalidStateException();
    }
  }
  
  private void _outsource() {
    
    Status=RCWorkItemTaskStatus.outsourcing;
  }
  
  public void outsource() {
    if(Status==RCWorkItemTaskStatus.processing){
    	_outsource();
    	getModelObjectLogService().createLog(this,"Status","outsource");
    	getBeanFactory().getBean(com.fudanmed.platform.core.domain.events.RCWorkItemTaskEventsManager.class).fireOutsource(this);						
    }else{
    	throw new edu.fudan.langlab.domain.statemachine.InvalidStateException();
    }
  }
  
  private void _cancel() {
    
    Status=RCWorkItemTaskStatus.canceled;
  }
  
  public void cancel() {
    if(Status==RCWorkItemTaskStatus.processing){
    	_cancel();
    	getModelObjectLogService().createLog(this,"Status","cancel");
    	getBeanFactory().getBean(com.fudanmed.platform.core.domain.events.RCWorkItemTaskEventsManager.class).fireCancel(this);						
    }else{
    	throw new edu.fudan.langlab.domain.statemachine.InvalidStateException();
    }
  }
  
  private void _cancelPend() {
    
    Status=RCWorkItemTaskStatus.pendFinish;
    this.groupTask.taskFinished(this);
  }
  
  public void cancelPend() {
    if(Status==RCWorkItemTaskStatus.pending){
    	_cancelPend();
    	getModelObjectLogService().createLog(this,"Status","cancelPend");
    	getBeanFactory().getBean(com.fudanmed.platform.core.domain.events.RCWorkItemTaskEventsManager.class).fireCancelPend(this);						
    }else{
    	throw new edu.fudan.langlab.domain.statemachine.InvalidStateException();
    }
  }
  
  private void _finishOutsource() {
    
    Status=RCWorkItemTaskStatus.outsourceFinish;
    this.groupTask.taskFinished(this);
  }
  
  public void finishOutsource() {
    if(Status==RCWorkItemTaskStatus.outsourcing){
    	_finishOutsource();
    	getModelObjectLogService().createLog(this,"Status","finishOutsource");
    	getBeanFactory().getBean(com.fudanmed.platform.core.domain.events.RCWorkItemTaskEventsManager.class).fireFinishOutsource(this);						
    }else{
    	throw new edu.fudan.langlab.domain.statemachine.InvalidStateException();
    }
  }
  
  private void _finish() {
    
    Status=RCWorkItemTaskStatus.finished;
    this.groupTask.taskFinished(this);
  }
  
  public void finish() {
    if(Status==RCWorkItemTaskStatus.followuping||Status==RCWorkItemTaskStatus.processing){
    	_finish();
    	getModelObjectLogService().createLog(this,"Status","finish");
    	getBeanFactory().getBean(com.fudanmed.platform.core.domain.events.RCWorkItemTaskEventsManager.class).fireFinish(this);						
    }else{
    	throw new edu.fudan.langlab.domain.statemachine.InvalidStateException();
    }
  }
  
  public Boolean isProcessing() {
    return com.fudanmed.platform.core.domain.RCWorkItemTaskStatus.processing==Status;
  }
  
  public Boolean isFollowuping() {
    return com.fudanmed.platform.core.domain.RCWorkItemTaskStatus.followuping==Status;
  }
  
  public Boolean isPending() {
    return com.fudanmed.platform.core.domain.RCWorkItemTaskStatus.pending==Status;
  }
  
  public Boolean isOutsourcing() {
    return com.fudanmed.platform.core.domain.RCWorkItemTaskStatus.outsourcing==Status;
  }
  
  public Boolean isMisDispatching() {
    return com.fudanmed.platform.core.domain.RCWorkItemTaskStatus.misDispatching==Status;
  }
  
  public Boolean isPendFinish() {
    return com.fudanmed.platform.core.domain.RCWorkItemTaskStatus.pendFinish==Status;
  }
  
  public Boolean isOutsourceFinish() {
    return com.fudanmed.platform.core.domain.RCWorkItemTaskStatus.outsourceFinish==Status;
  }
  
  public Boolean isFinished() {
    return com.fudanmed.platform.core.domain.RCWorkItemTaskStatus.finished==Status;
  }
  
  public Boolean isCanceled() {
    return com.fudanmed.platform.core.domain.RCWorkItemTaskStatus.canceled==Status;
  }
  
  @JoinColumn(name = "groupTask_id")
  @ManyToOne(targetEntity = RCGroupTaskImpl.class, cascade = { CascadeType.MERGE, CascadeType.PERSIST })
  private RCGroupTask groupTask;
  
  public RCGroupTask getGroupTask() {
    return this.groupTask;
  }
  
  public RCWorkItemTask setGroupTask(final RCGroupTask groupTask) {
    this.groupTask = groupTask;
    return this;			
    
  }
  
  private String sid;
  
  public String getSid() {
    return this.sid;
  }
  
  public RCWorkItemTask setSid(final String sid) {
    this.sid = sid;
    return this;			
    
  }
  
  private Date date;
  
  public Date getDate() {
    return this.date;
  }
  
  public RCWorkItemTask setDate(final Date date) {
    this.date = date;
    return this;			
    
  }
  
  private Date time;
  
  public Date getTime() {
    return this.time;
  }
  
  public RCWorkItemTask setTime(final Date time) {
    this.time = time;
    return this;			
    
  }
  
  private Date finishDate;
  
  public Date getFinishDate() {
    return this.finishDate;
  }
  
  public RCWorkItemTask setFinishDate(final Date finishDate) {
    this.finishDate = finishDate;
    return this;			
    
  }
  
  private Date finishTime;
  
  public Date getFinishTime() {
    return this.finishTime;
  }
  
  public RCWorkItemTask setFinishTime(final Date finishTime) {
    this.finishTime = finishTime;
    return this;			
    
  }
  
  @ManyToMany(targetEntity = RCEmployeeImpl.class)
  @JoinTable(name = "m2m_rcworkitemtask_workers", joinColumns = @JoinColumn(name = "rcworkitemtask_id") , inverseJoinColumns = @JoinColumn(name = "rCEmployee_inv_id") )
  private Collection<RCEmployee> workers = new java.util.ArrayList<com.fudanmed.platform.core.domain.RCEmployee>();;
  
  public Collection<RCEmployee> getWorkers() {
    return this.workers;
  }
  
  public RCWorkItemTask setWorkers(final Iterable<RCEmployee> workers) {
    removeAllWorkers();
    for(RCEmployee ca : workers){
    	addtoWorkers(ca);
    }
    return this;		
    
  }
  
  public RCWorkItemTask addtoWorkers(final RCEmployee rCEmployee) {
    this.workers.add(rCEmployee);
    return this;
    
  }
  
  public RCWorkItemTask removeAllWorkers() {
    this.workers.clear();
    return this;	
    
  }
  
  public RCWorkItemTask removeFromWorkers(final RCEmployee rCEmployee) {
    this.workers.remove(rCEmployee);
    return this;
    
  }
  
  private String comment;
  
  public String getComment() {
    return this.comment;
  }
  
  public RCWorkItemTask setComment(final String comment) {
    this.comment = comment;
    return this;			
    
  }
  
  @JoinColumn(name = "operator_id")
  @ManyToOne(targetEntity = RCEmployeeImpl.class, cascade = { CascadeType.MERGE, CascadeType.PERSIST })
  private RCEmployee operator;
  
  public RCEmployee getOperator() {
    return this.operator;
  }
  
  public RCWorkItemTask setOperator(final RCEmployee operator) {
    this.operator = operator;
    return this;			
    
  }
  
  @JoinColumn(name = "faultType_id")
  @ManyToOne(targetEntity = RCFaultTypeImpl.class, cascade = { CascadeType.MERGE, CascadeType.PERSIST })
  private RCFaultType faultType;
  
  public RCFaultType getFaultType() {
    return this.faultType;
  }
  
  public RCWorkItemTask setFaultType(final RCFaultType faultType) {
    this.faultType = faultType;
    return this;			
    
  }
  
  private String faultDescription;
  
  public String getFaultDescription() {
    return this.faultDescription;
  }
  
  public RCWorkItemTask setFaultDescription(final String faultDescription) {
    this.faultDescription = faultDescription;
    return this;			
    
  }
  
  @OneToMany(targetEntity = RCWorkItemPictureImpl.class, cascade = { CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REMOVE }, mappedBy = "workitemTask")
  private Collection<RCWorkItemPicture> documents = new java.util.ArrayList<com.fudanmed.platform.core.domain.RCWorkItemPicture>();;
  
  public Collection<RCWorkItemPicture> getDocuments() {
    return this.documents;
  }
  
  public RCWorkItemPicture createAndAddtoDocuments() {
    getDocuments().size();
    com.fudanmed.platform.core.domain.RCWorkItemPicture rCWorkItemPicture = new com.fudanmed.platform.core.domain.impl.RCWorkItemPictureImpl(this);
    getObjectFactory().create(rCWorkItemPicture);
    getDocuments().add(rCWorkItemPicture);
    return rCWorkItemPicture;
    
  }
  
  public RCWorkItemTask removeAllDocuments() {
    for(RCWorkItemPicture obj : this.documents){
    	getObjectFactory().delete(obj);
    }
    this.documents.clear();
    return this;	
    
  }
  
  public RCWorkItemTask removeFromDocuments(final RCWorkItemPicture rCWorkItemPicture) {
    this.documents.remove(rCWorkItemPicture);
    getObjectFactory().delete(rCWorkItemPicture);
    return this;
    
  }
  
  public IDocument createDocument(final Procedure1<? super IDocument> init) {
    RCWorkItemPicture _createAndAddtoDocuments = this.createAndAddtoDocuments();
    final Procedure1<RCWorkItemPicture> _function = new Procedure1<RCWorkItemPicture>() {
        public void apply(final RCWorkItemPicture it) {
          init.apply(it);
          String _plus = (RCWorkItemTaskImpl.this.sid + ":");
          String _name = it.getName();
          String _nullsafe = StringExtensions.nullsafe(_name);
          String _plus_1 = (_plus + _nullsafe);
          it.setName(_plus_1);
        }
      };
    RCWorkItemPicture _doubleArrow = ObjectExtensions.<RCWorkItemPicture>operator_doubleArrow(_createAndAddtoDocuments, _function);
    return _doubleArrow;
  }
  
  public void removeDocument(final IDocument document) {
    this.removeFromDocuments(((RCWorkItemPicture) document));
  }
  
  private String month;
  
  public String getMonth() {
    return this.month;
  }
  
  public RCWorkItemTask setMonth(final String month) {
    this.month = month;
    return this;			
    
  }
  
  public String getEntityName() {
    return this.sid;
  }
  
  public Collection<RCEmployee> getTaskOwners() {
    return this.workers;
  }
  
  public String getDescription() {
    return this.comment;
  }
  
  public Boolean isEnd() {
    boolean _xblockexpression = false;
    {
      boolean _switchResult = false;
      final RCWorkItemTaskStatus _switchValue = this.Status;
      boolean _matched = false;
      if (!_matched) {
        if (Objects.equal(_switchValue,RCWorkItemTaskStatus.processing)) {
          _matched=true;
          _switchResult = false;
        }
      }
      if (!_matched) {
        if (Objects.equal(_switchValue,RCWorkItemTaskStatus.outsourcing)) {
          _matched=true;
          _switchResult = false;
        }
      }
      if (!_matched) {
        if (Objects.equal(_switchValue,RCWorkItemTaskStatus.pending)) {
          _matched=true;
          _switchResult = false;
        }
      }
      if (!_matched) {
        if (Objects.equal(_switchValue,RCWorkItemTaskStatus.followuping)) {
          _matched=true;
          _switchResult = false;
        }
      }
      if (!_matched) {
        _switchResult = true;
      }
      boolean result = _switchResult;
      _xblockexpression = (result);
    }
    return Boolean.valueOf(_xblockexpression);
  }
  
  public Collection<RCWorkItemStockRecord> getOutStoreRecord() {
    IGenericQuery<RCWorkItemStockRecord> query=getObjectFactory().createGenericQuery(RCWorkItemStockRecord.class,"select r from com.fudanmed.platform.core.warehouse.impl.RCWorkItemStockRecordImpl as r   where (r.workItem = :this) and  r.active = 1      ").setParameter("this",this);
    Collection<RCWorkItemStockRecord> _list = query.list();
    return _list;
  }
  
  public Collection<RCWorkItemStorage> getStorage() {
    IGenericQuery<RCWorkItemStorage> query=getObjectFactory().createGenericQuery(RCWorkItemStorage.class,"select s from com.fudanmed.platform.core.warehouse.impl.RCWorkItemStorageImpl as s   where (s.workItem = :this) and  s.active = 1      ").setParameter("this",this);
    Collection<RCWorkItemStorage> _list = query.list();
    return _list;
  }
  
  public Collection<RCProductStorage> getAllProductStorage(final RCProductSpecification productSpec) {
    IGenericQuery<RCWorkItemStorage> query=getObjectFactory().createGenericQuery(RCWorkItemStorage.class,"select ps from com.fudanmed.platform.core.warehouse.impl.RCWorkItemStorageImpl as ps   where ((ps.productEntry.productSpec = :productSpec) and (ps.workItem = :this)) and  ps.active = 1  order by ps.productEntry.inStockRecord.date ASC    ").setParameter("productSpec",productSpec).setParameter("this",this);
    Collection<RCWorkItemStorage> _list = query.list();
    Iterable<RCProductStorage> _filter = Iterables.<RCProductStorage>filter(_list, RCProductStorage.class);
    List<RCProductStorage> _list_1 = IterableExtensions.<RCProductStorage>toList(_filter);
    return _list_1;
  }
  
  public Double getAmount() {
    Collection<RCWorkItemStorage> _storage = this.getStorage();
    final Function1<RCWorkItemStorage,Double> _function = new Function1<RCWorkItemStorage,Double>() {
        public Double apply(final RCWorkItemStorage it) {
          Double _amount = it.getAmount();
          return _amount;
        }
      };
    Iterable<Double> _map = IterableExtensions.<RCWorkItemStorage, Double>map(_storage, _function);
    final Function2<Double,Double,Double> _function_1 = new Function2<Double,Double,Double>() {
        public Double apply(final Double d1, final Double d2) {
          double _plus = DoubleExtensions.operator_plus(d1, d2);
          return Double.valueOf(_plus);
        }
      };
    Double _reduce = IterableExtensions.<Double>reduce(_map, _function_1);
    Double _nullsafe = NumberExtensions.nullsafe(_reduce);
    return _nullsafe;
  }
  
  public RCProductStorage getOrCreateProductStorage(final RCProductEntry productEntry) {
    IGenericQuery<RCWorkItemStorage> query=getObjectFactory().createGenericQuery(RCWorkItemStorage.class,"select ps from com.fudanmed.platform.core.warehouse.impl.RCWorkItemStorageImpl as ps   where ((ps.productEntry = :productEntry) and (ps.workItem = :this)) and  ps.active = 1      ").setParameter("productEntry",productEntry).setParameter("this",this);
    RCWorkItemStorage _uniqueResult = query.uniqueResult();
    final Function1<Void,RCWorkItemStorage> _function = new Function1<Void,RCWorkItemStorage>() {
        public RCWorkItemStorage apply(final Void it) {RCWorkItemStorage rCWorkItemStorage=RCWorkItemStorageImpl.create(getObjectFactory());
          final Procedure1<RCWorkItemStorage> _function = new Procedure1<RCWorkItemStorage>() {
              public void apply(final RCWorkItemStorage it) {
                it.setWorkItem(RCWorkItemTaskImpl.this);
                it.setProductEntry(productEntry);
                it.setQuantity(Integer.valueOf(0));
              }
            };
          RCWorkItemStorage _doubleArrow = ObjectExtensions.<RCWorkItemStorage>operator_doubleArrow(rCWorkItemStorage, _function);
          return _doubleArrow;
        }
      };
    RCWorkItemStorage _withDefault = ObjectExtensions2.<RCWorkItemStorage>withDefault(_uniqueResult, _function);
    return _withDefault;
  }
  
  public void updateDerived() {
    Month _month = DateUtil.getMonth(this.date);
    String _serialize = _month.serialize();
    this.month = _serialize;
  }
  
  public static RCWorkItemTask create(final RCGroupTask groupTask, final IObjectFactory objectFactory) {
    com.fudanmed.platform.core.domain.RCWorkItemTask rCWorkItemTask = new com.fudanmed.platform.core.domain.impl.RCWorkItemTaskImpl(
    	groupTask
    );
    objectFactory.create(rCWorkItemTask);
    return rCWorkItemTask;			
    
  }
  
  public RCWorkItemTaskProxy toProxy() {
    com.fudanmed.platform.core.domain.proxy.RCWorkItemTaskProxy proxy = new com.fudanmed.platform.core.domain.proxy.RCWorkItemTaskProxy();
    proxy.setId(this.getId());
    if(this instanceof edu.fudan.mylang.pf.INamedModelObject){
    	proxy.setName(((edu.fudan.mylang.pf.INamedModelObject)this).getEntityName());
    }
    return proxy;
    
  }
}
