package com.fudanmed.platform.core.measure.proxy;

import com.fudanmed.platform.core.measure.proxy.RCMeasureValueProxy;
import edu.fudan.mylang.pf.ProxyTarget;

@ProxyTarget("com.fudanmed.platform.core.measure.RCPhasedElectricMeasureValue")
public class RCPhasedElectricMeasureValueProxy extends RCMeasureValueProxy {
  public RCPhasedElectricMeasureValueProxy() {
    this.setClazzName("com.fudanmed.platform.core.measure.RCPhasedElectricMeasureValue");
  }
}
