package edu.fudan.langlab.uidl.domain.app.server.service.security;

import com.uniquesoft.gwt.server.service.common.BaseService;
import com.uniquesoft.gwt.shared.SessionTimeOutException;
import com.uniquesoft.gwt.shared.validation.ValidationException;
import edu.fudan.langlab.domain.organization.RoleManager;
import edu.fudan.langlab.domain.security.AppFunction;
import edu.fudan.langlab.domain.security.AppFunctionService;
import edu.fudan.langlab.domain.security.AppRole;
import edu.fudan.langlab.uidl.domain.app.client.security.RoleFunctionAssignmentPresenterService;
import edu.fudan.langlab.uidl.domain.app.server.service.security.AppFunctionMapper;
import edu.fudan.langlab.uidl.domain.app.shared.security.UIAppFunction;
import edu.fudan.langlab.uidl.domain.app.shared.security.UIAppRole;
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

@Service("edu.fudan.langlab.uidl.domain.app.client.security.RoleFunctionAssignmentPresenterService")
@Transactional
public class RoleFunctionAssignmentPresenterServiceImpl extends BaseService implements RoleFunctionAssignmentPresenterService {
  @Autowired
  private IObjectFactory entities;
  
  @Autowired
  private RoleManager roleManager;
  
  @Autowired
  private AppFunctionMapper appFunctionMapper;
  
  @Autowired
  private AppFunctionService appFunctionService;
  
  public Collection<UIAppRole> getAllRoles() throws SessionTimeOutException, ValidationException {
    Collection<AppRole> _allRoles = this.roleManager.getAllRoles();
    final Function1<AppRole,UIAppRole> _function = new Function1<AppRole,UIAppRole>() {
        public UIAppRole apply(final AppRole role) {
          UIAppRole _uIAppRole = new UIAppRole();
          final Procedure1<UIAppRole> _function = new Procedure1<UIAppRole>() {
              public void apply(final UIAppRole it) {
                String _roleId = role.getRoleId();
                it.setRoleId(_roleId);
                String _name = role.getName();
                it.setName(_name);
              }
            };
          UIAppRole _doubleArrow = ObjectExtensions.<UIAppRole>operator_doubleArrow(_uIAppRole, _function);
          return _doubleArrow;
        }
      };
    Iterable<UIAppRole> _map = IterableExtensions.<AppRole, UIAppRole>map(_allRoles, _function);
    List<UIAppRole> _list = IterableExtensions.<UIAppRole>toList(_map);
    return _list;
  }
  
  public Collection<UIAppFunction> getFunctions4Role(final String roleId) throws SessionTimeOutException, ValidationException {
    Collection<AppFunction> _loadAllFunctions4Role = this.appFunctionService.loadAllFunctions4Role(roleId);
    final Function1<AppFunction,UIAppFunction> _function = new Function1<AppFunction,UIAppFunction>() {
        public UIAppFunction apply(final AppFunction it) {
          UIAppFunction _transform = RoleFunctionAssignmentPresenterServiceImpl.this.appFunctionMapper.transform(it);
          return _transform;
        }
      };
    Iterable<UIAppFunction> _map = IterableExtensions.<AppFunction, UIAppFunction>map(_loadAllFunctions4Role, _function);
    List<UIAppFunction> _list = IterableExtensions.<UIAppFunction>toList(_map);
    return _list;
  }
}
