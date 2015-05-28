package com.fudanmed.platform.core.web.shared.deliver;

import com.uniquesoft.gwt.shared.datatype.IUIDLEnum;

public enum UICenterlizedDeliverTaskStatus implements IUIDLEnum<UICenterlizedDeliverTaskStatus> {
  canceled,

  dispatched,

  finished,

  scheduled;
  
  public String toString() {
    switch(this){
    case canceled:
    	return "已取消";
    case dispatched:
    	return "已派发";
    case finished:
    	return "已完成";
    case scheduled:
    	return "新建";
    	default:
    		return name();
    }
  }
  
  public UICenterlizedDeliverTaskStatus fromString(final String value) {
    if( "已取消".equals(value))
    	return canceled;
    if( "已派发".equals(value))
    	return dispatched;
    if( "已完成".equals(value))
    	return finished;
    if( "新建".equals(value))
    	return scheduled;
    	return null;			
    
  }
}
