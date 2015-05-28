package com.fudanmed.platform.core.web.shared.deliver;

import com.uniquesoft.gwt.shared.datatype.IUIDLEnum;

public enum UIPatientCheckDeliverTaskEventType implements IUIDLEnum<UIPatientCheckDeliverTaskEventType> {
  cancel,

  cancelDispatch,

  create,

  dispatch,

  finish,

  performUpdate;
  
  public String toString() {
    switch(this){
    case create:
    	return "新建";
    case performUpdate:
    	return "修改";
    case dispatch:
    	return "派发";
    case cancel:
    	return "取消";
    case cancelDispatch:
    	return "取消派发";
    case finish:
    	return "完成任务";
    	default:
    		return name();
    }
  }
  
  public UIPatientCheckDeliverTaskEventType fromString(final String value) {
    if( "新建".equals(value))
    	return create;
    if( "修改".equals(value))
    	return performUpdate;
    if( "派发".equals(value))
    	return dispatch;
    if( "取消".equals(value))
    	return cancel;
    if( "取消派发".equals(value))
    	return cancelDispatch;
    if( "完成任务".equals(value))
    	return finish;
    	return null;			
    
  }
}
