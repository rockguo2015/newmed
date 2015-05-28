package com.fudanmed.platform.core.web.shared.warehouse;

import com.fudanmed.platform.core.warehouse.proxy.RCProductCategoryProxy;
import com.fudanmed.platform.core.warehouse.proxy.RCProductTypeProxy;
import com.uniquesoft.gwt.shared.GWTEntity;
import com.uniquesoft.gwt.shared.common.IObjectFieldAccessor;

public class UIProductType extends GWTEntity {
  private String code;
  
  public String getCode() {
    return this.code;
  }
  
  public void setCode(final String code) {
    this.code = code;
  }
  
  public final static String P_Code = "code";
  
  public static IObjectFieldAccessor<UIProductType,String> CodeAccessor = new IObjectFieldAccessor<UIProductType,String>(){
    				public String getValue(UIProductType object){
    					return object.getCode();
    				}
    				public void setValue(UIProductType object,String value){
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
  
  public static IObjectFieldAccessor<UIProductType,String> NameAccessor = new IObjectFieldAccessor<UIProductType,String>(){
    				public String getValue(UIProductType object){
    					return object.getName();
    				}
    				public void setValue(UIProductType object,String value){
    					object.setName(value);
    				}
    			};
  
  private RCProductCategoryProxy category;
  
  public RCProductCategoryProxy getCategory() {
    return this.category;
  }
  
  public void setCategory(final RCProductCategoryProxy category) {
    this.category = category;
  }
  
  public final static String P_Category = "category";
  
  public static IObjectFieldAccessor<UIProductType,RCProductCategoryProxy> CategoryAccessor = new IObjectFieldAccessor<UIProductType,RCProductCategoryProxy>(){
    				public com.fudanmed.platform.core.warehouse.proxy.RCProductCategoryProxy getValue(UIProductType object){
    					return object.getCategory();
    				}
    				public void setValue(UIProductType object,com.fudanmed.platform.core.warehouse.proxy.RCProductCategoryProxy value){
    					object.setCategory(value);
    				}
    			};
  
  public RCProductTypeProxy toProxy() {
    return (RCProductTypeProxy)super.toProxy();
    
  }
}
