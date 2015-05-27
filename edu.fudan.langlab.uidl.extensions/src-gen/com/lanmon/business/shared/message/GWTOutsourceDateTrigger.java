package com.lanmon.business.shared.message;

import com.uniquesoft.gwt.shared.GWTEntity;
import com.uniquesoft.gwt.shared.GWTNamedEntity;
import com.uniquesoft.gwt.shared.common.IObjectFieldAccessor;
import java.util.Date;

public class GWTOutsourceDateTrigger extends GWTEntity {
  private GWTNamedEntity customer;
  
  public GWTNamedEntity getCustomer() {
    return this.customer;
  }
  
  public void setCustomer(final GWTNamedEntity customer) {
    this.customer = customer;
  }
  
  public final static String P_Customer = "customer";
  
  public static IObjectFieldAccessor<GWTOutsourceDateTrigger,GWTNamedEntity> CustomerAccessor = new IObjectFieldAccessor<GWTOutsourceDateTrigger,GWTNamedEntity>(){
    				public GWTNamedEntity getValue(GWTOutsourceDateTrigger object){
    					return object.getCustomer();
    				}
    				public void setValue(GWTOutsourceDateTrigger object,GWTNamedEntity value){
    					object.setCustomer(value);
    				}
    			};
  
  private Date nextTriggleDate;
  
  public Date getNextTriggleDate() {
    return this.nextTriggleDate;
  }
  
  public void setNextTriggleDate(final Date nextTriggleDate) {
    this.nextTriggleDate = nextTriggleDate;
  }
  
  public final static String P_NextTriggleDate = "nextTriggleDate";
  
  public static IObjectFieldAccessor<GWTOutsourceDateTrigger,Date> NextTriggleDateAccessor = new IObjectFieldAccessor<GWTOutsourceDateTrigger,Date>(){
    				public Date getValue(GWTOutsourceDateTrigger object){
    					return object.getNextTriggleDate();
    				}
    				public void setValue(GWTOutsourceDateTrigger object,Date value){
    					object.setNextTriggleDate(value);
    				}
    			};
}
