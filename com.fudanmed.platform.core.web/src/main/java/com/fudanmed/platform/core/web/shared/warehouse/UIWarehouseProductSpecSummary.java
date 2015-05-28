package com.fudanmed.platform.core.web.shared.warehouse;

import com.fudanmed.platform.core.common.proxy.RCMaterialBrandProxy;
import com.fudanmed.platform.core.warehouse.proxy.RCProduceSpecificationUnitProxy;
import com.fudanmed.platform.core.web.shared.warehouse.UIProductWarehouseStorageSummary;
import com.google.gwt.user.client.rpc.IsSerializable;
import com.uniquesoft.gwt.shared.GWTEntity;
import com.uniquesoft.gwt.shared.common.IObjectFieldAccessor;

public class UIWarehouseProductSpecSummary extends GWTEntity implements IsSerializable {
  private UIProductWarehouseStorageSummary storageSummary;
  
  public UIProductWarehouseStorageSummary getStorageSummary() {
    return this.storageSummary;
  }
  
  public void setStorageSummary(final UIProductWarehouseStorageSummary storageSummary) {
    this.storageSummary = storageSummary;
  }
  
  public final static String P_StorageSummary = "storageSummary";
  
  public static IObjectFieldAccessor<UIWarehouseProductSpecSummary,UIProductWarehouseStorageSummary> StorageSummaryAccessor = new IObjectFieldAccessor<UIWarehouseProductSpecSummary,UIProductWarehouseStorageSummary>(){
    				public com.fudanmed.platform.core.web.shared.warehouse.UIProductWarehouseStorageSummary getValue(UIWarehouseProductSpecSummary object){
    					return object.getStorageSummary();
    				}
    				public void setValue(UIWarehouseProductSpecSummary object,com.fudanmed.platform.core.web.shared.warehouse.UIProductWarehouseStorageSummary value){
    					object.setStorageSummary(value);
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
  
  public static IObjectFieldAccessor<UIWarehouseProductSpecSummary,String> ProductNameAccessor = new IObjectFieldAccessor<UIWarehouseProductSpecSummary,String>(){
    				public String getValue(UIWarehouseProductSpecSummary object){
    					return object.getProductName();
    				}
    				public void setValue(UIWarehouseProductSpecSummary object,String value){
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
  
  public static IObjectFieldAccessor<UIWarehouseProductSpecSummary,Integer> QuantityAccessor = new IObjectFieldAccessor<UIWarehouseProductSpecSummary,Integer>(){
    				public Integer getValue(UIWarehouseProductSpecSummary object){
    					return object.getQuantity();
    				}
    				public void setValue(UIWarehouseProductSpecSummary object,Integer value){
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
  
  public static IObjectFieldAccessor<UIWarehouseProductSpecSummary,Integer> SourceQuantityAccessor = new IObjectFieldAccessor<UIWarehouseProductSpecSummary,Integer>(){
    				public Integer getValue(UIWarehouseProductSpecSummary object){
    					return object.getSourceQuantity();
    				}
    				public void setValue(UIWarehouseProductSpecSummary object,Integer value){
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
  
  public static IObjectFieldAccessor<UIWarehouseProductSpecSummary,String> ProductSidAccessor = new IObjectFieldAccessor<UIWarehouseProductSpecSummary,String>(){
    				public String getValue(UIWarehouseProductSpecSummary object){
    					return object.getProductSid();
    				}
    				public void setValue(UIWarehouseProductSpecSummary object,String value){
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
  
  public static IObjectFieldAccessor<UIWarehouseProductSpecSummary,String> TypeDescAccessor = new IObjectFieldAccessor<UIWarehouseProductSpecSummary,String>(){
    				public String getValue(UIWarehouseProductSpecSummary object){
    					return object.getTypeDesc();
    				}
    				public void setValue(UIWarehouseProductSpecSummary object,String value){
    					object.setTypeDesc(value);
    				}
    			};
  
  private RCMaterialBrandProxy brand;
  
  public RCMaterialBrandProxy getBrand() {
    return this.brand;
  }
  
  public void setBrand(final RCMaterialBrandProxy brand) {
    this.brand = brand;
  }
  
  public final static String P_Brand = "brand";
  
  public static IObjectFieldAccessor<UIWarehouseProductSpecSummary,RCMaterialBrandProxy> BrandAccessor = new IObjectFieldAccessor<UIWarehouseProductSpecSummary,RCMaterialBrandProxy>(){
    				public com.fudanmed.platform.core.common.proxy.RCMaterialBrandProxy getValue(UIWarehouseProductSpecSummary object){
    					return object.getBrand();
    				}
    				public void setValue(UIWarehouseProductSpecSummary object,com.fudanmed.platform.core.common.proxy.RCMaterialBrandProxy value){
    					object.setBrand(value);
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
  
  public static IObjectFieldAccessor<UIWarehouseProductSpecSummary,RCProduceSpecificationUnitProxy> UnitAccessor = new IObjectFieldAccessor<UIWarehouseProductSpecSummary,RCProduceSpecificationUnitProxy>(){
    				public com.fudanmed.platform.core.warehouse.proxy.RCProduceSpecificationUnitProxy getValue(UIWarehouseProductSpecSummary object){
    					return object.getUnit();
    				}
    				public void setValue(UIWarehouseProductSpecSummary object,com.fudanmed.platform.core.warehouse.proxy.RCProduceSpecificationUnitProxy value){
    					object.setUnit(value);
    				}
    			};
}
