package com.fudanmed.platform.core.measure;

import com.fudanmed.platform.core.measure.RCMeasureDeviceType;
import com.fudanmed.platform.core.measure.RCPhasedElectricMeasureDevice;
import com.fudanmed.platform.core.measure.impl.RCPhasedElectricMeasureDeviceTypeImpl;
import com.fudanmed.platform.core.measure.proxy.RCPhasedElectricMeasureDeviceTypeProxy;
import edu.fudan.mylang.pf.EntityImplementation;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

@EntityImplementation(implementBy = RCPhasedElectricMeasureDeviceTypeImpl.class)
public interface RCPhasedElectricMeasureDeviceType extends RCMeasureDeviceType {
  public abstract RCPhasedElectricMeasureDevice createDevice(final Procedure1<? super RCPhasedElectricMeasureDevice> init);
  
  public abstract RCPhasedElectricMeasureDeviceTypeProxy toProxy();
}
