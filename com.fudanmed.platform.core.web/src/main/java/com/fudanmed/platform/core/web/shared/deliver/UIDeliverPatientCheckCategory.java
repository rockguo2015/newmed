package com.fudanmed.platform.core.web.shared.deliver;

import com.fudanmed.platform.core.deliver.proxy.DLDeliverPatientCheckCategoryProxy;
import com.uniquesoft.gwt.shared.GWTEntity;
import com.uniquesoft.gwt.shared.common.IObjectFieldAccessor;

public class UIDeliverPatientCheckCategory extends GWTEntity {
  private String code;
  
  public String getCode() {
    return this.code;
  }
  
  public void setCode(final String code) {
    this.code = code;
  }
  
  public final static String P_Code = "code";
  
  public static IObjectFieldAccessor<UIDeliverPatientCheckCategory,String> CodeAccessor = new IObjectFieldAccessor<UIDeliverPatientCheckCategory,String>(){
    				public String getValue(UIDeliverPatientCheckCategory object){
    					return object.getCode();
    				}
    				public void setValue(UIDeliverPatientCheckCategory object,String value){
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
  
  public static IObjectFieldAccessor<UIDeliverPatientCheckCategory,String> NameAccessor = new IObjectFieldAccessor<UIDeliverPatientCheckCategory,String>(){
    				public String getValue(UIDeliverPatientCheckCategory object){
    					return object.getName();
    				}
    				public void setValue(UIDeliverPatientCheckCategory object,String value){
    					object.setName(value);
    				}
    			};
  
  private DLDeliverPatientCheckCategoryProxy parentCategory;
  
  public DLDeliverPatientCheckCategoryProxy getParentCategory() {
    return this.parentCategory;
  }
  
  public void setParentCategory(final DLDeliverPatientCheckCategoryProxy parentCategory) {
    this.parentCategory = parentCategory;
  }
  
  public final static String P_ParentCategory = "parentCategory";
  
  public static IObjectFieldAccessor<UIDeliverPatientCheckCategory,DLDeliverPatientCheckCategoryProxy> ParentCategoryAccessor = new IObjectFieldAccessor<UIDeliverPatientCheckCategory,DLDeliverPatientCheckCategoryProxy>(){
    				public com.fudanmed.platform.core.deliver.proxy.DLDeliverPatientCheckCategoryProxy getValue(UIDeliverPatientCheckCategory object){
    					return object.getParentCategory();
    				}
    				public void setValue(UIDeliverPatientCheckCategory object,com.fudanmed.platform.core.deliver.proxy.DLDeliverPatientCheckCategoryProxy value){
    					object.setParentCategory(value);
    				}
    			};
  
  public DLDeliverPatientCheckCategoryProxy toProxy() {
    return (DLDeliverPatientCheckCategoryProxy)super.toProxy();
    
  }
}
