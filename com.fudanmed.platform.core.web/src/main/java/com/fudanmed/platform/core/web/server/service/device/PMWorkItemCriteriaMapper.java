package com.fudanmed.platform.core.web.server.service.device;

import com.fudanmed.platform.core.device.pm.RCPMWorkItemCriteria;
import com.fudanmed.platform.core.domain.RCMaintenanceTeam;
import com.fudanmed.platform.core.domain.RCWorkflowService;
import com.fudanmed.platform.core.web.shared.device.UIPMWorkItemCriteria;
import com.uniquesoft.uidl.transform.AbstractDataTypeMapper;
import com.uniquesoft.uidl.transform.IConvertService;
import java.util.Collection;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("com.fudanmed.platform.core.web.server.service.device.PMWorkItemCriteriaMapper")
public class PMWorkItemCriteriaMapper extends AbstractDataTypeMapper<UIPMWorkItemCriteria,RCPMWorkItemCriteria> {
  @Autowired
  private IConvertService convertService;
  
  @Autowired
  private RCWorkflowService workflowService;
  
  public void copyToEntity(final UIPMWorkItemCriteria from, final RCPMWorkItemCriteria to) {
    to.setAssignDateFrom(convertService.toValue(java.util.Date.class,from.getAssignDateFrom()));
    to.setAssignDateTo(convertService.toValue(java.util.Date.class,from.getAssignDateTo()));
    to.setIncludeFinishedItems(convertService.toValue(java.lang.Boolean.class,from.getIncludeFinishedItems()));
    to.setTeam(convertService.toValue(com.fudanmed.platform.core.domain.RCMaintenanceTeam.class,from.getTeam()));
    to.setStatus(convertService.toValue(com.fudanmed.platform.core.device.pm.RCPMWorkItemStatue.class,from.getStatus()));
    copyToCust(from,to);
    
  }
  
  protected void copyToCust(final UIPMWorkItemCriteria _gwt, final RCPMWorkItemCriteria _entity) {
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
  
  public UIPMWorkItemCriteria copyFromEntity(final UIPMWorkItemCriteria result, final RCPMWorkItemCriteria entity) {
    if(entity==null) return null;
    result.setAssignDateFrom(convertService.toValue(java.util.Date.class,entity.getAssignDateFrom()));
    result.setAssignDateTo(convertService.toValue(java.util.Date.class,entity.getAssignDateTo()));
    result.setIncludeFinishedItems(convertService.toValue(java.lang.Boolean.class,entity.getIncludeFinishedItems()));
    result.setTeam(convertService.toValue(com.fudanmed.platform.core.domain.proxy.RCMaintenanceTeamProxy.class,entity.getTeam()));
    result.setStatus(convertService.toValue(com.fudanmed.platform.core.web.shared.device.UIPMWorkItemStatue.class,entity.getStatus()));
    return result;
    
  }
  
  public UIPMWorkItemCriteria buildFrom(final RCPMWorkItemCriteria entity) {
    if(entity==null) return null;
    com.fudanmed.platform.core.web.shared.device.UIPMWorkItemCriteria result = new com.fudanmed.platform.core.web.shared.device.UIPMWorkItemCriteria();
    copyFromEntity(result,entity);	
    return result;
    
  }
  
  public Class<?> getUIClass() {
    return UIPMWorkItemCriteria.class;
  }
  
  public Class<?> getEntityClass() {
    return RCPMWorkItemCriteria.class;
  }
}
