package com.fudanmed.platform.core.deliver.impl;

import com.fudanmed.platform.core.deliver.DLResource;
import com.fudanmed.platform.core.deliver.DLResourceEvent;
import com.fudanmed.platform.core.deliver.DLResourceEventType;
import com.fudanmed.platform.core.deliver.DLResourceExtBorrowEvent;
import com.fudanmed.platform.core.deliver.DLResourceLifecycleEvent;
import com.fudanmed.platform.core.deliver.DLResourceStatus;
import com.fudanmed.platform.core.deliver.DLResourceType;
import com.fudanmed.platform.core.deliver.impl.DLResourceEventImpl;
import com.fudanmed.platform.core.deliver.impl.DLResourceExtBorrowEventImpl;
import com.fudanmed.platform.core.deliver.impl.DLResourceLifecycleEventImpl;
import com.fudanmed.platform.core.deliver.impl.DLResourceTypeImpl;
import com.fudanmed.platform.core.deliver.proxy.DLResourceProxy;
import edu.fudan.langlab.domain.statemachine.ModelObjectLogService;
import edu.fudan.mylang.pf.BaseModelObject;
import edu.fudan.mylang.pf.IGenericQuery;
import edu.fudan.mylang.pf.IObjectFactory;
import edu.fudan.mylang.utils.DateUtil;
import java.util.Collection;
import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.hibernate.annotations.DiscriminatorOptions;

@Entity
@DiscriminatorValue("DLRESOURCE_TYPE")
@DiscriminatorOptions(force = true)
@DiscriminatorColumn(length = 64)
@Table(name = "dlresource")
public class DLResourceImpl extends BaseModelObject implements DLResource {
  public DLResourceImpl() {
    super();
  }
  
  private DLResourceStatus Status;
  
  public DLResourceStatus getStatus() {
    return this.Status;
  }
  
  private ModelObjectLogService getModelObjectLogService() {
    return getBeanFactory().getBean(ModelObjectLogService.class);
  }
  
  private void _start() {
    
    this.createLifeCycleEvent(DLResourceEventType.register);
    Status=DLResourceStatus.ready4use;
  }
  
  public void start() {
    if(Status==null){
    	_start();
    	getModelObjectLogService().createLog(this,"Status","Initialize");
    }else{
    	throw new edu.fudan.langlab.domain.statemachine.InvalidStateException();
    }
  }
  
  private void _repair(final String comment) {
    
    DLResourceEvent _createLifeCycleEvent = this.createLifeCycleEvent(DLResourceEventType.repair);
    final Procedure1<DLResourceEvent> _function = new Procedure1<DLResourceEvent>() {
        public void apply(final DLResourceEvent it) {
          it.setComment(comment);
        }
      };
    ObjectExtensions.<DLResourceEvent>operator_doubleArrow(_createLifeCycleEvent, _function);
    Status=DLResourceStatus.repairing;
  }
  
  public void repair(final String comment) {
    if(Status==DLResourceStatus.ready4use){
    	_repair(comment);
    	getModelObjectLogService().createLog(this,"Status","repair");
    	getBeanFactory().getBean(com.fudanmed.platform.core.deliver.events.DLResourceEventsManager.class).fireRepair(this,comment);						
    }else{
    	throw new edu.fudan.langlab.domain.statemachine.InvalidStateException();
    }
  }
  
  private void _borrow() {
    
    Status=DLResourceStatus.borrowed;
  }
  
  public void borrow() {
    if(Status==DLResourceStatus.ready4use){
    	_borrow();
    	getModelObjectLogService().createLog(this,"Status","borrow");
    	getBeanFactory().getBean(com.fudanmed.platform.core.deliver.events.DLResourceEventsManager.class).fireBorrow(this);						
    }else{
    	throw new edu.fudan.langlab.domain.statemachine.InvalidStateException();
    }
  }
  
  private void _extBorrow(final String comment) {
    
    this.createExtBorrowEvent(comment);
    Status=DLResourceStatus.extBorrowed;
  }
  
  public void extBorrow(final String comment) {
    if(Status==DLResourceStatus.ready4use){
    	_extBorrow(comment);
    	getModelObjectLogService().createLog(this,"Status","extBorrow");
    	getBeanFactory().getBean(com.fudanmed.platform.core.deliver.events.DLResourceEventsManager.class).fireExtBorrow(this,comment);						
    }else{
    	throw new edu.fudan.langlab.domain.statemachine.InvalidStateException();
    }
  }
  
