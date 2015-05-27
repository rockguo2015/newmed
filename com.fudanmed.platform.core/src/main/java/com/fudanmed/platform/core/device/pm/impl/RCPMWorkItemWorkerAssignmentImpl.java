package com.fudanmed.platform.core.device.pm.impl;

import com.fudanmed.platform.core.device.pm.RCDevicePMPlan;
import com.fudanmed.platform.core.device.pm.RCPMWorkItem;
import com.fudanmed.platform.core.device.pm.RCPMWorkItemWorkerAssignment;
import com.fudanmed.platform.core.device.pm.RCPMWorkItemWorkerAssignmentSMState;
import com.fudanmed.platform.core.device.pm.RCPMWorkItemWorkerAssignmentStatus;
import com.fudanmed.platform.core.device.pm.RCWorkItemPlanAssignment;
import com.fudanmed.platform.core.device.pm.impl.RCPMWorkItemImpl;
import com.fudanmed.platform.core.device.pm.proxy.RCPMWorkItemWorkerAssignmentProxy;
import com.fudanmed.platform.core.domain.RCEmployee;
import com.fudanmed.platform.core.domain.impl.RCEmployeeImpl;
import edu.fudan.langlab.domain.statemachine.ModelObjectLogService;
import edu.fudan.mylang.pf.BaseModelObject;
import edu.fudan.mylang.pf.IGenericQuery;
import edu.fudan.mylang.pf.IObjectFactory;
import java.util.Collection;
import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.hibernate.annotations.DiscriminatorOptions;

@Entity
@DiscriminatorValue("RCPMWORKITEMWORKERASSIGNMENT_TYPE")
@DiscriminatorOptions(force = true)
@DiscriminatorColumn(length = 64)
@Table(name = "rcpmworkitemworkerassignment")
public class RCPMWorkItemWorkerAssignmentImpl extends BaseModelObject implements RCPMWorkItemWorkerAssignment {
  public RCPMWorkItemWorkerAssignmentImpl() {
    super();
  }
  
  public RCPMWorkItemWorkerAssignmentImpl(final RCPMWorkItem workitem) {
    super();
    this.workitem = workitem;
  }
  
  private RCPMWorkItemWorkerAssignmentSMState SMState;
  
  public RCPMWorkItemWorkerAssignmentSMState getSMState() {
    return this.SMState;
  }
  
  private ModelObjectLogService getModelObjectLogService() {
    return getBeanFactory().getBean(ModelObjectLogService.class);
  }
  
  private void _start() {
    
    this.status = RCPMWorkItemWorkerAssignmentStatus.planed;
    SMState=RCPMWorkItemWorkerAssignmentSMState.planed;
  }
  
  public void start() {
    if(SMState==null){
    	_start();
    	getModelObjectLogService().createLog(this,"SMState","Initialize");
    }else{
    	throw new edu.fudan.langlab.domain.statemachine.InvalidStateException();
    }
  }
  
  private void _pend() {
    
    this.status = RCPMWorkItemWorkerAssignmentStatus.pending;
    SMState=RCPMWorkItemWorkerAssignmentSMState.pending;
  }
  
  public void pend() {
    if(SMState==RCPMWorkItemWorkerAssignmentSMState.planed){
    	_pend();
    	getModelObjectLogService().createLog(this,"SMState","pend");
    	getBeanFactory().getBean(com.fudanmed.platform.core.device.pm.events.RCPMWorkItemWorkerAssignmentEventsManager.class).firePend(this);						
    }else{
    	throw new edu.fudan.langlab.domain.statemachine.InvalidStateException();
    }
  }
  
  private void _finish() {
    
    this.status = RCPMWorkItemWorkerAssignmentStatus.finished;
    SMState=RCPMWorkItemWorkerAssignmentSMState.finished;
    this.workitem.$workerAssignmentFinish();
  }
  
  public void finish() {
    if(SMState==RCPMWorkItemWorkerAssignmentSMState.planed||SMState==RCPMWorkItemWorkerAssignmentSMState.pending){
    	_finish();
    	getModelObjectLogService().createLog(this,"SMState","finish");
    	getBeanFactory().getBean(com.fudanmed.platform.core.device.pm.events.RCPMWorkItemWorkerAssignmentEventsManager.class).fireFinish(this);						
    }else{
    	throw new edu.fudan.langlab.domain.statemachine.InvalidStateException();
    }
  }
  
  public Boolean isPlaned() {
    return com.fudanmed.platform.core.device.pm.RCPMWorkItemWorkerAssignmentSMState.planed==SMState;
  }
  
  public Boolean isPending() {
    return com.fudanmed.platform.core.device.pm.RCPMWorkItemWorkerAssignmentSMState.pending==SMState;
  }
  
  public Boolean isFinished() {
    return com.fudanmed.platform.core.device.pm.RCPMWorkItemWorkerAssignmentSMState.finished==SMState;
  }
  
  @JoinColumn(name = "workitem_id")
  @ManyToOne(targetEntity = RCPMWorkItemImpl.class, cascade = { CascadeType.MERGE, CascadeType.PERSIST })
  private RCPMWorkItem workitem;
  
  public RCPMWorkItem getWorkitem() {
    return this.workitem;
  }
  
