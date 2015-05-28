package com.fudanmed.platform.core.web.shared.project;

import com.uniquesoft.gwt.shared.datatype.IUIDLEnum;

public enum UIServiceAttitude implements IUIDLEnum<UIServiceAttitude> {
  bad,

  good,

  normal;
  
  public String toString() {
    switch(this){
    case bad:
    	return "不满意";
    case normal:
    	return "较满意";
    case good:
    	return "非常满意";
    	default:
    		return name();
    }
  }
  
  public UIServiceAttitude fromString(final String value) {
    if( "不满意".equals(value))
    	return bad;
    if( "较满意".equals(value))
    	return normal;
    if( "非常满意".equals(value))
    	return good;
    	return null;			
    
  }
}
