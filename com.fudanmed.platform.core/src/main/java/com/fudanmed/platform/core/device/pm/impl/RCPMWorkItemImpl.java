package com.fudanmed.platform.core.device.pm.impl;

import com.fudanmed.platform.core.common.RCSequenceService;
import com.fudanmed.platform.core.device.pm.RCDevicePMPlan;
import com.fudanmed.platform.core.device.pm.RCDevicePMPlanStatus;
import com.fudanmed.platform.core.device.pm.RCPMWorkItem;
import com.fudanmed.platform.core.device.pm.RCPMWorkItemEvaluate;
import com.fudanmed.platform.core.device.pm.RCPMWorkItemSMState;
import com.fudanmed.platform.core.device.pm.RCPMWorkItemStatue;
import com.fudanmed.platform.core.device.pm.RCPMWorkItemWorkerAssignment;
import com.fudanmed.platform.core.device.pm.RCWorkItemPlanAssignment;
import com.fudanmed.platform.core.device.pm.impl.RCPMWorkItemWorkerAssignmentImpl;
import com.fudanmed.platform.core.device.pm.impl.RCWorkItemPlanAssignmentImpl;
import com.fudanmed.platform.core.device.pm.proxy.RCPMWorkItemProxy;
import com.fudanmed.platform.core.domain.RCMaintenanceTeam;
import com.fudanmed.platform.core.domain.RCSupplier;
import com.fudanmed.platform.core.domain.impl.RCMaintenanceTeamImpl;
import com.fudanmed.platform.core.domain.impl.RCSupplierImpl;
import com.google.common.base.Objects;
import edu.fudan.langlab.domain.statemachine.ModelObjectLogService;
import edu.fudan.mylang.pf.BaseModelObject;
import edu.fudan.mylang.pf.IObjectFactory;
import edu.fudan.mylang.utils.DateUtil;
import java.util.Collection;
import java.util.Date;
import javax.persistence.AssociationOverrides;
import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.hibernate.annotations.DiscriminatorOptions;
import org.springframework.beans.factory.BeanFactory;

@Entity
@DiscriminatorValue("RCPMWORKITEM_TYPE")
@DiscriminatorOptions(force = true)
@DiscriminatorColumn(length = 64)
@Table(name = "rcpmworkitem")
public class RCPMWorkItemImpl extends BaseModelObject implements RCPMWorkItem {
  public RCPMWorkItemImpl() {
    super();
  }
  
  private RCPMWorkItemSMState SMState;
  
  public RCPMWorkItemSMState getSMState() {
    return this.SMState;
  }
  
  private ModelObjectLogService getModelObjectLogService() {
    return getBeanFactory().getBean(ModelObjectLogService.class);
  }
  
  private void _start() {
    
    this.status = RCPMWorkItemStatue.planed;
    Date _now = DateUtil.now();
    this.dispatchDate = _now;
    BeanFactory _beanFactory = this.getBeanFactory();
    RCSequenceService _bean = _beanFactory.<RCSequenceService>getBean(RCSequenceService.class);
    String _nextPMWorkItemSequence = _bean.getNextPMWorkItemSequence();
    this.sid = _nextPMWorkItemSequence;
    SMState=RCPMWorkItemSMState.planed;
  }
  
  public void start() {
    if(SMState==null){
    	_start();
    	getModelObjectLogService().createLog(this,"SMState","Initialize");
    }else{
    	throw new edu.fudan.langlab.domain.statemachine.InvalidStateException();
    }
  }
  
  private void _assignPlan(final RCDevicePMPlan plan) {
    
    RCWorkItemPlanAssignment _createAndAddtoAssignments = this.createAndAddtoAssignments();
    final Procedure1<RCWorkItemPlanAssignment> _function = new Procedure1<RCWorkItemPlanAssignment>() {
        public void apply(final RCWorkItemPlanAssignment it) {
          it.setPlan(plan);
          plan.assign();
        }
      };
    ObjectExtensions.<RCWorkItemPlanAssignment>operator_doubleArrow(_createAndAddtoAssignments, _function);
  }
  
