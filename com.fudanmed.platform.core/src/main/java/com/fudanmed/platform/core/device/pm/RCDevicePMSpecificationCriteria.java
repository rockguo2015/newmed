package com.fudanmed.platform.core.device.pm;

import com.fudanmed.platform.core.device.pm.RCDevicePMSpecification;
import com.fudanmed.platform.core.device.pm.RCDevicePMType;
import com.fudanmed.platform.core.device.pm.impl.RCDevicePMSpecificationCriteriaImpl;
import edu.fudan.mylang.pf.query.IPagedCriteria;
import edu.fudan.mylang.pf.query.QueryImplementation;
import java.util.Date;

@QueryImplementation(implementBy = RCDevicePMSpecificationCriteriaImpl.class)
public interface RCDevicePMSpecificationCriteria extends IPagedCriteria<RCDevicePMSpecification> {
  public abstract String getSid();
  
  public abstract RCDevicePMSpecificationCriteria setSid(final String sid);
  
  public abstract RCDevicePMType getPmType();
  
  public abstract RCDevicePMSpecificationCriteria setPmType(final RCDevicePMType pmType);
  
  public abstract Date getLastPMPlanDateFrom();
  
  public abstract RCDevicePMSpecificationCriteria setLastPMPlanDateFrom(final Date lastPMPlanDateFrom);
  
  public abstract Date getLastPMPlanDateTo();
  
  public abstract RCDevicePMSpecificationCriteria setLastPMPlanDateTo(final Date lastPMPlanDateTo);
}
