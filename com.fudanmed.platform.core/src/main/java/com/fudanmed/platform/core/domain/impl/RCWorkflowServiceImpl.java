package com.fudanmed.platform.core.domain.impl;

import com.fudanmed.platform.core.domain.RCMaintenanceTeam;
import com.fudanmed.platform.core.domain.RCWorkflowService;
import com.google.common.base.Objects;
import edu.fudan.langlab.domain.security.ISystemUserService;
import edu.fudan.langlab.domain.security.Role;
import edu.fudan.langlab.domain.security.SecurityService;
import edu.fudan.langlab.domain.security.User;
import edu.fudan.langlab.domain.security.UserRoleAssignment;
import edu.fudan.mylang.pf.BaseService;
import edu.fudan.mylang.pf.IGenericQuery;
import java.util.Collection;
import java.util.List;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("com.fudanmed.platform.core.domain.RCWorkflowService")
public class RCWorkflowServiceImpl extends BaseService implements RCWorkflowService {
  @Autowired
  private ISystemUserService systemUserService;
  
  @Autowired
  private SecurityService securityService;
  
  public Collection<RCMaintenanceTeam> loadMaintenanceTeams4SystemUser() {
    List<RCMaintenanceTeam> _xblockexpression = null;
    {
      User _currentUser = this.systemUserService.getCurrentUser();
      String _userid = _currentUser.getUserid();
      Collection<UserRoleAssignment> _allRoles4User = this.securityService.getAllRoles4User(_userid);
      final Function1<UserRoleAssignment,String> _function = new Function1<UserRoleAssignment,String>() {
          public String apply(final UserRoleAssignment it) {
            String _roleId = it.getRoleId();
            return _roleId;
          }
        };
      final Iterable<String> userRoles = IterableExtensions.<UserRoleAssignment, String>map(_allRoles4User, _function);IGenericQuery<RCMaintenanceTeam> query=getObjectFactory().createGenericQuery(RCMaintenanceTeam.class,"select t from com.fudanmed.platform.core.domain.impl.RCMaintenanceTeamImpl as t   where  t.active = 1      ");
      final Collection<RCMaintenanceTeam> teams = query.list();
      final Function1<RCMaintenanceTeam,Boolean> _function_1 = new Function1<RCMaintenanceTeam,Boolean>() {
          public Boolean apply(final RCMaintenanceTeam team) {
            final Function1<String,Boolean> _function = new Function1<String,Boolean>() {
                public Boolean apply(final String it) {
                  Role _role = team.getRole();
                  String _roleId = _role.getRoleId();
                  boolean _equals = Objects.equal(it, _roleId);
                  return Boolean.valueOf(_equals);
                }
              };
            boolean _exists = IterableExtensions.<String>exists(userRoles, _function);
            return Boolean.valueOf(_exists);
          }
        };
      Iterable<RCMaintenanceTeam> _filter = IterableExtensions.<RCMaintenanceTeam>filter(teams, _function_1);
      List<RCMaintenanceTeam> _list = IterableExtensions.<RCMaintenanceTeam>toList(_filter);
      _xblockexpression = (_list);
    }
    return _xblockexpression;
  }
}
