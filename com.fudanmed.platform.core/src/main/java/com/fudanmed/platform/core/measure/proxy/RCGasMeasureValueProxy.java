package com.fudanmed.platform.core.measure.proxy;

import com.fudanmed.platform.core.measure.proxy.RCMeasureValueProxy;
import edu.fudan.mylang.pf.ProxyTarget;

@ProxyTarget("com.fudanmed.platform.core.measure.RCGasMeasureValue")
public class RCGasMeasureValueProxy extends RCMeasureValueProxy {
  public RCGasMeasureValueProxy() {
    this.setClazzName("com.fudanmed.platform.core.measure.RCGasMeasureValue");
  }
}
