package com.fudanmed.platform.core.web.server.service.deliver;

import com.fudanmed.platform.core.deliver.DLInHospitalLocation;
import com.fudanmed.platform.core.deliver.proxy.DLInHospitalLocationProxy;
import com.fudanmed.platform.core.web.client.deliver.PatientLocationContentProviderService;
import com.uniquesoft.uidl.contentprovider.BaseContentProviderService;
import com.uniquesoft.uidl.transform.IConvertService;
import com.uniquesoft.uidl.transform.ProxyContentProviderMapper;
import edu.fudan.mylang.pf.IObjectFactory;
import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("com.fudanmed.platform.core.web.client.deliver.PatientLocationContentProviderService")
@Transactional
public class PatientLocationContentProviderServiceImpl extends BaseContentProviderService implements PatientLocationContentProviderService {
  @Autowired
  private IConvertService convertService;
  
  @Autowired
  private IObjectFactory entities;
  
  @Autowired
  private ProxyContentProviderMapper<DLInHospitalLocation> mapper;
  
  public Collection<DLInHospitalLocationProxy> load() {
    return com.google.common.collect.Lists
    		.newArrayList(com.google.common.collect.Iterables.transform(
    				doLoad(),
    				new com.google.common.base.Function<DLInHospitalLocation, DLInHospitalLocationProxy>() {
    					@Override
    					public  DLInHospitalLocationProxy apply( DLInHospitalLocation input) {
    						return input.toProxy();
    					}
    				}));
    
  }
  
  public Collection<DLInHospitalLocation> doLoad() {
    Collection<DLInHospitalLocation> _all = this.entities.<DLInHospitalLocation>all(DLInHospitalLocation.class);
    return _all;
  }
}
