package com.fudanmed.platform.core.domain.impl;

import com.fudanmed.platform.core.domain.RCMaintenanceTeam;
import com.fudanmed.platform.core.domain.RCOnsitePosition;
import com.fudanmed.platform.core.domain.RCOrganization;
import com.fudanmed.platform.core.domain.RCOrganizationService;
import com.fudanmed.platform.core.domain.impl.RCMaintenanceTeamImpl;
import com.fudanmed.platform.core.domain.impl.RCOnsitePositionImpl;
import com.fudanmed.platform.core.domain.impl.RCOrganizationImpl;
import edu.fudan.langlab.domain.security.Role;
import edu.fudan.langlab.domain.security.SecurityService;
import edu.fudan.mylang.pf.BaseService;
import edu.fudan.mylang.pf.IGenericQuery;
import java.util.Collection;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("com.fudanmed.platform.core.domain.RCOrganizationService")
public class RCOrganizationServiceImpl extends BaseService implements RCOrganizationService {
  @Autowired
  private SecurityService securityService;
  
  public Collection<RCOrganization> getALlOrganization() {IGenericQuery<RCOrganization> query=getObjectFactory().createGenericQuery(RCOrganization.class,"select o from com.fudanmed.platform.core.domain.impl.RCOrganizationImpl as o   where  o.active = 1      ");
    Collection<RCOrganization> _list = query.list();
    return _list;
  }
  
  public Collection<RCOnsitePosition> getAllOnsitePositions() {IGenericQuery<RCOnsitePosition> query=getObjectFactory().createGenericQuery(RCOnsitePosition.class,"select o from com.fudanmed.platform.core.domain.impl.RCOnsitePositionImpl as o   where  o.active = 1      ");
    Collection<RCOnsitePosition> _list = query.list();
    return _list;
  }
  
  public RCOrganization createRootOrganization(final String code, final String name) {RCOrganization rCOrganization=RCOrganizationImpl.create(null,getObjectFactory());
    final Procedure1<RCOrganization> _function = new Procedure1<RCOrganization>() {
        public void apply(final RCOrganization it) {
          it.setCode(code);
          it.setName(name);
        }
      };
    RCOrganization _doubleArrow = ObjectExtensions.<RCOrganization>operator_doubleArrow(rCOrganization, _function);
    return _doubleArrow;
  }
  
  public RCOnsitePosition createRootOnsitePosition(final String code, final String name) {RCOnsitePosition rCOnsitePosition=RCOnsitePositionImpl.create(null,getObjectFactory());
    final Procedure1<RCOnsitePosition> _function = new Procedure1<RCOnsitePosition>() {
        public void apply(final RCOnsitePosition it) {
          it.setCode(code);
          it.setName(name);
        }
      };
    RCOnsitePosition _doubleArrow = ObjectExtensions.<RCOnsitePosition>operator_doubleArrow(rCOnsitePosition, _function);
    return _doubleArrow;
  }
  
  public RCMaintenanceTeam selectAsMaintenanceTeam(final RCOrganization organization) {RCMaintenanceTeam rCMaintenanceTeam=RCMaintenanceTeamImpl.create(getObjectFactory());
    final Procedure1<RCMaintenanceTeam> _function = new Procedure1<RCMaintenanceTeam>() {
        public void apply(final RCMaintenanceTeam it) {
          it.setOrganization(organization);
          Long _id = it.getId();
          String _string = _id.toString();
          String _plus = ("__" + _string);
          String _plus_1 = (_plus + "__");
          String _name = organization.getName();
          String _plus_2 = (_name + "\u7BA1\u7406\u5458");
          Role _createRole = RCOrganizationServiceImpl.this.securityService.createRole(_plus_1, _plus_2);
          final Procedure1<Role> _function = new Procedure1<Role>() {
              public void apply(final Role it) {
                it.setIsBuildin(Boolean.valueOf(true));
              }
            };
          Role _doubleArrow = ObjectExtensions.<Role>operator_doubleArrow(_createRole, _function);
          it.setRole(_doubleArrow);
        }
      };
    RCMaintenanceTeam _doubleArrow = ObjectExtensions.<RCMaintenanceTeam>operator_doubleArrow(rCMaintenanceTeam, _function);
    return _doubleArrow;
  }
  
  public void removeMaintenanceTeam(final RCMaintenanceTeam team) {getObjectFactory().delete(team);
    
    Long _id = team.getId();
    String _string = _id.toString();
    String _plus = ("__" + _string);
    String _plus_1 = (_plus + "__");
    Role _findRoleByRoleId = this.securityService.findRoleByRoleId(_plus_1);getObjectFactory().delete(_findRoleByRoleId);
    
  }
}
