package com.fudanmed.platform.core.web.shared.device;

import com.uniquesoft.gwt.shared.datatype.IUIDLEnum;

public enum UIDevicePMPlanStatus implements IUIDLEnum<UIDevicePMPlanStatus> {
  assigned,

  finished,

  planed,

  workerAssigned;
  
  public String toString() {
    switch(this){
    case assigned:
    	return "待派工";
    case planed:
    	return "待安排";
    case finished:
    	return "已维保";
    case workerAssigned:
    	return "执行中";
    	default:
    		return name();
    }
  }
  
  public UIDevicePMPlanStatus fromString(final String value) {
    if( "待派工".equals(value))
    	return assigned;
    if( "待安排".equals(value))
    	return planed;
    if( "已维保".equals(value))
    	return finished;
    if( "执行中".equals(value))
    	return workerAssigned;
    	return null;			
    
  }
}
