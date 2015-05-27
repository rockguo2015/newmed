package com.fudanmed.platform.core.domain.proxy;

import com.fudanmed.platform.core.domain.proxy.RCEmployeeAction;
import com.google.gwt.user.client.rpc.IsSerializable;

public class RCEmployeeManager implements IsSerializable {
  public static Boolean isActionValid(final RCEmployeeAction action, final Enum<?> state) {
    if(action==null||state==null) return false;
    switch(action){
    	case leaveJob:{
    		return "onJob".equals(state.name());
    	}
    	case returnJob:{
    		return "leaveJob".equals(state.name());
    	}
    	default:
    		return false;
    }
    
  }
}
