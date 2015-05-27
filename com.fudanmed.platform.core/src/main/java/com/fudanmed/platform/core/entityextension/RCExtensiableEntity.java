package com.fudanmed.platform.core.entityextension;

import com.fudanmed.platform.core.entityextension.RCCompositeValue;
import com.fudanmed.platform.core.entityextension.RCExtensiableEntityType;
import com.fudanmed.platform.core.entityextension.RCType;
import com.fudanmed.platform.core.entityextension.impl.RCExtensiableEntityImpl;
import com.fudanmed.platform.core.entityextension.proxy.RCExtensiableEntityProxy;
import edu.fudan.mylang.pf.EntityImplementation;
import edu.fudan.mylang.pf.IModelObject;

@EntityImplementation(implementBy = RCExtensiableEntityImpl.class)
public interface RCExtensiableEntity extends IModelObject {
  public abstract RCExtensiableEntityType getType();
  
  public abstract RCExtensiableEntity setType(final RCExtensiableEntityType type);
  
  public abstract RCCompositeValue getValue();
  
  public abstract RCExtensiableEntity setValue(final RCCompositeValue value);
  
  public abstract RCType getValueType();
  
  public abstract RCExtensiableEntityProxy toProxy();
}
