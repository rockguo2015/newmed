package com.fudanmed.platform.core.web.shared.project;

import com.fudanmed.platform.core.common.proxy.RCFaultEmergencyLevelProxy;
import com.fudanmed.platform.core.common.proxy.RCFaultReportSourceProxy;
import com.fudanmed.platform.core.domain.proxy.RCEmployeeProxy;
import com.fudanmed.platform.core.domain.proxy.RCFaultTypeProxy;
import com.fudanmed.platform.core.domain.proxy.RCMaintenamceTypeProxy;
import com.fudanmed.platform.core.domain.proxy.RCMaintenanceTeamProxy;
import com.fudanmed.platform.core.domain.proxy.RCOrganizationProxy;
import com.fudanmed.platform.core.domain.proxy.RCRepairTaskProxy;
import com.fudanmed.platform.core.web.shared.project.UIRepairTaskStatus;
import com.uniquesoft.gwt.shared.GWTEntity;
import com.uniquesoft.gwt.shared.common.IObjectFieldAccessor;
import edu.fudan.langlab.domain.organization.proxy.PartyProxy;
import java.util.Collection;
import java.util.Date;

public class UIRepairTaskStatisticData extends GWTEntity {
  private RCOrganizationProxy reportOrg;
  
  public RCOrganizationProxy getReportOrg() {
    return this.reportOrg;
  }
  
  public void setReportOrg(final RCOrganizationProxy reportOrg) {
    this.reportOrg = reportOrg;
  }
  
  public final static String P_ReportOrg = "reportOrg";
  
  public static IObjectFieldAccessor<UIRepairTaskStatisticData,RCOrganizationProxy> ReportOrgAccessor = new IObjectFieldAccessor<UIRepairTaskStatisticData,RCOrganizationProxy>(){
    				public com.fudanmed.platform.core.domain.proxy.RCOrganizationProxy getValue(UIRepairTaskStatisticData object){
    					return object.getReportOrg();
    				}
    				public void setValue(UIRepairTaskStatisticData object,com.fudanmed.platform.core.domain.proxy.RCOrganizationProxy value){
    					object.setReportOrg(value);
    				}
    			};
  
  private String reportOrgFullPath;
  
  public String getReportOrgFullPath() {
    return this.reportOrgFullPath;
  }
  
  public void setReportOrgFullPath(final String reportOrgFullPath) {
    this.reportOrgFullPath = reportOrgFullPath;
  }
  
  public final static String P_ReportOrgFullPath = "reportOrgFullPath";
  
