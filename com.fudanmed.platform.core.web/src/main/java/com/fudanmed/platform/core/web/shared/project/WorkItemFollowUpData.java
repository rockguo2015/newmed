package com.fudanmed.platform.core.web.shared.project;

import com.google.gwt.user.client.rpc.IsSerializable;
import com.uniquesoft.gwt.shared.common.IObjectFieldAccessor;
import java.util.Date;

public class WorkItemFollowUpData implements IsSerializable {
  private Date finishDate;
  
  public Date getFinishDate() {
    return this.finishDate;
  }
  
  public void setFinishDate(final Date finishDate) {
    this.finishDate = finishDate;
  }
  
  public final static String P_FinishDate = "finishDate";
  
  public static IObjectFieldAccessor<WorkItemFollowUpData,Date> FinishDateAccessor = new IObjectFieldAccessor<WorkItemFollowUpData,Date>(){
    				public java.util.Date getValue(WorkItemFollowUpData object){
    					return object.getFinishDate();
    				}
    				public void setValue(WorkItemFollowUpData object,java.util.Date value){
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
  
  public static IObjectFieldAccessor<WorkItemFollowUpData,Date> FinishTimeAccessor = new IObjectFieldAccessor<WorkItemFollowUpData,Date>(){
    				public java.util.Date getValue(WorkItemFollowUpData object){
    					return object.getFinishTime();
    				}
    				public void setValue(WorkItemFollowUpData object,java.util.Date value){
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
  
  public static IObjectFieldAccessor<WorkItemFollowUpData,String> CommentAccessor = new IObjectFieldAccessor<WorkItemFollowUpData,String>(){
    				public String getValue(WorkItemFollowUpData object){
    					return object.getComment();
    				}
    				public void setValue(WorkItemFollowUpData object,String value){
    					object.setComment(value);
    				}
    			};
}
