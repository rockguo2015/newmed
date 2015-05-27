package com.fudanmed.platform.core.entityextension;

import com.fudanmed.platform.core.entityextension.RCAttribute;
import com.fudanmed.platform.core.entityextension.RCAttributeSlot;
import com.fudanmed.platform.core.entityextension.RCExtensiableEntity;
import com.fudanmed.platform.core.entityextension.RCType;
import com.fudanmed.platform.core.entityextension.RCValue;
import com.fudanmed.platform.core.entityextension.impl.RCCompositeValueImpl;
import com.fudanmed.platform.core.entityextension.proxy.RCCompositeValueProxy;
import edu.fudan.mylang.pf.EntityImplementation;
import java.util.Collection;

@EntityImplementation(implementBy = RCCompositeValueImpl.class)
public interface RCCompositeValue extends RCValue {
  public abstract Collection<RCAttributeSlot> getSlots();
  
  public abstract RCAttributeSlot createAndAddtoSlots();
  
  public abstract RCCompositeValue removeFromSlots(final RCAttributeSlot rCAttributeSlot);
  
  public abstract RCCompositeValue removeAllSlots();
  
  public abstract RCAttributeSlot createAttribute(final String name, final RCType typeRef);
  
  public abstract RCAttributeSlot createAttribute(final String name, final String typeName);
  
  public abstract void removeAttribute(final RCAttribute attr);
  
  public abstract String getEntityName();
  
  public abstract RCCompositeValue cloneIn(final RCExtensiableEntity rootOwner);
  
  public abstract RCCompositeValueProxy toProxy();
}
