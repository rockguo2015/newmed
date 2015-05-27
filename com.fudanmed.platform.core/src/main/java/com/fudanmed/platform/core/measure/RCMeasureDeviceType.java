package com.fudanmed.platform.core.measure;

import com.fudanmed.platform.core.measure.RCMeasureDevice;
import com.fudanmed.platform.core.measure.impl.RCMeasureDeviceTypeImpl;
import com.fudanmed.platform.core.measure.proxy.RCMeasureDeviceTypeProxy;
import edu.fudan.mylang.pf.EntityImplementation;
import edu.fudan.mylang.pf.IModelObject;
import java.util.Collection;

@EntityImplementation(implementBy = RCMeasureDeviceTypeImpl.class)
public interface RCMeasureDeviceType extends IModelObject {
  public abstract String getName();
  
  public abstract RCMeasureDeviceType setName(final String name);
  
  public abstract String getSid();
  
  public abstract RCMeasureDeviceType setSid(final String sid);
  
  public abstract Collection<RCMeasureDevice> getMeasureDevices();
  
  public abstract RCMeasureDeviceTypeProxy toProxy();
}
