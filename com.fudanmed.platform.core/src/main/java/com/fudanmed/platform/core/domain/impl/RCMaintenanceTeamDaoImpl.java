package com.fudanmed.platform.core.domain.impl;

import com.fudanmed.platform.core.domain.RCEmployee;
import com.fudanmed.platform.core.domain.RCMaintenanceTeam;
import com.fudanmed.platform.core.domain.RCMaintenanceTeamDao;
import com.fudanmed.platform.core.warehouse.RCWarehouse;
import com.google.common.collect.Iterables;
import edu.fudan.langlab.domain.organization.Party;
import edu.fudan.langlab.domain.security.ISystemUserService;
import edu.fudan.mylang.pf.BaseDAOService;
import edu.fudan.mylang.pf.IGenericQuery;
import java.util.Collection;
import java.util.Set;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("com.fudanmed.platform.core.domain.RCMaintenanceTeamDao")
public class RCMaintenanceTeamDaoImpl extends BaseDAOService<RCMaintenanceTeam> implements RCMaintenanceTeamDao {
  @Autowired
  private ISystemUserService systemUserService;
  
  public Iterable<RCMaintenanceTeam> getAllStoreValidTeam4CurrentUser() {
    Set<RCMaintenanceTeam> _xblockexpression = null;
    {
      Party _currentUserAsParty = this.systemUserService.getCurrentUserAsParty();
      final RCEmployee emp = ((RCEmployee) _currentUserAsParty);
      IGenericQuery<RCWarehouse> query=getObjectFactory().createGenericQuery(RCWarehouse.class,"select  distinct e from com.fudanmed.platform.core.warehouse.impl.RCWarehouseImpl as e left join  e.storeManager as sm   where (sm = :emp) and  e.active = 1      ").setParameter("emp",emp);
      Collection<RCWarehouse> _list = query.list();
      final Function1<RCWarehouse,Collection<RCMaintenanceTeam>> _function = new Function1<RCWarehouse,Collection<RCMaintenanceTeam>>() {
          public Collection<RCMaintenanceTeam> apply(final RCWarehouse it) {
            Collection<RCMaintenanceTeam> _relatedTeams = it.getRelatedTeams();
            return _relatedTeams;
          }
        };
      Iterable<Collection<RCMaintenanceTeam>> _map = IterableExtensions.<RCWarehouse, Collection<RCMaintenanceTeam>>map(_list, _function);
      Iterable<RCMaintenanceTeam> _flatten = Iterables.<RCMaintenanceTeam>concat(_map);
      Set<RCMaintenanceTeam> _set = IterableExtensions.<RCMaintenanceTeam>toSet(_flatten);
      _xblockexpression = (_set);
    }
    return _xblockexpression;
  }
}
