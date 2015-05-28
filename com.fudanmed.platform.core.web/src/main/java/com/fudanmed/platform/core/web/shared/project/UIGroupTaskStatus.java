package com.fudanmed.platform.core.web.shared.project;

import com.uniquesoft.gwt.shared.datatype.IUIDLEnum;

public enum UIGroupTaskStatus implements IUIDLEnum<UIGroupTaskStatus> {
  canceled,

  finished,

  misDispatched,

  newCreated,

  wait4TasksFinish,

  wait4TeamOwnerProcess;
  
  public String toString() {
    switch(this){
    case newCreated:
    	return "新建";
    case wait4TasksFinish:
    	return "维修";
    case finished:
    	return "完工";
    case misDispatched:
    	return "完工[串单]";
    case wait4TeamOwnerProcess:
    	return "待结单";
    case canceled:
    	return "已取消";
    	default:
    		return name();
    }
  }
  
  public UIGroupTaskStatus fromString(final String value) {
    if( "新建".equals(value))
    	return newCreated;
    if( "维修".equals(value))
    	return wait4TasksFinish;
    if( "完工".equals(value))
    	return finished;
    if( "完工[串单]".equals(value))
    	return misDispatched;
    if( "待结单".equals(value))
    	return wait4TeamOwnerProcess;
    if( "已取消".equals(value))
    	return canceled;
    	return null;			
    
  }
}
