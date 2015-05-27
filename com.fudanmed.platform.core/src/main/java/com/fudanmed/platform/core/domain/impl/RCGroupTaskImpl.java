package com.fudanmed.platform.core.domain.impl;

import com.fudanmed.platform.core.common.RCSequenceService;
import com.fudanmed.platform.core.domain.RCEmployee;
import com.fudanmed.platform.core.domain.RCGroupTask;
import com.fudanmed.platform.core.domain.RCGroupTaskStatus;
import com.fudanmed.platform.core.domain.RCMaintenanceTeam;
import com.fudanmed.platform.core.domain.RCRepairTask;
import com.fudanmed.platform.core.domain.RCTaskDirtyManager;
import com.fudanmed.platform.core.domain.RCWorkItemPicture;
import com.fudanmed.platform.core.domain.RCWorkItemTask;
import com.fudanmed.platform.core.domain.RCWorkItemTaskStatus;
import com.fudanmed.platform.core.domain.impl.RCEmployeeImpl;
import com.fudanmed.platform.core.domain.impl.RCMaintenanceTeamImpl;
import com.fudanmed.platform.core.domain.impl.RCRepairTaskImpl;
import com.fudanmed.platform.core.domain.impl.RCWorkItemTaskImpl;
import com.fudanmed.platform.core.domain.proxy.RCGroupTaskProxy;
import com.fudanmed.platform.core.warehouse.RCWorkItemStorage;
import com.google.common.base.Objects;
import com.google.common.collect.Iterables;
import edu.fudan.langlab.domain.document.IDocument;
import edu.fudan.langlab.domain.statemachine.ModelObjectLogService;
import edu.fudan.mylang.common.NumberExtensions;
import edu.fudan.mylang.pf.BaseModelObject;
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
import org.springframework.beans.factory.BeanFactory;

@Entity
@DiscriminatorValue("RCGROUPTASK_TYPE")
@DiscriminatorOptions(force = true)
@DiscriminatorColumn(length = 64)
@Table(name = "rcgrouptask")
public class RCGroupTaskImpl extends BaseModelObject implements RCGroupTask {
  public RCGroupTaskImpl() {
    super();
  }
  
  public RCGroupTaskImpl(final RCRepairTask repairTask) {
    super();
    this.repairTask = repairTask;
  }
  
  private RCGroupTaskStatus Status;
  
  public RCGroupTaskStatus getStatus() {
    return this.Status;
  }
  
  private ModelObjectLogService getModelObjectLogService() {
    return getBeanFactory().getBean(ModelObjectLogService.class);
  }
  
  private void _start() {
    
    RCTaskDirtyManager _taskDirtyManager = this.getTaskDirtyManager();
    _taskDirtyManager.notifyTeam(this.team);
    this.updateDerived();
    Status=RCGroupTaskStatus.newCreated;
  }
  
  public void start() {
    if(Status==null){
    	_start();
    	getModelObjectLogService().createLog(this,"Status","Initialize");
    }else{
    	throw new edu.fudan.langlab.domain.statemachine.InvalidStateException();
    }
  }
  
  private void _reportFinish() {
    
    Boolean _hasMisDispatchedTask = this.hasMisDispatchedTask();
    boolean _not = (!_hasMisDispatchedTask);
    if (_not) {
      this.repairTask.groupTaskFinished(this);
    } else {
      this.repairTask.misdispatch(this);
    }
    RCTaskDirtyManager _taskDirtyManager = this.getTaskDirtyManager();
    _taskDirtyManager.notifyScheduler(this.team);
    Status=RCGroupTaskStatus.finished;
  }
  
  public void reportFinish() {
    if(Status==RCGroupTaskStatus.wait4TeamOwnerProcess){
    	_reportFinish();
    	getModelObjectLogService().createLog(this,"Status","reportFinish");
    	getBeanFactory().getBean(com.fudanmed.platform.core.domain.events.RCGroupTaskEventsManager.class).fireReportFinish(this);						
    }else{
    	throw new edu.fudan.langlab.domain.statemachine.InvalidStateException();
    }
  }
  
  private void _cancel() {
    
    Status=RCGroupTaskStatus.canceled;
  }
  
  public void cancel() {
    if(Status==RCGroupTaskStatus.newCreated){
    	_cancel();
    	getModelObjectLogService().createLog(this,"Status","cancel");
    	getBeanFactory().getBean(com.fudanmed.platform.core.domain.events.RCGroupTaskEventsManager.class).fireCancel(this);						
    }else{
    	throw new edu.fudan.langlab.domain.statemachine.InvalidStateException();
    }
  }
  
