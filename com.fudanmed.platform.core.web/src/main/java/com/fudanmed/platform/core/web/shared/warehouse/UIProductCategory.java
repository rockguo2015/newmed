package com.fudanmed.platform.core.web.shared.warehouse;

import com.fudanmed.platform.core.warehouse.proxy.RCProductCategoryProxy;
import com.uniquesoft.gwt.shared.GWTEntity;
import com.uniquesoft.gwt.shared.common.IObjectFieldAccessor;

public class UIProductCategory extends GWTEntity {
  private String code;
  
  public String getCode() {
    return this.code;
  }
  
  public void setCode(final String code) {
    this.code = code;
  }
  
  public final static String P_Code = "code";
  
  public static IObjectFieldAccessor<UIProductCategory,String> CodeAccessor = new IObjectFieldAccessor<UIProductCategory,String>(){
    				public String getValue(UIProductCategory object){
    					return object.getCode();
    				}
    				public void setValue(UIProductCategory object,String value){
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
  
  public static IObjectFieldAccessor<UIProductCategory,String> NameAccessor = new IObjectFieldAccessor<UIProductCategory,String>(){
    				public String getValue(UIProductCategory object){
    					return object.getName();
    				}
    				public void setValue(UIProductCategory object,String value){
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
  
  public static IObjectFieldAccessor<UIProductCategory,String> SimplePyAccessor = new IObjectFieldAccessor<UIProductCategory,String>(){
    				public String getValue(UIProductCategory object){
    					return object.getSimplePy();
    				}
    				public void setValue(UIProductCategory object,String value){
    					object.setSimplePy(value);
    				}
    			};
  
  private RCProductCategoryProxy parent;
  
  public RCProductCategoryProxy getParent() {
    return this.parent;
  }
  
  public void setParent(final RCProductCategoryProxy parent) {
    this.parent = parent;
  }
  
  public final static String P_Parent = "parent";
  
  public static IObjectFieldAccessor<UIProductCategory,RCProductCategoryProxy> ParentAccessor = new IObjectFieldAccessor<UIProductCategory,RCProductCategoryProxy>(){
    				public com.fudanmed.platform.core.warehouse.proxy.RCProductCategoryProxy getValue(UIProductCategory object){
    					return object.getParent();
    				}
    				public void setValue(UIProductCategory object,com.fudanmed.platform.core.warehouse.proxy.RCProductCategoryProxy value){
    					object.setParent(value);
    				}
    			};
  
  public RCProductCategoryProxy toProxy() {
    return (RCProductCategoryProxy)super.toProxy();
    
  }
}
