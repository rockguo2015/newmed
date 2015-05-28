package com.fudanmed.platform.core.web.shared.device;

import com.google.gwt.user.client.rpc.IsSerializable;
import com.uniquesoft.gwt.shared.common.IObjectFieldAccessor;

public class NumberValueData implements IsSerializable {
  private Double theValue;
  
  public Double getTheValue() {
    return this.theValue;
  }
  
  public void setTheValue(final Double theValue) {
    this.theValue = theValue;
  }
  
  public final static String P_TheValue = "theValue";
  
  public static IObjectFieldAccessor<NumberValueData,Double> TheValueAccessor = new IObjectFieldAccessor<NumberValueData,Double>(){
    				public Double getValue(NumberValueData object){
    					return object.getTheValue();
    				}
    				public void setValue(NumberValueData object,Double value){
    					object.setTheValue(value);
    				}
    			};
}
