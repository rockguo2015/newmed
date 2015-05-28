package com.fudanmed.platform.core.web.server.service.project;

import com.fudanmed.platform.core.common.RCSystemParameter;
import com.fudanmed.platform.core.common.RCSystemParameterService;
import com.fudanmed.platform.core.domain.RCEmployee;
import com.fudanmed.platform.core.domain.RCEmployeeUser;
import com.fudanmed.platform.core.domain.RCGroupTask;
import com.fudanmed.platform.core.domain.RCMaintenanceTeam;
import com.fudanmed.platform.core.domain.RCOrganization;
import com.fudanmed.platform.core.domain.RCRepairTask;
import com.fudanmed.platform.core.domain.RCWorkItemTask;
import com.fudanmed.platform.core.domain.proxy.RCEmployeeProxy;
import com.fudanmed.platform.core.domain.proxy.RCGroupTaskProxy;
import com.fudanmed.platform.core.domain.proxy.RCOrganizationProxy;
import com.fudanmed.platform.core.domain.proxy.RCWorkItemTaskProxy;
import com.fudanmed.platform.core.web.client.project.CreateOrUpdateWorkItemTaskPresenterService;
import com.fudanmed.platform.core.web.server.service.project.RepairTaskMapper;
import com.fudanmed.platform.core.web.server.service.project.WorkItemTaskMapper;
import com.fudanmed.platform.core.web.server.service.template.Template;
import com.fudanmed.platform.core.web.shared.project.UIRepairTask;
import com.fudanmed.platform.core.web.shared.project.UIWorkItemTask;
import com.uniquesoft.gwt.server.service.common.BaseService;
import com.uniquesoft.gwt.shared.SessionTimeOutException;
import com.uniquesoft.gwt.shared.validation.ValidationException;
import edu.fudan.langlab.domain.security.ISystemUserService;
import edu.fudan.langlab.domain.security.User;
import edu.fudan.mylang.pf.IObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("com.fudanmed.platform.core.web.client.project.CreateOrUpdateWorkItemTaskPresenterService")
@Transactional
public class CreateOrUpdateWorkItemTaskPresenterServiceImpl extends BaseService implements CreateOrUpdateWorkItemTaskPresenterService {
  @Autowired
  private IObjectFactory entities;
  
  @Autowired
  private WorkItemTaskMapper mapper;
  
  @Autowired
  private RepairTaskMapper repairTaskMapper;
  
  @Autowired
  private ISystemUserService systemUserService;
  
  @Autowired
  private RCSystemParameterService systemParameter;
  
  public UIWorkItemTask loadValue(final RCWorkItemTaskProxy pvalue) throws SessionTimeOutException, ValidationException {
    RCWorkItemTask _resolved= null;
    if(pvalue!=null) _resolved=(com.fudanmed.platform.core.domain.RCWorkItemTask)com.uniquesoft.uidl.extensions.ModelObjects.resolve(pvalue, entities);
    
    UIWorkItemTask _transform = this.mapper.transform( _resolved);
    return _transform;
  }
  
  public void updateValue(final UIWorkItemTask uivalue) throws SessionTimeOutException, ValidationException {
    RCWorkItemTask _resolved= null;
    if(uivalue!=null) _resolved=(com.fudanmed.platform.core.domain.RCWorkItemTask)com.uniquesoft.uidl.extensions.ModelObjects.resolve(uivalue, entities);
    
    this.mapper.transform(uivalue,  _resolved);
    RCWorkItemTask _resolved_1= null;
    if(uivalue!=null) _resolved_1=(com.fudanmed.platform.core.domain.RCWorkItemTask)com.uniquesoft.uidl.extensions.ModelObjects.resolve(uivalue, entities);
    
    User _currentUser = this.systemUserService.getCurrentUser();
    RCEmployee _employee = ((RCEmployeeUser) _currentUser).getEmployee();
     _resolved_1.setOperator(_employee);
  }
  
  public RCWorkItemTaskProxy createValue(final RCGroupTaskProxy groupTask, final UIWorkItemTask uivalue) throws SessionTimeOutException, ValidationException {
    RCWorkItemTaskProxy _xblockexpression = null;
    {
      RCGroupTask _resolved= null;
      if(groupTask!=null) _resolved=(com.fudanmed.platform.core.domain.RCGroupTask)com.uniquesoft.uidl.extensions.ModelObjects.resolve(groupTask, entities);
      
      RCWorkItemTask value =  _resolved.createWorkItemTask();
      this.mapper.transform(uivalue, value);
      User _currentUser = this.systemUserService.getCurrentUser();
      RCEmployee _employee = ((RCEmployeeUser) _currentUser).getEmployee();
      value.setOperator(_employee);
      RCWorkItemTaskProxy _proxy = value.toProxy();
      _xblockexpression = (_proxy);
    }
    return _xblockexpression;
  }
  
  public RCOrganizationProxy loadTeam(final RCGroupTaskProxy groupTask) throws SessionTimeOutException, ValidationException {
    RCGroupTask _resolved= null;
    if(groupTask!=null) _resolved=(com.fudanmed.platform.core.domain.RCGroupTask)com.uniquesoft.uidl.extensions.ModelObjects.resolve(groupTask, entities);
    
    RCMaintenanceTeam _team =  _resolved.getTeam();
    RCOrganization _organization = _team.getOrganization();
    RCOrganizationProxy _proxy = _organization.toProxy();
    return _proxy;
  }
  
  public RCEmployeeProxy loadSystemUser() throws SessionTimeOutException, ValidationException {
    User _currentUser = this.systemUserService.getCurrentUser();
    RCEmployee _employee = ((RCEmployeeUser) _currentUser).getEmployee();
    RCEmployeeProxy _proxy = _employee.toProxy();
    return _proxy;
  }
  
  public UIRepairTask loadRepairTask(final RCGroupTaskProxy groupTask) throws SessionTimeOutException, ValidationException {
    RCGroupTask _resolved= null;
    if(groupTask!=null) _resolved=(com.fudanmed.platform.core.domain.RCGroupTask)com.uniquesoft.uidl.extensions.ModelObjects.resolve(groupTask, entities);
    
    RCRepairTask _repairTask =  _resolved==null?(RCRepairTask)null: _resolved.getRepairTask();
    UIRepairTask _transform = this.repairTaskMapper.transform(_repairTask);
    return _transform;
  }
  
  public String generatePrintContents(final RCWorkItemTaskProxy workItemTask) throws SessionTimeOutException, ValidationException {
    RCWorkItemTask _resolved= null;
    if(workItemTask!=null) _resolved=(com.fudanmed.platform.core.domain.RCWorkItemTask)com.uniquesoft.uidl.extensions.ModelObjects.resolve(workItemTask, entities);
    
    RCSystemParameter _systemParameter = this.systemParameter.getSystemParameter();
    String _workItem = Template.workItem( _resolved, _systemParameter);
    return _workItem;
  }
}
