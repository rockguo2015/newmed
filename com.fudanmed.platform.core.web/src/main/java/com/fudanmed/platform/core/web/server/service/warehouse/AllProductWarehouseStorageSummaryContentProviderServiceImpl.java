package com.fudanmed.platform.core.web.server.service.warehouse;

import com.fudanmed.platform.core.warehouse.RCProductWarehouseStorageSummary;
import com.fudanmed.platform.core.warehouse.RCProductWarehouseStorageSummaryCriteria;
import com.fudanmed.platform.core.warehouse.RCWarehouse;
import com.fudanmed.platform.core.warehouse.RCWarehouseService;
import com.fudanmed.platform.core.warehouse.proxy.RCWarehouseProxy;
import com.fudanmed.platform.core.web.client.warehouse.AllProductWarehouseStorageSummaryContentProviderService;
import com.fudanmed.platform.core.web.server.service.warehouse.ProductWarehouseStorageSummaryMapper;
import com.fudanmed.platform.core.web.shared.warehouse.AllProductWarehouseStorageSummaryContentProviderCriteria;
import com.fudanmed.platform.core.web.shared.warehouse.UIProductWarehouseStorageSummary;
import com.google.common.base.Function;
import com.google.common.base.Objects;
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

@Service("com.fudanmed.platform.core.web.client.warehouse.AllProductWarehouseStorageSummaryContentProviderService")
@Transactional
public class AllProductWarehouseStorageSummaryContentProviderServiceImpl extends BaseContentProviderService implements AllProductWarehouseStorageSummaryContentProviderService {
  @Autowired
  private IConvertService convertService;
  
  @Autowired
  private IObjectFactory entities;
  
  @Autowired
  private RCWarehouseService warehouseService;
  
  @Autowired
  private ProductWarehouseStorageSummaryMapper mapper;
  
  public Collection<UIProductWarehouseStorageSummary> load(final AllProductWarehouseStorageSummaryContentProviderCriteria filter) {
    return doLoad(filter);
  }
  
  public Collection<UIProductWarehouseStorageSummary> doLoad(final AllProductWarehouseStorageSummaryContentProviderCriteria filter) {
    RCProductWarehouseStorageSummaryCriteria _createPagedCriteria = PagedQueries.createPagedCriteria(filter, RCProductWarehouseStorageSummaryCriteria.class, this.entities);
    final Procedure1<RCProductWarehouseStorageSummaryCriteria> _function = new Procedure1<RCProductWarehouseStorageSummaryCriteria>() {
        public void apply(final RCProductWarehouseStorageSummaryCriteria it) {
          String _name = filter.getName();
          it.setProductInfo(_name);
          RCWarehouseProxy _store = filter.getStore();
          boolean _notEquals = (!Objects.equal(_store, null));
          if (_notEquals) {
            RCWarehouseProxy _store_1 = filter.getStore();
            Long _id = _store_1.getId();
            RCWarehouse _get = AllProductWarehouseStorageSummaryContentProviderServiceImpl.this.entities.<RCWarehouse>get(RCWarehouse.class, _id);
            it.setStore(_get);
          }
        }
      };
    RCProductWarehouseStorageSummaryCriteria _doubleArrow = ObjectExtensions.<RCProductWarehouseStorageSummaryCriteria>operator_doubleArrow(_createPagedCriteria, _function);
    final Function1<RCProductWarehouseStorageSummary,UIProductWarehouseStorageSummary> _function_1 = new Function1<RCProductWarehouseStorageSummary,UIProductWarehouseStorageSummary>() {
        public UIProductWarehouseStorageSummary apply(final RCProductWarehouseStorageSummary it) {
          UIProductWarehouseStorageSummary _transform = AllProductWarehouseStorageSummaryContentProviderServiceImpl.this.mapper.transform(it);
          return _transform;
        }
      };
    IPagedResult<UIProductWarehouseStorageSummary> _listAndTransform = PagedQueries.<UIProductWarehouseStorageSummary, RCProductWarehouseStorageSummary>listAndTransform(_doubleArrow, new Function<RCProductWarehouseStorageSummary,UIProductWarehouseStorageSummary>() {
        public UIProductWarehouseStorageSummary apply(RCProductWarehouseStorageSummary input) {
          return _function_1.apply(input);
        }
    });
    return _listAndTransform;
  }
}
