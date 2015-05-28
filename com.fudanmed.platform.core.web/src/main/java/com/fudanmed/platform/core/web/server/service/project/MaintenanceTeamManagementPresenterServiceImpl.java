package com.fudanmed.platform.core.web.server.service.project;

import com.fudanmed.platform.core.domain.RCMaintenanceTeam;
import com.fudanmed.platform.core.domain.RCOrganization;
import com.fudanmed.platform.core.domain.RCOrganizationService;
import com.fudanmed.platform.core.domain.proxy.RCMaintenanceTeamProxy;
import com.fudanmed.platform.core.domain.proxy.RCOrganizationProxy;
import com.fudanmed.platform.core.web.client.project.MaintenanceTeamManagementPresenterService;
import com.fudanmed.platform.core.web.server.service.project.MaintenanceTeamMapper;
import com.fudanmed.platform.core.web.shared.project.UIMaintenanceTeam;
import com.uniquesoft.gwt.server.service.common.BaseService;
import com.uniquesoft.gwt.shared.SessionTimeOutException;
import com.uniquesoft.gwt.shared.extensions.IterableExtensions2;
import com.uniquesoft.gwt.shared.validation.ValidationException;
import edu.fudan.langlab.domain.security.SecurityService;
import edu.fudan.mylang.pf.IObjectFactory;
import java.util.Collection;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("com.fudanmed.platform.core.web.client.project.MaintenanceTeamManagementPresenterService")
@Transactional
public class MaintenanceTeamManagementPresenterServiceImpl extends BaseService implements MaintenanceTeamManagementPresenterService {
  @Autowired
  private IObjectFactory entities;
  
  @Autowired
  private RCOrganizationService organizationService;
  
  @Autowired
  private MaintenanceTeamMapper mapper;
  
  @Autowired
  private SecurityService securityService;
  
  public RCMaintenanceTeamProxy selectAsTeam(final RCOrganizationProxy org) throws SessionTimeOutException, ValidationException {
    RCOrganization _resolved= null;
    if(org!=null) _resolved=(com.fudanmed.platform.core.domain.RCOrganization)com.uniquesoft.uidl.extensions.ModelObjects.resolve(org, entities);
    
    RCMaintenanceTeam _selectAsMaintenanceTeam = this.organizationService.selectAsMaintenanceTeam( _resolved);
    RCMaintenanceTeamProxy _proxy = _selectAsMaintenanceTeam.toProxy();
    return _proxy;
  }
  
  public RCOrganizationProxy removeFromTeam(final RCMaintenanceTeamProxy team) throws SessionTimeOutException, ValidationException {
    RCOrganizationProxy _xblockexpression = null;
    {
      RCMaintenanceTeam _resolved= null;
      if(team!=null) _resolved=(com.fudanmed.platform.core.domain.RCMaintenanceTeam)com.uniquesoft.uidl.extensions.ModelObjects.resolve(team, entities);
      
      RCOrganization _organization =  _resolved.getOrganization();
      final RCOrganizationProxy result = _organization.toProxy();
      RCMaintenanceTeam _resolved_1= null;
      if(team!=null) _resolved_1=(com.fudanmed.platform.core.domain.RCMaintenanceTeam)com.uniquesoft.uidl.extensions.ModelObjects.resolve(team, entities);
      
      this.organizationService.removeMaintenanceTeam( _resolved_1);
      _xblockexpression = (result);
    }
    return _xblockexpression;
  }
  
  public Collection<UIMaintenanceTeam> loadTeams() throws SessionTimeOutException, ValidationException {
    Collection<RCMaintenanceTeam> _all = this.entities.<RCMaintenanceTeam>all(RCMaintenanceTeam.class);
    final Function1<RCMaintenanceTeam,UIMaintenanceTeam> _function = new Function1<RCMaintenanceTeam,UIMaintenanceTeam>() {
        public UIMaintenanceTeam apply(final RCMaintenanceTeam it) {
          UIMaintenanceTeam _transform = MaintenanceTeamManagementPresenterServiceImpl.this.mapper.transform(it);
          return _transform;
        }
      };
    Iterable<UIMaintenanceTeam> _map = IterableExtensions.<RCMaintenanceTeam, UIMaintenanceTeam>map(_all, _function);
    Collection<UIMaintenanceTeam> _unlazy = IterableExtensions2.<UIMaintenanceTeam>unlazy(_map);
    return _unlazy;
  }
}
