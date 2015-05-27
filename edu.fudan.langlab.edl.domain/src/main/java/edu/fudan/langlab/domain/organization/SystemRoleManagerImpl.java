package edu.fudan.langlab.domain.organization;

import com.google.common.base.Objects;
import edu.fudan.langlab.domain.organization.RoleContributor;
import edu.fudan.langlab.domain.organization.SystemRoleManager;
import edu.fudan.mylang.pf.BaseService;
import java.util.Collection;
import java.util.List;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(value = "SystemRoleManager")
@SuppressWarnings("all")
public class SystemRoleManagerImpl extends BaseService implements SystemRoleManager {
  @Autowired(required = false)
  private List<RoleContributor> roleContributors;
  
  public Collection<RoleContributor> getRoleContributors() {
    return this.roleContributors;
  }
  
  public String getRoleDescription(final String roleid) {
    final Function1<RoleContributor,Boolean> _function = new Function1<RoleContributor,Boolean>() {
        public Boolean apply(final RoleContributor it) {
          String _roleId = it.getRoleId();
          boolean _equals = Objects.equal(_roleId, roleid);
          return Boolean.valueOf(_equals);
        }
      };
    RoleContributor _findFirst = IterableExtensions.<RoleContributor>findFirst(this.roleContributors, _function);
    String _description = _findFirst==null?(String)null:_findFirst.getDescription();
    return _description;
  }
  
  public RoleContributor getRoleContributor(final String roleid) {
    final Function1<RoleContributor,Boolean> _function = new Function1<RoleContributor,Boolean>() {
        public Boolean apply(final RoleContributor it) {
          String _roleId = it.getRoleId();
          boolean _equals = Objects.equal(_roleId, roleid);
          return Boolean.valueOf(_equals);
        }
      };
    RoleContributor _findFirst = IterableExtensions.<RoleContributor>findFirst(this.roleContributors, _function);
    return _findFirst;
  }
}
