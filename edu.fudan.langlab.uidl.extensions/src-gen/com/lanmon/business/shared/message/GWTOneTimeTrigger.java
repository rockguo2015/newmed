package com.lanmon.business.shared.message;

import com.uniquesoft.gwt.shared.GWTEntity;
import com.uniquesoft.gwt.shared.common.IObjectFieldAccessor;
import java.util.Date;

public class GWTOneTimeTrigger extends GWTEntity {
  private String message;
  
  public String getMessage() {
    return this.message;
  }
  
  public void setMessage(final String message) {
    this.message = message;
  }
  
  public final static String P_Message = "message";
  
  public static IObjectFieldAccessor<GWTOneTimeTrigger,String> MessageAccessor = new IObjectFieldAccessor<GWTOneTimeTrigger,String>(){
    				public String getValue(GWTOneTimeTrigger object){
    					return object.getMessage();
    				}
    				public void setValue(GWTOneTimeTrigger object,String value){
    					object.setMessage(value);
    				}
    			};
  
  private Date triggerDate;
  
  public Date getTriggerDate() {
    return this.triggerDate;
  }
  
  public void setTriggerDate(final Date triggerDate) {
    this.triggerDate = triggerDate;
  }
  
  public final static String P_TriggerDate = "triggerDate";
  
  public static IObjectFieldAccessor<GWTOneTimeTrigger,Date> TriggerDateAccessor = new IObjectFieldAccessor<GWTOneTimeTrigger,Date>(){
    				public Date getValue(GWTOneTimeTrigger object){
    					return object.getTriggerDate();
    				}
    				public void setValue(GWTOneTimeTrigger object,Date value){
    					object.setTriggerDate(value);
    				}
    			};
}
