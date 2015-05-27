package com.fudanmed.platform.core.entityextension;

import com.fudanmed.platform.core.entityextension.RCExtensiableEntity;
import com.fudanmed.platform.core.entityextension.RCPrimaryValue;
import com.fudanmed.platform.core.entityextension.impl.RCNumberWithUnitValueImpl;
import com.fudanmed.platform.core.entityextension.proxy.RCNumberWithUnitValueProxy;
import edu.fudan.mylang.pf.EntityImplementation;

@EntityImplementation(implementBy = RCNumberWithUnitValueImpl.class)
public interface RCNumberWithUnitValue extends RCPrimaryValue {
  public abstract Double getValue();
  
  public abstract RCNumberWithUnitValue setValue(final Double value);
  
  public abstract String getEntityName();
  
  public abstract RCNumberWithUnitValue cloneIn(final RCExtensiableEntity rootOwner);
  
  public abstract RCNumberWithUnitValueProxy toProxy();
}
