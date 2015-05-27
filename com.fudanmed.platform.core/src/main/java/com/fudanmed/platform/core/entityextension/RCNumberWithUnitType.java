package com.fudanmed.platform.core.entityextension;

import com.fudanmed.platform.core.entityextension.RCCustomizableType;
import com.fudanmed.platform.core.entityextension.RCExtensiableEntity;
import com.fudanmed.platform.core.entityextension.RCNumberWithUnitValue;
import com.fudanmed.platform.core.entityextension.impl.RCNumberWithUnitTypeImpl;
import com.fudanmed.platform.core.entityextension.proxy.RCNumberWithUnitTypeProxy;
import edu.fudan.mylang.pf.EntityImplementation;

@EntityImplementation(implementBy = RCNumberWithUnitTypeImpl.class)
public interface RCNumberWithUnitType extends RCCustomizableType {
  public abstract String getAlias();
  
  public abstract RCNumberWithUnitType setAlias(final String alias);
  
  public abstract String getUnit();
  
  public abstract RCNumberWithUnitType setUnit(final String unit);
  
  public abstract String getTypeName();
  
  public abstract RCNumberWithUnitValue createInstance(final RCExtensiableEntity rootOwner);
  
  public abstract RCNumberWithUnitTypeProxy toProxy();
}
