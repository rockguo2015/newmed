package com.fudanmed.platform.core.web.server.service.warehouse;

import com.fudanmed.platform.core.domain.RCWorkItemTask;
import com.fudanmed.platform.core.domain.proxy.RCWorkItemTaskProxy;
import com.fudanmed.platform.core.warehouse.RCProductSpecificationSummary;
import com.fudanmed.platform.core.warehouse.RCWarehouseService;
import com.fudanmed.platform.core.warehouse.RCWorkItemStorage;
import com.fudanmed.platform.core.web.client.warehouse.AllWorkItemProductSpecSummaryContentProviderService;
import com.fudanmed.platform.core.web.server.service.warehouse.ProductSpecificationSummaryMapper;
import com.fudanmed.platform.core.web.shared.warehouse.AllWorkItemProductSpecSummaryContentProviderCriteria;
import com.fudanmed.platform.core.web.shared.warehouse.UIProductSpecificationSummary;
import com.uniquesoft.gwt.shared.extensions.IterableExtensions2;
import com.uniquesoft.uidl.contentprovider.BaseContentProviderService;
import com.uniquesoft.uidl.transform.IConvertService;
import edu.fudan.mylang.pf.IObjectFactory;
import java.util.Collection;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("com.fudanmed.platform.core.web.client.warehouse.AllWorkItemProductSpecSummaryContentProviderService")
@Transactional
public class AllWorkItemProductSpecSummaryContentProviderServiceImpl extends BaseContentProviderService implements AllWorkItemProductSpecSummaryContentProviderService {
  @Autowired
  private IConvertService convertService;
  
  @Autowired
  private IObjectFactory entities;
  
  @Autowired
  private RCWarehouseService warehouseService;
  
  @Autowired
  private ProductSpecificationSummaryMapper mapper;
  
  public Collection<UIProductSpecificationSummary> load(final AllWorkItemProductSpecSummaryContentProviderCriteria filter) {
    return doLoad(filter);
  }
  
  public Collection<UIProductSpecificationSummary> doLoad(final AllWorkItemProductSpecSummaryContentProviderCriteria filter) {
    RCWorkItemTaskProxy _workItem = filter.getWorkItem();
    Long _id = _workItem.getId();
    RCWorkItemTask _get = this.entities.<RCWorkItemTask>get(RCWorkItemTask.class, _id);
    Collection<RCWorkItemStorage> _storage = _get.getStorage();
    Collection<RCProductSpecificationSummary> _productSpecificationSummary = this.warehouseService.getProductSpecificationSummary(_storage);
    final Function1<RCProductSpecificationSummary,UIProductSpecificationSummary> _function = new Function1<RCProductSpecificationSummary,UIProductSpecificationSummary>() {
        public UIProductSpecificationSummary apply(final RCProductSpecificationSummary it) {
          UIProductSpecificationSummary _transform = AllWorkItemProductSpecSummaryContentProviderServiceImpl.this.mapper.transform(it);
          return _transform;
        }
      };
    Iterable<UIProductSpecificationSummary> _map = IterableExtensions.<RCProductSpecificationSummary, UIProductSpecificationSummary>map(_productSpecificationSummary, _function);
    Collection<UIProductSpecificationSummary> _unlazy = IterableExtensions2.<UIProductSpecificationSummary>unlazy(_map);
    return _unlazy;
  }
}
