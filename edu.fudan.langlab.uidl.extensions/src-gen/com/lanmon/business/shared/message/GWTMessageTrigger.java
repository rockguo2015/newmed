package com.lanmon.business.shared.message;

import com.lanmon.business.shared.message.GWTTriggerState;
import com.lanmon.business.shared.message.TriggerType;
import com.uniquesoft.gwt.shared.GWTEntity;
import com.uniquesoft.gwt.shared.common.IObjectFieldAccessor;
import java.util.Date;

public class GWTMessageTrigger extends GWTEntity {
  private String summary;
  
  public String getSummary() {
    return this.summary;
  }
  
  public void setSummary(final String summary) {
    this.summary = summary;
  }
  
  public final static String P_Summary = "summary";
  
  public static IObjectFieldAccessor<GWTMessageTrigger,String> SummaryAccessor = new IObjectFieldAccessor<GWTMessageTrigger,String>(){
    				public String getValue(GWTMessageTrigger object){
    					return object.getSummary();
    				}
    				public void setValue(GWTMessageTrigger object,String value){
    					object.setSummary(value);
    				}
    			};
  
  private GWTTriggerState state;
  
  public GWTTriggerState getState() {
    return this.state;
  }
  
  public void setState(final GWTTriggerState state) {
    this.state = state;
  }
  
  public final static String P_State = "state";
  
  public static IObjectFieldAccessor<GWTMessageTrigger,GWTTriggerState> StateAccessor = new IObjectFieldAccessor<GWTMessageTrigger,GWTTriggerState>(){
    				public GWTTriggerState getValue(GWTMessageTrigger object){
    					return object.getState();
    				}
    				public void setValue(GWTMessageTrigger object,GWTTriggerState value){
    					object.setState(value);
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
  
  public static IObjectFieldAccessor<GWTMessageTrigger,Date> TriggerDateAccessor = new IObjectFieldAccessor<GWTMessageTrigger,Date>(){
    				public Date getValue(GWTMessageTrigger object){
    					return object.getTriggerDate();
    				}
    				public void setValue(GWTMessageTrigger object,Date value){
    					object.setTriggerDate(value);
    				}
    			};
  
  private TriggerType triggerType;
  
  public TriggerType getTriggerType() {
    return this.triggerType;
  }
  
  public void setTriggerType(final TriggerType triggerType) {
    this.triggerType = triggerType;
  }
  
  public final static String P_TriggerType = "triggerType";
  
  public static IObjectFieldAccessor<GWTMessageTrigger,TriggerType> TriggerTypeAccessor = new IObjectFieldAccessor<GWTMessageTrigger,TriggerType>(){
    				public TriggerType getValue(GWTMessageTrigger object){
    					return object.getTriggerType();
    				}
    				public void setValue(GWTMessageTrigger object,TriggerType value){
    					object.setTriggerType(value);
    				}
    			};
}
