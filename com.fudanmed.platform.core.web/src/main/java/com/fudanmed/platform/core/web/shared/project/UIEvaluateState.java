package com.fudanmed.platform.core.web.shared.project;

import com.uniquesoft.gwt.shared.datatype.IUIDLEnum;

public enum UIEvaluateState implements IUIDLEnum<UIEvaluateState> {
  autoCommitted,

  finished,

  notReady,

  waiting;
  
  public String toString() {
    switch(this){
    case autoCommitted:
    	return "已自动评价";
    case finished:
    	return "已评价";
    case notReady:
    	return "";
    case waiting:
    	return "待评价";
    	default:
    		return name();
    }
  }
  
  public UIEvaluateState fromString(final String value) {
    if( "已自动评价".equals(value))
    	return autoCommitted;
    if( "已评价".equals(value))
    	return finished;
    if( "".equals(value))
    	return notReady;
    if( "待评价".equals(value))
    	return waiting;
    	return null;			
    
  }
}
