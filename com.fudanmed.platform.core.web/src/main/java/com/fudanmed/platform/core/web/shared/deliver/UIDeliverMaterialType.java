package com.fudanmed.platform.core.web.shared.deliver;

import com.fudanmed.platform.core.deliver.proxy.DLDeliverMaterialCategoryProxy;
import com.fudanmed.platform.core.deliver.proxy.DLDeliverMaterialTypeProxy;
import com.uniquesoft.gwt.shared.GWTEntity;
import com.uniquesoft.gwt.shared.common.IObjectFieldAccessor;

public class UIDeliverMaterialType extends GWTEntity {
  private DLDeliverMaterialCategoryProxy category;
  
  public DLDeliverMaterialCategoryProxy getCategory() {
    return this.category;
  }
  
  public void setCategory(final DLDeliverMaterialCategoryProxy category) {
    this.category = category;
  }
  
  public final static String P_Category = "category";
  
  public static IObjectFieldAccessor<UIDeliverMaterialType,DLDeliverMaterialCategoryProxy> CategoryAccessor = new IObjectFieldAccessor<UIDeliverMaterialType,DLDeliverMaterialCategoryProxy>(){
    				public com.fudanmed.platform.core.deliver.proxy.DLDeliverMaterialCategoryProxy getValue(UIDeliverMaterialType object){
    					return object.getCategory();
    				}
    				public void setValue(UIDeliverMaterialType object,com.fudanmed.platform.core.deliver.proxy.DLDeliverMaterialCategoryProxy value){
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
  
  public static IObjectFieldAccessor<UIDeliverMaterialType,String> CodeAccessor = new IObjectFieldAccessor<UIDeliverMaterialType,String>(){
    				public String getValue(UIDeliverMaterialType object){
    					return object.getCode();
    				}
    				public void setValue(UIDeliverMaterialType object,String value){
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
  
  public static IObjectFieldAccessor<UIDeliverMaterialType,String> NameAccessor = new IObjectFieldAccessor<UIDeliverMaterialType,String>(){
    				public String getValue(UIDeliverMaterialType object){
    					return object.getName();
    				}
    				public void setValue(UIDeliverMaterialType object,String value){
    					object.setName(value);
    				}
    			};
  
  private String unit;
  
  public String getUnit() {
    return this.unit;
  }
  
  public void setUnit(final String unit) {
    this.unit = unit;
  }
  
  public final static String P_Unit = "unit";
  
  public static IObjectFieldAccessor<UIDeliverMaterialType,String> UnitAccessor = new IObjectFieldAccessor<UIDeliverMaterialType,String>(){
    				public String getValue(UIDeliverMaterialType object){
    					return object.getUnit();
    				}
    				public void setValue(UIDeliverMaterialType object,String value){
    					object.setUnit(value);
    				}
    			};
  
  private String comment;
  
  public String getComment() {
    return this.comment;
  }
  
  public void setComment(final String comment) {
    this.comment = comment;
  }
  
  public final static String P_Comment = "comment";
  
  public static IObjectFieldAccessor<UIDeliverMaterialType,String> CommentAccessor = new IObjectFieldAccessor<UIDeliverMaterialType,String>(){
    				public String getValue(UIDeliverMaterialType object){
    					return object.getComment();
    				}
    				public void setValue(UIDeliverMaterialType object,String value){
    					object.setComment(value);
    				}
    			};
  
  public DLDeliverMaterialTypeProxy toProxy() {
    return (DLDeliverMaterialTypeProxy)super.toProxy();
    
  }
}
