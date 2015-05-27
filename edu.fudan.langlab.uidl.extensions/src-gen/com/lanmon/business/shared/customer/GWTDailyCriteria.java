package com.lanmon.business.shared.customer;

import com.google.gwt.user.client.rpc.IsSerializable;
import com.uniquesoft.gwt.shared.GWTNamedEntity;
import com.uniquesoft.gwt.shared.common.IObjectFieldAccessor;
import com.uniquesoft.gwt.shared.common.pager.IPagedCriteria;
import com.uniquesoft.gwt.shared.datatype.DateRange;

public class GWTDailyCriteria implements IsSerializable, IPagedCriteria {
  private GWTNamedEntity employee;
  
  public GWTNamedEntity getEmployee() {
    return this.employee;
  }
  
  public void setEmployee(final GWTNamedEntity employee) {
    this.employee = employee;
  }
  
  public final static String P_Employee = "employee";
  
  public static IObjectFieldAccessor<GWTDailyCriteria,GWTNamedEntity> EmployeeAccessor = new IObjectFieldAccessor<GWTDailyCriteria,GWTNamedEntity>(){
    				public GWTNamedEntity getValue(GWTDailyCriteria object){
    					return object.getEmployee();
    				}
    				public void setValue(GWTDailyCriteria object,GWTNamedEntity value){
    					object.setEmployee(value);
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
  
  public static IObjectFieldAccessor<GWTDailyCriteria,DateRange> DateRangeAccessor = new IObjectFieldAccessor<GWTDailyCriteria,DateRange>(){
    				public DateRange getValue(GWTDailyCriteria object){
    					return object.getDateRange();
    				}
    				public void setValue(GWTDailyCriteria object,DateRange value){
    					object.setDateRange(value);
    				}
    			};
  
  private String note;
  
  public String getNote() {
    return this.note;
  }
  
  public void setNote(final String note) {
    this.note = note;
  }
  
  public final static String P_Note = "note";
  
  public static IObjectFieldAccessor<GWTDailyCriteria,String> NoteAccessor = new IObjectFieldAccessor<GWTDailyCriteria,String>(){
    				public String getValue(GWTDailyCriteria object){
    					return object.getNote();
    				}
    				public void setValue(GWTDailyCriteria object,String value){
    					object.setNote(value);
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
  
  public static IObjectFieldAccessor<GWTDailyCriteria,Integer> PageAccessor = new IObjectFieldAccessor<GWTDailyCriteria,Integer>(){
    				public Integer getValue(GWTDailyCriteria object){
    					return object.getPage();
    				}
    				public void setValue(GWTDailyCriteria object,Integer value){
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
  
  public static IObjectFieldAccessor<GWTDailyCriteria,Integer> PageSizeAccessor = new IObjectFieldAccessor<GWTDailyCriteria,Integer>(){
    				public Integer getValue(GWTDailyCriteria object){
    					return object.getPageSize();
    				}
    				public void setValue(GWTDailyCriteria object,Integer value){
    					object.setPageSize(value);
    				}
    			};
}
