package com.fudanmed.platform.core.web.server.service.project;

import com.fudanmed.platform.core.common.RCSequenceService;
import com.fudanmed.platform.core.domain.RCEmployee;
import com.fudanmed.platform.core.domain.RCEmployeeUser;
import com.fudanmed.platform.core.domain.RCMaintenanceTeam;
import com.fudanmed.platform.core.domain.RCOnsitePosition;
import com.fudanmed.platform.core.domain.RCOrganization;
import com.fudanmed.platform.core.domain.RCRepairTask;
import com.fudanmed.platform.core.domain.RCRepairTaskCriteria;
import com.fudanmed.platform.core.domain.proxy.RCEmployeeProxy;
import com.fudanmed.platform.core.domain.proxy.RCMaintenanceTeamProxy;
import com.fudanmed.platform.core.domain.proxy.RCOnsitePositionProxy;
import com.fudanmed.platform.core.domain.proxy.RCOrganizationProxy;
import com.fudanmed.platform.core.domain.proxy.RCRepairTaskProxy;
import com.fudanmed.platform.core.web.client.project.CreateOrUpdateRepairTaskPresenterService;
import com.fudanmed.platform.core.web.server.service.organization.EmployeeMapper;
import com.fudanmed.platform.core.web.server.service.organization.OnsitePositionMapper;
import com.fudanmed.platform.core.web.server.service.organization.SimpleEmployeeMapper;
import com.fudanmed.platform.core.web.server.service.project.RepairTaskMapper;
import com.fudanmed.platform.core.web.server.service.project.RepairTaskValidator;
import com.fudanmed.platform.core.web.shared.organization.UIEmployee;
import com.fudanmed.platform.core.web.shared.organization.UIOnsitePosition;
import com.fudanmed.platform.core.web.shared.project.OrgRelatedInfoData;
import com.fudanmed.platform.core.web.shared.project.UIRepairTask;
import com.fudanmed.platform.core.web.shared.project.WorkflowEnumWorkAround;
import com.uniquesoft.gwt.server.service.common.BaseService;
import com.uniquesoft.gwt.shared.SessionTimeOutException;
import com.uniquesoft.gwt.shared.extensions.IterableExtensions2;
import com.uniquesoft.gwt.shared.validation.ValidationException;
import com.uniquesoft.uidl.validation.Validates;
import edu.fudan.langlab.domain.security.ISystemUserService;
import edu.fudan.langlab.domain.security.User;
import edu.fudan.mylang.pf.IObjectFactory;
import java.util.Collection;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("com.fudanmed.platform.core.web.client.project.CreateOrUpdateRepairTaskPresenterService")
@Transactional
public class CreateOrUpdateRepairTaskPresenterServiceImpl extends BaseService implements CreateOrUpdateRepairTaskPresenterService {
  @Autowired
  private IObjectFactory entities;
  
  @Autowired
  private RepairTaskMapper mapper;
  
  @Autowired
  private OnsitePositionMapper positionMapper;
  
  @Autowired
  private EmployeeMapper employeeMapper;
  
  @Autowired
  private SimpleEmployeeMapper simpleEmployeeMapper;
  
  @Autowired
  private ISystemUserService systemUserService;
  
  @Autowired
  private RCSequenceService sequenceService;
  
  @Autowired
  private RepairTaskValidator repairTaskValidator;
  
  public UIRepairTask loadValue(final RCRepairTaskProxy pvalue) throws SessionTimeOutException, ValidationException {
    RCRepairTask _resolved= null;
    if(pvalue!=null) _resolved=(com.fudanmed.platform.core.domain.RCRepairTask)com.uniquesoft.uidl.extensions.ModelObjects.resolve(pvalue, entities);
    
    UIRepairTask _transform = this.mapper.transform( _resolved);
    return _transform;
  }
  
