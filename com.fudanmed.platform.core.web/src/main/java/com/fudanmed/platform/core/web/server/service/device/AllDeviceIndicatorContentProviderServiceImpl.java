package com.fudanmed.platform.core.web.server.service.device;

import com.fudanmed.platform.core.device.RCDeviceIndicator;
import com.fudanmed.platform.core.device.proxy.RCDeviceIndicatorProxy;
import com.fudanmed.platform.core.web.client.device.AllDeviceIndicatorContentProviderService;
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

@Service("com.fudanmed.platform.core.web.client.device.AllDeviceIndicatorContentProviderService")
@Transactional
public class AllDeviceIndicatorContentProviderServiceImpl extends BaseContentProviderService implements AllDeviceIndicatorContentProviderService {
  @Autowired
  private IConvertService convertService;
  
  @Autowired
  private IObjectFactory entities;
  
  @Autowired
  private ProxyContentProviderMapper<RCDeviceIndicator> mapper;
  
  public Collection<RCDeviceIndicatorProxy> load() {
    return com.google.common.collect.Lists
    		.newArrayList(com.google.common.collect.Iterables.transform(
    				doLoad(),
    				new com.google.common.base.Function<RCDeviceIndicator, RCDeviceIndicatorProxy>() {
    					@Override
    					public  RCDeviceIndicatorProxy apply( RCDeviceIndicator input) {
    						return input.toProxy();
    					}
    				}));
    
  }
  
  public Collection<RCDeviceIndicator> doLoad() {
    Collection<RCDeviceIndicator> _all = this.entities.<RCDeviceIndicator>all(RCDeviceIndicator.class);
    final Function1<RCDeviceIndicator,String> _function = new Function1<RCDeviceIndicator,String>() {
        public String apply(final RCDeviceIndicator it) {
          String _codeid = it.getCodeid();
          return _codeid;
        }
      };
    List<RCDeviceIndicator> _sortBy = IterableExtensions.<RCDeviceIndicator, String>sortBy(_all, _function);
    return _sortBy;
  }
}