  public static IObjectFieldAccessor<UIRepairTaskStatisticData,String> ReportOrgFullPathAccessor = new IObjectFieldAccessor<UIRepairTaskStatisticData,String>(){
    				public String getValue(UIRepairTaskStatisticData object){
    					return object.getReportOrgFullPath();
    				}
    				public void setValue(UIRepairTaskStatisticData object,String value){
    					object.setReportOrgFullPath(value);
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
  
  public static IObjectFieldAccessor<UIRepairTaskStatisticData,String> ReporterNameAccessor = new IObjectFieldAccessor<UIRepairTaskStatisticData,String>(){
    				public String getValue(UIRepairTaskStatisticData object){
    					return object.getReporterName();
    				}
    				public void setValue(UIRepairTaskStatisticData object,String value){
    					object.setReporterName(value);
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
  
  public static IObjectFieldAccessor<UIRepairTaskStatisticData,String> LocationAccessor = new IObjectFieldAccessor<UIRepairTaskStatisticData,String>(){
    				public String getValue(UIRepairTaskStatisticData object){
    					return object.getLocation();
    				}
    				public void setValue(UIRepairTaskStatisticData object,String value){
    					object.setLocation(value);
    				}
    			};
  
  private PartyProxy operator;
  
  public PartyProxy getOperator() {
    return this.operator;
  }
  
  public void setOperator(final PartyProxy operator) {
    this.operator = operator;
  }
  
  public final static String P_Operator = "operator";
  
  public static IObjectFieldAccessor<UIRepairTaskStatisticData,PartyProxy> OperatorAccessor = new IObjectFieldAccessor<UIRepairTaskStatisticData,PartyProxy>(){
    				public edu.fudan.langlab.domain.organization.proxy.PartyProxy getValue(UIRepairTaskStatisticData object){
    					return object.getOperator();
    				}
    				public void setValue(UIRepairTaskStatisticData object,edu.fudan.langlab.domain.organization.proxy.PartyProxy value){
    					object.setOperator(value);
    				}
    			};
  
  private String reportSid;
  
  public String getReportSid() {
    return this.reportSid;
  }
  
  public void setReportSid(final String reportSid) {
    this.reportSid = reportSid;
  }
  
  public final static String P_ReportSid = "reportSid";
  
  public static IObjectFieldAccessor<UIRepairTaskStatisticData,String> ReportSidAccessor = new IObjectFieldAccessor<UIRepairTaskStatisticData,String>(){
    				public String getValue(UIRepairTaskStatisticData object){
    					return object.getReportSid();
    				}
    				public void setValue(UIRepairTaskStatisticData object,String value){
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
  
  public static IObjectFieldAccessor<UIRepairTaskStatisticData,RCFaultReportSourceProxy> FaultReportSourceAccessor = new IObjectFieldAccessor<UIRepairTaskStatisticData,RCFaultReportSourceProxy>(){
    				public com.fudanmed.platform.core.common.proxy.RCFaultReportSourceProxy getValue(UIRepairTaskStatisticData object){
    					return object.getFaultReportSource();
    				}
    				public void setValue(UIRepairTaskStatisticData object,com.fudanmed.platform.core.common.proxy.RCFaultReportSourceProxy value){
    					object.setFaultReportSource(value);
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
  
  public static IObjectFieldAccessor<UIRepairTaskStatisticData,Date> ReportTimeAccessor = new IObjectFieldAccessor<UIRepairTaskStatisticData,Date>(){
    				public java.util.Date getValue(UIRepairTaskStatisticData object){
    					return object.getReportTime();
    				}
    				public void setValue(UIRepairTaskStatisticData object,java.util.Date value){
    					object.setReportTime(value);
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
  
  public static IObjectFieldAccessor<UIRepairTaskStatisticData,UIRepairTaskStatus> StatusAccessor = new IObjectFieldAccessor<UIRepairTaskStatisticData,UIRepairTaskStatus>(){
    				public com.fudanmed.platform.core.web.shared.project.UIRepairTaskStatus getValue(UIRepairTaskStatisticData object){
    					return object.getStatus();
    				}
    				public void setValue(UIRepairTaskStatisticData object,com.fudanmed.platform.core.web.shared.project.UIRepairTaskStatus value){
    					object.setStatus(value);
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
  
  public static IObjectFieldAccessor<UIRepairTaskStatisticData,RCFaultEmergencyLevelProxy> FaultEmergencyLevelAccessor = new IObjectFieldAccessor<UIRepairTaskStatisticData,RCFaultEmergencyLevelProxy>(){
    				public com.fudanmed.platform.core.common.proxy.RCFaultEmergencyLevelProxy getValue(UIRepairTaskStatisticData object){
    					return object.getFaultEmergencyLevel();
    				}
    				public void setValue(UIRepairTaskStatisticData object,com.fudanmed.platform.core.common.proxy.RCFaultEmergencyLevelProxy value){
    					object.setFaultEmergencyLevel(value);
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
  
  public static IObjectFieldAccessor<UIRepairTaskStatisticData,Collection<RCMaintenanceTeamProxy>> TeamsAccessor = new IObjectFieldAccessor<UIRepairTaskStatisticData,Collection<RCMaintenanceTeamProxy>>(){
    				public java.util.Collection<com.fudanmed.platform.core.domain.proxy.RCMaintenanceTeamProxy> getValue(UIRepairTaskStatisticData object){
    					return object.getTeams();
    				}
    				public void setValue(UIRepairTaskStatisticData object,java.util.Collection<com.fudanmed.platform.core.domain.proxy.RCMaintenanceTeamProxy> value){
    					object.setTeams(value);
    				}
    			};
  
  private Collection<RCEmployeeProxy> workers = com.google.common.collect.Lists.newArrayList();
  
  public Collection<RCEmployeeProxy> getWorkers() {
    return this.workers;
  }
  
  public void setWorkers(final Collection<RCEmployeeProxy> workers) {
    this.workers = workers;
  }
  
  public final static String P_Workers = "workers";
  
  public static IObjectFieldAccessor<UIRepairTaskStatisticData,Collection<RCEmployeeProxy>> WorkersAccessor = new IObjectFieldAccessor<UIRepairTaskStatisticData,Collection<RCEmployeeProxy>>(){
    				public java.util.Collection<com.fudanmed.platform.core.domain.proxy.RCEmployeeProxy> getValue(UIRepairTaskStatisticData object){
    					return object.getWorkers();
    				}
    				public void setValue(UIRepairTaskStatisticData object,java.util.Collection<com.fudanmed.platform.core.domain.proxy.RCEmployeeProxy> value){
    					object.setWorkers(value);
    				}
    			};
  
  private RCFaultTypeProxy faultType;
  
  public RCFaultTypeProxy getFaultType() {
    return this.faultType;
  }
  
  public void setFaultType(final RCFaultTypeProxy faultType) {
    this.faultType = faultType;
  }
  
  public final static String P_FaultType = "faultType";
  
  public static IObjectFieldAccessor<UIRepairTaskStatisticData,RCFaultTypeProxy> FaultTypeAccessor = new IObjectFieldAccessor<UIRepairTaskStatisticData,RCFaultTypeProxy>(){
    				public com.fudanmed.platform.core.domain.proxy.RCFaultTypeProxy getValue(UIRepairTaskStatisticData object){
    					return object.getFaultType();
    				}
    				public void setValue(UIRepairTaskStatisticData object,com.fudanmed.platform.core.domain.proxy.RCFaultTypeProxy value){
    					object.setFaultType(value);
    				}
    			};
  
  private RCMaintenamceTypeProxy mType;
  
  public RCMaintenamceTypeProxy getMType() {
    return this.mType;
  }
  
  public void setMType(final RCMaintenamceTypeProxy mType) {
    this.mType = mType;
  }
  
  public final static String P_MType = "mType";
  
  public static IObjectFieldAccessor<UIRepairTaskStatisticData,RCMaintenamceTypeProxy> MTypeAccessor = new IObjectFieldAccessor<UIRepairTaskStatisticData,RCMaintenamceTypeProxy>(){
    				public com.fudanmed.platform.core.domain.proxy.RCMaintenamceTypeProxy getValue(UIRepairTaskStatisticData object){
    					return object.getMType();
    				}
    				public void setValue(UIRepairTaskStatisticData object,com.fudanmed.platform.core.domain.proxy.RCMaintenamceTypeProxy value){
    					object.setMType(value);
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
  
  public static IObjectFieldAccessor<UIRepairTaskStatisticData,String> CommentAccessor = new IObjectFieldAccessor<UIRepairTaskStatisticData,String>(){
    				public String getValue(UIRepairTaskStatisticData object){
    					return object.getComment();
    				}
    				public void setValue(UIRepairTaskStatisticData object,String value){
    					object.setComment(value);
    				}
    			};
  
  private Date dispatchTime;
  
  public Date getDispatchTime() {
    return this.dispatchTime;
  }
  
  public void setDispatchTime(final Date dispatchTime) {
    this.dispatchTime = dispatchTime;
  }
  
  public final static String P_DispatchTime = "dispatchTime";
  
  public static IObjectFieldAccessor<UIRepairTaskStatisticData,Date> DispatchTimeAccessor = new IObjectFieldAccessor<UIRepairTaskStatisticData,Date>(){
    				public java.util.Date getValue(UIRepairTaskStatisticData object){
    					return object.getDispatchTime();
    				}
    				public void setValue(UIRepairTaskStatisticData object,java.util.Date value){
    					object.setDispatchTime(value);
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
  
  public static IObjectFieldAccessor<UIRepairTaskStatisticData,Date> FinishTimeAccessor = new IObjectFieldAccessor<UIRepairTaskStatisticData,Date>(){
    				public java.util.Date getValue(UIRepairTaskStatisticData object){
    					return object.getFinishTime();
    				}
    				public void setValue(UIRepairTaskStatisticData object,java.util.Date value){
    					object.setFinishTime(value);
    				}
    			};
  
  private String hasSettlement;
  
  public String getHasSettlement() {
    return this.hasSettlement;
  }
  
  public void setHasSettlement(final String hasSettlement) {
    this.hasSettlement = hasSettlement;
  }
  
  public final static String P_HasSettlement = "hasSettlement";
  
  public static IObjectFieldAccessor<UIRepairTaskStatisticData,String> HasSettlementAccessor = new IObjectFieldAccessor<UIRepairTaskStatisticData,String>(){
    				public String getValue(UIRepairTaskStatisticData object){
    					return object.getHasSettlement();
    				}
    				public void setValue(UIRepairTaskStatisticData object,String value){
    					object.setHasSettlement(value);
    				}
    			};
  
  private String evaluateComment;
  
  public String getEvaluateComment() {
    return this.evaluateComment;
  }
  
  public void setEvaluateComment(final String evaluateComment) {
    this.evaluateComment = evaluateComment;
  }
  
  public final static String P_EvaluateComment = "evaluateComment";
  
  public static IObjectFieldAccessor<UIRepairTaskStatisticData,String> EvaluateCommentAccessor = new IObjectFieldAccessor<UIRepairTaskStatisticData,String>(){
    				public String getValue(UIRepairTaskStatisticData object){
    					return object.getEvaluateComment();
    				}
    				public void setValue(UIRepairTaskStatisticData object,String value){
    					object.setEvaluateComment(value);
    				}
    			};
  
  private RCEmployeeProxy evaluater;
  
  public RCEmployeeProxy getEvaluater() {
    return this.evaluater;
  }
  
  public void setEvaluater(final RCEmployeeProxy evaluater) {
    this.evaluater = evaluater;
  }
  
  public final static String P_Evaluater = "evaluater";
  
  public static IObjectFieldAccessor<UIRepairTaskStatisticData,RCEmployeeProxy> EvaluaterAccessor = new IObjectFieldAccessor<UIRepairTaskStatisticData,RCEmployeeProxy>(){
    				public com.fudanmed.platform.core.domain.proxy.RCEmployeeProxy getValue(UIRepairTaskStatisticData object){
    					return object.getEvaluater();
    				}
    				public void setValue(UIRepairTaskStatisticData object,com.fudanmed.platform.core.domain.proxy.RCEmployeeProxy value){
    					object.setEvaluater(value);
    				}
    			};
  
  private Date evaluateTime;
  
  public Date getEvaluateTime() {
    return this.evaluateTime;
  }
  
  public void setEvaluateTime(final Date evaluateTime) {
    this.evaluateTime = evaluateTime;
  }
  
  public final static String P_EvaluateTime = "evaluateTime";
  
  public static IObjectFieldAccessor<UIRepairTaskStatisticData,Date> EvaluateTimeAccessor = new IObjectFieldAccessor<UIRepairTaskStatisticData,Date>(){
    				public java.util.Date getValue(UIRepairTaskStatisticData object){
    					return object.getEvaluateTime();
    				}
    				public void setValue(UIRepairTaskStatisticData object,java.util.Date value){
    					object.setEvaluateTime(value);
    				}
    			};
  
  public RCRepairTaskProxy toProxy() {
    return (RCRepairTaskProxy)super.toProxy();
    
  }
}
