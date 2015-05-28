package com.fudanmed.platform.core.web.server.service.device;

import com.fudanmed.platform.core.device.pm.RCDevicePMType;
import com.fudanmed.platform.core.device.pm.proxy.RCDevicePMTypeProxy;
import com.fudanmed.platform.core.web.client.device.RCDevicePMTypeContentProviderService;
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

@Service("com.fudanmed.platform.core.web.client.device.RCDevicePMTypeContentProviderService")
@Transactional
public class RCDevicePMTypeContentProviderServiceImpl extends BaseContentProviderService implements RCDevicePMTypeContentProviderService {
  @Autowired
  private IConvertService convertService;
  
  @Autowired
  private IObjectFactory entities;
  
  @Autowired
  private ProxyContentProviderMapper<RCDevicePMType> mapper;
  
  public Collection<RCDevicePMTypeProxy> load() {
    return com.google.common.collect.Lists
    		.newArrayList(com.google.common.collect.Iterables.transform(
    				doLoad(),
    				new com.google.common.base.Function<RCDevicePMType, RCDevicePMTypeProxy>() {
    					@Override
    					public  RCDevicePMTypeProxy apply( RCDevicePMType input) {
    						return input.toProxy();
    					}
    				}));
    
  }
  
  public Collection<RCDevicePMType> doLoad() {
    Collection<RCDevicePMType> _all = this.entities.<RCDevicePMType>all(RCDevicePMType.class);
    final Function1<RCDevicePMType,String> _function = new Function1<RCDevicePMType,String>() {
        public String apply(final RCDevicePMType it) {
          String _codeid = it.getCodeid();
          return _codeid;
        }
      };
    List<RCDevicePMType> _sortBy = IterableExtensions.<RCDevicePMType, String>sortBy(_all, _function);
    return _sortBy;
  }
}
