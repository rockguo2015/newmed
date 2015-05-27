package com.fudanmed.platform.core.deliver.proxy;

import com.fudanmed.platform.core.deliver.proxy.DLResourceAction;
import com.google.gwt.user.client.rpc.IsSerializable;

public class DLResourceManager implements IsSerializable {
  public static Boolean isActionValid(final DLResourceAction action, final Enum<?> state) {
    if(action==null||state==null) return false;
    switch(action){
    	case repair:{
    		return "ready4use".equals(state.name());
    	}
    	case borrow:{
    		return "ready4use".equals(state.name());
    	}
    	case extBorrow:{
    		return "ready4use".equals(state.name());
    	}
    	case unregister:{
    		return "ready4use".equals(state.name())||"repairing".equals(state.name());
    	}
    	case finishRepair:{
    		return "repairing".equals(state.name());
    	}
    	case doExtReturn:{
    		return "extBorrowed".equals(state.name());
    	}
    	case doReturn:{
    		return "borrowed".equals(state.name());
    	}
    	default:
    		return false;
    }
    
  }
}
