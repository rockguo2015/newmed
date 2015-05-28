package com.fudanmed.platform.core.web.shared.project;

import com.uniquesoft.gwt.shared.datatype.IUIDLEnum;

public enum UIArrivalTime implements IUIDLEnum<UIArrivalTime> {
  bad,

  good,

  normal;
  
  public String toString() {
    switch(this){
    case bad:
    	return "不及时";
    case normal:
    	return "较及时";
    case good:
    	return "非常及时";
    	default:
    		return name();
    }
  }
  
  public UIArrivalTime fromString(final String value) {
    if( "不及时".equals(value))
    	return bad;
    if( "较及时".equals(value))
    	return normal;
    if( "非常及时".equals(value))
    	return good;
    	return null;			
    
  }
}
