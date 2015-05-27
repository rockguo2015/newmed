package com.fudanmed.platform.core.device.pm.proxy;

import com.fudanmed.platform.core.device.pm.proxy.RCPMWorkItemAction;
import com.google.gwt.user.client.rpc.IsSerializable;

public class RCPMWorkItemManager implements IsSerializable {
  public static Boolean isActionValid(final RCPMWorkItemAction action, final Enum<?> state) {
    if(action==null||state==null) return false;
    switch(action){
    	case assignPlan:{
    		return "planed".equals(state.name());
    	}
    	case deassignPlan:{
    		return "planed".equals(state.name());
    	}
    	case assignTeam:{
    		return "planed".equals(state.name());
    	}
    	case workersAssigned:{
    		return "teamAssigned".equals(state.name())||"partialExecuting".equals(state.name());
    	}
    	case $workerAssignmentFinish:{
    		return "partialExecuting".equals(state.name())||"executing".equals(state.name());
    	}
    	case teamFinish:{
    		return "ready4TeamFinishReport".equals(state.name());
    	}
    	case finish:{
    		return "teamFinished".equals(state.name());
    	}
    	default:
    		return false;
    }
    
  }
}
