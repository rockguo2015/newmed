package com.fudanmed.platform.core.measure;

import com.fudanmed.platform.core.measure.RCMeasureDevice;
import com.fudanmed.platform.core.measure.RCMeasureValue;
import com.fudanmed.platform.core.measure.impl.RCElectricMeasureDeviceImpl;
import com.fudanmed.platform.core.measure.proxy.RCElectricMeasureDeviceProxy;
import edu.fudan.mylang.pf.EntityImplementation;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

@EntityImplementation(implementBy = RCElectricMeasureDeviceImpl.class)
public interface RCElectricMeasureDevice extends RCMeasureDevice {
  public abstract RCMeasureValue doCreateValue();
  
  public abstract void update(final Procedure1<? super RCElectricMeasureDevice> updater);
  
  public abstract void delete();
  
  public abstract RCElectricMeasureDeviceProxy toProxy();
}
