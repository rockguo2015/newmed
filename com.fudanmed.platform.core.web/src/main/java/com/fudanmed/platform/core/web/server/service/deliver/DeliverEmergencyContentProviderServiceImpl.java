package com.fudanmed.platform.core.web.server.service.deliver;

import com.fudanmed.platform.core.deliver.DLDeliverEmergency;
import com.fudanmed.platform.core.deliver.proxy.DLDeliverEmergencyProxy;
import com.fudanmed.platform.core.web.client.deliver.DeliverEmergencyContentProviderService;
import com.uniquesoft.uidl.contentprovider.BaseContentProviderService;
import com.uniquesoft.uidl.transform.IConvertService;
import com.uniquesoft.uidl.transform.ProxyContentProviderMapper;
import edu.fudan.mylang.pf.IObjectFactory;
import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("com.fudanmed.platform.core.web.client.deliver.DeliverEmergencyContentProviderService")
@Transactional
public class DeliverEmergencyContentProviderServiceImpl extends BaseContentProviderService implements DeliverEmergencyContentProviderService {
  @Autowired
  private IConvertService convertService;
  
  @Autowired
  private IObjectFactory entities;
  
  @Autowired
  private ProxyContentProviderMapper<DLDeliverEmergency> mapper;
  
  public Collection<DLDeliverEmergencyProxy> load() {
    return com.google.common.collect.Lists
    		.newArrayList(com.google.common.collect.Iterables.transform(
    				doLoad(),
    				new com.google.common.base.Function<DLDeliverEmergency, DLDeliverEmergencyProxy>() {
    					@Override
    					public  DLDeliverEmergencyProxy apply( DLDeliverEmergency input) {
    						return input.toProxy();
    					}
    				}));
    
  }
  
  public Collection<DLDeliverEmergency> doLoad() {
    Collection<DLDeliverEmergency> _all = this.entities.<DLDeliverEmergency>all(DLDeliverEmergency.class);
    return _all;
  }
}
