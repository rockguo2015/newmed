package com.fudanmed.platform.core.measure.proxy;

import com.fudanmed.platform.core.measure.proxy.RCMeasureDeviceProxy;
import edu.fudan.mylang.pf.ProxyTarget;

@ProxyTarget("com.fudanmed.platform.core.measure.RCGasMeasureDevice")
public class RCGasMeasureDeviceProxy extends RCMeasureDeviceProxy {
  public RCGasMeasureDeviceProxy() {
    this.setClazzName("com.fudanmed.platform.core.measure.RCGasMeasureDevice");
  }
}