  public void assignPlan(final RCDevicePMPlan plan) {
    if(SMState==RCPMWorkItemSMState.planed){
    	_assignPlan(plan);
    	getModelObjectLogService().createLog(this,"SMState","assignPlan");
    	getBeanFactory().getBean(com.fudanmed.platform.core.device.pm.events.RCPMWorkItemEventsManager.class).fireAssignPlan(this,plan);						
    }else{
    	throw new edu.fudan.langlab.domain.statemachine.InvalidStateException();
    }
  }
  
  private void _deassignPlan(final RCDevicePMPlan plan) {
    
    final Function1<RCWorkItemPlanAssignment,Boolean> _function = new Function1<RCWorkItemPlanAssignment,Boolean>() {
        public Boolean apply(final RCWorkItemPlanAssignment it) {
          RCDevicePMPlan _plan = it.getPlan();
          boolean _equals = Objects.equal(_plan, plan);
          return Boolean.valueOf(_equals);
        }
      };
    RCWorkItemPlanAssignment _findFirst = IterableExtensions.<RCWorkItemPlanAssignment>findFirst(this.assignments, _function);
    this.removeFromAssignments(_findFirst);
    plan.cancelAssign();
  }
  
  public void deassignPlan(final RCDevicePMPlan plan) {
    if(SMState==RCPMWorkItemSMState.planed){
    	_deassignPlan(plan);
    	getModelObjectLogService().createLog(this,"SMState","deassignPlan");
    	getBeanFactory().getBean(com.fudanmed.platform.core.device.pm.events.RCPMWorkItemEventsManager.class).fireDeassignPlan(this,plan);						
    }else{
    	throw new edu.fudan.langlab.domain.statemachine.InvalidStateException();
    }
  }
  
  private void _assignTeam() {
    
    this.status = RCPMWorkItemStatue.teamAssigned;
    SMState=RCPMWorkItemSMState.teamAssigned;
  }
  
  public void assignTeam() {
    if(SMState==RCPMWorkItemSMState.planed){
    	_assignTeam();
    	getModelObjectLogService().createLog(this,"SMState","assignTeam");
    	getBeanFactory().getBean(com.fudanmed.platform.core.device.pm.events.RCPMWorkItemEventsManager.class).fireAssignTeam(this);						
    }else{
    	throw new edu.fudan.langlab.domain.statemachine.InvalidStateException();
    }
  }
  
  private void _workersAssigned() {
    
    Boolean _allTaskAssigned = this.allTaskAssigned();
    if ((_allTaskAssigned).booleanValue()) {
      SMState=RCPMWorkItemSMState.executing;
      this.status = RCPMWorkItemStatue.executing;
    } else {
      SMState=RCPMWorkItemSMState.partialExecuting;
      this.status = RCPMWorkItemStatue.partialExecuting;
    }
  }
  
  public void workersAssigned() {
    if(SMState==RCPMWorkItemSMState.teamAssigned||SMState==RCPMWorkItemSMState.partialExecuting){
    	_workersAssigned();
    	getModelObjectLogService().createLog(this,"SMState","workersAssigned");
    	getBeanFactory().getBean(com.fudanmed.platform.core.device.pm.events.RCPMWorkItemEventsManager.class).fireWorkersAssigned(this);						
    }else{
    	throw new edu.fudan.langlab.domain.statemachine.InvalidStateException();
    }
  }
  
