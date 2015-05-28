package com.fudanmed.platform.core.web.shared.warehouse;

import com.fudanmed.platform.core.warehouse.proxy.RCWarehouseProxy;
import com.google.gwt.user.client.rpc.IsSerializable;
import com.uniquesoft.gwt.shared.common.IObjectFieldAccessor;
import com.uniquesoft.gwt.shared.common.pager.IPagedCriteria;
import java.util.Date;

public class UITransferRecordCriteria implements IsSerializable, IPagedCriteria {
  private RCWarehouseProxy targetStore;
  
  public RCWarehouseProxy getTargetStore() {
    return this.targetStore;
  }
  
  public void setTargetStore(final RCWarehouseProxy targetStore) {
    this.targetStore = targetStore;
  }
  
  public final static String P_TargetStore = "targetStore";
  
  public static IObjectFieldAccessor<UITransferRecordCriteria,RCWarehouseProxy> TargetStoreAccessor = new IObjectFieldAccessor<UITransferRecordCriteria,RCWarehouseProxy>(){
    				public com.fudanmed.platform.core.warehouse.proxy.RCWarehouseProxy getValue(UITransferRecordCriteria object){
    					return object.getTargetStore();
    				}
    				public void setValue(UITransferRecordCriteria object,com.fudanmed.platform.core.warehouse.proxy.RCWarehouseProxy value){
    					object.setTargetStore(value);
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
  
  public static IObjectFieldAccessor<UITransferRecordCriteria,Date> DateFromAccessor = new IObjectFieldAccessor<UITransferRecordCriteria,Date>(){
    				public java.util.Date getValue(UITransferRecordCriteria object){
    					return object.getDateFrom();
    				}
    				public void setValue(UITransferRecordCriteria object,java.util.Date value){
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
  
  public static IObjectFieldAccessor<UITransferRecordCriteria,Date> DateToAccessor = new IObjectFieldAccessor<UITransferRecordCriteria,Date>(){
    				public java.util.Date getValue(UITransferRecordCriteria object){
    					return object.getDateTo();
    				}
    				public void setValue(UITransferRecordCriteria object,java.util.Date value){
    					object.setDateTo(value);
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
