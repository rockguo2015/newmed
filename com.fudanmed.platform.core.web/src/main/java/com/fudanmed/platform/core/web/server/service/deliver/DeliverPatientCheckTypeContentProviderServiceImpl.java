package com.fudanmed.platform.core.web.server.service.deliver;

import com.fudanmed.platform.core.deliver.DLDeliverPatientCheckType;
import com.fudanmed.platform.core.deliver.proxy.DLDeliverPatientCheckTypeProxy;
import com.fudanmed.platform.core.web.client.deliver.DeliverPatientCheckTypeContentProviderService;
import com.uniquesoft.uidl.contentprovider.BaseContentProviderService;
import com.uniquesoft.uidl.transform.IConvertService;
import com.uniquesoft.uidl.transform.ProxyContentProviderMapper;
import edu.fudan.mylang.pf.IObjectFactory;
import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("com.fudanmed.platform.core.web.client.deliver.DeliverPatientCheckTypeContentProviderService")
@Transactional
public class DeliverPatientCheckTypeContentProviderServiceImpl extends BaseContentProviderService implements DeliverPatientCheckTypeContentProviderService {
  @Autowired
  private IConvertService convertService;
  
  @Autowired
  private IObjectFactory entities;
  
  @Autowired
  private ProxyContentProviderMapper<DLDeliverPatientCheckType> mapper;
  
  public Collection<DLDeliverPatientCheckTypeProxy> load() {
    return com.google.common.collect.Lists
    		.newArrayList(com.google.common.collect.Iterables.transform(
    				doLoad(),
    				new com.google.common.base.Function<DLDeliverPatientCheckType, DLDeliverPatientCheckTypeProxy>() {
    					@Override
    					public  DLDeliverPatientCheckTypeProxy apply( DLDeliverPatientCheckType input) {
    						return input.toProxy();
    					}
    				}));
    
  }
  
  public Collection<DLDeliverPatientCheckType> doLoad() {
    Collection<DLDeliverPatientCheckType> _all = this.entities.<DLDeliverPatientCheckType>all(DLDeliverPatientCheckType.class);
    return _all;
  }
}