  private void _$workerAssignmentFinish() {
    
    boolean _and = false;
    Boolean _allTaskAssigned = this.allTaskAssigned();
    if (!(_allTaskAssigned).booleanValue()) {
      _and = false;
    } else {
      Boolean _allWorkerTaskFinished = this.allWorkerTaskFinished();
      _and = ((_allTaskAssigned).booleanValue() && (_allWorkerTaskFinished).booleanValue());
    }
    if (_and) {
      this.status = RCPMWorkItemStatue.ready4TeamFinishReport;
      SMState=RCPMWorkItemSMState.ready4TeamFinishReport;
    } else {
    }
  }
  
  public void $workerAssignmentFinish() {
    if(SMState==RCPMWorkItemSMState.partialExecuting||SMState==RCPMWorkItemSMState.executing){
    	_$workerAssignmentFinish();
    	getModelObjectLogService().createLog(this,"SMState","$workerAssignmentFinish");
    	getBeanFactory().getBean(com.fudanmed.platform.core.device.pm.events.RCPMWorkItemEventsManager.class).fire$workerAssignmentFinish(this);						
    }else{
    	throw new edu.fudan.langlab.domain.statemachine.InvalidStateException();
    }
  }
  
  private void _teamFinish(final Date finishDate, final String comment) {
    
    this.status = RCPMWorkItemStatue.teamFinished;
    this.teamComment = comment;
    this.finishDate = finishDate;
    SMState=RCPMWorkItemSMState.teamFinished;
  }
  
  public void teamFinish(final Date finishDate, final String comment) {
    if(SMState==RCPMWorkItemSMState.ready4TeamFinishReport){
    	_teamFinish(finishDate,comment);
    	getModelObjectLogService().createLog(this,"SMState","teamFinish");
    	getBeanFactory().getBean(com.fudanmed.platform.core.device.pm.events.RCPMWorkItemEventsManager.class).fireTeamFinish(this,finishDate,comment);						
    }else{
    	throw new edu.fudan.langlab.domain.statemachine.InvalidStateException();
    }
  }
  
  private void _finish() {
    
    this.status = RCPMWorkItemStatue.finished;
    final Function1<RCWorkItemPlanAssignment,Boolean> _function = new Function1<RCWorkItemPlanAssignment,Boolean>() {
        public Boolean apply(final RCWorkItemPlanAssignment it) {
          RCDevicePMPlan _plan = it.getPlan();
          RCDevicePMPlanStatus _status = _plan.getStatus();
          boolean _notEquals = (!Objects.equal(_status, RCDevicePMPlanStatus.finished));
          return Boolean.valueOf(_notEquals);
        }
      };
    Iterable<RCWorkItemPlanAssignment> _filter = IterableExtensions.<RCWorkItemPlanAssignment>filter(this.assignments, _function);
    final Procedure1<RCWorkItemPlanAssignment> _function_1 = new Procedure1<RCWorkItemPlanAssignment>() {
        public void apply(final RCWorkItemPlanAssignment it) {
          RCDevicePMPlan _plan = it.getPlan();
          _plan.finish("");
        }
      };
    IterableExtensions.<RCWorkItemPlanAssignment>forEach(_filter, _function_1);
    SMState=RCPMWorkItemSMState.finished;
  }
  
  public void finish() {
    if(SMState==RCPMWorkItemSMState.teamFinished){
    	_finish();
    	getModelObjectLogService().createLog(this,"SMState","finish");
    	getBeanFactory().getBean(com.fudanmed.platform.core.device.pm.events.RCPMWorkItemEventsManager.class).fireFinish(this);						
    }else{
    	throw new edu.fudan.langlab.domain.statemachine.InvalidStateException();
    }
  }
  
  public Boolean isPlaned() {
    return com.fudanmed.platform.core.device.pm.RCPMWorkItemSMState.planed==SMState;
  }
  
  public Boolean isTeamAssigned() {
    return com.fudanmed.platform.core.device.pm.RCPMWorkItemSMState.teamAssigned==SMState;
  }
  
  public Boolean isExecuting() {
    return com.fudanmed.platform.core.device.pm.RCPMWorkItemSMState.executing==SMState;
  }
  
