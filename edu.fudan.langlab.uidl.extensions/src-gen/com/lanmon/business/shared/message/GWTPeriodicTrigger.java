package com.lanmon.business.shared.message;

import com.lanmon.business.shared.message.GWTPeriodicUnit;
import com.uniquesoft.gwt.shared.GWTEntity;
import com.uniquesoft.gwt.shared.common.IObjectFieldAccessor;
import java.util.Date;

public class GWTPeriodicTrigger extends GWTEntity {
  private String message;
  
  public String getMessage() {
    return this.message;
  }
  
  public void setMessage(final String message) {
    this.message = message;
  }
  
  public final static String P_Message = "message";
  
  public static IObjectFieldAccessor<GWTPeriodicTrigger,String> MessageAccessor = new IObjectFieldAccessor<GWTPeriodicTrigger,String>(){
    				public String getValue(GWTPeriodicTrigger object){
    					return object.getMessage();
    				}
    				public void setValue(GWTPeriodicTrigger object,String value){
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
  
  public static IObjectFieldAccessor<GWTPeriodicTrigger,Date> TriggerDateAccessor = new IObjectFieldAccessor<GWTPeriodicTrigger,Date>(){
    				public Date getValue(GWTPeriodicTrigger object){
    					return object.getTriggerDate();
    				}
    				public void setValue(GWTPeriodicTrigger object,Date value){
    					object.setTriggerDate(value);
    				}
    			};
  
  private Integer timeInterval;
  
  public Integer getTimeInterval() {
    return this.timeInterval;
  }
  
  public void setTimeInterval(final Integer timeInterval) {
    this.timeInterval = timeInterval;
  }
  
  public final static String P_TimeInterval = "timeInterval";
  
  public static IObjectFieldAccessor<GWTPeriodicTrigger,Integer> TimeIntervalAccessor = new IObjectFieldAccessor<GWTPeriodicTrigger,Integer>(){
    				public Integer getValue(GWTPeriodicTrigger object){
    					return object.getTimeInterval();
    				}
    				public void setValue(GWTPeriodicTrigger object,Integer value){
    					object.setTimeInterval(value);
    				}
    			};
  
  private GWTPeriodicUnit unit;
  
  public GWTPeriodicUnit getUnit() {
    return this.unit;
  }
  
  public void setUnit(final GWTPeriodicUnit unit) {
    this.unit = unit;
  }
  
  public final static String P_Unit = "unit";
  
  public static IObjectFieldAccessor<GWTPeriodicTrigger,GWTPeriodicUnit> UnitAccessor = new IObjectFieldAccessor<GWTPeriodicTrigger,GWTPeriodicUnit>(){
    				public GWTPeriodicUnit getValue(GWTPeriodicTrigger object){
    					return object.getUnit();
    				}
    				public void setValue(GWTPeriodicTrigger object,GWTPeriodicUnit value){
    					object.setUnit(value);
    				}
    			};
}
