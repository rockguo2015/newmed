package com.fudanmed.platform.core.deliver.impl;

import com.fudanmed.platform.core.deliver.DLCenterlizedDeliverTask;
import com.fudanmed.platform.core.deliver.DLCenterlizedDeliverTaskStatus;
import com.fudanmed.platform.core.deliver.DLDeliverSubject;
import com.fudanmed.platform.core.deliver.DLPatientCheckDeliverTaskEvent;
import com.fudanmed.platform.core.deliver.DLPatientCheckDeliverTaskEventType;
import com.fudanmed.platform.core.deliver.DLPlanDateTime;
import com.fudanmed.platform.core.deliver.DLResource;
import com.fudanmed.platform.core.deliver.impl.DLDeliverSubjectImpl;
import com.fudanmed.platform.core.deliver.impl.DLPatientCheckDeliverTaskEventImpl;
import com.fudanmed.platform.core.deliver.impl.DLResourceImpl;
import com.fudanmed.platform.core.deliver.impl.DLTaskImpl;
import com.fudanmed.platform.core.deliver.proxy.DLCenterlizedDeliverTaskProxy;
import com.fudanmed.platform.core.domain.RCEmployee;
import com.uniquesoft.uidl.validation.Validates;
import edu.fudan.langlab.domain.statemachine.ModelObjectLogService;
import edu.fudan.mylang.pf.IObjectFactory;
import edu.fudan.mylang.utils.DateUtil;
import java.util.Collection;
import java.util.Date;
import javax.persistence.AssociationOverrides;
import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

@Entity
@DiscriminatorValue("DLCENTERLIZEDDELIVERTASK_TYPE")
public class DLCenterlizedDeliverTaskImpl extends DLTaskImpl implements DLCenterlizedDeliverTask {
  public DLCenterlizedDeliverTaskImpl() {
    super();
  }
  
  private DLCenterlizedDeliverTaskStatus Status;
  
  public DLCenterlizedDeliverTaskStatus getStatus() {
    return this.Status;
  }
  
  private ModelObjectLogService getModelObjectLogService() {
    return getBeanFactory().getBean(ModelObjectLogService.class);
  }
  
  private void _start() {
    
    Date _now = DateUtil.now();
    this.setCreateTime(_now);
    DLPatientCheckDeliverTaskEvent _createEvent = this.createEvent(DLPatientCheckDeliverTaskEventType.create);
    final Procedure1<DLPatientCheckDeliverTaskEvent> _function = new Procedure1<DLPatientCheckDeliverTaskEvent>() {
        public void apply(final DLPatientCheckDeliverTaskEvent it) {
          it.setComment("\u65B0\u5EFA\u4EFB\u52A1");
        }
      };
    ObjectExtensions.<DLPatientCheckDeliverTaskEvent>operator_doubleArrow(_createEvent, _function);
    Status=DLCenterlizedDeliverTaskStatus.scheduled;
  }
  
  public void start() {
    if(Status==null){
    	_start();
    	getModelObjectLogService().createLog(this,"Status","Initialize");
    }else{
    	throw new edu.fudan.langlab.domain.statemachine.InvalidStateException();
    }
  }
  
  private void _dispatch(final Collection<RCEmployee> performers) {
    
    boolean _isNullOrEmpty = IterableExtensions.isNullOrEmpty(performers);
    boolean _not = (!_isNullOrEmpty);
    Validates.Assert(_not, "\u5FC5\u987B\u8BBE\u7F6E\u8FD0\u9001\u5458");
    this.setPerformers(performers);
    DLPatientCheckDeliverTaskEvent _createEvent = this.createEvent(DLPatientCheckDeliverTaskEventType.dispatch);
    final Procedure1<DLPatientCheckDeliverTaskEvent> _function = new Procedure1<DLPatientCheckDeliverTaskEvent>() {
        public void apply(final DLPatientCheckDeliverTaskEvent it) {
          final Function1<RCEmployee,String> _function = new Function1<RCEmployee,String>() {
              public String apply(final RCEmployee it) {
                String _entityName = it.getEntityName();
                return _entityName;
              }
            };
          Iterable<String> _map = IterableExtensions.<RCEmployee, String>map(performers, _function);
          String _join = IterableExtensions.join(_map, ",");
          String _plus = ("\u5206\u914D\u7ED9" + _join);
          String _plus_1 = (_plus + "\u6267\u884C");
          it.setComment(_plus_1);
        }
      };
    ObjectExtensions.<DLPatientCheckDeliverTaskEvent>operator_doubleArrow(_createEvent, _function);
    Status=DLCenterlizedDeliverTaskStatus.dispatched;
  }
  
