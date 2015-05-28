package com.fudanmed.platform.core.web.shared.warehouse;

import com.fudanmed.platform.core.warehouse.proxy.RCWarehouseProxy;
import com.google.gwt.user.client.rpc.IsSerializable;
import com.uniquesoft.gwt.shared.common.IObjectFieldAccessor;
import com.uniquesoft.gwt.shared.common.pager.IPagedCriteria;
import java.util.Date;

public class UIStockTakingListCriteria implements IsSerializable, IPagedCriteria {
  private RCWarehouseProxy warehouse;
  
  public RCWarehouseProxy getWarehouse() {
    return this.warehouse;
  }
  
  public void setWarehouse(final RCWarehouseProxy warehouse) {
    this.warehouse = warehouse;
  }
  
  public final static String P_Warehouse = "warehouse";
  
  public static IObjectFieldAccessor<UIStockTakingListCriteria,RCWarehouseProxy> WarehouseAccessor = new IObjectFieldAccessor<UIStockTakingListCriteria,RCWarehouseProxy>(){
    				public com.fudanmed.platform.core.warehouse.proxy.RCWarehouseProxy getValue(UIStockTakingListCriteria object){
    					return object.getWarehouse();
    				}
    				public void setValue(UIStockTakingListCriteria object,com.fudanmed.platform.core.warehouse.proxy.RCWarehouseProxy value){
    					object.setWarehouse(value);
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
  
  public static IObjectFieldAccessor<UIStockTakingListCriteria,Date> DateFromAccessor = new IObjectFieldAccessor<UIStockTakingListCriteria,Date>(){
    				public java.util.Date getValue(UIStockTakingListCriteria object){
    					return object.getDateFrom();
    				}
    				public void setValue(UIStockTakingListCriteria object,java.util.Date value){
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
  
  public static IObjectFieldAccessor<UIStockTakingListCriteria,Date> DateToAccessor = new IObjectFieldAccessor<UIStockTakingListCriteria,Date>(){
    				public java.util.Date getValue(UIStockTakingListCriteria object){
    					return object.getDateTo();
    				}
    				public void setValue(UIStockTakingListCriteria object,java.util.Date value){
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
