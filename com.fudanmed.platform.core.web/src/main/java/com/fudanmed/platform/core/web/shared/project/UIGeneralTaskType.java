package com.fudanmed.platform.core.web.shared.project;

import com.uniquesoft.gwt.shared.datatype.IUIDLEnum;

public enum UIGeneralTaskType implements IUIDLEnum<UIGeneralTaskType> {
  workitemTask,

  groupTask;
  
  public String toString() {
    switch(this){
    case workitemTask:
    	return "派发工单";
    case groupTask:
    	return "派发班组";
    	default:
    		return name();
    }
  }
  
  public UIGeneralTaskType fromString(final String value) {
    if( "派发工单".equals(value))
    	return workitemTask;
    if( "派发班组".equals(value))
    	return groupTask;
    	return null;			
    
  }
}
