package com.fudanmed.platform.core.web.server.service.organization;

import com.fudanmed.platform.core.deliver.DLDeliverOrganization;
import com.fudanmed.platform.core.deliver.proxy.DLDeliverOrganizationProxy;
import com.fudanmed.platform.core.web.client.organization.AllDeliverOrganizationContentProviderService;
import com.uniquesoft.uidl.contentprovider.BaseContentProviderService;
import com.uniquesoft.uidl.transform.IConvertService;
import com.uniquesoft.uidl.transform.ProxyContentProviderMapper;
import edu.fudan.mylang.pf.IObjectFactory;
import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("com.fudanmed.platform.core.web.client.organization.AllDeliverOrganizationContentProviderService")
@Transactional
public class AllDeliverOrganizationContentProviderServiceImpl extends BaseContentProviderService implements AllDeliverOrganizationContentProviderService {
  @Autowired
  private IConvertService convertService;
  
  @Autowired
  private IObjectFactory entities;
  
  @Autowired
  private ProxyContentProviderMapper<DLDeliverOrganization> mapper;
  
  public Collection<DLDeliverOrganizationProxy> load() {
    return com.google.common.collect.Lists
    		.newArrayList(com.google.common.collect.Iterables.transform(
    				doLoad(),
    				new com.google.common.base.Function<DLDeliverOrganization, DLDeliverOrganizationProxy>() {
    					@Override
    					public  DLDeliverOrganizationProxy apply( DLDeliverOrganization input) {
    						return input.toProxy();
    					}
    				}));
    
  }
  
  public Collection<DLDeliverOrganization> doLoad() {
    Collection<DLDeliverOrganization> _all = this.entities.<DLDeliverOrganization>all(DLDeliverOrganization.class);
    return _all;
  }
}
