package com.fudanmed.platform.core.web.server.service.warehouse;

import com.fudanmed.platform.core.warehouse.RCInStoreType;
import com.fudanmed.platform.core.warehouse.proxy.RCInStoreTypeProxy;
import com.fudanmed.platform.core.web.client.warehouse.AllInStoreTypeContentProviderService;
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

@Service("com.fudanmed.platform.core.web.client.warehouse.AllInStoreTypeContentProviderService")
@Transactional
public class AllInStoreTypeContentProviderServiceImpl extends BaseContentProviderService implements AllInStoreTypeContentProviderService {
  @Autowired
  private IConvertService convertService;
  
  @Autowired
  private IObjectFactory entities;
  
  @Autowired
  private ProxyContentProviderMapper<RCInStoreType> mapper;
  
  public Collection<RCInStoreTypeProxy> load() {
    return com.google.common.collect.Lists
    		.newArrayList(com.google.common.collect.Iterables.transform(
    				doLoad(),
    				new com.google.common.base.Function<RCInStoreType, RCInStoreTypeProxy>() {
    					@Override
    					public  RCInStoreTypeProxy apply( RCInStoreType input) {
    						return input.toProxy();
    					}
    				}));
    
  }
  
  public Collection<RCInStoreType> doLoad() {
    Collection<RCInStoreType> _all = this.entities.<RCInStoreType>all(RCInStoreType.class);
    final Function1<RCInStoreType,String> _function = new Function1<RCInStoreType,String>() {
        public String apply(final RCInStoreType it) {
          String _codeid = it.getCodeid();
          return _codeid;
        }
      };
    List<RCInStoreType> _sortBy = IterableExtensions.<RCInStoreType, String>sortBy(_all, _function);
    return _sortBy;
  }
}
