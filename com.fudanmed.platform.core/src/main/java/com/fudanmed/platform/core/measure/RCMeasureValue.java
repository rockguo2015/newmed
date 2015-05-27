package com.fudanmed.platform.core.measure;

import com.fudanmed.platform.core.measure.RCMeasureDevice;
import com.fudanmed.platform.core.measure.impl.RCMeasureValueImpl;
import com.fudanmed.platform.core.measure.proxy.RCMeasureValueProxy;
import edu.fudan.mylang.pf.EntityImplementation;
import edu.fudan.mylang.pf.IModelObject;
import java.util.Collection;
import java.util.Date;

@EntityImplementation(implementBy = RCMeasureValueImpl.class)
public interface RCMeasureValue extends IModelObject {
  public abstract RCMeasureDevice getDevice();
  
  public abstract RCMeasureValue setDevice(final RCMeasureDevice device);
  
  public abstract Date getMeasureDate();
  
  public abstract RCMeasureValue setMeasureDate(final Date measureDate);
  
  public abstract String getMeasurePerson();
  
  public abstract RCMeasureValue setMeasurePerson(final String measurePerson);
  
  public abstract RCMeasureValue getLastValue();
  
  public abstract RCMeasureValue setLastValue(final RCMeasureValue lastValue);
  
  public abstract String toValueString();
  
  public abstract Collection<Double> serializeValues();
  
  public abstract void deserializeValues(final Collection<Double> values);
  
  public abstract RCMeasureValueProxy toProxy();
}
