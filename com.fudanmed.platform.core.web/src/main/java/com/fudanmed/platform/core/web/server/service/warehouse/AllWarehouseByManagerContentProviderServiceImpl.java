package com.fudanmed.platform.core.web.server.service.warehouse;

import com.fudanmed.platform.core.domain.RCEmployee;
import com.fudanmed.platform.core.domain.proxy.RCEmployeeProxy;
import com.fudanmed.platform.core.warehouse.RCWarehouse;
import com.fudanmed.platform.core.warehouse.RCWarehouseDAO;
import com.fudanmed.platform.core.warehouse.proxy.RCWarehouseProxy;
import com.fudanmed.platform.core.web.client.warehouse.AllWarehouseByManagerContentProviderService;
import com.fudanmed.platform.core.web.shared.warehouse.AllWarehouseByManagerContentProviderCriteria;
import com.uniquesoft.uidl.contentprovider.BaseContentProviderService;
import com.uniquesoft.uidl.transform.IConvertService;
import com.uniquesoft.uidl.transform.ProxyContentProviderMapper;
import edu.fudan.mylang.pf.IObjectFactory;
import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("com.fudanmed.platform.core.web.client.warehouse.AllWarehouseByManagerContentProviderService")
@Transactional
public class AllWarehouseByManagerContentProviderServiceImpl extends BaseContentProviderService implements AllWarehouseByManagerContentProviderService {
  @Autowired
  private IConvertService convertService;
  
  @Autowired
  private IObjectFactory entities;
  
  @Autowired
  private ProxyContentProviderMapper<RCWarehouse> mapper;
  
  @Autowired
  private RCWarehouseDAO dao;
  
  public Collection<RCWarehouseProxy> load(final AllWarehouseByManagerContentProviderCriteria filter) {
    return com.google.common.collect.Lists
    		.newArrayList(com.google.common.collect.Iterables.transform(
    				doLoad(filter),
    				new com.google.common.base.Function<RCWarehouse, RCWarehouseProxy>() {
    					@Override
    					public  RCWarehouseProxy apply( RCWarehouse input) {
    						return input.toProxy();
    					}
    				}));
    
  }
  
  public Collection<RCWarehouse> doLoad(final AllWarehouseByManagerContentProviderCriteria filter) {
    Collection<RCWarehouse> _xblockexpression = null;
    {
      RCEmployeeProxy _employee = filter.getEmployee();
      RCEmployee _resolved= null;
      if(_employee!=null) _resolved=(com.fudanmed.platform.core.domain.RCEmployee)com.uniquesoft.uidl.extensions.ModelObjects.resolve(_employee, entities);
      
      final RCEmployee employee =  _resolved;
      Collection<RCWarehouse> _findManagedWarehouse = this.dao.findManagedWarehouse(employee);
      _xblockexpression = (_findManagedWarehouse);
    }
    return _xblockexpression;
  }
}
