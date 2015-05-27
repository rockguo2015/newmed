package com.fudanmed.platform.core.device.pm.proxy;

import com.fudanmed.platform.core.device.pm.proxy.RCPMWorkItemWorkerAssignmentAction;
import com.google.gwt.user.client.rpc.IsSerializable;

public class RCPMWorkItemWorkerAssignmentManager implements IsSerializable {
  public static Boolean isActionValid(final RCPMWorkItemWorkerAssignmentAction action, final Enum<?> state) {
    if(action==null||state==null) return false;
    switch(action){
    	case pend:{
    		return "planed".equals(state.name());
    	}
    	case finish:{
    		return "planed".equals(state.name())||"pending".equals(state.name());
    	}
    	default:
    		return false;
    }
    
  }
}
