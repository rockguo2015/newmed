package com.fudanmed.platform.core.web.shared.project;

import com.google.gwt.user.client.rpc.IsSerializable;
import com.uniquesoft.gwt.shared.common.IObjectFieldAccessor;
import java.util.Date;

public class WorkItemMisDispatchingData implements IsSerializable {
  private Date finishDate;
  
  public Date getFinishDate() {
    return this.finishDate;
  }
  
  public void setFinishDate(final Date finishDate) {
    this.finishDate = finishDate;
  }
  
  public final static String P_FinishDate = "finishDate";
  
  public static IObjectFieldAccessor<WorkItemMisDispatchingData,Date> FinishDateAccessor = new IObjectFieldAccessor<WorkItemMisDispatchingData,Date>(){
    				public java.util.Date getValue(WorkItemMisDispatchingData object){
    					return object.getFinishDate();
    				}
    				public void setValue(WorkItemMisDispatchingData object,java.util.Date value){
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
  
  public static IObjectFieldAccessor<WorkItemMisDispatchingData,Date> FinishTimeAccessor = new IObjectFieldAccessor<WorkItemMisDispatchingData,Date>(){
    				public java.util.Date getValue(WorkItemMisDispatchingData object){
    					return object.getFinishTime();
    				}
    				public void setValue(WorkItemMisDispatchingData object,java.util.Date value){
    					object.setFinishTime(value);
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
  
  public static IObjectFieldAccessor<WorkItemMisDispatchingData,String> CommentAccessor = new IObjectFieldAccessor<WorkItemMisDispatchingData,String>(){
    				public String getValue(WorkItemMisDispatchingData object){
    					return object.getComment();
    				}
    				public void setValue(WorkItemMisDispatchingData object,String value){
    					object.setComment(value);
    				}
    			};
  
  private Boolean alsoReport;
  
  public Boolean getAlsoReport() {
    return this.alsoReport;
  }
  
  public void setAlsoReport(final Boolean alsoReport) {
    this.alsoReport = alsoReport;
  }
  
  public final static String P_AlsoReport = "alsoReport";
  
  public static IObjectFieldAccessor<WorkItemMisDispatchingData,Boolean> AlsoReportAccessor = new IObjectFieldAccessor<WorkItemMisDispatchingData,Boolean>(){
    				public Boolean getValue(WorkItemMisDispatchingData object){
    					return object.getAlsoReport();
    				}
    				public void setValue(WorkItemMisDispatchingData object,Boolean value){
    					object.setAlsoReport(value);
    				}
    			};
  
  private String reportComment;
  
  public String getReportComment() {
    return this.reportComment;
  }
  
  public void setReportComment(final String reportComment) {
    this.reportComment = reportComment;
  }
  
  public final static String P_ReportComment = "reportComment";
  
  public static IObjectFieldAccessor<WorkItemMisDispatchingData,String> ReportCommentAccessor = new IObjectFieldAccessor<WorkItemMisDispatchingData,String>(){
    				public String getValue(WorkItemMisDispatchingData object){
    					return object.getReportComment();
    				}
    				public void setValue(WorkItemMisDispatchingData object,String value){
    					object.setReportComment(value);
    				}
    			};
}
