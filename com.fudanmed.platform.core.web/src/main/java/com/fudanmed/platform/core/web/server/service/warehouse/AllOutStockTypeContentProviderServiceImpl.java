package com.fudanmed.platform.core.web.server.service.warehouse;

import com.fudanmed.platform.core.common.RCOutStockType;
import com.fudanmed.platform.core.common.proxy.RCOutStockTypeProxy;
import com.fudanmed.platform.core.web.client.warehouse.AllOutStockTypeContentProviderService;
import com.uniquesoft.gwt.shared.extensions.IterableExtensions2;
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

@Service("com.fudanmed.platform.core.web.client.warehouse.AllOutStockTypeContentProviderService")
@Transactional
public class AllOutStockTypeContentProviderServiceImpl extends BaseContentProviderService implements AllOutStockTypeContentProviderService {
  @Autowired
  private IConvertService convertService;
  
  @Autowired
  private IObjectFactory entities;
  
  @Autowired
  private ProxyContentProviderMapper<RCOutStockType> mapper;
  
  public Collection<RCOutStockTypeProxy> load() {
    return com.google.common.collect.Lists
    		.newArrayList(com.google.common.collect.Iterables.transform(
    				doLoad(),
    				new com.google.common.base.Function<RCOutStockType, RCOutStockTypeProxy>() {
    					@Override
    					public  RCOutStockTypeProxy apply( RCOutStockType input) {
    						return input.toProxy();
    					}
    				}));
    
  }
  
  public Collection<RCOutStockType> doLoad() {
    Collection<RCOutStockType> _all = this.entities.<RCOutStockType>all(RCOutStockType.class);
    final Function1<RCOutStockType,String> _function = new Function1<RCOutStockType,String>() {
        public String apply(final RCOutStockType it) {
          String _codeid = it.getCodeid();
          return _codeid;
        }
      };
    List<RCOutStockType> _sortBy = IterableExtensions.<RCOutStockType, String>sortBy(_all, _function);
    Collection<RCOutStockType> _unlazy = IterableExtensions2.<RCOutStockType>unlazy(_sortBy);
    return _unlazy;
  }
}
