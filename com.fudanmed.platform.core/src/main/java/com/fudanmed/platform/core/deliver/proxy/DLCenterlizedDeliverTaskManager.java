package com.fudanmed.platform.core.deliver.proxy;

import com.fudanmed.platform.core.deliver.proxy.DLCenterlizedDeliverTaskAction;
import com.google.gwt.user.client.rpc.IsSerializable;

public class DLCenterlizedDeliverTaskManager implements IsSerializable {
  public static Boolean isActionValid(final DLCenterlizedDeliverTaskAction action, final Enum<?> state) {
    if(action==null||state==null) return false;
    switch(action){
    	case dispatch:{
    		return "scheduled".equals(state.name());
    	}
    	case finish:{
    		return "dispatched".equals(state.name());
    	}
    	case cancelDispatch:{
    		return "dispatched".equals(state.name());
    	}
    	case performUpdate:{
    		return "scheduled".equals(state.name())||"dispatched".equals(state.name());
    	}
    	case cancel:{
    		return "scheduled".equals(state.name())||"dispatched".equals(state.name());
    	}
    	default:
    		return false;
    }
    
  }
}
