package com.fudanmed.platform.core.device;

import com.fudanmed.platform.core.device.RCDeviceType;
import com.fudanmed.platform.core.device.impl.RCDeviceTypeCriteriaImpl;
import edu.fudan.mylang.pf.query.IPagedCriteria;
import edu.fudan.mylang.pf.query.QueryImplementation;

@QueryImplementation(implementBy = RCDeviceTypeCriteriaImpl.class)
public interface RCDeviceTypeCriteria extends IPagedCriteria<RCDeviceType> {
  public abstract String getName();
  
  public abstract RCDeviceTypeCriteria setName(final String name);
  
  public abstract String getCategory();
  
  public abstract RCDeviceTypeCriteria setCategory(final String category);
}
