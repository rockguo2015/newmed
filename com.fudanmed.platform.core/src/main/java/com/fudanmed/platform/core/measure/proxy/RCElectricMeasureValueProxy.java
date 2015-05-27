package com.fudanmed.platform.core.measure.proxy;

import com.fudanmed.platform.core.measure.proxy.RCMeasureValueProxy;
import edu.fudan.mylang.pf.ProxyTarget;

@ProxyTarget("com.fudanmed.platform.core.measure.RCElectricMeasureValue")
public class RCElectricMeasureValueProxy extends RCMeasureValueProxy {
  public RCElectricMeasureValueProxy() {
    this.setClazzName("com.fudanmed.platform.core.measure.RCElectricMeasureValue");
  }
}
