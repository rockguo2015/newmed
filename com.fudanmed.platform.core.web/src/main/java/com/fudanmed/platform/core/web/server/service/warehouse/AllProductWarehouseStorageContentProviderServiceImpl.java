package com.fudanmed.platform.core.web.server.service.warehouse;

import com.fudanmed.platform.core.warehouse.RCProductWarehouseStorage;
import com.fudanmed.platform.core.warehouse.RCProductWarehouseStorageCriteria;
import com.fudanmed.platform.core.warehouse.RCWarehouseService;
import com.fudanmed.platform.core.web.client.warehouse.AllProductWarehouseStorageContentProviderService;
import com.fudanmed.platform.core.web.server.service.warehouse.ProductWarehouseStorageMapper;
import com.fudanmed.platform.core.web.shared.warehouse.AllProductWarehouseStorageContentProviderCriteria;
import com.fudanmed.platform.core.web.shared.warehouse.UIProductWarehouseStorage;
import com.google.common.base.Function;
import com.uniquesoft.gwt.server.common.pager.PagedQueries;
import com.uniquesoft.gwt.shared.common.pager.IPagedResult;
import com.uniquesoft.uidl.contentprovider.BaseContentProviderService;
import com.uniquesoft.uidl.transform.IConvertService;
import edu.fudan.mylang.pf.IObjectFactory;
import java.util.Collection;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("com.fudanmed.platform.core.web.client.warehouse.AllProductWarehouseStorageContentProviderService")
@Transactional
public class AllProductWarehouseStorageContentProviderServiceImpl extends BaseContentProviderService implements AllProductWarehouseStorageContentProviderService {
  @Autowired
  private IConvertService convertService;
  
  @Autowired
  private IObjectFactory entities;
  
  @Autowired
  private RCWarehouseService warehouseService;
  
  @Autowired
  private ProductWarehouseStorageMapper mapper;
  
  public Collection<UIProductWarehouseStorage> load(final AllProductWarehouseStorageContentProviderCriteria filter) {
    return doLoad(filter);
  }
  
  public Collection<UIProductWarehouseStorage> doLoad(final AllProductWarehouseStorageContentProviderCriteria filter) {
    RCProductWarehouseStorageCriteria _createPagedCriteria = PagedQueries.createPagedCriteria(filter, RCProductWarehouseStorageCriteria.class, this.entities);
    final Procedure1<RCProductWarehouseStorageCriteria> _function = new Procedure1<RCProductWarehouseStorageCriteria>() {
        public void apply(final RCProductWarehouseStorageCriteria it) {
          String _name = filter.getName();
          it.setProductInfo(_name);
        }
      };
    RCProductWarehouseStorageCriteria _doubleArrow = ObjectExtensions.<RCProductWarehouseStorageCriteria>operator_doubleArrow(_createPagedCriteria, _function);
    final Function1<RCProductWarehouseStorage,UIProductWarehouseStorage> _function_1 = new Function1<RCProductWarehouseStorage,UIProductWarehouseStorage>() {
        public UIProductWarehouseStorage apply(final RCProductWarehouseStorage it) {
          UIProductWarehouseStorage _transform = AllProductWarehouseStorageContentProviderServiceImpl.this.mapper.transform(it);
          return _transform;
        }
      };
    IPagedResult<UIProductWarehouseStorage> _listAndTransform = PagedQueries.<UIProductWarehouseStorage, RCProductWarehouseStorage>listAndTransform(_doubleArrow, new Function<RCProductWarehouseStorage,UIProductWarehouseStorage>() {
        public UIProductWarehouseStorage apply(RCProductWarehouseStorage input) {
          return _function_1.apply(input);
        }
    });
    return _listAndTransform;
  }
}
