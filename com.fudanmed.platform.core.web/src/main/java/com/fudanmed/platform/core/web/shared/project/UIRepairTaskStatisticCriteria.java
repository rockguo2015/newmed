package com.fudanmed.platform.core.web.shared.project;

import com.fudanmed.platform.core.domain.proxy.RCEmployeeProxy;
import com.fudanmed.platform.core.domain.proxy.RCMaintenanceTeamProxy;
import com.fudanmed.platform.core.domain.proxy.RCOrganizationProxy;
import com.fudanmed.platform.core.web.shared.project.UIRepairTaskStatus;
import com.google.gwt.user.client.rpc.IsSerializable;
import com.uniquesoft.gwt.shared.common.IObjectFieldAccessor;
import com.uniquesoft.gwt.shared.common.pager.IPagedCriteria;
import com.uniquesoft.gwt.shared.datatype.UIDateRange;

public class UIRepairTaskStatisticCriteria implements IsSerializable, IPagedCriteria {
  private RCOrganizationProxy reportOrg;
  
  public RCOrganizationProxy getReportOrg() {
    return this.reportOrg;
  }
  
  public void setReportOrg(final RCOrganizationProxy reportOrg) {
    this.reportOrg = reportOrg;
  }
  
  public final static String P_ReportOrg = "reportOrg";
  
  public static IObjectFieldAccessor<UIRepairTaskStatisticCriteria,RCOrganizationProxy> ReportOrgAccessor = new IObjectFieldAccessor<UIRepairTaskStatisticCriteria,RCOrganizationProxy>(){
    				public com.fudanmed.platform.core.domain.proxy.RCOrganizationProxy getValue(UIRepairTaskStatisticCriteria object){
    					return object.getReportOrg();
    				}
    				public void setValue(UIRepairTaskStatisticCriteria object,com.fudanmed.platform.core.domain.proxy.RCOrganizationProxy value){
    					object.setReportOrg(value);
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
  
  public static IObjectFieldAccessor<UIRepairTaskStatisticCriteria,RCMaintenanceTeamProxy> TeamAccessor = new IObjectFieldAccessor<UIRepairTaskStatisticCriteria,RCMaintenanceTeamProxy>(){
    				public com.fudanmed.platform.core.domain.proxy.RCMaintenanceTeamProxy getValue(UIRepairTaskStatisticCriteria object){
    					return object.getTeam();
    				}
    				public void setValue(UIRepairTaskStatisticCriteria object,com.fudanmed.platform.core.domain.proxy.RCMaintenanceTeamProxy value){
    					object.setTeam(value);
    				}
    			};
  
  private RCEmployeeProxy worker;
  
  public RCEmployeeProxy getWorker() {
    return this.worker;
  }
  
  public void setWorker(final RCEmployeeProxy worker) {
    this.worker = worker;
  }
  
  public final static String P_Worker = "worker";
  
  public static IObjectFieldAccessor<UIRepairTaskStatisticCriteria,RCEmployeeProxy> WorkerAccessor = new IObjectFieldAccessor<UIRepairTaskStatisticCriteria,RCEmployeeProxy>(){
    				public com.fudanmed.platform.core.domain.proxy.RCEmployeeProxy getValue(UIRepairTaskStatisticCriteria object){
    					return object.getWorker();
    				}
    				public void setValue(UIRepairTaskStatisticCriteria object,com.fudanmed.platform.core.domain.proxy.RCEmployeeProxy value){
    					object.setWorker(value);
    				}
    			};
  
  private String comment;
  
  public String getComment() {
    return this.comment;
  }
  
  public void setComment(final String comment) {
    this.comment = comment;
  }
  
  public final static String P_Comment = "comment";
  
  public static IObjectFieldAccessor<UIRepairTaskStatisticCriteria,String> CommentAccessor = new IObjectFieldAccessor<UIRepairTaskStatisticCriteria,String>(){
    				public String getValue(UIRepairTaskStatisticCriteria object){
    					return object.getComment();
    				}
    				public void setValue(UIRepairTaskStatisticCriteria object,String value){
    					object.setComment(value);
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
  
  public static IObjectFieldAccessor<UIRepairTaskStatisticCriteria,UIRepairTaskStatus> StatusAccessor = new IObjectFieldAccessor<UIRepairTaskStatisticCriteria,UIRepairTaskStatus>(){
    				public com.fudanmed.platform.core.web.shared.project.UIRepairTaskStatus getValue(UIRepairTaskStatisticCriteria object){
    					return object.getStatus();
    				}
    				public void setValue(UIRepairTaskStatisticCriteria object,com.fudanmed.platform.core.web.shared.project.UIRepairTaskStatus value){
    					object.setStatus(value);
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
  
  public static IObjectFieldAccessor<UIRepairTaskStatisticCriteria,UIDateRange> ReportDateRangeAccessor = new IObjectFieldAccessor<UIRepairTaskStatisticCriteria,UIDateRange>(){
    				public com.uniquesoft.gwt.shared.datatype.UIDateRange getValue(UIRepairTaskStatisticCriteria object){
    					return object.getReportDateRange();
    				}
    				public void setValue(UIRepairTaskStatisticCriteria object,com.uniquesoft.gwt.shared.datatype.UIDateRange value){
    					object.setReportDateRange(value);
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
