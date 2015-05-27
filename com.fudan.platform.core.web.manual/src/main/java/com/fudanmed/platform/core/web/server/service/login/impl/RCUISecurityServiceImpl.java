package com.fudanmed.platform.core.web.server.service.login.impl;

import com.fudanmed.platform.core.domain.RCSecurityService;
import com.google.common.collect.Iterables;
import edu.fudan.langlab.domain.security.AppFunction;
import edu.fudan.langlab.domain.security.AppFunctionService;
import edu.fudan.langlab.domain.security.SecurityService;
import edu.fudan.langlab.domain.security.User;
import edu.fudan.langlab.domain.security.UserRoleAssignment;
import edu.fudan.langlab.security.shared.FunctionIdentifier;
import edu.fudan.langlab.security.shared.IFunctionIdentifier;
import edu.fudan.langlab.uidl.domain.app.server.service.login.ISecurityService;
import edu.fudan.mylang.pf.BaseService;
import java.util.Collection;
import java.util.Set;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("com.fudanmed.platform.core.web.server.service.login.RCUISecurityService")
public class RCUISecurityServiceImpl extends BaseService implements ISecurityService {
  @Autowired
  private RCSecurityService rcSecurityService;
  
  @Autowired
  private SecurityService securityService;
  
  @Autowired
  private AppFunctionService appFunctionService;
  
  public User login(final String userid, final String passwd) {
    User _userLogin = this.rcSecurityService.userLogin(userid, passwd);
    return _userLogin;
  }
  
  public Collection<? extends IFunctionIdentifier> loadValidFunctions4User(final String userid) {
    Collection<UserRoleAssignment> _allRoles4User = this.securityService.getAllRoles4User(userid);
    final Function1<UserRoleAssignment,Collection<AppFunction>> _function = new Function1<UserRoleAssignment,Collection<AppFunction>>() {
        public Collection<AppFunction> apply(final UserRoleAssignment it) {
          String _roleId = it.getRoleId();
          Collection<AppFunction> _loadAllFunctions4Role = RCUISecurityServiceImpl.this.appFunctionService.loadAllFunctions4Role(_roleId);
          return _loadAllFunctions4Role;
        }
      };
    Iterable<Collection<AppFunction>> _map = IterableExtensions.<UserRoleAssignment, Collection<AppFunction>>map(_allRoles4User, _function);
    Iterable<AppFunction> _flatten = Iterables.<AppFunction>concat(_map);
    final Function1<AppFunction,FunctionIdentifier> _function_1 = new Function1<AppFunction,FunctionIdentifier>() {
        public FunctionIdentifier apply(final AppFunction appFunction) {
          String _functionId = appFunction.getFunctionId();
          FunctionIdentifier _functionIdentifier = new FunctionIdentifier(_functionId);
          return _functionIdentifier;
        }
      };
    Iterable<FunctionIdentifier> _map_1 = IterableExtensions.<AppFunction, FunctionIdentifier>map(_flatten, _function_1);
    Set<FunctionIdentifier> _set = IterableExtensions.<FunctionIdentifier>toSet(_map_1);
    return _set;
  }
}
