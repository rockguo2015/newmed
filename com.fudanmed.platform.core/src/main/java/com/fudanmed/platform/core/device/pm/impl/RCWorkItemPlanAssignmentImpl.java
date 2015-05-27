package com.fudanmed.platform.core.device.pm.impl;

import com.fudanmed.platform.core.device.pm.RCDevicePMPlan;
import com.fudanmed.platform.core.device.pm.RCPMWorkItem;
import com.fudanmed.platform.core.device.pm.RCPMWorkItemWorkerAssignment;
import com.fudanmed.platform.core.device.pm.RCWorkItemPlanAssignment;
import com.fudanmed.platform.core.device.pm.impl.RCDevicePMPlanImpl;
import com.fudanmed.platform.core.device.pm.impl.RCPMWorkItemImpl;
import com.fudanmed.platform.core.device.pm.impl.RCPMWorkItemWorkerAssignmentImpl;
import com.fudanmed.platform.core.device.pm.proxy.RCWorkItemPlanAssignmentProxy;
import edu.fudan.mylang.pf.BaseModelObject;
import edu.fudan.mylang.pf.IObjectFactory;
import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import org.hibernate.annotations.DiscriminatorOptions;

@Entity
@DiscriminatorValue("RCWORKITEMPLANASSIGNMENT_TYPE")
@DiscriminatorOptions(force = true)
@DiscriminatorColumn(length = 64)
@Table(name = "rcworkitemplanassignment")
public class RCWorkItemPlanAssignmentImpl extends BaseModelObject implements RCWorkItemPlanAssignment {
  public RCWorkItemPlanAssignmentImpl() {
    super();
  }
  
  public RCWorkItemPlanAssignmentImpl(final RCPMWorkItem workitem) {
    super();
    this.workitem = workitem;
  }
  
  @JoinColumn(name = "plan_id")
  @ManyToOne(targetEntity = RCDevicePMPlanImpl.class, cascade = { CascadeType.MERGE, CascadeType.PERSIST })
  private RCDevicePMPlan plan;
  
  public RCDevicePMPlan getPlan() {
    return this.plan;
  }
  
  public RCWorkItemPlanAssignment setPlan(final RCDevicePMPlan plan) {
    this.plan = plan;
    return this;			
    
  }
  
  @JoinColumn(name = "workitem_id")
  @ManyToOne(targetEntity = RCPMWorkItemImpl.class, cascade = { CascadeType.MERGE, CascadeType.PERSIST })
  private RCPMWorkItem workitem;
  
  public RCPMWorkItem getWorkitem() {
    return this.workitem;
  }
  
  public RCWorkItemPlanAssignment setWorkitem(final RCPMWorkItem workitem) {
    this.workitem = workitem;
    return this;			
    
  }
  
  @JoinColumn(name = "workerAssignment_id")
  @ManyToOne(targetEntity = RCPMWorkItemWorkerAssignmentImpl.class, cascade = { CascadeType.MERGE, CascadeType.PERSIST })
  private RCPMWorkItemWorkerAssignment workerAssignment;
  
  public RCPMWorkItemWorkerAssignment getWorkerAssignment() {
    return this.workerAssignment;
  }
  
  public RCWorkItemPlanAssignment setWorkerAssignment(final RCPMWorkItemWorkerAssignment workerAssignment) {
    this.workerAssignment = workerAssignment;
    return this;			
    
  }
  
  public static RCWorkItemPlanAssignment create(final RCPMWorkItem workitem, final IObjectFactory objectFactory) {
    com.fudanmed.platform.core.device.pm.RCWorkItemPlanAssignment rCWorkItemPlanAssignment = new com.fudanmed.platform.core.device.pm.impl.RCWorkItemPlanAssignmentImpl(
    	workitem
    );
    objectFactory.create(rCWorkItemPlanAssignment);
    return rCWorkItemPlanAssignment;			
    
  }
  
  public RCWorkItemPlanAssignmentProxy toProxy() {
    com.fudanmed.platform.core.device.pm.proxy.RCWorkItemPlanAssignmentProxy proxy = new com.fudanmed.platform.core.device.pm.proxy.RCWorkItemPlanAssignmentProxy();
    proxy.setId(this.getId());
    if(this instanceof edu.fudan.mylang.pf.INamedModelObject){
    	proxy.setName(((edu.fudan.mylang.pf.INamedModelObject)this).getEntityName());
    }
    return proxy;
    
  }
}
