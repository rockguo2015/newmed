package com.fudanmed.platform.core.web.server.service.project;

import com.fudanmed.platform.core.common.RCFaultReportSource;
import com.fudanmed.platform.core.common.proxy.RCFaultReportSourceProxy;
import com.fudanmed.platform.core.web.client.project.FaultReportSourceContentProviderService;
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

@Service("com.fudanmed.platform.core.web.client.project.FaultReportSourceContentProviderService")
@Transactional
public class FaultReportSourceContentProviderServiceImpl extends BaseContentProviderService implements FaultReportSourceContentProviderService {
  @Autowired
  private IConvertService convertService;
  
  @Autowired
  private IObjectFactory entities;
  
  @Autowired
  private ProxyContentProviderMapper<RCFaultReportSource> mapper;
  
  public Collection<RCFaultReportSourceProxy> load() {
    return com.google.common.collect.Lists
    		.newArrayList(com.google.common.collect.Iterables.transform(
    				doLoad(),
    				new com.google.common.base.Function<RCFaultReportSource, RCFaultReportSourceProxy>() {
    					@Override
    					public  RCFaultReportSourceProxy apply( RCFaultReportSource input) {
    						return input.toProxy();
    					}
    				}));
    
  }
  
  public Collection<RCFaultReportSource> doLoad() {
    Collection<RCFaultReportSource> _all = this.entities.<RCFaultReportSource>all(RCFaultReportSource.class);
    final Function1<RCFaultReportSource,String> _function = new Function1<RCFaultReportSource,String>() {
        public String apply(final RCFaultReportSource it) {
          String _codeid = it.getCodeid();
          return _codeid;
        }
      };
    List<RCFaultReportSource> _sortBy = IterableExtensions.<RCFaultReportSource, String>sortBy(_all, _function);
    return _sortBy;
  }
}