  private void _unregister(final String comment) {
    
    DLResourceEvent _createLifeCycleEvent = this.createLifeCycleEvent(DLResourceEventType.unregister);
    final Procedure1<DLResourceEvent> _function = new Procedure1<DLResourceEvent>() {
        public void apply(final DLResourceEvent it) {
          it.setComment(comment);
        }
      };
    ObjectExtensions.<DLResourceEvent>operator_doubleArrow(_createLifeCycleEvent, _function);
    Status=DLResourceStatus.unregistered;
  }
  
  public void unregister(final String comment) {
    if(Status==DLResourceStatus.ready4use||Status==DLResourceStatus.repairing){
    	_unregister(comment);
    	getModelObjectLogService().createLog(this,"Status","unregister");
    	getBeanFactory().getBean(com.fudanmed.platform.core.deliver.events.DLResourceEventsManager.class).fireUnregister(this,comment);						
    }else{
    	throw new edu.fudan.langlab.domain.statemachine.InvalidStateException();
    }
  }
  
  private void _finishRepair(final String comment) {
    
    DLResourceEvent _createLifeCycleEvent = this.createLifeCycleEvent(DLResourceEventType.finishRepair);
    final Procedure1<DLResourceEvent> _function = new Procedure1<DLResourceEvent>() {
        public void apply(final DLResourceEvent it) {
          it.setComment(comment);
        }
      };
    ObjectExtensions.<DLResourceEvent>operator_doubleArrow(_createLifeCycleEvent, _function);
    Status=DLResourceStatus.ready4use;
  }
  
  public void finishRepair(final String comment) {
    if(Status==DLResourceStatus.repairing){
    	_finishRepair(comment);
    	getModelObjectLogService().createLog(this,"Status","finishRepair");
    	getBeanFactory().getBean(com.fudanmed.platform.core.deliver.events.DLResourceEventsManager.class).fireFinishRepair(this,comment);						
    }else{
    	throw new edu.fudan.langlab.domain.statemachine.InvalidStateException();
    }
  }
  
  private void _doExtReturn() {
    
    IGenericQuery<DLResourceExtBorrowEvent> query=getObjectFactory().createGenericQuery(DLResourceExtBorrowEvent.class,"select e from com.fudanmed.platform.core.deliver.impl.DLResourceExtBorrowEventImpl as e   where ((e.resource = :this) and (e.returnDateTime IS   NULL )) and  e.active = 1      ").setParameter("this",this);
    final DLResourceExtBorrowEvent event = query.uniqueResult();
    event.setReturned(Boolean.valueOf(true));
    Date _now = DateUtil.now();
    event.setReturnDateTime(_now);
    Status=DLResourceStatus.ready4use;
  }
  
  public void doExtReturn() {
    if(Status==DLResourceStatus.extBorrowed){
    	_doExtReturn();
    	getModelObjectLogService().createLog(this,"Status","doExtReturn");
    	getBeanFactory().getBean(com.fudanmed.platform.core.deliver.events.DLResourceEventsManager.class).fireDoExtReturn(this);						
    }else{
    	throw new edu.fudan.langlab.domain.statemachine.InvalidStateException();
    }
  }
  
  private void _doReturn() {
    
    Status=DLResourceStatus.ready4use;
  }
  
  public void doReturn() {
    if(Status==DLResourceStatus.borrowed){
    	_doReturn();
    	getModelObjectLogService().createLog(this,"Status","doReturn");
    	getBeanFactory().getBean(com.fudanmed.platform.core.deliver.events.DLResourceEventsManager.class).fireDoReturn(this);						
    }else{
    	throw new edu.fudan.langlab.domain.statemachine.InvalidStateException();
    }
  }
  
  public Boolean isReady4use() {
    return com.fudanmed.platform.core.deliver.DLResourceStatus.ready4use==Status;
  }
  
  public Boolean isBorrowed() {
    return com.fudanmed.platform.core.deliver.DLResourceStatus.borrowed==Status;
  }
  
  public Boolean isExtBorrowed() {
    return com.fudanmed.platform.core.deliver.DLResourceStatus.extBorrowed==Status;
  }
  
  public Boolean isRepairing() {
    return com.fudanmed.platform.core.deliver.DLResourceStatus.repairing==Status;
  }
  
