package com.fudanmed.platform.core.device.pm.impl;

import com.fudanmed.platform.core.device.pm.RCDevicePMPlan;
import com.fudanmed.platform.core.device.pm.RCDevicePMPlanSMStatus;
import com.fudanmed.platform.core.device.pm.RCDevicePMPlanStatus;
import com.fudanmed.platform.core.device.pm.RCDevicePMSpecification;
import com.fudanmed.platform.core.device.pm.impl.RCDevicePMSpecificationImpl;
import com.fudanmed.platform.core.device.pm.proxy.RCDevicePMPlanProxy;
import edu.fudan.langlab.domain.statemachine.ModelObjectLogService;
import edu.fudan.mylang.pf.BaseModelObject;
import edu.fudan.mylang.pf.IObjectFactory;
import edu.fudan.mylang.utils.DateUtil;
import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import org.hibernate.annotations.DiscriminatorOptions;

@Entity
@DiscriminatorValue("RCDEVICEPMPLAN_TYPE")
@DiscriminatorOptions(force = true)
@DiscriminatorColumn(length = 64)
@Table(name = "rcdevicepmplan")
public class RCDevicePMPlanImpl extends BaseModelObject implements RCDevicePMPlan {
  public RCDevicePMPlanImpl() {
    super();
  }
  
  public RCDevicePMPlanImpl(final RCDevicePMSpecification spec) {
    super();
    this.spec = spec;
  }
  
  private RCDevicePMPlanSMStatus SMStatus;
  
  public RCDevicePMPlanSMStatus getSMStatus() {
    return this.SMStatus;
  }
  
  private ModelObjectLogService getModelObjectLogService() {
    return getBeanFactory().getBean(ModelObjectLogService.class);
  }
  
  private void _start() {
    
    this.status = RCDevicePMPlanStatus.planed;
    SMStatus=RCDevicePMPlanSMStatus.planed;
  }
  
  public void start() {
    if(SMStatus==null){
    	_start();
    	getModelObjectLogService().createLog(this,"SMStatus","Initialize");
    }else{
    	throw new edu.fudan.langlab.domain.statemachine.InvalidStateException();
    }
  }
  
  private void _assign() {
    
    this.status = RCDevicePMPlanStatus.assigned;
    SMStatus=RCDevicePMPlanSMStatus.assigned;
  }
  
  public void assign() {
    if(SMStatus==RCDevicePMPlanSMStatus.planed){
    	_assign();
    	getModelObjectLogService().createLog(this,"SMStatus","assign");
    	getBeanFactory().getBean(com.fudanmed.platform.core.device.pm.events.RCDevicePMPlanEventsManager.class).fireAssign(this);						
    }else{
    	throw new edu.fudan.langlab.domain.statemachine.InvalidStateException();
    }
  }
  
  private void _assignWorker() {
    
    this.status = RCDevicePMPlanStatus.workerAssigned;
    SMStatus=RCDevicePMPlanSMStatus.workerAssigned;
  }
  
  public void assignWorker() {
    if(SMStatus==RCDevicePMPlanSMStatus.assigned){
    	_assignWorker();
    	getModelObjectLogService().createLog(this,"SMStatus","assignWorker");
    	getBeanFactory().getBean(com.fudanmed.platform.core.device.pm.events.RCDevicePMPlanEventsManager.class).fireAssignWorker(this);						
    }else{
    	throw new edu.fudan.langlab.domain.statemachine.InvalidStateException();
    }
  }
  
  private void _cancelAssign() {
    
    this.status = RCDevicePMPlanStatus.planed;
    SMStatus=RCDevicePMPlanSMStatus.planed;
  }
  
  public void cancelAssign() {
    if(SMStatus==RCDevicePMPlanSMStatus.assigned){
    	_cancelAssign();
    	getModelObjectLogService().createLog(this,"SMStatus","cancelAssign");
    	getBeanFactory().getBean(com.fudanmed.platform.core.device.pm.events.RCDevicePMPlanEventsManager.class).fireCancelAssign(this);						
    }else{
    	throw new edu.fudan.langlab.domain.statemachine.InvalidStateException();
    }
  }
  
  private void _finish(final String comment) {
    
    this.status = RCDevicePMPlanStatus.finished;
    Date _day = DateUtil.today();
    this.finishDate = _day;
    this.comment = comment;
    SMStatus=RCDevicePMPlanSMStatus.finished;
  }
  
