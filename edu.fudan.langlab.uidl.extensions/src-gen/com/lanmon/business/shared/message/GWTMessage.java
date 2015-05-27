package com.lanmon.business.shared.message;

import com.uniquesoft.gwt.shared.GWTEntity;
import com.uniquesoft.gwt.shared.GWTNamedEntity;
import com.uniquesoft.gwt.shared.common.IObjectFieldAccessor;
import java.util.Date;

public class GWTMessage extends GWTEntity {
  private String type;
  
  public String getType() {
    return this.type;
  }
  
  public void setType(final String type) {
    this.type = type;
  }
  
  public final static String P_Type = "type";
  
  public static IObjectFieldAccessor<GWTMessage,String> TypeAccessor = new IObjectFieldAccessor<GWTMessage,String>(){
    				public String getValue(GWTMessage object){
    					return object.getType();
    				}
    				public void setValue(GWTMessage object,String value){
    					object.setType(value);
    				}
    			};
  
  private String title;
  
  public String getTitle() {
    return this.title;
  }
  
  public void setTitle(final String title) {
    this.title = title;
  }
  
  public final static String P_Title = "title";
  
  public static IObjectFieldAccessor<GWTMessage,String> TitleAccessor = new IObjectFieldAccessor<GWTMessage,String>(){
    				public String getValue(GWTMessage object){
    					return object.getTitle();
    				}
    				public void setValue(GWTMessage object,String value){
    					object.setTitle(value);
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
  
  public static IObjectFieldAccessor<GWTMessage,Date> TriggerDateAccessor = new IObjectFieldAccessor<GWTMessage,Date>(){
    				public Date getValue(GWTMessage object){
    					return object.getTriggerDate();
    				}
    				public void setValue(GWTMessage object,Date value){
    					object.setTriggerDate(value);
    				}
    			};
  
  private GWTNamedEntity customer;
  
  public GWTNamedEntity getCustomer() {
    return this.customer;
  }
  
  public void setCustomer(final GWTNamedEntity customer) {
    this.customer = customer;
  }
  
  public final static String P_Customer = "customer";
  
  public static IObjectFieldAccessor<GWTMessage,GWTNamedEntity> CustomerAccessor = new IObjectFieldAccessor<GWTMessage,GWTNamedEntity>(){
    				public GWTNamedEntity getValue(GWTMessage object){
    					return object.getCustomer();
    				}
    				public void setValue(GWTMessage object,GWTNamedEntity value){
    					object.setCustomer(value);
    				}
    			};
}
