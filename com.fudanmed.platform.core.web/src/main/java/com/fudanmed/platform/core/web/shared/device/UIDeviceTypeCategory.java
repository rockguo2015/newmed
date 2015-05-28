package com.fudanmed.platform.core.web.shared.device;

import com.fudanmed.platform.core.device.proxy.RCDeviceTypeCategoryProxy;
import com.uniquesoft.gwt.shared.GWTEntity;
import com.uniquesoft.gwt.shared.common.IObjectFieldAccessor;

public class UIDeviceTypeCategory extends GWTEntity {
  private String code;
  
  public String getCode() {
    return this.code;
  }
  
  public void setCode(final String code) {
    this.code = code;
  }
  
  public final static String P_Code = "code";
  
  public static IObjectFieldAccessor<UIDeviceTypeCategory,String> CodeAccessor = new IObjectFieldAccessor<UIDeviceTypeCategory,String>(){
    				public String getValue(UIDeviceTypeCategory object){
    					return object.getCode();
    				}
    				public void setValue(UIDeviceTypeCategory object,String value){
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
  
  public static IObjectFieldAccessor<UIDeviceTypeCategory,String> NameAccessor = new IObjectFieldAccessor<UIDeviceTypeCategory,String>(){
    				public String getValue(UIDeviceTypeCategory object){
    					return object.getName();
    				}
    				public void setValue(UIDeviceTypeCategory object,String value){
    					object.setName(value);
    				}
    			};
  
  private String simplePy;
  
  public String getSimplePy() {
    return this.simplePy;
  }
  
  public void setSimplePy(final String simplePy) {
    this.simplePy = simplePy;
  }
  
  public final static String P_SimplePy = "simplePy";
  
  public static IObjectFieldAccessor<UIDeviceTypeCategory,String> SimplePyAccessor = new IObjectFieldAccessor<UIDeviceTypeCategory,String>(){
    				public String getValue(UIDeviceTypeCategory object){
    					return object.getSimplePy();
    				}
    				public void setValue(UIDeviceTypeCategory object,String value){
    					object.setSimplePy(value);
    				}
    			};
  
  private RCDeviceTypeCategoryProxy parent;
  
  public RCDeviceTypeCategoryProxy getParent() {
    return this.parent;
  }
  
  public void setParent(final RCDeviceTypeCategoryProxy parent) {
    this.parent = parent;
  }
  
  public final static String P_Parent = "parent";
  
  public static IObjectFieldAccessor<UIDeviceTypeCategory,RCDeviceTypeCategoryProxy> ParentAccessor = new IObjectFieldAccessor<UIDeviceTypeCategory,RCDeviceTypeCategoryProxy>(){
    				public com.fudanmed.platform.core.device.proxy.RCDeviceTypeCategoryProxy getValue(UIDeviceTypeCategory object){
    					return object.getParent();
    				}
    				public void setValue(UIDeviceTypeCategory object,com.fudanmed.platform.core.device.proxy.RCDeviceTypeCategoryProxy value){
    					object.setParent(value);
    				}
    			};
  
  public RCDeviceTypeCategoryProxy toProxy() {
    return (RCDeviceTypeCategoryProxy)super.toProxy();
    
  }
}
