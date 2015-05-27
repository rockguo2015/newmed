package edu.fudan.langlab.uidl.domain.app.server.service.security;

import com.uniquesoft.gwt.server.service.common.BaseService;
import com.uniquesoft.gwt.shared.SessionTimeOutException;
import com.uniquesoft.gwt.shared.validation.ValidationException;
import edu.fudan.langlab.domain.security.Role;
import edu.fudan.langlab.domain.security.SecurityService;
import edu.fudan.langlab.domain.security.User;
import edu.fudan.langlab.domain.security.UserRoleAssignment;
import edu.fudan.langlab.domain.security.proxy.RoleProxy;
import edu.fudan.langlab.domain.security.proxy.UserProxy;
import edu.fudan.langlab.uidl.domain.app.client.security.SelectRoles4UserPresenterService;
import edu.fudan.langlab.uidl.domain.app.shared.security.UIUserRoles;
import edu.fudan.mylang.pf.IObjectFactory;
import java.util.Collection;
import java.util.List;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("edu.fudan.langlab.uidl.domain.app.client.security.SelectRoles4UserPresenterService")
@Transactional
public class SelectRoles4UserPresenterServiceImpl extends BaseService implements SelectRoles4UserPresenterService {
  @Autowired
  private IObjectFactory entities;
  
  @Autowired
  private SecurityService securityService;
  
  public Collection<RoleProxy> loadRoles4User(final UserProxy user) throws SessionTimeOutException, ValidationException {
    User _resolved= null;
    if(user!=null) _resolved=(edu.fudan.langlab.domain.security.User)com.uniquesoft.uidl.extensions.ModelObjects.resolve(user, entities);
    
    Collection<Role> _allRoles4User = this.securityService.getAllRoles4User( _resolved);
    final Function1<Role,RoleProxy> _function = new Function1<Role,RoleProxy>() {
        public RoleProxy apply(final Role it) {
          RoleProxy _proxy = it.toProxy();
          return _proxy;
        }
      };
    Iterable<RoleProxy> _map = IterableExtensions.<Role, RoleProxy>map(_allRoles4User, _function);
    List<RoleProxy> _list = IterableExtensions.<RoleProxy>toList(_map);
    return _list;
  }
  
  public void updateUserRoles(final UserProxy user, final UIUserRoles userRoles) throws SessionTimeOutException, ValidationException {
    User _resolved= null;
    if(user!=null) _resolved=(edu.fudan.langlab.domain.security.User)com.uniquesoft.uidl.extensions.ModelObjects.resolve(user, entities);
    
    String _userid =  _resolved.getUserid();
    Collection<UserRoleAssignment> _allRoles4User = this.securityService.getAllRoles4User(_userid);
    final Procedure1<UserRoleAssignment> _function = new Procedure1<UserRoleAssignment>() {
        public void apply(final UserRoleAssignment it) {
          SelectRoles4UserPresenterServiceImpl.this.entities.delete(it);
        }
      };
    IterableExtensions.<UserRoleAssignment>forEach(_allRoles4User, _function);
    User _resolved_1= null;
    if(user!=null) _resolved_1=(edu.fudan.langlab.domain.security.User)com.uniquesoft.uidl.extensions.ModelObjects.resolve(user, entities);
    
    final User u =  _resolved_1;
    Collection<RoleProxy> _roles = userRoles.getRoles();
    final Procedure1<RoleProxy> _function_1 = new Procedure1<RoleProxy>() {
        public void apply(final RoleProxy role) {
          UserRoleAssignment _create = SelectRoles4UserPresenterServiceImpl.this.entities.<UserRoleAssignment>create(UserRoleAssignment.class);
          final Procedure1<UserRoleAssignment> _function = new Procedure1<UserRoleAssignment>() {
              public void apply(final UserRoleAssignment it) {
                Long _id = role.getId();
                Role _get = SelectRoles4UserPresenterServiceImpl.this.entities.<Role>get(Role.class, _id);
                String _roleId = _get.getRoleId();
                it.setRoleId(_roleId);
                it.setUser(u);
              }
            };
          ObjectExtensions.<UserRoleAssignment>operator_doubleArrow(_create, _function);
        }
      };
    IterableExtensions.<RoleProxy>forEach(_roles, _function_1);
  }
}
