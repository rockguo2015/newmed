package com.fudanmed.platform.core.web.server.service.warehouse;

import com.fudanmed.platform.core.common.RCSystemParameter;
import com.fudanmed.platform.core.common.RCSystemParameterService;
import com.fudanmed.platform.core.domain.RCEmployee;
import com.fudanmed.platform.core.domain.RCEmployeeUser;
import com.fudanmed.platform.core.domain.proxy.RCEmployeeProxy;
import com.fudanmed.platform.core.warehouse.RCProductSpecification;
import com.fudanmed.platform.core.warehouse.RCProductSpecificationDAO;
import com.fudanmed.platform.core.warehouse.RCProductWarehouseStorageSummary;
import com.fudanmed.platform.core.warehouse.RCProductWarehouseStorageSummaryCriteria;
import com.fudanmed.platform.core.warehouse.RCTransferRecord;
import com.fudanmed.platform.core.warehouse.RCWarehouse;
import com.fudanmed.platform.core.warehouse.RCWarehouseService;
import com.fudanmed.platform.core.warehouse.proxy.RCTransferRecordProxy;
import com.fudanmed.platform.core.warehouse.proxy.RCWarehouseProxy;
import com.fudanmed.platform.core.web.client.warehouse.CreateOrUpdateTransferRecordPresenterService;
import com.fudanmed.platform.core.web.server.service.template.TransferTemplate;
import com.fudanmed.platform.core.web.server.service.warehouse.ProductWarehouseStorageSummaryMapper;
import com.fudanmed.platform.core.web.server.service.warehouse.TransferRecordItemMapper;
import com.fudanmed.platform.core.web.server.service.warehouse.TransferRecordMapper;
import com.fudanmed.platform.core.web.shared.warehouse.UIProductWarehouseStorageSummary;
import com.fudanmed.platform.core.web.shared.warehouse.UITransferRecord;
import com.google.common.base.Objects;
import com.uniquesoft.gwt.server.service.common.BaseService;
import com.uniquesoft.gwt.shared.SessionTimeOutException;
import com.uniquesoft.gwt.shared.validation.ValidationException;
import edu.fudan.langlab.domain.organization.Party;
import edu.fudan.langlab.domain.security.ISystemUserService;
import edu.fudan.langlab.domain.security.User;
import edu.fudan.mylang.pf.IObjectFactory;
import java.util.Collection;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("com.fudanmed.platform.core.web.client.warehouse.CreateOrUpdateTransferRecordPresenterService")
@Transactional
public class CreateOrUpdateTransferRecordPresenterServiceImpl extends BaseService implements CreateOrUpdateTransferRecordPresenterService {
  @Autowired
  private IObjectFactory entities;
  
  @Autowired
  private TransferRecordMapper mapper;
  
  @Autowired
  private ISystemUserService systemUserService;
  
  @Autowired
  private RCWarehouseService warehouseService;
  
  @Autowired
  private RCSystemParameterService systemParameter;
  
  @Autowired
  private TransferRecordItemMapper itemMapper;
  
  @Autowired
  private RCProductSpecificationDAO productSpecificationDAO;
  
  @Autowired
  private ProductWarehouseStorageSummaryMapper productWarehouseStorageSummaryMapper;
  
