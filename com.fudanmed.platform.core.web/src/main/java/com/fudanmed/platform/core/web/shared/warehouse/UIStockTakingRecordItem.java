package com.fudanmed.platform.core.web.shared.warehouse;

import com.fudanmed.platform.core.warehouse.proxy.RCProduceSpecificationUnitProxy;
import com.fudanmed.platform.core.warehouse.proxy.RCProductSpecificationProxy;
import com.fudanmed.platform.core.warehouse.proxy.RCStockTakingRecordItemProxy;
import com.fudanmed.platform.core.warehouse.proxy.RCWarehouseProxy;
import com.uniquesoft.gwt.shared.GWTEntity;
import com.uniquesoft.gwt.shared.common.IObjectFieldAccessor;

public class UIStockTakingRecordItem extends GWTEntity {
  private RCWarehouseProxy sourceStore;
  
  public RCWarehouseProxy getSourceStore() {
    return this.sourceStore;
  }
  
  public void setSourceStore(final RCWarehouseProxy sourceStore) {
    this.sourceStore = sourceStore;
  }
  
  public final static String P_SourceStore = "sourceStore";
  
  public static IObjectFieldAccessor<UIStockTakingRecordItem,RCWarehouseProxy> SourceStoreAccessor = new IObjectFieldAccessor<UIStockTakingRecordItem,RCWarehouseProxy>(){
    				public com.fudanmed.platform.core.warehouse.proxy.RCWarehouseProxy getValue(UIStockTakingRecordItem object){
    					return object.getSourceStore();
    				}
    				public void setValue(UIStockTakingRecordItem object,com.fudanmed.platform.core.warehouse.proxy.RCWarehouseProxy value){
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
  
  public static IObjectFieldAccessor<UIStockTakingRecordItem,RCProductSpecificationProxy> ProductSpecAccessor = new IObjectFieldAccessor<UIStockTakingRecordItem,RCProductSpecificationProxy>(){
    				public com.fudanmed.platform.core.warehouse.proxy.RCProductSpecificationProxy getValue(UIStockTakingRecordItem object){
    					return object.getProductSpec();
    				}
    				public void setValue(UIStockTakingRecordItem object,com.fudanmed.platform.core.warehouse.proxy.RCProductSpecificationProxy value){
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
  
  public static IObjectFieldAccessor<UIStockTakingRecordItem,String> SidAccessor = new IObjectFieldAccessor<UIStockTakingRecordItem,String>(){
    				public String getValue(UIStockTakingRecordItem object){
    					return object.getSid();
    				}
    				public void setValue(UIStockTakingRecordItem object,String value){
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
  
  public static IObjectFieldAccessor<UIStockTakingRecordItem,Integer> QuantityAccessor = new IObjectFieldAccessor<UIStockTakingRecordItem,Integer>(){
    				public Integer getValue(UIStockTakingRecordItem object){
    					return object.getQuantity();
    				}
    				public void setValue(UIStockTakingRecordItem object,Integer value){
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
  
  public static IObjectFieldAccessor<UIStockTakingRecordItem,String> ProductSidAccessor = new IObjectFieldAccessor<UIStockTakingRecordItem,String>(){
    				public String getValue(UIStockTakingRecordItem object){
    					return object.getProductSid();
    				}
    				public void setValue(UIStockTakingRecordItem object,String value){
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
  
  public static IObjectFieldAccessor<UIStockTakingRecordItem,String> TypeDescAccessor = new IObjectFieldAccessor<UIStockTakingRecordItem,String>(){
    				public String getValue(UIStockTakingRecordItem object){
    					return object.getTypeDesc();
    				}
    				public void setValue(UIStockTakingRecordItem object,String value){
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
  
  public static IObjectFieldAccessor<UIStockTakingRecordItem,RCProduceSpecificationUnitProxy> UnitAccessor = new IObjectFieldAccessor<UIStockTakingRecordItem,RCProduceSpecificationUnitProxy>(){
    				public com.fudanmed.platform.core.warehouse.proxy.RCProduceSpecificationUnitProxy getValue(UIStockTakingRecordItem object){
    					return object.getUnit();
    				}
    				public void setValue(UIStockTakingRecordItem object,com.fudanmed.platform.core.warehouse.proxy.RCProduceSpecificationUnitProxy value){
    					object.setUnit(value);
    				}
    			};
  
  public RCStockTakingRecordItemProxy toProxy() {
    return (RCStockTakingRecordItemProxy)super.toProxy();
    
  }
}
