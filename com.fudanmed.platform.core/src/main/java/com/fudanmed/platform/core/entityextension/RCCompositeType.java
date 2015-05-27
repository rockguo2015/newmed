package com.fudanmed.platform.core.entityextension;

import com.fudanmed.platform.core.entityextension.RCAttribute;
import com.fudanmed.platform.core.entityextension.RCCompositeValue;
import com.fudanmed.platform.core.entityextension.RCExtensiableEntity;
import com.fudanmed.platform.core.entityextension.RCExtensiableEntityType;
import com.fudanmed.platform.core.entityextension.RCType;
import com.fudanmed.platform.core.entityextension.impl.RCCompositeTypeImpl;
import com.fudanmed.platform.core.entityextension.proxy.RCCompositeTypeProxy;
import edu.fudan.mylang.pf.EntityImplementation;
import java.util.Collection;

@EntityImplementation(implementBy = RCCompositeTypeImpl.class)
public interface RCCompositeType extends RCType {
  public abstract String getName();
  
  public abstract RCCompositeType setName(final String name);
  
  public abstract String getTypeName();
  
  public abstract RCExtensiableEntityType getExtensiableEntity();
  
  public abstract RCCompositeType setExtensiableEntity(final RCExtensiableEntityType extensiableEntity);
  
  public abstract Collection<RCAttribute> getAttrs();
  
  public abstract RCAttribute createAndAddtoAttrs();
  
  public abstract RCCompositeType removeFromAttrs(final RCAttribute rCAttribute);
  
  public abstract RCCompositeType removeAllAttrs();
  
  public abstract RCCompositeValue createInstance(final RCExtensiableEntity rootOwner);
  
  public abstract RCCompositeType cloneType(final RCExtensiableEntityType extensiableEntity);
  
  public abstract RCCompositeTypeProxy toProxy();
}
