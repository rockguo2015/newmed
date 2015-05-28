package com.fudanmed.platform.core.web.shared.device;

import com.fudanmed.platform.core.entityextension.proxy.RCPrimaryTypeProxy;
import com.google.gwt.user.client.rpc.IsSerializable;
import com.uniquesoft.gwt.shared.common.IObjectFieldAccessor;

public class UIPrimaryAttribute implements IsSerializable {
  private String parentCompositeAttribute;
  
  public String getParentCompositeAttribute() {
    return this.parentCompositeAttribute;
  }
  
  public void setParentCompositeAttribute(final String parentCompositeAttribute) {
    this.parentCompositeAttribute = parentCompositeAttribute;
  }
  
  public final static String P_ParentCompositeAttribute = "parentCompositeAttribute";
  
  public static IObjectFieldAccessor<UIPrimaryAttribute,String> ParentCompositeAttributeAccessor = new IObjectFieldAccessor<UIPrimaryAttribute,String>(){
    				public String getValue(UIPrimaryAttribute object){
    					return object.getParentCompositeAttribute();
    				}
    				public void setValue(UIPrimaryAttribute object,String value){
    					object.setParentCompositeAttribute(value);
    				}
    			};
  
  private String attributeName;
  
  public String getAttributeName() {
    return this.attributeName;
  }
  
  public void setAttributeName(final String attributeName) {
    this.attributeName = attributeName;
  }
  
  public final static String P_AttributeName = "attributeName";
  
  public static IObjectFieldAccessor<UIPrimaryAttribute,String> AttributeNameAccessor = new IObjectFieldAccessor<UIPrimaryAttribute,String>(){
    				public String getValue(UIPrimaryAttribute object){
    					return object.getAttributeName();
    				}
    				public void setValue(UIPrimaryAttribute object,String value){
    					object.setAttributeName(value);
    				}
    			};
  
  private RCPrimaryTypeProxy type;
  
  public RCPrimaryTypeProxy getType() {
    return this.type;
  }
  
  public void setType(final RCPrimaryTypeProxy type) {
    this.type = type;
  }
  
  public final static String P_Type = "type";
  
  public static IObjectFieldAccessor<UIPrimaryAttribute,RCPrimaryTypeProxy> TypeAccessor = new IObjectFieldAccessor<UIPrimaryAttribute,RCPrimaryTypeProxy>(){
    				public com.fudanmed.platform.core.entityextension.proxy.RCPrimaryTypeProxy getValue(UIPrimaryAttribute object){
    					return object.getType();
    				}
    				public void setValue(UIPrimaryAttribute object,com.fudanmed.platform.core.entityextension.proxy.RCPrimaryTypeProxy value){
    					object.setType(value);
    				}
    			};
}
