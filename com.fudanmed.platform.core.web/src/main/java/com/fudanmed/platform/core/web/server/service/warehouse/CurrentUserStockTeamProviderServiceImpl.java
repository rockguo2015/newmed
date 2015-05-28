package com.fudanmed.platform.core.web.server.service.warehouse;

import com.fudanmed.platform.core.domain.RCMaintenanceTeam;
import com.fudanmed.platform.core.domain.RCMaintenanceTeamDao;
import com.fudanmed.platform.core.domain.proxy.RCMaintenanceTeamProxy;
import com.fudanmed.platform.core.web.client.warehouse.CurrentUserStockTeamProviderService;
import com.uniquesoft.gwt.shared.extensions.IterableExtensions2;
import com.uniquesoft.uidl.contentprovider.BaseContentProviderService;
import com.uniquesoft.uidl.transform.IConvertService;
import com.uniquesoft.uidl.transform.ProxyContentProviderMapper;
import edu.fudan.mylang.pf.IObjectFactory;
import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("com.fudanmed.platform.core.web.client.warehouse.CurrentUserStockTeamProviderService")
@Transactional
public class CurrentUserStockTeamProviderServiceImpl extends BaseContentProviderService implements CurrentUserStockTeamProviderService {
  @Autowired
  private IConvertService convertService;
  
  @Autowired
  private IObjectFactory entities;
  
  @Autowired
  private ProxyContentProviderMapper<RCMaintenanceTeam> mapper;
  
  @Autowired
  private RCMaintenanceTeamDao dao;
  
  public Collection<RCMaintenanceTeamProxy> load() {
    return com.google.common.collect.Lists
    		.newArrayList(com.google.common.collect.Iterables.transform(
    				doLoad(),
    				new com.google.common.base.Function<RCMaintenanceTeam, RCMaintenanceTeamProxy>() {
    					@Override
    					public  RCMaintenanceTeamProxy apply( RCMaintenanceTeam input) {
    						return input.toProxy();
    					}
    				}));
    
  }
  
  public Collection<RCMaintenanceTeam> doLoad() {
    Iterable<RCMaintenanceTeam> _allStoreValidTeam4CurrentUser = this.dao.getAllStoreValidTeam4CurrentUser();
    Collection<RCMaintenanceTeam> _unlazy = IterableExtensions2.<RCMaintenanceTeam>unlazy(_allStoreValidTeam4CurrentUser);
    return _unlazy;
  }
}