  public RCPMWorkItemWorkerAssignment setWorkitem(final RCPMWorkItem workitem) {
    this.workitem = workitem;
    return this;			
    
  }
  
  @ManyToMany(targetEntity = RCEmployeeImpl.class)
  @JoinTable(name = "m2m_rcpmworkitemworkerassignment_workers", joinColumns = @JoinColumn(name = "rcpmworkitemworkerassignment_id") , inverseJoinColumns = @JoinColumn(name = "rCEmployee_inv_id") )
  private Collection<RCEmployee> workers = new java.util.ArrayList<com.fudanmed.platform.core.domain.RCEmployee>();;
  
  public Collection<RCEmployee> getWorkers() {
    return this.workers;
  }
  
  public RCPMWorkItemWorkerAssignment setWorkers(final Iterable<RCEmployee> workers) {
    removeAllWorkers();
    for(RCEmployee ca : workers){
    	addtoWorkers(ca);
    }
    return this;		
    
  }
  
  public RCPMWorkItemWorkerAssignment addtoWorkers(final RCEmployee rCEmployee) {
    this.workers.add(rCEmployee);
    return this;
    
  }
  
  public RCPMWorkItemWorkerAssignment removeAllWorkers() {
    this.workers.clear();
    return this;	
    
  }
  
  public RCPMWorkItemWorkerAssignment removeFromWorkers(final RCEmployee rCEmployee) {
    this.workers.remove(rCEmployee);
    return this;
    
  }
  
  private Date assignDate;
  
  public Date getAssignDate() {
    return this.assignDate;
  }
  
  public RCPMWorkItemWorkerAssignment setAssignDate(final Date assignDate) {
    this.assignDate = assignDate;
    return this;			
    
  }
  
  private Date finishDate;
  
  public Date getFinishDate() {
    return this.finishDate;
  }
  
  public RCPMWorkItemWorkerAssignment setFinishDate(final Date finishDate) {
    this.finishDate = finishDate;
    return this;			
    
  }
  
  private String comment;
  
  public String getComment() {
    return this.comment;
  }
  
  public RCPMWorkItemWorkerAssignment setComment(final String comment) {
    this.comment = comment;
    return this;			
    
  }
  
  private String finalComment;
  
  public String getFinalComment() {
    return this.finalComment;
  }
  
  public RCPMWorkItemWorkerAssignment setFinalComment(final String finalComment) {
    this.finalComment = finalComment;
    return this;			
    
  }
  
  private RCPMWorkItemWorkerAssignmentStatus status;
  
  public RCPMWorkItemWorkerAssignmentStatus getStatus() {
    return this.status;
  }
  
  public RCPMWorkItemWorkerAssignment setStatus(final RCPMWorkItemWorkerAssignmentStatus status) {
    this.status = status;
    return this;			
    
  }
  
  public Collection<RCWorkItemPlanAssignment> getWorkItemPlanAssignments() {
    IGenericQuery<RCWorkItemPlanAssignment> query=getObjectFactory().createGenericQuery(RCWorkItemPlanAssignment.class,"select e from com.fudanmed.platform.core.device.pm.impl.RCWorkItemPlanAssignmentImpl as e   where (e.workerAssignment = :this) and  e.active = 1      ").setParameter("this",this);
    Collection<RCWorkItemPlanAssignment> _list = query.list();
    return _list;
  }
  
  public Boolean getAllTaskFinished() {
    Collection<RCWorkItemPlanAssignment> _workItemPlanAssignments = this.getWorkItemPlanAssignments();
    final Function1<RCWorkItemPlanAssignment,Boolean> _function = new Function1<RCWorkItemPlanAssignment,Boolean>() {
        public Boolean apply(final RCWorkItemPlanAssignment it) {
          RCDevicePMPlan _plan = it.getPlan();
          Boolean _isFinished = _plan.isFinished();
          return _isFinished;
        }
      };
    boolean _forall = IterableExtensions.<RCWorkItemPlanAssignment>forall(_workItemPlanAssignments, _function);
    return Boolean.valueOf(_forall);
  }
  
  public static RCPMWorkItemWorkerAssignment create(final RCPMWorkItem workitem, final IObjectFactory objectFactory) {
    com.fudanmed.platform.core.device.pm.RCPMWorkItemWorkerAssignment rCPMWorkItemWorkerAssignment = new com.fudanmed.platform.core.device.pm.impl.RCPMWorkItemWorkerAssignmentImpl(
    	workitem
    );
    objectFactory.create(rCPMWorkItemWorkerAssignment);
    return rCPMWorkItemWorkerAssignment;			
    
  }
  
  public RCPMWorkItemWorkerAssignmentProxy toProxy() {
    com.fudanmed.platform.core.device.pm.proxy.RCPMWorkItemWorkerAssignmentProxy proxy = new com.fudanmed.platform.core.device.pm.proxy.RCPMWorkItemWorkerAssignmentProxy();
    proxy.setId(this.getId());
    if(this instanceof edu.fudan.mylang.pf.INamedModelObject){
    	proxy.setName(((edu.fudan.mylang.pf.INamedModelObject)this).getEntityName());
    }
    return proxy;
    
  }
}
