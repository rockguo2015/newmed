package com.fudanmed.platform.core.web.shared.project;

import com.google.gwt.user.client.rpc.IsSerializable;
import com.uniquesoft.gwt.shared.common.IObjectFieldAccessor;
import java.util.Date;

public class GroupTaskMisDispatchReportData implements IsSerializable {
  private Date finishDate;
  
  public Date getFinishDate() {
    return this.finishDate;
  }
  
  public void setFinishDate(final Date finishDate) {
    this.finishDate = finishDate;
  }
  
  public final static String P_FinishDate = "finishDate";
  
  public static IObjectFieldAccessor<GroupTaskMisDispatchReportData,Date> FinishDateAccessor = new IObjectFieldAccessor<GroupTaskMisDispatchReportData,Date>(){
    				public java.util.Date getValue(GroupTaskMisDispatchReportData object){
    					return object.getFinishDate();
    				}
    				public void setValue(GroupTaskMisDispatchReportData object,java.util.Date value){
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
  
  public static IObjectFieldAccessor<GroupTaskMisDispatchReportData,Date> FinishTimeAccessor = new IObjectFieldAccessor<GroupTaskMisDispatchReportData,Date>(){
    				public java.util.Date getValue(GroupTaskMisDispatchReportData object){
    					return object.getFinishTime();
    				}
    				public void setValue(GroupTaskMisDispatchReportData object,java.util.Date value){
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
  
  public static IObjectFieldAccessor<GroupTaskMisDispatchReportData,String> CommentAccessor = new IObjectFieldAccessor<GroupTaskMisDispatchReportData,String>(){
    				public String getValue(GroupTaskMisDispatchReportData object){
    					return object.getComment();
    				}
    				public void setValue(GroupTaskMisDispatchReportData object,String value){
    					object.setComment(value);
    				}
    			};
}
