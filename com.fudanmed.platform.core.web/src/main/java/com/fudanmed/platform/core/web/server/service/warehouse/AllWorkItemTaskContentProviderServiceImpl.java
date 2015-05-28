package com.fudanmed.platform.core.web.server.service.warehouse;

import com.fudanmed.platform.core.domain.RCWorkItemTask;
import com.fudanmed.platform.core.domain.proxy.RCWorkItemTaskProxy;
import com.fudanmed.platform.core.web.client.warehouse.AllWorkItemTaskContentProviderService;
import com.uniquesoft.uidl.contentprovider.BaseContentProviderService;
import com.uniquesoft.uidl.transform.IConvertService;
import com.uniquesoft.uidl.transform.ProxyContentProviderMapper;
import edu.fudan.mylang.pf.IObjectFactory;
import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("com.fudanmed.platform.core.web.client.warehouse.AllWorkItemTaskContentProviderService")
@Transactional
public class AllWorkItemTaskContentProviderServiceImpl extends BaseContentProviderService implements AllWorkItemTaskContentProviderService {
  @Autowired
  private IConvertService convertService;
  
  @Autowired
  private IObjectFactory entities;
  
  @Autowired
  private ProxyContentProviderMapper<RCWorkItemTask> mapper;
  
  public Collection<RCWorkItemTaskProxy> load() {
    return com.google.common.collect.Lists
    		.newArrayList(com.google.common.collect.Iterables.transform(
    				doLoad(),
    				new com.google.common.base.Function<RCWorkItemTask, RCWorkItemTaskProxy>() {
    					@Override
    					public  RCWorkItemTaskProxy apply( RCWorkItemTask input) {
    						return input.toProxy();
    					}
    				}));
    
  }
  
  public Collection<RCWorkItemTask> doLoad() {
    Collection<RCWorkItemTask> _all = this.entities.<RCWorkItemTask>all(RCWorkItemTask.class);
    return _all;
  }
}
