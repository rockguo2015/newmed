package com.fudanmed.platform.core.web.shared.device;

import com.fudanmed.platform.core.web.shared.device.UIPMWorkItemEvaluate;
import com.google.gwt.user.client.rpc.IsSerializable;
import com.uniquesoft.gwt.shared.common.IObjectFieldAccessor;
import java.util.Date;

public class UIPMWorkItemTeamFinishReportData implements IsSerializable {
  private Date finishDate;
  
  public Date getFinishDate() {
    return this.finishDate;
  }
  
  public void setFinishDate(final Date finishDate) {
    this.finishDate = finishDate;
  }
  
  public final static String P_FinishDate = "finishDate";
  
  public static IObjectFieldAccessor<UIPMWorkItemTeamFinishReportData,Date> FinishDateAccessor = new IObjectFieldAccessor<UIPMWorkItemTeamFinishReportData,Date>(){
    				public java.util.Date getValue(UIPMWorkItemTeamFinishReportData object){
    					return object.getFinishDate();
    				}
    				public void setValue(UIPMWorkItemTeamFinishReportData object,java.util.Date value){
    					object.setFinishDate(value);
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
  
  public static IObjectFieldAccessor<UIPMWorkItemTeamFinishReportData,String> CommentAccessor = new IObjectFieldAccessor<UIPMWorkItemTeamFinishReportData,String>(){
    				public String getValue(UIPMWorkItemTeamFinishReportData object){
    					return object.getComment();
    				}
    				public void setValue(UIPMWorkItemTeamFinishReportData object,String value){
    					object.setComment(value);
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
  
  public static IObjectFieldAccessor<UIPMWorkItemTeamFinishReportData,UIPMWorkItemEvaluate> EvaluateAccessor = new IObjectFieldAccessor<UIPMWorkItemTeamFinishReportData,UIPMWorkItemEvaluate>(){
    				public com.fudanmed.platform.core.web.shared.device.UIPMWorkItemEvaluate getValue(UIPMWorkItemTeamFinishReportData object){
    					return object.getEvaluate();
    				}
    				public void setValue(UIPMWorkItemTeamFinishReportData object,com.fudanmed.platform.core.web.shared.device.UIPMWorkItemEvaluate value){
    					object.setEvaluate(value);
    				}
    			};
}
