package com.fudanmed.platform.core.web.shared.project;

import com.uniquesoft.gwt.shared.datatype.IUIDLEnum;

public enum UIFrequencyProblem implements IUIDLEnum<UIFrequencyProblem> {
  bad,

  good,

  normal;
  
  public String toString() {
    switch(this){
    case bad:
    	return "较低";
    case normal:
    	return "一般";
    case good:
    	return "高";
    	default:
    		return name();
    }
  }
  
  public UIFrequencyProblem fromString(final String value) {
    if( "较低".equals(value))
    	return bad;
    if( "一般".equals(value))
    	return normal;
    if( "高".equals(value))
    	return good;
    	return null;			
    
  }
}
