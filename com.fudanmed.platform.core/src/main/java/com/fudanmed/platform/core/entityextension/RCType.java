package com.fudanmed.platform.core.entityextension;

import com.fudanmed.platform.core.entityextension.RCExtensiableEntity;
import com.fudanmed.platform.core.entityextension.RCExtensiableEntityType;
import com.fudanmed.platform.core.entityextension.RCValue;
import com.fudanmed.platform.core.entityextension.impl.RCTypeImpl;
import com.fudanmed.platform.core.entityextension.proxy.RCTypeProxy;
import edu.fudan.mylang.pf.EntityImplementation;
import edu.fudan.mylang.pf.IModelObject;
import edu.fudan.mylang.pf.INamedModelObject;

@EntityImplementation(implementBy = RCTypeImpl.class)
public interface RCType extends IModelObject, INamedModelObject {
  public abstract String getTypeName();
  
  public abstract RCValue createInstance(final RCExtensiableEntity rootOwner);
  
  public abstract String getEntityName();
  
  public abstract RCType cloneType(final RCExtensiableEntityType extensiableEntity);
  
  public abstract RCTypeProxy toProxy();
}
