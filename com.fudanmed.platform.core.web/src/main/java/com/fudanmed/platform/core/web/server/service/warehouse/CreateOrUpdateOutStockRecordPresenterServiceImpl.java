package com.fudanmed.platform.core.web.server.service.warehouse;

import com.fudanmed.platform.core.common.RCSystemParameter;
import com.fudanmed.platform.core.common.RCSystemParameterService;
import com.fudanmed.platform.core.domain.RCEmployee;
import com.fudanmed.platform.core.domain.RCEmployeeUser;
import com.fudanmed.platform.core.domain.RCMaintenanceTeam;
import com.fudanmed.platform.core.domain.RCOrganization;
import com.fudanmed.platform.core.domain.proxy.RCEmployeeProxy;
import com.fudanmed.platform.core.domain.proxy.RCMaintenanceTeamProxy;
import com.fudanmed.platform.core.domain.proxy.RCOrganizationProxy;
import com.fudanmed.platform.core.warehouse.RCOutStockRecord;
import com.fudanmed.platform.core.warehouse.RCProductSpecification;
import com.fudanmed.platform.core.warehouse.RCProductSpecificationDAO;
import com.fudanmed.platform.core.warehouse.RCProductWarehouseStorageSummary;
import com.fudanmed.platform.core.warehouse.RCProductWarehouseStorageSummaryCriteria;
import com.fudanmed.platform.core.warehouse.RCWarehouse;
import com.fudanmed.platform.core.warehouse.RCWarehouseService;
import com.fudanmed.platform.core.warehouse.proxy.RCOutStockRecordProxy;
import com.fudanmed.platform.core.warehouse.proxy.RCWarehouseProxy;
import com.fudanmed.platform.core.web.client.warehouse.CreateOrUpdateOutStockRecordPresenterService;
import com.fudanmed.platform.core.web.server.service.template.OutStockTemplate;
import com.fudanmed.platform.core.web.server.service.warehouse.OutStockRecordItemMapper;
import com.fudanmed.platform.core.web.server.service.warehouse.OutStockRecordMapper;
import com.fudanmed.platform.core.web.server.service.warehouse.ProductWarehouseStorageSummaryMapper;
import com.fudanmed.platform.core.web.shared.warehouse.UIOutStockRecord;
import com.fudanmed.platform.core.web.shared.warehouse.UIProductWarehouseStorageSummary;
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

@Service("com.fudanmed.platform.core.web.client.warehouse.CreateOrUpdateOutStockRecordPresenterService")
@Transactional
public class CreateOrUpdateOutStockRecordPresenterServiceImpl extends BaseService implements CreateOrUpdateOutStockRecordPresenterService {
  @Autowired
  private IObjectFactory entities;
  
  @Autowired
  private OutStockRecordMapper mapper;
  
  @Autowired
  private ISystemUserService systemUserService;
  
  @Autowired
  private RCWarehouseService warehouseService;
  
  @Autowired
  private RCSystemParameterService systemParameter;
  
  @Autowired
  private OutStockRecordItemMapper itemMapper;
  
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
  
  public UIOutStockRecord loadValue(final RCOutStockRecordProxy pvalue) throws SessionTimeOutException, ValidationException {
    RCOutStockRecord _resolved= null;
    if(pvalue!=null) _resolved=(com.fudanmed.platform.core.warehouse.RCOutStockRecord)com.uniquesoft.uidl.extensions.ModelObjects.resolve(pvalue, entities);
    
    UIOutStockRecord _transform = this.mapper.transform( _resolved);
    return _transform;
  }
  
  public void updateValue(final UIOutStockRecord uivalue) throws SessionTimeOutException, ValidationException {
    RCOutStockRecord _resolved= null;
    if(uivalue!=null) _resolved=(com.fudanmed.platform.core.warehouse.RCOutStockRecord)com.uniquesoft.uidl.extensions.ModelObjects.resolve(uivalue, entities);
    
    final RCOutStockRecord result =  _resolved;
    this.mapper.transform(uivalue, result);
    User _currentUser = this.systemUserService.getCurrentUser();
    RCEmployee _employee = ((RCEmployeeUser) _currentUser).getEmployee();
    result.commit(_employee);
  }
  
  public RCOrganizationProxy loadOrganization(final RCMaintenanceTeamProxy team) throws SessionTimeOutException, ValidationException {
    RCMaintenanceTeam _resolved= null;
    if(team!=null) _resolved=(com.fudanmed.platform.core.domain.RCMaintenanceTeam)com.uniquesoft.uidl.extensions.ModelObjects.resolve(team, entities);
    
    RCOrganization _organization =  _resolved.getOrganization();
    RCOrganizationProxy _proxy = _organization.toProxy();
    return _proxy;
  }
  
  public RCOutStockRecordProxy createValue(final UIOutStockRecord uivalue) throws SessionTimeOutException, ValidationException {
    RCOutStockRecordProxy _xblockexpression = null;
    {
      final Procedure1<RCOutStockRecord> _function = new Procedure1<RCOutStockRecord>() {
          public void apply(final RCOutStockRecord it) {
            CreateOrUpdateOutStockRecordPresenterServiceImpl.this.mapper.transform(uivalue, it);
          }
        };
      final RCOutStockRecord result = this.warehouseService.createOutStockRecord(_function);
      User _currentUser = this.systemUserService.getCurrentUser();
      RCEmployee _employee = ((RCEmployeeUser) _currentUser).getEmployee();
      result.commit(_employee);
      RCOutStockRecordProxy _proxy = result.toProxy();
      _xblockexpression = (_proxy);
    }
    return _xblockexpression;
  }
  
  public RCWarehouseProxy getHostWarehouse() throws SessionTimeOutException, ValidationException {
    RCWarehouse _majorWarehouse = this.warehouseService.getMajorWarehouse();
    RCWarehouseProxy _proxy = _majorWarehouse.toProxy();
    return _proxy;
  }
  
  public RCEmployeeProxy loadCurrentUser() throws SessionTimeOutException, ValidationException {
    Party _currentUserAsParty = this.systemUserService.getCurrentUserAsParty();
    RCEmployeeProxy _proxy = ((RCEmployee) _currentUserAsParty).toProxy();
    return _proxy;
  }
  
  public String generatePrintContents(final RCOutStockRecordProxy record) throws SessionTimeOutException, ValidationException {
    RCOutStockRecord _resolved= null;
    if(record!=null) _resolved=(com.fudanmed.platform.core.warehouse.RCOutStockRecord)com.uniquesoft.uidl.extensions.ModelObjects.resolve(record, entities);
    
    RCSystemParameter _systemParameter = this.systemParameter.getSystemParameter();
    String _template = OutStockTemplate.template( _resolved, _systemParameter, this.itemMapper);
    return _template;
  }
}
