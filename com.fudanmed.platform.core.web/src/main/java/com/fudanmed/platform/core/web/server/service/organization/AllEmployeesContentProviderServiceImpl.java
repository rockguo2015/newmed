package com.fudanmed.platform.core.web.server.service.organization;

import com.fudanmed.platform.core.domain.RCEmployee;
import com.fudanmed.platform.core.domain.RCEmployeeDAO;
import com.fudanmed.platform.core.domain.proxy.RCEmployeeProxy;
import com.fudanmed.platform.core.web.client.organization.AllEmployeesContentProviderService;
import com.uniquesoft.uidl.contentprovider.BaseContentProviderService;
import com.uniquesoft.uidl.transform.IConvertService;
import com.uniquesoft.uidl.transform.ProxyContentProviderMapper;
import edu.fudan.mylang.pf.IObjectFactory;
import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("com.fudanmed.platform.core.web.client.organization.AllEmployeesContentProviderService")
@Transactional
public class AllEmployeesContentProviderServiceImpl extends BaseContentProviderService implements AllEmployeesContentProviderService {
  @Autowired
  private IConvertService convertService;
  
  @Autowired
  private IObjectFactory entities;
  
  @Autowired
  private ProxyContentProviderMapper<RCEmployee> mapper;
  
  @Autowired
  private RCEmployeeDAO dao;
  
  public Collection<RCEmployeeProxy> load() {
    return com.google.common.collect.Lists
    		.newArrayList(com.google.common.collect.Iterables.transform(
    				doLoad(),
    				new com.google.common.base.Function<RCEmployee, RCEmployeeProxy>() {
    					@Override
    					public  RCEmployeeProxy apply( RCEmployee input) {
    						return input.toProxy();
    					}
    				}));
    
  }
  
  public Collection<RCEmployee> doLoad() {
    Collection<RCEmployee> _allOnJobEmployees = this.dao.allOnJobEmployees();
    return _allOnJobEmployees;
  }
}
