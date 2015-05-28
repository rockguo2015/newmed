package com.fudanmed.platform.core.web.server.service.warehouse;

import com.fudanmed.platform.core.domain.RCWorkItemTaskCriteria;
import com.fudanmed.platform.core.web.shared.project.WorkflowEnumWorkAround;
import com.fudanmed.platform.core.web.shared.warehouse.UIWorkItemTaskCriteria;
import com.uniquesoft.uidl.transform.AbstractDataTypeMapper;
import com.uniquesoft.uidl.transform.IConvertService;
import org.eclipse.xtext.xbase.lib.Functions.Function0;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("com.fudanmed.platform.core.web.server.service.warehouse.WorkItemTaskCriteriaMapper")
public class WorkItemTaskCriteriaMapper extends AbstractDataTypeMapper<UIWorkItemTaskCriteria,RCWorkItemTaskCriteria> {
  @Autowired
  private IConvertService convertService;
  
  public void copyToEntity(final UIWorkItemTaskCriteria from, final RCWorkItemTaskCriteria to) {
    to.setSid(convertService.toValue(java.lang.String.class,from.getSid()));
    to.setShowAll(convertService.toValue(java.lang.Boolean.class,from.getShowAll()));
    to.setTeam(convertService.toValue(com.fudanmed.platform.core.domain.RCMaintenanceTeam.class,from.getTeam()));
    copyToCust(from,to);
    
  }
  
  protected void copyToCust(final UIWorkItemTaskCriteria _gwt, final RCWorkItemTaskCriteria _entity) {
    WorkflowEnumWorkAround.initWorkItemTaskCriteria(new Function0<RCWorkItemTaskCriteria>() {
      public RCWorkItemTaskCriteria apply() {
        return _entity;
      }
    }.apply());
  }
  
  public UIWorkItemTaskCriteria copyFromEntity(final UIWorkItemTaskCriteria result, final RCWorkItemTaskCriteria entity) {
    if(entity==null) return null;
    result.setSid(convertService.toValue(java.lang.String.class,entity.getSid()));
    result.setShowAll(convertService.toValue(java.lang.Boolean.class,entity.getShowAll()));
    result.setTeam(convertService.toValue(com.fudanmed.platform.core.domain.proxy.RCMaintenanceTeamProxy.class,entity.getTeam()));
    return result;
    
  }
  
  public UIWorkItemTaskCriteria buildFrom(final RCWorkItemTaskCriteria entity) {
    if(entity==null) return null;
    com.fudanmed.platform.core.web.shared.warehouse.UIWorkItemTaskCriteria result = new com.fudanmed.platform.core.web.shared.warehouse.UIWorkItemTaskCriteria();
    copyFromEntity(result,entity);	
    return result;
    
  }
  
  public Class<?> getUIClass() {
    return UIWorkItemTaskCriteria.class;
  }
  
  public Class<?> getEntityClass() {
    return RCWorkItemTaskCriteria.class;
  }
}
