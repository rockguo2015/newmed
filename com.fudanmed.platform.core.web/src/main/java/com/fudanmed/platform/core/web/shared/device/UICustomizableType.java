package com.fudanmed.platform.core.web.shared.device;

import com.fudanmed.platform.core.entityextension.proxy.RCCustomizableTypeProxy;
import com.uniquesoft.gwt.shared.GWTEntity;
import com.uniquesoft.gwt.shared.common.IObjectFieldAccessor;

public class UICustomizableType extends GWTEntity {
  private String alias;
  
  public String getAlias() {
    return this.alias;
  }
  
  public void setAlias(final String alias) {
    this.alias = alias;
  }
  
  public final static String P_Alias = "alias";
  
  public static IObjectFieldAccessor<UICustomizableType,String> AliasAccessor = new IObjectFieldAccessor<UICustomizableType,String>(){
    				public String getValue(UICustomizableType object){
    					return object.getAlias();
    				}
    				public void setValue(UICustomizableType object,String value){
    					object.setAlias(value);
    				}
    			};
  
  private String typeName;
  
  public String getTypeName() {
    return this.typeName;
  }
  
  public void setTypeName(final String typeName) {
    this.typeName = typeName;
  }
  
  public final static String P_TypeName = "typeName";
  
  public static IObjectFieldAccessor<UICustomizableType,String> TypeNameAccessor = new IObjectFieldAccessor<UICustomizableType,String>(){
    				public String getValue(UICustomizableType object){
    					return object.getTypeName();
    				}
    				public void setValue(UICustomizableType object,String value){
    					object.setTypeName(value);
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
  
  public static IObjectFieldAccessor<UICustomizableType,Boolean> IsPrimaryAccessor = new IObjectFieldAccessor<UICustomizableType,Boolean>(){
    				public Boolean getValue(UICustomizableType object){
    					return object.getIsPrimary();
    				}
    				public void setValue(UICustomizableType object,Boolean value){
    					object.setIsPrimary(value);
    				}
    			};
  
  public RCCustomizableTypeProxy toProxy() {
    return (RCCustomizableTypeProxy)super.toProxy();
    
  }
}
