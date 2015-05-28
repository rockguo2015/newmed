package com.fudanmed.platform.core.web.server.service.warehouse;

import com.fudanmed.platform.core.warehouse.RCProductWarehouseStorage;
import com.fudanmed.platform.core.warehouse.RCProductWarehouseStorageSummary;
import com.fudanmed.platform.core.warehouse.proxy.RCProductWarehouseStorageSummaryProxy;
import com.fudanmed.platform.core.web.client.warehouse.ProductWarehouseStorageListPresenterService;
import com.fudanmed.platform.core.web.server.service.warehouse.ProductWarehouseStorageMapper;
import com.fudanmed.platform.core.web.shared.warehouse.UIProductWarehouseStorage;
import com.uniquesoft.gwt.server.service.common.BaseService;
import com.uniquesoft.gwt.shared.SessionTimeOutException;
import com.uniquesoft.gwt.shared.extensions.IterableExtensions2;
import com.uniquesoft.gwt.shared.validation.ValidationException;
import edu.fudan.mylang.pf.IObjectFactory;
import java.util.Collection;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("com.fudanmed.platform.core.web.client.warehouse.ProductWarehouseStorageListPresenterService")
@Transactional
public class ProductWarehouseStorageListPresenterServiceImpl extends BaseService implements ProductWarehouseStorageListPresenterService {
  @Autowired
  private IObjectFactory entities;
  
  @Autowired
  private ProductWarehouseStorageMapper mapper;
  
  public Collection<UIProductWarehouseStorage> loadProductWarehouseStorageList(final RCProductWarehouseStorageSummaryProxy context) throws SessionTimeOutException, ValidationException {
    RCProductWarehouseStorageSummary _resolved= null;
    if(context!=null) _resolved=(com.fudanmed.platform.core.warehouse.RCProductWarehouseStorageSummary)com.uniquesoft.uidl.extensions.ModelObjects.resolve(context, entities);
    
    Collection<RCProductWarehouseStorage> _productWarehouseStorages =  _resolved.getProductWarehouseStorages();
    final Function1<RCProductWarehouseStorage,UIProductWarehouseStorage> _function = new Function1<RCProductWarehouseStorage,UIProductWarehouseStorage>() {
        public UIProductWarehouseStorage apply(final RCProductWarehouseStorage it) {
          UIProductWarehouseStorage _transform = ProductWarehouseStorageListPresenterServiceImpl.this.mapper.transform(it);
          return _transform;
        }
      };
    Iterable<UIProductWarehouseStorage> _map = IterableExtensions.<RCProductWarehouseStorage, UIProductWarehouseStorage>map(_productWarehouseStorages, _function);
    Collection<UIProductWarehouseStorage> _unlazy = IterableExtensions2.<UIProductWarehouseStorage>unlazy(_map);
    return _unlazy;
  }
}
