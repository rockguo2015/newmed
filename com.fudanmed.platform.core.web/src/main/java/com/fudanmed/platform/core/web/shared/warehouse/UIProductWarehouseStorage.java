package com.fudanmed.platform.core.web.shared.warehouse;

import com.fudanmed.platform.core.domain.proxy.RCSupplierProxy;
import com.fudanmed.platform.core.warehouse.proxy.RCProduceSpecificationUnitProxy;
import com.fudanmed.platform.core.warehouse.proxy.RCProductEntryProxy;
import com.fudanmed.platform.core.warehouse.proxy.RCProductWarehouseStorageProxy;
import com.fudanmed.platform.core.warehouse.proxy.RCWarehouseProxy;
import com.uniquesoft.gwt.shared.GWTEntity;
import com.uniquesoft.gwt.shared.common.IObjectFieldAccessor;
import java.util.Date;

public class UIProductWarehouseStorage extends GWTEntity {
  private RCWarehouseProxy store;
  
  public RCWarehouseProxy getStore() {
    return this.store;
  }
  
  public void setStore(final RCWarehouseProxy store) {
    this.store = store;
  }
  
  public final static String P_Store = "store";
  
  public static IObjectFieldAccessor<UIProductWarehouseStorage,RCWarehouseProxy> StoreAccessor = new IObjectFieldAccessor<UIProductWarehouseStorage,RCWarehouseProxy>(){
    				public com.fudanmed.platform.core.warehouse.proxy.RCWarehouseProxy getValue(UIProductWarehouseStorage object){
    					return object.getStore();
    				}
    				public void setValue(UIProductWarehouseStorage object,com.fudanmed.platform.core.warehouse.proxy.RCWarehouseProxy value){
    					object.setStore(value);
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
  
  public static IObjectFieldAccessor<UIProductWarehouseStorage,String> SidAccessor = new IObjectFieldAccessor<UIProductWarehouseStorage,String>(){
    				public String getValue(UIProductWarehouseStorage object){
    					return object.getSid();
    				}
    				public void setValue(UIProductWarehouseStorage object,String value){
    					object.setSid(value);
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
  
  public static IObjectFieldAccessor<UIProductWarehouseStorage,RCProductEntryProxy> ProductEntryAccessor = new IObjectFieldAccessor<UIProductWarehouseStorage,RCProductEntryProxy>(){
    				public com.fudanmed.platform.core.warehouse.proxy.RCProductEntryProxy getValue(UIProductWarehouseStorage object){
    					return object.getProductEntry();
    				}
    				public void setValue(UIProductWarehouseStorage object,com.fudanmed.platform.core.warehouse.proxy.RCProductEntryProxy value){
    					object.setProductEntry(value);
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
  
  public static IObjectFieldAccessor<UIProductWarehouseStorage,String> ProductSpecsSidAccessor = new IObjectFieldAccessor<UIProductWarehouseStorage,String>(){
    				public String getValue(UIProductWarehouseStorage object){
    					return object.getProductSpecsSid();
    				}
    				public void setValue(UIProductWarehouseStorage object,String value){
    					object.setProductSpecsSid(value);
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
  
  public static IObjectFieldAccessor<UIProductWarehouseStorage,String> NameAccessor = new IObjectFieldAccessor<UIProductWarehouseStorage,String>(){
    				public String getValue(UIProductWarehouseStorage object){
    					return object.getName();
    				}
    				public void setValue(UIProductWarehouseStorage object,String value){
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
  
  public static IObjectFieldAccessor<UIProductWarehouseStorage,String> TypeDescAccessor = new IObjectFieldAccessor<UIProductWarehouseStorage,String>(){
    				public String getValue(UIProductWarehouseStorage object){
    					return object.getTypeDesc();
    				}
    				public void setValue(UIProductWarehouseStorage object,String value){
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
  
  public static IObjectFieldAccessor<UIProductWarehouseStorage,RCProduceSpecificationUnitProxy> UnitAccessor = new IObjectFieldAccessor<UIProductWarehouseStorage,RCProduceSpecificationUnitProxy>(){
    				public com.fudanmed.platform.core.warehouse.proxy.RCProduceSpecificationUnitProxy getValue(UIProductWarehouseStorage object){
    					return object.getUnit();
    				}
    				public void setValue(UIProductWarehouseStorage object,com.fudanmed.platform.core.warehouse.proxy.RCProduceSpecificationUnitProxy value){
    					object.setUnit(value);
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
  
  public static IObjectFieldAccessor<UIProductWarehouseStorage,Double> PriceAccessor = new IObjectFieldAccessor<UIProductWarehouseStorage,Double>(){
    				public Double getValue(UIProductWarehouseStorage object){
    					return object.getPrice();
    				}
    				public void setValue(UIProductWarehouseStorage object,Double value){
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
  
  public static IObjectFieldAccessor<UIProductWarehouseStorage,Integer> QuantityAccessor = new IObjectFieldAccessor<UIProductWarehouseStorage,Integer>(){
    				public Integer getValue(UIProductWarehouseStorage object){
    					return object.getQuantity();
    				}
    				public void setValue(UIProductWarehouseStorage object,Integer value){
    					object.setQuantity(value);
    				}
    			};
  
  private RCSupplierProxy supplier;
  
  public RCSupplierProxy getSupplier() {
    return this.supplier;
  }
  
  public void setSupplier(final RCSupplierProxy supplier) {
    this.supplier = supplier;
  }
  
  public final static String P_Supplier = "supplier";
  
  public static IObjectFieldAccessor<UIProductWarehouseStorage,RCSupplierProxy> SupplierAccessor = new IObjectFieldAccessor<UIProductWarehouseStorage,RCSupplierProxy>(){
    				public com.fudanmed.platform.core.domain.proxy.RCSupplierProxy getValue(UIProductWarehouseStorage object){
    					return object.getSupplier();
    				}
    				public void setValue(UIProductWarehouseStorage object,com.fudanmed.platform.core.domain.proxy.RCSupplierProxy value){
    					object.setSupplier(value);
    				}
    			};
  
  private Date instockDate;
  
  public Date getInstockDate() {
    return this.instockDate;
  }
  
  public void setInstockDate(final Date instockDate) {
    this.instockDate = instockDate;
  }
  
  public final static String P_InstockDate = "instockDate";
  
  public static IObjectFieldAccessor<UIProductWarehouseStorage,Date> InstockDateAccessor = new IObjectFieldAccessor<UIProductWarehouseStorage,Date>(){
    				public java.util.Date getValue(UIProductWarehouseStorage object){
    					return object.getInstockDate();
    				}
    				public void setValue(UIProductWarehouseStorage object,java.util.Date value){
    					object.setInstockDate(value);
    				}
    			};
  
  public RCProductWarehouseStorageProxy toProxy() {
    return (RCProductWarehouseStorageProxy)super.toProxy();
    
  }
}
