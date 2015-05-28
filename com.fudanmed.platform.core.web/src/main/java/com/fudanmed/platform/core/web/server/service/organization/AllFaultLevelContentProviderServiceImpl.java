package com.fudanmed.platform.core.web.server.service.organization;

import com.fudanmed.platform.core.common.RCFaultLevel;
import com.fudanmed.platform.core.common.proxy.RCFaultLevelProxy;
import com.fudanmed.platform.core.web.client.organization.AllFaultLevelContentProviderService;
import com.uniquesoft.uidl.contentprovider.BaseContentProviderService;
import com.uniquesoft.uidl.transform.IConvertService;
import com.uniquesoft.uidl.transform.ProxyContentProviderMapper;
import edu.fudan.mylang.pf.IObjectFactory;
import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("com.fudanmed.platform.core.web.client.organization.AllFaultLevelContentProviderService")
@Transactional
public class AllFaultLevelContentProviderServiceImpl extends BaseContentProviderService implements AllFaultLevelContentProviderService {
  @Autowired
  private IConvertService convertService;
  
  @Autowired
  private IObjectFactory entities;
  
  @Autowired
  private ProxyContentProviderMapper<RCFaultLevel> mapper;
  
  public Collection<RCFaultLevelProxy> load() {
    return com.google.common.collect.Lists
    		.newArrayList(com.google.common.collect.Iterables.transform(
    				doLoad(),
    				new com.google.common.base.Function<RCFaultLevel, RCFaultLevelProxy>() {
    					@Override
    					public  RCFaultLevelProxy apply( RCFaultLevel input) {
    						return input.toProxy();
    					}
    				}));
    
  }
  
  public Collection<RCFaultLevel> doLoad() {
    Collection<RCFaultLevel> _all = this.entities.<RCFaultLevel>all(RCFaultLevel.class);
    return _all;
  }
}
