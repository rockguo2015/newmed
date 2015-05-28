package com.fudanmed.platform.core.web.server.service.warehouse;

import com.fudanmed.platform.core.warehouse.RCProductType;
import com.fudanmed.platform.core.warehouse.RCProductTypeCriteria;
import com.fudanmed.platform.core.warehouse.proxy.RCProductTypeProxy;
import com.fudanmed.platform.core.web.client.warehouse.AllProductTypeContentProviderService;
import com.fudanmed.platform.core.web.shared.warehouse.AllProductTypeContentProviderCriteria;
import com.uniquesoft.uidl.contentprovider.BaseContentProviderService;
import com.uniquesoft.uidl.transform.IConvertService;
import com.uniquesoft.uidl.transform.ProxyContentProviderMapper;
import edu.fudan.mylang.pf.IObjectFactory;
import java.util.Collection;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("com.fudanmed.platform.core.web.client.warehouse.AllProductTypeContentProviderService")
@Transactional
public class AllProductTypeContentProviderServiceImpl extends BaseContentProviderService implements AllProductTypeContentProviderService {
  @Autowired
  private IConvertService convertService;
  
  @Autowired
  private IObjectFactory entities;
  
  @Autowired
  private ProxyContentProviderMapper<RCProductType> mapper;
  
  public Collection<RCProductTypeProxy> load(final AllProductTypeContentProviderCriteria filter) {
    return com.google.common.collect.Lists
    		.newArrayList(com.google.common.collect.Iterables.transform(
    				doLoad(filter),
    				new com.google.common.base.Function<RCProductType, RCProductTypeProxy>() {
    					@Override
    					public  RCProductTypeProxy apply( RCProductType input) {
    						return input.toProxy();
    					}
    				}));
    
  }
  
  public Collection<RCProductType> doLoad(final AllProductTypeContentProviderCriteria filter) {
    Collection<RCProductType> _xblockexpression = null;
    {
      RCProductTypeCriteria _createQueryCriteria = this.entities.createQueryCriteria(RCProductTypeCriteria.class);
      final Procedure1<RCProductTypeCriteria> _function = new Procedure1<RCProductTypeCriteria>() {
          public void apply(final RCProductTypeCriteria it) {
            String _name = filter.getName();
            it.setInfo(_name);
          }
        };
      RCProductTypeCriteria _doubleArrow = ObjectExtensions.<RCProductTypeCriteria>operator_doubleArrow(_createQueryCriteria, _function);
      final Collection<RCProductType> result = _doubleArrow.list();
      _xblockexpression = (result);
    }
    return _xblockexpression;
  }
}
