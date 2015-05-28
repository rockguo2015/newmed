package com.fudanmed.platform.core.web.shared.measure;

import com.fudanmed.platform.core.measure.proxy.RCMeasureDeviceProxy;
import com.uniquesoft.gwt.shared.GWTEntity;
import com.uniquesoft.gwt.shared.common.IObjectFieldAccessor;

public class UIMeasureDevice extends GWTEntity {
  private String sid;
  
  public String getSid() {
    return this.sid;
  }
  
  public void setSid(final String sid) {
    this.sid = sid;
  }
  
  public final static String P_Sid = "sid";
  
  public static IObjectFieldAccessor<UIMeasureDevice,String> SidAccessor = new IObjectFieldAccessor<UIMeasureDevice,String>(){
    				public String getValue(UIMeasureDevice object){
    					return object.getSid();
    				}
    				public void setValue(UIMeasureDevice object,String value){
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
  
  public static IObjectFieldAccessor<UIMeasureDevice,String> NameAccessor = new IObjectFieldAccessor<UIMeasureDevice,String>(){
    				public String getValue(UIMeasureDevice object){
    					return object.getName();
    				}
    				public void setValue(UIMeasureDevice object,String value){
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
  
  public static IObjectFieldAccessor<UIMeasureDevice,String> LocationAccessor = new IObjectFieldAccessor<UIMeasureDevice,String>(){
    				public String getValue(UIMeasureDevice object){
    					return object.getLocation();
    				}
    				public void setValue(UIMeasureDevice object,String value){
    					object.setLocation(value);
    				}
    			};
  
  public RCMeasureDeviceProxy toProxy() {
    return (RCMeasureDeviceProxy)super.toProxy();
    
  }
}
