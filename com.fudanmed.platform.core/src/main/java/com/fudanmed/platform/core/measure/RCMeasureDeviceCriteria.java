package com.fudanmed.platform.core.measure;

import com.fudanmed.platform.core.measure.RCMeasureDevice;
import com.fudanmed.platform.core.measure.RCMeasureDeviceType;
import com.fudanmed.platform.core.measure.impl.RCMeasureDeviceCriteriaImpl;
import edu.fudan.mylang.pf.query.IPagedCriteria;
import edu.fudan.mylang.pf.query.QueryImplementation;

@QueryImplementation(implementBy = RCMeasureDeviceCriteriaImpl.class)
public interface RCMeasureDeviceCriteria extends IPagedCriteria<RCMeasureDevice> {
  public abstract RCMeasureDeviceType getType();
  
  public abstract RCMeasureDeviceCriteria setType(final RCMeasureDeviceType type);
  
  public abstract String getSid();
  
  public abstract RCMeasureDeviceCriteria setSid(final String sid);
}
