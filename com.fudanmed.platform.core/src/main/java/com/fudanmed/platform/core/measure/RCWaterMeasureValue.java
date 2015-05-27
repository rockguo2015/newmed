package com.fudanmed.platform.core.measure;

import com.fudanmed.platform.core.measure.RCMeasureValue;
import com.fudanmed.platform.core.measure.impl.RCWaterMeasureValueImpl;
import com.fudanmed.platform.core.measure.proxy.RCWaterMeasureValueProxy;
import edu.fudan.mylang.pf.EntityImplementation;
import java.util.Collection;

@EntityImplementation(implementBy = RCWaterMeasureValueImpl.class)
public interface RCWaterMeasureValue extends RCMeasureValue {
  public abstract Double getValue();
  
  public abstract RCWaterMeasureValue setValue(final Double value);
  
  public abstract String toValueString();
  
  public abstract Double getIncrementalValue();
  
  public abstract Collection<Double> serializeValues();
  
  public abstract void deserializeValues(final Collection<Double> values);
  
  public abstract RCWaterMeasureValueProxy toProxy();
}
