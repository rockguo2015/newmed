package com.fudanmed.platform.core.web.shared.project;

import com.fudanmed.platform.core.domain.proxy.RCMaintenanceTeamProxy;
import com.fudanmed.platform.core.domain.proxy.RCOrganizationProxy;
import com.google.gwt.user.client.rpc.IsSerializable;
import com.uniquesoft.gwt.shared.common.IObjectFieldAccessor;
import com.uniquesoft.gwt.shared.common.pager.IPagedCriteria;
import java.util.Date;

public class UIWorkItemStockStatisticsCriteria implements IsSerializable, IPagedCriteria {
  private Date reportDateFrom;
  
  public Date getReportDateFrom() {
    return this.reportDateFrom;
  }
  
  public void setReportDateFrom(final Date reportDateFrom) {
    this.reportDateFrom = reportDateFrom;
  }
  
  public final static String P_ReportDateFrom = "reportDateFrom";
  
  public static IObjectFieldAccessor<UIWorkItemStockStatisticsCriteria,Date> ReportDateFromAccessor = new IObjectFieldAccessor<UIWorkItemStockStatisticsCriteria,Date>(){
    				public java.util.Date getValue(UIWorkItemStockStatisticsCriteria object){
    					return object.getReportDateFrom();
    				}
    				public void setValue(UIWorkItemStockStatisticsCriteria object,java.util.Date value){
    					object.setReportDateFrom(value);
    				}
    			};
  
  private Date reportDateTo;
  
  public Date getReportDateTo() {
    return this.reportDateTo;
  }
  
  public void setReportDateTo(final Date reportDateTo) {
    this.reportDateTo = reportDateTo;
  }
  
  public final static String P_ReportDateTo = "reportDateTo";
  
  public static IObjectFieldAccessor<UIWorkItemStockStatisticsCriteria,Date> ReportDateToAccessor = new IObjectFieldAccessor<UIWorkItemStockStatisticsCriteria,Date>(){
    				public java.util.Date getValue(UIWorkItemStockStatisticsCriteria object){
    					return object.getReportDateTo();
    				}
    				public void setValue(UIWorkItemStockStatisticsCriteria object,java.util.Date value){
    					object.setReportDateTo(value);
    				}
    			};
  
  private RCMaintenanceTeamProxy team;
  
  public RCMaintenanceTeamProxy getTeam() {
    return this.team;
  }
  
  public void setTeam(final RCMaintenanceTeamProxy team) {
    this.team = team;
  }
  
  public final static String P_Team = "team";
  
  public static IObjectFieldAccessor<UIWorkItemStockStatisticsCriteria,RCMaintenanceTeamProxy> TeamAccessor = new IObjectFieldAccessor<UIWorkItemStockStatisticsCriteria,RCMaintenanceTeamProxy>(){
    				public com.fudanmed.platform.core.domain.proxy.RCMaintenanceTeamProxy getValue(UIWorkItemStockStatisticsCriteria object){
    					return object.getTeam();
    				}
    				public void setValue(UIWorkItemStockStatisticsCriteria object,com.fudanmed.platform.core.domain.proxy.RCMaintenanceTeamProxy value){
    					object.setTeam(value);
    				}
    			};
  
  private RCOrganizationProxy reportOrg;
  
  public RCOrganizationProxy getReportOrg() {
    return this.reportOrg;
  }
  
  public void setReportOrg(final RCOrganizationProxy reportOrg) {
    this.reportOrg = reportOrg;
  }
  
  public final static String P_ReportOrg = "reportOrg";
  
  public static IObjectFieldAccessor<UIWorkItemStockStatisticsCriteria,RCOrganizationProxy> ReportOrgAccessor = new IObjectFieldAccessor<UIWorkItemStockStatisticsCriteria,RCOrganizationProxy>(){
    				public com.fudanmed.platform.core.domain.proxy.RCOrganizationProxy getValue(UIWorkItemStockStatisticsCriteria object){
    					return object.getReportOrg();
    				}
    				public void setValue(UIWorkItemStockStatisticsCriteria object,com.fudanmed.platform.core.domain.proxy.RCOrganizationProxy value){
    					object.setReportOrg(value);
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
