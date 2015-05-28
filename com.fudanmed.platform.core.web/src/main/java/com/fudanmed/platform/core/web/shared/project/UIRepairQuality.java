package com.fudanmed.platform.core.web.shared.project;

import com.uniquesoft.gwt.shared.datatype.IUIDLEnum;

public enum UIRepairQuality implements IUIDLEnum<UIRepairQuality> {
  bad,

  good,

  normal;
  
  public String toString() {
    switch(this){
    case bad:
    	return "较差";
    case normal:
    	return "较好";
    case good:
    	return "好";
    	default:
    		return name();
    }
  }
  
  public UIRepairQuality fromString(final String value) {
    if( "较差".equals(value))
    	return bad;
    if( "较好".equals(value))
    	return normal;
    if( "好".equals(value))
    	return good;
    	return null;			
    
  }
}
