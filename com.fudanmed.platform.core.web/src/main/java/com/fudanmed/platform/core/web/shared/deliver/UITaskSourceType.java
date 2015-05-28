package com.fudanmed.platform.core.web.shared.deliver;

import com.uniquesoft.gwt.shared.datatype.IUIDLEnum;

public enum UITaskSourceType implements IUIDLEnum<UITaskSourceType> {
  curtomerRequest,

  imported;
  
  public String toString() {
    switch(this){
    case curtomerRequest:
    	return "科室请求";
    case imported:
    	return "HIS系统导入";
    	default:
    		return name();
    }
  }
  
  public UITaskSourceType fromString(final String value) {
    if( "科室请求".equals(value))
    	return curtomerRequest;
    if( "HIS系统导入".equals(value))
    	return imported;
    	return null;			
    
  }
}
