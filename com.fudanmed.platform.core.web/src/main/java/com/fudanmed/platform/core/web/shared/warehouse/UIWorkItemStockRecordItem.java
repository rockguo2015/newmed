package com.fudanmed.platform.core.web.shared.warehouse;

import com.fudanmed.platform.core.common.proxy.RCMaterialBrandProxy;
import com.fudanmed.platform.core.domain.proxy.RCWorkItemTaskProxy;
import com.fudanmed.platform.core.warehouse.proxy.RCProduceSpecificationUnitProxy;
import com.fudanmed.platform.core.warehouse.proxy.RCProductSpecificationProxy;
import com.fudanmed.platform.core.warehouse.proxy.RCWarehouseProxy;
import com.fudanmed.platform.core.warehouse.proxy.RCWorkItemStockRecordItemProxy;
import com.uniquesoft.gwt.shared.GWTEntity;
import com.uniquesoft.gwt.shared.common.IObjectFieldAccessor;

public class UIWorkItemStockRecordItem extends GWTEntity {
  private RCWorkItemTaskProxy workItem;
  
  public RCWorkItemTaskProxy getWorkItem() {
    return this.workItem;
  }
  
  public void setWorkItem(final RCWorkItemTaskProxy workItem) {
    this.workItem = workItem;
  }
  
  public final static String P_WorkItem = "workItem";
  
  public static IObjectFieldAccessor<UIWorkItemStockRecordItem,RCWorkItemTaskProxy> WorkItemAccessor = new IObjectFieldAccessor<UIWorkItemStockRecordItem,RCWorkItemTaskProxy>(){
    				public com.fudanmed.platform.core.domain.proxy.RCWorkItemTaskProxy getValue(UIWorkItemStockRecordItem object){
    					return object.getWorkItem();
    				}
    				public void setValue(UIWorkItemStockRecordItem object,com.fudanmed.platform.core.domain.proxy.RCWorkItemTaskProxy value){
    					object.setWorkItem(value);
    				}
    			};
  
  private RCWarehouseProxy sourceStore;
  
  public RCWarehouseProxy getSourceStore() {
    return this.sourceStore;
  }
  
  public void setSourceStore(final RCWarehouseProxy sourceStore) {
    this.sourceStore = sourceStore;
  }
  
  public final static String P_SourceStore = "sourceStore";
  
  public static IObjectFieldAccessor<UIWorkItemStockRecordItem,RCWarehouseProxy> SourceStoreAccessor = new IObjectFieldAccessor<UIWorkItemStockRecordItem,RCWarehouseProxy>(){
    				public com.fudanmed.platform.core.warehouse.proxy.RCWarehouseProxy getValue(UIWorkItemStockRecordItem object){
    					return object.getSourceStore();
    				}
    				public void setValue(UIWorkItemStockRecordItem object,com.fudanmed.platform.core.warehouse.proxy.RCWarehouseProxy value){
    					object.setSourceStore(value);
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
  
  public static IObjectFieldAccessor<UIWorkItemStockRecordItem,String> SidAccessor = new IObjectFieldAccessor<UIWorkItemStockRecordItem,String>(){
    				public String getValue(UIWorkItemStockRecordItem object){
    					return object.getSid();
    				}
    				public void setValue(UIWorkItemStockRecordItem object,String value){
    					object.setSid(value);
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
  
  public static IObjectFieldAccessor<UIWorkItemStockRecordItem,String> ProductSidAccessor = new IObjectFieldAccessor<UIWorkItemStockRecordItem,String>(){
    				public String getValue(UIWorkItemStockRecordItem object){
    					return object.getProductSid();
    				}
    				public void setValue(UIWorkItemStockRecordItem object,String value){
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
  
  public static IObjectFieldAccessor<UIWorkItemStockRecordItem,String> MaterialIdAccessor = new IObjectFieldAccessor<UIWorkItemStockRecordItem,String>(){
    				public String getValue(UIWorkItemStockRecordItem object){
    					return object.getMaterialId();
    				}
    				public void setValue(UIWorkItemStockRecordItem object,String value){
    					object.setMaterialId(value);
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
  
  public static IObjectFieldAccessor<UIWorkItemStockRecordItem,RCProductSpecificationProxy> ProductSpecAccessor = new IObjectFieldAccessor<UIWorkItemStockRecordItem,RCProductSpecificationProxy>(){
    				public com.fudanmed.platform.core.warehouse.proxy.RCProductSpecificationProxy getValue(UIWorkItemStockRecordItem object){
    					return object.getProductSpec();
    				}
    				public void setValue(UIWorkItemStockRecordItem object,com.fudanmed.platform.core.warehouse.proxy.RCProductSpecificationProxy value){
    					object.setProductSpec(value);
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
  
  public static IObjectFieldAccessor<UIWorkItemStockRecordItem,String> TypeDescAccessor = new IObjectFieldAccessor<UIWorkItemStockRecordItem,String>(){
    				public String getValue(UIWorkItemStockRecordItem object){
    					return object.getTypeDesc();
    				}
    				public void setValue(UIWorkItemStockRecordItem object,String value){
    					object.setTypeDesc(value);
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
  
  public static IObjectFieldAccessor<UIWorkItemStockRecordItem,Double> PriceAccessor = new IObjectFieldAccessor<UIWorkItemStockRecordItem,Double>(){
    				public Double getValue(UIWorkItemStockRecordItem object){
    					return object.getPrice();
    				}
    				public void setValue(UIWorkItemStockRecordItem object,Double value){
    					object.setPrice(value);
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
  
  public static IObjectFieldAccessor<UIWorkItemStockRecordItem,Integer> QuantityAccessor = new IObjectFieldAccessor<UIWorkItemStockRecordItem,Integer>(){
    				public Integer getValue(UIWorkItemStockRecordItem object){
    					return object.getQuantity();
    				}
    				public void setValue(UIWorkItemStockRecordItem object,Integer value){
    					object.setQuantity(value);
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
  
  public static IObjectFieldAccessor<UIWorkItemStockRecordItem,RCProduceSpecificationUnitProxy> UnitAccessor = new IObjectFieldAccessor<UIWorkItemStockRecordItem,RCProduceSpecificationUnitProxy>(){
    				public com.fudanmed.platform.core.warehouse.proxy.RCProduceSpecificationUnitProxy getValue(UIWorkItemStockRecordItem object){
    					return object.getUnit();
    				}
    				public void setValue(UIWorkItemStockRecordItem object,com.fudanmed.platform.core.warehouse.proxy.RCProduceSpecificationUnitProxy value){
    					object.setUnit(value);
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
  
  public static IObjectFieldAccessor<UIWorkItemStockRecordItem,RCMaterialBrandProxy> BrandAccessor = new IObjectFieldAccessor<UIWorkItemStockRecordItem,RCMaterialBrandProxy>(){
    				public com.fudanmed.platform.core.common.proxy.RCMaterialBrandProxy getValue(UIWorkItemStockRecordItem object){
    					return object.getBrand();
    				}
    				public void setValue(UIWorkItemStockRecordItem object,com.fudanmed.platform.core.common.proxy.RCMaterialBrandProxy value){
    					object.setBrand(value);
    				}
    			};
  
  public RCWorkItemStockRecordItemProxy toProxy() {
    return (RCWorkItemStockRecordItemProxy)super.toProxy();
    
  }
}
