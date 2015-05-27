package com.fudanmed.platform.core.measure;

import com.fudanmed.platform.core.measure.RCMeasureValue;
import com.fudanmed.platform.core.measure.impl.RCPhasedElectricMeasureValueImpl;
import com.fudanmed.platform.core.measure.proxy.RCPhasedElectricMeasureValueProxy;
import edu.fudan.mylang.pf.EntityImplementation;
import java.util.Collection;

@EntityImplementation(implementBy = RCPhasedElectricMeasureValueImpl.class)
public interface RCPhasedElectricMeasureValue extends RCMeasureValue {
  public abstract Double getHighValue();
  
  public abstract RCPhasedElectricMeasureValue setHighValue(final Double highValue);
  
  public abstract Double getAverageValue();
  
  public abstract RCPhasedElectricMeasureValue setAverageValue(final Double averageValue);
  
  public abstract Double getPeekValue();
  
  public abstract RCPhasedElectricMeasureValue setPeekValue(final Double peekValue);
  
  public abstract Double getLowValue();
  
  public abstract RCPhasedElectricMeasureValue setLowValue(final Double lowValue);
  
  public abstract Double getMaxRequiredValue();
  
  public abstract RCPhasedElectricMeasureValue setMaxRequiredValue(final Double maxRequiredValue);
  
  public abstract Double getNoPowerValue();
  
  public abstract RCPhasedElectricMeasureValue setNoPowerValue(final Double noPowerValue);
  
  public abstract String toValueString();
  
  /**
   * 有功电量
   */
  public abstract Double getTotalEfficentPower();
  
  /**
   * 耗电量
   */
  public abstract Double getConsumedPower();
  
  public abstract String toIncrementValueString();
  
  public abstract Collection<Double> serializeValues();
  
  public abstract void deserializeValues(final Collection<Double> values);
  
  public abstract RCPhasedElectricMeasureValueProxy toProxy();
}