  public Boolean isUnregistered() {
    return com.fudanmed.platform.core.deliver.DLResourceStatus.unregistered==Status;
  }
  
  private String sid;
  
  public String getSid() {
    return this.sid;
  }
  
  public DLResource setSid(final String sid) {
    this.sid = sid;
    return this;			
    
  }
  
  @JoinColumn(name = "type_id")
  @ManyToOne(targetEntity = DLResourceTypeImpl.class, cascade = { CascadeType.MERGE, CascadeType.PERSIST })
  private DLResourceType type;
  
  public DLResourceType getType() {
    return this.type;
  }
  
  public DLResource setType(final DLResourceType type) {
    this.type = type;
    return this;			
    
  }
  
  private String description;
  
  public String getDescription() {
    return this.description;
  }
  
  public DLResource setDescription(final String description) {
    this.description = description;
    return this;			
    
  }
  
  @OneToMany(targetEntity = DLResourceEventImpl.class, cascade = { CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REMOVE }, mappedBy = "resource")
  private Collection<DLResourceEvent> events = new java.util.ArrayList<com.fudanmed.platform.core.deliver.DLResourceEvent>();;
  
  public Collection<DLResourceEvent> getEvents() {
    return this.events;
  }
  
  public DLResourceEvent createAndAddtoEvents() {
    getEvents().size();
    com.fudanmed.platform.core.deliver.DLResourceEvent dLResourceEvent = new com.fudanmed.platform.core.deliver.impl.DLResourceEventImpl(this);
    getObjectFactory().create(dLResourceEvent);
    getEvents().add(dLResourceEvent);
    return dLResourceEvent;
    
  }
  
  public DLResource removeAllEvents() {
    for(DLResourceEvent obj : this.events){
    	getObjectFactory().delete(obj);
    }
    this.events.clear();
    return this;	
    
  }
  
  public DLResource removeFromEvents(final DLResourceEvent dLResourceEvent) {
    this.events.remove(dLResourceEvent);
    getObjectFactory().delete(dLResourceEvent);
    return this;
    
  }
  
  public DLResourceEvent createLifeCycleEvent(final DLResourceEventType type) {DLResourceLifecycleEvent dLResourceLifecycleEvent=DLResourceLifecycleEventImpl.create(this,getObjectFactory());
    final Procedure1<DLResourceLifecycleEvent> _function = new Procedure1<DLResourceLifecycleEvent>() {
        public void apply(final DLResourceLifecycleEvent it) {
          Date _day = DateUtil.today();
          it.setDate(_day);
          it.setType(type);
          String _comment = it.getComment();
          it.setComment(_comment);
        }
      };
    DLResourceLifecycleEvent _doubleArrow = ObjectExtensions.<DLResourceLifecycleEvent>operator_doubleArrow(dLResourceLifecycleEvent, _function);
    return _doubleArrow;
  }
  
  public DLResourceExtBorrowEvent createExtBorrowEvent(final String comment) {DLResourceExtBorrowEvent dLResourceExtBorrowEvent=DLResourceExtBorrowEventImpl.create(this,getObjectFactory());
    final Procedure1<DLResourceExtBorrowEvent> _function = new Procedure1<DLResourceExtBorrowEvent>() {
        public void apply(final DLResourceExtBorrowEvent it) {
          Date _day = DateUtil.today();
          it.setDate(_day);
          Date _now = DateUtil.now();
          it.setDateTime(_now);
          it.setComment(comment);
        }
      };
    DLResourceExtBorrowEvent _doubleArrow = ObjectExtensions.<DLResourceExtBorrowEvent>operator_doubleArrow(dLResourceExtBorrowEvent, _function);
    return _doubleArrow;
  }
  
  public static DLResource create(final IObjectFactory objectFactory) {
    com.fudanmed.platform.core.deliver.DLResource dLResource = new com.fudanmed.platform.core.deliver.impl.DLResourceImpl(
    );
    objectFactory.create(dLResource);
    return dLResource;			
    
  }
  
  public DLResourceProxy toProxy() {
    com.fudanmed.platform.core.deliver.proxy.DLResourceProxy proxy = new com.fudanmed.platform.core.deliver.proxy.DLResourceProxy();
    proxy.setId(this.getId());
    if(this instanceof edu.fudan.mylang.pf.INamedModelObject){
    	proxy.setName(((edu.fudan.mylang.pf.INamedModelObject)this).getEntityName());
    }
    return proxy;
    
  }
}
