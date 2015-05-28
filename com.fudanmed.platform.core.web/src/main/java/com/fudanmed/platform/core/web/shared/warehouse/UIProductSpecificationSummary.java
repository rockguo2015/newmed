package com.fudanmed.platform.core.web.shared.warehouse;

import com.fudanmed.platform.core.warehouse.proxy.RCProduceSpecificationUnitProxy;
import com.fudanmed.platform.core.warehouse.proxy.RCProductSpecificationProxy;
import com.google.gwt.user.client.rpc.IsSerializable;
import com.uniquesoft.gwt.shared.common.IObjectFieldAccessor;

public class UIProductSpecificationSummary implements IsSerializable {
  private RCProductSpecificationProxy productSpec;
  
  public RCProductSpecificationProxy getProductSpec() {
    return this.productSpec;
  }
  
  public void setProductSpec(final RCProductSpecificationProxy productSpec) {
    this.productSpec = productSpec;
  }
  
  public final static String P_ProductSpec = "productSpec";
  
  public static IObjectFieldAccessor<UIProductSpecificationSummary,RCProductSpecificationProxy> ProductSpecAccessor = new IObjectFieldAccessor<UIProductSpecificationSummary,RCProductSpecificationProxy>(){
    				public com.fudanmed.platform.core.warehouse.proxy.RCProductSpecificationProxy getValue(UIProductSpecificationSummary object){
    					return object.getProductSpec();
    				}
    				public void setValue(UIProductSpecificationSummary object,com.fudanmed.platform.core.warehouse.proxy.RCProductSpecificationProxy value){
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
  
  public static IObjectFieldAccessor<UIProductSpecificationSummary,Integer> QuantityAccessor = new IObjectFieldAccessor<UIProductSpecificationSummary,Integer>(){
    				public Integer getValue(UIProductSpecificationSummary object){
    					return object.getQuantity();
    				}
    				public void setValue(UIProductSpecificationSummary object,Integer value){
    					object.setQuantity(value);
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
  
  public static IObjectFieldAccessor<UIProductSpecificationSummary,String> SidAccessor = new IObjectFieldAccessor<UIProductSpecificationSummary,String>(){
    				public String getValue(UIProductSpecificationSummary object){
    					return object.getSid();
    				}
    				public void setValue(UIProductSpecificationSummary object,String value){
    					object.setSid(value);
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
  
  public static IObjectFieldAccessor<UIProductSpecificationSummary,String> TypeDescAccessor = new IObjectFieldAccessor<UIProductSpecificationSummary,String>(){
    				public String getValue(UIProductSpecificationSummary object){
    					return object.getTypeDesc();
    				}
    				public void setValue(UIProductSpecificationSummary object,String value){
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
  
  public static IObjectFieldAccessor<UIProductSpecificationSummary,RCProduceSpecificationUnitProxy> UnitAccessor = new IObjectFieldAccessor<UIProductSpecificationSummary,RCProduceSpecificationUnitProxy>(){
    				public com.fudanmed.platform.core.warehouse.proxy.RCProduceSpecificationUnitProxy getValue(UIProductSpecificationSummary object){
    					return object.getUnit();
    				}
    				public void setValue(UIProductSpecificationSummary object,com.fudanmed.platform.core.warehouse.proxy.RCProduceSpecificationUnitProxy value){
    					object.setUnit(value);
    				}
    			};
}
