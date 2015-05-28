package com.fudanmed.platform.core.web.shared.device;

import com.google.gwt.user.client.rpc.IsSerializable;
import com.uniquesoft.gwt.shared.common.IObjectFieldAccessor;

public class RangeValueData implements IsSerializable {
  private Double lower;
  
  public Double getLower() {
    return this.lower;
  }
  
  public void setLower(final Double lower) {
    this.lower = lower;
  }
  
  public final static String P_Lower = "lower";
  
  public static IObjectFieldAccessor<RangeValueData,Double> LowerAccessor = new IObjectFieldAccessor<RangeValueData,Double>(){
    				public Double getValue(RangeValueData object){
    					return object.getLower();
    				}
    				public void setValue(RangeValueData object,Double value){
    					object.setLower(value);
    				}
    			};
  
  private Double upper;
  
  public Double getUpper() {
    return this.upper;
  }
  
  public void setUpper(final Double upper) {
    this.upper = upper;
  }
  
  public final static String P_Upper = "upper";
  
  public static IObjectFieldAccessor<RangeValueData,Double> UpperAccessor = new IObjectFieldAccessor<RangeValueData,Double>(){
    				public Double getValue(RangeValueData object){
    					return object.getUpper();
    				}
    				public void setValue(RangeValueData object,Double value){
    					object.setUpper(value);
    				}
    			};
}
