package com.fudanmed.platform.core.device.pm.proxy;

import com.fudanmed.platform.core.device.pm.proxy.RCDevicePMPlanAction;
import com.google.gwt.user.client.rpc.IsSerializable;

public class RCDevicePMPlanManager implements IsSerializable {
  public static Boolean isActionValid(final RCDevicePMPlanAction action, final Enum<?> state) {
    if(action==null||state==null) return false;
    switch(action){
    	case assign:{
    		return "planed".equals(state.name());
    	}
    	case assignWorker:{
    		return "assigned".equals(state.name());
    	}
    	case cancelAssign:{
    		return "assigned".equals(state.name());
    	}
    	case finish:{
    		return "workerAssigned".equals(state.name());
    	}
    	case reportInfo:{
    		return "workerAssigned".equals(state.name());
    	}
    	default:
    		return false;
    }
    
  }
}
