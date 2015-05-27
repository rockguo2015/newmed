package com.fudanmed.platform.core.entityextension;

import com.fudanmed.platform.core.entityextension.RCExtensiableEntity;
import com.fudanmed.platform.core.entityextension.RCPrimaryValue;
import com.fudanmed.platform.core.entityextension.impl.RCRangeValueImpl;
import com.fudanmed.platform.core.entityextension.proxy.RCRangeValueProxy;
import edu.fudan.mylang.pf.EntityImplementation;

@EntityImplementation(implementBy = RCRangeValueImpl.class)
public interface RCRangeValue extends RCPrimaryValue {
  public abstract Double getLowerBound();
  
  public abstract RCRangeValue setLowerBound(final Double lowerBound);
  
  public abstract Double getUpperBound();
  
  public abstract RCRangeValue setUpperBound(final Double upperBound);
  
  public abstract String getEntityName();
  
  public abstract void setValue(final Double lowerBound, final Double upperBound);
  
  public abstract RCRangeValue cloneIn(final RCExtensiableEntity rootOwner);
  
  public abstract RCRangeValueProxy toProxy();
}
