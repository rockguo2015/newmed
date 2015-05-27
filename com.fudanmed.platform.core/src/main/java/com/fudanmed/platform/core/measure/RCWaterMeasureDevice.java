package com.fudanmed.platform.core.measure;

import com.fudanmed.platform.core.measure.RCMeasureDevice;
import com.fudanmed.platform.core.measure.RCWaterMeasureValue;
import com.fudanmed.platform.core.measure.impl.RCWaterMeasureDeviceImpl;
import com.fudanmed.platform.core.measure.proxy.RCWaterMeasureDeviceProxy;
import edu.fudan.mylang.pf.EntityImplementation;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

@EntityImplementation(implementBy = RCWaterMeasureDeviceImpl.class)
public interface RCWaterMeasureDevice extends RCMeasureDevice {
  public abstract RCWaterMeasureValue doCreateValue();
  
  public abstract void update(final Procedure1<? super RCWaterMeasureDevice> updater);
  
  public abstract RCWaterMeasureDeviceProxy toProxy();
}