  private void _reportMisdispatch() {
    
    this.repairTask.misdispatch(this);
    RCTaskDirtyManager _taskDirtyManager = this.getTaskDirtyManager();
    _taskDirtyManager.notifyScheduler(this.team);
    Status=RCGroupTaskStatus.misDispatched;
  }
  
  public void reportMisdispatch() {
    if(Status==RCGroupTaskStatus.newCreated||Status==RCGroupTaskStatus.wait4TeamOwnerProcess){
    	_reportMisdispatch();
    	getModelObjectLogService().createLog(this,"Status","reportMisdispatch");
    	getBeanFactory().getBean(com.fudanmed.platform.core.domain.events.RCGroupTaskEventsManager.class).fireReportMisdispatch(this);						
    }else{
    	throw new edu.fudan.langlab.domain.statemachine.InvalidStateException();
    }
  }
  
  private void _taskCreated(final RCWorkItemTask task) {
    
    final RCGroupTaskStatus _switchValue = this.Status;
    boolean _matched = false;
    if (!_matched) {
      if (Objects.equal(_switchValue,RCGroupTaskStatus.newCreated)) {
        _matched=true;
        this.repairTask.firstWorkItemCreated();
      }
    }
    Status=RCGroupTaskStatus.wait4TasksFinish;
  }
  
  public void taskCreated(final RCWorkItemTask task) {
    if(Status==RCGroupTaskStatus.newCreated||Status==RCGroupTaskStatus.wait4TeamOwnerProcess||Status==RCGroupTaskStatus.wait4TasksFinish){
    	_taskCreated(task);
    	getModelObjectLogService().createLog(this,"Status","taskCreated");
    	getBeanFactory().getBean(com.fudanmed.platform.core.domain.events.RCGroupTaskEventsManager.class).fireTaskCreated(this,task);						
    }else{
    	throw new edu.fudan.langlab.domain.statemachine.InvalidStateException();
    }
  }
  
  private void _taskFinished(final RCWorkItemTask task) {
    
    Boolean _allTasksFinished = this.allTasksFinished();
    if ((_allTasksFinished).booleanValue()) {
      Status=RCGroupTaskStatus.wait4TeamOwnerProcess;
    } else {
      Status=RCGroupTaskStatus.wait4TasksFinish;
    }
  }
  
  public void taskFinished(final RCWorkItemTask task) {
    if(Status==RCGroupTaskStatus.wait4TasksFinish){
    	_taskFinished(task);
    	getModelObjectLogService().createLog(this,"Status","taskFinished");
    	getBeanFactory().getBean(com.fudanmed.platform.core.domain.events.RCGroupTaskEventsManager.class).fireTaskFinished(this,task);						
    }else{
    	throw new edu.fudan.langlab.domain.statemachine.InvalidStateException();
    }
  }
  
  public Boolean isNewCreated() {
    return com.fudanmed.platform.core.domain.RCGroupTaskStatus.newCreated==Status;
  }
  
  public Boolean isWait4TeamOwnerProcess() {
    return com.fudanmed.platform.core.domain.RCGroupTaskStatus.wait4TeamOwnerProcess==Status;
  }
  
  public Boolean isWait4TasksFinish() {
    return com.fudanmed.platform.core.domain.RCGroupTaskStatus.wait4TasksFinish==Status;
  }
  
  public Boolean isFinished() {
    return com.fudanmed.platform.core.domain.RCGroupTaskStatus.finished==Status;
  }
  
  public Boolean isMisDispatched() {
    return com.fudanmed.platform.core.domain.RCGroupTaskStatus.misDispatched==Status;
  }
  
  public Boolean isCanceled() {
    return com.fudanmed.platform.core.domain.RCGroupTaskStatus.canceled==Status;
  }
  
  @JoinColumn(name = "repairTask_id")
  @ManyToOne(targetEntity = RCRepairTaskImpl.class, cascade = { CascadeType.MERGE, CascadeType.PERSIST })
  private RCRepairTask repairTask;
  
  public RCRepairTask getRepairTask() {
    return this.repairTask;
  }
  
  public RCGroupTask setRepairTask(final RCRepairTask repairTask) {
    this.repairTask = repairTask;
    return this;			
    
  }
  
  @JoinColumn(name = "team_id")
  @ManyToOne(targetEntity = RCMaintenanceTeamImpl.class, cascade = { CascadeType.MERGE, CascadeType.PERSIST })
  private RCMaintenanceTeam team;
  
  public RCMaintenanceTeam getTeam() {
    return this.team;
  }
  
  public RCGroupTask setTeam(final RCMaintenanceTeam team) {
    this.team = team;
    return this;			
    
  }
  
  private Date date;
  
  public Date getDate() {
    return this.date;
  }
  
