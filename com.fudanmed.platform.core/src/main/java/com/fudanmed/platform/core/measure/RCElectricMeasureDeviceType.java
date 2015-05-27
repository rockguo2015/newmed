package com.fudanmed.platform.core.measure;

import com.fudanmed.platform.core.measure.RCElectricMeasureDevice;
import com.fudanmed.platform.core.measure.RCMeasureDeviceType;
import com.fudanmed.platform.core.measure.impl.RCElectricMeasureDeviceTypeImpl;
import com.fudanmed.platform.core.measure.proxy.RCElectricMeasureDeviceTypeProxy;
import edu.fudan.mylang.pf.EntityImplementation;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

@EntityImplementation(implementBy = RCElectricMeasureDeviceTypeImpl.class)
public interface RCElectricMeasureDeviceType extends RCMeasureDeviceType {
  public abstract RCElectricMeasureDevice createDevice(final Procedure1<? super RCElectricMeasureDevice> init);
  
  public abstract RCElectricMeasureDeviceTypeProxy toProxy();
}