  public void dispatch(final Collection<RCEmployee> performers) {
    if(Status==DLCenterlizedDeliverTaskStatus.scheduled){
    	_dispatch(performers);
    	getModelObjectLogService().createLog(this,"Status","dispatch");
    	getBeanFactory().getBean(com.fudanmed.platform.core.deliver.events.DLCenterlizedDeliverTaskEventsManager.class).fireDispatch(this,performers);						
    }else{
    	throw new edu.fudan.langlab.domain.statemachine.InvalidStateException();
    }
  }
  
  private void _finish(final String comment) {
    
    DLPatientCheckDeliverTaskEvent _createEvent = this.createEvent(DLPatientCheckDeliverTaskEventType.finish);
    final Procedure1<DLPatientCheckDeliverTaskEvent> _function = new Procedure1<DLPatientCheckDeliverTaskEvent>() {
        public void apply(final DLPatientCheckDeliverTaskEvent it) {
          it.setComment(comment);
        }
      };
    ObjectExtensions.<DLPatientCheckDeliverTaskEvent>operator_doubleArrow(_createEvent, _function);
    Status=DLCenterlizedDeliverTaskStatus.finished;
  }
  
  public void finish(final String comment) {
    if(Status==DLCenterlizedDeliverTaskStatus.dispatched){
    	_finish(comment);
    	getModelObjectLogService().createLog(this,"Status","finish");
    	getBeanFactory().getBean(com.fudanmed.platform.core.deliver.events.DLCenterlizedDeliverTaskEventsManager.class).fireFinish(this,comment);						
    }else{
    	throw new edu.fudan.langlab.domain.statemachine.InvalidStateException();
    }
  }
  
  private void _cancelDispatch(final String comment) {
    
    this.removeAllPerformers();
    DLPatientCheckDeliverTaskEvent _createEvent = this.createEvent(DLPatientCheckDeliverTaskEventType.cancelDispatch);
    final Procedure1<DLPatientCheckDeliverTaskEvent> _function = new Procedure1<DLPatientCheckDeliverTaskEvent>() {
        public void apply(final DLPatientCheckDeliverTaskEvent it) {
          it.setComment(comment);
        }
      };
    ObjectExtensions.<DLPatientCheckDeliverTaskEvent>operator_doubleArrow(_createEvent, _function);
    Status=DLCenterlizedDeliverTaskStatus.scheduled;
  }
  
  public void cancelDispatch(final String comment) {
    if(Status==DLCenterlizedDeliverTaskStatus.dispatched){
    	_cancelDispatch(comment);
    	getModelObjectLogService().createLog(this,"Status","cancelDispatch");
    	getBeanFactory().getBean(com.fudanmed.platform.core.deliver.events.DLCenterlizedDeliverTaskEventsManager.class).fireCancelDispatch(this,comment);						
    }else{
    	throw new edu.fudan.langlab.domain.statemachine.InvalidStateException();
    }
  }
  
  private void _performUpdate(final Procedure1<? super DLCenterlizedDeliverTask> updater) {
    
    updater.apply(this);
    this.checkValid();
    this.createEvent(DLPatientCheckDeliverTaskEventType.performUpdate);
  }
  
  public void performUpdate(final Procedure1<? super DLCenterlizedDeliverTask> updater) {
    if(Status==DLCenterlizedDeliverTaskStatus.scheduled||Status==DLCenterlizedDeliverTaskStatus.dispatched){
    	_performUpdate(updater);
    	getModelObjectLogService().createLog(this,"Status","performUpdate");
    	getBeanFactory().getBean(com.fudanmed.platform.core.deliver.events.DLCenterlizedDeliverTaskEventsManager.class).firePerformUpdate(this,updater);						
    }else{
    	throw new edu.fudan.langlab.domain.statemachine.InvalidStateException();
    }
  }
  
  private void _cancel(final String comment) {
    
    DLPatientCheckDeliverTaskEvent _createEvent = this.createEvent(DLPatientCheckDeliverTaskEventType.cancel);
    final Procedure1<DLPatientCheckDeliverTaskEvent> _function = new Procedure1<DLPatientCheckDeliverTaskEvent>() {
        public void apply(final DLPatientCheckDeliverTaskEvent it) {
          it.setComment(comment);
        }
      };
    ObjectExtensions.<DLPatientCheckDeliverTaskEvent>operator_doubleArrow(_createEvent, _function);
    Status=DLCenterlizedDeliverTaskStatus.canceled;
  }
  
  public void cancel(final String comment) {
    if(Status==DLCenterlizedDeliverTaskStatus.scheduled||Status==DLCenterlizedDeliverTaskStatus.dispatched){
    	_cancel(comment);
    	getModelObjectLogService().createLog(this,"Status","cancel");
    	getBeanFactory().getBean(com.fudanmed.platform.core.deliver.events.DLCenterlizedDeliverTaskEventsManager.class).fireCancel(this,comment);						
    }else{
    	throw new edu.fudan.langlab.domain.statemachine.InvalidStateException();
    }
  }
  
