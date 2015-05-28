package com.fudanmed.platform.core.web.shared.warehouse;

import com.fudanmed.platform.core.domain.proxy.RCEmployeeProxy;
import com.fudanmed.platform.core.domain.proxy.RCSupplierProxy;
import com.fudanmed.platform.core.warehouse.proxy.RCInStockRecordProxy;
import com.fudanmed.platform.core.warehouse.proxy.RCInStoreTypeProxy;
import com.fudanmed.platform.core.warehouse.proxy.RCWarehouseProxy;
import com.fudanmed.platform.core.web.shared.warehouse.UIInStockRecordItem;
import com.uniquesoft.gwt.shared.GWTEntity;
import com.uniquesoft.gwt.shared.common.IObjectFieldAccessor;
import java.util.Collection;
import java.util.Date;

public class UIInStockRecord extends GWTEntity {
  private RCWarehouseProxy store;
  
  public RCWarehouseProxy getStore() {
    return this.store;
  }
  
  public void setStore(final RCWarehouseProxy store) {
    this.store = store;
  }
  
  public final static String P_Store = "store";
  
  public static IObjectFieldAccessor<UIInStockRecord,RCWarehouseProxy> StoreAccessor = new IObjectFieldAccessor<UIInStockRecord,RCWarehouseProxy>(){
    				public com.fudanmed.platform.core.warehouse.proxy.RCWarehouseProxy getValue(UIInStockRecord object){
    					return object.getStore();
    				}
    				public void setValue(UIInStockRecord object,com.fudanmed.platform.core.warehouse.proxy.RCWarehouseProxy value){
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
  
  public static IObjectFieldAccessor<UIInStockRecord,String> SidAccessor = new IObjectFieldAccessor<UIInStockRecord,String>(){
    				public String getValue(UIInStockRecord object){
    					return object.getSid();
    				}
    				public void setValue(UIInStockRecord object,String value){
    					object.setSid(value);
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
  
  public static IObjectFieldAccessor<UIInStockRecord,Date> DateAccessor = new IObjectFieldAccessor<UIInStockRecord,Date>(){
    				public java.util.Date getValue(UIInStockRecord object){
    					return object.getDate();
    				}
    				public void setValue(UIInStockRecord object,java.util.Date value){
    					object.setDate(value);
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
  
  public static IObjectFieldAccessor<UIInStockRecord,RCEmployeeProxy> OperatorAccessor = new IObjectFieldAccessor<UIInStockRecord,RCEmployeeProxy>(){
    				public com.fudanmed.platform.core.domain.proxy.RCEmployeeProxy getValue(UIInStockRecord object){
    					return object.getOperator();
    				}
    				public void setValue(UIInStockRecord object,com.fudanmed.platform.core.domain.proxy.RCEmployeeProxy value){
    					object.setOperator(value);
    				}
    			};
  
  private RCInStoreTypeProxy inStoreType;
  
  public RCInStoreTypeProxy getInStoreType() {
    return this.inStoreType;
  }
  
  public void setInStoreType(final RCInStoreTypeProxy inStoreType) {
    this.inStoreType = inStoreType;
  }
  
  public final static String P_InStoreType = "inStoreType";
  
  public static IObjectFieldAccessor<UIInStockRecord,RCInStoreTypeProxy> InStoreTypeAccessor = new IObjectFieldAccessor<UIInStockRecord,RCInStoreTypeProxy>(){
    				public com.fudanmed.platform.core.warehouse.proxy.RCInStoreTypeProxy getValue(UIInStockRecord object){
    					return object.getInStoreType();
    				}
    				public void setValue(UIInStockRecord object,com.fudanmed.platform.core.warehouse.proxy.RCInStoreTypeProxy value){
    					object.setInStoreType(value);
    				}
    			};
  
  private String deliverNumber;
  
  public String getDeliverNumber() {
    return this.deliverNumber;
  }
  
  public void setDeliverNumber(final String deliverNumber) {
    this.deliverNumber = deliverNumber;
  }
  
  public final static String P_DeliverNumber = "deliverNumber";
  
  public static IObjectFieldAccessor<UIInStockRecord,String> DeliverNumberAccessor = new IObjectFieldAccessor<UIInStockRecord,String>(){
    				public String getValue(UIInStockRecord object){
    					return object.getDeliverNumber();
    				}
    				public void setValue(UIInStockRecord object,String value){
    					object.setDeliverNumber(value);
    				}
    			};
  
  private String invoiceNumber;
  
  public String getInvoiceNumber() {
    return this.invoiceNumber;
  }
  
  public void setInvoiceNumber(final String invoiceNumber) {
    this.invoiceNumber = invoiceNumber;
  }
  
  public final static String P_InvoiceNumber = "invoiceNumber";
  
  public static IObjectFieldAccessor<UIInStockRecord,String> InvoiceNumberAccessor = new IObjectFieldAccessor<UIInStockRecord,String>(){
    				public String getValue(UIInStockRecord object){
    					return object.getInvoiceNumber();
    				}
    				public void setValue(UIInStockRecord object,String value){
    					object.setInvoiceNumber(value);
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
  
  public static IObjectFieldAccessor<UIInStockRecord,String> CommentAccessor = new IObjectFieldAccessor<UIInStockRecord,String>(){
    				public String getValue(UIInStockRecord object){
    					return object.getComment();
    				}
    				public void setValue(UIInStockRecord object,String value){
    					object.setComment(value);
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
  
  public static IObjectFieldAccessor<UIInStockRecord,RCSupplierProxy> SupplierAccessor = new IObjectFieldAccessor<UIInStockRecord,RCSupplierProxy>(){
    				public com.fudanmed.platform.core.domain.proxy.RCSupplierProxy getValue(UIInStockRecord object){
    					return object.getSupplier();
    				}
    				public void setValue(UIInStockRecord object,com.fudanmed.platform.core.domain.proxy.RCSupplierProxy value){
    					object.setSupplier(value);
    				}
    			};
  
  private Boolean committed;
  
  public Boolean getCommitted() {
    return this.committed;
  }
  
  public void setCommitted(final Boolean committed) {
    this.committed = committed;
  }
  
  public final static String P_Committed = "committed";
  
  public static IObjectFieldAccessor<UIInStockRecord,Boolean> CommittedAccessor = new IObjectFieldAccessor<UIInStockRecord,Boolean>(){
    				public Boolean getValue(UIInStockRecord object){
    					return object.getCommitted();
    				}
    				public void setValue(UIInStockRecord object,Boolean value){
    					object.setCommitted(value);
    				}
    			};
  
  private Boolean saveOnly;
  
  public Boolean getSaveOnly() {
    return this.saveOnly;
  }
  
  public void setSaveOnly(final Boolean saveOnly) {
    this.saveOnly = saveOnly;
  }
  
  public final static String P_SaveOnly = "saveOnly";
  
  public static IObjectFieldAccessor<UIInStockRecord,Boolean> SaveOnlyAccessor = new IObjectFieldAccessor<UIInStockRecord,Boolean>(){
    				public Boolean getValue(UIInStockRecord object){
    					return object.getSaveOnly();
    				}
    				public void setValue(UIInStockRecord object,Boolean value){
    					object.setSaveOnly(value);
    				}
    			};
  
  private Boolean print;
  
  public Boolean getPrint() {
    return this.print;
  }
  
  public void setPrint(final Boolean print) {
    this.print = print;
  }
  
  public final static String P_Print = "print";
  
  public static IObjectFieldAccessor<UIInStockRecord,Boolean> PrintAccessor = new IObjectFieldAccessor<UIInStockRecord,Boolean>(){
    				public Boolean getValue(UIInStockRecord object){
    					return object.getPrint();
    				}
    				public void setValue(UIInStockRecord object,Boolean value){
    					object.setPrint(value);
    				}
    			};
  
  private Collection<UIInStockRecordItem> items = com.google.common.collect.Lists.newArrayList();
  
  public Collection<UIInStockRecordItem> getItems() {
    return this.items;
  }
  
  public void setItems(final Collection<UIInStockRecordItem> items) {
    this.items = items;
  }
  
  public final static String P_Items = "items";
  
  public static IObjectFieldAccessor<UIInStockRecord,Collection<UIInStockRecordItem>> ItemsAccessor = new IObjectFieldAccessor<UIInStockRecord,Collection<UIInStockRecordItem>>(){
    				public java.util.Collection<com.fudanmed.platform.core.web.shared.warehouse.UIInStockRecordItem> getValue(UIInStockRecord object){
    					return object.getItems();
    				}
    				public void setValue(UIInStockRecord object,java.util.Collection<com.fudanmed.platform.core.web.shared.warehouse.UIInStockRecordItem> value){
    					object.setItems(value);
    				}
    			};
  
  public RCInStockRecordProxy toProxy() {
    return (RCInStockRecordProxy)super.toProxy();
    
  }
}
