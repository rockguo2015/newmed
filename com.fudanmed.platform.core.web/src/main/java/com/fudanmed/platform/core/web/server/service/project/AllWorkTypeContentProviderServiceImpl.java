package com.fudanmed.platform.core.web.server.service.project;

import com.fudanmed.platform.core.common.RCWorkType;
import com.fudanmed.platform.core.common.proxy.RCWorkTypeProxy;
import com.fudanmed.platform.core.web.client.project.AllWorkTypeContentProviderService;
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

@Service("com.fudanmed.platform.core.web.client.project.AllWorkTypeContentProviderService")
@Transactional
public class AllWorkTypeContentProviderServiceImpl extends BaseContentProviderService implements AllWorkTypeContentProviderService {
  @Autowired
  private IConvertService convertService;
  
  @Autowired
  private IObjectFactory entities;
  
  @Autowired
  private ProxyContentProviderMapper<RCWorkType> mapper;
  
  public Collection<RCWorkTypeProxy> load() {
    return com.google.common.collect.Lists
    		.newArrayList(com.google.common.collect.Iterables.transform(
    				doLoad(),
    				new com.google.common.base.Function<RCWorkType, RCWorkTypeProxy>() {
    					@Override
    					public  RCWorkTypeProxy apply( RCWorkType input) {
    						return input.toProxy();
    					}
    				}));
    
  }
  
  public Collection<RCWorkType> doLoad() {
    Collection<RCWorkType> _all = this.entities.<RCWorkType>all(RCWorkType.class);
    final Function1<RCWorkType,String> _function = new Function1<RCWorkType,String>() {
        public String apply(final RCWorkType it) {
          String _codeid = it.getCodeid();
          return _codeid;
        }
      };
    List<RCWorkType> _sortBy = IterableExtensions.<RCWorkType, String>sortBy(_all, _function);
    return _sortBy;
  }
}
