package com.fudanmed.platform.core.web.server.service.warehouse;

import com.fudanmed.platform.core.common.RCSystemParameter;
import com.fudanmed.platform.core.common.RCSystemParameterService;
import com.fudanmed.platform.core.domain.RCEmployee;
import com.fudanmed.platform.core.domain.RCEmployeeUser;
import com.fudanmed.platform.core.domain.proxy.RCEmployeeProxy;
import com.fudanmed.platform.core.warehouse.RCInStockRecord;
import com.fudanmed.platform.core.warehouse.RCProductSpecification;
import com.fudanmed.platform.core.warehouse.RCProductSpecificationDAO;
import com.fudanmed.platform.core.warehouse.RCWarehouse;
import com.fudanmed.platform.core.warehouse.RCWarehouseService;
import com.fudanmed.platform.core.warehouse.proxy.RCInStockRecordProxy;
import com.fudanmed.platform.core.warehouse.proxy.RCWarehouseProxy;
import com.fudanmed.platform.core.web.client.warehouse.CreateOrUpdateInStockRecordPresenterService;
import com.fudanmed.platform.core.web.server.service.template.InStockTemplate;
import com.fudanmed.platform.core.web.server.service.warehouse.InStockRecordItemMapper;
import com.fudanmed.platform.core.web.server.service.warehouse.InStockRecordMapper;
import com.fudanmed.platform.core.web.server.service.warehouse.ProductSpecificationMapper;
import com.fudanmed.platform.core.web.shared.warehouse.CreateOrUpdateInStockRecordInitData;
import com.fudanmed.platform.core.web.shared.warehouse.UIInStockRecord;
import com.fudanmed.platform.core.web.shared.warehouse.UIProductSpecification;
import com.uniquesoft.gwt.server.service.common.BaseService;
import com.uniquesoft.gwt.shared.SessionTimeOutException;
import com.uniquesoft.gwt.shared.validation.ValidationException;
import edu.fudan.langlab.domain.organization.Party;
import edu.fudan.langlab.domain.security.ISystemUserService;
import edu.fudan.langlab.domain.security.User;
import edu.fudan.mylang.pf.IObjectFactory;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("com.fudanmed.platform.core.web.client.warehouse.CreateOrUpdateInStockRecordPresenterService")
@Transactional
public class CreateOrUpdateInStockRecordPresenterServiceImpl extends BaseService implements CreateOrUpdateInStockRecordPresenterService {
  @Autowired
  private IObjectFactory entities;
  
  @Autowired
  private InStockRecordMapper mapper;
  
  @Autowired
  private ISystemUserService systemUserService;
  
  @Autowired
  private RCWarehouseService warehouseService;
  
  @Autowired
  private RCSystemParameterService systemParameter;
  
  @Autowired
  private InStockRecordItemMapper itemMapper;
  
  @Autowired
  private RCProductSpecificationDAO productSpecificationDAO;
  
  @Autowired
  private ProductSpecificationMapper productSpecificationMapper;
  
  public UIInStockRecord loadValue(final RCInStockRecordProxy pvalue) throws SessionTimeOutException, ValidationException {
    RCInStockRecord _resolved= null;
    if(pvalue!=null) _resolved=(com.fudanmed.platform.core.warehouse.RCInStockRecord)com.uniquesoft.uidl.extensions.ModelObjects.resolve(pvalue, entities);
    
    UIInStockRecord _transform = this.mapper.transform( _resolved);
    return _transform;
  }
  
