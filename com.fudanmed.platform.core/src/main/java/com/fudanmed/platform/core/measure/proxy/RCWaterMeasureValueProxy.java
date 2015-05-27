package com.fudanmed.platform.core.measure.proxy;

import com.fudanmed.platform.core.measure.proxy.RCMeasureValueProxy;
import edu.fudan.mylang.pf.ProxyTarget;

@ProxyTarget("com.fudanmed.platform.core.measure.RCWaterMeasureValue")
public class RCWaterMeasureValueProxy extends RCMeasureValueProxy {
  public RCWaterMeasureValueProxy() {
    this.setClazzName("com.fudanmed.platform.core.measure.RCWaterMeasureValue");
  }
}
