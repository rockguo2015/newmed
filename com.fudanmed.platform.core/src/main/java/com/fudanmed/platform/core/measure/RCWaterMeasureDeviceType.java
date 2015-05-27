package com.fudanmed.platform.core.measure;

import com.fudanmed.platform.core.measure.RCMeasureDeviceType;
import com.fudanmed.platform.core.measure.RCWaterMeasureDevice;
import com.fudanmed.platform.core.measure.impl.RCWaterMeasureDeviceTypeImpl;
import com.fudanmed.platform.core.measure.proxy.RCWaterMeasureDeviceTypeProxy;
import edu.fudan.mylang.pf.EntityImplementation;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

@EntityImplementation(implementBy = RCWaterMeasureDeviceTypeImpl.class)
public interface RCWaterMeasureDeviceType extends RCMeasureDeviceType {
  public abstract RCWaterMeasureDevice createDevice(final Procedure1<? super RCWaterMeasureDevice> init);
  
  public abstract RCWaterMeasureDeviceTypeProxy toProxy();
}
