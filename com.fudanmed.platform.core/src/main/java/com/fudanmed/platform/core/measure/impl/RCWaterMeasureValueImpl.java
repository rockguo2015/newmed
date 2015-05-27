package com.fudanmed.platform.core.measure.impl;

import com.fudanmed.platform.core.measure.RCMeasureValue;
import com.fudanmed.platform.core.measure.RCWaterMeasureValue;
import com.fudanmed.platform.core.measure.impl.RCMeasureValueImpl;
import com.fudanmed.platform.core.measure.proxy.RCWaterMeasureValueProxy;
import com.google.common.base.Objects;
import edu.fudan.mylang.pf.IObjectFactory;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.DoubleExtensions;

@Entity
@DiscriminatorValue("RCWATERMEASUREVALUE_TYPE")
public class RCWaterMeasureValueImpl extends RCMeasureValueImpl implements RCWaterMeasureValue {
  public RCWaterMeasureValueImpl() {
    super();
  }
  
  private Double value;
  
  public Double getValue() {
    return this.value;
  }
  
  public RCWaterMeasureValue setValue(final Double value) {
    this.value = value;
    return this;			
    
  }
  
  public String toValueString() {
    String _string = this.value.toString();
    return _string;
  }
  
  public Double getIncrementalValue() {
    Double _xifexpression = null;
    RCMeasureValue _lastValue = this.getLastValue();
    boolean _equals = Objects.equal(_lastValue, null);
    if (_equals) {
      _xifexpression = this.value;
    } else {
      RCMeasureValue _lastValue_1 = this.getLastValue();
      Double _value = ((RCWaterMeasureValue) _lastValue_1).getValue();
      double _minus = DoubleExtensions.operator_minus(this.value, _value);
      _xifexpression = _minus;
    }
    return _xifexpression;
  }
  
  public Collection<Double> serializeValues() {
    ArrayList<Double> _newArrayList = CollectionLiterals.<Double>newArrayList(this.value);
    return _newArrayList;
  }
  
  public void deserializeValues(final Collection<Double> values) {
    Iterator<Double> _iterator = values.iterator();
    Double _next = _iterator.next();
    this.value = _next;
  }
  
  public static RCWaterMeasureValue create(final IObjectFactory objectFactory) {
    com.fudanmed.platform.core.measure.RCWaterMeasureValue rCWaterMeasureValue = new com.fudanmed.platform.core.measure.impl.RCWaterMeasureValueImpl(
    );
    objectFactory.create(rCWaterMeasureValue);
    return rCWaterMeasureValue;			
    
  }
  
  public RCWaterMeasureValueProxy toProxy() {
    com.fudanmed.platform.core.measure.proxy.RCWaterMeasureValueProxy proxy = new com.fudanmed.platform.core.measure.proxy.RCWaterMeasureValueProxy();
    proxy.setId(this.getId());
    if(this instanceof edu.fudan.mylang.pf.INamedModelObject){
    	proxy.setName(((edu.fudan.mylang.pf.INamedModelObject)this).getEntityName());
    }
    return proxy;
    
  }
}
