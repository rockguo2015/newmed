package com.fudanmed.platform.core.web.server.service.organization;

import com.fudanmed.platform.core.domain.RCOrganization;
import com.fudanmed.platform.core.domain.proxy.RCOrganizationProxy;
import com.fudanmed.platform.core.web.client.organization.AllOrganizationContentProviderService;
import com.uniquesoft.uidl.contentprovider.BaseContentProviderService;
import com.uniquesoft.uidl.transform.IConvertService;
import com.uniquesoft.uidl.transform.ProxyContentProviderMapper;
import edu.fudan.mylang.pf.IObjectFactory;
import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("com.fudanmed.platform.core.web.client.organization.AllOrganizationContentProviderService")
@Transactional
public class AllOrganizationContentProviderServiceImpl extends BaseContentProviderService implements AllOrganizationContentProviderService {
  @Autowired
  private IConvertService convertService;
  
  @Autowired
  private IObjectFactory entities;
  
  @Autowired
  private ProxyContentProviderMapper<RCOrganization> mapper;
  
  public Collection<RCOrganizationProxy> load() {
    return com.google.common.collect.Lists
    		.newArrayList(com.google.common.collect.Iterables.transform(
    				doLoad(),
    				new com.google.common.base.Function<RCOrganization, RCOrganizationProxy>() {
    					@Override
    					public  RCOrganizationProxy apply( RCOrganization input) {
    						return input.toProxy();
    					}
    				}));
    
  }
  
  public Collection<RCOrganization> doLoad() {
    Collection<RCOrganization> _all = this.entities.<RCOrganization>all(RCOrganization.class);
    return _all;
  }
}
