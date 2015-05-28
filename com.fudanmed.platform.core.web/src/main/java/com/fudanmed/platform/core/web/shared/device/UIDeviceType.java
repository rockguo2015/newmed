package com.fudanmed.platform.core.web.shared.device;

import com.fudanmed.platform.core.device.proxy.RCDeviceTypeCategoryProxy;
import com.fudanmed.platform.core.device.proxy.RCDeviceTypeProxy;
import com.uniquesoft.gwt.shared.GWTEntity;
import com.uniquesoft.gwt.shared.common.IObjectFieldAccessor;

public class UIDeviceType extends GWTEntity {
  private RCDeviceTypeCategoryProxy category;
  
  public RCDeviceTypeCategoryProxy getCategory() {
    return this.category;
  }
  
  public void setCategory(final RCDeviceTypeCategoryProxy category) {
    this.category = category;
  }
  
  public final static String P_Category = "category";
  
  public static IObjectFieldAccessor<UIDeviceType,RCDeviceTypeCategoryProxy> CategoryAccessor = new IObjectFieldAccessor<UIDeviceType,RCDeviceTypeCategoryProxy>(){
    				public com.fudanmed.platform.core.device.proxy.RCDeviceTypeCategoryProxy getValue(UIDeviceType object){
    					return object.getCategory();
    				}
    				public void setValue(UIDeviceType object,com.fudanmed.platform.core.device.proxy.RCDeviceTypeCategoryProxy value){
    					object.setCategory(value);
    				}
    			};
  
  private String code;
  
  public String getCode() {
    return this.code;
  }
  
  public void setCode(final String code) {
    this.code = code;
  }
  
  public final static String P_Code = "code";
  
  public static IObjectFieldAccessor<UIDeviceType,String> CodeAccessor = new IObjectFieldAccessor<UIDeviceType,String>(){
    				public String getValue(UIDeviceType object){
    					return object.getCode();
    				}
    				public void setValue(UIDeviceType object,String value){
    					object.setCode(value);
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
  
  public static IObjectFieldAccessor<UIDeviceType,String> NameAccessor = new IObjectFieldAccessor<UIDeviceType,String>(){
    				public String getValue(UIDeviceType object){
    					return object.getName();
    				}
    				public void setValue(UIDeviceType object,String value){
    					object.setName(value);
    				}
    			};
  
  private Integer depreciationYears;
  
  public Integer getDepreciationYears() {
    return this.depreciationYears;
  }
  
  public void setDepreciationYears(final Integer depreciationYears) {
    this.depreciationYears = depreciationYears;
  }
  
  public final static String P_DepreciationYears = "depreciationYears";
  
  public static IObjectFieldAccessor<UIDeviceType,Integer> DepreciationYearsAccessor = new IObjectFieldAccessor<UIDeviceType,Integer>(){
    				public Integer getValue(UIDeviceType object){
    					return object.getDepreciationYears();
    				}
    				public void setValue(UIDeviceType object,Integer value){
    					object.setDepreciationYears(value);
    				}
    			};
  
  public RCDeviceTypeProxy toProxy() {
    return (RCDeviceTypeProxy)super.toProxy();
    
  }
}
