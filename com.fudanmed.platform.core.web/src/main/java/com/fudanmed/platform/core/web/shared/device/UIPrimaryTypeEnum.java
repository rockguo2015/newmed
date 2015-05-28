package com.fudanmed.platform.core.web.shared.device;

import com.uniquesoft.gwt.shared.datatype.IUIDLEnum;

public enum UIPrimaryTypeEnum implements IUIDLEnum<UIPrimaryTypeEnum> {
  number,

  numberWithUnit,

  range,

  string,

  date;
  
  public String toString() {
    switch(this){
    	default:
    		return name();
    }
  }
  
  public UIPrimaryTypeEnum fromString(final String value) {
    	return null;			
    
  }
}
