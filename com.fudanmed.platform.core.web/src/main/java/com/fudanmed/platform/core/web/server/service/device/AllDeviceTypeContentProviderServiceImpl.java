package com.fudanmed.platform.core.web.server.service.device;

import com.fudanmed.platform.core.device.RCDeviceType;
import com.fudanmed.platform.core.device.proxy.RCDeviceTypeProxy;
import com.fudanmed.platform.core.web.client.device.AllDeviceTypeContentProviderService;
import com.uniquesoft.uidl.contentprovider.BaseContentProviderService;
import com.uniquesoft.uidl.transform.IConvertService;
import com.uniquesoft.uidl.transform.ProxyContentProviderMapper;
import edu.fudan.mylang.pf.IObjectFactory;
import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("com.fudanmed.platform.core.web.client.device.AllDeviceTypeContentProviderService")
@Transactional
public class AllDeviceTypeContentProviderServiceImpl extends BaseContentProviderService implements AllDeviceTypeContentProviderService {
  @Autowired
  private IConvertService convertService;
  
  @Autowired
  private IObjectFactory entities;
  
  @Autowired
  private ProxyContentProviderMapper<RCDeviceType> mapper;
  
  public Collection<RCDeviceTypeProxy> load() {
    return com.google.common.collect.Lists
    		.newArrayList(com.google.common.collect.Iterables.transform(
    				doLoad(),
    				new com.google.common.base.Function<RCDeviceType, RCDeviceTypeProxy>() {
    					@Override
    					public  RCDeviceTypeProxy apply( RCDeviceType input) {
    						return input.toProxy();
    					}
    				}));
    
  }
  
  public Collection<RCDeviceType> doLoad() {
    Collection<RCDeviceType> _all = this.entities.<RCDeviceType>all(RCDeviceType.class);
    return _all;
  }
}
