package com.fudanmed.platform.core.web.shared.project;

import com.fudanmed.platform.core.common.proxy.RCMaterialBrandProxy;
import com.fudanmed.platform.core.warehouse.proxy.RCProduceSpecificationUnitProxy;
import com.fudanmed.platform.core.warehouse.proxy.RCProductSpecificationProxy;
import com.fudanmed.platform.core.warehouse.proxy.RCWorkItemStorageProxy;
import com.uniquesoft.gwt.shared.GWTEntity;
import com.uniquesoft.gwt.shared.common.IObjectFieldAccessor;

public class UIWorkItemStorage4Settlement extends GWTEntity {
  private String repairTaskInfo;
  
  public String getRepairTaskInfo() {
    return this.repairTaskInfo;
  }
  
  public void setRepairTaskInfo(final String repairTaskInfo) {
    this.repairTaskInfo = repairTaskInfo;
  }
  
  public final static String P_RepairTaskInfo = "repairTaskInfo";
  
  public static IObjectFieldAccessor<UIWorkItemStorage4Settlement,String> RepairTaskInfoAccessor = new IObjectFieldAccessor<UIWorkItemStorage4Settlement,String>(){
    				public String getValue(UIWorkItemStorage4Settlement object){
    					return object.getRepairTaskInfo();
    				}
    				public void setValue(UIWorkItemStorage4Settlement object,String value){
    					object.setRepairTaskInfo(value);
    				}
    			};
  
  private String repairTaskSid;
  
  public String getRepairTaskSid() {
    return this.repairTaskSid;
  }
  
  public void setRepairTaskSid(final String repairTaskSid) {
    this.repairTaskSid = repairTaskSid;
  }
  
  public final static String P_RepairTaskSid = "repairTaskSid";
  
  public static IObjectFieldAccessor<UIWorkItemStorage4Settlement,String> RepairTaskSidAccessor = new IObjectFieldAccessor<UIWorkItemStorage4Settlement,String>(){
    				public String getValue(UIWorkItemStorage4Settlement object){
    					return object.getRepairTaskSid();
    				}
    				public void setValue(UIWorkItemStorage4Settlement object,String value){
    					object.setRepairTaskSid(value);
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
  
  public static IObjectFieldAccessor<UIWorkItemStorage4Settlement,String> SidAccessor = new IObjectFieldAccessor<UIWorkItemStorage4Settlement,String>(){
    				public String getValue(UIWorkItemStorage4Settlement object){
    					return object.getSid();
    				}
    				public void setValue(UIWorkItemStorage4Settlement object,String value){
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
  
  public static IObjectFieldAccessor<UIWorkItemStorage4Settlement,String> ProductSidAccessor = new IObjectFieldAccessor<UIWorkItemStorage4Settlement,String>(){
    				public String getValue(UIWorkItemStorage4Settlement object){
    					return object.getProductSid();
    				}
    				public void setValue(UIWorkItemStorage4Settlement object,String value){
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
  
  public static IObjectFieldAccessor<UIWorkItemStorage4Settlement,String> MaterialIdAccessor = new IObjectFieldAccessor<UIWorkItemStorage4Settlement,String>(){
    				public String getValue(UIWorkItemStorage4Settlement object){
    					return object.getMaterialId();
    				}
    				public void setValue(UIWorkItemStorage4Settlement object,String value){
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
  
  public static IObjectFieldAccessor<UIWorkItemStorage4Settlement,RCProductSpecificationProxy> ProductSpecAccessor = new IObjectFieldAccessor<UIWorkItemStorage4Settlement,RCProductSpecificationProxy>(){
    				public com.fudanmed.platform.core.warehouse.proxy.RCProductSpecificationProxy getValue(UIWorkItemStorage4Settlement object){
    					return object.getProductSpec();
    				}
    				public void setValue(UIWorkItemStorage4Settlement object,com.fudanmed.platform.core.warehouse.proxy.RCProductSpecificationProxy value){
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
  
  public static IObjectFieldAccessor<UIWorkItemStorage4Settlement,String> TypeDescAccessor = new IObjectFieldAccessor<UIWorkItemStorage4Settlement,String>(){
    				public String getValue(UIWorkItemStorage4Settlement object){
    					return object.getTypeDesc();
    				}
    				public void setValue(UIWorkItemStorage4Settlement object,String value){
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
  
  public static IObjectFieldAccessor<UIWorkItemStorage4Settlement,RCMaterialBrandProxy> BrandAccessor = new IObjectFieldAccessor<UIWorkItemStorage4Settlement,RCMaterialBrandProxy>(){
    				public com.fudanmed.platform.core.common.proxy.RCMaterialBrandProxy getValue(UIWorkItemStorage4Settlement object){
    					return object.getBrand();
    				}
    				public void setValue(UIWorkItemStorage4Settlement object,com.fudanmed.platform.core.common.proxy.RCMaterialBrandProxy value){
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
  
  public static IObjectFieldAccessor<UIWorkItemStorage4Settlement,Double> PriceAccessor = new IObjectFieldAccessor<UIWorkItemStorage4Settlement,Double>(){
    				public Double getValue(UIWorkItemStorage4Settlement object){
    					return object.getPrice();
    				}
    				public void setValue(UIWorkItemStorage4Settlement object,Double value){
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
  
  public static IObjectFieldAccessor<UIWorkItemStorage4Settlement,Integer> QuantityAccessor = new IObjectFieldAccessor<UIWorkItemStorage4Settlement,Integer>(){
    				public Integer getValue(UIWorkItemStorage4Settlement object){
    					return object.getQuantity();
    				}
    				public void setValue(UIWorkItemStorage4Settlement object,Integer value){
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
  
  public static IObjectFieldAccessor<UIWorkItemStorage4Settlement,RCProduceSpecificationUnitProxy> UnitAccessor = new IObjectFieldAccessor<UIWorkItemStorage4Settlement,RCProduceSpecificationUnitProxy>(){
    				public com.fudanmed.platform.core.warehouse.proxy.RCProduceSpecificationUnitProxy getValue(UIWorkItemStorage4Settlement object){
    					return object.getUnit();
    				}
    				public void setValue(UIWorkItemStorage4Settlement object,com.fudanmed.platform.core.warehouse.proxy.RCProduceSpecificationUnitProxy value){
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
  
  public static IObjectFieldAccessor<UIWorkItemStorage4Settlement,Double> AmountAccessor = new IObjectFieldAccessor<UIWorkItemStorage4Settlement,Double>(){
    				public Double getValue(UIWorkItemStorage4Settlement object){
    					return object.getAmount();
    				}
    				public void setValue(UIWorkItemStorage4Settlement object,Double value){
    					object.setAmount(value);
    				}
    			};
  
  public RCWorkItemStorageProxy toProxy() {
    return (RCWorkItemStorageProxy)super.toProxy();
    
  }
}
