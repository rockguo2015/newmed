package com.fudanmed.platform.core.measure.impl;

import com.fudanmed.platform.core.measure.RCMeasureDevice;
import com.fudanmed.platform.core.measure.RCMeasureValue;
import com.fudanmed.platform.core.measure.RCPhasedElectricMeasureDevice;
import com.fudanmed.platform.core.measure.RCPhasedElectricMeasureValue;
import com.fudanmed.platform.core.measure.impl.RCMeasureValueImpl;
import com.fudanmed.platform.core.measure.proxy.RCPhasedElectricMeasureValueProxy;
import com.google.common.base.Objects;
import edu.fudan.mylang.common.NumberExtensions;
import edu.fudan.mylang.pf.IObjectFactory;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.DoubleExtensions;

@Entity
@DiscriminatorValue("RCPHASEDELECTRICMEASUREVALUE_TYPE")
public class RCPhasedElectricMeasureValueImpl extends RCMeasureValueImpl implements RCPhasedElectricMeasureValue {
  public RCPhasedElectricMeasureValueImpl() {
    super();
  }
  
  private Double highValue;
  
  public Double getHighValue() {
    return this.highValue;
  }
  
  public RCPhasedElectricMeasureValue setHighValue(final Double highValue) {
    this.highValue = highValue;
    return this;			
    
  }
  
  private Double averageValue;
  
  public Double getAverageValue() {
    return this.averageValue;
  }
  
  public RCPhasedElectricMeasureValue setAverageValue(final Double averageValue) {
    this.averageValue = averageValue;
    return this;			
    
  }
  
  private Double peekValue;
  
  public Double getPeekValue() {
    return this.peekValue;
  }
  
  public RCPhasedElectricMeasureValue setPeekValue(final Double peekValue) {
    this.peekValue = peekValue;
    return this;			
    
  }
  
  private Double lowValue;
  
  public Double getLowValue() {
    return this.lowValue;
  }
  
  public RCPhasedElectricMeasureValue setLowValue(final Double lowValue) {
    this.lowValue = lowValue;
    return this;			
    
  }
  
  private Double maxRequiredValue;
  
  public Double getMaxRequiredValue() {
    return this.maxRequiredValue;
  }
  
  public RCPhasedElectricMeasureValue setMaxRequiredValue(final Double maxRequiredValue) {
    this.maxRequiredValue = maxRequiredValue;
    return this;			
    
  }
  
  private Double noPowerValue;
  
  public Double getNoPowerValue() {
    return this.noPowerValue;
  }
  
  public RCPhasedElectricMeasureValue setNoPowerValue(final Double noPowerValue) {
    this.noPowerValue = noPowerValue;
    return this;			
    
  }
  
  public String toValueString() {
    Double _totalEfficentPower = this.getTotalEfficentPower();
    String _string = _totalEfficentPower.toString();
    return _string;
  }
  
  /**
   * 有功电量
   */
  public Double getTotalEfficentPower() {
    Double _nullsafe = NumberExtensions.nullsafe(this.highValue);
    Double _nullsafe_1 = NumberExtensions.nullsafe(this.averageValue);
    double _plus = DoubleExtensions.operator_plus(_nullsafe, _nullsafe_1);
    Double _nullsafe_2 = NumberExtensions.nullsafe(this.peekValue);
    double _plus_1 = (_plus + (_nullsafe_2).doubleValue());
    Double _nullsafe_3 = NumberExtensions.nullsafe(this.lowValue);
    double _plus_2 = (_plus_1 + (_nullsafe_3).doubleValue());
    return Double.valueOf(_plus_2);
  }
  
  /**
   * 耗电量
   */
  public Double getConsumedPower() {
    double _xblockexpression = (double) 0;
    {
      Double _xifexpression = null;
      RCMeasureValue _lastValue = this.getLastValue();
      boolean _equals = Objects.equal(_lastValue, null);
      if (_equals) {
        Double _totalEfficentPower = this.getTotalEfficentPower();
        _xifexpression = _totalEfficentPower;
      } else {
        double _xblockexpression_1 = (double) 0;
        {
          RCMeasureValue _lastValue_1 = this.getLastValue();
          final RCPhasedElectricMeasureValue v = ((RCPhasedElectricMeasureValue) _lastValue_1);
          Double _totalEfficentPower_1 = this.getTotalEfficentPower();
          Double _totalEfficentPower_2 = v.getTotalEfficentPower();
          double _minus = DoubleExtensions.operator_minus(_totalEfficentPower_1, _totalEfficentPower_2);
          _xblockexpression_1 = (_minus);
        }
        _xifexpression = _xblockexpression_1;
      }
      final Double t = _xifexpression;
      RCMeasureDevice _device = this.getDevice();
      Double _factor = ((RCPhasedElectricMeasureDevice) _device).getFactor();
      double _multiply = DoubleExtensions.operator_multiply(t, _factor);
      _xblockexpression = (_multiply);
    }
    return Double.valueOf(_xblockexpression);
  }
  
  public String toIncrementValueString() {
    Double _consumedPower = this.getConsumedPower();
    String _string = _consumedPower.toString();
    return _string;
  }
  
  public Collection<Double> serializeValues() {
    ArrayList<Double> _newArrayList = CollectionLiterals.<Double>newArrayList(this.highValue, this.averageValue, this.peekValue, this.lowValue, this.maxRequiredValue, this.noPowerValue);
    return _newArrayList;
  }
  
  public void deserializeValues(final Collection<Double> values) {
    final Iterator<Double> i = values.iterator();
    Double _next = i.next();
    this.highValue = _next;
    Double _next_1 = i.next();
    this.averageValue = _next_1;
    Double _next_2 = i.next();
    this.peekValue = _next_2;
    Double _next_3 = i.next();
    this.lowValue = _next_3;
    Double _next_4 = i.next();
    this.maxRequiredValue = _next_4;
    Double _next_5 = i.next();
    this.noPowerValue = _next_5;
  }
  
  public static RCPhasedElectricMeasureValue create(final IObjectFactory objectFactory) {
    com.fudanmed.platform.core.measure.RCPhasedElectricMeasureValue rCPhasedElectricMeasureValue = new com.fudanmed.platform.core.measure.impl.RCPhasedElectricMeasureValueImpl(
    );
    objectFactory.create(rCPhasedElectricMeasureValue);
    return rCPhasedElectricMeasureValue;			
    
  }
  
  public RCPhasedElectricMeasureValueProxy toProxy() {
    com.fudanmed.platform.core.measure.proxy.RCPhasedElectricMeasureValueProxy proxy = new com.fudanmed.platform.core.measure.proxy.RCPhasedElectricMeasureValueProxy();
    proxy.setId(this.getId());
    if(this instanceof edu.fudan.mylang.pf.INamedModelObject){
    	proxy.setName(((edu.fudan.mylang.pf.INamedModelObject)this).getEntityName());
    }
    return proxy;
    
  }
}
