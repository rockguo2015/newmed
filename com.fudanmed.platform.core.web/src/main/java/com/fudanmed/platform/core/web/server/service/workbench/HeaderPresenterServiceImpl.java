package com.fudanmed.platform.core.web.server.service.workbench;

import com.fudanmed.platform.core.common.RCSystemParameter;
import com.fudanmed.platform.core.common.RCSystemParameterService;
import com.fudanmed.platform.core.web.client.workbench.HeaderPresenterService;
import com.uniquesoft.gwt.server.service.common.BaseService;
import com.uniquesoft.gwt.shared.SessionTimeOutException;
import com.uniquesoft.gwt.shared.validation.ValidationException;
import edu.fudan.mylang.pf.IObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("com.fudanmed.platform.core.web.client.workbench.HeaderPresenterService")
@Transactional
public class HeaderPresenterServiceImpl extends BaseService implements HeaderPresenterService {
  @Autowired
  private IObjectFactory entities;
  
  @Autowired
  private RCSystemParameterService systemParameterService;
  
  public String getAppTitle() throws SessionTimeOutException, ValidationException {
    RCSystemParameter _systemParameter = this.systemParameterService.getSystemParameter();
    String _applicationTitle = _systemParameter.getApplicationTitle();
    return _applicationTitle;
  }
}
