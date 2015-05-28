package com.fudanmed.platform.core.web.shared.warehouse;

import com.fudanmed.platform.core.common.proxy.RCMaterialBrandProxy;
import com.fudanmed.platform.core.warehouse.proxy.RCProduceSpecificationUnitProxy;
import com.fudanmed.platform.core.warehouse.proxy.RCProductEntryProxy;
import com.fudanmed.platform.core.warehouse.proxy.RCTransferRecordItemProxy;
import com.fudanmed.platform.core.web.shared.warehouse.UIProductWarehouseStorage;
import com.uniquesoft.gwt.shared.GWTEntity;
import com.uniquesoft.gwt.shared.common.IObjectFieldAccessor;

public class UITransferRecordItem extends GWTEntity {
  private String sid;
  
  public String getSid() {
    return this.sid;
  }
  
  public void setSid(final String sid) {
    this.sid = sid;
  }
  
  public final static String P_Sid = "sid";
  
  public static IObjectFieldAccessor<UITransferRecordItem,String> SidAccessor = new IObjectFieldAccessor<UITransferRecordItem,String>(){
    				public String getValue(UITransferRecordItem object){
    					return object.getSid();
    				}
    				public void setValue(UITransferRecordItem object,String value){
    					object.setSid(value);
    				}
    			};
  
  private UIProductWarehouseStorage storage;
  
  public UIProductWarehouseStorage getStorage() {
    return this.storage;
  }
  
  public void setStorage(final UIProductWarehouseStorage storage) {
    this.storage = storage;
  }
  
  public final static String P_Storage = "storage";
  
  public static IObjectFieldAccessor<UITransferRecordItem,UIProductWarehouseStorage> StorageAccessor = new IObjectFieldAccessor<UITransferRecordItem,UIProductWarehouseStorage>(){
    				public com.fudanmed.platform.core.web.shared.warehouse.UIProductWarehouseStorage getValue(UITransferRecordItem object){
    					return object.getStorage();
    				}
    				public void setValue(UITransferRecordItem object,com.fudanmed.platform.core.web.shared.warehouse.UIProductWarehouseStorage value){
    					object.setStorage(value);
    				}
    			};
  
  private RCProductEntryProxy productEntry;
  
  public RCProductEntryProxy getProductEntry() {
    return this.productEntry;
  }
  
  public void setProductEntry(final RCProductEntryProxy productEntry) {
    this.productEntry = productEntry;
  }
  
  public final static String P_ProductEntry = "productEntry";
  
  public static IObjectFieldAccessor<UITransferRecordItem,RCProductEntryProxy> ProductEntryAccessor = new IObjectFieldAccessor<UITransferRecordItem,RCProductEntryProxy>(){
    				public com.fudanmed.platform.core.warehouse.proxy.RCProductEntryProxy getValue(UITransferRecordItem object){
    					return object.getProductEntry();
    				}
    				public void setValue(UITransferRecordItem object,com.fudanmed.platform.core.warehouse.proxy.RCProductEntryProxy value){
    					object.setProductEntry(value);
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
  
  public static IObjectFieldAccessor<UITransferRecordItem,Integer> QuantityAccessor = new IObjectFieldAccessor<UITransferRecordItem,Integer>(){
    				public Integer getValue(UITransferRecordItem object){
    					return object.getQuantity();
    				}
    				public void setValue(UITransferRecordItem object,Integer value){
    					object.setQuantity(value);
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
  
  public static IObjectFieldAccessor<UITransferRecordItem,String> MaterialIdAccessor = new IObjectFieldAccessor<UITransferRecordItem,String>(){
    				public String getValue(UITransferRecordItem object){
    					return object.getMaterialId();
    				}
    				public void setValue(UITransferRecordItem object,String value){
    					object.setMaterialId(value);
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
  
  public static IObjectFieldAccessor<UITransferRecordItem,Integer> SourceQuantityAccessor = new IObjectFieldAccessor<UITransferRecordItem,Integer>(){
    				public Integer getValue(UITransferRecordItem object){
    					return object.getSourceQuantity();
    				}
    				public void setValue(UITransferRecordItem object,Integer value){
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
  
  public static IObjectFieldAccessor<UITransferRecordItem,String> ProductSidAccessor = new IObjectFieldAccessor<UITransferRecordItem,String>(){
    				public String getValue(UITransferRecordItem object){
    					return object.getProductSid();
    				}
    				public void setValue(UITransferRecordItem object,String value){
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
  
  public static IObjectFieldAccessor<UITransferRecordItem,String> TypeDescAccessor = new IObjectFieldAccessor<UITransferRecordItem,String>(){
    				public String getValue(UITransferRecordItem object){
    					return object.getTypeDesc();
    				}
    				public void setValue(UITransferRecordItem object,String value){
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
  
  public static IObjectFieldAccessor<UITransferRecordItem,Double> PriceAccessor = new IObjectFieldAccessor<UITransferRecordItem,Double>(){
    				public Double getValue(UITransferRecordItem object){
    					return object.getPrice();
    				}
    				public void setValue(UITransferRecordItem object,Double value){
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
  
  public static IObjectFieldAccessor<UITransferRecordItem,RCMaterialBrandProxy> BrandAccessor = new IObjectFieldAccessor<UITransferRecordItem,RCMaterialBrandProxy>(){
    				public com.fudanmed.platform.core.common.proxy.RCMaterialBrandProxy getValue(UITransferRecordItem object){
    					return object.getBrand();
    				}
    				public void setValue(UITransferRecordItem object,com.fudanmed.platform.core.common.proxy.RCMaterialBrandProxy value){
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
  
  public static IObjectFieldAccessor<UITransferRecordItem,RCProduceSpecificationUnitProxy> UnitAccessor = new IObjectFieldAccessor<UITransferRecordItem,RCProduceSpecificationUnitProxy>(){
    				public com.fudanmed.platform.core.warehouse.proxy.RCProduceSpecificationUnitProxy getValue(UITransferRecordItem object){
    					return object.getUnit();
    				}
    				public void setValue(UITransferRecordItem object,com.fudanmed.platform.core.warehouse.proxy.RCProduceSpecificationUnitProxy value){
    					object.setUnit(value);
    				}
    			};
  
  public RCTransferRecordItemProxy toProxy() {
    return (RCTransferRecordItemProxy)super.toProxy();
    
  }
}
