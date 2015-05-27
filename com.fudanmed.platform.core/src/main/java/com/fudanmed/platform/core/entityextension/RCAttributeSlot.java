package com.fudanmed.platform.core.entityextension;

import com.fudanmed.platform.core.entityextension.RCAttribute;
import com.fudanmed.platform.core.entityextension.RCCompositeValue;
import com.fudanmed.platform.core.entityextension.RCType;
import com.fudanmed.platform.core.entityextension.RCValue;
import com.fudanmed.platform.core.entityextension.impl.RCAttributeSlotImpl;
import com.fudanmed.platform.core.entityextension.proxy.RCAttributeSlotProxy;
import edu.fudan.mylang.pf.EntityImplementation;
import edu.fudan.mylang.pf.IModelObject;

@EntityImplementation(implementBy = RCAttributeSlotImpl.class)
public interface RCAttributeSlot extends IModelObject {
  public abstract RCCompositeValue getAttrValue();
  
  public abstract RCAttributeSlot setAttrValue(final RCCompositeValue attrValue);
  
  public abstract RCAttribute getAttr();
  
  public abstract RCAttributeSlot setAttr(final RCAttribute attr);
  
  public abstract RCValue getValue();
  
  public abstract RCAttributeSlot setValue(final RCValue value);
  
  public abstract RCType getValueType();
  
  public abstract RCAttributeSlotProxy toProxy();
}
