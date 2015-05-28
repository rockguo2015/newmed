package com.fudanmed.platform.core.web.shared.device;

import com.fudanmed.platform.core.entityextension.proxy.RCPrimaryTypeProxy;
import com.uniquesoft.gwt.shared.GWTEntity;
import com.uniquesoft.gwt.shared.common.IObjectFieldAccessor;

public class UIPrimaryType extends GWTEntity {
  private String name;
  
  public String getName() {
    return this.name;
  }
  
  public void setName(final String name) {
    this.name = name;
  }
  
  public final static String P_Name = "name";
  
  public static IObjectFieldAccessor<UIPrimaryType,String> NameAccessor = new IObjectFieldAccessor<UIPrimaryType,String>(){
    				public String getValue(UIPrimaryType object){
    					return object.getName();
    				}
    				public void setValue(UIPrimaryType object,String value){
    					object.setName(value);
    				}
    			};
  
  public RCPrimaryTypeProxy toProxy() {
    return (RCPrimaryTypeProxy)super.toProxy();
    
  }
}
