package com.fudanmed.platform.core.measure;

import com.fudanmed.platform.core.measure.RCMeasureDevice;
import com.fudanmed.platform.core.measure.RCMeasureValue;
import com.fudanmed.platform.core.measure.impl.RCGasMeasureDeviceImpl;
import com.fudanmed.platform.core.measure.proxy.RCGasMeasureDeviceProxy;
import edu.fudan.mylang.pf.EntityImplementation;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

@EntityImplementation(implementBy = RCGasMeasureDeviceImpl.class)
public interface RCGasMeasureDevice extends RCMeasureDevice {
  public abstract RCMeasureValue doCreateValue();
  
  public abstract void update(final Procedure1<? super RCGasMeasureDevice> updater);
  
  public abstract RCGasMeasureDeviceProxy toProxy();
}
