package com.fudanmed.platform.core.web.shared.project;

import com.fudanmed.platform.core.common.proxy.RCFaultReportSourceProxy;
import com.fudanmed.platform.core.domain.proxy.RCOrganizationProxy;
import com.fudanmed.platform.core.web.shared.project.UIRepairTaskStatus;
import com.google.gwt.user.client.rpc.IsSerializable;
import com.uniquesoft.gwt.shared.common.IObjectFieldAccessor;
import com.uniquesoft.gwt.shared.common.pager.IPagedCriteria;
import com.uniquesoft.gwt.shared.datatype.UIDateRange;

public class UIRepairTaskCriteria implements IsSerializable, IPagedCriteria {
  private String comment;
  
  public String getComment() {
    return this.comment;
  }
  
  public void setComment(final String comment) {
    this.comment = comment;
  }
  
  public final static String P_Comment = "comment";
  
  public static IObjectFieldAccessor<UIRepairTaskCriteria,String> CommentAccessor = new IObjectFieldAccessor<UIRepairTaskCriteria,String>(){
    				public String getValue(UIRepairTaskCriteria object){
    					return object.getComment();
    				}
    				public void setValue(UIRepairTaskCriteria object,String value){
    					object.setComment(value);
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
  
  public static IObjectFieldAccessor<UIRepairTaskCriteria,Boolean> IncludeFinishedTaskAccessor = new IObjectFieldAccessor<UIRepairTaskCriteria,Boolean>(){
    				public Boolean getValue(UIRepairTaskCriteria object){
    					return object.getIncludeFinishedTask();
    				}
    				public void setValue(UIRepairTaskCriteria object,Boolean value){
    					object.setIncludeFinishedTask(value);
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
  
  public static IObjectFieldAccessor<UIRepairTaskCriteria,RCOrganizationProxy> ReportOrgAccessor = new IObjectFieldAccessor<UIRepairTaskCriteria,RCOrganizationProxy>(){
    				public com.fudanmed.platform.core.domain.proxy.RCOrganizationProxy getValue(UIRepairTaskCriteria object){
    					return object.getReportOrg();
    				}
    				public void setValue(UIRepairTaskCriteria object,com.fudanmed.platform.core.domain.proxy.RCOrganizationProxy value){
    					object.setReportOrg(value);
    				}
    			};
  
  private UIDateRange reportDateRange;
  
  public UIDateRange getReportDateRange() {
    return this.reportDateRange;
  }
  
  public void setReportDateRange(final UIDateRange reportDateRange) {
    this.reportDateRange = reportDateRange;
  }
  
  public final static String P_ReportDateRange = "reportDateRange";
  
  public static IObjectFieldAccessor<UIRepairTaskCriteria,UIDateRange> ReportDateRangeAccessor = new IObjectFieldAccessor<UIRepairTaskCriteria,UIDateRange>(){
    				public com.uniquesoft.gwt.shared.datatype.UIDateRange getValue(UIRepairTaskCriteria object){
    					return object.getReportDateRange();
    				}
    				public void setValue(UIRepairTaskCriteria object,com.uniquesoft.gwt.shared.datatype.UIDateRange value){
    					object.setReportDateRange(value);
    				}
    			};
  
  private UIRepairTaskStatus status;
  
  public UIRepairTaskStatus getStatus() {
    return this.status;
  }
  
  public void setStatus(final UIRepairTaskStatus status) {
    this.status = status;
  }
  
  public final static String P_Status = "status";
  
  public static IObjectFieldAccessor<UIRepairTaskCriteria,UIRepairTaskStatus> StatusAccessor = new IObjectFieldAccessor<UIRepairTaskCriteria,UIRepairTaskStatus>(){
    				public com.fudanmed.platform.core.web.shared.project.UIRepairTaskStatus getValue(UIRepairTaskCriteria object){
    					return object.getStatus();
    				}
    				public void setValue(UIRepairTaskCriteria object,com.fudanmed.platform.core.web.shared.project.UIRepairTaskStatus value){
    					object.setStatus(value);
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
  
  public static IObjectFieldAccessor<UIRepairTaskCriteria,RCFaultReportSourceProxy> FaultReportSourceAccessor = new IObjectFieldAccessor<UIRepairTaskCriteria,RCFaultReportSourceProxy>(){
    				public com.fudanmed.platform.core.common.proxy.RCFaultReportSourceProxy getValue(UIRepairTaskCriteria object){
    					return object.getFaultReportSource();
    				}
    				public void setValue(UIRepairTaskCriteria object,com.fudanmed.platform.core.common.proxy.RCFaultReportSourceProxy value){
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
  
  public static IObjectFieldAccessor<UIRepairTaskCriteria,String> MonthAccessor = new IObjectFieldAccessor<UIRepairTaskCriteria,String>(){
    				public String getValue(UIRepairTaskCriteria object){
    					return object.getMonth();
    				}
    				public void setValue(UIRepairTaskCriteria object,String value){
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