  public RCGroupTask setDate(final Date date) {
    this.date = date;
    return this;			
    
  }
  
  private Date time;
  
  public Date getTime() {
    return this.time;
  }
  
  public RCGroupTask setTime(final Date time) {
    this.time = time;
    return this;			
    
  }
  
  private String comment;
  
  public String getComment() {
    return this.comment;
  }
  
  public RCGroupTask setComment(final String comment) {
    this.comment = comment;
    return this;			
    
  }
  
  private Date finishDate;
  
  public Date getFinishDate() {
    return this.finishDate;
  }
  
  public RCGroupTask setFinishDate(final Date finishDate) {
    this.finishDate = finishDate;
    return this;			
    
  }
  
  private Date finishTime;
  
  public Date getFinishTime() {
    return this.finishTime;
  }
  
  public RCGroupTask setFinishTime(final Date finishTime) {
    this.finishTime = finishTime;
    return this;			
    
  }
  
  @JoinColumn(name = "operator_id")
  @ManyToOne(targetEntity = RCEmployeeImpl.class, cascade = { CascadeType.MERGE, CascadeType.PERSIST })
  private RCEmployee operator;
  
  public RCEmployee getOperator() {
    return this.operator;
  }
  
  public RCGroupTask setOperator(final RCEmployee operator) {
    this.operator = operator;
    return this;			
    
  }
  
  private String month;
  
  public String getMonth() {
    return this.month;
  }
  
  public RCGroupTask setMonth(final String month) {
    this.month = month;
    return this;			
    
  }
  
  @OneToMany(targetEntity = RCWorkItemTaskImpl.class, cascade = { CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REMOVE }, mappedBy = "groupTask")
  private Collection<RCWorkItemTask> tasks = new java.util.ArrayList<com.fudanmed.platform.core.domain.RCWorkItemTask>();;
  
  public Collection<RCWorkItemTask> getTasks() {
    return this.tasks;
  }
  
  public RCWorkItemTask createAndAddtoTasks() {
    getTasks().size();
    com.fudanmed.platform.core.domain.RCWorkItemTask rCWorkItemTask = new com.fudanmed.platform.core.domain.impl.RCWorkItemTaskImpl(this);
    getObjectFactory().create(rCWorkItemTask);
    getTasks().add(rCWorkItemTask);
    return rCWorkItemTask;
    
  }
  
  public RCGroupTask removeAllTasks() {
    for(RCWorkItemTask obj : this.tasks){
    	getObjectFactory().delete(obj);
    }
    this.tasks.clear();
    return this;	
    
  }
  
  public RCGroupTask removeFromTasks(final RCWorkItemTask rCWorkItemTask) {
    this.tasks.remove(rCWorkItemTask);
    getObjectFactory().delete(rCWorkItemTask);
    return this;
    
  }
  
