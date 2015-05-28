package com.fudanmed.platform.core.web.server.service.project;

import com.fudanmed.platform.core.domain.RCGroupTaskCriteria;
import com.fudanmed.platform.core.domain.RCMaintenanceTeam;
import com.fudanmed.platform.core.domain.RCWorkflowService;
import com.fudanmed.platform.core.web.shared.project.UIGroupTaskCriteria;
import com.fudanmed.platform.core.web.shared.project.WorkflowEnumWorkAround;
import com.uniquesoft.uidl.transform.AbstractDataTypeMapper;
import com.uniquesoft.uidl.transform.IConvertService;
import java.util.Collection;
import org.eclipse.xtext.xbase.lib.Functions.Function0;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("com.fudanmed.platform.core.web.server.service.project.GroupTaskCriteriaMapper")
public class GroupTaskCriteriaMapper extends AbstractDataTypeMapper<UIGroupTaskCriteria,RCGroupTaskCriteria> {
  @Autowired
  private IConvertService convertService;
  
  @Autowired
  private RCWorkflowService workflowService;
  
  public void copyToEntity(final UIGroupTaskCriteria from, final RCGroupTaskCriteria to) {
    to.setDateFrom(convertService.toValue(java.util.Date.class,from.getDateFrom()));
    to.setDateTo(convertService.toValue(java.util.Date.class,from.getDateTo()));
    to.setIncludeFinishedTask(convertService.toValue(java.lang.Boolean.class,from.getIncludeFinishedTask()));
    to.setStatus(convertService.toValue(com.fudanmed.platform.core.domain.RCGroupTaskStatus.class,from.getStatus()));
    to.setReportOrg(convertService.toValue(com.fudanmed.platform.core.domain.RCOrganization.class,from.getReportOrg()));
    to.setFaultReportSource(convertService.toValue(com.fudanmed.platform.core.common.RCFaultReportSource.class,from.getFaultReportSource()));
    to.setMonth(convertService.toValue(java.lang.String.class,from.getMonth()));
    copyToCust(from,to);
    
  }
  
  protected void copyToCust(final UIGroupTaskCriteria _gwt, final RCGroupTaskCriteria _entity) {
    WorkflowEnumWorkAround.initGroupTaskCriteria(new Function0<RCGroupTaskCriteria>() {
      public RCGroupTaskCriteria apply() {
        return _entity;
      }
    }.apply());
    Collection<RCMaintenanceTeam> _loadMaintenanceTeams4SystemUser = this.workflowService.loadMaintenanceTeams4SystemUser();
    final Procedure1<RCMaintenanceTeam> _function = new Procedure1<RCMaintenanceTeam>() {
        public void apply(final RCMaintenanceTeam it) {
          Collection<Long> _teams = _entity.getTeams();
          Long _id = it.getId();
          _teams.add(_id);
        }
      };
    IterableExtensions.<RCMaintenanceTeam>forEach(_loadMaintenanceTeams4SystemUser, _function);
  }
  
  public UIGroupTaskCriteria copyFromEntity(final UIGroupTaskCriteria result, final RCGroupTaskCriteria entity) {
    if(entity==null) return null;
    result.setDateFrom(convertService.toValue(java.util.Date.class,entity.getDateFrom()));
    result.setDateTo(convertService.toValue(java.util.Date.class,entity.getDateTo()));
    result.setIncludeFinishedTask(convertService.toValue(java.lang.Boolean.class,entity.getIncludeFinishedTask()));
    result.setStatus(convertService.toValue(com.fudanmed.platform.core.web.shared.project.UIGroupTaskStatus.class,entity.getStatus()));
    result.setReportOrg(convertService.toValue(com.fudanmed.platform.core.domain.proxy.RCOrganizationProxy.class,entity.getReportOrg()));
    result.setFaultReportSource(convertService.toValue(com.fudanmed.platform.core.common.proxy.RCFaultReportSourceProxy.class,entity.getFaultReportSource()));
    result.setMonth(convertService.toValue(java.lang.String.class,entity.getMonth()));
    return result;
    
  }
  
  public UIGroupTaskCriteria buildFrom(final RCGroupTaskCriteria entity) {
    if(entity==null) return null;
    com.fudanmed.platform.core.web.shared.project.UIGroupTaskCriteria result = new com.fudanmed.platform.core.web.shared.project.UIGroupTaskCriteria();
    copyFromEntity(result,entity);	
    return result;
    
  }
  
  public Class<?> getUIClass() {
    return UIGroupTaskCriteria.class;
  }
  
  public Class<?> getEntityClass() {
    return RCGroupTaskCriteria.class;
  }
}
