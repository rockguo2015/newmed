package com.fudanmed.platform.core.web.shared.device;

import com.fudanmed.platform.core.device.pm.proxy.RCPMWorkItemProxy;
import com.fudanmed.platform.core.device.pm.proxy.RCWorkItemPlanAssignmentProxy;
import com.fudanmed.platform.core.domain.proxy.RCMaintenanceTeamProxy;
import com.fudanmed.platform.core.domain.proxy.RCSupplierProxy;
import com.fudanmed.platform.core.web.shared.device.UIPMWorkItemEvaluate;
import com.fudanmed.platform.core.web.shared.device.UIPMWorkItemStatue;
import com.uniquesoft.gwt.shared.GWTEntity;
import com.uniquesoft.gwt.shared.common.IObjectFieldAccessor;
import java.util.Collection;
import java.util.Date;

public class UIPMWorkItem extends GWTEntity {
  private String title;
  
  public String getTitle() {
    return this.title;
  }
  
  public void setTitle(final String title) {
    this.title = title;
  }
  
  public final static String P_Title = "title";
  
  public static IObjectFieldAccessor<UIPMWorkItem,String> TitleAccessor = new IObjectFieldAccessor<UIPMWorkItem,String>(){
    				public String getValue(UIPMWorkItem object){
    					return object.getTitle();
    				}
    				public void setValue(UIPMWorkItem object,String value){
    					object.setTitle(value);
    				}
    			};
  
  private String description;
  
  public String getDescription() {
    return this.description;
  }
  
  public void setDescription(final String description) {
    this.description = description;
  }
  
  public final static String P_Description = "description";
  
  public static IObjectFieldAccessor<UIPMWorkItem,String> DescriptionAccessor = new IObjectFieldAccessor<UIPMWorkItem,String>(){
    				public String getValue(UIPMWorkItem object){
    					return object.getDescription();
    				}
    				public void setValue(UIPMWorkItem object,String value){
    					object.setDescription(value);
    				}
    			};
  
  private String sid;
  
  public String getSid() {
    return this.sid;
  }
  
  public void setSid(final String sid) {
    this.sid = sid;
  }
  
  public final static String P_Sid = "sid";
  
  public static IObjectFieldAccessor<UIPMWorkItem,String> SidAccessor = new IObjectFieldAccessor<UIPMWorkItem,String>(){
    				public String getValue(UIPMWorkItem object){
    					return object.getSid();
    				}
    				public void setValue(UIPMWorkItem object,String value){
    					object.setSid(value);
    				}
    			};
  
  private Date assignDate;
  
  public Date getAssignDate() {
    return this.assignDate;
  }
  
  public void setAssignDate(final Date assignDate) {
    this.assignDate = assignDate;
  }
  
  public final static String P_AssignDate = "assignDate";
  
  public static IObjectFieldAccessor<UIPMWorkItem,Date> AssignDateAccessor = new IObjectFieldAccessor<UIPMWorkItem,Date>(){
    				public java.util.Date getValue(UIPMWorkItem object){
    					return object.getAssignDate();
    				}
    				public void setValue(UIPMWorkItem object,java.util.Date value){
    					object.setAssignDate(value);
    				}
    			};
  
  private Date dispatchDate;
  
  public Date getDispatchDate() {
    return this.dispatchDate;
  }
  
  public void setDispatchDate(final Date dispatchDate) {
    this.dispatchDate = dispatchDate;
  }
  
  public final static String P_DispatchDate = "dispatchDate";
  
  public static IObjectFieldAccessor<UIPMWorkItem,Date> DispatchDateAccessor = new IObjectFieldAccessor<UIPMWorkItem,Date>(){
    				public java.util.Date getValue(UIPMWorkItem object){
    					return object.getDispatchDate();
    				}
    				public void setValue(UIPMWorkItem object,java.util.Date value){
    					object.setDispatchDate(value);
    				}
    			};
  
  private RCSupplierProxy supplier;
  
  public RCSupplierProxy getSupplier() {
    return this.supplier;
  }
  
  public void setSupplier(final RCSupplierProxy supplier) {
    this.supplier = supplier;
  }
  
  public final static String P_Supplier = "supplier";
  
