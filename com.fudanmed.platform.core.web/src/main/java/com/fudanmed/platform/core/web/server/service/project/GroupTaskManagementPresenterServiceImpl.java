package com.fudanmed.platform.core.web.server.service.project;

import com.fudanmed.platform.core.common.RCSystemParameter;
import com.fudanmed.platform.core.common.RCSystemParameterService;
import com.fudanmed.platform.core.domain.RCGroupTask;
import com.fudanmed.platform.core.domain.RCGroupTaskCriteria;
import com.fudanmed.platform.core.domain.RCMaintenanceTeam;
import com.fudanmed.platform.core.domain.RCOrganization;
import com.fudanmed.platform.core.domain.RCRepairTask;
import com.fudanmed.platform.core.domain.RCTaskDirtyManager;
import com.fudanmed.platform.core.domain.RCWorkItemTask;
import com.fudanmed.platform.core.domain.RCWorkflowService;
import com.fudanmed.platform.core.domain.proxy.RCGroupTaskProxy;
import com.fudanmed.platform.core.domain.proxy.RCRepairTaskProxy;
import com.fudanmed.platform.core.domain.proxy.RCWorkItemTaskProxy;
import com.fudanmed.platform.core.web.client.project.GroupTaskManagementPresenterService;
import com.fudanmed.platform.core.web.server.service.project.GroupTaskCriteriaMapper;
import com.fudanmed.platform.core.web.server.service.project.GroupTaskMapper;
import com.fudanmed.platform.core.web.server.service.template.Template;
import com.fudanmed.platform.core.web.shared.project.UIGroupTask;
import com.fudanmed.platform.core.web.shared.project.UIGroupTaskCriteria;
import com.google.common.base.Function;
import com.uniquesoft.gwt.server.common.pager.PagedQueries;
import com.uniquesoft.gwt.server.service.common.BaseService;
import com.uniquesoft.gwt.shared.SessionTimeOutException;
import com.uniquesoft.gwt.shared.common.pager.IPagedResult;
import com.uniquesoft.gwt.shared.validation.ValidationException;
import edu.fudan.mylang.pf.IObjectFactory;
import java.util.Collection;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("com.fudanmed.platform.core.web.client.project.GroupTaskManagementPresenterService")
@Transactional
public class GroupTaskManagementPresenterServiceImpl extends BaseService implements GroupTaskManagementPresenterService {
  @Autowired
  private IObjectFactory entities;
  
  @Autowired
  private GroupTaskCriteriaMapper criteriaMapper;
  
  @Autowired
  private GroupTaskMapper mapper;
  
  @Autowired
  private RCTaskDirtyManager taskDirtyManager;
  
  @Autowired
  private RCWorkflowService workflowService;
  
  @Autowired
  private RCSystemParameterService systemParameter;
  
  public String getTeamName() throws SessionTimeOutException, ValidationException {
    Collection<RCMaintenanceTeam> _loadMaintenanceTeams4SystemUser = this.workflowService.loadMaintenanceTeams4SystemUser();
    final Function1<RCMaintenanceTeam,String> _function = new Function1<RCMaintenanceTeam,String>() {
        public String apply(final RCMaintenanceTeam it) {
          RCOrganization _organization = it.getOrganization();
          String _name = _organization.getName();
          return _name;
        }
      };
    Iterable<String> _map = IterableExtensions.<RCMaintenanceTeam, String>map(_loadMaintenanceTeams4SystemUser, _function);
    String _join = IterableExtensions.join(_map, ",");
    return _join;
  }
  
