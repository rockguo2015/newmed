package com.fudanmed.platform.core.web.shared.warehouse;

import com.fudanmed.platform.core.domain.proxy.RCEmployeeProxy;
import com.fudanmed.platform.core.warehouse.proxy.RCProductStoreTransactionProxy;
import com.uniquesoft.gwt.shared.GWTEntity;
import com.uniquesoft.gwt.shared.common.IObjectFieldAccessor;
import java.util.Date;

public class UIProductStoreTransaction extends GWTEntity {
  private String transactionTypeDesc;
  
  public String getTransactionTypeDesc() {
    return this.transactionTypeDesc;
  }
  
  public void setTransactionTypeDesc(final String transactionTypeDesc) {
    this.transactionTypeDesc = transactionTypeDesc;
  }
  
  public final static String P_TransactionTypeDesc = "transactionTypeDesc";
  
  public static IObjectFieldAccessor<UIProductStoreTransaction,String> TransactionTypeDescAccessor = new IObjectFieldAccessor<UIProductStoreTransaction,String>(){
    				public String getValue(UIProductStoreTransaction object){
    					return object.getTransactionTypeDesc();
    				}
    				public void setValue(UIProductStoreTransaction object,String value){
    					object.setTransactionTypeDesc(value);
    				}
    			};
  
  private String eventRecordSid;
  
  public String getEventRecordSid() {
    return this.eventRecordSid;
  }
  
  public void setEventRecordSid(final String eventRecordSid) {
    this.eventRecordSid = eventRecordSid;
  }
  
  public final static String P_EventRecordSid = "eventRecordSid";
  
  public static IObjectFieldAccessor<UIProductStoreTransaction,String> EventRecordSidAccessor = new IObjectFieldAccessor<UIProductStoreTransaction,String>(){
    				public String getValue(UIProductStoreTransaction object){
    					return object.getEventRecordSid();
    				}
    				public void setValue(UIProductStoreTransaction object,String value){
    					object.setEventRecordSid(value);
    				}
    			};
  
  private Date date;
  
  public Date getDate() {
    return this.date;
  }
  
  public void setDate(final Date date) {
    this.date = date;
  }
  
  public final static String P_Date = "date";
  
  public static IObjectFieldAccessor<UIProductStoreTransaction,Date> DateAccessor = new IObjectFieldAccessor<UIProductStoreTransaction,Date>(){
    				public java.util.Date getValue(UIProductStoreTransaction object){
    					return object.getDate();
    				}
    				public void setValue(UIProductStoreTransaction object,java.util.Date value){
    					object.setDate(value);
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
  
  public static IObjectFieldAccessor<UIProductStoreTransaction,Integer> QuantityAccessor = new IObjectFieldAccessor<UIProductStoreTransaction,Integer>(){
    				public Integer getValue(UIProductStoreTransaction object){
    					return object.getQuantity();
    				}
    				public void setValue(UIProductStoreTransaction object,Integer value){
    					object.setQuantity(value);
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
  
  public static IObjectFieldAccessor<UIProductStoreTransaction,Double> PriceAccessor = new IObjectFieldAccessor<UIProductStoreTransaction,Double>(){
    				public Double getValue(UIProductStoreTransaction object){
    					return object.getPrice();
    				}
    				public void setValue(UIProductStoreTransaction object,Double value){
    					object.setPrice(value);
    				}
    			};
  
  private RCEmployeeProxy operator;
  
  public RCEmployeeProxy getOperator() {
    return this.operator;
  }
  
  public void setOperator(final RCEmployeeProxy operator) {
    this.operator = operator;
  }
  
  public final static String P_Operator = "operator";
  
  public static IObjectFieldAccessor<UIProductStoreTransaction,RCEmployeeProxy> OperatorAccessor = new IObjectFieldAccessor<UIProductStoreTransaction,RCEmployeeProxy>(){
    				public com.fudanmed.platform.core.domain.proxy.RCEmployeeProxy getValue(UIProductStoreTransaction object){
    					return object.getOperator();
    				}
    				public void setValue(UIProductStoreTransaction object,com.fudanmed.platform.core.domain.proxy.RCEmployeeProxy value){
    					object.setOperator(value);
    				}
    			};
  
  public RCProductStoreTransactionProxy toProxy() {
    return (RCProductStoreTransactionProxy)super.toProxy();
    
  }
}
