package com.fudanmed.platform.core.web.server.service.organization;

import com.fudanmed.platform.core.web.client.organization.ResetPasswdPresenterService;
import com.fudanmed.platform.core.web.server.service.organization.ResetPasswdDataValidator;
import com.fudanmed.platform.core.web.shared.organization.UIResetPasswdData;
import com.uniquesoft.gwt.server.service.common.BaseService;
import com.uniquesoft.gwt.shared.SessionTimeOutException;
import com.uniquesoft.gwt.shared.validation.ValidationException;
import com.uniquesoft.uidl.validation.Validates;
import edu.fudan.langlab.domain.security.User;
import edu.fudan.langlab.domain.security.proxy.UserProxy;
import edu.fudan.mylang.pf.IObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("com.fudanmed.platform.core.web.client.organization.ResetPasswdPresenterService")
@Transactional
public class ResetPasswdPresenterServiceImpl extends BaseService implements ResetPasswdPresenterService {
  @Autowired
  private IObjectFactory entities;
  
  @Autowired
  private ResetPasswdDataValidator validator;
  
  public String getUserId(final UserProxy user) throws SessionTimeOutException, ValidationException {
    User _resolved= null;
    if(user!=null) _resolved=(edu.fudan.langlab.domain.security.User)com.uniquesoft.uidl.extensions.ModelObjects.resolve(user, entities);
    
    String _userid =  _resolved.getUserid();
    return _userid;
  }
  
  public void changePasswd(final UIResetPasswdData data) throws SessionTimeOutException, ValidationException {
    Validates.<UIResetPasswdData>validateWith(data, this.validator);
    UserProxy _user = data.getUser();
    User _resolved= null;
    if(_user!=null) _resolved=(edu.fudan.langlab.domain.security.User)com.uniquesoft.uidl.extensions.ModelObjects.resolve(_user, entities);
    
    String _newPasswd = data.getNewPasswd();
     _resolved.setPasswd(_newPasswd);
  }
}
