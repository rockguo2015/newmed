package com.fudanmed.platform.core.web.shared.organization;

import com.uniquesoft.gwt.shared.datatype.IUIDLEnum;

public enum UIEmployeeStatus implements IUIDLEnum<UIEmployeeStatus> {
  leaveJob,

  onJob;
  
  public String toString() {
    switch(this){
    	default:
    		return name();
    }
  }
  
  public UIEmployeeStatus fromString(final String value) {
    	return null;			
    
  }
}
