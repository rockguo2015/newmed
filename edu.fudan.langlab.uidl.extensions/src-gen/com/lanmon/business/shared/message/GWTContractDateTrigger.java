package com.lanmon.business.shared.message;

import com.lanmon.business.shared.message.GWTContractDateTriggerType;
import com.uniquesoft.gwt.shared.GWTEntity;
import com.uniquesoft.gwt.shared.GWTNamedEntity;
import com.uniquesoft.gwt.shared.common.IObjectFieldAccessor;
import java.util.Date;

public class GWTContractDateTrigger extends GWTEntity {
  private GWTNamedEntity customer;
  
  public GWTNamedEntity getCustomer() {
    return this.customer;
  }
  
  public void setCustomer(final GWTNamedEntity customer) {
    this.customer = customer;
  }
  
  public final static String P_Customer = "customer";
  
  public static IObjectFieldAccessor<GWTContractDateTrigger,GWTNamedEntity> CustomerAccessor = new IObjectFieldAccessor<GWTContractDateTrigger,GWTNamedEntity>(){
    				public GWTNamedEntity getValue(GWTContractDateTrigger object){
    					return object.getCustomer();
    				}
    				public void setValue(GWTContractDateTrigger object,GWTNamedEntity value){
    					object.setCustomer(value);
    				}
    			};
  
  private GWTContractDateTriggerType type;
  
  public GWTContractDateTriggerType getType() {
    return this.type;
  }
  
  public void setType(final GWTContractDateTriggerType type) {
    this.type = type;
  }
  
  public final static String P_Type = "type";
  
  public static IObjectFieldAccessor<GWTContractDateTrigger,GWTContractDateTriggerType> TypeAccessor = new IObjectFieldAccessor<GWTContractDateTrigger,GWTContractDateTriggerType>(){
    				public GWTContractDateTriggerType getValue(GWTContractDateTrigger object){
    					return object.getType();
    				}
    				public void setValue(GWTContractDateTrigger object,GWTContractDateTriggerType value){
    					object.setType(value);
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
  
  public static IObjectFieldAccessor<GWTContractDateTrigger,Date> TriggerDateAccessor = new IObjectFieldAccessor<GWTContractDateTrigger,Date>(){
    				public Date getValue(GWTContractDateTrigger object){
    					return object.getTriggerDate();
    				}
    				public void setValue(GWTContractDateTrigger object,Date value){
    					object.setTriggerDate(value);
    				}
    			};
}
