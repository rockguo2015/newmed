package com.fudanmed.platform.core.web.shared.device;

import com.google.gwt.user.client.rpc.IsSerializable;
import com.uniquesoft.gwt.shared.common.IObjectFieldAccessor;

public class UIWorkItemPlanAssignmentFinishData implements IsSerializable {
  private String comment;
  
  public String getComment() {
    return this.comment;
  }
  
  public void setComment(final String comment) {
    this.comment = comment;
  }
  
  public final static String P_Comment = "comment";
  
  public static IObjectFieldAccessor<UIWorkItemPlanAssignmentFinishData,String> CommentAccessor = new IObjectFieldAccessor<UIWorkItemPlanAssignmentFinishData,String>(){
    				public String getValue(UIWorkItemPlanAssignmentFinishData object){
    					return object.getComment();
    				}
    				public void setValue(UIWorkItemPlanAssignmentFinishData object,String value){
    					object.setComment(value);
    				}
    			};
  
  private Boolean finished;
  
  public Boolean getFinished() {
    return this.finished;
  }
  
  public void setFinished(final Boolean finished) {
    this.finished = finished;
  }
  
  public final static String P_Finished = "finished";
  
  public static IObjectFieldAccessor<UIWorkItemPlanAssignmentFinishData,Boolean> FinishedAccessor = new IObjectFieldAccessor<UIWorkItemPlanAssignmentFinishData,Boolean>(){
    				public Boolean getValue(UIWorkItemPlanAssignmentFinishData object){
    					return object.getFinished();
    				}
    				public void setValue(UIWorkItemPlanAssignmentFinishData object,Boolean value){
    					object.setFinished(value);
    				}
    			};
}