  public static IObjectFieldAccessor<UIPMWorkItem,RCSupplierProxy> SupplierAccessor = new IObjectFieldAccessor<UIPMWorkItem,RCSupplierProxy>(){
    				public com.fudanmed.platform.core.domain.proxy.RCSupplierProxy getValue(UIPMWorkItem object){
    					return object.getSupplier();
    				}
    				public void setValue(UIPMWorkItem object,com.fudanmed.platform.core.domain.proxy.RCSupplierProxy value){
    					object.setSupplier(value);
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
  
  public static IObjectFieldAccessor<UIPMWorkItem,RCMaintenanceTeamProxy> TeamAccessor = new IObjectFieldAccessor<UIPMWorkItem,RCMaintenanceTeamProxy>(){
    				public com.fudanmed.platform.core.domain.proxy.RCMaintenanceTeamProxy getValue(UIPMWorkItem object){
    					return object.getTeam();
    				}
    				public void setValue(UIPMWorkItem object,com.fudanmed.platform.core.domain.proxy.RCMaintenanceTeamProxy value){
    					object.setTeam(value);
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
  
  public static IObjectFieldAccessor<UIPMWorkItem,Date> FinishDateAccessor = new IObjectFieldAccessor<UIPMWorkItem,Date>(){
    				public java.util.Date getValue(UIPMWorkItem object){
    					return object.getFinishDate();
    				}
    				public void setValue(UIPMWorkItem object,java.util.Date value){
    					object.setFinishDate(value);
    				}
    			};
  
  private String teamComment;
  
  public String getTeamComment() {
    return this.teamComment;
  }
  
  public void setTeamComment(final String teamComment) {
    this.teamComment = teamComment;
  }
  
  public final static String P_TeamComment = "teamComment";
  
  public static IObjectFieldAccessor<UIPMWorkItem,String> TeamCommentAccessor = new IObjectFieldAccessor<UIPMWorkItem,String>(){
    				public String getValue(UIPMWorkItem object){
    					return object.getTeamComment();
    				}
    				public void setValue(UIPMWorkItem object,String value){
    					object.setTeamComment(value);
    				}
    			};
  
  private Collection<RCWorkItemPlanAssignmentProxy> assignments = com.google.common.collect.Lists.newArrayList();
  
  public Collection<RCWorkItemPlanAssignmentProxy> getAssignments() {
    return this.assignments;
  }
  
  public void setAssignments(final Collection<RCWorkItemPlanAssignmentProxy> assignments) {
    this.assignments = assignments;
  }
  
  public final static String P_Assignments = "assignments";
  
  public static IObjectFieldAccessor<UIPMWorkItem,Collection<RCWorkItemPlanAssignmentProxy>> AssignmentsAccessor = new IObjectFieldAccessor<UIPMWorkItem,Collection<RCWorkItemPlanAssignmentProxy>>(){
    				public java.util.Collection<com.fudanmed.platform.core.device.pm.proxy.RCWorkItemPlanAssignmentProxy> getValue(UIPMWorkItem object){
    					return object.getAssignments();
    				}
    				public void setValue(UIPMWorkItem object,java.util.Collection<com.fudanmed.platform.core.device.pm.proxy.RCWorkItemPlanAssignmentProxy> value){
    					object.setAssignments(value);
    				}
    			};
  
  private UIPMWorkItemStatue status;
  
  public UIPMWorkItemStatue getStatus() {
    return this.status;
  }
  
  public void setStatus(final UIPMWorkItemStatue status) {
    this.status = status;
  }
  
  public final static String P_Status = "status";
  
  public static IObjectFieldAccessor<UIPMWorkItem,UIPMWorkItemStatue> StatusAccessor = new IObjectFieldAccessor<UIPMWorkItem,UIPMWorkItemStatue>(){
    				public com.fudanmed.platform.core.web.shared.device.UIPMWorkItemStatue getValue(UIPMWorkItem object){
    					return object.getStatus();
    				}
    				public void setValue(UIPMWorkItem object,com.fudanmed.platform.core.web.shared.device.UIPMWorkItemStatue value){
    					object.setStatus(value);
    				}
    			};
  
  private UIPMWorkItemEvaluate evaluate = new UIPMWorkItemEvaluate();
  
  public UIPMWorkItemEvaluate getEvaluate() {
    return this.evaluate;
  }
  
  public void setEvaluate(final UIPMWorkItemEvaluate evaluate) {
    this.evaluate = evaluate;
  }
  
  public final static String P_Evaluate = "evaluate";
  
  public static IObjectFieldAccessor<UIPMWorkItem,UIPMWorkItemEvaluate> EvaluateAccessor = new IObjectFieldAccessor<UIPMWorkItem,UIPMWorkItemEvaluate>(){
    				public com.fudanmed.platform.core.web.shared.device.UIPMWorkItemEvaluate getValue(UIPMWorkItem object){
    					return object.getEvaluate();
    				}
    				public void setValue(UIPMWorkItem object,com.fudanmed.platform.core.web.shared.device.UIPMWorkItemEvaluate value){
    					object.setEvaluate(value);
    				}
    			};
  
  private Boolean dispatchTeam;
  
  public Boolean getDispatchTeam() {
    return this.dispatchTeam;
  }
  
  public void setDispatchTeam(final Boolean dispatchTeam) {
    this.dispatchTeam = dispatchTeam;
  }
  
  public final static String P_DispatchTeam = "dispatchTeam";
  
  public static IObjectFieldAccessor<UIPMWorkItem,Boolean> DispatchTeamAccessor = new IObjectFieldAccessor<UIPMWorkItem,Boolean>(){
    				public Boolean getValue(UIPMWorkItem object){
    					return object.getDispatchTeam();
    				}
    				public void setValue(UIPMWorkItem object,Boolean value){
    					object.setDispatchTeam(value);
    				}
    			};
  
  private Boolean allWorkerTaskFinished;
  
  public Boolean getAllWorkerTaskFinished() {
    return this.allWorkerTaskFinished;
  }
  
  public void setAllWorkerTaskFinished(final Boolean allWorkerTaskFinished) {
    this.allWorkerTaskFinished = allWorkerTaskFinished;
  }
  
  public final static String P_AllWorkerTaskFinished = "allWorkerTaskFinished";
  
  public static IObjectFieldAccessor<UIPMWorkItem,Boolean> AllWorkerTaskFinishedAccessor = new IObjectFieldAccessor<UIPMWorkItem,Boolean>(){
    				public Boolean getValue(UIPMWorkItem object){
    					return object.getAllWorkerTaskFinished();
    				}
    				public void setValue(UIPMWorkItem object,Boolean value){
    					object.setAllWorkerTaskFinished(value);
    				}
    			};
  
  public RCPMWorkItemProxy toProxy() {
    return (RCPMWorkItemProxy)super.toProxy();
    
  }
}
