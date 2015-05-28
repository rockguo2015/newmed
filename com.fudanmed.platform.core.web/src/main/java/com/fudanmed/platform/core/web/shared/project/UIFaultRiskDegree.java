package com.fudanmed.platform.core.web.shared.project;

import com.uniquesoft.gwt.shared.datatype.IUIDLEnum;

public enum UIFaultRiskDegree implements IUIDLEnum<UIFaultRiskDegree> {
  jiaoda,

  yanzhong,

  yiban,

  zhongda;
  
  public String toString() {
    switch(this){
    case jiaoda:
    	return "较大";
    case yanzhong:
    	return "严重";
    case yiban:
    	return "一般";
    case zhongda:
    	return "重大";
    	default:
    		return name();
    }
  }
  
  public UIFaultRiskDegree fromString(final String value) {
    if( "较大".equals(value))
    	return jiaoda;
    if( "严重".equals(value))
    	return yanzhong;
    if( "一般".equals(value))
    	return yiban;
    if( "重大".equals(value))
    	return zhongda;
    	return null;			
    
  }
}
