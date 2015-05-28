package com.fudanmed.platform.core.web.shared.device;

import com.fudanmed.platform.core.device.pm.proxy.RCPMWorkItemWorkerAssignmentProxy;
import com.fudanmed.platform.core.domain.proxy.RCEmployeeProxy;
import com.fudanmed.platform.core.web.shared.device.UIPMWorkItemEvaluate;
import com.fudanmed.platform.core.web.shared.device.UIPMWorkItemWorkerAssignmentStatus;
import com.uniquesoft.gwt.shared.GWTEntity;
import com.uniquesoft.gwt.shared.common.IObjectFieldAccessor;
import java.util.Collection;
import java.util.Date;

public class UIPMWorkItemWorkerAssignment extends GWTEntity {
  private Collection<RCEmployeeProxy> workers = com.google.common.collect.Lists.newArrayList();
  
  public Collection<RCEmployeeProxy> getWorkers() {
    return this.workers;
  }
  
  public void setWorkers(final Collection<RCEmployeeProxy> workers) {
    this.workers = workers;
  }
  
  public final static String P_Workers = "workers";
  
  public static IObjectFieldAccessor<UIPMWorkItemWorkerAssignment,Collection<RCEmployeeProxy>> WorkersAccessor = new IObjectFieldAccessor<UIPMWorkItemWorkerAssignment,Collection<RCEmployeeProxy>>(){
    				public java.util.Collection<com.fudanmed.platform.core.domain.proxy.RCEmployeeProxy> getValue(UIPMWorkItemWorkerAssignment object){
    					return object.getWorkers();
    				}
    				public void setValue(UIPMWorkItemWorkerAssignment object,java.util.Collection<com.fudanmed.platform.core.domain.proxy.RCEmployeeProxy> value){
    					object.setWorkers(value);
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
  
  public static IObjectFieldAccessor<UIPMWorkItemWorkerAssignment,Date> AssignDateAccessor = new IObjectFieldAccessor<UIPMWorkItemWorkerAssignment,Date>(){
    				public java.util.Date getValue(UIPMWorkItemWorkerAssignment object){
    					return object.getAssignDate();
    				}
    				public void setValue(UIPMWorkItemWorkerAssignment object,java.util.Date value){
    					object.setAssignDate(value);
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
  
  public static IObjectFieldAccessor<UIPMWorkItemWorkerAssignment,String> CommentAccessor = new IObjectFieldAccessor<UIPMWorkItemWorkerAssignment,String>(){
    				public String getValue(UIPMWorkItemWorkerAssignment object){
    					return object.getComment();
    				}
    				public void setValue(UIPMWorkItemWorkerAssignment object,String value){
    					object.setComment(value);
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
  
  public static IObjectFieldAccessor<UIPMWorkItemWorkerAssignment,Date> FinishDateAccessor = new IObjectFieldAccessor<UIPMWorkItemWorkerAssignment,Date>(){
    				public java.util.Date getValue(UIPMWorkItemWorkerAssignment object){
    					return object.getFinishDate();
    				}
    				public void setValue(UIPMWorkItemWorkerAssignment object,java.util.Date value){
    					object.setFinishDate(value);
    				}
    			};
  
  private String finalComment;
  
  public String getFinalComment() {
    return this.finalComment;
  }
  
  public void setFinalComment(final String finalComment) {
    this.finalComment = finalComment;
  }
  
  public final static String P_FinalComment = "finalComment";
  
  public static IObjectFieldAccessor<UIPMWorkItemWorkerAssignment,String> FinalCommentAccessor = new IObjectFieldAccessor<UIPMWorkItemWorkerAssignment,String>(){
    				public String getValue(UIPMWorkItemWorkerAssignment object){
    					return object.getFinalComment();
    				}
    				public void setValue(UIPMWorkItemWorkerAssignment object,String value){
    					object.setFinalComment(value);
    				}
    			};
  
  private UIPMWorkItemWorkerAssignmentStatus status;
  
  public UIPMWorkItemWorkerAssignmentStatus getStatus() {
    return this.status;
  }
  
  public void setStatus(final UIPMWorkItemWorkerAssignmentStatus status) {
    this.status = status;
  }
  
  public final static String P_Status = "status";
  
  public static IObjectFieldAccessor<UIPMWorkItemWorkerAssignment,UIPMWorkItemWorkerAssignmentStatus> StatusAccessor = new IObjectFieldAccessor<UIPMWorkItemWorkerAssignment,UIPMWorkItemWorkerAssignmentStatus>(){
    				public com.fudanmed.platform.core.web.shared.device.UIPMWorkItemWorkerAssignmentStatus getValue(UIPMWorkItemWorkerAssignment object){
    					return object.getStatus();
    				}
    				public void setValue(UIPMWorkItemWorkerAssignment object,com.fudanmed.platform.core.web.shared.device.UIPMWorkItemWorkerAssignmentStatus value){
    					object.setStatus(value);
    				}
    			};
  
  private Boolean reportWorkItemFinish;
  
  public Boolean getReportWorkItemFinish() {
    return this.reportWorkItemFinish;
  }
  
  public void setReportWorkItemFinish(final Boolean reportWorkItemFinish) {
    this.reportWorkItemFinish = reportWorkItemFinish;
  }
  
  public final static String P_ReportWorkItemFinish = "reportWorkItemFinish";
  
  public static IObjectFieldAccessor<UIPMWorkItemWorkerAssignment,Boolean> ReportWorkItemFinishAccessor = new IObjectFieldAccessor<UIPMWorkItemWorkerAssignment,Boolean>(){
    				public Boolean getValue(UIPMWorkItemWorkerAssignment object){
    					return object.getReportWorkItemFinish();
    				}
    				public void setValue(UIPMWorkItemWorkerAssignment object,Boolean value){
    					object.setReportWorkItemFinish(value);
    				}
    			};
  
  private String workItemFinishComment;
  
  public String getWorkItemFinishComment() {
    return this.workItemFinishComment;
  }
  
  public void setWorkItemFinishComment(final String workItemFinishComment) {
    this.workItemFinishComment = workItemFinishComment;
  }
  
  public final static String P_WorkItemFinishComment = "workItemFinishComment";
  
  public static IObjectFieldAccessor<UIPMWorkItemWorkerAssignment,String> WorkItemFinishCommentAccessor = new IObjectFieldAccessor<UIPMWorkItemWorkerAssignment,String>(){
    				public String getValue(UIPMWorkItemWorkerAssignment object){
    					return object.getWorkItemFinishComment();
    				}
    				public void setValue(UIPMWorkItemWorkerAssignment object,String value){
    					object.setWorkItemFinishComment(value);
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
  
  public static IObjectFieldAccessor<UIPMWorkItemWorkerAssignment,UIPMWorkItemEvaluate> EvaluateAccessor = new IObjectFieldAccessor<UIPMWorkItemWorkerAssignment,UIPMWorkItemEvaluate>(){
    				public com.fudanmed.platform.core.web.shared.device.UIPMWorkItemEvaluate getValue(UIPMWorkItemWorkerAssignment object){
    					return object.getEvaluate();
    				}
    				public void setValue(UIPMWorkItemWorkerAssignment object,com.fudanmed.platform.core.web.shared.device.UIPMWorkItemEvaluate value){
    					object.setEvaluate(value);
    				}
    			};
  
  private Boolean allTaskFinished;
  
  public Boolean getAllTaskFinished() {
    return this.allTaskFinished;
  }
  
  public void setAllTaskFinished(final Boolean allTaskFinished) {
    this.allTaskFinished = allTaskFinished;
  }
  
  public final static String P_AllTaskFinished = "allTaskFinished";
  
  public static IObjectFieldAccessor<UIPMWorkItemWorkerAssignment,Boolean> AllTaskFinishedAccessor = new IObjectFieldAccessor<UIPMWorkItemWorkerAssignment,Boolean>(){
    				public Boolean getValue(UIPMWorkItemWorkerAssignment object){
    					return object.getAllTaskFinished();
    				}
    				public void setValue(UIPMWorkItemWorkerAssignment object,Boolean value){
    					object.setAllTaskFinished(value);
    				}
    			};
  
  private Boolean print;
  
  public Boolean getPrint() {
    return this.print;
  }
  
  public void setPrint(final Boolean print) {
    this.print = print;
  }
  
  public final static String P_Print = "print";
  
  public static IObjectFieldAccessor<UIPMWorkItemWorkerAssignment,Boolean> PrintAccessor = new IObjectFieldAccessor<UIPMWorkItemWorkerAssignment,Boolean>(){
    				public Boolean getValue(UIPMWorkItemWorkerAssignment object){
    					return object.getPrint();
    				}
    				public void setValue(UIPMWorkItemWorkerAssignment object,Boolean value){
    					object.setPrint(value);
    				}
    			};
  
  public RCPMWorkItemWorkerAssignmentProxy toProxy() {
    return (RCPMWorkItemWorkerAssignmentProxy)super.toProxy();
    
  }
}
