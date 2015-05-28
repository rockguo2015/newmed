package com.fudanmed.platform.core.web.server.service.project;

import com.fudanmed.platform.core.common.RCSequenceService;
import com.fudanmed.platform.core.domain.RCEmployee;
import com.fudanmed.platform.core.domain.RCEmployeeUser;
import com.fudanmed.platform.core.domain.RCFaultType;
import com.fudanmed.platform.core.domain.RCFaultTypeContentProviderCriteria;
import com.fudanmed.platform.core.domain.RCOnsitePosition;
import com.fudanmed.platform.core.domain.RCOrganization;
import com.fudanmed.platform.core.domain.RCRepairTask;
import com.fudanmed.platform.core.domain.RCRepairTaskCriteria;
import com.fudanmed.platform.core.domain.RCRepairTaskDAO;
import com.fudanmed.platform.core.domain.proxy.RCOnsitePositionProxy;
import com.fudanmed.platform.core.domain.proxy.RCOrganizationProxy;
import com.fudanmed.platform.core.domain.proxy.RCRepairTaskProxy;
import com.fudanmed.platform.core.web.client.project.CreateOrUpdateReportPresenterService;
import com.fudanmed.platform.core.web.server.service.organization.EmployeeMapper;
import com.fudanmed.platform.core.web.server.service.organization.OnsitePositionMapper;
import com.fudanmed.platform.core.web.server.service.project.FaultTypeMapper;
import com.fudanmed.platform.core.web.server.service.project.RepairTaskMapper;
import com.fudanmed.platform.core.web.server.service.project.ReportValidator;
import com.fudanmed.platform.core.web.shared.organization.UIEmployee;
import com.fudanmed.platform.core.web.shared.organization.UIOnsitePosition;
import com.fudanmed.platform.core.web.shared.project.OrgRelatedInfoData;
import com.fudanmed.platform.core.web.shared.project.UIFaultType;
import com.fudanmed.platform.core.web.shared.project.UIRepairTask;
import com.fudanmed.platform.core.web.shared.project.WorkflowEnumWorkAround;
import com.uniquesoft.gwt.server.service.common.BaseService;
import com.uniquesoft.gwt.shared.SessionTimeOutException;
import com.uniquesoft.gwt.shared.extensions.IterableExtensions2;
import com.uniquesoft.gwt.shared.validation.ValidationException;
import com.uniquesoft.uidl.validation.Validates;
import edu.fudan.langlab.domain.code.CodeService;
import edu.fudan.langlab.domain.organization.Party;
import edu.fudan.langlab.domain.security.ISystemUserService;
import edu.fudan.langlab.domain.security.User;
import edu.fudan.mylang.pf.IObjectFactory;
import java.util.Collection;
import java.util.Set;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("com.fudanmed.platform.core.web.client.project.CreateOrUpdateReportPresenterService")
@Transactional
public class CreateOrUpdateReportPresenterServiceImpl extends BaseService implements CreateOrUpdateReportPresenterService {
  @Autowired
  private IObjectFactory entities;
  
  @Autowired
  private RepairTaskMapper mapper;
  
  @Autowired
  private OnsitePositionMapper positionMapper;
  
  @Autowired
  private FaultTypeMapper faultTypeMapper;
  
  @Autowired
  private EmployeeMapper employeeMapper;
  
  @Autowired
  private ISystemUserService systemUserService;
  
  @Autowired
  private RCSequenceService sequenceService;
  
  @Autowired
  private ReportValidator reportValidator;
  
  @Autowired
  private CodeService codeService;
  
  @Autowired
  private RCRepairTaskDAO dao;
  
  public UIRepairTask loadValue(final RCRepairTaskProxy pvalue) throws SessionTimeOutException, ValidationException {
    RCRepairTask _resolved= null;
    if(pvalue!=null) _resolved=(com.fudanmed.platform.core.domain.RCRepairTask)com.uniquesoft.uidl.extensions.ModelObjects.resolve(pvalue, entities);
    
    UIRepairTask _transform = this.mapper.transform( _resolved);
    return _transform;
  }
  
