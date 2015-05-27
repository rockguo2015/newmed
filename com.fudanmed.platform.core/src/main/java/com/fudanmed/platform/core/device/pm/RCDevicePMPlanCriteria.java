package com.fudanmed.platform.core.device.pm;

import com.fudanmed.platform.core.device.RCDeviceType;
import com.fudanmed.platform.core.device.pm.RCDevicePMPlan;
import com.fudanmed.platform.core.device.pm.RCDevicePMPlanStatus;
import com.fudanmed.platform.core.device.pm.RCDevicePMType;
import com.fudanmed.platform.core.device.pm.impl.RCDevicePMPlanCriteriaImpl;
import com.fudanmed.platform.core.domain.RCOnsitePosition;
import edu.fudan.mylang.pf.query.IPagedCriteria;
import edu.fudan.mylang.pf.query.QueryImplementation;
import java.util.Date;

@QueryImplementation(implementBy = RCDevicePMPlanCriteriaImpl.class)
public interface RCDevicePMPlanCriteria extends IPagedCriteria<RCDevicePMPlan> {
  public abstract Date getPlanDateFrom();
  
  public abstract RCDevicePMPlanCriteria setPlanDateFrom(final Date planDateFrom);
  
  public abstract Date getPlanDateTo();
  
  public abstract RCDevicePMPlanCriteria setPlanDateTo(final Date planDateTo);
  
  public abstract RCDeviceType getDeviceType();
  
  public abstract RCDevicePMPlanCriteria setDeviceType(final RCDeviceType deviceType);
  
  public abstract String getCategory();
  
  public abstract RCDevicePMPlanCriteria setCategory(final String category);
  
  public abstract RCDevicePMType getPmType();
  
  public abstract RCDevicePMPlanCriteria setPmType(final RCDevicePMType pmType);
  
  public abstract RCDevicePMPlanStatus getStatus();
  
  public abstract RCDevicePMPlanCriteria setStatus(final RCDevicePMPlanStatus status);
  
  public abstract RCOnsitePosition getLocation();
  
  public abstract RCDevicePMPlanCriteria setLocation(final RCOnsitePosition location);
  
  public abstract String getLocationPathId();
  
  public abstract RCDevicePMPlanCriteria setLocationPathId(final String locationPathId);
  
  public abstract void postInitialize();
}
