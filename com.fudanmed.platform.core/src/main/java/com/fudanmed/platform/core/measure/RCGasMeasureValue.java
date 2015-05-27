package com.fudanmed.platform.core.measure;

import com.fudanmed.platform.core.measure.RCMeasureValue;
import com.fudanmed.platform.core.measure.impl.RCGasMeasureValueImpl;
import com.fudanmed.platform.core.measure.proxy.RCGasMeasureValueProxy;
import edu.fudan.mylang.pf.EntityImplementation;
import java.util.Collection;

@EntityImplementation(implementBy = RCGasMeasureValueImpl.class)
public interface RCGasMeasureValue extends RCMeasureValue {
  public abstract Double getValue();
  
  public abstract RCGasMeasureValue setValue(final Double value);
  
  public abstract String toValueString();
  
  public abstract Double getIncrementalValue();
  
  public abstract Collection<Double> serializeValues();
  
  public abstract void deserializeValues(final Collection<Double> values);
  
  public abstract RCGasMeasureValueProxy toProxy();
}
