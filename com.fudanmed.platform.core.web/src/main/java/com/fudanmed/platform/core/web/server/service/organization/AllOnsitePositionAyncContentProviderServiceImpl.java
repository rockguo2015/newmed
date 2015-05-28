package com.fudanmed.platform.core.web.server.service.organization;

import com.fudanmed.platform.core.domain.RCOnsitePosition;
import com.fudanmed.platform.core.domain.RCOnsitePositionCriteria;
import com.fudanmed.platform.core.domain.proxy.RCOnsitePositionProxy;
import com.fudanmed.platform.core.web.client.organization.AllOnsitePositionAyncContentProviderService;
import com.fudanmed.platform.core.web.shared.organization.AllOnsitePositionAyncContentProviderCriteria;
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

@Service("com.fudanmed.platform.core.web.client.organization.AllOnsitePositionAyncContentProviderService")
@Transactional
public class AllOnsitePositionAyncContentProviderServiceImpl extends BaseContentProviderService implements AllOnsitePositionAyncContentProviderService {
  @Autowired
  private IConvertService convertService;
  
  @Autowired
  private IObjectFactory entities;
  
  @Autowired
  private ProxyContentProviderMapper<RCOnsitePosition> mapper;
  
  public Collection<RCOnsitePositionProxy> load(final AllOnsitePositionAyncContentProviderCriteria filter) {
    return com.google.common.collect.Lists
    		.newArrayList(com.google.common.collect.Iterables.transform(
    				doLoad(filter),
    				new com.google.common.base.Function<RCOnsitePosition, RCOnsitePositionProxy>() {
    					@Override
    					public  RCOnsitePositionProxy apply( RCOnsitePosition input) {
    						return input.toProxy();
    					}
    				}));
    
  }
  
  public Collection<RCOnsitePosition> doLoad(final AllOnsitePositionAyncContentProviderCriteria filter) {
    RCOnsitePositionCriteria _createPagedCriteria = PagedQueries.createPagedCriteria(filter, RCOnsitePositionCriteria.class, this.entities);
    final Procedure1<RCOnsitePositionCriteria> _function = new Procedure1<RCOnsitePositionCriteria>() {
        public void apply(final RCOnsitePositionCriteria it) {
          String _name = filter.getName();
          it.setInfo(_name);
        }
      };
    RCOnsitePositionCriteria _doubleArrow = ObjectExtensions.<RCOnsitePositionCriteria>operator_doubleArrow(_createPagedCriteria, _function);
    final Function1<RCOnsitePosition,RCOnsitePosition> _function_1 = new Function1<RCOnsitePosition,RCOnsitePosition>() {
        public RCOnsitePosition apply(final RCOnsitePosition it) {
          return it;
        }
      };
    IPagedResult<RCOnsitePosition> _listAndTransform = PagedQueries.<RCOnsitePosition, RCOnsitePosition>listAndTransform(_doubleArrow, new Function<RCOnsitePosition,RCOnsitePosition>() {
        public RCOnsitePosition apply(RCOnsitePosition input) {
          return _function_1.apply(input);
        }
    });
    return _listAndTransform;
  }
}
