package com.fudanmed.platform.core.web.shared.project;

import com.fudanmed.platform.core.common.proxy.RCFaultReportSourceProxy;
import com.fudanmed.platform.core.domain.proxy.RCOrganizationProxy;
import com.fudanmed.platform.core.web.shared.project.UIGroupTaskStatus;
import com.google.gwt.user.client.rpc.IsSerializable;
import com.uniquesoft.gwt.shared.common.IObjectFieldAccessor;
import com.uniquesoft.gwt.shared.common.pager.IPagedCriteria;
import java.util.Collection;
import java.util.Date;

public class UIGroupTaskCriteria implements IsSerializable, IPagedCriteria {
  private Date dateFrom;
  
  public Date getDateFrom() {
    return this.dateFrom;
  }
  
  public void setDateFrom(final Date dateFrom) {
    this.dateFrom = dateFrom;
  }
  
  public final static String P_DateFrom = "dateFrom";
  
  public static IObjectFieldAccessor<UIGroupTaskCriteria,Date> DateFromAccessor = new IObjectFieldAccessor<UIGroupTaskCriteria,Date>(){
    				public java.util.Date getValue(UIGroupTaskCriteria object){
    					return object.getDateFrom();
    				}
    				public void setValue(UIGroupTaskCriteria object,java.util.Date value){
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
  
  public static IObjectFieldAccessor<UIGroupTaskCriteria,Date> DateToAccessor = new IObjectFieldAccessor<UIGroupTaskCriteria,Date>(){
    				public java.util.Date getValue(UIGroupTaskCriteria object){
    					return object.getDateTo();
    				}
    				public void setValue(UIGroupTaskCriteria object,java.util.Date value){
    					object.setDateTo(value);
    				}
    			};
  
  private Boolean includeFinishedTask;
  
  public Boolean getIncludeFinishedTask() {
    return this.includeFinishedTask;
  }
  
  public void setIncludeFinishedTask(final Boolean includeFinishedTask) {
    this.includeFinishedTask = includeFinishedTask;
  }
  
  public final static String P_IncludeFinishedTask = "includeFinishedTask";
  
  public static IObjectFieldAccessor<UIGroupTaskCriteria,Boolean> IncludeFinishedTaskAccessor = new IObjectFieldAccessor<UIGroupTaskCriteria,Boolean>(){
    				public Boolean getValue(UIGroupTaskCriteria object){
    					return object.getIncludeFinishedTask();
    				}
    				public void setValue(UIGroupTaskCriteria object,Boolean value){
    					object.setIncludeFinishedTask(value);
    				}
    			};
  
  private Collection<?> teams;
  
  public Collection<?> getTeams() {
    return this.teams;
  }
  
  public void setTeams(final Collection<?> teams) {
    this.teams = teams;
  }
  
  public final static String P_Teams = "teams";
  
  public static IObjectFieldAccessor<UIGroupTaskCriteria,Collection<?>> TeamsAccessor = new IObjectFieldAccessor<UIGroupTaskCriteria,Collection<?>>(){
    				public java.util.Collection<?> getValue(UIGroupTaskCriteria object){
    					return object.getTeams();
    				}
    				public void setValue(UIGroupTaskCriteria object,java.util.Collection<?> value){
    					object.setTeams(value);
    				}
    			};
  
  private UIGroupTaskStatus status;
  
  public UIGroupTaskStatus getStatus() {
    return this.status;
  }
  
  public void setStatus(final UIGroupTaskStatus status) {
    this.status = status;
  }
  
  public final static String P_Status = "status";
  
  public static IObjectFieldAccessor<UIGroupTaskCriteria,UIGroupTaskStatus> StatusAccessor = new IObjectFieldAccessor<UIGroupTaskCriteria,UIGroupTaskStatus>(){
    				public com.fudanmed.platform.core.web.shared.project.UIGroupTaskStatus getValue(UIGroupTaskCriteria object){
    					return object.getStatus();
    				}
    				public void setValue(UIGroupTaskCriteria object,com.fudanmed.platform.core.web.shared.project.UIGroupTaskStatus value){
    					object.setStatus(value);
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
  
  public static IObjectFieldAccessor<UIGroupTaskCriteria,RCOrganizationProxy> ReportOrgAccessor = new IObjectFieldAccessor<UIGroupTaskCriteria,RCOrganizationProxy>(){
    				public com.fudanmed.platform.core.domain.proxy.RCOrganizationProxy getValue(UIGroupTaskCriteria object){
    					return object.getReportOrg();
    				}
    				public void setValue(UIGroupTaskCriteria object,com.fudanmed.platform.core.domain.proxy.RCOrganizationProxy value){
    					object.setReportOrg(value);
    				}
    			};
  
  private RCFaultReportSourceProxy faultReportSource;
  
  public RCFaultReportSourceProxy getFaultReportSource() {
    return this.faultReportSource;
  }
  
  public void setFaultReportSource(final RCFaultReportSourceProxy faultReportSource) {
    this.faultReportSource = faultReportSource;
  }
  
  public final static String P_FaultReportSource = "faultReportSource";
  
  public static IObjectFieldAccessor<UIGroupTaskCriteria,RCFaultReportSourceProxy> FaultReportSourceAccessor = new IObjectFieldAccessor<UIGroupTaskCriteria,RCFaultReportSourceProxy>(){
    				public com.fudanmed.platform.core.common.proxy.RCFaultReportSourceProxy getValue(UIGroupTaskCriteria object){
    					return object.getFaultReportSource();
    				}
    				public void setValue(UIGroupTaskCriteria object,com.fudanmed.platform.core.common.proxy.RCFaultReportSourceProxy value){
    					object.setFaultReportSource(value);
    				}
    			};
  
  private String month;
  
  public String getMonth() {
    return this.month;
  }
  
  public void setMonth(final String month) {
    this.month = month;
  }
  
  public final static String P_Month = "month";
  
  public static IObjectFieldAccessor<UIGroupTaskCriteria,String> MonthAccessor = new IObjectFieldAccessor<UIGroupTaskCriteria,String>(){
    				public String getValue(UIGroupTaskCriteria object){
    					return object.getMonth();
    				}
    				public void setValue(UIGroupTaskCriteria object,String value){
    					object.setMonth(value);
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