  public Double getAmount() {
    final Function1<RCWorkItemTask,Double> _function = new Function1<RCWorkItemTask,Double>() {
        public Double apply(final RCWorkItemTask it) {
          Double _amount = it.getAmount();
          return _amount;
        }
      };
    Iterable<Double> _map = IterableExtensions.<RCWorkItemTask, Double>map(this.tasks, _function);
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
  
  public Boolean allTasksFinished() {
    final Function1<RCWorkItemTask,Boolean> _function = new Function1<RCWorkItemTask,Boolean>() {
        public Boolean apply(final RCWorkItemTask it) {
          Boolean _isEnd = it.isEnd();
          return _isEnd;
        }
      };
    boolean _forall = IterableExtensions.<RCWorkItemTask>forall(this.tasks, _function);
    return Boolean.valueOf(_forall);
  }
  
  public Boolean allTasksFinishedExcept(final RCWorkItemTask task) {
    final Function1<RCWorkItemTask,Boolean> _function = new Function1<RCWorkItemTask,Boolean>() {
        public Boolean apply(final RCWorkItemTask it) {
          boolean _or = false;
          boolean _equals = Objects.equal(it, task);
          if (_equals) {
            _or = true;
          } else {
            Boolean _isEnd = it.isEnd();
            _or = (_equals || (_isEnd).booleanValue());
          }
          return Boolean.valueOf(_or);
        }
      };
    boolean _forall = IterableExtensions.<RCWorkItemTask>forall(this.tasks, _function);
    return Boolean.valueOf(_forall);
  }
  
  public void updateDerived() {
    Month _month = DateUtil.getMonth(this.date);
    String _serialize = _month.serialize();
    this.month = _serialize;
  }
  
  public Boolean hasMisDispatchedTask() {
    final Function1<RCWorkItemTask,Boolean> _function = new Function1<RCWorkItemTask,Boolean>() {
        public Boolean apply(final RCWorkItemTask task) {
          boolean _switchResult = false;
          RCWorkItemTaskStatus _status = task.getStatus();
          final RCWorkItemTaskStatus _switchValue = _status;
          boolean _matched = false;
          if (!_matched) {
            if (Objects.equal(_switchValue,RCWorkItemTaskStatus.misDispatching)) {
              _matched=true;
              _switchResult = true;
            }
          }
          if (!_matched) {
            _switchResult = false;
          }
          return Boolean.valueOf(_switchResult);
        }
      };
    boolean _exists = IterableExtensions.<RCWorkItemTask>exists(this.tasks, _function);
    return Boolean.valueOf(_exists);
  }
  
  public Boolean isEnd() {
    Boolean _allTasksFinished = this.allTasksFinished();
    return _allTasksFinished;
  }
  
  public Collection<RCWorkItemStorage> getStorage() {
    final Function1<RCWorkItemTask,Collection<RCWorkItemStorage>> _function = new Function1<RCWorkItemTask,Collection<RCWorkItemStorage>>() {
        public Collection<RCWorkItemStorage> apply(final RCWorkItemTask it) {
          Collection<RCWorkItemStorage> _storage = it.getStorage();
          return _storage;
        }
      };
    Iterable<Collection<RCWorkItemStorage>> _map = IterableExtensions.<RCWorkItemTask, Collection<RCWorkItemStorage>>map(this.tasks, _function);
    Iterable<RCWorkItemStorage> _flatten = Iterables.<RCWorkItemStorage>concat(_map);
    List<RCWorkItemStorage> _list = IterableExtensions.<RCWorkItemStorage>toList(_flatten);
    return _list;
  }
  
  public RCTaskDirtyManager getTaskDirtyManager() {
    BeanFactory _beanFactory = this.getBeanFactory();
    RCTaskDirtyManager _bean = _beanFactory.<RCTaskDirtyManager>getBean(RCTaskDirtyManager.class);
    return _bean;
  }
  
  public Collection<? extends IDocument> getDocuments() {
    final Function1<RCWorkItemTask,Collection<RCWorkItemPicture>> _function = new Function1<RCWorkItemTask,Collection<RCWorkItemPicture>>() {
        public Collection<RCWorkItemPicture> apply(final RCWorkItemTask it) {
          Collection<RCWorkItemPicture> _documents = it.getDocuments();
          return _documents;
        }
      };
    Iterable<Collection<RCWorkItemPicture>> _map = IterableExtensions.<RCWorkItemTask, Collection<RCWorkItemPicture>>map(this.tasks, _function);
    Iterable<RCWorkItemPicture> _flatten = Iterables.<RCWorkItemPicture>concat(_map);
    List<RCWorkItemPicture> _list = IterableExtensions.<RCWorkItemPicture>toList(_flatten);
    return _list;
  }
  
  public RCWorkItemTask createWorkItemTask() {RCWorkItemTask rCWorkItemTask=RCWorkItemTaskImpl.create(this,getObjectFactory());
    final Procedure1<RCWorkItemTask> _function = new Procedure1<RCWorkItemTask>() {
        public void apply(final RCWorkItemTask it) {
          BeanFactory _beanFactory = RCGroupTaskImpl.this.getBeanFactory();
          RCSequenceService _bean = _beanFactory.<RCSequenceService>getBean(RCSequenceService.class);
          String _nextWorkItemTaskSequence = _bean.getNextWorkItemTaskSequence();
          it.setSid(_nextWorkItemTaskSequence);
          it.start();
        }
      };
    RCWorkItemTask _doubleArrow = ObjectExtensions.<RCWorkItemTask>operator_doubleArrow(rCWorkItemTask, _function);
    return _doubleArrow;
  }
  
  public static RCGroupTask create(final RCRepairTask repairTask, final IObjectFactory objectFactory) {
    com.fudanmed.platform.core.domain.RCGroupTask rCGroupTask = new com.fudanmed.platform.core.domain.impl.RCGroupTaskImpl(
    	repairTask
    );
    objectFactory.create(rCGroupTask);
    return rCGroupTask;			
    
  }
  
  public RCGroupTaskProxy toProxy() {
    com.fudanmed.platform.core.domain.proxy.RCGroupTaskProxy proxy = new com.fudanmed.platform.core.domain.proxy.RCGroupTaskProxy();
    proxy.setId(this.getId());
    if(this instanceof edu.fudan.mylang.pf.INamedModelObject){
    	proxy.setName(((edu.fudan.mylang.pf.INamedModelObject)this).getEntityName());
    }
    return proxy;
    
  }
}
