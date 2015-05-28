package com.fudanmed.platform.core.web.shared.measure;

import com.fudanmed.platform.core.measure.proxy.RCMeasureDeviceTypeProxy;
import com.uniquesoft.gwt.shared.GWTEntity;
import com.uniquesoft.gwt.shared.common.IObjectFieldAccessor;

public class UIMeasureDeviceType extends GWTEntity {
  private String name;
  
  public String getName() {
    return this.name;
  }
  
  public void setName(final String name) {
    this.name = name;
  }
  
  public final static String P_Name = "name";
  
  public static IObjectFieldAccessor<UIMeasureDeviceType,String> NameAccessor = new IObjectFieldAccessor<UIMeasureDeviceType,String>(){
    				public String getValue(UIMeasureDeviceType object){
    					return object.getName();
    				}
    				public void setValue(UIMeasureDeviceType object,String value){
    					object.setName(value);
    				}
    			};
  
  public RCMeasureDeviceTypeProxy toProxy() {
    return (RCMeasureDeviceTypeProxy)super.toProxy();
    
  }
}
