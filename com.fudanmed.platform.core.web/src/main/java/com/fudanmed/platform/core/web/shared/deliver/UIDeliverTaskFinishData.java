package com.fudanmed.platform.core.web.shared.deliver;

import com.google.gwt.user.client.rpc.IsSerializable;
import com.uniquesoft.gwt.shared.common.IObjectFieldAccessor;

public class UIDeliverTaskFinishData implements IsSerializable {
  private String comment;
  
  public String getComment() {
    return this.comment;
  }
  
  public void setComment(final String comment) {
    this.comment = comment;
  }
  
  public final static String P_Comment = "comment";
  
  public static IObjectFieldAccessor<UIDeliverTaskFinishData,String> CommentAccessor = new IObjectFieldAccessor<UIDeliverTaskFinishData,String>(){
    				public String getValue(UIDeliverTaskFinishData object){
    					return object.getComment();
    				}
    				public void setValue(UIDeliverTaskFinishData object,String value){
    					object.setComment(value);
    				}
    			};
}
