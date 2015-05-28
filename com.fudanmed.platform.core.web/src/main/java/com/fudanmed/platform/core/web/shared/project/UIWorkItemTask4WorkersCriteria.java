package com.fudanmed.platform.core.web.shared.project;

import com.fudanmed.platform.core.domain.proxy.RCMaintenanceTeamProxy;
import com.google.gwt.user.client.rpc.IsSerializable;
import com.uniquesoft.gwt.shared.common.IObjectFieldAccessor;
import com.uniquesoft.gwt.shared.common.pager.IPagedCriteria;
import java.util.Date;

public class UIWorkItemTask4WorkersCriteria implements IsSerializable, IPagedCriteria {
  private Date dateFrom;
  
  public Date getDateFrom() {
    return this.dateFrom;
  }
  
  public void setDateFrom(final Date dateFrom) {
    this.dateFrom = dateFrom;
  }
  
  public final static String P_DateFrom = "dateFrom";
  
  public static IObjectFieldAccessor<UIWorkItemTask4WorkersCriteria,Date> DateFromAccessor = new IObjectFieldAccessor<UIWorkItemTask4WorkersCriteria,Date>(){
    				public java.util.Date getValue(UIWorkItemTask4WorkersCriteria object){
    					return object.getDateFrom();
    				}
    				public void setValue(UIWorkItemTask4WorkersCriteria object,java.util.Date value){
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
  
  public static IObjectFieldAccessor<UIWorkItemTask4WorkersCriteria,Date> DateToAccessor = new IObjectFieldAccessor<UIWorkItemTask4WorkersCriteria,Date>(){
    				public java.util.Date getValue(UIWorkItemTask4WorkersCriteria object){
    					return object.getDateTo();
    				}
    				public void setValue(UIWorkItemTask4WorkersCriteria object,java.util.Date value){
    					object.setDateTo(value);
    				}
    			};
  
  private RCMaintenanceTeamProxy department;
  
  public RCMaintenanceTeamProxy getDepartment() {
    return this.department;
  }
  
  public void setDepartment(final RCMaintenanceTeamProxy department) {
    this.department = department;
  }
  
  public final static String P_Department = "department";
  
  public static IObjectFieldAccessor<UIWorkItemTask4WorkersCriteria,RCMaintenanceTeamProxy> DepartmentAccessor = new IObjectFieldAccessor<UIWorkItemTask4WorkersCriteria,RCMaintenanceTeamProxy>(){
    				public com.fudanmed.platform.core.domain.proxy.RCMaintenanceTeamProxy getValue(UIWorkItemTask4WorkersCriteria object){
    					return object.getDepartment();
    				}
    				public void setValue(UIWorkItemTask4WorkersCriteria object,com.fudanmed.platform.core.domain.proxy.RCMaintenanceTeamProxy value){
    					object.setDepartment(value);
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
