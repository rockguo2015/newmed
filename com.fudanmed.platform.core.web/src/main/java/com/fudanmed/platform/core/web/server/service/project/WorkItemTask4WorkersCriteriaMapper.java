package com.fudanmed.platform.core.web.server.service.project;

import com.fudanmed.platform.core.domain.RCWorkItemTask4WorkersCriteria;
import com.fudanmed.platform.core.web.shared.project.UIWorkItemTask4WorkersCriteria;
import com.uniquesoft.uidl.transform.AbstractDataTypeMapper;
import com.uniquesoft.uidl.transform.IConvertService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("com.fudanmed.platform.core.web.server.service.project.WorkItemTask4WorkersCriteriaMapper")
public class WorkItemTask4WorkersCriteriaMapper extends AbstractDataTypeMapper<UIWorkItemTask4WorkersCriteria,RCWorkItemTask4WorkersCriteria> {
  @Autowired
  private IConvertService convertService;
  
  public void copyToEntity(final UIWorkItemTask4WorkersCriteria from, final RCWorkItemTask4WorkersCriteria to) {
    to.setDateFrom(convertService.toValue(java.util.Date.class,from.getDateFrom()));
    to.setDateTo(convertService.toValue(java.util.Date.class,from.getDateTo()));
    to.setDepartment(convertService.toValue(com.fudanmed.platform.core.domain.RCMaintenanceTeam.class,from.getDepartment()));
    
  }
  
  public UIWorkItemTask4WorkersCriteria copyFromEntity(final UIWorkItemTask4WorkersCriteria result, final RCWorkItemTask4WorkersCriteria entity) {
    if(entity==null) return null;
    result.setDateFrom(convertService.toValue(java.util.Date.class,entity.getDateFrom()));
    result.setDateTo(convertService.toValue(java.util.Date.class,entity.getDateTo()));
    result.setDepartment(convertService.toValue(com.fudanmed.platform.core.domain.proxy.RCMaintenanceTeamProxy.class,entity.getDepartment()));
    return result;
    
  }
  
  public UIWorkItemTask4WorkersCriteria buildFrom(final RCWorkItemTask4WorkersCriteria entity) {
    if(entity==null) return null;
    com.fudanmed.platform.core.web.shared.project.UIWorkItemTask4WorkersCriteria result = new com.fudanmed.platform.core.web.shared.project.UIWorkItemTask4WorkersCriteria();
    copyFromEntity(result,entity);	
    return result;
    
  }
  
  public Class<?> getUIClass() {
    return UIWorkItemTask4WorkersCriteria.class;
  }
  
  public Class<?> getEntityClass() {
    return RCWorkItemTask4WorkersCriteria.class;
  }
}
