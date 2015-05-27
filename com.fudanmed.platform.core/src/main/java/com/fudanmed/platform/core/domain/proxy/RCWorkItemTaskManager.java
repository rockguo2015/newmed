package com.fudanmed.platform.core.domain.proxy;

import com.fudanmed.platform.core.domain.proxy.RCWorkItemTaskAction;
import com.google.gwt.user.client.rpc.IsSerializable;

public class RCWorkItemTaskManager implements IsSerializable {
  public static Boolean isActionValid(final RCWorkItemTaskAction action, final Enum<?> state) {
    if(action==null||state==null) return false;
    switch(action){
    	case followup:{
    		return "processing".equals(state.name());
    	}
    	case pend:{
    		return "processing".equals(state.name());
    	}
    	case misDispatching:{
    		return "processing".equals(state.name());
    	}
    	case outsource:{
    		return "processing".equals(state.name());
    	}
    	case cancel:{
    		return "processing".equals(state.name());
    	}
    	case cancelPend:{
    		return "pending".equals(state.name());
    	}
    	case finishOutsource:{
    		return "outsourcing".equals(state.name());
    	}
    	case finish:{
    		return "followuping".equals(state.name())||"processing".equals(state.name());
    	}
    	default:
    		return false;
    }
    
  }
}
