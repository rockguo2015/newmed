package com.fudanmed.platform.core.web.server.service.project;

import com.fudanmed.platform.core.domain.RCFaultType;
import com.fudanmed.platform.core.domain.proxy.RCFaultTypeProxy;
import com.fudanmed.platform.core.web.client.project.AllFaultTypeContentProviderService;
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

@Service("com.fudanmed.platform.core.web.client.project.AllFaultTypeContentProviderService")
@Transactional
public class AllFaultTypeContentProviderServiceImpl extends BaseContentProviderService implements AllFaultTypeContentProviderService {
  @Autowired
  private IConvertService convertService;
  
  @Autowired
  private IObjectFactory entities;
  
  @Autowired
  private ProxyContentProviderMapper<RCFaultType> mapper;
  
  public Collection<RCFaultTypeProxy> load() {
    return com.google.common.collect.Lists
    		.newArrayList(com.google.common.collect.Iterables.transform(
    				doLoad(),
    				new com.google.common.base.Function<RCFaultType, RCFaultTypeProxy>() {
    					@Override
    					public  RCFaultTypeProxy apply( RCFaultType input) {
    						return input.toProxy();
    					}
    				}));
    
  }
  
  public Collection<RCFaultType> doLoad() {
    Collection<RCFaultType> _all = this.entities.<RCFaultType>all(RCFaultType.class);
    final Function1<RCFaultType,String> _function = new Function1<RCFaultType,String>() {
        public String apply(final RCFaultType it) {
          String _name = it.getName();
          return _name;
        }
      };
    List<RCFaultType> _sortBy = IterableExtensions.<RCFaultType, String>sortBy(_all, _function);
    return _sortBy;
  }
}
