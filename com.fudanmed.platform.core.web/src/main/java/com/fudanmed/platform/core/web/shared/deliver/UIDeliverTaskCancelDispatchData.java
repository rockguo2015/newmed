package com.fudanmed.platform.core.web.shared.deliver;

import com.google.gwt.user.client.rpc.IsSerializable;
import com.uniquesoft.gwt.shared.common.IObjectFieldAccessor;

public class UIDeliverTaskCancelDispatchData implements IsSerializable {
  private String comment;
  
  public String getComment() {
    return this.comment;
  }
  
  public void setComment(final String comment) {
    this.comment = comment;
  }
  
  public final static String P_Comment = "comment";
  
  public static IObjectFieldAccessor<UIDeliverTaskCancelDispatchData,String> CommentAccessor = new IObjectFieldAccessor<UIDeliverTaskCancelDispatchData,String>(){
    				public String getValue(UIDeliverTaskCancelDispatchData object){
    					return object.getComment();
    				}
    				public void setValue(UIDeliverTaskCancelDispatchData object,String value){
    					object.setComment(value);
    				}
    			};
}
