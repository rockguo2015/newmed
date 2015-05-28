package com.fudanmed.platform.core.web.server.service.warehouse;

import com.fudanmed.platform.core.domain.RCEmployee;
import com.fudanmed.platform.core.domain.RCEmployeeUser;
import com.fudanmed.platform.core.warehouse.RCStockTakingRecord;
import com.fudanmed.platform.core.warehouse.RCWarehouse;
import com.fudanmed.platform.core.warehouse.RCWarehouseService;
import com.fudanmed.platform.core.warehouse.proxy.RCStockTakingRecordProxy;
import com.fudanmed.platform.core.warehouse.proxy.RCWarehouseProxy;
import com.fudanmed.platform.core.web.client.warehouse.CreateOrUpdateStockTakingRecordPresenterService;
import com.fudanmed.platform.core.web.server.service.warehouse.StockTakingRecordMapper;
import com.fudanmed.platform.core.web.shared.warehouse.UIStockTakingRecord;
import com.uniquesoft.gwt.server.service.common.BaseService;
import com.uniquesoft.gwt.shared.SessionTimeOutException;
import com.uniquesoft.gwt.shared.validation.ValidationException;
import edu.fudan.langlab.domain.security.ISystemUserService;
import edu.fudan.langlab.domain.security.User;
import edu.fudan.mylang.pf.IObjectFactory;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("com.fudanmed.platform.core.web.client.warehouse.CreateOrUpdateStockTakingRecordPresenterService")
@Transactional
public class CreateOrUpdateStockTakingRecordPresenterServiceImpl extends BaseService implements CreateOrUpdateStockTakingRecordPresenterService {
  @Autowired
  private IObjectFactory entities;
  
  @Autowired
  private StockTakingRecordMapper mapper;
  
  @Autowired
  private ISystemUserService systemUserService;
  
  @Autowired
  private RCWarehouseService warehouseService;
  
  public UIStockTakingRecord loadValue(final RCStockTakingRecordProxy pvalue) throws SessionTimeOutException, ValidationException {
    RCStockTakingRecord _resolved= null;
    if(pvalue!=null) _resolved=(com.fudanmed.platform.core.warehouse.RCStockTakingRecord)com.uniquesoft.uidl.extensions.ModelObjects.resolve(pvalue, entities);
    
    UIStockTakingRecord _transform = this.mapper.transform( _resolved);
    return _transform;
  }
  
  public void updateValue(final UIStockTakingRecord uivalue) throws SessionTimeOutException, ValidationException {
    RCStockTakingRecord _resolved= null;
    if(uivalue!=null) _resolved=(com.fudanmed.platform.core.warehouse.RCStockTakingRecord)com.uniquesoft.uidl.extensions.ModelObjects.resolve(uivalue, entities);
    
    this.mapper.transform(uivalue,  _resolved);
  }
  
  public RCStockTakingRecordProxy createValue(final UIStockTakingRecord uivalue) throws SessionTimeOutException, ValidationException {
    RCStockTakingRecordProxy _xblockexpression = null;
    {
      final Procedure1<RCStockTakingRecord> _function = new Procedure1<RCStockTakingRecord>() {
          public void apply(final RCStockTakingRecord it) {
            CreateOrUpdateStockTakingRecordPresenterServiceImpl.this.mapper.transform(uivalue, it);
          }
        };
      final RCStockTakingRecord result = this.warehouseService.createStockTakingRecord(_function);
      User _currentUser = this.systemUserService.getCurrentUser();
      RCEmployee _employee = ((RCEmployeeUser) _currentUser).getEmployee();
      result.commit(_employee);
      RCStockTakingRecordProxy _proxy = result.toProxy();
      _xblockexpression = (_proxy);
    }
    return _xblockexpression;
  }
  
  public RCWarehouseProxy getHostWarehouse() throws SessionTimeOutException, ValidationException {
    RCWarehouse _majorWarehouse = this.warehouseService.getMajorWarehouse();
    RCWarehouseProxy _proxy = _majorWarehouse.toProxy();
    return _proxy;
  }
  
  public String generatePrintContents(final RCStockTakingRecordProxy record) throws SessionTimeOutException, ValidationException {
    return null;
  }
}
