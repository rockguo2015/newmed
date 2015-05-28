package com.fudanmed.platform.core.web.shared.warehouse;

import com.fudanmed.platform.core.common.proxy.RCMaterialBrandProxy;
import com.fudanmed.platform.core.domain.proxy.RCWorkItemTaskProxy;
import com.fudanmed.platform.core.warehouse.proxy.RCProduceSpecificationUnitProxy;
import com.fudanmed.platform.core.warehouse.proxy.RCProductSpecificationProxy;
import com.fudanmed.platform.core.warehouse.proxy.RCWorkItemStorageProxy;
import com.uniquesoft.gwt.shared.GWTEntity;
import com.uniquesoft.gwt.shared.common.IObjectFieldAccessor;

public class UIWorkItemStorage extends GWTEntity {
  private RCWorkItemTaskProxy workItem;
  
  public RCWorkItemTaskProxy getWorkItem() {
    return this.workItem;
  }
  
  public void setWorkItem(final RCWorkItemTaskProxy workItem) {
    this.workItem = workItem;
  }
  
  public final static String P_WorkItem = "workItem";
  
  public static IObjectFieldAccessor<UIWorkItemStorage,RCWorkItemTaskProxy> WorkItemAccessor = new IObjectFieldAccessor<UIWorkItemStorage,RCWorkItemTaskProxy>(){
    				public com.fudanmed.platform.core.domain.proxy.RCWorkItemTaskProxy getValue(UIWorkItemStorage object){
    					return object.getWorkItem();
    				}
    				public void setValue(UIWorkItemStorage object,com.fudanmed.platform.core.domain.proxy.RCWorkItemTaskProxy value){
    					object.setWorkItem(value);
    				}
    			};
  
  private RCProductSpecificationProxy productSpec;
  
  public RCProductSpecificationProxy getProductSpec() {
    return this.productSpec;
  }
  
  public void setProductSpec(final RCProductSpecificationProxy productSpec) {
    this.productSpec = productSpec;
  }
  
  public final static String P_ProductSpec = "productSpec";
  
  public static IObjectFieldAccessor<UIWorkItemStorage,RCProductSpecificationProxy> ProductSpecAccessor = new IObjectFieldAccessor<UIWorkItemStorage,RCProductSpecificationProxy>(){
    				public com.fudanmed.platform.core.warehouse.proxy.RCProductSpecificationProxy getValue(UIWorkItemStorage object){
    					return object.getProductSpec();
    				}
    				public void setValue(UIWorkItemStorage object,com.fudanmed.platform.core.warehouse.proxy.RCProductSpecificationProxy value){
    					object.setProductSpec(value);
    				}
    			};
  
  private String sid;
  
  public String getSid() {
    return this.sid;
  }
  
  public void setSid(final String sid) {
    this.sid = sid;
  }
  
  public final static String P_Sid = "sid";
  
  public static IObjectFieldAccessor<UIWorkItemStorage,String> SidAccessor = new IObjectFieldAccessor<UIWorkItemStorage,String>(){
    				public String getValue(UIWorkItemStorage object){
    					return object.getSid();
    				}
    				public void setValue(UIWorkItemStorage object,String value){
    					object.setSid(value);
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
  
  public static IObjectFieldAccessor<UIWorkItemStorage,Integer> QuantityAccessor = new IObjectFieldAccessor<UIWorkItemStorage,Integer>(){
    				public Integer getValue(UIWorkItemStorage object){
    					return object.getQuantity();
    				}
    				public void setValue(UIWorkItemStorage object,Integer value){
    					object.setQuantity(value);
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
  
  public static IObjectFieldAccessor<UIWorkItemStorage,String> ProductSidAccessor = new IObjectFieldAccessor<UIWorkItemStorage,String>(){
    				public String getValue(UIWorkItemStorage object){
    					return object.getProductSid();
    				}
    				public void setValue(UIWorkItemStorage object,String value){
    					object.setProductSid(value);
    				}
    			};
  
  private String materialId;
  
  public String getMaterialId() {
    return this.materialId;
  }
  
  public void setMaterialId(final String materialId) {
    this.materialId = materialId;
  }
  
  public final static String P_MaterialId = "materialId";
  
  public static IObjectFieldAccessor<UIWorkItemStorage,String> MaterialIdAccessor = new IObjectFieldAccessor<UIWorkItemStorage,String>(){
    				public String getValue(UIWorkItemStorage object){
    					return object.getMaterialId();
    				}
    				public void setValue(UIWorkItemStorage object,String value){
    					object.setMaterialId(value);
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
  
  public static IObjectFieldAccessor<UIWorkItemStorage,String> TypeDescAccessor = new IObjectFieldAccessor<UIWorkItemStorage,String>(){
    				public String getValue(UIWorkItemStorage object){
    					return object.getTypeDesc();
    				}
    				public void setValue(UIWorkItemStorage object,String value){
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
  
  public static IObjectFieldAccessor<UIWorkItemStorage,RCProduceSpecificationUnitProxy> UnitAccessor = new IObjectFieldAccessor<UIWorkItemStorage,RCProduceSpecificationUnitProxy>(){
    				public com.fudanmed.platform.core.warehouse.proxy.RCProduceSpecificationUnitProxy getValue(UIWorkItemStorage object){
    					return object.getUnit();
    				}
    				public void setValue(UIWorkItemStorage object,com.fudanmed.platform.core.warehouse.proxy.RCProduceSpecificationUnitProxy value){
    					object.setUnit(value);
    				}
    			};
  
  private Double amount;
  
  public Double getAmount() {
    return this.amount;
  }
  
  public void setAmount(final Double amount) {
    this.amount = amount;
  }
  
  public final static String P_Amount = "amount";
  
  public static IObjectFieldAccessor<UIWorkItemStorage,Double> AmountAccessor = new IObjectFieldAccessor<UIWorkItemStorage,Double>(){
    				public Double getValue(UIWorkItemStorage object){
    					return object.getAmount();
    				}
    				public void setValue(UIWorkItemStorage object,Double value){
    					object.setAmount(value);
    				}
    			};
  
  private Double price;
  
  public Double getPrice() {
    return this.price;
  }
  
  public void setPrice(final Double price) {
    this.price = price;
  }
  
  public final static String P_Price = "price";
  
  public static IObjectFieldAccessor<UIWorkItemStorage,Double> PriceAccessor = new IObjectFieldAccessor<UIWorkItemStorage,Double>(){
    				public Double getValue(UIWorkItemStorage object){
    					return object.getPrice();
    				}
    				public void setValue(UIWorkItemStorage object,Double value){
    					object.setPrice(value);
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
  
  public static IObjectFieldAccessor<UIWorkItemStorage,RCMaterialBrandProxy> BrandAccessor = new IObjectFieldAccessor<UIWorkItemStorage,RCMaterialBrandProxy>(){
    				public com.fudanmed.platform.core.common.proxy.RCMaterialBrandProxy getValue(UIWorkItemStorage object){
    					return object.getBrand();
    				}
    				public void setValue(UIWorkItemStorage object,com.fudanmed.platform.core.common.proxy.RCMaterialBrandProxy value){
    					object.setBrand(value);
    				}
    			};
  
  public RCWorkItemStorageProxy toProxy() {
    return (RCWorkItemStorageProxy)super.toProxy();
    
  }
}
