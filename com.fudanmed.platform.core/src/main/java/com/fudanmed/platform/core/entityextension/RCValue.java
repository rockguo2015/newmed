package com.fudanmed.platform.core.entityextension;

import com.fudanmed.platform.core.entityextension.RCAttributeSlot;
import com.fudanmed.platform.core.entityextension.RCExtensiableEntity;
import com.fudanmed.platform.core.entityextension.RCType;
import com.fudanmed.platform.core.entityextension.impl.RCValueImpl;
import com.fudanmed.platform.core.entityextension.proxy.RCValueProxy;
import edu.fudan.mylang.pf.EntityImplementation;
import edu.fudan.mylang.pf.IModelObject;
import edu.fudan.mylang.pf.INamedModelObject;

@EntityImplementation(implementBy = RCValueImpl.class)
public interface RCValue extends IModelObject, INamedModelObject {
  public abstract String getInstanceName();
  
  public abstract RCValue setInstanceName(final String instanceName);
  
  public abstract RCType getType();
  
  public abstract RCValue setType(final RCType type);
  
  public abstract RCExtensiableEntity getRootOwner();
  
  public abstract RCValue setRootOwner(final RCExtensiableEntity rootOwner);
  
  public abstract RCAttributeSlot getSlotOwner();
  
  public abstract RCValue setSlotOwner(final RCAttributeSlot slotOwner);
  
  public abstract String getEntityName();
  
  public abstract RCValue cloneIn(final RCExtensiableEntity rootOwner);
  
  public abstract RCValueProxy toProxy();
}
