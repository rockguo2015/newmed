package com.fudanmed.platform.core.web.shared.warehouse;

import com.fudanmed.platform.core.common.proxy.RCMaterialBrandProxy;
import com.fudanmed.platform.core.warehouse.proxy.RCProduceSpecificationUnitProxy;
import com.fudanmed.platform.core.warehouse.proxy.RCProductSpecificationProxy;
import com.fudanmed.platform.core.warehouse.proxy.RCStockTakingItemProxy;
import com.uniquesoft.gwt.shared.GWTEntity;
import com.uniquesoft.gwt.shared.common.IObjectFieldAccessor;

public class UIStockTakingItem extends GWTEntity {
  private RCProductSpecificationProxy productSpec;
  
  public RCProductSpecificationProxy getProductSpec() {
    return this.productSpec;
  }
  
  public void setProductSpec(final RCProductSpecificationProxy productSpec) {
    this.productSpec = productSpec;
  }
  
  public final static String P_ProductSpec = "productSpec";
  
  public static IObjectFieldAccessor<UIStockTakingItem,RCProductSpecificationProxy> ProductSpecAccessor = new IObjectFieldAccessor<UIStockTakingItem,RCProductSpecificationProxy>(){
    				public com.fudanmed.platform.core.warehouse.proxy.RCProductSpecificationProxy getValue(UIStockTakingItem object){
    					return object.getProductSpec();
    				}
    				public void setValue(UIStockTakingItem object,com.fudanmed.platform.core.warehouse.proxy.RCProductSpecificationProxy value){
    					object.setProductSpec(value);
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
  
  public static IObjectFieldAccessor<UIStockTakingItem,Integer> QuantityAccessor = new IObjectFieldAccessor<UIStockTakingItem,Integer>(){
    				public Integer getValue(UIStockTakingItem object){
    					return object.getQuantity();
    				}
    				public void setValue(UIStockTakingItem object,Integer value){
    					object.setQuantity(value);
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
  
  public static IObjectFieldAccessor<UIStockTakingItem,String> ProductSpecsSidAccessor = new IObjectFieldAccessor<UIStockTakingItem,String>(){
    				public String getValue(UIStockTakingItem object){
    					return object.getProductSpecsSid();
    				}
    				public void setValue(UIStockTakingItem object,String value){
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
  
  public static IObjectFieldAccessor<UIStockTakingItem,String> MaterialIdAccessor = new IObjectFieldAccessor<UIStockTakingItem,String>(){
    				public String getValue(UIStockTakingItem object){
    					return object.getMaterialId();
    				}
    				public void setValue(UIStockTakingItem object,String value){
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
  
  public static IObjectFieldAccessor<UIStockTakingItem,RCMaterialBrandProxy> BrandAccessor = new IObjectFieldAccessor<UIStockTakingItem,RCMaterialBrandProxy>(){
    				public com.fudanmed.platform.core.common.proxy.RCMaterialBrandProxy getValue(UIStockTakingItem object){
    					return object.getBrand();
    				}
    				public void setValue(UIStockTakingItem object,com.fudanmed.platform.core.common.proxy.RCMaterialBrandProxy value){
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
  
  public static IObjectFieldAccessor<UIStockTakingItem,String> NameAccessor = new IObjectFieldAccessor<UIStockTakingItem,String>(){
    				public String getValue(UIStockTakingItem object){
    					return object.getName();
    				}
    				public void setValue(UIStockTakingItem object,String value){
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
  
  public static IObjectFieldAccessor<UIStockTakingItem,String> TypeDescAccessor = new IObjectFieldAccessor<UIStockTakingItem,String>(){
    				public String getValue(UIStockTakingItem object){
    					return object.getTypeDesc();
    				}
    				public void setValue(UIStockTakingItem object,String value){
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
  
  public static IObjectFieldAccessor<UIStockTakingItem,RCProduceSpecificationUnitProxy> UnitAccessor = new IObjectFieldAccessor<UIStockTakingItem,RCProduceSpecificationUnitProxy>(){
    				public com.fudanmed.platform.core.warehouse.proxy.RCProduceSpecificationUnitProxy getValue(UIStockTakingItem object){
    					return object.getUnit();
    				}
    				public void setValue(UIStockTakingItem object,com.fudanmed.platform.core.warehouse.proxy.RCProduceSpecificationUnitProxy value){
    					object.setUnit(value);
    				}
    			};
  
  private Integer realQuantity;
  
  public Integer getRealQuantity() {
    return this.realQuantity;
  }
  
  public void setRealQuantity(final Integer realQuantity) {
    this.realQuantity = realQuantity;
  }
  
  public final static String P_RealQuantity = "realQuantity";
  
  public static IObjectFieldAccessor<UIStockTakingItem,Integer> RealQuantityAccessor = new IObjectFieldAccessor<UIStockTakingItem,Integer>(){
    				public Integer getValue(UIStockTakingItem object){
    					return object.getRealQuantity();
    				}
    				public void setValue(UIStockTakingItem object,Integer value){
    					object.setRealQuantity(value);
    				}
    			};
  
  private Integer balance;
  
  public Integer getBalance() {
    return this.balance;
  }
  
  public void setBalance(final Integer balance) {
    this.balance = balance;
  }
  
  public final static String P_Balance = "balance";
  
  public static IObjectFieldAccessor<UIStockTakingItem,Integer> BalanceAccessor = new IObjectFieldAccessor<UIStockTakingItem,Integer>(){
    				public Integer getValue(UIStockTakingItem object){
    					return object.getBalance();
    				}
    				public void setValue(UIStockTakingItem object,Integer value){
    					object.setBalance(value);
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
  
  public static IObjectFieldAccessor<UIStockTakingItem,String> CommentAccessor = new IObjectFieldAccessor<UIStockTakingItem,String>(){
    				public String getValue(UIStockTakingItem object){
    					return object.getComment();
    				}
    				public void setValue(UIStockTakingItem object,String value){
    					object.setComment(value);
    				}
    			};
  
  public RCStockTakingItemProxy toProxy() {
    return (RCStockTakingItemProxy)super.toProxy();
    
  }
}
