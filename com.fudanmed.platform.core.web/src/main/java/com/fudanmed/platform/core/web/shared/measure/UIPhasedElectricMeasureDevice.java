package com.fudanmed.platform.core.web.shared.measure;

import com.fudanmed.platform.core.measure.proxy.RCPhasedElectricMeasureDeviceProxy;
import com.uniquesoft.gwt.shared.GWTEntity;
import com.uniquesoft.gwt.shared.common.IObjectFieldAccessor;

public class UIPhasedElectricMeasureDevice extends GWTEntity {
  private String sid;
  
  public String getSid() {
    return this.sid;
  }
  
  public void setSid(final String sid) {
    this.sid = sid;
  }
  
  public final static String P_Sid = "sid";
  
  public static IObjectFieldAccessor<UIPhasedElectricMeasureDevice,String> SidAccessor = new IObjectFieldAccessor<UIPhasedElectricMeasureDevice,String>(){
    				public String getValue(UIPhasedElectricMeasureDevice object){
    					return object.getSid();
    				}
    				public void setValue(UIPhasedElectricMeasureDevice object,String value){
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
  
  public static IObjectFieldAccessor<UIPhasedElectricMeasureDevice,String> NameAccessor = new IObjectFieldAccessor<UIPhasedElectricMeasureDevice,String>(){
    				public String getValue(UIPhasedElectricMeasureDevice object){
    					return object.getName();
    				}
    				public void setValue(UIPhasedElectricMeasureDevice object,String value){
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
  
  public static IObjectFieldAccessor<UIPhasedElectricMeasureDevice,String> LocationAccessor = new IObjectFieldAccessor<UIPhasedElectricMeasureDevice,String>(){
    				public String getValue(UIPhasedElectricMeasureDevice object){
    					return object.getLocation();
    				}
    				public void setValue(UIPhasedElectricMeasureDevice object,String value){
    					object.setLocation(value);
    				}
    			};
  
  private Double factor;
  
  public Double getFactor() {
    return this.factor;
  }
  
  public void setFactor(final Double factor) {
    this.factor = factor;
  }
  
  public final static String P_Factor = "factor";
  
  public static IObjectFieldAccessor<UIPhasedElectricMeasureDevice,Double> FactorAccessor = new IObjectFieldAccessor<UIPhasedElectricMeasureDevice,Double>(){
    				public Double getValue(UIPhasedElectricMeasureDevice object){
    					return object.getFactor();
    				}
    				public void setValue(UIPhasedElectricMeasureDevice object,Double value){
    					object.setFactor(value);
    				}
    			};
  
  public RCPhasedElectricMeasureDeviceProxy toProxy() {
    return (RCPhasedElectricMeasureDeviceProxy)super.toProxy();
    
  }
}
