package com.fudanmed.platform.core.common;

import com.fudanmed.platform.core.common.impl.RCEBoardMessageImpl;
import com.fudanmed.platform.core.common.proxy.RCEBoardMessageProxy;
import edu.fudan.mylang.pf.EntityImplementation;
import edu.fudan.mylang.pf.IModelObject;

@EntityImplementation(implementBy = RCEBoardMessageImpl.class)
public interface RCEBoardMessage extends IModelObject {
  public abstract String getMessage();
  
  public abstract RCEBoardMessage setMessage(final String message);
  
  public abstract RCEBoardMessageProxy toProxy();
}