  public Boolean isTeamFinished() {
    return com.fudanmed.platform.core.device.pm.RCPMWorkItemSMState.teamFinished==SMState;
  }
  
  public Boolean isFinished() {
    return com.fudanmed.platform.core.device.pm.RCPMWorkItemSMState.finished==SMState;
  }
  
  public Boolean isPartialExecuting() {
    return com.fudanmed.platform.core.device.pm.RCPMWorkItemSMState.partialExecuting==SMState;
  }
  
  public Boolean isReady4TeamFinishReport() {
    return com.fudanmed.platform.core.device.pm.RCPMWorkItemSMState.ready4TeamFinishReport==SMState;
  }
  
  private String title;
  
  public String getTitle() {
    return this.title;
  }
  
  public RCPMWorkItem setTitle(final String title) {
    this.title = title;
    return this;			
    
  }
  
  private String description;
  
  public String getDescription() {
    return this.description;
  }
  
  public RCPMWorkItem setDescription(final String description) {
    this.description = description;
    return this;			
    
  }
  
  private String sid;
  
  public String getSid() {
    return this.sid;
  }
  
  public RCPMWorkItem setSid(final String sid) {
    this.sid = sid;
    return this;			
    
  }
  
  private Date assignDate;
  
  public Date getAssignDate() {
    return this.assignDate;
  }
  
  public RCPMWorkItem setAssignDate(final Date assignDate) {
    this.assignDate = assignDate;
    return this;			
    
  }
  
  @JoinColumn(name = "supplier_id")
  @ManyToOne(targetEntity = RCSupplierImpl.class, cascade = { CascadeType.MERGE, CascadeType.PERSIST })
  private RCSupplier supplier;
  
  public RCSupplier getSupplier() {
    return this.supplier;
  }
  
  public RCPMWorkItem setSupplier(final RCSupplier supplier) {
    this.supplier = supplier;
    return this;			
    
  }
  
  @OneToMany(targetEntity = RCWorkItemPlanAssignmentImpl.class, cascade = { CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REMOVE }, mappedBy = "workitem")
  private Collection<RCWorkItemPlanAssignment> assignments = new java.util.ArrayList<com.fudanmed.platform.core.device.pm.RCWorkItemPlanAssignment>();;
  
  public Collection<RCWorkItemPlanAssignment> getAssignments() {
    return this.assignments;
  }
  
  public RCWorkItemPlanAssignment createAndAddtoAssignments() {
    getAssignments().size();
    com.fudanmed.platform.core.device.pm.RCWorkItemPlanAssignment rCWorkItemPlanAssignment = new com.fudanmed.platform.core.device.pm.impl.RCWorkItemPlanAssignmentImpl(this);
    getObjectFactory().create(rCWorkItemPlanAssignment);
    getAssignments().add(rCWorkItemPlanAssignment);
    return rCWorkItemPlanAssignment;
    
  }
  
  public RCPMWorkItem removeAllAssignments() {
    for(RCWorkItemPlanAssignment obj : this.assignments){
    	getObjectFactory().delete(obj);
    }
    this.assignments.clear();
    return this;	
    
  }
  
  public RCPMWorkItem removeFromAssignments(final RCWorkItemPlanAssignment rCWorkItemPlanAssignment) {
    this.assignments.remove(rCWorkItemPlanAssignment);
    getObjectFactory().delete(rCWorkItemPlanAssignment);
    return this;
    
  }
  
  @OneToMany(targetEntity = RCPMWorkItemWorkerAssignmentImpl.class, cascade = { CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REMOVE }, mappedBy = "workitem")
  private Collection<RCPMWorkItemWorkerAssignment> workerAssignment = new java.util.ArrayList<com.fudanmed.platform.core.device.pm.RCPMWorkItemWorkerAssignment>();;
  
