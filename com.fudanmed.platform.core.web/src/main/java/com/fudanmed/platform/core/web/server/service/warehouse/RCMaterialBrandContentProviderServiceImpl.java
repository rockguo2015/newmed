package com.fudanmed.platform.core.web.server.service.warehouse;

import com.fudanmed.platform.core.common.RCMaterialBrand;
import com.fudanmed.platform.core.common.proxy.RCMaterialBrandProxy;
import com.fudanmed.platform.core.web.client.warehouse.RCMaterialBrandContentProviderService;
import com.uniquesoft.uidl.contentprovider.BaseContentProviderService;
import com.uniquesoft.uidl.transform.IConvertService;
import com.uniquesoft.uidl.transform.ProxyContentProviderMapper;
import edu.fudan.mylang.pf.IObjectFactory;
import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("com.fudanmed.platform.core.web.client.warehouse.RCMaterialBrandContentProviderService")
@Transactional
public class RCMaterialBrandContentProviderServiceImpl extends BaseContentProviderService implements RCMaterialBrandContentProviderService {
  @Autowired
  private IConvertService convertService;
  
  @Autowired
  private IObjectFactory entities;
  
  @Autowired
  private ProxyContentProviderMapper<RCMaterialBrand> mapper;
  
  public Collection<RCMaterialBrandProxy> load() {
    return com.google.common.collect.Lists
    		.newArrayList(com.google.common.collect.Iterables.transform(
    				doLoad(),
    				new com.google.common.base.Function<RCMaterialBrand, RCMaterialBrandProxy>() {
    					@Override
    					public  RCMaterialBrandProxy apply( RCMaterialBrand input) {
    						return input.toProxy();
    					}
    				}));
    
  }
  
  public Collection<RCMaterialBrand> doLoad() {
    Collection<RCMaterialBrand> _all = this.entities.<RCMaterialBrand>all(RCMaterialBrand.class);
    return _all;
  }
}