  public void finish(final String comment) {
    if(SMStatus==RCDevicePMPlanSMStatus.workerAssigned){
    	_finish(comment);
    	getModelObjectLogService().createLog(this,"SMStatus","finish");
    	getBeanFactory().getBean(com.fudanmed.platform.core.device.pm.events.RCDevicePMPlanEventsManager.class).fireFinish(this,comment);						
    }else{
    	throw new edu.fudan.langlab.domain.statemachine.InvalidStateException();
    }
  }
  
  private void _reportInfo(final String comment) {
    
    this.comment = comment;
  }
  
  public void reportInfo(final String comment) {
    if(SMStatus==RCDevicePMPlanSMStatus.workerAssigned){
    	_reportInfo(comment);
    	getModelObjectLogService().createLog(this,"SMStatus","reportInfo");
    	getBeanFactory().getBean(com.fudanmed.platform.core.device.pm.events.RCDevicePMPlanEventsManager.class).fireReportInfo(this,comment);						
    }else{
    	throw new edu.fudan.langlab.domain.statemachine.InvalidStateException();
    }
  }
  
  public Boolean isPlaned() {
    return com.fudanmed.platform.core.device.pm.RCDevicePMPlanSMStatus.planed==SMStatus;
  }
  
  public Boolean isAssigned() {
    return com.fudanmed.platform.core.device.pm.RCDevicePMPlanSMStatus.assigned==SMStatus;
  }
  
  public Boolean isFinished() {
    return com.fudanmed.platform.core.device.pm.RCDevicePMPlanSMStatus.finished==SMStatus;
  }
  
  public Boolean isWorkerAssigned() {
    return com.fudanmed.platform.core.device.pm.RCDevicePMPlanSMStatus.workerAssigned==SMStatus;
  }
  
  @JoinColumn(name = "spec_id")
  @ManyToOne(targetEntity = RCDevicePMSpecificationImpl.class, cascade = { CascadeType.MERGE, CascadeType.PERSIST })
  private RCDevicePMSpecification spec;
  
  public RCDevicePMSpecification getSpec() {
    return this.spec;
  }
  
  public RCDevicePMPlan setSpec(final RCDevicePMSpecification spec) {
    this.spec = spec;
    return this;			
    
  }
  
  private Date planDate;
  
  public Date getPlanDate() {
    return this.planDate;
  }
  
  public RCDevicePMPlan setPlanDate(final Date planDate) {
    this.planDate = planDate;
    return this;			
    
  }
  
  private Date finishDate;
  
  public Date getFinishDate() {
    return this.finishDate;
  }
  
  public RCDevicePMPlan setFinishDate(final Date finishDate) {
    this.finishDate = finishDate;
    return this;			
    
  }
  
  private String comment;
  
  public String getComment() {
    return this.comment;
  }
  
  public RCDevicePMPlan setComment(final String comment) {
    this.comment = comment;
    return this;			
    
  }
  
  private RCDevicePMPlanStatus status;
  
  public RCDevicePMPlanStatus getStatus() {
    return this.status;
  }
  
  public RCDevicePMPlan setStatus(final RCDevicePMPlanStatus status) {
    this.status = status;
    return this;			
    
  }
  
  public Boolean hasAssignedWorker() {
    boolean _or = false;
    Boolean _isWorkerAssigned = this.isWorkerAssigned();
    if ((_isWorkerAssigned).booleanValue()) {
      _or = true;
    } else {
      Boolean _isFinished = this.isFinished();
      _or = ((_isWorkerAssigned).booleanValue() || (_isFinished).booleanValue());
    }
    return Boolean.valueOf(_or);
  }
  
  public static RCDevicePMPlan create(final RCDevicePMSpecification spec, final IObjectFactory objectFactory) {
    com.fudanmed.platform.core.device.pm.RCDevicePMPlan rCDevicePMPlan = new com.fudanmed.platform.core.device.pm.impl.RCDevicePMPlanImpl(
    	spec
    );
    objectFactory.create(rCDevicePMPlan);
    return rCDevicePMPlan;			
    
  }
  
  public RCDevicePMPlanProxy toProxy() {
    com.fudanmed.platform.core.device.pm.proxy.RCDevicePMPlanProxy proxy = new com.fudanmed.platform.core.device.pm.proxy.RCDevicePMPlanProxy();
    proxy.setId(this.getId());
    if(this instanceof edu.fudan.mylang.pf.INamedModelObject){
    	proxy.setName(((edu.fudan.mylang.pf.INamedModelObject)this).getEntityName());
    }
    return proxy;
    
  }
}