  public void updateValue(final UIRepairTask uivalue) throws SessionTimeOutException, ValidationException {
    Validates.<UIRepairTask>validateWith(uivalue, this.repairTaskValidator);
    RCRepairTask _resolved= null;
    if(uivalue!=null) _resolved=(com.fudanmed.platform.core.domain.RCRepairTask)com.uniquesoft.uidl.extensions.ModelObjects.resolve(uivalue, entities);
    
    final RCRepairTask v =  _resolved;
    this.mapper.transform(uivalue, v);
    User _currentUser = this.systemUserService.getCurrentUser();
    RCEmployee _employee = ((RCEmployeeUser) _currentUser).getEmployee();
    v.setOperator(_employee);
    v.updated();
    Boolean _saveOnly = uivalue.getSaveOnly();
    if ((_saveOnly).booleanValue()) {
      RCMaintenanceTeamProxy _activeTeam = uivalue.getActiveTeam();
      Long _id = _activeTeam.getId();
      RCMaintenanceTeam _get = this.entities.<RCMaintenanceTeam>get(RCMaintenanceTeam.class, _id);
      v.createGroupTask(_get);
    }
  }
  
  public RCRepairTaskProxy createValue(final UIRepairTask uivalue) throws SessionTimeOutException, ValidationException {
    RCRepairTaskProxy _xblockexpression = null;
    {
      Validates.<UIRepairTask>validateWith(uivalue, this.repairTaskValidator);
      RCRepairTask _create = this.entities.<RCRepairTask>create(RCRepairTask.class);
      final Procedure1<RCRepairTask> _function = new Procedure1<RCRepairTask>() {
          public void apply(final RCRepairTask it) {
            CreateOrUpdateRepairTaskPresenterServiceImpl.this.mapper.transform(uivalue, it);
            String _nextRepairTaskSequence = CreateOrUpdateRepairTaskPresenterServiceImpl.this.sequenceService.getNextRepairTaskSequence();
            it.setReportSid(_nextRepairTaskSequence);
            User _currentUser = CreateOrUpdateRepairTaskPresenterServiceImpl.this.systemUserService.getCurrentUser();
            RCEmployee _employee = ((RCEmployeeUser) _currentUser).getEmployee();
            it.setOperator(_employee);
            it.start(Boolean.valueOf(false));
          }
        };
      final RCRepairTask report = ObjectExtensions.<RCRepairTask>operator_doubleArrow(_create, _function);
      Boolean _saveOnly = uivalue.getSaveOnly();
      if ((_saveOnly).booleanValue()) {
        RCMaintenanceTeamProxy _activeTeam = uivalue.getActiveTeam();
        Long _id = _activeTeam.getId();
        RCMaintenanceTeam _get = this.entities.<RCMaintenanceTeam>get(RCMaintenanceTeam.class, _id);
        report.createGroupTask(_get);
      }
      RCRepairTaskProxy _proxy = report.toProxy();
      _xblockexpression = (_proxy);
    }
    return _xblockexpression;
  }
  
