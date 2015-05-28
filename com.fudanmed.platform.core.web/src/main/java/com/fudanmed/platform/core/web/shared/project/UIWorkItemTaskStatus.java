package com.fudanmed.platform.core.web.shared.project;

import com.uniquesoft.gwt.shared.datatype.IUIDLEnum;

public enum UIWorkItemTaskStatus implements IUIDLEnum<UIWorkItemTaskStatus> {
  canceled,

  finished,

  followuping,

  misDispatching,

  outsourceFinish,

  outsourcing,

  pendFinish,

  pending,

  processing;
  
  public String toString() {
    switch(this){
    case processing:
    	return "维修";
    case followuping:
    	return "跟进";
    case finished:
    	return "完工";
    case pending:
    	return "挂单中";
    case pendFinish:
    	return "完工[挂单已处理]";
    case outsourcing:
    	return "需外协";
    case outsourceFinish:
    	return "完工[外协已处理]";
    case misDispatching:
    	return "完工[串单重调]";
    	default:
    		return name();
    }
  }
  
  public UIWorkItemTaskStatus fromString(final String value) {
    if( "维修".equals(value))
    	return processing;
    if( "跟进".equals(value))
    	return followuping;
    if( "完工".equals(value))
    	return finished;
    if( "挂单中".equals(value))
    	return pending;
    if( "完工[挂单已处理]".equals(value))
    	return pendFinish;
    if( "需外协".equals(value))
    	return outsourcing;
    if( "完工[外协已处理]".equals(value))
    	return outsourceFinish;
    if( "完工[串单重调]".equals(value))
    	return misDispatching;
    	return null;			
    
  }
}
