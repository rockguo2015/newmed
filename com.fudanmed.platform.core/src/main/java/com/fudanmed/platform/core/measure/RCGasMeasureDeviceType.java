package com.fudanmed.platform.core.measure;

import com.fudanmed.platform.core.measure.RCGasMeasureDevice;
import com.fudanmed.platform.core.measure.RCMeasureDeviceType;
import com.fudanmed.platform.core.measure.impl.RCGasMeasureDeviceTypeImpl;
import com.fudanmed.platform.core.measure.proxy.RCGasMeasureDeviceTypeProxy;
import edu.fudan.mylang.pf.EntityImplementation;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

@EntityImplementation(implementBy = RCGasMeasureDeviceTypeImpl.class)
public interface RCGasMeasureDeviceType extends RCMeasureDeviceType {
  public abstract RCGasMeasureDevice createDevice(final Procedure1<? super RCGasMeasureDevice> init);
  
  public abstract RCGasMeasureDeviceTypeProxy toProxy();
}
