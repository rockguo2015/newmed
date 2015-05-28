package com.fudanmed.platform.core.web.shared.device;

import com.google.gwt.user.client.rpc.IsSerializable;
import com.uniquesoft.gwt.shared.common.IObjectFieldAccessor;
import java.util.Date;

public class DateValueData implements IsSerializable {
  private Date theValue;
  
  public Date getTheValue() {
    return this.theValue;
  }
  
  public void setTheValue(final Date theValue) {
    this.theValue = theValue;
  }
  
  public final static String P_TheValue = "theValue";
  
  public static IObjectFieldAccessor<DateValueData,Date> TheValueAccessor = new IObjectFieldAccessor<DateValueData,Date>(){
    				public java.util.Date getValue(DateValueData object){
    					return object.getTheValue();
    				}
    				public void setValue(DateValueData object,java.util.Date value){
    					object.setTheValue(value);
    				}
    			};
}
