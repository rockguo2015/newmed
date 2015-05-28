package com.fudanmed.platform.core.web.server.service.deliver;

import com.fudanmed.platform.core.deliver.DLInHospitalPatient;
import com.fudanmed.platform.core.deliver.proxy.DLInHospitalPatientProxy;
import com.fudanmed.platform.core.web.client.deliver.InHospitalPatientContentProviderService;
import com.uniquesoft.uidl.contentprovider.BaseContentProviderService;
import com.uniquesoft.uidl.transform.IConvertService;
import com.uniquesoft.uidl.transform.ProxyContentProviderMapper;
import edu.fudan.mylang.pf.IObjectFactory;
import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("com.fudanmed.platform.core.web.client.deliver.InHospitalPatientContentProviderService")
@Transactional
public class InHospitalPatientContentProviderServiceImpl extends BaseContentProviderService implements InHospitalPatientContentProviderService {
  @Autowired
  private IConvertService convertService;
  
  @Autowired
  private IObjectFactory entities;
  
  @Autowired
  private ProxyContentProviderMapper<DLInHospitalPatient> mapper;
  
  public Collection<DLInHospitalPatientProxy> load() {
    return com.google.common.collect.Lists
    		.newArrayList(com.google.common.collect.Iterables.transform(
    				doLoad(),
    				new com.google.common.base.Function<DLInHospitalPatient, DLInHospitalPatientProxy>() {
    					@Override
    					public  DLInHospitalPatientProxy apply( DLInHospitalPatient input) {
    						return input.toProxy();
    					}
    				}));
    
  }
  
  public Collection<DLInHospitalPatient> doLoad() {
    Collection<DLInHospitalPatient> _all = this.entities.<DLInHospitalPatient>all(DLInHospitalPatient.class);
    return _all;
  }
}