  public Collection<RCPMWorkItemWorkerAssignment> getWorkerAssignment() {
    return this.workerAssignment;
  }
  
  public RCPMWorkItemWorkerAssignment createAndAddtoWorkerAssignment() {
    getWorkerAssignment().size();
    com.fudanmed.platform.core.device.pm.RCPMWorkItemWorkerAssignment rCPMWorkItemWorkerAssignment = new com.fudanmed.platform.core.device.pm.impl.RCPMWorkItemWorkerAssignmentImpl(this);
    getObjectFactory().create(rCPMWorkItemWorkerAssignment);
    getWorkerAssignment().add(rCPMWorkItemWorkerAssignment);
    return rCPMWorkItemWorkerAssignment;
    
  }
  
  public RCPMWorkItem removeAllWorkerAssignment() {
    for(RCPMWorkItemWorkerAssignment obj : this.workerAssignment){
    	getObjectFactory().delete(obj);
    }
    this.workerAssignment.clear();
    return this;	
    
  }
  
  public RCPMWorkItem removeFromWorkerAssignment(final RCPMWorkItemWorkerAssignment rCPMWorkItemWorkerAssignment) {
    this.workerAssignment.remove(rCPMWorkItemWorkerAssignment);
    getObjectFactory().delete(rCPMWorkItemWorkerAssignment);
    return this;
    
  }
  
  private RCPMWorkItemStatue status;
  
  public RCPMWorkItemStatue getStatus() {
    return this.status;
  }
  
  public RCPMWorkItem setStatus(final RCPMWorkItemStatue status) {
    this.status = status;
    return this;			
    
  }
  
  @JoinColumn(name = "team_id")
  @ManyToOne(targetEntity = RCMaintenanceTeamImpl.class, cascade = { CascadeType.MERGE, CascadeType.PERSIST })
  private RCMaintenanceTeam team;
  
  public RCMaintenanceTeam getTeam() {
    return this.team;
  }
  
  public RCPMWorkItem setTeam(final RCMaintenanceTeam team) {
    this.team = team;
    return this;			
    
  }
  
  private String teamComment;
  
  public String getTeamComment() {
    return this.teamComment;
  }
  
  public RCPMWorkItem setTeamComment(final String teamComment) {
    this.teamComment = teamComment;
    return this;			
    
  }
  
  private Date finishDate;
  
  public Date getFinishDate() {
    return this.finishDate;
  }
  
  public RCPMWorkItem setFinishDate(final Date finishDate) {
    this.finishDate = finishDate;
    return this;			
    
  }
  
  private Date dispatchDate;
  
  public Date getDispatchDate() {
    return this.dispatchDate;
  }
  
  public RCPMWorkItem setDispatchDate(final Date dispatchDate) {
    this.dispatchDate = dispatchDate;
    return this;			
    
  }
  
  @Embedded
  @AttributeOverrides(value = { @AttributeOverride(name = "worker", column = @Column(name = "evaluate_worker") ), @AttributeOverride(name = "notifyDate", column = @Column(name = "evaluate_notifyDate") ), @AttributeOverride(name = "arriveDate", column = @Column(name = "evaluate_arriveDate") ), @AttributeOverride(name = "price", column = @Column(name = "evaluate_price") ), @AttributeOverride(name = "materials", column = @Column(name = "evaluate_materials") ), @AttributeOverride(name = "arrivalOnTime", column = @Column(name = "evaluate_arrivalOnTime") ), @AttributeOverride(name = "attitude", column = @Column(name = "evaluate_attitude") ), @AttributeOverride(name = "frequency", column = @Column(name = "evaluate_frequency") ), @AttributeOverride(name = "quality", column = @Column(name = "evaluate_quality") ), @AttributeOverride(name = "problemsRemains", column = @Column(name = "evaluate_problemsRemains") ), @AttributeOverride(name = "comment", column = @Column(name = "evaluate_comment") ), @AttributeOverride(name = "workaround", column = @Column(name = "evaluate_workaround") ) } )
  @AssociationOverrides(value = { } )
  private RCPMWorkItemEvaluate evaluate = com.fudanmed.platform.core.device.pm.RCPMWorkItemEvaluate.create();
  
