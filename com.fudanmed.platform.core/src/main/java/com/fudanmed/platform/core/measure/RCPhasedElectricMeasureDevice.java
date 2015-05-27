package com.fudanmed.platform.core.measure;

import com.fudanmed.platform.core.measure.RCMeasureDevice;
import com.fudanmed.platform.core.measure.RCMeasureValue;
import com.fudanmed.platform.core.measure.impl.RCPhasedElectricMeasureDeviceImpl;
import com.fudanmed.platform.core.measure.proxy.RCPhasedElectricMeasureDeviceProxy;
import edu.fudan.mylang.pf.EntityImplementation;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

@EntityImplementation(implementBy = RCPhasedElectricMeasureDeviceImpl.class)
public interface RCPhasedElectricMeasureDevice extends RCMeasureDevice {
  public abstract Double getFactor();
  
  public abstract RCPhasedElectricMeasureDevice setFactor(final Double factor);
  
  public abstract RCMeasureValue doCreateValue();
  
  public abstract void update(final Procedure1<? super RCPhasedElectricMeasureDevice> updater);
  
  public abstract RCPhasedElectricMeasureDeviceProxy toProxy();
}