  public Boolean isDirty() throws SessionTimeOutException, ValidationException {
    boolean _xblockexpression = false;
    {
      final Collection<RCMaintenanceTeam> teamRoles = this.workflowService.loadMaintenanceTeams4SystemUser();
      int _size = teamRoles.size();
      boolean _equals = (_size == 0);
      if (_equals) {
        return Boolean.valueOf(false);
      }
      final Function1<RCMaintenanceTeam,Boolean> _function = new Function1<RCMaintenanceTeam,Boolean>() {
          public Boolean apply(final RCMaintenanceTeam it) {
            Boolean _checkDirty = GroupTaskManagementPresenterServiceImpl.this.taskDirtyManager.checkDirty(it);
            return _checkDirty;
          }
        };
      boolean _forall = IterableExtensions.<RCMaintenanceTeam>forall(teamRoles, _function);
      _xblockexpression = (_forall);
    }
    return Boolean.valueOf(_xblockexpression);
  }
  
  public IPagedResult<UIGroupTask> filter(final UIGroupTaskCriteria uicriteria) throws SessionTimeOutException, ValidationException {
    IPagedResult<UIGroupTask> _xblockexpression = null;
    {
      final RCGroupTaskCriteria c = PagedQueries.createPagedCriteria(uicriteria, RCGroupTaskCriteria.class, this.criteriaMapper, this.entities);
      final Function1<RCGroupTask,UIGroupTask> _function = new Function1<RCGroupTask,UIGroupTask>() {
          public UIGroupTask apply(final RCGroupTask it) {
            UIGroupTask _apply = GroupTaskManagementPresenterServiceImpl.this.mapper.apply(it);
            return _apply;
          }
        };
      final IPagedResult<UIGroupTask> result = PagedQueries.<UIGroupTask, RCGroupTask>listAndTransform(c, new Function<RCGroupTask,UIGroupTask>() {
          public UIGroupTask apply(RCGroupTask input) {
            return _function.apply(input);
          }
      });
      Collection<RCMaintenanceTeam> _loadMaintenanceTeams4SystemUser = this.workflowService.loadMaintenanceTeams4SystemUser();
      final Procedure1<RCMaintenanceTeam> _function_1 = new Procedure1<RCMaintenanceTeam>() {
          public void apply(final RCMaintenanceTeam it) {
            GroupTaskManagementPresenterServiceImpl.this.taskDirtyManager.refreshed(it);
          }
        };
      IterableExtensions.<RCMaintenanceTeam>forEach(_loadMaintenanceTeams4SystemUser, _function_1);
      _xblockexpression = (result);
    }
    return _xblockexpression;
  }
  
  public void delete(final RCGroupTaskProxy value) throws SessionTimeOutException, ValidationException {
    RCGroupTask _resolved= null;
    if(value!=null) _resolved=(com.fudanmed.platform.core.domain.RCGroupTask)com.uniquesoft.uidl.extensions.ModelObjects.resolve(value, entities);
    
    this.entities.delete( _resolved);
  }
  
  public RCRepairTaskProxy getRepairTask(final RCGroupTaskProxy groupTask) throws SessionTimeOutException, ValidationException {
    RCGroupTask _resolved= null;
    if(groupTask!=null) _resolved=(com.fudanmed.platform.core.domain.RCGroupTask)com.uniquesoft.uidl.extensions.ModelObjects.resolve(groupTask, entities);
    
    RCRepairTask _repairTask =  _resolved.getRepairTask();
    RCRepairTaskProxy _proxy = _repairTask.toProxy();
    return _proxy;
  }
  
  public String generatePrintContents(final RCWorkItemTaskProxy workItemTask) throws SessionTimeOutException, ValidationException {
    String _xblockexpression = null;
    {
      RCWorkItemTask _resolved= null;
      if(workItemTask!=null) _resolved=(com.fudanmed.platform.core.domain.RCWorkItemTask)com.uniquesoft.uidl.extensions.ModelObjects.resolve(workItemTask, entities);
      
      RCSystemParameter _systemParameter = this.systemParameter.getSystemParameter();
      final String result = Template.workItem( _resolved, _systemParameter);
      _xblockexpression = (result);
    }
    return _xblockexpression;
  }
}
