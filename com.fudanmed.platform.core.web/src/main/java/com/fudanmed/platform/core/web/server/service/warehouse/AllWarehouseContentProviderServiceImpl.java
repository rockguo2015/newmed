package com.fudanmed.platform.core.web.server.service.warehouse;

import com.fudanmed.platform.core.warehouse.RCWarehouse;
import com.fudanmed.platform.core.warehouse.proxy.RCWarehouseProxy;
import com.fudanmed.platform.core.web.client.warehouse.AllWarehouseContentProviderService;
import com.uniquesoft.uidl.contentprovider.BaseContentProviderService;
import com.uniquesoft.uidl.transform.IConvertService;
import com.uniquesoft.uidl.transform.ProxyContentProviderMapper;
import edu.fudan.mylang.pf.IObjectFactory;
import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("com.fudanmed.platform.core.web.client.warehouse.AllWarehouseContentProviderService")
@Transactional
public class AllWarehouseContentProviderServiceImpl extends BaseContentProviderService implements AllWarehouseContentProviderService {
  @Autowired
  private IConvertService convertService;
  
  @Autowired
  private IObjectFactory entities;
  
  @Autowired
  private ProxyContentProviderMapper<RCWarehouse> mapper;
  
  public Collection<RCWarehouseProxy> load() {
    return com.google.common.collect.Lists
    		.newArrayList(com.google.common.collect.Iterables.transform(
    				doLoad(),
    				new com.google.common.base.Function<RCWarehouse, RCWarehouseProxy>() {
    					@Override
    					public  RCWarehouseProxy apply( RCWarehouse input) {
    						return input.toProxy();
    					}
    				}));
    
  }
  
  public Collection<RCWarehouse> doLoad() {
    Collection<RCWarehouse> _all = this.entities.<RCWarehouse>all(RCWarehouse.class);
    return _all;
  }
}
