package com.fudanmed.platform.core.entityextension;

import com.fudanmed.platform.core.entityextension.RCCompositeType;
import com.fudanmed.platform.core.entityextension.impl.RCExtensiableEntityTypeImpl;
import com.fudanmed.platform.core.entityextension.proxy.RCExtensiableEntityTypeProxy;
import edu.fudan.mylang.pf.EntityImplementation;
import edu.fudan.mylang.pf.IModelObject;
import java.util.Collection;

@EntityImplementation(implementBy = RCExtensiableEntityTypeImpl.class)
public interface RCExtensiableEntityType extends IModelObject {
  public abstract RCCompositeType getRootType();
  
  public abstract RCExtensiableEntityType setRootType(final RCCompositeType rootType);
  
  public abstract Collection<RCCompositeType> getCompositeTypes();
  
  public abstract RCCompositeType createAndAddtoCompositeTypes();
  
  public abstract RCExtensiableEntityType removeFromCompositeTypes(final RCCompositeType rCCompositeType);
  
  public abstract RCExtensiableEntityType removeAllCompositeTypes();
  
  public abstract RCExtensiableEntityTypeProxy toProxy();
}
