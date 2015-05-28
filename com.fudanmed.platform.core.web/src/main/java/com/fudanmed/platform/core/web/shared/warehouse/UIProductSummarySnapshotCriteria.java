package com.fudanmed.platform.core.web.shared.warehouse;

import com.fudanmed.platform.core.warehouse.proxy.RCWarehouseProxy;
import com.fudanmed.platform.core.web.shared.warehouse.UIProductSpecification;
import com.google.gwt.user.client.rpc.IsSerializable;
import com.uniquesoft.gwt.shared.common.IObjectFieldAccessor;
import com.uniquesoft.gwt.shared.common.pager.IPagedCriteria;
import java.util.Date;

public class UIProductSummarySnapshotCriteria implements IsSerializable, IPagedCriteria {
  private Date dateFrom;
  
  public Date getDateFrom() {
    return this.dateFrom;
  }
  
  public void setDateFrom(final Date dateFrom) {
    this.dateFrom = dateFrom;
  }
  
  public final static String P_DateFrom = "dateFrom";
  
  public static IObjectFieldAccessor<UIProductSummarySnapshotCriteria,Date> DateFromAccessor = new IObjectFieldAccessor<UIProductSummarySnapshotCriteria,Date>(){
    				public java.util.Date getValue(UIProductSummarySnapshotCriteria object){
    					return object.getDateFrom();
    				}
    				public void setValue(UIProductSummarySnapshotCriteria object,java.util.Date value){
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
  
  public static IObjectFieldAccessor<UIProductSummarySnapshotCriteria,Date> DateToAccessor = new IObjectFieldAccessor<UIProductSummarySnapshotCriteria,Date>(){
    				public java.util.Date getValue(UIProductSummarySnapshotCriteria object){
    					return object.getDateTo();
    				}
    				public void setValue(UIProductSummarySnapshotCriteria object,java.util.Date value){
    					object.setDateTo(value);
    				}
    			};
  
  private RCWarehouseProxy store;
  
  public RCWarehouseProxy getStore() {
    return this.store;
  }
  
  public void setStore(final RCWarehouseProxy store) {
    this.store = store;
  }
  
  public final static String P_Store = "store";
  
  public static IObjectFieldAccessor<UIProductSummarySnapshotCriteria,RCWarehouseProxy> StoreAccessor = new IObjectFieldAccessor<UIProductSummarySnapshotCriteria,RCWarehouseProxy>(){
    				public com.fudanmed.platform.core.warehouse.proxy.RCWarehouseProxy getValue(UIProductSummarySnapshotCriteria object){
    					return object.getStore();
    				}
    				public void setValue(UIProductSummarySnapshotCriteria object,com.fudanmed.platform.core.warehouse.proxy.RCWarehouseProxy value){
    					object.setStore(value);
    				}
    			};
  
  private UIProductSpecification productSpec;
  
  public UIProductSpecification getProductSpec() {
    return this.productSpec;
  }
  
  public void setProductSpec(final UIProductSpecification productSpec) {
    this.productSpec = productSpec;
  }
  
  public final static String P_ProductSpec = "productSpec";
  
  public static IObjectFieldAccessor<UIProductSummarySnapshotCriteria,UIProductSpecification> ProductSpecAccessor = new IObjectFieldAccessor<UIProductSummarySnapshotCriteria,UIProductSpecification>(){
    				public com.fudanmed.platform.core.web.shared.warehouse.UIProductSpecification getValue(UIProductSummarySnapshotCriteria object){
    					return object.getProductSpec();
    				}
    				public void setValue(UIProductSummarySnapshotCriteria object,com.fudanmed.platform.core.web.shared.warehouse.UIProductSpecification value){
    					object.setProductSpec(value);
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
