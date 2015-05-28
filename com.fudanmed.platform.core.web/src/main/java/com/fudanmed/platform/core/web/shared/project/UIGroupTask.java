package com.fudanmed.platform.core.web.shared.project;

import com.fudanmed.platform.core.common.proxy.RCFaultLevelProxy;
import com.fudanmed.platform.core.domain.proxy.RCGroupTaskProxy;
import com.fudanmed.platform.core.domain.proxy.RCMaintenanceTeamProxy;
import com.fudanmed.platform.core.domain.proxy.RCOrganizationProxy;
import com.fudanmed.platform.core.web.shared.project.UIGroupTaskStatus;
import com.uniquesoft.gwt.shared.GWTEntity;
import com.uniquesoft.gwt.shared.common.IObjectFieldAccessor;
import java.util.Date;

public class UIGroupTask extends GWTEntity {
  private String reportSid;
  
  public String getReportSid() {
    return this.reportSid;
  }
  
  public void setReportSid(final String reportSid) {
    this.reportSid = reportSid;
  }
  
  public final static String P_ReportSid = "reportSid";
  
  public static IObjectFieldAccessor<UIGroupTask,String> ReportSidAccessor = new IObjectFieldAccessor<UIGroupTask,String>(){
    				public String getValue(UIGroupTask object){
    					return object.getReportSid();
    				}
    				public void setValue(UIGroupTask object,String value){
    					object.setReportSid(value);
    				}
    			};
  
  private Date date;
  
  public Date getDate() {
    return this.date;
  }
  
  public void setDate(final Date date) {
    this.date = date;
  }
  
  public final static String P_Date = "date";
  
  public static IObjectFieldAccessor<UIGroupTask,Date> DateAccessor = new IObjectFieldAccessor<UIGroupTask,Date>(){
    				public java.util.Date getValue(UIGroupTask object){
    					return object.getDate();
    				}
    				public void setValue(UIGroupTask object,java.util.Date value){
    					object.setDate(value);
    				}
    			};
  
  private Date time;
  
  public Date getTime() {
    return this.time;
  }
  
  public void setTime(final Date time) {
    this.time = time;
  }
  
  public final static String P_Time = "time";
  
  public static IObjectFieldAccessor<UIGroupTask,Date> TimeAccessor = new IObjectFieldAccessor<UIGroupTask,Date>(){
    				public java.util.Date getValue(UIGroupTask object){
    					return object.getTime();
    				}
    				public void setValue(UIGroupTask object,java.util.Date value){
    					object.setTime(value);
    				}
    			};
  
  private Date dateTime;
  
  public Date getDateTime() {
    return this.dateTime;
  }
  
  public void setDateTime(final Date dateTime) {
    this.dateTime = dateTime;
  }
  
  public final static String P_DateTime = "dateTime";
  
  public static IObjectFieldAccessor<UIGroupTask,Date> DateTimeAccessor = new IObjectFieldAccessor<UIGroupTask,Date>(){
    				public java.util.Date getValue(UIGroupTask object){
    					return object.getDateTime();
    				}
    				public void setValue(UIGroupTask object,java.util.Date value){
    					object.setDateTime(value);
    				}
    			};
  
  private RCFaultLevelProxy faultLevel;
  
  public RCFaultLevelProxy getFaultLevel() {
    return this.faultLevel;
  }
  
  public void setFaultLevel(final RCFaultLevelProxy faultLevel) {
    this.faultLevel = faultLevel;
  }
  
  public final static String P_FaultLevel = "faultLevel";
  
  public static IObjectFieldAccessor<UIGroupTask,RCFaultLevelProxy> FaultLevelAccessor = new IObjectFieldAccessor<UIGroupTask,RCFaultLevelProxy>(){
    				public com.fudanmed.platform.core.common.proxy.RCFaultLevelProxy getValue(UIGroupTask object){
    					return object.getFaultLevel();
    				}
    				public void setValue(UIGroupTask object,com.fudanmed.platform.core.common.proxy.RCFaultLevelProxy value){
    					object.setFaultLevel(value);
    				}
    			};
  
