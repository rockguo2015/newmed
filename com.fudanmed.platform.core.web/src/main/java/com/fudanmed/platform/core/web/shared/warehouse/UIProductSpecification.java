package com.fudanmed.platform.core.web.shared.warehouse;

import com.fudanmed.platform.core.common.proxy.RCMaterialBrandProxy;
import com.fudanmed.platform.core.domain.proxy.RCSupplierProxy;
import com.fudanmed.platform.core.warehouse.proxy.RCProduceSpecificationUnitProxy;
import com.fudanmed.platform.core.warehouse.proxy.RCProductSpecificationProxy;
import com.fudanmed.platform.core.warehouse.proxy.RCProductTypeProxy;
import com.uniquesoft.gwt.shared.GWTEntity;
import com.uniquesoft.gwt.shared.common.IObjectFieldAccessor;

public class UIProductSpecification extends GWTEntity {
  private String sid;
  
  public String getSid() {
    return this.sid;
  }
  
  public void setSid(final String sid) {
    this.sid = sid;
  }
  
  public final static String P_Sid = "sid";
  
  public static IObjectFieldAccessor<UIProductSpecification,String> SidAccessor = new IObjectFieldAccessor<UIProductSpecification,String>(){
    				public String getValue(UIProductSpecification object){
    					return object.getSid();
    				}
    				public void setValue(UIProductSpecification object,String value){
    					object.setSid(value);
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
  
  public static IObjectFieldAccessor<UIProductSpecification,String> MaterialIdAccessor = new IObjectFieldAccessor<UIProductSpecification,String>(){
    				public String getValue(UIProductSpecification object){
    					return object.getMaterialId();
    				}
    				public void setValue(UIProductSpecification object,String value){
    					object.setMaterialId(value);
    				}
    			};
  
  private RCMaterialBrandProxy brandType;
  
  public RCMaterialBrandProxy getBrandType() {
    return this.brandType;
  }
  
  public void setBrandType(final RCMaterialBrandProxy brandType) {
    this.brandType = brandType;
  }
  
  public final static String P_BrandType = "brandType";
  
  public static IObjectFieldAccessor<UIProductSpecification,RCMaterialBrandProxy> BrandTypeAccessor = new IObjectFieldAccessor<UIProductSpecification,RCMaterialBrandProxy>(){
    				public com.fudanmed.platform.core.common.proxy.RCMaterialBrandProxy getValue(UIProductSpecification object){
    					return object.getBrandType();
    				}
    				public void setValue(UIProductSpecification object,com.fudanmed.platform.core.common.proxy.RCMaterialBrandProxy value){
    					object.setBrandType(value);
    				}
    			};
  
  private Double referencePrice;
  
  public Double getReferencePrice() {
    return this.referencePrice;
  }
  
  public void setReferencePrice(final Double referencePrice) {
    this.referencePrice = referencePrice;
  }
  
  public final static String P_ReferencePrice = "referencePrice";
  
  public static IObjectFieldAccessor<UIProductSpecification,Double> ReferencePriceAccessor = new IObjectFieldAccessor<UIProductSpecification,Double>(){
    				public Double getValue(UIProductSpecification object){
    					return object.getReferencePrice();
    				}
    				public void setValue(UIProductSpecification object,Double value){
    					object.setReferencePrice(value);
    				}
    			};
  
  private Integer shelfLife;
  
  public Integer getShelfLife() {
    return this.shelfLife;
  }
  
  public void setShelfLife(final Integer shelfLife) {
    this.shelfLife = shelfLife;
  }
  
  public final static String P_ShelfLife = "shelfLife";
  
  public static IObjectFieldAccessor<UIProductSpecification,Integer> ShelfLifeAccessor = new IObjectFieldAccessor<UIProductSpecification,Integer>(){
    				public Integer getValue(UIProductSpecification object){
    					return object.getShelfLife();
    				}
    				public void setValue(UIProductSpecification object,Integer value){
    					object.setShelfLife(value);
    				}
    			};
  
  private Integer lowerStorage;
  
  public Integer getLowerStorage() {
    return this.lowerStorage;
  }
  
  public void setLowerStorage(final Integer lowerStorage) {
    this.lowerStorage = lowerStorage;
  }
  
  public final static String P_LowerStorage = "lowerStorage";
  
  public static IObjectFieldAccessor<UIProductSpecification,Integer> LowerStorageAccessor = new IObjectFieldAccessor<UIProductSpecification,Integer>(){
    				public Integer getValue(UIProductSpecification object){
    					return object.getLowerStorage();
    				}
    				public void setValue(UIProductSpecification object,Integer value){
    					object.setLowerStorage(value);
    				}
    			};
  
  private Integer upperStorage;
  
  public Integer getUpperStorage() {
    return this.upperStorage;
  }
  
  public void setUpperStorage(final Integer upperStorage) {
    this.upperStorage = upperStorage;
  }
  
  public final static String P_UpperStorage = "upperStorage";
  
  public static IObjectFieldAccessor<UIProductSpecification,Integer> UpperStorageAccessor = new IObjectFieldAccessor<UIProductSpecification,Integer>(){
    				public Integer getValue(UIProductSpecification object){
    					return object.getUpperStorage();
    				}
    				public void setValue(UIProductSpecification object,Integer value){
    					object.setUpperStorage(value);
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
  
  public static IObjectFieldAccessor<UIProductSpecification,String> NameAccessor = new IObjectFieldAccessor<UIProductSpecification,String>(){
    				public String getValue(UIProductSpecification object){
    					return object.getName();
    				}
    				public void setValue(UIProductSpecification object,String value){
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
  
  public static IObjectFieldAccessor<UIProductSpecification,String> TypeDescAccessor = new IObjectFieldAccessor<UIProductSpecification,String>(){
    				public String getValue(UIProductSpecification object){
    					return object.getTypeDesc();
    				}
    				public void setValue(UIProductSpecification object,String value){
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
  
  public static IObjectFieldAccessor<UIProductSpecification,RCProduceSpecificationUnitProxy> UnitAccessor = new IObjectFieldAccessor<UIProductSpecification,RCProduceSpecificationUnitProxy>(){
    				public com.fudanmed.platform.core.warehouse.proxy.RCProduceSpecificationUnitProxy getValue(UIProductSpecification object){
    					return object.getUnit();
    				}
    				public void setValue(UIProductSpecification object,com.fudanmed.platform.core.warehouse.proxy.RCProduceSpecificationUnitProxy value){
    					object.setUnit(value);
    				}
    			};
  
  private RCProductTypeProxy productType;
  
  public RCProductTypeProxy getProductType() {
    return this.productType;
  }
  
  public void setProductType(final RCProductTypeProxy productType) {
    this.productType = productType;
  }
  
  public final static String P_ProductType = "productType";
  
  public static IObjectFieldAccessor<UIProductSpecification,RCProductTypeProxy> ProductTypeAccessor = new IObjectFieldAccessor<UIProductSpecification,RCProductTypeProxy>(){
    				public com.fudanmed.platform.core.warehouse.proxy.RCProductTypeProxy getValue(UIProductSpecification object){
    					return object.getProductType();
    				}
    				public void setValue(UIProductSpecification object,com.fudanmed.platform.core.warehouse.proxy.RCProductTypeProxy value){
    					object.setProductType(value);
    				}
    			};
  
  private RCSupplierProxy defaultSupplier;
  
  public RCSupplierProxy getDefaultSupplier() {
    return this.defaultSupplier;
  }
  
  public void setDefaultSupplier(final RCSupplierProxy defaultSupplier) {
    this.defaultSupplier = defaultSupplier;
  }
  
  public final static String P_DefaultSupplier = "defaultSupplier";
  
  public static IObjectFieldAccessor<UIProductSpecification,RCSupplierProxy> DefaultSupplierAccessor = new IObjectFieldAccessor<UIProductSpecification,RCSupplierProxy>(){
    				public com.fudanmed.platform.core.domain.proxy.RCSupplierProxy getValue(UIProductSpecification object){
    					return object.getDefaultSupplier();
    				}
    				public void setValue(UIProductSpecification object,com.fudanmed.platform.core.domain.proxy.RCSupplierProxy value){
    					object.setDefaultSupplier(value);
    				}
    			};
  
  public RCProductSpecificationProxy toProxy() {
    return (RCProductSpecificationProxy)super.toProxy();
    
  }
}
