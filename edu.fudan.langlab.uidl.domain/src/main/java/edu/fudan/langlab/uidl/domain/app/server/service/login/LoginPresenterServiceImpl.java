package edu.fudan.langlab.uidl.domain.app.server.service.login;

import com.google.common.base.Objects;
import com.uniquesoft.gwt.server.service.common.BaseService;
import com.uniquesoft.gwt.shared.SessionTimeOutException;
import com.uniquesoft.gwt.shared.validation.ValidationException;
import edu.fudan.langlab.domain.security.ISystemUserService;
import edu.fudan.langlab.domain.security.User;
import edu.fudan.langlab.security.shared.IFunctionIdentifier;
import edu.fudan.langlab.uidl.domain.app.client.login.LoginPresenterService;
import edu.fudan.langlab.uidl.domain.app.server.service.login.ISecurityService;
import edu.fudan.langlab.uidl.domain.app.shared.login.UIUser;
import edu.fudan.mylang.pf.IObjectFactory;
import java.util.Collection;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("edu.fudan.langlab.uidl.domain.app.client.login.LoginPresenterService")
@Transactional
public class LoginPresenterServiceImpl extends BaseService implements LoginPresenterService {
  @Autowired
  private IObjectFactory entities;
  
  @Autowired
  private ISecurityService securityService;
  
  @Autowired
  private ISystemUserService systemUserService;
  
  public Boolean isSuperUsr(final String userid) throws SessionTimeOutException, ValidationException {
    boolean _equals = "admin".equals(userid);
    return Boolean.valueOf(_equals);
  }
  
  public UIUser login(final String userid, final String passwd) throws SessionTimeOutException, ValidationException {
    final User u = this.securityService.login(userid, passwd);
    boolean _equals = Objects.equal(u, null);
    if (_equals) {
      return null;
    } else {
      this.systemUserService.setCurrentUser(u);
      UIUser _uIUser = new UIUser();
      final Procedure1<UIUser> _function = new Procedure1<UIUser>() {
          public void apply(final UIUser uiuser) {
            String _userid = u.getUserid();
            uiuser.setUserid(_userid);
            String _entityName = u.getEntityName();
            uiuser.setName(_entityName);
          }
        };
      UIUser user = ObjectExtensions.<UIUser>operator_doubleArrow(_uIUser, _function);
      this.loadFunctions4User(user);
      return user;
    }
  }
  
  public Collection<? extends IFunctionIdentifier> loadFunctions4User(final UIUser user) throws SessionTimeOutException, ValidationException {
    String _userid = user.getUserid();
    Collection<? extends IFunctionIdentifier> _loadValidFunctions4User = this.securityService.loadValidFunctions4User(_userid);
    return _loadValidFunctions4User;
  }
}
