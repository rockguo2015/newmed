package com.fudanmed.platform.core.web.server.service.deliver;

import com.fudanmed.platform.core.deliver.DLCheckOrganization;
import com.fudanmed.platform.core.deliver.DLDeliverPatientCheckType;
import com.fudanmed.platform.core.deliver.proxy.DLCheckOrganizationProxy;
import com.fudanmed.platform.core.deliver.proxy.DLDeliverPatientCheckTypeProxy;
import com.fudanmed.platform.core.web.client.deliver.CheckOrgContentProviderService;
import com.fudanmed.platform.core.web.shared.deliver.CheckOrgContentProviderCriteria;
import com.google.common.base.Objects;
import com.uniquesoft.uidl.contentprovider.BaseContentProviderService;
import com.uniquesoft.uidl.transform.IConvertService;
import com.uniquesoft.uidl.transform.ProxyContentProviderMapper;
import edu.fudan.mylang.pf.IObjectFactory;
import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("com.fudanmed.platform.core.web.client.deliver.CheckOrgContentProviderService")
@Transactional
public class CheckOrgContentProviderServiceImpl extends BaseContentProviderService implements CheckOrgContentProviderService {
  @Autowired
  private IConvertService convertService;
  
  @Autowired
  private IObjectFactory entities;
  
  @Autowired
  private ProxyContentProviderMapper<DLCheckOrganization> mapper;
  
  public Collection<DLCheckOrganizationProxy> load(final CheckOrgContentProviderCriteria filter) {
    return com.google.common.collect.Lists
    		.newArrayList(com.google.common.collect.Iterables.transform(
    				doLoad(filter),
    				new com.google.common.base.Function<DLCheckOrganization, DLCheckOrganizationProxy>() {
    					@Override
    					public  DLCheckOrganizationProxy apply( DLCheckOrganization input) {
    						return input.toProxy();
    					}
    				}));
    
  }
  
  public Collection<DLCheckOrganization> doLoad(final CheckOrgContentProviderCriteria filter) {
    Collection<DLCheckOrganization> _xifexpression = null;
    DLDeliverPatientCheckTypeProxy _checkType = filter.getCheckType();
    boolean _equals = Objects.equal(_checkType, null);
    if (_equals) {
      Collection<DLCheckOrganization> _all = this.entities.<DLCheckOrganization>all(DLCheckOrganization.class);
      _xifexpression = _all;
    } else {
      DLDeliverPatientCheckTypeProxy _checkType_1 = filter.getCheckType();
      Long _id = _checkType_1.getId();
      DLDeliverPatientCheckType _get = this.entities.<DLDeliverPatientCheckType>get(DLDeliverPatientCheckType.class, _id);
      Collection<DLCheckOrganization> _checkOrganization = _get.getCheckOrganization();
      _xifexpression = _checkOrganization;
    }
    return _xifexpression;
  }
}
