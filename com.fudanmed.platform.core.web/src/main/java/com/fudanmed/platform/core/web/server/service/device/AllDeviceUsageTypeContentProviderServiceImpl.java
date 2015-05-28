package com.fudanmed.platform.core.web.server.service.device;

import com.fudanmed.platform.core.device.RCDeviceUsageType;
import com.fudanmed.platform.core.device.proxy.RCDeviceUsageTypeProxy;
import com.fudanmed.platform.core.web.client.device.AllDeviceUsageTypeContentProviderService;
import com.uniquesoft.uidl.contentprovider.BaseContentProviderService;
import com.uniquesoft.uidl.transform.IConvertService;
import com.uniquesoft.uidl.transform.ProxyContentProviderMapper;
import edu.fudan.mylang.pf.IObjectFactory;
import java.util.Collection;
import java.util.List;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("com.fudanmed.platform.core.web.client.device.AllDeviceUsageTypeContentProviderService")
@Transactional
public class AllDeviceUsageTypeContentProviderServiceImpl extends BaseContentProviderService implements AllDeviceUsageTypeContentProviderService {
  @Autowired
  private IConvertService convertService;
  
  @Autowired
  private IObjectFactory entities;
  
  @Autowired
  private ProxyContentProviderMapper<RCDeviceUsageType> mapper;
  
  public Collection<RCDeviceUsageTypeProxy> load() {
    return com.google.common.collect.Lists
    		.newArrayList(com.google.common.collect.Iterables.transform(
    				doLoad(),
    				new com.google.common.base.Function<RCDeviceUsageType, RCDeviceUsageTypeProxy>() {
    					@Override
    					public  RCDeviceUsageTypeProxy apply( RCDeviceUsageType input) {
    						return input.toProxy();
    					}
    				}));
    
  }
  
  public Collection<RCDeviceUsageType> doLoad() {
    Collection<RCDeviceUsageType> _all = this.entities.<RCDeviceUsageType>all(RCDeviceUsageType.class);
    final Function1<RCDeviceUsageType,String> _function = new Function1<RCDeviceUsageType,String>() {
        public String apply(final RCDeviceUsageType it) {
          String _codeid = it.getCodeid();
          return _codeid;
        }
      };
    List<RCDeviceUsageType> _sortBy = IterableExtensions.<RCDeviceUsageType, String>sortBy(_all, _function);
    return _sortBy;
  }
}
