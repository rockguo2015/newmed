package com.fudanmed.platform.core.web.server.service.warehouse;

import com.fudanmed.platform.core.warehouse.RCWarehouse;
import com.fudanmed.platform.core.warehouse.proxy.RCWarehouseProxy;
import com.fudanmed.platform.core.web.client.warehouse.WarehouseManagementPresenterService;
import com.fudanmed.platform.core.web.server.service.warehouse.WarehouseMapper;
import com.fudanmed.platform.core.web.shared.warehouse.UIWarehouse;
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

@Service("com.fudanmed.platform.core.web.client.warehouse.WarehouseManagementPresenterService")
@Transactional
public class WarehouseManagementPresenterServiceImpl extends BaseService implements WarehouseManagementPresenterService {
  @Autowired
  private IObjectFactory entities;
  
  @Autowired
  private WarehouseMapper mapper;
  
  public Collection<UIWarehouse> loadWarehouseList() throws SessionTimeOutException, ValidationException {
    Collection<RCWarehouse> _all = this.entities.<RCWarehouse>all(RCWarehouse.class);
    final Function1<RCWarehouse,UIWarehouse> _function = new Function1<RCWarehouse,UIWarehouse>() {
        public UIWarehouse apply(final RCWarehouse it) {
          UIWarehouse _transform = WarehouseManagementPresenterServiceImpl.this.mapper.transform(it);
          return _transform;
        }
      };
    Iterable<UIWarehouse> _map = IterableExtensions.<RCWarehouse, UIWarehouse>map(_all, _function);
    Collection<UIWarehouse> _unlazy = IterableExtensions2.<UIWarehouse>unlazy(_map);
    return _unlazy;
  }
  
  public void deleteWarehouse(final RCWarehouseProxy value) throws SessionTimeOutException, ValidationException {
    RCWarehouse _resolved= null;
    if(value!=null) _resolved=(com.fudanmed.platform.core.warehouse.RCWarehouse)com.uniquesoft.uidl.extensions.ModelObjects.resolve(value, entities);
    
    this.entities.delete( _resolved);
  }
}