  public OrgRelatedInfoData loadOrgRelatedInfoData(final RCOrganizationProxy org) throws SessionTimeOutException, ValidationException {
    OrgRelatedInfoData _xblockexpression = null;
    {
      RCOrganization _resolved= null;
      if(org!=null) _resolved=(com.fudanmed.platform.core.domain.RCOrganization)com.uniquesoft.uidl.extensions.ModelObjects.resolve(org, entities);
      
      final RCOrganization organization =  _resolved;
      OrgRelatedInfoData _orgRelatedInfoData = new OrgRelatedInfoData();
      final Procedure1<OrgRelatedInfoData> _function = new Procedure1<OrgRelatedInfoData>() {
          public void apply(final OrgRelatedInfoData it) {
            Collection<RCOnsitePosition> _positions = organization.getPositions();
            final Function1<RCOnsitePosition,UIOnsitePosition> _function = new Function1<RCOnsitePosition,UIOnsitePosition>() {
                public UIOnsitePosition apply(final RCOnsitePosition it) {
                  UIOnsitePosition _transform = CreateOrUpdateRepairTaskPresenterServiceImpl.this.positionMapper.transform(it);
                  return _transform;
                }
              };
            Iterable<UIOnsitePosition> _map = IterableExtensions.<RCOnsitePosition, UIOnsitePosition>map(_positions, _function);
            Collection<UIOnsitePosition> _unlazy = IterableExtensions2.<UIOnsitePosition>unlazy(_map);
            it.setPos(_unlazy);
            Collection<RCEmployee> _onJobEmployees = organization.getOnJobEmployees();
            final Function1<RCEmployee,UIEmployee> _function_1 = new Function1<RCEmployee,UIEmployee>() {
                public UIEmployee apply(final RCEmployee it) {
                  UIEmployee _transform = CreateOrUpdateRepairTaskPresenterServiceImpl.this.simpleEmployeeMapper.transform(it);
                  return _transform;
                }
              };
            Iterable<UIEmployee> _map_1 = IterableExtensions.<RCEmployee, UIEmployee>map(_onJobEmployees, _function_1);
            Collection<UIEmployee> _unlazy_1 = IterableExtensions2.<UIEmployee>unlazy(_map_1);
            it.setWorkers(_unlazy_1);
            RCRepairTaskCriteria _createQueryCriteria = CreateOrUpdateRepairTaskPresenterServiceImpl.this.entities.createQueryCriteria(RCRepairTaskCriteria.class);
            final Procedure1<RCRepairTaskCriteria> _function_2 = new Procedure1<RCRepairTaskCriteria>() {
                public void apply(final RCRepairTaskCriteria it) {
                  it.setLimit(Integer.valueOf(20));
                  it.setReportOrg(organization);
                  it.setIncludeFinishedTask(Boolean.valueOf(true));
                  WorkflowEnumWorkAround.initRepairTaskCriteria(it);
                }
              };
            RCRepairTaskCriteria _doubleArrow = ObjectExtensions.<RCRepairTaskCriteria>operator_doubleArrow(_createQueryCriteria, _function_2);
            Collection<RCRepairTask> _list = _doubleArrow.list();
            final Function1<RCRepairTask,UIRepairTask> _function_3 = new Function1<RCRepairTask,UIRepairTask>() {
                public UIRepairTask apply(final RCRepairTask it) {
                  UIRepairTask _transform = CreateOrUpdateRepairTaskPresenterServiceImpl.this.mapper.transform(it);
                  return _transform;
                }
              };
            Iterable<UIRepairTask> _map_2 = IterableExtensions.<RCRepairTask, UIRepairTask>map(_list, _function_3);
            Collection<UIRepairTask> _unlazy_2 = IterableExtensions2.<UIRepairTask>unlazy(_map_2);
            it.setHistoryTasks(_unlazy_2);
          }
        };
      OrgRelatedInfoData _doubleArrow = ObjectExtensions.<OrgRelatedInfoData>operator_doubleArrow(_orgRelatedInfoData, _function);
      _xblockexpression = (_doubleArrow);
    }
    return _xblockexpression;
  }
  
  public OrgRelatedInfoData loadOrgRelatedInfoData4Task(final RCRepairTaskProxy uivalue) throws SessionTimeOutException, ValidationException {
    RCRepairTask _resolved= null;
    if(uivalue!=null) _resolved=(com.fudanmed.platform.core.domain.RCRepairTask)com.uniquesoft.uidl.extensions.ModelObjects.resolve(uivalue, entities);
    
    RCOrganization _reportOrg =  _resolved.getReportOrg();
    RCOrganizationProxy _proxy = _reportOrg.toProxy();
    OrgRelatedInfoData _loadOrgRelatedInfoData = this.loadOrgRelatedInfoData(_proxy);
    return _loadOrgRelatedInfoData;
  }
  
  public String getFullPath(final RCOnsitePositionProxy loc) throws SessionTimeOutException, ValidationException {
    RCOnsitePosition _resolved= null;
    if(loc!=null) _resolved=(com.fudanmed.platform.core.domain.RCOnsitePosition)com.uniquesoft.uidl.extensions.ModelObjects.resolve(loc, entities);
    
    String _fullPath =  _resolved.fullPath();
    return _fullPath;
  }
  
  public RCEmployeeProxy getSystemUser() throws SessionTimeOutException, ValidationException {
    User _currentUser = this.systemUserService.getCurrentUser();
    RCEmployee _employee = ((RCEmployeeUser) _currentUser).getEmployee();
    RCEmployeeProxy _proxy = _employee.toProxy();
    return _proxy;
  }
}
