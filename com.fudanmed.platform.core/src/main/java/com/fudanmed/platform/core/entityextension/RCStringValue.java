package com.fudanmed.platform.core.entityextension;

import com.fudanmed.platform.core.entityextension.RCExtensiableEntity;
import com.fudanmed.platform.core.entityextension.RCPrimaryValue;
import com.fudanmed.platform.core.entityextension.impl.RCStringValueImpl;
import com.fudanmed.platform.core.entityextension.proxy.RCStringValueProxy;
import edu.fudan.mylang.pf.EntityImplementation;

@EntityImplementation(implementBy = RCStringValueImpl.class)
public interface RCStringValue extends RCPrimaryValue {
  public abstract String getStringValue();
  
  public abstract RCStringValue setStringValue(final String stringValue);
  
  public abstract String getEntityName();
  
  public abstract String getValue();
  
  public abstract void setValue(final String v);
  
  public abstract RCStringValue cloneIn(final RCExtensiableEntity rootOwner);
  
  public abstract RCStringValueProxy toProxy();
}
