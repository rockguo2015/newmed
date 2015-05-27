package com.fudanmed.platform.core.entityextension;

import com.fudanmed.platform.core.entityextension.RCExtensiableEntity;
import com.fudanmed.platform.core.entityextension.RCPrimaryValue;
import com.fudanmed.platform.core.entityextension.impl.RCNumberValueImpl;
import com.fudanmed.platform.core.entityextension.proxy.RCNumberValueProxy;
import edu.fudan.mylang.pf.EntityImplementation;

@EntityImplementation(implementBy = RCNumberValueImpl.class)
public interface RCNumberValue extends RCPrimaryValue {
  public abstract Double getValue();
  
  public abstract RCNumberValue setValue(final Double value);
  
  public abstract String getEntityName();
  
  public abstract RCNumberValue cloneIn(final RCExtensiableEntity rootOwner);
  
  public abstract RCNumberValueProxy toProxy();
}