  public RCInStockRecordProxy updateValue(final UIInStockRecord uivalue) throws SessionTimeOutException, ValidationException {
    RCInStockRecordProxy _xblockexpression = null;
    {
      RCInStockRecord _resolved= null;
      if(uivalue!=null) _resolved=(com.fudanmed.platform.core.warehouse.RCInStockRecord)com.uniquesoft.uidl.extensions.ModelObjects.resolve(uivalue, entities);
      
      final RCInStockRecord value =  _resolved;
      this.mapper.transform(uivalue, value);
      Boolean _saveOnly = uivalue.getSaveOnly();
      boolean _not = (!_saveOnly);
      if (_not) {
        User _currentUser = this.systemUserService.getCurrentUser();
        RCEmployee _employee = ((RCEmployeeUser) _currentUser).getEmployee();
        value.commit(_employee);
      }
      RCInStockRecordProxy _proxy = value.toProxy();
      _xblockexpression = (_proxy);
    }
    return _xblockexpression;
  }
  
  public UIProductSpecification getProductSpecByProductSid(final String productSid) throws SessionTimeOutException, ValidationException {
    RCProductSpecification _findBySid = this.productSpecificationDAO.findBySid(productSid);
    UIProductSpecification _transform = this.productSpecificationMapper.transform(_findBySid);
    return _transform;
  }
  
  public RCInStockRecordProxy createValue(final UIInStockRecord uivalue) throws SessionTimeOutException, ValidationException {
    RCInStockRecordProxy _xblockexpression = null;
    {
      RCInStockRecord value = this.entities.<RCInStockRecord>create(RCInStockRecord.class);
      this.mapper.transform(uivalue, value);
      Boolean _saveOnly = uivalue.getSaveOnly();
      boolean _not = (!_saveOnly);
      if (_not) {
        User _currentUser = this.systemUserService.getCurrentUser();
        RCEmployee _employee = ((RCEmployeeUser) _currentUser).getEmployee();
        value.commit(_employee);
      }
      RCInStockRecordProxy _proxy = value.toProxy();
      _xblockexpression = (_proxy);
    }
    return _xblockexpression;
  }
  
  public CreateOrUpdateInStockRecordInitData loadCreateOrUpdateInStockRecordInitData() throws SessionTimeOutException, ValidationException {
    CreateOrUpdateInStockRecordInitData _createOrUpdateInStockRecordInitData = new CreateOrUpdateInStockRecordInitData();
    final Procedure1<CreateOrUpdateInStockRecordInitData> _function = new Procedure1<CreateOrUpdateInStockRecordInitData>() {
        public void apply(final CreateOrUpdateInStockRecordInitData it) {
          RCWarehouse majorWarehouse = CreateOrUpdateInStockRecordPresenterServiceImpl.this.warehouseService.getMajorWarehouse();
          RCWarehouseProxy _proxy = majorWarehouse.toProxy();
          it.setStore(_proxy);
          Party _currentUserAsParty = CreateOrUpdateInStockRecordPresenterServiceImpl.this.systemUserService.getCurrentUserAsParty();
          RCEmployeeProxy _proxy_1 = ((RCEmployee) _currentUserAsParty).toProxy();
          it.setCurrentUser(_proxy_1);
        }
      };
    CreateOrUpdateInStockRecordInitData _doubleArrow = ObjectExtensions.<CreateOrUpdateInStockRecordInitData>operator_doubleArrow(_createOrUpdateInStockRecordInitData, _function);
    return _doubleArrow;
  }
  
  public RCEmployeeProxy loadStoreManager(final RCWarehouseProxy store) throws SessionTimeOutException, ValidationException {
    Party _currentUserAsParty = this.systemUserService.getCurrentUserAsParty();
    RCEmployeeProxy _proxy = ((RCEmployee) _currentUserAsParty).toProxy();
    return _proxy;
  }
  
  public String generatePrintContent(final RCInStockRecordProxy inStockRecord) throws SessionTimeOutException, ValidationException {
    RCInStockRecord _resolved= null;
    if(inStockRecord!=null) _resolved=(com.fudanmed.platform.core.warehouse.RCInStockRecord)com.uniquesoft.uidl.extensions.ModelObjects.resolve(inStockRecord, entities);
    
    RCSystemParameter _systemParameter = this.systemParameter.getSystemParameter();
    String _template = InStockTemplate.template( _resolved, _systemParameter, this.itemMapper);
    return _template;
  }
}
