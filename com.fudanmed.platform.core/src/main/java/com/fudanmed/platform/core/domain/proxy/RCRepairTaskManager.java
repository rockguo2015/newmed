package com.fudanmed.platform.core.domain.proxy;

import com.fudanmed.platform.core.domain.proxy.RCRepairTaskAction;
import com.google.gwt.user.client.rpc.IsSerializable;

public class RCRepairTaskManager implements IsSerializable {
  public static Boolean isActionValid(final RCRepairTaskAction action, final Enum<?> state) {
    if(action==null||state==null) return false;
    switch(action){
    	case cancel:{
    		return "newCreated".equals(state.name())||"scheduled".equals(state.name())||"wait4Close".equals(state.name());
    	}
    	case updated:{
    		return "wait4SchedulerProcess".equals(state.name())||"newCreated".equals(state.name());
    	}
    	case firstWorkItemCreated:{
    		return "scheduled".equals(state.name());
    	}
    	case misdispatch:{
    		return "scheduled".equals(state.name())||"wait4GroupTaskFinish".equals(state.name());
    	}
    	case groupTaskFinished:{
    		return "wait4GroupTaskFinish".equals(state.name());
    	}
    	case close:{
    		return "wait4Close".equals(state.name());
    	}
    	case createGroupTask:{
    		return "newCreated".equals(state.name())||"wait4SchedulerProcess".equals(state.name())||"wait4Close".equals(state.name());
    	}
    	default:
    		return false;
    }
    
  }
}
