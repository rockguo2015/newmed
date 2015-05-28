package com.fudanmed.platform.core.web.shared.deliver;

import com.uniquesoft.gwt.shared.datatype.IUIDLEnum;

public enum UIGender implements IUIDLEnum<UIGender> {
  female,

  male;
  
  public String toString() {
    switch(this){
    case male:
    	return "男";
    case female:
    	return "女";
    	default:
    		return name();
    }
  }
  
  public UIGender fromString(final String value) {
    if( "男".equals(value))
    	return male;
    if( "女".equals(value))
    	return female;
    	return null;			
    
  }
}
