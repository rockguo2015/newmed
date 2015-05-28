package com.fudanmed.platform.core.web.server.service.organization;

import com.fudanmed.platform.core.domain.RCEmployee;
import com.fudanmed.platform.core.domain.RCEmployeeDAO;
import com.fudanmed.platform.core.domain.RCOrganization;
import com.fudanmed.platform.core.domain.proxy.RCEmployeeProxy;
import com.fudanmed.platform.core.domain.proxy.RCOrganizationProxy;
import com.fudanmed.platform.core.web.client.organization.AllOrgEmployeeContentProviderService;
import com.fudanmed.platform.core.web.shared.organization.AllOrgEmployeeContentProviderCriteria;
import com.google.common.base.Objects;
import com.uniquesoft.uidl.contentprovider.BaseContentProviderService;
import com.uniquesoft.uidl.transform.IConvertService;
import com.uniquesoft.uidl.transform.ProxyContentProviderMapper;
import edu.fudan.mylang.pf.IObjectFactory;
import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("com.fudanmed.platform.core.web.client.organization.AllOrgEmployeeContentProviderService")
@Transactional
public class AllOrgEmployeeContentProviderServiceImpl extends BaseContentProviderService implements AllOrgEmployeeContentProviderService {
  @Autowired
  private IConvertService convertService;
  
  @Autowired
  private IObjectFactory entities;
  
  @Autowired
  private ProxyContentProviderMapper<RCEmployee> mapper;
  
  @Autowired
  private RCEmployeeDAO dao;
  
  public Collection<RCEmployeeProxy> load(final AllOrgEmployeeContentProviderCriteria filter) {
    return com.google.common.collect.Lists
    		.newArrayList(com.google.common.collect.Iterables.transform(
    				doLoad(filter),
    				new com.google.common.base.Function<RCEmployee, RCEmployeeProxy>() {
    					@Override
    					public  RCEmployeeProxy apply( RCEmployee input) {
    						return input.toProxy();
    					}
    				}));
    
  }
  
  public Collection<RCEmployee> doLoad(final AllOrgEmployeeContentProviderCriteria filter) {
    Collection<RCEmployee> _xifexpression = null;
    RCOrganizationProxy _org = filter.getOrg();
    boolean _equals = Objects.equal(_org, null);
    if (_equals) {
      Collection<RCEmployee> _allOnJobEmployees = this.dao.allOnJobEmployees();
      _xifexpression = _allOnJobEmployees;
    } else {
      RCOrganizationProxy _org_1 = filter.getOrg();
      Long _id = _org_1.getId();
      RCOrganization _get = this.entities.<RCOrganization>get(RCOrganization.class, _id);
      Collection<RCEmployee> _onJobEmployees = _get.getOnJobEmployees();
      _xifexpression = _onJobEmployees;
    }
    return _xifexpression;
  }
}
