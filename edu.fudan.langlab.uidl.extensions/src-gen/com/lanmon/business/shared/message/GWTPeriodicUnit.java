package com.lanmon.business.shared.message;

public enum GWTPeriodicUnit {
  Day,

  Week,

  Month;
  
  public String toString() {
    switch(this){
    case Day:
    	return "日";
    case Week:
    	return "周";
    case Month:
    	return "月";
    	default:
    		return "";
    }
  }
}
