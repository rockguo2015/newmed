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
import com.fudanmed.platform.core.warehouse.RCWarehouseService;
import com.fudanmed.platform.core.warehouse.RCWorkItemReturnStockRecord;
import com.fudanmed.platform.core.warehouse.proxy.RCWorkItemReturnStockRecordProxy;
import com.fudanmed.platform.core.web.client.warehouse.CreateOrUpdateWorkItemReturnStockRecordPresenterService;
import com.fudanmed.platform.core.web.server.service.template.WorkOrderReturnTemplate;
import com.fudanmed.platform.core.web.server.service.warehouse.WorkItemReturnStockRecordMapper;
import com.fudanmed.platform.core.web.shared.warehouse.UIWorkItemReturnStockRecord;
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

@Service("com.fudanmed.platform.core.web.client.warehouse.CreateOrUpdateWorkItemReturnStockRecordPresenterService")
@Transactional
public class CreateOrUpdateWorkItemReturnStockRecordPresenterServiceImpl extends BaseService implements CreateOrUpdateWorkItemReturnStockRecordPresenterService {
  @Autowired
  private IObjectFactory entities;
  
  @Autowired
  private WorkItemReturnStockRecordMapper mapper;
  
  @Autowired
  private ISystemUserService systemUserService;
  
  @Autowired
  private RCWarehouseService warehouseService;
  
  @Autowired
  private RCSystemParameterService systemParameter;
  
  public UIWorkItemReturnStockRecord loadValue(final RCWorkItemReturnStockRecordProxy pvalue) throws SessionTimeOutException, ValidationException {
    RCWorkItemReturnStockRecord _resolved= null;
    if(pvalue!=null) _resolved=(com.fudanmed.platform.core.warehouse.RCWorkItemReturnStockRecord)com.uniquesoft.uidl.extensions.ModelObjects.resolve(pvalue, entities);
    
    UIWorkItemReturnStockRecord _transform = this.mapper.transform( _resolved);
    return _transform;
  }
  
  public RCWorkItemReturnStockRecordProxy createValue(final UIWorkItemReturnStockRecord uivalue) throws SessionTimeOutException, ValidationException {
    RCWorkItemReturnStockRecordProxy _xblockexpression = null;
    {
      final Procedure1<RCWorkItemReturnStockRecord> _function = new Procedure1<RCWorkItemReturnStockRecord>() {
          public void apply(final RCWorkItemReturnStockRecord it) {
            CreateOrUpdateWorkItemReturnStockRecordPresenterServiceImpl.this.mapper.transform(uivalue, it);
          }
        };
      final RCWorkItemReturnStockRecord result = this.warehouseService.createWorkItemReturnStockRecord(_function);
      User _currentUser = this.systemUserService.getCurrentUser();
      RCEmployee _employee = ((RCEmployeeUser) _currentUser).getEmployee();
      result.commit(_employee);
      RCWorkItemReturnStockRecordProxy _proxy = result.toProxy();
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
  
  public RCEmployeeProxy getCurrentUser() throws SessionTimeOutException, ValidationException {
    Party _currentUserAsParty = this.systemUserService.getCurrentUserAsParty();
    RCEmployeeProxy _proxy = ((RCEmployee) _currentUserAsParty).toProxy();
    return _proxy;
  }
  
  public String generatePrintContents(final RCWorkItemReturnStockRecordProxy record) throws SessionTimeOutException, ValidationException {
    RCWorkItemReturnStockRecord _resolved= null;
    if(record!=null) _resolved=(com.fudanmed.platform.core.warehouse.RCWorkItemReturnStockRecord)com.uniquesoft.uidl.extensions.ModelObjects.resolve(record, entities);
    
    RCSystemParameter _systemParameter = this.systemParameter.getSystemParameter();
    String _template = WorkOrderReturnTemplate.template( _resolved, _systemParameter);
    return _template;
  }
}
