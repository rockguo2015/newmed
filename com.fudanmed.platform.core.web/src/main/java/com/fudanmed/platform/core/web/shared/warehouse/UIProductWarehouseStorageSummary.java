package com.fudanmed.platform.core.web.shared.warehouse;

import com.fudanmed.platform.core.common.proxy.RCMaterialBrandProxy;
import com.fudanmed.platform.core.warehouse.proxy.RCProduceSpecificationUnitProxy;
import com.fudanmed.platform.core.warehouse.proxy.RCProductWarehouseStorageSummaryProxy;
import com.fudanmed.platform.core.warehouse.proxy.RCWarehouseProxy;
import com.uniquesoft.gwt.shared.GWTEntity;
import com.uniquesoft.gwt.shared.common.IObjectFieldAccessor;

public class UIProductWarehouseStorageSummary extends GWTEntity {
  private RCWarehouseProxy store;
  
  public RCWarehouseProxy getStore() {
    return this.store;
  }
  
  public void setStore(final RCWarehouseProxy store) {
    this.store = store;
  }
  
  public final static String P_Store = "store";
  
  public static IObjectFieldAccessor<UIProductWarehouseStorageSummary,RCWarehouseProxy> StoreAccessor = new IObjectFieldAccessor<UIProductWarehouseStorageSummary,RCWarehouseProxy>(){
    				public com.fudanmed.platform.core.warehouse.proxy.RCWarehouseProxy getValue(UIProductWarehouseStorageSummary object){
    					return object.getStore();
    				}
    				public void setValue(UIProductWarehouseStorageSummary object,com.fudanmed.platform.core.warehouse.proxy.RCWarehouseProxy value){
    					object.setStore(value);
    				}
    			};
  
  private String productSpecsSid;
  
  public String getProductSpecsSid() {
    return this.productSpecsSid;
  }
  
  public void setProductSpecsSid(final String productSpecsSid) {
    this.productSpecsSid = productSpecsSid;
  }
  
  public final static String P_ProductSpecsSid = "productSpecsSid";
  
  public static IObjectFieldAccessor<UIProductWarehouseStorageSummary,String> ProductSpecsSidAccessor = new IObjectFieldAccessor<UIProductWarehouseStorageSummary,String>(){
    				public String getValue(UIProductWarehouseStorageSummary object){
    					return object.getProductSpecsSid();
    				}
    				public void setValue(UIProductWarehouseStorageSummary object,String value){
    					object.setProductSpecsSid(value);
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
  
  public static IObjectFieldAccessor<UIProductWarehouseStorageSummary,String> MaterialIdAccessor = new IObjectFieldAccessor<UIProductWarehouseStorageSummary,String>(){
    				public String getValue(UIProductWarehouseStorageSummary object){
    					return object.getMaterialId();
    				}
    				public void setValue(UIProductWarehouseStorageSummary object,String value){
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
  
  public static IObjectFieldAccessor<UIProductWarehouseStorageSummary,RCMaterialBrandProxy> BrandAccessor = new IObjectFieldAccessor<UIProductWarehouseStorageSummary,RCMaterialBrandProxy>(){
    				public com.fudanmed.platform.core.common.proxy.RCMaterialBrandProxy getValue(UIProductWarehouseStorageSummary object){
    					return object.getBrand();
    				}
    				public void setValue(UIProductWarehouseStorageSummary object,com.fudanmed.platform.core.common.proxy.RCMaterialBrandProxy value){
    					object.setBrand(value);
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
  
  public static IObjectFieldAccessor<UIProductWarehouseStorageSummary,String> NameAccessor = new IObjectFieldAccessor<UIProductWarehouseStorageSummary,String>(){
    				public String getValue(UIProductWarehouseStorageSummary object){
    					return object.getName();
    				}
    				public void setValue(UIProductWarehouseStorageSummary object,String value){
    					object.setName(value);
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
  
  public static IObjectFieldAccessor<UIProductWarehouseStorageSummary,String> TypeDescAccessor = new IObjectFieldAccessor<UIProductWarehouseStorageSummary,String>(){
    				public String getValue(UIProductWarehouseStorageSummary object){
    					return object.getTypeDesc();
    				}
    				public void setValue(UIProductWarehouseStorageSummary object,String value){
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
  
  public static IObjectFieldAccessor<UIProductWarehouseStorageSummary,RCProduceSpecificationUnitProxy> UnitAccessor = new IObjectFieldAccessor<UIProductWarehouseStorageSummary,RCProduceSpecificationUnitProxy>(){
    				public com.fudanmed.platform.core.warehouse.proxy.RCProduceSpecificationUnitProxy getValue(UIProductWarehouseStorageSummary object){
    					return object.getUnit();
    				}
    				public void setValue(UIProductWarehouseStorageSummary object,com.fudanmed.platform.core.warehouse.proxy.RCProduceSpecificationUnitProxy value){
    					object.setUnit(value);
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
  
  public static IObjectFieldAccessor<UIProductWarehouseStorageSummary,Integer> QuantityAccessor = new IObjectFieldAccessor<UIProductWarehouseStorageSummary,Integer>(){
    				public Integer getValue(UIProductWarehouseStorageSummary object){
    					return object.getQuantity();
    				}
    				public void setValue(UIProductWarehouseStorageSummary object,Integer value){
    					object.setQuantity(value);
    				}
    			};
  
  public RCProductWarehouseStorageSummaryProxy toProxy() {
    return (RCProductWarehouseStorageSummaryProxy)super.toProxy();
    
  }
}
