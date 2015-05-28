package com.fudanmed.platform.core.web.server.service.deliver;

import com.fudanmed.platform.core.deliver.DLPatientDeliverMethod;
import com.fudanmed.platform.core.deliver.proxy.DLPatientDeliverMethodProxy;
import com.fudanmed.platform.core.web.client.deliver.PatientDeliverMethodContentProviderService;
import com.uniquesoft.uidl.contentprovider.BaseContentProviderService;
import com.uniquesoft.uidl.transform.IConvertService;
import com.uniquesoft.uidl.transform.ProxyContentProviderMapper;
import edu.fudan.mylang.pf.IObjectFactory;
import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("com.fudanmed.platform.core.web.client.deliver.PatientDeliverMethodContentProviderService")
@Transactional
public class PatientDeliverMethodContentProviderServiceImpl extends BaseContentProviderService implements PatientDeliverMethodContentProviderService {
  @Autowired
  private IConvertService convertService;
  
  @Autowired
  private IObjectFactory entities;
  
  @Autowired
  private ProxyContentProviderMapper<DLPatientDeliverMethod> mapper;
  
  public Collection<DLPatientDeliverMethodProxy> load() {
    return com.google.common.collect.Lists
    		.newArrayList(com.google.common.collect.Iterables.transform(
    				doLoad(),
    				new com.google.common.base.Function<DLPatientDeliverMethod, DLPatientDeliverMethodProxy>() {
    					@Override
    					public  DLPatientDeliverMethodProxy apply( DLPatientDeliverMethod input) {
    						return input.toProxy();
    					}
    				}));
    
  }
  
  public Collection<DLPatientDeliverMethod> doLoad() {
    Collection<DLPatientDeliverMethod> _all = this.entities.<DLPatientDeliverMethod>all(DLPatientDeliverMethod.class);
    return _all;
  }
}
