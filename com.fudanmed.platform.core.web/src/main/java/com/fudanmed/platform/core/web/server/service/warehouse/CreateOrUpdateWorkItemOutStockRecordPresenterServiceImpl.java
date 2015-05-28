package com.fudanmed.platform.core.web.server.service.warehouse;

import com.fudanmed.platform.core.common.RCSystemParameter;
import com.fudanmed.platform.core.common.RCSystemParameterService;
import com.fudanmed.platform.core.domain.RCEmployee;
import com.fudanmed.platform.core.domain.RCEmployeeUser;
import com.fudanmed.platform.core.domain.RCGroupTask;
import com.fudanmed.platform.core.domain.RCRepairTask;
import com.fudanmed.platform.core.domain.RCWorkItemTask;
import com.fudanmed.platform.core.domain.proxy.RCEmployeeProxy;
import com.fudanmed.platform.core.domain.proxy.RCRepairTaskProxy;
import com.fudanmed.platform.core.domain.proxy.RCWorkItemTaskProxy;
import com.fudanmed.platform.core.warehouse.RCProductSpecification;
import com.fudanmed.platform.core.warehouse.RCProductSpecificationDAO;
import com.fudanmed.platform.core.warehouse.RCProductWarehouseStorageSummary;
import com.fudanmed.platform.core.warehouse.RCProductWarehouseStorageSummaryCriteria;
import com.fudanmed.platform.core.warehouse.RCWarehouse;
import com.fudanmed.platform.core.warehouse.RCWarehouseService;
import com.fudanmed.platform.core.warehouse.RCWorkItemOutStockRecord;
import com.fudanmed.platform.core.warehouse.proxy.RCWarehouseProxy;
import com.fudanmed.platform.core.warehouse.proxy.RCWorkItemOutStockRecordProxy;
import com.fudanmed.platform.core.web.client.warehouse.CreateOrUpdateWorkItemOutStockRecordPresenterService;
import com.fudanmed.platform.core.web.server.service.template.Template;
import com.fudanmed.platform.core.web.server.service.warehouse.ProductWarehouseStorageSummaryMapper;
import com.fudanmed.platform.core.web.server.service.warehouse.WorkItemOutStockRecordMapper;
import com.fudanmed.platform.core.web.shared.warehouse.UIProductWarehouseStorageSummary;
import com.fudanmed.platform.core.web.shared.warehouse.UIWorkItemOutStockRecord;
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

@Service("com.fudanmed.platform.core.web.client.warehouse.CreateOrUpdateWorkItemOutStockRecordPresenterService")
@Transactional
public class CreateOrUpdateWorkItemOutStockRecordPresenterServiceImpl extends BaseService implements CreateOrUpdateWorkItemOutStockRecordPresenterService {
  @Autowired
  private IObjectFactory entities;
  
  @Autowired
  private WorkItemOutStockRecordMapper mapper;
  
  @Autowired
  private ISystemUserService systemUserService;
  
  @Autowired
  private RCWarehouseService warehouseService;
  
  @Autowired
  private RCSystemParameterService systemParameter;
  
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
  
  public UIWorkItemOutStockRecord loadValue(final RCWorkItemOutStockRecordProxy pvalue) throws SessionTimeOutException, ValidationException {
    RCWorkItemOutStockRecord _resolved= null;
    if(pvalue!=null) _resolved=(com.fudanmed.platform.core.warehouse.RCWorkItemOutStockRecord)com.uniquesoft.uidl.extensions.ModelObjects.resolve(pvalue, entities);
    
    UIWorkItemOutStockRecord _transform = this.mapper.transform( _resolved);
    return _transform;
  }
  
  public RCWorkItemOutStockRecordProxy createValue(final UIWorkItemOutStockRecord uivalue) throws SessionTimeOutException, ValidationException {
    RCWorkItemOutStockRecordProxy _xblockexpression = null;
    {
      final Procedure1<RCWorkItemOutStockRecord> _function = new Procedure1<RCWorkItemOutStockRecord>() {
          public void apply(final RCWorkItemOutStockRecord it) {
            CreateOrUpdateWorkItemOutStockRecordPresenterServiceImpl.this.mapper.transform(uivalue, it);
          }
        };
      final RCWorkItemOutStockRecord result = this.warehouseService.createWorkItemOutStockRecord(_function);
      User _currentUser = this.systemUserService.getCurrentUser();
      RCEmployee _employee = ((RCEmployeeUser) _currentUser).getEmployee();
      result.commit(_employee);
      RCWorkItemOutStockRecordProxy _proxy = result.toProxy();
      _xblockexpression = (_proxy);
    }
    return _xblockexpression;
  }
  
  public RCRepairTaskProxy getRepairTask(final RCWorkItemTaskProxy workItem) throws SessionTimeOutException, ValidationException {
    RCRepairTaskProxy _xblockexpression = null;
    {
      RCWorkItemTask _resolved= null;
      if(workItem!=null) _resolved=(com.fudanmed.platform.core.domain.RCWorkItemTask)com.uniquesoft.uidl.extensions.ModelObjects.resolve(workItem, entities);
      
      RCGroupTask _groupTask =  _resolved.getGroupTask();
      final RCRepairTask repairTask = _groupTask.getRepairTask();
      RCRepairTaskProxy _proxy = repairTask.toProxy();
      final Procedure1<RCRepairTaskProxy> _function = new Procedure1<RCRepairTaskProxy>() {
          public void apply(final RCRepairTaskProxy it) {
            String _reportSid = repairTask.getReportSid();
            it.setName(_reportSid);
          }
        };
      RCRepairTaskProxy _doubleArrow = ObjectExtensions.<RCRepairTaskProxy>operator_doubleArrow(_proxy, _function);
      _xblockexpression = (_doubleArrow);
    }
    return _xblockexpression;
  }
  
  public String generateFitPrintContents(final RCWorkItemOutStockRecordProxy record) throws SessionTimeOutException, ValidationException {
    RCWorkItemOutStockRecord _resolved= null;
    if(record!=null) _resolved=(com.fudanmed.platform.core.warehouse.RCWorkItemOutStockRecord)com.uniquesoft.uidl.extensions.ModelObjects.resolve(record, entities);
    
    String _workItemOutStockFit = Template.workItemOutStockFit( _resolved);
    return _workItemOutStockFit;
  }
  
  public String generatePrintContents(final RCWorkItemOutStockRecordProxy record) throws SessionTimeOutException, ValidationException {
    RCWorkItemOutStockRecord _resolved= null;
    if(record!=null) _resolved=(com.fudanmed.platform.core.warehouse.RCWorkItemOutStockRecord)com.uniquesoft.uidl.extensions.ModelObjects.resolve(record, entities);
    
    RCSystemParameter _systemParameter = this.systemParameter.getSystemParameter();
    String _workItemOutStock = Template.workItemOutStock( _resolved, _systemParameter);
    return _workItemOutStock;
  }
  
  public RCEmployeeProxy getCurrentUser() throws SessionTimeOutException, ValidationException {
    Party _currentUserAsParty = this.systemUserService.getCurrentUserAsParty();
    RCEmployeeProxy _proxy = ((RCEmployee) _currentUserAsParty).toProxy();
    return _proxy;
  }
}
