package com.lanmon.business.shared.event;

import com.google.gwt.user.client.rpc.IsSerializable;
import com.uniquesoft.gwt.shared.GWTNamedEntity;
import com.uniquesoft.gwt.shared.common.IObjectFieldAccessor;
import com.uniquesoft.gwt.shared.common.pager.IPagedCriteria;
import com.uniquesoft.gwt.shared.datatype.DateRange;

public class GWTEventCriteria implements IsSerializable, IPagedCriteria {
  private String message;
  
  public String getMessage() {
    return this.message;
  }
  
  public void setMessage(final String message) {
    this.message = message;
  }
  
  public final static String P_Message = "message";
  
  public static IObjectFieldAccessor<GWTEventCriteria,String> MessageAccessor = new IObjectFieldAccessor<GWTEventCriteria,String>(){
    				public String getValue(GWTEventCriteria object){
    					return object.getMessage();
    				}
    				public void setValue(GWTEventCriteria object,String value){
    					object.setMessage(value);
    				}
    			};
  
  private DateRange dateRange;
  
  public DateRange getDateRange() {
    return this.dateRange;
  }
  
  public void setDateRange(final DateRange dateRange) {
    this.dateRange = dateRange;
  }
  
  public final static String P_DateRange = "dateRange";
  
  public static IObjectFieldAccessor<GWTEventCriteria,DateRange> DateRangeAccessor = new IObjectFieldAccessor<GWTEventCriteria,DateRange>(){
    				public DateRange getValue(GWTEventCriteria object){
    					return object.getDateRange();
    				}
    				public void setValue(GWTEventCriteria object,DateRange value){
    					object.setDateRange(value);
    				}
    			};
  
  private GWTNamedEntity customer;
  
  public GWTNamedEntity getCustomer() {
    return this.customer;
  }
  
  public void setCustomer(final GWTNamedEntity customer) {
    this.customer = customer;
  }
  
  public final static String P_Customer = "customer";
  
  public static IObjectFieldAccessor<GWTEventCriteria,GWTNamedEntity> CustomerAccessor = new IObjectFieldAccessor<GWTEventCriteria,GWTNamedEntity>(){
    				public GWTNamedEntity getValue(GWTEventCriteria object){
    					return object.getCustomer();
    				}
    				public void setValue(GWTEventCriteria object,GWTNamedEntity value){
    					object.setCustomer(value);
    				}
    			};
  
  private Integer page;
  
  public Integer getPage() {
    return this.page;
  }
  
  public void setPage(final Integer page) {
    this.page = page;
  }
  
  public final static String P_Page = "page";
  
  public static IObjectFieldAccessor<GWTEventCriteria,Integer> PageAccessor = new IObjectFieldAccessor<GWTEventCriteria,Integer>(){
    				public Integer getValue(GWTEventCriteria object){
    					return object.getPage();
    				}
    				public void setValue(GWTEventCriteria object,Integer value){
    					object.setPage(value);
    				}
    			};
  
  private Integer pageSize;
  
  public Integer getPageSize() {
    return this.pageSize;
  }
  
  public void setPageSize(final Integer pageSize) {
    this.pageSize = pageSize;
  }
  
  public final static String P_PageSize = "pageSize";
  
  public static IObjectFieldAccessor<GWTEventCriteria,Integer> PageSizeAccessor = new IObjectFieldAccessor<GWTEventCriteria,Integer>(){
    				public Integer getValue(GWTEventCriteria object){
    					return object.getPageSize();
    				}
    				public void setValue(GWTEventCriteria object,Integer value){
    					object.setPageSize(value);
    				}
    			};
}
