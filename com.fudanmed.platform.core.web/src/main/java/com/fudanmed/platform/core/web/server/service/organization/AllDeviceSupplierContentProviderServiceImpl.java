package com.fudanmed.platform.core.web.server.service.organization;

import com.fudanmed.platform.core.domain.RCSupplier;
import com.fudanmed.platform.core.domain.RCSupplierCriteria;
import com.fudanmed.platform.core.domain.RCSupplierType;
import com.fudanmed.platform.core.domain.proxy.RCSupplierProxy;
import com.fudanmed.platform.core.web.client.organization.AllDeviceSupplierContentProviderService;
import com.fudanmed.platform.core.web.shared.organization.AllDeviceSupplierContentProviderCriteria;
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

@Service("com.fudanmed.platform.core.web.client.organization.AllDeviceSupplierContentProviderService")
@Transactional
public class AllDeviceSupplierContentProviderServiceImpl extends BaseContentProviderService implements AllDeviceSupplierContentProviderService {
  @Autowired
  private IConvertService convertService;
  
  @Autowired
  private IObjectFactory entities;
  
  @Autowired
  private ProxyContentProviderMapper<RCSupplier> mapper;
  
  public Collection<RCSupplierProxy> load(final AllDeviceSupplierContentProviderCriteria filter) {
    return com.google.common.collect.Lists
    		.newArrayList(com.google.common.collect.Iterables.transform(
    				doLoad(filter),
    				new com.google.common.base.Function<RCSupplier, RCSupplierProxy>() {
    					@Override
    					public  RCSupplierProxy apply( RCSupplier input) {
    						return input.toProxy();
    					}
    				}));
    
  }
  
  public Collection<RCSupplier> doLoad(final AllDeviceSupplierContentProviderCriteria filter) {
    RCSupplierCriteria _createQueryCriteria = this.entities.createQueryCriteria(RCSupplierCriteria.class);
    final Procedure1<RCSupplierCriteria> _function = new Procedure1<RCSupplierCriteria>() {
        public void apply(final RCSupplierCriteria it) {
          String _name = filter.getName();
          it.setInfo(_name);
          it.setType(RCSupplierType.maintenanceProvider);
        }
      };
    RCSupplierCriteria _doubleArrow = ObjectExtensions.<RCSupplierCriteria>operator_doubleArrow(_createQueryCriteria, _function);
    Collection<RCSupplier> _list = _doubleArrow.list();
    return _list;
  }
}
