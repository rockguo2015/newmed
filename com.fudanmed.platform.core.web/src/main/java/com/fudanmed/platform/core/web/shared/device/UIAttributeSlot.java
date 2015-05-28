package com.fudanmed.platform.core.web.shared.device;

import com.fudanmed.platform.core.entityextension.proxy.RCAttributeSlotProxy;
import com.fudanmed.platform.core.entityextension.proxy.RCTypeProxy;
import com.fudanmed.platform.core.entityextension.proxy.RCValueProxy;
import com.fudanmed.platform.core.web.shared.device.UIPrimaryTypeEnum;
import com.uniquesoft.gwt.shared.GWTEntity;
import com.uniquesoft.gwt.shared.common.IObjectFieldAccessor;

public class UIAttributeSlot extends GWTEntity {
  private UIAttributeSlot parentSlot;
  
  public UIAttributeSlot getParentSlot() {
    return this.parentSlot;
  }
  
  public void setParentSlot(final UIAttributeSlot parentSlot) {
    this.parentSlot = parentSlot;
  }
  
  public final static String P_ParentSlot = "parentSlot";
  
  public static IObjectFieldAccessor<UIAttributeSlot,UIAttributeSlot> ParentSlotAccessor = new IObjectFieldAccessor<UIAttributeSlot,UIAttributeSlot>(){
    				public com.fudanmed.platform.core.web.shared.device.UIAttributeSlot getValue(UIAttributeSlot object){
    					return object.getParentSlot();
    				}
    				public void setValue(UIAttributeSlot object,com.fudanmed.platform.core.web.shared.device.UIAttributeSlot value){
    					object.setParentSlot(value);
    				}
    			};
  
  private String slotName;
  
  public String getSlotName() {
    return this.slotName;
  }
  
  public void setSlotName(final String slotName) {
    this.slotName = slotName;
  }
  
  public final static String P_SlotName = "slotName";
  
  public static IObjectFieldAccessor<UIAttributeSlot,String> SlotNameAccessor = new IObjectFieldAccessor<UIAttributeSlot,String>(){
    				public String getValue(UIAttributeSlot object){
    					return object.getSlotName();
    				}
    				public void setValue(UIAttributeSlot object,String value){
    					object.setSlotName(value);
    				}
    			};
  
  private RCTypeProxy type;
  
  public RCTypeProxy getType() {
    return this.type;
  }
  
  public void setType(final RCTypeProxy type) {
    this.type = type;
  }
  
  public final static String P_Type = "type";
  
  public static IObjectFieldAccessor<UIAttributeSlot,RCTypeProxy> TypeAccessor = new IObjectFieldAccessor<UIAttributeSlot,RCTypeProxy>(){
    				public com.fudanmed.platform.core.entityextension.proxy.RCTypeProxy getValue(UIAttributeSlot object){
    					return object.getType();
    				}
    				public void setValue(UIAttributeSlot object,com.fudanmed.platform.core.entityextension.proxy.RCTypeProxy value){
    					object.setType(value);
    				}
    			};
  
  private RCValueProxy slotValue;
  
  public RCValueProxy getSlotValue() {
    return this.slotValue;
  }
  
  public void setSlotValue(final RCValueProxy slotValue) {
    this.slotValue = slotValue;
  }
  
  public final static String P_SlotValue = "slotValue";
  
  public static IObjectFieldAccessor<UIAttributeSlot,RCValueProxy> SlotValueAccessor = new IObjectFieldAccessor<UIAttributeSlot,RCValueProxy>(){
    				public com.fudanmed.platform.core.entityextension.proxy.RCValueProxy getValue(UIAttributeSlot object){
    					return object.getSlotValue();
    				}
    				public void setValue(UIAttributeSlot object,com.fudanmed.platform.core.entityextension.proxy.RCValueProxy value){
    					object.setSlotValue(value);
    				}
    			};
  
  private Boolean isPrimary;
  
  public Boolean getIsPrimary() {
    return this.isPrimary;
  }
  
  public void setIsPrimary(final Boolean isPrimary) {
    this.isPrimary = isPrimary;
  }
  
  public final static String P_IsPrimary = "isPrimary";
  
  public static IObjectFieldAccessor<UIAttributeSlot,Boolean> IsPrimaryAccessor = new IObjectFieldAccessor<UIAttributeSlot,Boolean>(){
    				public Boolean getValue(UIAttributeSlot object){
    					return object.getIsPrimary();
    				}
    				public void setValue(UIAttributeSlot object,Boolean value){
    					object.setIsPrimary(value);
    				}
    			};
  
  private UIPrimaryTypeEnum typeEnum;
  
  public UIPrimaryTypeEnum getTypeEnum() {
    return this.typeEnum;
  }
  
  public void setTypeEnum(final UIPrimaryTypeEnum typeEnum) {
    this.typeEnum = typeEnum;
  }
  
  public final static String P_TypeEnum = "typeEnum";
  
  public static IObjectFieldAccessor<UIAttributeSlot,UIPrimaryTypeEnum> TypeEnumAccessor = new IObjectFieldAccessor<UIAttributeSlot,UIPrimaryTypeEnum>(){
    				public com.fudanmed.platform.core.web.shared.device.UIPrimaryTypeEnum getValue(UIAttributeSlot object){
    					return object.getTypeEnum();
    				}
    				public void setValue(UIAttributeSlot object,com.fudanmed.platform.core.web.shared.device.UIPrimaryTypeEnum value){
    					object.setTypeEnum(value);
    				}
    			};
  
  public RCAttributeSlotProxy toProxy() {
    return (RCAttributeSlotProxy)super.toProxy();
    
  }
}
