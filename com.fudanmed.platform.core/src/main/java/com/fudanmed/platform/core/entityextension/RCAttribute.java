package com.fudanmed.platform.core.entityextension;

import com.fudanmed.platform.core.entityextension.RCCompositeType;
import com.fudanmed.platform.core.entityextension.RCType;
import com.fudanmed.platform.core.entityextension.impl.RCAttributeImpl;
import com.fudanmed.platform.core.entityextension.proxy.RCAttributeProxy;
import edu.fudan.mylang.pf.EntityImplementation;
import edu.fudan.mylang.pf.IModelObject;

@EntityImplementation(implementBy = RCAttributeImpl.class)
public interface RCAttribute extends IModelObject {
  public abstract RCCompositeType getType();
  
  public abstract RCAttribute setType(final RCCompositeType type);
  
  public abstract String getName();
  
  public abstract RCAttribute setName(final String name);
  
  public abstract RCType getTypeRef();
  
  public abstract RCAttribute setTypeRef(final RCType typeRef);
  
  public abstract RCAttributeProxy toProxy();
}
