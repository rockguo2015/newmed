package com.fudanmed.platform.core.web.shared.deliver;

import com.fudanmed.platform.core.deliver.proxy.DLDeliverMaterialCategoryProxy;
import com.uniquesoft.gwt.shared.GWTEntity;
import com.uniquesoft.gwt.shared.common.IObjectFieldAccessor;

public class UIDeliverMaterialCategory extends GWTEntity {
  private String code;
  
  public String getCode() {
    return this.code;
  }
  
  public void setCode(final String code) {
    this.code = code;
  }
  
  public final static String P_Code = "code";
  
  public static IObjectFieldAccessor<UIDeliverMaterialCategory,String> CodeAccessor = new IObjectFieldAccessor<UIDeliverMaterialCategory,String>(){
    				public String getValue(UIDeliverMaterialCategory object){
    					return object.getCode();
    				}
    				public void setValue(UIDeliverMaterialCategory object,String value){
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
  
  public static IObjectFieldAccessor<UIDeliverMaterialCategory,String> NameAccessor = new IObjectFieldAccessor<UIDeliverMaterialCategory,String>(){
    				public String getValue(UIDeliverMaterialCategory object){
    					return object.getName();
    				}
    				public void setValue(UIDeliverMaterialCategory object,String value){
    					object.setName(value);
    				}
    			};
  
  private DLDeliverMaterialCategoryProxy parentCategory;
  
  public DLDeliverMaterialCategoryProxy getParentCategory() {
    return this.parentCategory;
  }
  
  public void setParentCategory(final DLDeliverMaterialCategoryProxy parentCategory) {
    this.parentCategory = parentCategory;
  }
  
  public final static String P_ParentCategory = "parentCategory";
  
  public static IObjectFieldAccessor<UIDeliverMaterialCategory,DLDeliverMaterialCategoryProxy> ParentCategoryAccessor = new IObjectFieldAccessor<UIDeliverMaterialCategory,DLDeliverMaterialCategoryProxy>(){
    				public com.fudanmed.platform.core.deliver.proxy.DLDeliverMaterialCategoryProxy getValue(UIDeliverMaterialCategory object){
    					return object.getParentCategory();
    				}
    				public void setValue(UIDeliverMaterialCategory object,com.fudanmed.platform.core.deliver.proxy.DLDeliverMaterialCategoryProxy value){
    					object.setParentCategory(value);
    				}
    			};
  
  public DLDeliverMaterialCategoryProxy toProxy() {
    return (DLDeliverMaterialCategoryProxy)super.toProxy();
    
  }
}
