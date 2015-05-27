package com.fudanmed.platform.core.device;

import com.fudanmed.platform.core.device.RCDevice;
import com.fudanmed.platform.core.device.RCDeviceType;
import com.fudanmed.platform.core.device.impl.RCDeviceCriteriaImpl;
import com.fudanmed.platform.core.domain.RCOnsitePosition;
import edu.fudan.mylang.pf.query.IPagedCriteria;
import edu.fudan.mylang.pf.query.QueryImplementation;

@QueryImplementation(implementBy = RCDeviceCriteriaImpl.class)
public interface RCDeviceCriteria extends IPagedCriteria<RCDevice> {
  public abstract String getSid();
  
  public abstract RCDeviceCriteria setSid(final String sid);
  
  public abstract String getName();
  
  public abstract RCDeviceCriteria setName(final String name);
  
  public abstract RCDeviceType getDeviceType();
  
  public abstract RCDeviceCriteria setDeviceType(final RCDeviceType deviceType);
  
  public abstract String getCategory();
  
  public abstract RCDeviceCriteria setCategory(final String category);
  
  public abstract RCOnsitePosition getLocation();
  
  public abstract RCDeviceCriteria setLocation(final RCOnsitePosition location);
  
  public abstract String getLocationPathName();
  
  public abstract RCDeviceCriteria setLocationPathName(final String locationPathName);
  
  public abstract void postInitialize();
}
