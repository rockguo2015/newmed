package edu.fudan.langlab.uidl.domain.app.server.service.security;

import com.uniquesoft.gwt.server.service.common.BaseService;
import com.uniquesoft.gwt.shared.SessionTimeOutException;
import com.uniquesoft.gwt.shared.extensions.IterableExtensions2;
import com.uniquesoft.gwt.shared.validation.ValidationException;
import edu.fudan.langlab.domain.security.Role;
import edu.fudan.langlab.domain.security.SecurityService;
import edu.fudan.langlab.domain.security.User;
import edu.fudan.langlab.domain.security.proxy.RoleProxy;
import edu.fudan.langlab.uidl.domain.app.client.security.RoleManagementPresenterService;
import edu.fudan.langlab.uidl.domain.app.server.service.security.RoleMapper;
import edu.fudan.langlab.uidl.domain.app.shared.security.UIRole;
import edu.fudan.mylang.pf.IObjectFactory;
import java.util.Collection;
import java.util.List;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("edu.fudan.langlab.uidl.domain.app.client.security.RoleManagementPresenterService")
@Transactional
public class RoleManagementPresenterServiceImpl extends BaseService implements RoleManagementPresenterService {
  @Autowired
  private IObjectFactory entities;
  
  @Autowired
  private RoleMapper mapper;
  
  @Autowired
  private SecurityService securityService;
  
  public Collection<UIRole> loadRoleList() throws SessionTimeOutException, ValidationException {
    Collection<Role> _all = this.entities.<Role>all(Role.class);
    final Function1<Role,UIRole> _function = new Function1<Role,UIRole>() {
        public UIRole apply(final Role it) {
          UIRole _transform = RoleManagementPresenterServiceImpl.this.mapper.transform(it);
          return _transform;
        }
      };
    Iterable<UIRole> _map = IterableExtensions.<Role, UIRole>map(_all, _function);
    final Function1<UIRole,String> _function_1 = new Function1<UIRole,String>() {
        public String apply(final UIRole it) {
          String _roleId = it.getRoleId();
          return _roleId;
        }
      };
    List<UIRole> _sortBy = IterableExtensions.<UIRole, String>sortBy(_map, _function_1);
    Collection<UIRole> _unlazy = IterableExtensions2.<UIRole>unlazy(_sortBy);
    return _unlazy;
  }
  
  public Boolean canDelete(final RoleProxy role) throws SessionTimeOutException, ValidationException {
    Role _resolved= null;
    if(role!=null) _resolved=(edu.fudan.langlab.domain.security.Role)com.uniquesoft.uidl.extensions.ModelObjects.resolve(role, entities);
    
    Collection<User> _allUsers4Role = this.securityService.getAllUsers4Role( _resolved);
    int _size = _allUsers4Role.size();
    boolean _equals = (_size == 0);
    return Boolean.valueOf(_equals);
  }
  
  public void delete(final RoleProxy role) throws SessionTimeOutException, ValidationException {
    Boolean _canDelete = this.canDelete(role);
    if ((_canDelete).booleanValue()) {
      Role _resolved= null;
      if(role!=null) _resolved=(edu.fudan.langlab.domain.security.Role)com.uniquesoft.uidl.extensions.ModelObjects.resolve(role, entities);
      
      this.entities.delete( _resolved);
    } else {
      RuntimeException _runtimeException = new RuntimeException("cann\'t delete");
      throw _runtimeException;
    }
  }
}
