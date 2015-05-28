package com.fudanmed.platform.core.web.server.service.device;

import com.fudanmed.platform.core.device.RCAcquireType;
import com.fudanmed.platform.core.device.proxy.RCAcquireTypeProxy;
import com.fudanmed.platform.core.web.client.device.AllAquireTypeContentProviderService;
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

@Service("com.fudanmed.platform.core.web.client.device.AllAquireTypeContentProviderService")
@Transactional
public class AllAquireTypeContentProviderServiceImpl extends BaseContentProviderService implements AllAquireTypeContentProviderService {
  @Autowired
  private IConvertService convertService;
  
  @Autowired
  private IObjectFactory entities;
  
  @Autowired
  private ProxyContentProviderMapper<RCAcquireType> mapper;
  
  public Collection<RCAcquireTypeProxy> load() {
    return com.google.common.collect.Lists
    		.newArrayList(com.google.common.collect.Iterables.transform(
    				doLoad(),
    				new com.google.common.base.Function<RCAcquireType, RCAcquireTypeProxy>() {
    					@Override
    					public  RCAcquireTypeProxy apply( RCAcquireType input) {
    						return input.toProxy();
    					}
    				}));
    
  }
  
  public Collection<RCAcquireType> doLoad() {
    Collection<RCAcquireType> _all = this.entities.<RCAcquireType>all(RCAcquireType.class);
    final Function1<RCAcquireType,String> _function = new Function1<RCAcquireType,String>() {
        public String apply(final RCAcquireType it) {
          String _codeid = it.getCodeid();
          return _codeid;
        }
      };
    List<RCAcquireType> _sortBy = IterableExtensions.<RCAcquireType, String>sortBy(_all, _function);
    return _sortBy;
  }
}
