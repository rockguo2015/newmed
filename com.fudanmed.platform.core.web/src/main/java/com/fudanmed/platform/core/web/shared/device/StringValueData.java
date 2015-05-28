package com.fudanmed.platform.core.web.shared.device;

import com.google.gwt.user.client.rpc.IsSerializable;
import com.uniquesoft.gwt.shared.common.IObjectFieldAccessor;

public class StringValueData implements IsSerializable {
  private String theValue;
  
  public String getTheValue() {
    return this.theValue;
  }
  
  public void setTheValue(final String theValue) {
    this.theValue = theValue;
  }
  
  public final static String P_TheValue = "theValue";
  
  public static IObjectFieldAccessor<StringValueData,String> TheValueAccessor = new IObjectFieldAccessor<StringValueData,String>(){
    				public String getValue(StringValueData object){
    					return object.getTheValue();
    				}
    				public void setValue(StringValueData object,String value){
    					object.setTheValue(value);
    				}
    			};
}
