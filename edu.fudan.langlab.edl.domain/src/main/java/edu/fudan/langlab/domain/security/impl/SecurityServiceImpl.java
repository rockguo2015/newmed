package edu.fudan.langlab.domain.security.impl;

import com.google.common.base.Objects;
import com.google.common.collect.Iterables;
import com.uniquesoft.uidl.validation.Validates;
import edu.fudan.langlab.domain.security.AppFunction;
import edu.fudan.langlab.domain.security.AppRole;
import edu.fudan.langlab.domain.security.Role;
import edu.fudan.langlab.domain.security.RoleFunctionAssignment;
import edu.fudan.langlab.domain.security.SecurityService;
import edu.fudan.langlab.domain.security.User;
import edu.fudan.langlab.domain.security.UserRoleAssignment;
import edu.fudan.langlab.domain.security.impl.AppFunctionImpl;
import edu.fudan.langlab.domain.security.impl.RoleFunctionAssignmentImpl;
import edu.fudan.langlab.domain.security.impl.RoleImpl;
import edu.fudan.langlab.domain.security.impl.UserRoleAssignmentImpl;
import edu.fudan.mylang.pf.BaseService;
import edu.fudan.mylang.pf.IGenericQuery;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.springframework.stereotype.Service;

@Service("edu.fudan.langlab.domain.security.SecurityService")
public class SecurityServiceImpl extends BaseService implements SecurityService {
  public Collection<UserRoleAssignment> getAllRoles4User(final String userid) {
    IGenericQuery<UserRoleAssignment> query=getObjectFactory().createGenericQuery(UserRoleAssignment.class,"select ra from edu.fudan.langlab.domain.security.impl.UserRoleAssignmentImpl as ra   where (ra.user.userid = :userid) and  ra.active = 1      ").setParameter("userid",userid);
    Collection<UserRoleAssignment> _list = query.list();
    return _list;
  }
  
  public Collection<Role> getAllRoles4User(final User user) {
    IGenericQuery<UserRoleAssignment> query=getObjectFactory().createGenericQuery(UserRoleAssignment.class,"select ra from edu.fudan.langlab.domain.security.impl.UserRoleAssignmentImpl as ra   where (ra.user = :user) and  ra.active = 1      ").setParameter("user",user);
    Collection<UserRoleAssignment> _list = query.list();
    final Function1<UserRoleAssignment,Role> _function = new Function1<UserRoleAssignment,Role>() {
        public Role apply(final UserRoleAssignment it) {
          Role _xblockexpression = null;
          {
            final String roleId = it.getRoleId();
            IGenericQuery<Role> query=getObjectFactory().createGenericQuery(Role.class,"select r from edu.fudan.langlab.domain.security.impl.RoleImpl as r   where (r.roleId = :roleId) and  r.active = 1      ").setParameter("roleId",roleId);
            Role _uniqueResult = query.uniqueResult();
            _xblockexpression = (_uniqueResult);
          }
          return _xblockexpression;
        }
      };
    Iterable<Role> _map = IterableExtensions.<UserRoleAssignment, Role>map(_list, _function);
    List<Role> _list_1 = IterableExtensions.<Role>toList(_map);
    return _list_1;
  }
  
  public Role createRole(final String roleId, final String roleName) {Role role=RoleImpl.create(getObjectFactory());
    final Procedure1<Role> _function = new Procedure1<Role>() {
        public void apply(final Role it) {
          it.setRoleId(roleId);
          it.setName(roleName);
        }
      };
    Role _doubleArrow = ObjectExtensions.<Role>operator_doubleArrow(role, _function);
    return _doubleArrow;
  }
  
  public Collection<User> getAllUsers4Role(final Role role) {
    List<User> _xblockexpression = null;
    {
      final String roleId = role.getRoleId();
      IGenericQuery<UserRoleAssignment> query=getObjectFactory().createGenericQuery(UserRoleAssignment.class,"select ra from edu.fudan.langlab.domain.security.impl.UserRoleAssignmentImpl as ra   where (ra.roleId = :roleId) and  ra.active = 1      ").setParameter("roleId",roleId);
      Collection<UserRoleAssignment> _list = query.list();
      final Function1<UserRoleAssignment,User> _function = new Function1<UserRoleAssignment,User>() {
          public User apply(final UserRoleAssignment it) {
            User _user = it.getUser();
            return _user;
          }
        };
      Iterable<User> _map = IterableExtensions.<UserRoleAssignment, User>map(_list, _function);
      List<User> _list_1 = IterableExtensions.<User>toList(_map);
      _xblockexpression = (_list_1);
    }
    return _xblockexpression;
  }
  
  public Role findRoleByRoleId(final String roleId) {
    IGenericQuery<Role> query=getObjectFactory().createGenericQuery(Role.class,"select r from edu.fudan.langlab.domain.security.impl.RoleImpl as r   where (r.roleId = :roleId) and  r.active = 1      ").setParameter("roleId",roleId);
    Role _uniqueResult = query.uniqueResult();
    return _uniqueResult;
  }
  
