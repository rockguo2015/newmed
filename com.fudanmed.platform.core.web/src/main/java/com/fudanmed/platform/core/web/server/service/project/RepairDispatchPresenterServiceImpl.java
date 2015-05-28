package com.fudanmed.platform.core.web.server.service.project;

import com.fudanmed.platform.core.domain.RCEmployee;
import com.fudanmed.platform.core.domain.RCEmployeeUser;
import com.fudanmed.platform.core.domain.RCMaintenanceTeam;
import com.fudanmed.platform.core.domain.RCRepairTask;
import com.fudanmed.platform.core.domain.proxy.RCEmployeeProxy;
import com.fudanmed.platform.core.domain.proxy.RCMaintenanceTeamProxy;
import com.fudanmed.platform.core.domain.proxy.RCRepairTaskProxy;
import com.fudanmed.platform.core.web.client.project.RepairDispatchPresenterService;
import com.fudanmed.platform.core.web.server.service.project.RepairDispatchDataValidator;
import com.fudanmed.platform.core.web.shared.project.UIRepairDispatchData;
import com.uniquesoft.gwt.server.service.common.BaseService;
import com.uniquesoft.gwt.shared.SessionTimeOutException;
import com.uniquesoft.gwt.shared.validation.ValidationException;
import com.uniquesoft.uidl.validation.Validates;
import edu.fudan.langlab.domain.security.ISystemUserService;
import edu.fudan.langlab.domain.security.User;
import edu.fudan.mylang.pf.IObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("com.fudanmed.platform.core.web.client.project.RepairDispatchPresenterService")
@Transactional
public class RepairDispatchPresenterServiceImpl extends BaseService implements RepairDispatchPresenterService {
  @Autowired
  private IObjectFactory entities;
  
  @Autowired
  private ISystemUserService systemUserService;
  
  @Autowired
  private RepairDispatchDataValidator validator;
  
  public void dispatch(final RCRepairTaskProxy report, final UIRepairDispatchData data) throws SessionTimeOutException, ValidationException {
    Validates.<UIRepairDispatchData>validateWith(data, this.validator);
    RCRepairTask _resolved= null;
    if(report!=null) _resolved=(com.fudanmed.platform.core.domain.RCRepairTask)com.uniquesoft.uidl.extensions.ModelObjects.resolve(report, entities);
    
    RCMaintenanceTeamProxy _team = data.getTeam();
    RCMaintenanceTeam _resolved_1= null;
    if(_team!=null) _resolved_1=(com.fudanmed.platform.core.domain.RCMaintenanceTeam)com.uniquesoft.uidl.extensions.ModelObjects.resolve(_team, entities);
    
     _resolved.createGroupTask( _resolved_1);
  }
  
  public RCEmployeeProxy getSystemUser() throws SessionTimeOutException, ValidationException {
    User _currentUser = this.systemUserService.getCurrentUser();
    RCEmployee _employee = ((RCEmployeeUser) _currentUser).getEmployee();
    RCEmployeeProxy _proxy = _employee.toProxy();
    return _proxy;
  }
}
