package com.fudanmed.platform.core.device;

import com.fudanmed.platform.core.device.RCDevice;
import com.fudanmed.platform.core.device.impl.RCDeviceLookupCriteriaImpl;
import edu.fudan.mylang.pf.query.IPagedCriteria;
import edu.fudan.mylang.pf.query.QueryImplementation;

@QueryImplementation(implementBy = RCDeviceLookupCriteriaImpl.class)
public interface RCDeviceLookupCriteria extends IPagedCriteria<RCDevice> {
  public abstract String getInfo();
  
  public abstract RCDeviceLookupCriteria setInfo(final String info);
}