  public Collection<AppRole> getAllRoles() {IGenericQuery<Role> query=getObjectFactory().createGenericQuery(Role.class,"select r from edu.fudan.langlab.domain.security.impl.RoleImpl as r   where  r.active = 1      ");
    Collection<Role> _list = query.list();
    final Function1<Role,AppRole> _function = new Function1<Role,AppRole>() {
        public AppRole apply(final Role role) {
          AppRole _appRole = new AppRole();
          final Procedure1<AppRole> _function = new Procedure1<AppRole>() {
              public void apply(final AppRole it) {
                String _roleId = role.getRoleId();
                it.setRoleId(_roleId);
                String _name = role.getName();
                it.setName(_name);
              }
            };
          AppRole _doubleArrow = ObjectExtensions.<AppRole>operator_doubleArrow(_appRole, _function);
          return _doubleArrow;
        }
      };
    Iterable<AppRole> _map = IterableExtensions.<Role, AppRole>map(_list, _function);
    List<AppRole> _list_1 = IterableExtensions.<AppRole>toList(_map);
    return _list_1;
  }
  
  public void assignRole2User(final Role role, final User user) {
    Collection<Role> _allRoles4User = this.getAllRoles4User(user);
    final Function1<Role,Boolean> _function = new Function1<Role,Boolean>() {
        public Boolean apply(final Role it) {
          boolean _equals = Objects.equal(it, role);
          return Boolean.valueOf(_equals);
        }
      };
    boolean _exists = IterableExtensions.<Role>exists(_allRoles4User, _function);
    boolean _not = (!_exists);
    Validates.Assert(_not, "\u4E0D\u80FD\u7ED9\u7528\u6237\u91CD\u590D\u5206\u914D\u89D2\u8272");UserRoleAssignment userRoleAssignment=UserRoleAssignmentImpl.create(getObjectFactory());
    final Procedure1<UserRoleAssignment> _function_1 = new Procedure1<UserRoleAssignment>() {
        public void apply(final UserRoleAssignment it) {
          String _roleId = role.getRoleId();
          it.setRoleId(_roleId);
          it.setUser(user);
        }
      };
    ObjectExtensions.<UserRoleAssignment>operator_doubleArrow(userRoleAssignment, _function_1);
  }
  
  public void removeRoleFromUser(final Role role, final User user) {
    Collection<Role> _allRoles4User = this.getAllRoles4User(user);
    final Function1<Role,Boolean> _function = new Function1<Role,Boolean>() {
        public Boolean apply(final Role it) {
          boolean _equals = Objects.equal(it, role);
          return Boolean.valueOf(_equals);
        }
      };
    boolean _exists = IterableExtensions.<Role>exists(_allRoles4User, _function);
    Validates.Assert(_exists, "\u7528\u6237\u6CA1\u6709\u5206\u914D\u5F85\u89E3\u9664\u7684\u89D2\u8272");
    final String roleId = role.getRoleId();
    IGenericQuery<UserRoleAssignment> query=getObjectFactory().createGenericQuery(UserRoleAssignment.class,"select ra from edu.fudan.langlab.domain.security.impl.UserRoleAssignmentImpl as ra   where ((ra.user = :user) and (ra.roleId = :roleId)) and  ra.active = 1      ").setParameter("user",user).setParameter("roleId",roleId);
    UserRoleAssignment _uniqueResult = query.uniqueResult();getObjectFactory().delete(_uniqueResult);
    
  }
  
  public void assignFunction2Role(final AppFunction function, final Role role) {RoleFunctionAssignment roleFunctionAssignment=RoleFunctionAssignmentImpl.create(getObjectFactory());
    final Procedure1<RoleFunctionAssignment> _function = new Procedure1<RoleFunctionAssignment>() {
        public void apply(final RoleFunctionAssignment it) {
          String _roleId = role.getRoleId();
          it.setRoleId(_roleId);
          it.setFunction(function);
        }
      };
    ObjectExtensions.<RoleFunctionAssignment>operator_doubleArrow(roleFunctionAssignment, _function);
  }
  
  public AppFunction createFunction(final String parentFunctionId, final String functionId, final String name) {
    AppFunction _xifexpression = null;
    boolean _equals = Objects.equal(parentFunctionId, null);
    if (_equals) {
      AppFunction _createFunction = this.createFunction(((AppFunction) null), functionId, name);
      _xifexpression = _createFunction;
    } else {
      AppFunction _xblockexpression = null;
      {
        IGenericQuery<AppFunction> query=getObjectFactory().createGenericQuery(AppFunction.class,"select e from edu.fudan.langlab.domain.security.impl.AppFunctionImpl as e   where (e.functionId = :parentFunctionId) and  e.active = 1      ").setParameter("parentFunctionId",parentFunctionId);
        final AppFunction parentFunction = query.uniqueResult();
        boolean _notEquals = (!Objects.equal(parentFunction, null));
        String _plus = ("\u7236\u529F\u80FD\u4E0D\u5B58\u5728:" + parentFunctionId);
        Validates.Assert(_notEquals, _plus);
        AppFunction _createFunction_1 = this.createFunction(parentFunction, functionId, name);
        _xblockexpression = (_createFunction_1);
      }
      _xifexpression = _xblockexpression;
    }
    return _xifexpression;
  }
  
