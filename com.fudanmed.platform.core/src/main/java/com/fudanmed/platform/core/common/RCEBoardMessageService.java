package com.fudanmed.platform.core.common;

import com.fudanmed.platform.core.common.RCEBoardMessage;
import edu.fudan.mylang.pf.IBaseService;

public interface RCEBoardMessageService extends IBaseService {
  public abstract RCEBoardMessage getEBoardMessage();
  
  public abstract String getMessage();
  
  public abstract void updateMessage(final String message);
}
