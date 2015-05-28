package com.fudanmed.platform.core.web.shared.warehouse;

import com.fudanmed.platform.core.warehouse.proxy.RCProduceSpecificationUnitProxy;
import com.fudanmed.platform.core.web.shared.warehouse.UIProductSpecificationSummary;
import com.google.gwt.user.client.rpc.IsSerializable;
import com.uniquesoft.gwt.shared.GWTEntity;
import com.uniquesoft.gwt.shared.common.IObjectFieldAccessor;

public class UIWorkItemProductSpecSummary extends GWTEntity implements IsSerializable {
  private UIProductSpecificationSummary productSpecSummary = new UIProductSpecificationSummary();
  
  public UIProductSpecificationSummary getProductSpecSummary() {
    return this.productSpecSummary;
  }
  
  public void setProductSpecSummary(final UIProductSpecificationSummary productSpecSummary) {
    this.productSpecSummary = productSpecSummary;
  }
  
  public final static String P_ProductSpecSummary = "productSpecSummary";
  
  public static IObjectFieldAccessor<UIWorkItemProductSpecSummary,UIProductSpecificationSummary> ProductSpecSummaryAccessor = new IObjectFieldAccessor<UIWorkItemProductSpecSummary,UIProductSpecificationSummary>(){
    				public com.fudanmed.platform.core.web.shared.warehouse.UIProductSpecificationSummary getValue(UIWorkItemProductSpecSummary object){
    					return object.getProductSpecSummary();
    				}
    				public void setValue(UIWorkItemProductSpecSummary object,com.fudanmed.platform.core.web.shared.warehouse.UIProductSpecificationSummary value){
    					object.setProductSpecSummary(value);
    				}
    			};
  
  private String productName;
  
  public String getProductName() {
    return this.productName;
  }
  
  public void setProductName(final String productName) {
    this.productName = productName;
  }
  
  public final static String P_ProductName = "productName";
  
  public static IObjectFieldAccessor<UIWorkItemProductSpecSummary,String> ProductNameAccessor = new IObjectFieldAccessor<UIWorkItemProductSpecSummary,String>(){
    				public String getValue(UIWorkItemProductSpecSummary object){
    					return object.getProductName();
    				}
    				public void setValue(UIWorkItemProductSpecSummary object,String value){
    					object.setProductName(value);
    				}
    			};
  
  private Integer quantity;
  
  public Integer getQuantity() {
    return this.quantity;
  }
  
  public void setQuantity(final Integer quantity) {
    this.quantity = quantity;
  }
  
  public final static String P_Quantity = "quantity";
  
  public static IObjectFieldAccessor<UIWorkItemProductSpecSummary,Integer> QuantityAccessor = new IObjectFieldAccessor<UIWorkItemProductSpecSummary,Integer>(){
    				public Integer getValue(UIWorkItemProductSpecSummary object){
    					return object.getQuantity();
    				}
    				public void setValue(UIWorkItemProductSpecSummary object,Integer value){
    					object.setQuantity(value);
    				}
    			};
  
  private Integer sourceQuantity;
  
  public Integer getSourceQuantity() {
    return this.sourceQuantity;
  }
  
  public void setSourceQuantity(final Integer sourceQuantity) {
    this.sourceQuantity = sourceQuantity;
  }
  
  public final static String P_SourceQuantity = "sourceQuantity";
  
  public static IObjectFieldAccessor<UIWorkItemProductSpecSummary,Integer> SourceQuantityAccessor = new IObjectFieldAccessor<UIWorkItemProductSpecSummary,Integer>(){
    				public Integer getValue(UIWorkItemProductSpecSummary object){
    					return object.getSourceQuantity();
    				}
    				public void setValue(UIWorkItemProductSpecSummary object,Integer value){
    					object.setSourceQuantity(value);
    				}
    			};
  
  private String productSid;
  
  public String getProductSid() {
    return this.productSid;
  }
  
  public void setProductSid(final String productSid) {
    this.productSid = productSid;
  }
  
  public final static String P_ProductSid = "productSid";
  
  public static IObjectFieldAccessor<UIWorkItemProductSpecSummary,String> ProductSidAccessor = new IObjectFieldAccessor<UIWorkItemProductSpecSummary,String>(){
    				public String getValue(UIWorkItemProductSpecSummary object){
    					return object.getProductSid();
    				}
    				public void setValue(UIWorkItemProductSpecSummary object,String value){
    					object.setProductSid(value);
    				}
    			};
  
  private String typeDesc;
  
  public String getTypeDesc() {
    return this.typeDesc;
  }
  
  public void setTypeDesc(final String typeDesc) {
    this.typeDesc = typeDesc;
  }
  
  public final static String P_TypeDesc = "typeDesc";
  
  public static IObjectFieldAccessor<UIWorkItemProductSpecSummary,String> TypeDescAccessor = new IObjectFieldAccessor<UIWorkItemProductSpecSummary,String>(){
    				public String getValue(UIWorkItemProductSpecSummary object){
    					return object.getTypeDesc();
    				}
    				public void setValue(UIWorkItemProductSpecSummary object,String value){
    					object.setTypeDesc(value);
    				}
    			};
  
  private RCProduceSpecificationUnitProxy unit;
  
  public RCProduceSpecificationUnitProxy getUnit() {
    return this.unit;
  }
  
  public void setUnit(final RCProduceSpecificationUnitProxy unit) {
    this.unit = unit;
  }
  
  public final static String P_Unit = "unit";
  
  public static IObjectFieldAccessor<UIWorkItemProductSpecSummary,RCProduceSpecificationUnitProxy> UnitAccessor = new IObjectFieldAccessor<UIWorkItemProductSpecSummary,RCProduceSpecificationUnitProxy>(){
    				public com.fudanmed.platform.core.warehouse.proxy.RCProduceSpecificationUnitProxy getValue(UIWorkItemProductSpecSummary object){
    					return object.getUnit();
    				}
    				public void setValue(UIWorkItemProductSpecSummary object,com.fudanmed.platform.core.warehouse.proxy.RCProduceSpecificationUnitProxy value){
    					object.setUnit(value);
    				}
    			};
}
