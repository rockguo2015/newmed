package com.fudanmed.platform.core.web.shared.device;

import com.google.gwt.user.client.rpc.IsSerializable;
import com.uniquesoft.gwt.shared.common.IObjectFieldAccessor;

public class UICompositeAttribute implements IsSerializable {
  private String parentCompositeAttribute;
  
  public String getParentCompositeAttribute() {
    return this.parentCompositeAttribute;
  }
  
  public void setParentCompositeAttribute(final String parentCompositeAttribute) {
    this.parentCompositeAttribute = parentCompositeAttribute;
  }
  
  public final static String P_ParentCompositeAttribute = "parentCompositeAttribute";
  
  public static IObjectFieldAccessor<UICompositeAttribute,String> ParentCompositeAttributeAccessor = new IObjectFieldAccessor<UICompositeAttribute,String>(){
    				public String getValue(UICompositeAttribute object){
    					return object.getParentCompositeAttribute();
    				}
    				public void setValue(UICompositeAttribute object,String value){
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
  
  public static IObjectFieldAccessor<UICompositeAttribute,String> AttributeNameAccessor = new IObjectFieldAccessor<UICompositeAttribute,String>(){
    				public String getValue(UICompositeAttribute object){
    					return object.getAttributeName();
    				}
    				public void setValue(UICompositeAttribute object,String value){
    					object.setAttributeName(value);
    				}
    			};
}