  public UIProductWarehouseStorageSummary getProductSummaryByProductSid(final String sid, final RCWarehouseProxy store) throws SessionTimeOutException, ValidationException {
    UIProductWarehouseStorageSummary _xblockexpression = null;
    {
      final RCProductSpecification productSpec = this.productSpecificationDAO.findBySid(sid);
      UIProductWarehouseStorageSummary _xifexpression = null;
      boolean _notEquals = (!Objects.equal(productSpec, null));
      if (_notEquals) {
        RCProductWarehouseStorageSummaryCriteria _createQueryCriteria = this.entities.createQueryCriteria(RCProductWarehouseStorageSummaryCriteria.class);
        final Procedure1<RCProductWarehouseStorageSummaryCriteria> _function = new Procedure1<RCProductWarehouseStorageSummaryCriteria>() {
            public void apply(final RCProductWarehouseStorageSummaryCriteria it) {
              it.setProductSpec(productSpec);
              RCWarehouse _resolved= null;
              if(store!=null) _resolved=(com.fudanmed.platform.core.warehouse.RCWarehouse)com.uniquesoft.uidl.extensions.ModelObjects.resolve(store, entities);
              
              it.setStore( _resolved);
            }
          };
        RCProductWarehouseStorageSummaryCriteria _doubleArrow = ObjectExtensions.<RCProductWarehouseStorageSummaryCriteria>operator_doubleArrow(_createQueryCriteria, _function);
        Collection<RCProductWarehouseStorageSummary> _list = _doubleArrow.list();
        RCProductWarehouseStorageSummary _head = IterableExtensions.<RCProductWarehouseStorageSummary>head(_list);
        UIProductWarehouseStorageSummary _transform = this.productWarehouseStorageSummaryMapper.transform(_head);
        _xifexpression = _transform;
      }
      _xblockexpression = (_xifexpression);
    }
    return _xblockexpression;
  }
  
  public UITransferRecord loadValue(final RCTransferRecordProxy pvalue) throws SessionTimeOutException, ValidationException {
    RCTransferRecord _resolved= null;
    if(pvalue!=null) _resolved=(com.fudanmed.platform.core.warehouse.RCTransferRecord)com.uniquesoft.uidl.extensions.ModelObjects.resolve(pvalue, entities);
    
    UITransferRecord _transform = this.mapper.transform( _resolved);
    return _transform;
  }
  
  public void updateValue(final UITransferRecord uivalue) throws SessionTimeOutException, ValidationException {
    RCTransferRecord _resolved= null;
    if(uivalue!=null) _resolved=(com.fudanmed.platform.core.warehouse.RCTransferRecord)com.uniquesoft.uidl.extensions.ModelObjects.resolve(uivalue, entities);
    
    this.mapper.transform(uivalue,  _resolved);
  }
  
  public RCTransferRecordProxy createValue(final UITransferRecord uivalue) throws SessionTimeOutException, ValidationException {
    RCTransferRecordProxy _xblockexpression = null;
    {
      final Procedure1<RCTransferRecord> _function = new Procedure1<RCTransferRecord>() {
          public void apply(final RCTransferRecord it) {
            CreateOrUpdateTransferRecordPresenterServiceImpl.this.mapper.transform(uivalue, it);
          }
        };
      final RCTransferRecord result = this.warehouseService.createTransferRecord(_function);
      User _currentUser = this.systemUserService.getCurrentUser();
      RCEmployee _employee = ((RCEmployeeUser) _currentUser).getEmployee();
      result.commit(_employee);
      RCTransferRecordProxy _proxy = result.toProxy();
      _xblockexpression = (_proxy);
    }
    return _xblockexpression;
  }
  
  public RCEmployeeProxy getCurrentUser() throws SessionTimeOutException, ValidationException {
    Party _currentUserAsParty = this.systemUserService.getCurrentUserAsParty();
    RCEmployeeProxy _proxy = ((RCEmployee) _currentUserAsParty).toProxy();
    return _proxy;
  }
  
  public String generatePrintContents(final RCTransferRecordProxy record) throws SessionTimeOutException, ValidationException {
    RCTransferRecord _resolved= null;
    if(record!=null) _resolved=(com.fudanmed.platform.core.warehouse.RCTransferRecord)com.uniquesoft.uidl.extensions.ModelObjects.resolve(record, entities);
    
    RCSystemParameter _systemParameter = this.systemParameter.getSystemParameter();
    String _template = TransferTemplate.template( _resolved, _systemParameter, this.itemMapper);
    return _template;
  }
}
