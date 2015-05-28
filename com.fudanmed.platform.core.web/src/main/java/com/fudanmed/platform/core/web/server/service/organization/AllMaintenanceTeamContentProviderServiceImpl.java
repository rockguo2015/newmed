package com.fudanmed.platform.core.web.server.service.organization;

import com.fudanmed.platform.core.domain.RCMaintenanceTeam;
import com.fudanmed.platform.core.domain.proxy.RCMaintenanceTeamProxy;
import com.fudanmed.platform.core.web.client.organization.AllMaintenanceTeamContentProviderService;
import com.uniquesoft.uidl.contentprovider.BaseContentProviderService;
import com.uniquesoft.uidl.transform.IConvertService;
import com.uniquesoft.uidl.transform.ProxyContentProviderMapper;
import edu.fudan.mylang.pf.IObjectFactory;
import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("com.fudanmed.platform.core.web.client.organization.AllMaintenanceTeamContentProviderService")
@Transactional
public class AllMaintenanceTeamContentProviderServiceImpl extends BaseContentProviderService implements AllMaintenanceTeamContentProviderService {
  @Autowired
  private IConvertService convertService;
  
  @Autowired
  private IObjectFactory entities;
  
  @Autowired
  private ProxyContentProviderMapper<RCMaintenanceTeam> mapper;
  
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
    Collection<RCMaintenanceTeam> _all = this.entities.<RCMaintenanceTeam>all(RCMaintenanceTeam.class);
    return _all;
  }
}