  public void updateValue(final UIRepairTask uivalue) throws SessionTimeOutException, ValidationException {
    Validates.<UIRepairTask>validateWith(uivalue, this.reportValidator);
    RCRepairTask _resolved= null;
    if(uivalue!=null) _resolved=(com.fudanmed.platform.core.domain.RCRepairTask)com.uniquesoft.uidl.extensions.ModelObjects.resolve(uivalue, entities);
    
    final RCRepairTask v =  _resolved;
    this.mapper.transform(uivalue, v);
    Party _currentUserAsParty = this.systemUserService.getCurrentUserAsParty();
    v.setOperator(_currentUserAsParty);
    v.updated();
  }
  
  public void createValue(final UIRepairTask uivalue) throws SessionTimeOutException, ValidationException {
    Validates.<UIRepairTask>validateWith(uivalue, this.reportValidator);
    final Procedure1<RCRepairTask> _function = new Procedure1<RCRepairTask>() {
        public void apply(final RCRepairTask it) {
          CreateOrUpdateReportPresenterServiceImpl.this.mapper.transform(uivalue, it);
          it.start(Boolean.valueOf(true));
        }
      };
    this.dao.createRepairTask4Reporter(_function);
  }
  
  public Collection<UIFaultType> loadFaultTypes(final String name) throws SessionTimeOutException, ValidationException {
    RCFaultTypeContentProviderCriteria _createQueryCriteria = this.entities.createQueryCriteria(RCFaultTypeContentProviderCriteria.class);
    final Procedure1<RCFaultTypeContentProviderCriteria> _function = new Procedure1<RCFaultTypeContentProviderCriteria>() {
        public void apply(final RCFaultTypeContentProviderCriteria it) {
          it.setLimit(Integer.valueOf(20));
          String _plus = ("%" + name);
          String _plus_1 = (_plus + "%");
          it.setName(_plus_1);
        }
      };
    RCFaultTypeContentProviderCriteria _doubleArrow = ObjectExtensions.<RCFaultTypeContentProviderCriteria>operator_doubleArrow(_createQueryCriteria, _function);
    Collection<RCFaultType> _list = _doubleArrow.list();
    final Function1<RCFaultType,UIFaultType> _function_1 = new Function1<RCFaultType,UIFaultType>() {
        public UIFaultType apply(final RCFaultType it) {
          UIFaultType _transform = CreateOrUpdateReportPresenterServiceImpl.this.faultTypeMapper.transform(it);
          return _transform;
        }
      };
    Iterable<UIFaultType> _map = IterableExtensions.<RCFaultType, UIFaultType>map(_list, _function_1);
    Collection<UIFaultType> _unlazy = IterableExtensions2.<UIFaultType>unlazy(_map);
    return _unlazy;
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
                  UIOnsitePosition _transform = CreateOrUpdateReportPresenterServiceImpl.this.positionMapper.transform(it);
                  return _transform;
                }
              };
            Iterable<UIOnsitePosition> _map = IterableExtensions.<RCOnsitePosition, UIOnsitePosition>map(_positions, _function);
            Collection<UIOnsitePosition> _unlazy = IterableExtensions2.<UIOnsitePosition>unlazy(_map);
            it.setPos(_unlazy);
            RCRepairTaskCriteria _createQueryCriteria = CreateOrUpdateReportPresenterServiceImpl.this.entities.createQueryCriteria(RCRepairTaskCriteria.class);
            final Procedure1<RCRepairTaskCriteria> _function_1 = new Procedure1<RCRepairTaskCriteria>() {
                public void apply(final RCRepairTaskCriteria it) {
                  it.setLimit(Integer.valueOf(20));
                  it.setReportOrg(organization);
                  it.setIncludeFinishedTask(Boolean.valueOf(true));
                  WorkflowEnumWorkAround.initRepairTaskCriteria(it);
                }
              };
            RCRepairTaskCriteria _doubleArrow = ObjectExtensions.<RCRepairTaskCriteria>operator_doubleArrow(_createQueryCriteria, _function_1);
            Collection<RCRepairTask> _list = _doubleArrow.list();
            final Function1<RCRepairTask,UIRepairTask> _function_2 = new Function1<RCRepairTask,UIRepairTask>() {
                public UIRepairTask apply(final RCRepairTask it) {
                  UIRepairTask _transform = CreateOrUpdateReportPresenterServiceImpl.this.mapper.transform(it);
                  return _transform;
                }
              };
            Iterable<UIRepairTask> _map_1 = IterableExtensions.<RCRepairTask, UIRepairTask>map(_list, _function_2);
            Collection<UIRepairTask> _unlazy_1 = IterableExtensions2.<UIRepairTask>unlazy(_map_1);
            it.setHistoryTasks(_unlazy_1);
          }
        };
      OrgRelatedInfoData _doubleArrow = ObjectExtensions.<OrgRelatedInfoData>operator_doubleArrow(_orgRelatedInfoData, _function);
      _xblockexpression = (_doubleArrow);
    }
    return _xblockexpression;
  }
  
  public String getFullPath(final RCOnsitePositionProxy loc) throws SessionTimeOutException, ValidationException {
    RCOnsitePosition _resolved= null;
    if(loc!=null) _resolved=(com.fudanmed.platform.core.domain.RCOnsitePosition)com.uniquesoft.uidl.extensions.ModelObjects.resolve(loc, entities);
    
    String _fullPath =  _resolved.fullPath();
    return _fullPath;
  }
  
  public OrgRelatedInfoData loadOrgRelatedInfoData4Task(final RCRepairTaskProxy uivalue) throws SessionTimeOutException, ValidationException {
    RCRepairTask _resolved= null;
    if(uivalue!=null) _resolved=(com.fudanmed.platform.core.domain.RCRepairTask)com.uniquesoft.uidl.extensions.ModelObjects.resolve(uivalue, entities);
    
    RCOrganization _reportOrg =  _resolved.getReportOrg();
    RCOrganizationProxy _proxy = _reportOrg.toProxy();
    OrgRelatedInfoData _loadOrgRelatedInfoData = this.loadOrgRelatedInfoData(_proxy);
    return _loadOrgRelatedInfoData;
  }
  
  public RCOrganizationProxy getReportOrg() throws SessionTimeOutException, ValidationException {
    User _currentUser = this.systemUserService.getCurrentUser();
    RCEmployee _employee = ((RCEmployeeUser) _currentUser).getEmployee();
    RCOrganization _organization = _employee.getOrganization();
    RCOrganizationProxy _proxy = _organization.toProxy();
    return _proxy;
  }
  
  public UIEmployee getReporter() throws SessionTimeOutException, ValidationException {
    Party _currentUserAsParty = this.systemUserService.getCurrentUserAsParty();
    UIEmployee _transform = this.employeeMapper.transform(((RCEmployee) _currentUserAsParty));
    return _transform;
  }
  
  public Collection<String> getLastReportContents() throws SessionTimeOutException, ValidationException {
    RCRepairTaskCriteria _createQueryCriteria = this.entities.createQueryCriteria(RCRepairTaskCriteria.class);
    final Procedure1<RCRepairTaskCriteria> _function = new Procedure1<RCRepairTaskCriteria>() {
        public void apply(final RCRepairTaskCriteria it) {
          RCOrganization _reportOrg = it.getReportOrg();
          it.setReportOrg(_reportOrg);
          it.setIncludeFinishedTask(Boolean.valueOf(true));
          it.setLimit(Integer.valueOf(100));
          WorkflowEnumWorkAround.initRepairTaskCriteria(it);
        }
      };
    RCRepairTaskCriteria _doubleArrow = ObjectExtensions.<RCRepairTaskCriteria>operator_doubleArrow(_createQueryCriteria, _function);
    Collection<RCRepairTask> _list = _doubleArrow.list();
    final Function1<RCRepairTask,String> _function_1 = new Function1<RCRepairTask,String>() {
        public String apply(final RCRepairTask it) {
          String _comment = it.getComment();
          return _comment;
        }
      };
    Iterable<String> _map = IterableExtensions.<RCRepairTask, String>map(_list, _function_1);
    Iterable<String> _filterNull = IterableExtensions.<String>filterNull(_map);
    Set<String> _set = IterableExtensions.<String>toSet(_filterNull);
    Collection<String> _unlazy = IterableExtensions2.<String>unlazy(_set);
    return _unlazy;
  }
}
