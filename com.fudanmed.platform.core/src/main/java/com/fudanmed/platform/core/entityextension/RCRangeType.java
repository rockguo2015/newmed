package com.fudanmed.platform.core.entityextension;

import com.fudanmed.platform.core.entityextension.RCCustomizableType;
import com.fudanmed.platform.core.entityextension.RCExtensiableEntity;
import com.fudanmed.platform.core.entityextension.RCNumberWithUnitType;
import com.fudanmed.platform.core.entityextension.RCRangeValue;
import com.fudanmed.platform.core.entityextension.impl.RCRangeTypeImpl;
import com.fudanmed.platform.core.entityextension.proxy.RCRangeTypeProxy;
import edu.fudan.mylang.pf.EntityImplementation;

@EntityImplementation(implementBy = RCRangeTypeImpl.class)
public interface RCRangeType extends RCCustomizableType {
  public abstract RCNumberWithUnitType getNumberType();
  
  public abstract RCRangeType setNumberType(final RCNumberWithUnitType numberType);
  
  public abstract String getTypeName();
  
  public abstract String getAlias();
  
  public abstract RCRangeValue createInstance(final RCExtensiableEntity rootOwner);
  
  public abstract RCRangeTypeProxy toProxy();
}
