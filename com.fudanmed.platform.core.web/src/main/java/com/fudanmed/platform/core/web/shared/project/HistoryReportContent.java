package com.fudanmed.platform.core.web.shared.project;

import com.google.gwt.user.client.rpc.IsSerializable;
import com.uniquesoft.gwt.shared.common.IObjectFieldAccessor;

public class HistoryReportContent implements IsSerializable {
  private String comment;
  
  public String getComment() {
    return this.comment;
  }
  
  public void setComment(final String comment) {
    this.comment = comment;
  }
  
  public final static String P_Comment = "comment";
  
  public static IObjectFieldAccessor<HistoryReportContent,String> CommentAccessor = new IObjectFieldAccessor<HistoryReportContent,String>(){
    				public String getValue(HistoryReportContent object){
    					return object.getComment();
    				}
    				public void setValue(HistoryReportContent object,String value){
    					object.setComment(value);
    				}
    			};
}
