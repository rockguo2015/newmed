package com.fudanmed.platform.core.web.server.service.organization;

import com.fudanmed.platform.core.web.client.organization.ChangePasswdPresenterService;
import com.fudanmed.platform.core.web.server.service.organization.ChangePasswdDataValidator;
import com.fudanmed.platform.core.web.shared.organization.UIChangePasswdData;
import com.uniquesoft.gwt.server.service.common.BaseService;
import com.uniquesoft.gwt.shared.SessionTimeOutException;
import com.uniquesoft.gwt.shared.validation.ValidationException;
import com.uniquesoft.uidl.validation.Validates;
import edu.fudan.langlab.domain.security.ISystemUserService;
import edu.fudan.langlab.domain.security.User;
import edu.fudan.langlab.domain.security.proxy.UserProxy;
import edu.fudan.mylang.pf.IObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("com.fudanmed.platform.core.web.client.organization.ChangePasswdPresenterService")
@Transactional
public class ChangePasswdPresenterServiceImpl extends BaseService implements ChangePasswdPresenterService {
  @Autowired
  private IObjectFactory entities;
  
  @Autowired
  private ChangePasswdDataValidator validator;
  
  @Autowired
  private ISystemUserService systemUserService;
  
  public void changePasswd(final UIChangePasswdData data) throws SessionTimeOutException, ValidationException {
    Validates.<UIChangePasswdData>validateWith(data, this.validator);
    UserProxy _user = data.getUser();
    User _resolved= null;
    if(_user!=null) _resolved=(edu.fudan.langlab.domain.security.User)com.uniquesoft.uidl.extensions.ModelObjects.resolve(_user, entities);
    
    String _newPasswd = data.getNewPasswd();
     _resolved.setPasswd(_newPasswd);
  }
  
  public UserProxy getCurrentUser() throws SessionTimeOutException, ValidationException {
    User _currentUser = this.systemUserService.getCurrentUser();
    UserProxy _proxy = _currentUser.toProxy();
    return _proxy;
  }
}