  public RCPMWorkItemEvaluate getEvaluate() {
    return this.evaluate;
  }
  
  public RCPMWorkItem setEvaluate(final RCPMWorkItemEvaluate evaluate) {
    this.evaluate = evaluate;
    return this;			
    
  }
  
  public Boolean allTaskAssigned() {
    final Function1<RCWorkItemPlanAssignment,Boolean> _function = new Function1<RCWorkItemPlanAssignment,Boolean>() {
        public Boolean apply(final RCWorkItemPlanAssignment it) {
          RCDevicePMPlan _plan = it.getPlan();
          Boolean _hasAssignedWorker = _plan.hasAssignedWorker();
          return _hasAssignedWorker;
        }
      };
    boolean _forall = IterableExtensions.<RCWorkItemPlanAssignment>forall(this.assignments, _function);
    return Boolean.valueOf(_forall);
  }
  
  public Boolean allWorkerTaskFinished() {
    final Function1<RCPMWorkItemWorkerAssignment,Boolean> _function = new Function1<RCPMWorkItemWorkerAssignment,Boolean>() {
        public Boolean apply(final RCPMWorkItemWorkerAssignment it) {
          Boolean _isFinished = it.isFinished();
          return _isFinished;
        }
      };
    boolean _forall = IterableExtensions.<RCPMWorkItemWorkerAssignment>forall(this.workerAssignment, _function);
    return Boolean.valueOf(_forall);
  }
  
  public void assignWorker(final Collection<RCWorkItemPlanAssignment> workItemPlanAssignments, final Procedure1<? super RCPMWorkItemWorkerAssignment> postInit) {
    RCPMWorkItemWorkerAssignment _createAndAddtoWorkerAssignment = this.createAndAddtoWorkerAssignment();
    final Procedure1<RCPMWorkItemWorkerAssignment> _function = new Procedure1<RCPMWorkItemWorkerAssignment>() {
        public void apply(final RCPMWorkItemWorkerAssignment workerAssign) {
          postInit.apply(workerAssign);
          workerAssign.start();
          final Procedure1<RCWorkItemPlanAssignment> _function = new Procedure1<RCWorkItemPlanAssignment>() {
              public void apply(final RCWorkItemPlanAssignment it) {
                it.setWorkerAssignment(workerAssign);
                RCDevicePMPlan _plan = it.getPlan();
                _plan.assignWorker();
              }
            };
          IterableExtensions.<RCWorkItemPlanAssignment>forEach(workItemPlanAssignments, _function);
          RCPMWorkItemImpl.this.workersAssigned();
        }
      };
    ObjectExtensions.<RCPMWorkItemWorkerAssignment>operator_doubleArrow(_createAndAddtoWorkerAssignment, _function);
  }
  
  public static RCPMWorkItem create(final IObjectFactory objectFactory) {
    com.fudanmed.platform.core.device.pm.RCPMWorkItem rCPMWorkItem = new com.fudanmed.platform.core.device.pm.impl.RCPMWorkItemImpl(
    );
    objectFactory.create(rCPMWorkItem);
    return rCPMWorkItem;			
    
  }
  
  public RCPMWorkItemProxy toProxy() {
    com.fudanmed.platform.core.device.pm.proxy.RCPMWorkItemProxy proxy = new com.fudanmed.platform.core.device.pm.proxy.RCPMWorkItemProxy();
    proxy.setId(this.getId());
    if(this instanceof edu.fudan.mylang.pf.INamedModelObject){
    	proxy.setName(((edu.fudan.mylang.pf.INamedModelObject)this).getEntityName());
    }
    return proxy;
    
  }
}
