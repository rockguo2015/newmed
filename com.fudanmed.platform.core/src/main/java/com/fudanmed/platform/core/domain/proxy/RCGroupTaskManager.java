package com.fudanmed.platform.core.domain.proxy;

import com.fudanmed.platform.core.domain.proxy.RCGroupTaskAction;
import com.google.gwt.user.client.rpc.IsSerializable;

public class RCGroupTaskManager implements IsSerializable {
  public static Boolean isActionValid(final RCGroupTaskAction action, final Enum<?> state) {
    if(action==null||state==null) return false;
    switch(action){
    	case reportFinish:{
    		return "wait4TeamOwnerProcess".equals(state.name());
    	}
    	case cancel:{
    		return "newCreated".equals(state.name());
    	}
    	case reportMisdispatch:{
    		return "newCreated".equals(state.name())||"wait4TeamOwnerProcess".equals(state.name());
    	}
    	case taskCreated:{
    		return "newCreated".equals(state.name())||"wait4TeamOwnerProcess".equals(state.name())||"wait4TasksFinish".equals(state.name());
    	}
    	case taskFinished:{
    		return "wait4TasksFinish".equals(state.name());
    	}
    	default:
    		return false;
    }
    
  }
}
