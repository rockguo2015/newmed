package com.fudanmed.platform.core.web.shared.device;

import com.uniquesoft.gwt.shared.datatype.IUIDLEnum;

public enum UIDeviceCategoryOrTypeType implements IUIDLEnum<UIDeviceCategoryOrTypeType> {
  type,

  category;
  
  public String toString() {
    switch(this){
    	default:
    		return name();
    }
  }
  
  public UIDeviceCategoryOrTypeType fromString(final String value) {
    	return null;			
    
  }
}