  private String faultLevelColor;
  
  public String getFaultLevelColor() {
    return this.faultLevelColor;
  }
  
  public void setFaultLevelColor(final String faultLevelColor) {
    this.faultLevelColor = faultLevelColor;
  }
  
  public final static String P_FaultLevelColor = "faultLevelColor";
  
  public static IObjectFieldAccessor<UIGroupTask,String> FaultLevelColorAccessor = new IObjectFieldAccessor<UIGroupTask,String>(){
    				public String getValue(UIGroupTask object){
    					return object.getFaultLevelColor();
    				}
    				public void setValue(UIGroupTask object,String value){
    					object.setFaultLevelColor(value);
    				}
    			};
  
  private Date finishDate;
  
  public Date getFinishDate() {
    return this.finishDate;
  }
  
  public void setFinishDate(final Date finishDate) {
    this.finishDate = finishDate;
  }
  
  public final static String P_FinishDate = "finishDate";
  
  public static IObjectFieldAccessor<UIGroupTask,Date> FinishDateAccessor = new IObjectFieldAccessor<UIGroupTask,Date>(){
    				public java.util.Date getValue(UIGroupTask object){
    					return object.getFinishDate();
    				}
    				public void setValue(UIGroupTask object,java.util.Date value){
    					object.setFinishDate(value);
    				}
    			};
  
  private Date finishTime;
  
  public Date getFinishTime() {
    return this.finishTime;
  }
  
  public void setFinishTime(final Date finishTime) {
    this.finishTime = finishTime;
  }
  
  public final static String P_FinishTime = "finishTime";
  
  public static IObjectFieldAccessor<UIGroupTask,Date> FinishTimeAccessor = new IObjectFieldAccessor<UIGroupTask,Date>(){
    				public java.util.Date getValue(UIGroupTask object){
    					return object.getFinishTime();
    				}
    				public void setValue(UIGroupTask object,java.util.Date value){
    					object.setFinishTime(value);
    				}
    			};
  
  private Date finishDateTime;
  
  public Date getFinishDateTime() {
    return this.finishDateTime;
  }
  
  public void setFinishDateTime(final Date finishDateTime) {
    this.finishDateTime = finishDateTime;
  }
  
  public final static String P_FinishDateTime = "finishDateTime";
  
  public static IObjectFieldAccessor<UIGroupTask,Date> FinishDateTimeAccessor = new IObjectFieldAccessor<UIGroupTask,Date>(){
    				public java.util.Date getValue(UIGroupTask object){
    					return object.getFinishDateTime();
    				}
    				public void setValue(UIGroupTask object,java.util.Date value){
    					object.setFinishDateTime(value);
    				}
    			};
  
  private Date planFinishDateTime;
  
  public Date getPlanFinishDateTime() {
    return this.planFinishDateTime;
  }
  
  public void setPlanFinishDateTime(final Date planFinishDateTime) {
    this.planFinishDateTime = planFinishDateTime;
  }
  
  public final static String P_PlanFinishDateTime = "planFinishDateTime";
  
