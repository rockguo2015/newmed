package com.fudanmed.platform.core.web.shared.project;

import com.fudanmed.platform.core.common.proxy.RCFaultEmergencyLevelProxy;
import com.fudanmed.platform.core.common.proxy.RCFaultLevelProxy;
import com.fudanmed.platform.core.common.proxy.RCFaultReportSourceProxy;
import com.fudanmed.platform.core.domain.proxy.RCEmployeeProxy;
import com.fudanmed.platform.core.domain.proxy.RCFaultTypeProxy;
import com.fudanmed.platform.core.domain.proxy.RCMaintenanceTeamProxy;
import com.fudanmed.platform.core.domain.proxy.RCOrganizationProxy;
import com.fudanmed.platform.core.domain.proxy.RCRepairTaskProxy;
import com.fudanmed.platform.core.web.shared.project.UIEvaluateState;
import com.fudanmed.platform.core.web.shared.project.UIFaultType;
import com.fudanmed.platform.core.web.shared.project.UIRepairTaskStatus;
import com.uniquesoft.gwt.shared.GWTEntity;
import com.uniquesoft.gwt.shared.common.IObjectFieldAccessor;
import java.util.Collection;
import java.util.Date;

public class UIRepairTask extends GWTEntity {
  private String reportSid;
  
  public String getReportSid() {
    return this.reportSid;
  }
  
  public void setReportSid(final String reportSid) {
    this.reportSid = reportSid;
  }
  
  public final static String P_ReportSid = "reportSid";
  
