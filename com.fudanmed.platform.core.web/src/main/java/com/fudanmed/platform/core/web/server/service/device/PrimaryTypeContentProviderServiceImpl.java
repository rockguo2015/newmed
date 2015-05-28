package com.fudanmed.platform.core.web.server.service.device;

import com.fudanmed.platform.core.entityextension.RCPrimaryType;
import com.fudanmed.platform.core.entityextension.proxy.RCPrimaryTypeProxy;
import com.fudanmed.platform.core.web.client.device.PrimaryTypeContentProviderService;
import com.uniquesoft.uidl.contentprovider.BaseContentProviderService;
import com.uniquesoft.uidl.transform.IConvertService;
import com.uniquesoft.uidl.transform.ProxyContentProviderMapper;
import edu.fudan.mylang.pf.IObjectFactory;
import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("com.fudanmed.platform.core.web.client.device.PrimaryTypeContentProviderService")
@Transactional
public class PrimaryTypeContentProviderServiceImpl extends BaseContentProviderService implements PrimaryTypeContentProviderService {
  @Autowired
  private IConvertService convertService;
  
  @Autowired
  private IObjectFactory entities;
  
  @Autowired
  private ProxyContentProviderMapper<RCPrimaryType> mapper;
  
  public Collection<RCPrimaryTypeProxy> load() {
    return com.google.common.collect.Lists
    		.newArrayList(com.google.common.collect.Iterables.transform(
    				doLoad(),
    				new com.google.common.base.Function<RCPrimaryType, RCPrimaryTypeProxy>() {
    					@Override
    					public  RCPrimaryTypeProxy apply( RCPrimaryType input) {
    						return input.toProxy();
    					}
    				}));
    
  }
  
  public Collection<RCPrimaryType> doLoad() {
    Collection<RCPrimaryType> _all = this.entities.<RCPrimaryType>all(RCPrimaryType.class);
    return _all;
  }
}
