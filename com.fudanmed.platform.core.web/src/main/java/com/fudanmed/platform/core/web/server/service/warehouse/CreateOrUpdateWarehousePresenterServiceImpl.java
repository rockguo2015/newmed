package com.fudanmed.platform.core.web.server.service.warehouse;

import com.fudanmed.platform.core.warehouse.RCWarehouse;
import com.fudanmed.platform.core.warehouse.proxy.RCWarehouseProxy;
import com.fudanmed.platform.core.web.client.warehouse.CreateOrUpdateWarehousePresenterService;
import com.fudanmed.platform.core.web.server.service.warehouse.WarehouseMapper;
import com.fudanmed.platform.core.web.shared.warehouse.UIWarehouse;
import com.uniquesoft.gwt.server.service.common.BaseService;
import com.uniquesoft.gwt.shared.SessionTimeOutException;
import com.uniquesoft.gwt.shared.validation.ValidationException;
import edu.fudan.mylang.pf.IObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("com.fudanmed.platform.core.web.client.warehouse.CreateOrUpdateWarehousePresenterService")
@Transactional
public class CreateOrUpdateWarehousePresenterServiceImpl extends BaseService implements CreateOrUpdateWarehousePresenterService {
  @Autowired
  private IObjectFactory entities;
  
  @Autowired
  private WarehouseMapper mapper;
  
  public UIWarehouse loadValue(final RCWarehouseProxy pvalue) throws SessionTimeOutException, ValidationException {
    RCWarehouse _resolved= null;
    if(pvalue!=null) _resolved=(com.fudanmed.platform.core.warehouse.RCWarehouse)com.uniquesoft.uidl.extensions.ModelObjects.resolve(pvalue, entities);
    
    UIWarehouse _transform = this.mapper.transform( _resolved);
    return _transform;
  }
  
  public void updateValue(final UIWarehouse uivalue) throws SessionTimeOutException, ValidationException {
    RCWarehouse _resolved= null;
    if(uivalue!=null) _resolved=(com.fudanmed.platform.core.warehouse.RCWarehouse)com.uniquesoft.uidl.extensions.ModelObjects.resolve(uivalue, entities);
    
    this.mapper.transform(uivalue,  _resolved);
  }
  
  public void createValue(final UIWarehouse uivalue) throws SessionTimeOutException, ValidationException {
    RCWarehouse value = this.entities.<RCWarehouse>create(RCWarehouse.class);
    this.mapper.transform(uivalue, value);
  }
}
