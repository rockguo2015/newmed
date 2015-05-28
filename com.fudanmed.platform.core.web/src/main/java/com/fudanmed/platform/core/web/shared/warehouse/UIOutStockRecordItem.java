package com.fudanmed.platform.core.web.shared.warehouse;

import com.fudanmed.platform.core.common.proxy.RCMaterialBrandProxy;
import com.fudanmed.platform.core.warehouse.proxy.RCOutStockRecordItemProxy;
import com.fudanmed.platform.core.warehouse.proxy.RCProduceSpecificationUnitProxy;
import com.fudanmed.platform.core.warehouse.proxy.RCProductSpecificationProxy;
import com.fudanmed.platform.core.warehouse.proxy.RCWarehouseProxy;
import com.uniquesoft.gwt.shared.GWTEntity;
import com.uniquesoft.gwt.shared.common.IObjectFieldAccessor;

public class UIOutStockRecordItem extends GWTEntity {
  private RCWarehouseProxy sourceStore;
  
  public RCWarehouseProxy getSourceStore() {
    return this.sourceStore;
  }
  
  public void setSourceStore(final RCWarehouseProxy sourceStore) {
    this.sourceStore = sourceStore;
  }
  
  public final static String P_SourceStore = "sourceStore";
  
  public static IObjectFieldAccessor<UIOutStockRecordItem,RCWarehouseProxy> SourceStoreAccessor = new IObjectFieldAccessor<UIOutStockRecordItem,RCWarehouseProxy>(){
    				public com.fudanmed.platform.core.warehouse.proxy.RCWarehouseProxy getValue(UIOutStockRecordItem object){
    					return object.getSourceStore();
    				}
    				public void setValue(UIOutStockRecordItem object,com.fudanmed.platform.core.warehouse.proxy.RCWarehouseProxy value){
    					object.setSourceStore(value);
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
  
  public static IObjectFieldAccessor<UIOutStockRecordItem,RCProductSpecificationProxy> ProductSpecAccessor = new IObjectFieldAccessor<UIOutStockRecordItem,RCProductSpecificationProxy>(){
    				public com.fudanmed.platform.core.warehouse.proxy.RCProductSpecificationProxy getValue(UIOutStockRecordItem object){
    					return object.getProductSpec();
    				}
    				public void setValue(UIOutStockRecordItem object,com.fudanmed.platform.core.warehouse.proxy.RCProductSpecificationProxy value){
    					object.setProductSpec(value);
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
  
  public static IObjectFieldAccessor<UIOutStockRecordItem,String> MaterialIdAccessor = new IObjectFieldAccessor<UIOutStockRecordItem,String>(){
    				public String getValue(UIOutStockRecordItem object){
    					return object.getMaterialId();
    				}
    				public void setValue(UIOutStockRecordItem object,String value){
    					object.setMaterialId(value);
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
  
  public static IObjectFieldAccessor<UIOutStockRecordItem,RCMaterialBrandProxy> BrandAccessor = new IObjectFieldAccessor<UIOutStockRecordItem,RCMaterialBrandProxy>(){
    				public com.fudanmed.platform.core.common.proxy.RCMaterialBrandProxy getValue(UIOutStockRecordItem object){
    					return object.getBrand();
    				}
    				public void setValue(UIOutStockRecordItem object,com.fudanmed.platform.core.common.proxy.RCMaterialBrandProxy value){
    					object.setBrand(value);
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
  
  public static IObjectFieldAccessor<UIOutStockRecordItem,Double> PriceAccessor = new IObjectFieldAccessor<UIOutStockRecordItem,Double>(){
    				public Double getValue(UIOutStockRecordItem object){
    					return object.getPrice();
    				}
    				public void setValue(UIOutStockRecordItem object,Double value){
    					object.setPrice(value);
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
  
  public static IObjectFieldAccessor<UIOutStockRecordItem,String> SidAccessor = new IObjectFieldAccessor<UIOutStockRecordItem,String>(){
    				public String getValue(UIOutStockRecordItem object){
    					return object.getSid();
    				}
    				public void setValue(UIOutStockRecordItem object,String value){
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
  
  public static IObjectFieldAccessor<UIOutStockRecordItem,Integer> QuantityAccessor = new IObjectFieldAccessor<UIOutStockRecordItem,Integer>(){
    				public Integer getValue(UIOutStockRecordItem object){
    					return object.getQuantity();
    				}
    				public void setValue(UIOutStockRecordItem object,Integer value){
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
  
  public static IObjectFieldAccessor<UIOutStockRecordItem,String> ProductSidAccessor = new IObjectFieldAccessor<UIOutStockRecordItem,String>(){
    				public String getValue(UIOutStockRecordItem object){
    					return object.getProductSid();
    				}
    				public void setValue(UIOutStockRecordItem object,String value){
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
  
  public static IObjectFieldAccessor<UIOutStockRecordItem,String> TypeDescAccessor = new IObjectFieldAccessor<UIOutStockRecordItem,String>(){
    				public String getValue(UIOutStockRecordItem object){
    					return object.getTypeDesc();
    				}
    				public void setValue(UIOutStockRecordItem object,String value){
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
  
  public static IObjectFieldAccessor<UIOutStockRecordItem,RCProduceSpecificationUnitProxy> UnitAccessor = new IObjectFieldAccessor<UIOutStockRecordItem,RCProduceSpecificationUnitProxy>(){
    				public com.fudanmed.platform.core.warehouse.proxy.RCProduceSpecificationUnitProxy getValue(UIOutStockRecordItem object){
    					return object.getUnit();
    				}
    				public void setValue(UIOutStockRecordItem object,com.fudanmed.platform.core.warehouse.proxy.RCProduceSpecificationUnitProxy value){
    					object.setUnit(value);
    				}
    			};
  
  public RCOutStockRecordItemProxy toProxy() {
    return (RCOutStockRecordItemProxy)super.toProxy();
    
  }
}
