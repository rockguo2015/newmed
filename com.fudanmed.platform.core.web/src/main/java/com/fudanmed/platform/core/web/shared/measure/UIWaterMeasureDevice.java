package com.fudanmed.platform.core.web.shared.measure;

import com.fudanmed.platform.core.measure.proxy.RCWaterMeasureDeviceProxy;
import com.uniquesoft.gwt.shared.GWTEntity;
import com.uniquesoft.gwt.shared.common.IObjectFieldAccessor;

public class UIWaterMeasureDevice extends GWTEntity {
  private String sid;
  
  public String getSid() {
    return this.sid;
  }
  
  public void setSid(final String sid) {
    this.sid = sid;
  }
  
  public final static String P_Sid = "sid";
  
  public static IObjectFieldAccessor<UIWaterMeasureDevice,String> SidAccessor = new IObjectFieldAccessor<UIWaterMeasureDevice,String>(){
    				public String getValue(UIWaterMeasureDevice object){
    					return object.getSid();
    				}
    				public void setValue(UIWaterMeasureDevice object,String value){
    					object.setSid(value);
    				}
    			};
  
  private String name;
  
  public String getName() {
    return this.name;
  }
  
  public void setName(final String name) {
    this.name = name;
  }
  
  public final static String P_Name = "name";
  
  public static IObjectFieldAccessor<UIWaterMeasureDevice,String> NameAccessor = new IObjectFieldAccessor<UIWaterMeasureDevice,String>(){
    				public String getValue(UIWaterMeasureDevice object){
    					return object.getName();
    				}
    				public void setValue(UIWaterMeasureDevice object,String value){
    					object.setName(value);
    				}
    			};
  
  private String location;
  
  public String getLocation() {
    return this.location;
  }
  
  public void setLocation(final String location) {
    this.location = location;
  }
  
  public final static String P_Location = "location";
  
  public static IObjectFieldAccessor<UIWaterMeasureDevice,String> LocationAccessor = new IObjectFieldAccessor<UIWaterMeasureDevice,String>(){
    				public String getValue(UIWaterMeasureDevice object){
    					return object.getLocation();
    				}
    				public void setValue(UIWaterMeasureDevice object,String value){
    					object.setLocation(value);
    				}
    			};
  
  public RCWaterMeasureDeviceProxy toProxy() {
    return (RCWaterMeasureDeviceProxy)super.toProxy();
    
  }
}