  public static IObjectFieldAccessor<UIGroupTask,Date> PlanFinishDateTimeAccessor = new IObjectFieldAccessor<UIGroupTask,Date>(){
    				public java.util.Date getValue(UIGroupTask object){
    					return object.getPlanFinishDateTime();
    				}
    				public void setValue(UIGroupTask object,java.util.Date value){
    					object.setPlanFinishDateTime(value);
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
  
  public static IObjectFieldAccessor<UIGroupTask,UIGroupTaskStatus> StatusAccessor = new IObjectFieldAccessor<UIGroupTask,UIGroupTaskStatus>(){
    				public com.fudanmed.platform.core.web.shared.project.UIGroupTaskStatus getValue(UIGroupTask object){
    					return object.getStatus();
    				}
    				public void setValue(UIGroupTask object,com.fudanmed.platform.core.web.shared.project.UIGroupTaskStatus value){
    					object.setStatus(value);
    				}
    			};
  
  private String location;
  
  public String getLocation() {
    return this.location;
  }
  
  public void setLocation(final String location) {
    this.location = location;
  }
  
  public final static String P_Location = "location";
  
  public static IObjectFieldAccessor<UIGroupTask,String> LocationAccessor = new IObjectFieldAccessor<UIGroupTask,String>(){
    				public String getValue(UIGroupTask object){
    					return object.getLocation();
    				}
    				public void setValue(UIGroupTask object,String value){
    					object.setLocation(value);
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
  
  public static IObjectFieldAccessor<UIGroupTask,String> CommentAccessor = new IObjectFieldAccessor<UIGroupTask,String>(){
    				public String getValue(UIGroupTask object){
    					return object.getComment();
    				}
    				public void setValue(UIGroupTask object,String value){
    					object.setComment(value);
    				}
    			};
  
  private String reporterName;
  
  public String getReporterName() {
    return this.reporterName;
  }
  
  public void setReporterName(final String reporterName) {
    this.reporterName = reporterName;
  }
  
  public final static String P_ReporterName = "reporterName";
  
  public static IObjectFieldAccessor<UIGroupTask,String> ReporterNameAccessor = new IObjectFieldAccessor<UIGroupTask,String>(){
    				public String getValue(UIGroupTask object){
    					return object.getReporterName();
    				}
    				public void setValue(UIGroupTask object,String value){
    					object.setReporterName(value);
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
  
  public static IObjectFieldAccessor<UIGroupTask,RCOrganizationProxy> ReportOrgAccessor = new IObjectFieldAccessor<UIGroupTask,RCOrganizationProxy>(){
    				public com.fudanmed.platform.core.domain.proxy.RCOrganizationProxy getValue(UIGroupTask object){
    					return object.getReportOrg();
    				}
    				public void setValue(UIGroupTask object,com.fudanmed.platform.core.domain.proxy.RCOrganizationProxy value){
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
  
  public static IObjectFieldAccessor<UIGroupTask,RCMaintenanceTeamProxy> TeamAccessor = new IObjectFieldAccessor<UIGroupTask,RCMaintenanceTeamProxy>(){
    				public com.fudanmed.platform.core.domain.proxy.RCMaintenanceTeamProxy getValue(UIGroupTask object){
    					return object.getTeam();
    				}
    				public void setValue(UIGroupTask object,com.fudanmed.platform.core.domain.proxy.RCMaintenanceTeamProxy value){
    					object.setTeam(value);
    				}
    			};
  
  private Boolean submitNow;
  
  public Boolean getSubmitNow() {
    return this.submitNow;
  }
  
  public void setSubmitNow(final Boolean submitNow) {
    this.submitNow = submitNow;
  }
  
  public final static String P_SubmitNow = "submitNow";
  
  public static IObjectFieldAccessor<UIGroupTask,Boolean> SubmitNowAccessor = new IObjectFieldAccessor<UIGroupTask,Boolean>(){
    				public Boolean getValue(UIGroupTask object){
    					return object.getSubmitNow();
    				}
    				public void setValue(UIGroupTask object,Boolean value){
    					object.setSubmitNow(value);
    				}
    			};
  
  private Boolean needAudit;
  
  public Boolean getNeedAudit() {
    return this.needAudit;
  }
  
  public void setNeedAudit(final Boolean needAudit) {
    this.needAudit = needAudit;
  }
  
  public final static String P_NeedAudit = "needAudit";
  
  public static IObjectFieldAccessor<UIGroupTask,Boolean> NeedAuditAccessor = new IObjectFieldAccessor<UIGroupTask,Boolean>(){
    				public Boolean getValue(UIGroupTask object){
    					return object.getNeedAudit();
    				}
    				public void setValue(UIGroupTask object,Boolean value){
    					object.setNeedAudit(value);
    				}
    			};
  
  public RCGroupTaskProxy toProxy() {
    return (RCGroupTaskProxy)super.toProxy();
    
  }
}