  public static IObjectFieldAccessor<UIRepairTask,String> ReportSidAccessor = new IObjectFieldAccessor<UIRepairTask,String>(){
    				public String getValue(UIRepairTask object){
    					return object.getReportSid();
    				}
    				public void setValue(UIRepairTask object,String value){
    					object.setReportSid(value);
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
  
  public static IObjectFieldAccessor<UIRepairTask,RCFaultReportSourceProxy> FaultReportSourceAccessor = new IObjectFieldAccessor<UIRepairTask,RCFaultReportSourceProxy>(){
    				public com.fudanmed.platform.core.common.proxy.RCFaultReportSourceProxy getValue(UIRepairTask object){
    					return object.getFaultReportSource();
    				}
    				public void setValue(UIRepairTask object,com.fudanmed.platform.core.common.proxy.RCFaultReportSourceProxy value){
    					object.setFaultReportSource(value);
    				}
    			};
  
  private Date reportDate;
  
  public Date getReportDate() {
    return this.reportDate;
  }
  
  public void setReportDate(final Date reportDate) {
    this.reportDate = reportDate;
  }
  
  public final static String P_ReportDate = "reportDate";
  
  public static IObjectFieldAccessor<UIRepairTask,Date> ReportDateAccessor = new IObjectFieldAccessor<UIRepairTask,Date>(){
    				public java.util.Date getValue(UIRepairTask object){
    					return object.getReportDate();
    				}
    				public void setValue(UIRepairTask object,java.util.Date value){
    					object.setReportDate(value);
    				}
    			};
  
  private Date reportTime;
  
  public Date getReportTime() {
    return this.reportTime;
  }
  
  public void setReportTime(final Date reportTime) {
    this.reportTime = reportTime;
  }
  
  public final static String P_ReportTime = "reportTime";
  
  public static IObjectFieldAccessor<UIRepairTask,Date> ReportTimeAccessor = new IObjectFieldAccessor<UIRepairTask,Date>(){
    				public java.util.Date getValue(UIRepairTask object){
    					return object.getReportTime();
    				}
    				public void setValue(UIRepairTask object,java.util.Date value){
    					object.setReportTime(value);
    				}
    			};
  
  private Date reportDateTime;
  
  public Date getReportDateTime() {
    return this.reportDateTime;
  }
  
  public void setReportDateTime(final Date reportDateTime) {
    this.reportDateTime = reportDateTime;
  }
  
  public final static String P_ReportDateTime = "reportDateTime";
  
  public static IObjectFieldAccessor<UIRepairTask,Date> ReportDateTimeAccessor = new IObjectFieldAccessor<UIRepairTask,Date>(){
    				public java.util.Date getValue(UIRepairTask object){
    					return object.getReportDateTime();
    				}
    				public void setValue(UIRepairTask object,java.util.Date value){
    					object.setReportDateTime(value);
    				}
    			};
  
  private Date reserveDate;
  
  public Date getReserveDate() {
    return this.reserveDate;
  }
  
  public void setReserveDate(final Date reserveDate) {
    this.reserveDate = reserveDate;
  }
  
  public final static String P_ReserveDate = "reserveDate";
  
  public static IObjectFieldAccessor<UIRepairTask,Date> ReserveDateAccessor = new IObjectFieldAccessor<UIRepairTask,Date>(){
    				public java.util.Date getValue(UIRepairTask object){
    					return object.getReserveDate();
    				}
    				public void setValue(UIRepairTask object,java.util.Date value){
    					object.setReserveDate(value);
    				}
    			};
  
  private Date reserveTime;
  
  public Date getReserveTime() {
    return this.reserveTime;
  }
  
  public void setReserveTime(final Date reserveTime) {
    this.reserveTime = reserveTime;
  }
  
  public final static String P_ReserveTime = "reserveTime";
  
  public static IObjectFieldAccessor<UIRepairTask,Date> ReserveTimeAccessor = new IObjectFieldAccessor<UIRepairTask,Date>(){
    				public java.util.Date getValue(UIRepairTask object){
    					return object.getReserveTime();
    				}
    				public void setValue(UIRepairTask object,java.util.Date value){
    					object.setReserveTime(value);
    				}
    			};
  
  private Date planFinishDate;
  
  public Date getPlanFinishDate() {
    return this.planFinishDate;
  }
  
  public void setPlanFinishDate(final Date planFinishDate) {
    this.planFinishDate = planFinishDate;
  }
  
  public final static String P_PlanFinishDate = "planFinishDate";
  
  public static IObjectFieldAccessor<UIRepairTask,Date> PlanFinishDateAccessor = new IObjectFieldAccessor<UIRepairTask,Date>(){
    				public java.util.Date getValue(UIRepairTask object){
    					return object.getPlanFinishDate();
    				}
    				public void setValue(UIRepairTask object,java.util.Date value){
    					object.setPlanFinishDate(value);
    				}
    			};
  
  private Date planFinishTime;
  
  public Date getPlanFinishTime() {
    return this.planFinishTime;
  }
  
  public void setPlanFinishTime(final Date planFinishTime) {
    this.planFinishTime = planFinishTime;
  }
  
  public final static String P_PlanFinishTime = "planFinishTime";
  
  public static IObjectFieldAccessor<UIRepairTask,Date> PlanFinishTimeAccessor = new IObjectFieldAccessor<UIRepairTask,Date>(){
    				public java.util.Date getValue(UIRepairTask object){
    					return object.getPlanFinishTime();
    				}
    				public void setValue(UIRepairTask object,java.util.Date value){
    					object.setPlanFinishTime(value);
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
  
  public static IObjectFieldAccessor<UIRepairTask,Date> PlanFinishDateTimeAccessor = new IObjectFieldAccessor<UIRepairTask,Date>(){
    				public java.util.Date getValue(UIRepairTask object){
    					return object.getPlanFinishDateTime();
    				}
    				public void setValue(UIRepairTask object,java.util.Date value){
    					object.setPlanFinishDateTime(value);
    				}
    			};
  
  private Boolean isTimeOut;
  
  public Boolean getIsTimeOut() {
    return this.isTimeOut;
  }
  
  public void setIsTimeOut(final Boolean isTimeOut) {
    this.isTimeOut = isTimeOut;
  }
  
  public final static String P_IsTimeOut = "isTimeOut";
  
  public static IObjectFieldAccessor<UIRepairTask,Boolean> IsTimeOutAccessor = new IObjectFieldAccessor<UIRepairTask,Boolean>(){
    				public Boolean getValue(UIRepairTask object){
    					return object.getIsTimeOut();
    				}
    				public void setValue(UIRepairTask object,Boolean value){
    					object.setIsTimeOut(value);
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
  
  public static IObjectFieldAccessor<UIRepairTask,Date> FinishDateAccessor = new IObjectFieldAccessor<UIRepairTask,Date>(){
    				public java.util.Date getValue(UIRepairTask object){
    					return object.getFinishDate();
    				}
    				public void setValue(UIRepairTask object,java.util.Date value){
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
  
  public static IObjectFieldAccessor<UIRepairTask,Date> FinishTimeAccessor = new IObjectFieldAccessor<UIRepairTask,Date>(){
    				public java.util.Date getValue(UIRepairTask object){
    					return object.getFinishTime();
    				}
    				public void setValue(UIRepairTask object,java.util.Date value){
    					object.setFinishTime(value);
    				}
    			};
  
  private RCEmployeeProxy operator;
  
  public RCEmployeeProxy getOperator() {
    return this.operator;
  }
  
  public void setOperator(final RCEmployeeProxy operator) {
    this.operator = operator;
  }
  
  public final static String P_Operator = "operator";
  
  public static IObjectFieldAccessor<UIRepairTask,RCEmployeeProxy> OperatorAccessor = new IObjectFieldAccessor<UIRepairTask,RCEmployeeProxy>(){
    				public com.fudanmed.platform.core.domain.proxy.RCEmployeeProxy getValue(UIRepairTask object){
    					return object.getOperator();
    				}
    				public void setValue(UIRepairTask object,com.fudanmed.platform.core.domain.proxy.RCEmployeeProxy value){
    					object.setOperator(value);
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
  
  public static IObjectFieldAccessor<UIRepairTask,String> LocationAccessor = new IObjectFieldAccessor<UIRepairTask,String>(){
    				public String getValue(UIRepairTask object){
    					return object.getLocation();
    				}
    				public void setValue(UIRepairTask object,String value){
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
  
  public static IObjectFieldAccessor<UIRepairTask,String> CommentAccessor = new IObjectFieldAccessor<UIRepairTask,String>(){
    				public String getValue(UIRepairTask object){
    					return object.getComment();
    				}
    				public void setValue(UIRepairTask object,String value){
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
  
  public static IObjectFieldAccessor<UIRepairTask,String> ReporterNameAccessor = new IObjectFieldAccessor<UIRepairTask,String>(){
    				public String getValue(UIRepairTask object){
    					return object.getReporterName();
    				}
    				public void setValue(UIRepairTask object,String value){
    					object.setReporterName(value);
    				}
    			};
  
  private String reporterPhone;
  
  public String getReporterPhone() {
    return this.reporterPhone;
  }
  
  public void setReporterPhone(final String reporterPhone) {
    this.reporterPhone = reporterPhone;
  }
  
  public final static String P_ReporterPhone = "reporterPhone";
  
  public static IObjectFieldAccessor<UIRepairTask,String> ReporterPhoneAccessor = new IObjectFieldAccessor<UIRepairTask,String>(){
    				public String getValue(UIRepairTask object){
    					return object.getReporterPhone();
    				}
    				public void setValue(UIRepairTask object,String value){
    					object.setReporterPhone(value);
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
  
  public static IObjectFieldAccessor<UIRepairTask,RCOrganizationProxy> ReportOrgAccessor = new IObjectFieldAccessor<UIRepairTask,RCOrganizationProxy>(){
    				public com.fudanmed.platform.core.domain.proxy.RCOrganizationProxy getValue(UIRepairTask object){
    					return object.getReportOrg();
    				}
    				public void setValue(UIRepairTask object,com.fudanmed.platform.core.domain.proxy.RCOrganizationProxy value){
    					object.setReportOrg(value);
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
  
  public static IObjectFieldAccessor<UIRepairTask,UIRepairTaskStatus> StatusAccessor = new IObjectFieldAccessor<UIRepairTask,UIRepairTaskStatus>(){
    				public com.fudanmed.platform.core.web.shared.project.UIRepairTaskStatus getValue(UIRepairTask object){
    					return object.getStatus();
    				}
    				public void setValue(UIRepairTask object,com.fudanmed.platform.core.web.shared.project.UIRepairTaskStatus value){
    					object.setStatus(value);
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
  
  public static IObjectFieldAccessor<UIRepairTask,RCFaultLevelProxy> FaultLevelAccessor = new IObjectFieldAccessor<UIRepairTask,RCFaultLevelProxy>(){
    				public com.fudanmed.platform.core.common.proxy.RCFaultLevelProxy getValue(UIRepairTask object){
    					return object.getFaultLevel();
    				}
    				public void setValue(UIRepairTask object,com.fudanmed.platform.core.common.proxy.RCFaultLevelProxy value){
    					object.setFaultLevel(value);
    				}
    			};
  
  private RCFaultEmergencyLevelProxy faultEmergencyLevel;
  
  public RCFaultEmergencyLevelProxy getFaultEmergencyLevel() {
    return this.faultEmergencyLevel;
  }
  
  public void setFaultEmergencyLevel(final RCFaultEmergencyLevelProxy faultEmergencyLevel) {
    this.faultEmergencyLevel = faultEmergencyLevel;
  }
  
  public final static String P_FaultEmergencyLevel = "faultEmergencyLevel";
  
  public static IObjectFieldAccessor<UIRepairTask,RCFaultEmergencyLevelProxy> FaultEmergencyLevelAccessor = new IObjectFieldAccessor<UIRepairTask,RCFaultEmergencyLevelProxy>(){
    				public com.fudanmed.platform.core.common.proxy.RCFaultEmergencyLevelProxy getValue(UIRepairTask object){
    					return object.getFaultEmergencyLevel();
    				}
    				public void setValue(UIRepairTask object,com.fudanmed.platform.core.common.proxy.RCFaultEmergencyLevelProxy value){
    					object.setFaultEmergencyLevel(value);
    				}
    			};
  
  private UIFaultType faultType;
  
  public UIFaultType getFaultType() {
    return this.faultType;
  }
  
  public void setFaultType(final UIFaultType faultType) {
    this.faultType = faultType;
  }
  
  public final static String P_FaultType = "faultType";
  
  public static IObjectFieldAccessor<UIRepairTask,UIFaultType> FaultTypeAccessor = new IObjectFieldAccessor<UIRepairTask,UIFaultType>(){
    				public com.fudanmed.platform.core.web.shared.project.UIFaultType getValue(UIRepairTask object){
    					return object.getFaultType();
    				}
    				public void setValue(UIRepairTask object,com.fudanmed.platform.core.web.shared.project.UIFaultType value){
    					object.setFaultType(value);
    				}
    			};
  
  private RCFaultTypeProxy actualFaultType;
  
  public RCFaultTypeProxy getActualFaultType() {
    return this.actualFaultType;
  }
  
  public void setActualFaultType(final RCFaultTypeProxy actualFaultType) {
    this.actualFaultType = actualFaultType;
  }
  
  public final static String P_ActualFaultType = "actualFaultType";
  
  public static IObjectFieldAccessor<UIRepairTask,RCFaultTypeProxy> ActualFaultTypeAccessor = new IObjectFieldAccessor<UIRepairTask,RCFaultTypeProxy>(){
    				public com.fudanmed.platform.core.domain.proxy.RCFaultTypeProxy getValue(UIRepairTask object){
    					return object.getActualFaultType();
    				}
    				public void setValue(UIRepairTask object,com.fudanmed.platform.core.domain.proxy.RCFaultTypeProxy value){
    					object.setActualFaultType(value);
    				}
    			};
  
  private Boolean saveOnly;
  
  public Boolean getSaveOnly() {
    return this.saveOnly;
  }
  
  public void setSaveOnly(final Boolean saveOnly) {
    this.saveOnly = saveOnly;
  }
  
  public final static String P_SaveOnly = "saveOnly";
  
  public static IObjectFieldAccessor<UIRepairTask,Boolean> SaveOnlyAccessor = new IObjectFieldAccessor<UIRepairTask,Boolean>(){
    				public Boolean getValue(UIRepairTask object){
    					return object.getSaveOnly();
    				}
    				public void setValue(UIRepairTask object,Boolean value){
    					object.setSaveOnly(value);
    				}
    			};
  
  private RCMaintenanceTeamProxy activeTeam;
  
  public RCMaintenanceTeamProxy getActiveTeam() {
    return this.activeTeam;
  }
  
  public void setActiveTeam(final RCMaintenanceTeamProxy activeTeam) {
    this.activeTeam = activeTeam;
  }
  
  public final static String P_ActiveTeam = "activeTeam";
  
  public static IObjectFieldAccessor<UIRepairTask,RCMaintenanceTeamProxy> ActiveTeamAccessor = new IObjectFieldAccessor<UIRepairTask,RCMaintenanceTeamProxy>(){
    				public com.fudanmed.platform.core.domain.proxy.RCMaintenanceTeamProxy getValue(UIRepairTask object){
    					return object.getActiveTeam();
    				}
    				public void setValue(UIRepairTask object,com.fudanmed.platform.core.domain.proxy.RCMaintenanceTeamProxy value){
    					object.setActiveTeam(value);
    				}
    			};
  
  private String abbtActiveWorkers;
  
  public String getAbbtActiveWorkers() {
    return this.abbtActiveWorkers;
  }
  
  public void setAbbtActiveWorkers(final String abbtActiveWorkers) {
    this.abbtActiveWorkers = abbtActiveWorkers;
  }
  
  public final static String P_AbbtActiveWorkers = "abbtActiveWorkers";
  
  public static IObjectFieldAccessor<UIRepairTask,String> AbbtActiveWorkersAccessor = new IObjectFieldAccessor<UIRepairTask,String>(){
    				public String getValue(UIRepairTask object){
    					return object.getAbbtActiveWorkers();
    				}
    				public void setValue(UIRepairTask object,String value){
    					object.setAbbtActiveWorkers(value);
    				}
    			};
  
  private Double amount;
  
  public Double getAmount() {
    return this.amount;
  }
  
  public void setAmount(final Double amount) {
    this.amount = amount;
  }
  
  public final static String P_Amount = "amount";
  
  public static IObjectFieldAccessor<UIRepairTask,Double> AmountAccessor = new IObjectFieldAccessor<UIRepairTask,Double>(){
    				public Double getValue(UIRepairTask object){
    					return object.getAmount();
    				}
    				public void setValue(UIRepairTask object,Double value){
    					object.setAmount(value);
    				}
    			};
  
  private UIEvaluateState evaluateState;
  
  public UIEvaluateState getEvaluateState() {
    return this.evaluateState;
  }
  
  public void setEvaluateState(final UIEvaluateState evaluateState) {
    this.evaluateState = evaluateState;
  }
  
  public final static String P_EvaluateState = "evaluateState";
  
  public static IObjectFieldAccessor<UIRepairTask,UIEvaluateState> EvaluateStateAccessor = new IObjectFieldAccessor<UIRepairTask,UIEvaluateState>(){
    				public com.fudanmed.platform.core.web.shared.project.UIEvaluateState getValue(UIRepairTask object){
    					return object.getEvaluateState();
    				}
    				public void setValue(UIRepairTask object,com.fudanmed.platform.core.web.shared.project.UIEvaluateState value){
    					object.setEvaluateState(value);
    				}
    			};
  
  private Boolean settlementState;
  
  public Boolean getSettlementState() {
    return this.settlementState;
  }
  
  public void setSettlementState(final Boolean settlementState) {
    this.settlementState = settlementState;
  }
  
  public final static String P_SettlementState = "settlementState";
  
  public static IObjectFieldAccessor<UIRepairTask,Boolean> SettlementStateAccessor = new IObjectFieldAccessor<UIRepairTask,Boolean>(){
    				public Boolean getValue(UIRepairTask object){
    					return object.getSettlementState();
    				}
    				public void setValue(UIRepairTask object,Boolean value){
    					object.setSettlementState(value);
    				}
    			};
  
  private Collection<RCMaintenanceTeamProxy> teams = com.google.common.collect.Lists.newArrayList();
  
  public Collection<RCMaintenanceTeamProxy> getTeams() {
    return this.teams;
  }
  
  public void setTeams(final Collection<RCMaintenanceTeamProxy> teams) {
    this.teams = teams;
  }
  
  public final static String P_Teams = "teams";
  
  public static IObjectFieldAccessor<UIRepairTask,Collection<RCMaintenanceTeamProxy>> TeamsAccessor = new IObjectFieldAccessor<UIRepairTask,Collection<RCMaintenanceTeamProxy>>(){
    				public java.util.Collection<com.fudanmed.platform.core.domain.proxy.RCMaintenanceTeamProxy> getValue(UIRepairTask object){
    					return object.getTeams();
    				}
    				public void setValue(UIRepairTask object,java.util.Collection<com.fudanmed.platform.core.domain.proxy.RCMaintenanceTeamProxy> value){
    					object.setTeams(value);
    				}
    			};
  
  private Boolean isFromReporter;
  
  public Boolean getIsFromReporter() {
    return this.isFromReporter;
  }
  
  public void setIsFromReporter(final Boolean isFromReporter) {
    this.isFromReporter = isFromReporter;
  }
  
  public final static String P_IsFromReporter = "isFromReporter";
  
  public static IObjectFieldAccessor<UIRepairTask,Boolean> IsFromReporterAccessor = new IObjectFieldAccessor<UIRepairTask,Boolean>(){
    				public Boolean getValue(UIRepairTask object){
    					return object.getIsFromReporter();
    				}
    				public void setValue(UIRepairTask object,Boolean value){
    					object.setIsFromReporter(value);
    				}
    			};
  
  private Boolean isDelayed;
  
  public Boolean getIsDelayed() {
    return this.isDelayed;
  }
  
  public void setIsDelayed(final Boolean isDelayed) {
    this.isDelayed = isDelayed;
  }
  
  public final static String P_IsDelayed = "isDelayed";
  
  public static IObjectFieldAccessor<UIRepairTask,Boolean> IsDelayedAccessor = new IObjectFieldAccessor<UIRepairTask,Boolean>(){
    				public Boolean getValue(UIRepairTask object){
    					return object.getIsDelayed();
    				}
    				public void setValue(UIRepairTask object,Boolean value){
    					object.setIsDelayed(value);
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
  
  public static IObjectFieldAccessor<UIRepairTask,String> FaultLevelColorAccessor = new IObjectFieldAccessor<UIRepairTask,String>(){
    				public String getValue(UIRepairTask object){
    					return object.getFaultLevelColor();
    				}
    				public void setValue(UIRepairTask object,String value){
    					object.setFaultLevelColor(value);
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
  
  public static IObjectFieldAccessor<UIRepairTask,Boolean> NeedAuditAccessor = new IObjectFieldAccessor<UIRepairTask,Boolean>(){
    				public Boolean getValue(UIRepairTask object){
    					return object.getNeedAudit();
    				}
    				public void setValue(UIRepairTask object,Boolean value){
    					object.setNeedAudit(value);
    				}
    			};
  
  public RCRepairTaskProxy toProxy() {
    return (RCRepairTaskProxy)super.toProxy();
    
  }
}
