package com.fudanmed.platform.core.web.server.service.deliver;

import com.fudanmed.platform.core.deliver.DLCheckOrganization;
import com.fudanmed.platform.core.deliver.proxy.DLCheckOrganizationProxy;
import com.fudanmed.platform.core.web.client.deliver.CheckOrganizationContentProviderService;
import com.uniquesoft.uidl.contentprovider.BaseContentProviderService;
import com.uniquesoft.uidl.transform.IConvertService;
import com.uniquesoft.uidl.transform.ProxyContentProviderMapper;
import edu.fudan.mylang.pf.IObjectFactory;
import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("com.fudanmed.platform.core.web.client.deliver.CheckOrganizationContentProviderService")
@Transactional
public class CheckOrganizationContentProviderServiceImpl extends BaseContentProviderService implements CheckOrganizationContentProviderService {
  @Autowired
  private IConvertService convertService;
  
  @Autowired
  private IObjectFactory entities;
  
  @Autowired
  private ProxyContentProviderMapper<DLCheckOrganization> mapper;
  
  public Collection<DLCheckOrganizationProxy> load() {
    return com.google.common.collect.Lists
    		.newArrayList(com.google.common.collect.Iterables.transform(
    				doLoad(),
    				new com.google.common.base.Function<DLCheckOrganization, DLCheckOrganizationProxy>() {
    					@Override
    					public  DLCheckOrganizationProxy apply( DLCheckOrganization input) {
    						return input.toProxy();
    					}
    				}));
    
  }
  
  public Collection<DLCheckOrganization> doLoad() {
    Collection<DLCheckOrganization> _all = this.entities.<DLCheckOrganization>all(DLCheckOrganization.class);
    return _all;
  }
}
