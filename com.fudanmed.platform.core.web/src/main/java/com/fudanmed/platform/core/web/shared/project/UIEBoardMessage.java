package com.fudanmed.platform.core.web.shared.project;

import com.fudanmed.platform.core.common.proxy.RCEBoardMessageProxy;
import com.uniquesoft.gwt.shared.GWTEntity;
import com.uniquesoft.gwt.shared.common.IObjectFieldAccessor;

public class UIEBoardMessage extends GWTEntity {
  private String message;
  
  public String getMessage() {
    return this.message;
  }
  
  public void setMessage(final String message) {
    this.message = message;
  }
  
  public final static String P_Message = "message";
  
  public static IObjectFieldAccessor<UIEBoardMessage,String> MessageAccessor = new IObjectFieldAccessor<UIEBoardMessage,String>(){
    				public String getValue(UIEBoardMessage object){
    					return object.getMessage();
    				}
    				public void setValue(UIEBoardMessage object,String value){
    					object.setMessage(value);
    				}
    			};
  
  public RCEBoardMessageProxy toProxy() {
    return (RCEBoardMessageProxy)super.toProxy();
    
  }
}
