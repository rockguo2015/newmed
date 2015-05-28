package com.fudanmed.platform.core.web.server.service.warehouse;

import com.fudanmed.platform.core.warehouse.RCProduceSpecificationUnit;
import com.fudanmed.platform.core.warehouse.proxy.RCProduceSpecificationUnitProxy;
import com.fudanmed.platform.core.web.client.warehouse.AllProduceSpecificationUnitContentProviderService;
import com.uniquesoft.uidl.contentprovider.BaseContentProviderService;
import com.uniquesoft.uidl.transform.IConvertService;
import com.uniquesoft.uidl.transform.ProxyContentProviderMapper;
import edu.fudan.mylang.pf.IObjectFactory;
import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("com.fudanmed.platform.core.web.client.warehouse.AllProduceSpecificationUnitContentProviderService")
@Transactional
public class AllProduceSpecificationUnitContentProviderServiceImpl extends BaseContentProviderService implements AllProduceSpecificationUnitContentProviderService {
  @Autowired
  private IConvertService convertService;
  
  @Autowired
  private IObjectFactory entities;
  
  @Autowired
  private ProxyContentProviderMapper<RCProduceSpecificationUnit> mapper;
  
  public Collection<RCProduceSpecificationUnitProxy> load() {
    return com.google.common.collect.Lists
    		.newArrayList(com.google.common.collect.Iterables.transform(
    				doLoad(),
    				new com.google.common.base.Function<RCProduceSpecificationUnit, RCProduceSpecificationUnitProxy>() {
    					@Override
    					public  RCProduceSpecificationUnitProxy apply( RCProduceSpecificationUnit input) {
    						return input.toProxy();
    					}
    				}));
    
  }
  
  public Collection<RCProduceSpecificationUnit> doLoad() {
    Collection<RCProduceSpecificationUnit> _all = this.entities.<RCProduceSpecificationUnit>all(RCProduceSpecificationUnit.class);
    return _all;
  }
}
