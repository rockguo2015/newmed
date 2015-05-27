package com.fudanmed.platform.core.measure;

import com.fudanmed.platform.core.measure.RCMeasureValue;
import com.fudanmed.platform.core.measure.impl.RCElectricMeasureValueImpl;
import com.fudanmed.platform.core.measure.proxy.RCElectricMeasureValueProxy;
import edu.fudan.mylang.pf.EntityImplementation;
import java.util.Collection;

@EntityImplementation(implementBy = RCElectricMeasureValueImpl.class)
public interface RCElectricMeasureValue extends RCMeasureValue {
  public abstract Double getValue();
  
  public abstract RCElectricMeasureValue setValue(final Double value);
  
  public abstract String toValueString();
  
  public abstract Double getIncrementalValue();
  
  public abstract Collection<Double> serializeValues();
  
  public abstract void deserializeValues(final Collection<Double> values);
  
  public abstract RCElectricMeasureValueProxy toProxy();
}
