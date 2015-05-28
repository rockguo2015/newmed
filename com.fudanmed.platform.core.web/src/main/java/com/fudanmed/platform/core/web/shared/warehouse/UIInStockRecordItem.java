package com.fudanmed.platform.core.web.shared.warehouse;

import com.fudanmed.platform.core.common.proxy.RCMaterialBrandProxy;
import com.fudanmed.platform.core.warehouse.proxy.RCInStockRecordItemProxy;
import com.fudanmed.platform.core.warehouse.proxy.RCProduceSpecificationUnitProxy;
import com.fudanmed.platform.core.warehouse.proxy.RCProductSpecificationProxy;
import com.fudanmed.platform.core.web.shared.warehouse.UIProductSpecification;
import com.uniquesoft.gwt.shared.GWTEntity;
import com.uniquesoft.gwt.shared.common.IObjectFieldAccessor;

public class UIInStockRecordItem extends GWTEntity {
  private String sid;
  
  public String getSid() {
    return this.sid;
  }
  
  public void setSid(final String sid) {
    this.sid = sid;
  }
  
  public final static String P_Sid = "sid";
  
  public static IObjectFieldAccessor<UIInStockRecordItem,String> SidAccessor = new IObjectFieldAccessor<UIInStockRecordItem,String>(){
    				public String getValue(UIInStockRecordItem object){
    					return object.getSid();
    				}
    				public void setValue(UIInStockRecordItem object,String value){
    					object.setSid(value);
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
  
  public static IObjectFieldAccessor<UIInStockRecordItem,RCProductSpecificationProxy> ProductSpecAccessor = new IObjectFieldAccessor<UIInStockRecordItem,RCProductSpecificationProxy>(){
    				public com.fudanmed.platform.core.warehouse.proxy.RCProductSpecificationProxy getValue(UIInStockRecordItem object){
    					return object.getProductSpec();
    				}
    				public void setValue(UIInStockRecordItem object,com.fudanmed.platform.core.warehouse.proxy.RCProductSpecificationProxy value){
    					object.setProductSpec(value);
    				}
    			};
  
  private UIProductSpecification uiProductSpec;
  
  public UIProductSpecification getUiProductSpec() {
    return this.uiProductSpec;
  }
  
  public void setUiProductSpec(final UIProductSpecification uiProductSpec) {
    this.uiProductSpec = uiProductSpec;
  }
  
  public final static String P_UiProductSpec = "uiProductSpec";
  
  public static IObjectFieldAccessor<UIInStockRecordItem,UIProductSpecification> UiProductSpecAccessor = new IObjectFieldAccessor<UIInStockRecordItem,UIProductSpecification>(){
    				public com.fudanmed.platform.core.web.shared.warehouse.UIProductSpecification getValue(UIInStockRecordItem object){
    					return object.getUiProductSpec();
    				}
    				public void setValue(UIInStockRecordItem object,com.fudanmed.platform.core.web.shared.warehouse.UIProductSpecification value){
    					object.setUiProductSpec(value);
    				}
    			};
  
  private String productSpecName;
  
  public String getProductSpecName() {
    return this.productSpecName;
  }
  
  public void setProductSpecName(final String productSpecName) {
    this.productSpecName = productSpecName;
  }
  
  public final static String P_ProductSpecName = "productSpecName";
  
  public static IObjectFieldAccessor<UIInStockRecordItem,String> ProductSpecNameAccessor = new IObjectFieldAccessor<UIInStockRecordItem,String>(){
    				public String getValue(UIInStockRecordItem object){
    					return object.getProductSpecName();
    				}
    				public void setValue(UIInStockRecordItem object,String value){
    					object.setProductSpecName(value);
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
  
  public static IObjectFieldAccessor<UIInStockRecordItem,Double> PriceAccessor = new IObjectFieldAccessor<UIInStockRecordItem,Double>(){
    				public Double getValue(UIInStockRecordItem object){
    					return object.getPrice();
    				}
    				public void setValue(UIInStockRecordItem object,Double value){
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
  
  public static IObjectFieldAccessor<UIInStockRecordItem,Integer> QuantityAccessor = new IObjectFieldAccessor<UIInStockRecordItem,Integer>(){
    				public Integer getValue(UIInStockRecordItem object){
    					return object.getQuantity();
    				}
    				public void setValue(UIInStockRecordItem object,Integer value){
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
  
  public static IObjectFieldAccessor<UIInStockRecordItem,String> ProductSidAccessor = new IObjectFieldAccessor<UIInStockRecordItem,String>(){
    				public String getValue(UIInStockRecordItem object){
    					return object.getProductSid();
    				}
    				public void setValue(UIInStockRecordItem object,String value){
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
  
  public static IObjectFieldAccessor<UIInStockRecordItem,String> MaterialIdAccessor = new IObjectFieldAccessor<UIInStockRecordItem,String>(){
    				public String getValue(UIInStockRecordItem object){
    					return object.getMaterialId();
    				}
    				public void setValue(UIInStockRecordItem object,String value){
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
  
  public static IObjectFieldAccessor<UIInStockRecordItem,RCMaterialBrandProxy> BrandAccessor = new IObjectFieldAccessor<UIInStockRecordItem,RCMaterialBrandProxy>(){
    				public com.fudanmed.platform.core.common.proxy.RCMaterialBrandProxy getValue(UIInStockRecordItem object){
    					return object.getBrand();
    				}
    				public void setValue(UIInStockRecordItem object,com.fudanmed.platform.core.common.proxy.RCMaterialBrandProxy value){
    					object.setBrand(value);
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
  
  public static IObjectFieldAccessor<UIInStockRecordItem,String> TypeDescAccessor = new IObjectFieldAccessor<UIInStockRecordItem,String>(){
    				public String getValue(UIInStockRecordItem object){
    					return object.getTypeDesc();
    				}
    				public void setValue(UIInStockRecordItem object,String value){
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
  
  public static IObjectFieldAccessor<UIInStockRecordItem,RCProduceSpecificationUnitProxy> UnitAccessor = new IObjectFieldAccessor<UIInStockRecordItem,RCProduceSpecificationUnitProxy>(){
    				public com.fudanmed.platform.core.warehouse.proxy.RCProduceSpecificationUnitProxy getValue(UIInStockRecordItem object){
    					return object.getUnit();
    				}
    				public void setValue(UIInStockRecordItem object,com.fudanmed.platform.core.warehouse.proxy.RCProduceSpecificationUnitProxy value){
    					object.setUnit(value);
    				}
    			};
  
  public RCInStockRecordItemProxy toProxy() {
    return (RCInStockRecordItemProxy)super.toProxy();
    
  }
}