  public AppFunction createFunction(final AppFunction parentFunction, final String functionId, final String name) {
    AppFunction _xblockexpression = null;
    {
      IGenericQuery<Long> query=getObjectFactory().createGenericQuery(Long.class,"select count(e) from edu.fudan.langlab.domain.security.impl.AppFunctionImpl as e   where (e.functionId = :functionId) and  e.active = 1      ").setParameter("functionId",functionId);
      Long _uniqueResult = query.uniqueResult();
      boolean _equals = ((_uniqueResult).longValue() == 0);
      String _plus = ("\u529F\u80FDID\u91CD\u590D:" + functionId);
      Validates.Assert(_equals, _plus);AppFunction appFunction=AppFunctionImpl.create(getObjectFactory());
      final Procedure1<AppFunction> _function = new Procedure1<AppFunction>() {
          public void apply(final AppFunction it) {
            String _functionId = parentFunction==null?(String)null:parentFunction.getFunctionId();
            it.setParentFunctionId(_functionId);
            it.setFunctionId(functionId);
            it.setName(name);
          }
        };
      AppFunction _doubleArrow = ObjectExtensions.<AppFunction>operator_doubleArrow(appFunction, _function);
      _xblockexpression = (_doubleArrow);
    }
    return _xblockexpression;
  }
  
  public void removeFunctionFromRole(final AppFunction function, final Role role) {
    String _roleId = role.getRoleId();
    IGenericQuery<RoleFunctionAssignment> query=getObjectFactory().createGenericQuery(RoleFunctionAssignment.class,"select ra from edu.fudan.langlab.domain.security.impl.RoleFunctionAssignmentImpl as ra   where ((ra.function = :function) and (ra.roleId = :_roleId)) and  ra.active = 1      ").setParameter("function",function).setParameter("_roleId",_roleId);
    final RoleFunctionAssignment v = query.uniqueResult();getObjectFactory().delete(v);
    
  }
  
  public void removeFunctionFromRoleCascade(final AppFunction function, final Role role) {
    Collection<AppFunction> _subFunctions = function.getSubFunctions();
    final Procedure1<Collection<AppFunction>> _function = new Procedure1<Collection<AppFunction>>() {
        public void apply(final Collection<AppFunction> it) {
          it.add(function);
        }
      };
    final Collection<AppFunction> v = ObjectExtensions.<Collection<AppFunction>>operator_doubleArrow(_subFunctions, _function);
    final Procedure1<AppFunction> _function_1 = new Procedure1<AppFunction>() {
        public void apply(final AppFunction it) {getObjectFactory().delete(it);
          
        }
      };
    IterableExtensions.<AppFunction>forEach(v, _function_1);
  }
  
  public Collection<AppFunction> getAllFunctions4Role(final Role role) {
    List<AppFunction> _xblockexpression = null;
    {
      final String roleId = role.getRoleId();
      IGenericQuery<RoleFunctionAssignment> query=getObjectFactory().createGenericQuery(RoleFunctionAssignment.class,"select e from edu.fudan.langlab.domain.security.impl.RoleFunctionAssignmentImpl as e   where (e.roleId = :roleId) and  e.active = 1      ").setParameter("roleId",roleId);
      Collection<RoleFunctionAssignment> _list = query.list();
      final Function1<RoleFunctionAssignment,AppFunction> _function = new Function1<RoleFunctionAssignment,AppFunction>() {
          public AppFunction apply(final RoleFunctionAssignment it) {
            AppFunction _function = it.getFunction();
            return _function;
          }
        };
      Iterable<AppFunction> _map = IterableExtensions.<RoleFunctionAssignment, AppFunction>map(_list, _function);
      List<AppFunction> _list_1 = IterableExtensions.<AppFunction>toList(_map);
      _xblockexpression = (_list_1);
    }
    return _xblockexpression;
  }
  
  public Collection<AppFunction> getAllFunctions4User(final User user) {
    Collection<Role> _allRoles4User = this.getAllRoles4User(user);
    final Function1<Role,Collection<AppFunction>> _function = new Function1<Role,Collection<AppFunction>>() {
        public Collection<AppFunction> apply(final Role it) {
          Collection<AppFunction> _allFunctions4Role = SecurityServiceImpl.this.getAllFunctions4Role(it);
          return _allFunctions4Role;
        }
      };
    Iterable<Collection<AppFunction>> _map = IterableExtensions.<Role, Collection<AppFunction>>map(_allRoles4User, _function);
    Iterable<AppFunction> _flatten = Iterables.<AppFunction>concat(_map);
    Set<AppFunction> _set = IterableExtensions.<AppFunction>toSet(_flatten);
    return _set;
  }
}
