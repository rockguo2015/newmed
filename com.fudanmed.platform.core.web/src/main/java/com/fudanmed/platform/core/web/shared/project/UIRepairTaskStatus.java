package com.fudanmed.platform.core.web.shared.project;

import com.uniquesoft.gwt.shared.datatype.IUIDLEnum;

public enum UIRepairTaskStatus implements IUIDLEnum<UIRepairTaskStatus> {
  cancel,

  closed,

  newCreated,

  scheduled,

  wait4Close,

  wait4GroupTaskFinish,

  wait4SchedulerProcess;
  
  public String toString() {
    switch(this){
    case newCreated:
    	return "新建";
    case scheduled:
    	return "已调度";
    case wait4GroupTaskFinish:
    	return "维修";
    case wait4SchedulerProcess:
    	return "串单待重调";
    case wait4Close:
    	return "待结单";
    case cancel:
    	return "取消";
    case closed:
    	return "完成";
    	default:
    		return name();
    }
  }
  
  public UIRepairTaskStatus fromString(final String value) {
    if( "新建".equals(value))
    	return newCreated;
    if( "已调度".equals(value))
    	return scheduled;
    if( "维修".equals(value))
    	return wait4GroupTaskFinish;
    if( "串单待重调".equals(value))
    	return wait4SchedulerProcess;
    if( "待结单".equals(value))
    	return wait4Close;
    if( "取消".equals(value))
    	return cancel;
    if( "完成".equals(value))
    	return closed;
    	return null;			
    
  }
}
