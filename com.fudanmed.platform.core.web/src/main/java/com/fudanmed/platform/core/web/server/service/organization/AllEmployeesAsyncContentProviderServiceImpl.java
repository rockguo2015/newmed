package com.fudanmed.platform.core.web.server.service.organization;

import com.fudanmed.platform.core.domain.RCEmployee;
import com.fudanmed.platform.core.domain.RCEmployeeByNameCriteria;
import com.fudanmed.platform.core.domain.proxy.RCEmployeeProxy;
import com.fudanmed.platform.core.web.client.organization.AllEmployeesAsyncContentProviderService;
import com.fudanmed.platform.core.web.shared.organization.AllEmployeesAsyncContentProviderCriteria;
import com.uniquesoft.uidl.contentprovider.BaseContentProviderService;
import com.uniquesoft.uidl.transform.IConvertService;
import com.uniquesoft.uidl.transform.ProxyContentProviderMapper;
import edu.fudan.mylang.pf.IObjectFactory;
import java.util.Collection;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("com.fudanmed.platform.core.web.client.organization.AllEmployeesAsyncContentProviderService")
@Transactional
public class AllEmployeesAsyncContentProviderServiceImpl extends BaseContentProviderService implements AllEmployeesAsyncContentProviderService {
  @Autowired
  private IConvertService convertService;
  
  @Autowired
  private IObjectFactory entities;
  
  @Autowired
  private ProxyContentProviderMapper<RCEmployee> mapper;
  
  public Collection<RCEmployeeProxy> load(final AllEmployeesAsyncContentProviderCriteria filter) {
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
  
  public Collection<RCEmployee> doLoad(final AllEmployeesAsyncContentProviderCriteria filter) {
    RCEmployeeByNameCriteria _createQueryCriteria = this.entities.createQueryCriteria(RCEmployeeByNameCriteria.class);
    final Procedure1<RCEmployeeByNameCriteria> _function = new Procedure1<RCEmployeeByNameCriteria>() {
        public void apply(final RCEmployeeByNameCriteria it) {
          String _name = filter.getName();
          it.setName(_name);
        }
      };
    RCEmployeeByNameCriteria _doubleArrow = ObjectExtensions.<RCEmployeeByNameCriteria>operator_doubleArrow(_createQueryCriteria, _function);
    Collection<RCEmployee> _list = _doubleArrow.list();
    return _list;
  }
}
