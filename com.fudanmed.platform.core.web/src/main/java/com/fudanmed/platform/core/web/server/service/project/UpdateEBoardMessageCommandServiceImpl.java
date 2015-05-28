package com.fudanmed.platform.core.web.server.service.project;

import com.fudanmed.platform.core.common.RCEBoardMessage;
import com.fudanmed.platform.core.common.RCEBoardMessageService;
import com.fudanmed.platform.core.common.proxy.RCEBoardMessageProxy;
import com.fudanmed.platform.core.web.client.project.UpdateEBoardMessageCommandService;
import com.uniquesoft.gwt.server.service.common.BaseService;
import com.uniquesoft.gwt.shared.SessionTimeOutException;
import com.uniquesoft.gwt.shared.validation.ValidationException;
import edu.fudan.mylang.pf.IObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("com.fudanmed.platform.core.web.client.project.UpdateEBoardMessageCommandService")
@Transactional
public class UpdateEBoardMessageCommandServiceImpl extends BaseService implements UpdateEBoardMessageCommandService {
  @Autowired
  private IObjectFactory entities;
  
  @Autowired
  private RCEBoardMessageService eboardMessageService;
  
  public RCEBoardMessageProxy loadEBoardMessage() throws SessionTimeOutException, ValidationException {
    RCEBoardMessage _eBoardMessage = this.eboardMessageService.getEBoardMessage();
    RCEBoardMessageProxy _proxy = _eBoardMessage.toProxy();
    return _proxy;
  }
}
