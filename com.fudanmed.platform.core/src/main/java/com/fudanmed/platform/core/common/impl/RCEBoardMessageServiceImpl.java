package com.fudanmed.platform.core.common.impl;

import com.fudanmed.platform.core.common.RCEBoardMessage;
import com.fudanmed.platform.core.common.RCEBoardMessageService;
import edu.fudan.mylang.pf.BaseService;
import edu.fudan.mylang.pf.IGenericQuery;
import org.springframework.stereotype.Service;

@Service("com.fudanmed.platform.core.common.RCEBoardMessageService")
public class RCEBoardMessageServiceImpl extends BaseService implements RCEBoardMessageService {
  public RCEBoardMessage getEBoardMessage() {IGenericQuery<RCEBoardMessage> query=getObjectFactory().createGenericQuery(RCEBoardMessage.class,"select e from com.fudanmed.platform.core.common.impl.RCEBoardMessageImpl as e   where  e.active = 1      ");
    RCEBoardMessage _uniqueResult = query.uniqueResult();
    return _uniqueResult;
  }
  
  public String getMessage() {
    RCEBoardMessage _eBoardMessage = this.getEBoardMessage();
    String _message = _eBoardMessage.getMessage();
    return _message;
  }
  
  public void updateMessage(final String message) {
    RCEBoardMessage _eBoardMessage = this.getEBoardMessage();
    _eBoardMessage.setMessage(message);
  }
}
