package com.fudanmed.platform.core.web.server.service.organization;

import com.fudanmed.platform.core.domain.RCOrganization;
import com.fudanmed.platform.core.domain.RCOrganizationCriteria;
import com.fudanmed.platform.core.domain.proxy.RCOrganizationProxy;
import com.fudanmed.platform.core.web.client.organization.AllOrganizationAsyncContentProviderService;
import com.fudanmed.platform.core.web.shared.organization.AllOrganizationAsyncContentProviderCriteria;
import com.google.common.base.Function;
import com.uniquesoft.gwt.server.common.pager.PagedQueries;
import com.uniquesoft.gwt.shared.common.pager.IPagedResult;
import com.uniquesoft.uidl.contentprovider.BaseContentProviderService;
import com.uniquesoft.uidl.transform.IConvertService;
import com.uniquesoft.uidl.transform.ProxyContentProviderMapper;
import edu.fudan.mylang.pf.IObjectFactory;
import java.util.Collection;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("com.fudanmed.platform.core.web.client.organization.AllOrganizationAsyncContentProviderService")
@Transactional
public class AllOrganizationAsyncContentProviderServiceImpl extends BaseContentProviderService implements AllOrganizationAsyncContentProviderService {
  @Autowired
  private IConvertService convertService;
  
  @Autowired
  private IObjectFactory entities;
  
  @Autowired
  private ProxyContentProviderMapper<RCOrganization> mapper;
  
  public Collection<RCOrganizationProxy> load(final AllOrganizationAsyncContentProviderCriteria filter) {
    return com.google.common.collect.Lists
    		.newArrayList(com.google.common.collect.Iterables.transform(
    				doLoad(filter),
    				new com.google.common.base.Function<RCOrganization, RCOrganizationProxy>() {
    					@Override
    					public  RCOrganizationProxy apply( RCOrganization input) {
    						return input.toProxy();
    					}
    				}));
    
  }
  
  public Collection<RCOrganization> doLoad(final AllOrganizationAsyncContentProviderCriteria filter) {
    RCOrganizationCriteria _createPagedCriteria = PagedQueries.createPagedCriteria(filter, RCOrganizationCriteria.class, this.entities);
    final Procedure1<RCOrganizationCriteria> _function = new Procedure1<RCOrganizationCriteria>() {
        public void apply(final RCOrganizationCriteria it) {
          String _name = filter.getName();
          it.setInfo(_name);
        }
      };
    RCOrganizationCriteria _doubleArrow = ObjectExtensions.<RCOrganizationCriteria>operator_doubleArrow(_createPagedCriteria, _function);
    final Function1<RCOrganization,RCOrganization> _function_1 = new Function1<RCOrganization,RCOrganization>() {
        public RCOrganization apply(final RCOrganization it) {
          return it;
        }
      };
    IPagedResult<RCOrganization> _listAndTransform = PagedQueries.<RCOrganization, RCOrganization>listAndTransform(_doubleArrow, new Function<RCOrganization,RCOrganization>() {
        public RCOrganization apply(RCOrganization input) {
          return _function_1.apply(input);
        }
    });
    return _listAndTransform;
  }
}
