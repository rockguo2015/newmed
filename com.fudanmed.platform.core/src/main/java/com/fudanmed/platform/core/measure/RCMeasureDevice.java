package com.fudanmed.platform.core.measure;

import com.fudanmed.platform.core.measure.RCMeasureDeviceType;
import com.fudanmed.platform.core.measure.RCMeasureValue;
import com.fudanmed.platform.core.measure.impl.RCMeasureDeviceImpl;
import com.fudanmed.platform.core.measure.proxy.RCMeasureDeviceProxy;
import edu.fudan.mylang.pf.EntityImplementation;
import edu.fudan.mylang.pf.IModelObject;
import java.util.Date;

@EntityImplementation(implementBy = RCMeasureDeviceImpl.class)
public interface RCMeasureDevice extends IModelObject {
  public abstract RCMeasureDeviceType getDeviceType();
  
  public abstract RCMeasureDevice setDeviceType(final RCMeasureDeviceType deviceType);
  
  public abstract String getSid();
  
  public abstract RCMeasureDevice setSid(final String sid);
  
  public abstract String getName();
  
  public abstract RCMeasureDevice setName(final String name);
  
  public abstract String getLocation();
  
  public abstract RCMeasureDevice setLocation(final String location);
  
  public abstract RCMeasureValue getLastValue();
  
  public abstract RCMeasureDevice setLastValue(final RCMeasureValue lastValue);
  
  public abstract RCMeasureValue createValue(final Date measureDate, final String measurePerson);
  
  public abstract RCMeasureValue doCreateValue();
  
  public abstract void checkValid();
  
  public abstract RCMeasureDeviceProxy toProxy();
}
