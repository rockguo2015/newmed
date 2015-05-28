package com.fudanmed.platform.core.web.shared.warehouse;

import com.google.gwt.user.client.rpc.IsSerializable;
import com.uniquesoft.gwt.shared.common.IObjectFieldAccessor;
import com.uniquesoft.gwt.shared.common.pager.IPagedCriteria;
import java.util.Collection;
import java.util.Date;

public class UIOutStockRecordCriteria implements IsSerializable, IPagedCriteria {
  private String sid;
  
  public String getSid() {
    return this.sid;
  }
  
  public void setSid(final String sid) {
    this.sid = sid;
  }
  
  public final static String P_Sid = "sid";
  
  public static IObjectFieldAccessor<UIOutStockRecordCriteria,String> SidAccessor = new IObjectFieldAccessor<UIOutStockRecordCriteria,String>(){
    				public String getValue(UIOutStockRecordCriteria object){
    					return object.getSid();
    				}
    				public void setValue(UIOutStockRecordCriteria object,String value){
    					object.setSid(value);
    				}
    			};
  
  private Date dateFrom;
  
  public Date getDateFrom() {
    return this.dateFrom;
  }
  
  public void setDateFrom(final Date dateFrom) {
    this.dateFrom = dateFrom;
  }
  
  public final static String P_DateFrom = "dateFrom";
  
  public static IObjectFieldAccessor<UIOutStockRecordCriteria,Date> DateFromAccessor = new IObjectFieldAccessor<UIOutStockRecordCriteria,Date>(){
    				public java.util.Date getValue(UIOutStockRecordCriteria object){
    					return object.getDateFrom();
    				}
    				public void setValue(UIOutStockRecordCriteria object,java.util.Date value){
    					object.setDateFrom(value);
    				}
    			};
  
  private Date dateTo;
  
  public Date getDateTo() {
    return this.dateTo;
  }
  
  public void setDateTo(final Date dateTo) {
    this.dateTo = dateTo;
  }
  
  public final static String P_DateTo = "dateTo";
  
  public static IObjectFieldAccessor<UIOutStockRecordCriteria,Date> DateToAccessor = new IObjectFieldAccessor<UIOutStockRecordCriteria,Date>(){
    				public java.util.Date getValue(UIOutStockRecordCriteria object){
    					return object.getDateTo();
    				}
    				public void setValue(UIOutStockRecordCriteria object,java.util.Date value){
    					object.setDateTo(value);
    				}
    			};
  
  private Collection<?> stores;
  
  public Collection<?> getStores() {
    return this.stores;
  }
  
  public void setStores(final Collection<?> stores) {
    this.stores = stores;
  }
  
  public final static String P_Stores = "stores";
  
  public static IObjectFieldAccessor<UIOutStockRecordCriteria,Collection<?>> StoresAccessor = new IObjectFieldAccessor<UIOutStockRecordCriteria,Collection<?>>(){
    				public java.util.Collection<?> getValue(UIOutStockRecordCriteria object){
    					return object.getStores();
    				}
    				public void setValue(UIOutStockRecordCriteria object,java.util.Collection<?> value){
    					object.setStores(value);
    				}
    			};
  
  private Integer page;
  
  public Integer getPage() {
    return this.page;
  }
  
  public void setPage(final Integer page) {
    this.page = page;
  }
  
  private Integer pageSize;
  
  public Integer getPageSize() {
    return this.pageSize;
  }
  
  public void setPageSize(final Integer pageSize) {
    this.pageSize = pageSize;
  }
}
