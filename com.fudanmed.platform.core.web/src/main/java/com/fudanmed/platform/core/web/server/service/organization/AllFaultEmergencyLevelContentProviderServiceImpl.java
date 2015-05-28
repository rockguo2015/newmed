package com.fudanmed.platform.core.web.server.service.organization;

import com.fudanmed.platform.core.common.RCFaultEmergencyLevel;
import com.fudanmed.platform.core.common.proxy.RCFaultEmergencyLevelProxy;
import com.fudanmed.platform.core.web.client.organization.AllFaultEmergencyLevelContentProviderService;
import com.uniquesoft.uidl.contentprovider.BaseContentProviderService;
import com.uniquesoft.uidl.transform.IConvertService;
import com.uniquesoft.uidl.transform.ProxyContentProviderMapper;
import edu.fudan.mylang.pf.IObjectFactory;
import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("com.fudanmed.platform.core.web.client.organization.AllFaultEmergencyLevelContentProviderService")
@Transactional
public class AllFaultEmergencyLevelContentProviderServiceImpl extends BaseContentProviderService implements AllFaultEmergencyLevelContentProviderService {
  @Autowired
  private IConvertService convertService;
  
  @Autowired
  private IObjectFactory entities;
  
  @Autowired
  private ProxyContentProviderMapper<RCFaultEmergencyLevel> mapper;
  
  public Collection<RCFaultEmergencyLevelProxy> load() {
    return com.google.common.collect.Lists
    		.newArrayList(com.google.common.collect.Iterables.transform(
    				doLoad(),
    				new com.google.common.base.Function<RCFaultEmergencyLevel, RCFaultEmergencyLevelProxy>() {
    					@Override
    					public  RCFaultEmergencyLevelProxy apply( RCFaultEmergencyLevel input) {
    						return input.toProxy();
    					}
    				}));
    
  }
  
  public Collection<RCFaultEmergencyLevel> doLoad() {
    Collection<RCFaultEmergencyLevel> _all = this.entities.<RCFaultEmergencyLevel>all(RCFaultEmergencyLevel.class);
    return _all;
  }
}