  public Boolean isScheduled() {
    return com.fudanmed.platform.core.deliver.DLCenterlizedDeliverTaskStatus.scheduled==Status;
  }
  
  public Boolean isDispatched() {
    return com.fudanmed.platform.core.deliver.DLCenterlizedDeliverTaskStatus.dispatched==Status;
  }
  
  public Boolean isCanceled() {
    return com.fudanmed.platform.core.deliver.DLCenterlizedDeliverTaskStatus.canceled==Status;
  }
  
  public Boolean isFinished() {
    return com.fudanmed.platform.core.deliver.DLCenterlizedDeliverTaskStatus.finished==Status;
  }
  
  @ManyToMany(targetEntity = DLResourceImpl.class)
  @JoinTable(name = "m2m_dlcenterlizeddelivertask_resources", joinColumns = @JoinColumn(name = "dlcenterlizeddelivertask_id") , inverseJoinColumns = @JoinColumn(name = "dLResource_inv_id") )
  private Collection<DLResource> resources = new java.util.ArrayList<com.fudanmed.platform.core.deliver.DLResource>();;
  
  public Collection<DLResource> getResources() {
    return this.resources;
  }
  
  public DLCenterlizedDeliverTask setResources(final Iterable<DLResource> resources) {
    removeAllResources();
    for(DLResource ca : resources){
    	addtoResources(ca);
    }
    return this;		
    
  }
  
  public DLCenterlizedDeliverTask addtoResources(final DLResource dLResource) {
    this.resources.add(dLResource);
    return this;
    
  }
  
  public DLCenterlizedDeliverTask removeAllResources() {
    this.resources.clear();
    return this;	
    
  }
  
  public DLCenterlizedDeliverTask removeFromResources(final DLResource dLResource) {
    this.resources.remove(dLResource);
    return this;
    
  }
  
  @JoinColumn(name = "subject_id")
  @ManyToOne(targetEntity = DLDeliverSubjectImpl.class, cascade = { CascadeType.MERGE, CascadeType.PERSIST })
  private DLDeliverSubject subject;
  
  public DLDeliverSubject getSubject() {
    return this.subject;
  }
  
  public DLCenterlizedDeliverTask setSubject(final DLDeliverSubject subject) {
    this.subject = subject;
    return this;			
    
  }
  
  @Embedded
  @AttributeOverrides(value = { @AttributeOverride(name = "planDate", column = @Column(name = "planDateTime_planDate") ), @AttributeOverride(name = "planTime", column = @Column(name = "planDateTime_planTime") ), @AttributeOverride(name = "workaround", column = @Column(name = "planDateTime_workaround") ) } )
  @AssociationOverrides(value = { } )
  private DLPlanDateTime planDateTime = com.fudanmed.platform.core.deliver.DLPlanDateTime.create();
  
  public DLPlanDateTime getPlanDateTime() {
    return this.planDateTime;
  }
  
  public DLCenterlizedDeliverTask setPlanDateTime(final DLPlanDateTime planDateTime) {
    this.planDateTime = planDateTime;
    return this;			
    
  }
  
  public DLPatientCheckDeliverTaskEvent createEvent(final DLPatientCheckDeliverTaskEventType eventType) {DLPatientCheckDeliverTaskEvent dLPatientCheckDeliverTaskEvent=DLPatientCheckDeliverTaskEventImpl.create(this,getObjectFactory());
    final Procedure1<DLPatientCheckDeliverTaskEvent> _function = new Procedure1<DLPatientCheckDeliverTaskEvent>() {
        public void apply(final DLPatientCheckDeliverTaskEvent it) {
          it.setEventType(eventType);
          Date _now = DateUtil.now();
          it.setCreateTime(_now);
        }
      };
    DLPatientCheckDeliverTaskEvent _doubleArrow = ObjectExtensions.<DLPatientCheckDeliverTaskEvent>operator_doubleArrow(dLPatientCheckDeliverTaskEvent, _function);
    return _doubleArrow;
  }
  
  public static DLCenterlizedDeliverTask create(final IObjectFactory objectFactory) {
    com.fudanmed.platform.core.deliver.DLCenterlizedDeliverTask dLCenterlizedDeliverTask = new com.fudanmed.platform.core.deliver.impl.DLCenterlizedDeliverTaskImpl(
    );
    objectFactory.create(dLCenterlizedDeliverTask);
    return dLCenterlizedDeliverTask;			
    
  }
  
  public DLCenterlizedDeliverTaskProxy toProxy() {
    com.fudanmed.platform.core.deliver.proxy.DLCenterlizedDeliverTaskProxy proxy = new com.fudanmed.platform.core.deliver.proxy.DLCenterlizedDeliverTaskProxy();
    proxy.setId(this.getId());
    if(this instanceof edu.fudan.mylang.pf.INamedModelObject){
    	proxy.setName(((edu.fudan.mylang.pf.INamedModelObject)this).getEntityName());
    }
    return proxy;
    
  }
}
