package com.fudanmed.platform.core.entityextension;

import com.fudanmed.platform.core.entityextension.RCExtensiableEntity;
import com.fudanmed.platform.core.entityextension.RCPrimaryType;
import com.fudanmed.platform.core.entityextension.RCPrimaryValue;
import com.fudanmed.platform.core.entityextension.impl.RCCustomizableTypeImpl;
import com.fudanmed.platform.core.entityextension.proxy.RCCustomizableTypeProxy;
import edu.fudan.mylang.pf.EntityImplementation;

@EntityImplementation(implementBy = RCCustomizableTypeImpl.class)
public interface RCCustomizableType extends RCPrimaryType {
  public abstract String getTypeName();
  
  public abstract String getAlias();
  
  public abstract RCPrimaryValue createInstance(final RCExtensiableEntity owner);
  
  public abstract RCCustomizableTypeProxy toProxy();
}
