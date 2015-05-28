package com.fudanmed.platform.core.web.server.service.workbench;

import com.fudanmed.platform.core.domain.RCRepairReportUser;
import com.fudanmed.platform.core.web.client.workbench.RouterPresenterService;
import com.uniquesoft.gwt.server.service.common.BaseService;
import com.uniquesoft.gwt.shared.SessionTimeOutException;
import com.uniquesoft.gwt.shared.validation.ValidationException;
import edu.fudan.langlab.domain.security.ISystemUserService;
import edu.fudan.langlab.domain.security.User;
import edu.fudan.mylang.pf.IObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("com.fudanmed.platform.core.web.client.workbench.RouterPresenterService")
@Transactional
public class RouterPresenterServiceImpl extends BaseService implements RouterPresenterService {
  @Autowired
  private IObjectFactory entities;
  
  @Autowired
  private ISystemUserService systemUserService;
  
  public Boolean isReporter() throws SessionTimeOutException, ValidationException {
    User _currentUser = this.systemUserService.getCurrentUser();
    return Boolean.valueOf((_currentUser instanceof RCRepairReportUser));
  }
}
