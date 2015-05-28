package com.fudanmed.platform.core.web.server.service.project;

import com.fudanmed.platform.core.warehouse.RCWorkItemStockRecordItemStatCriteria;
import com.fudanmed.platform.core.web.shared.project.UIWorkItemStockRecordItemStatCriteria;
import com.uniquesoft.uidl.transform.AbstractDataTypeMapper;
import com.uniquesoft.uidl.transform.IConvertService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("com.fudanmed.platform.core.web.server.service.project.WorkItemStockRecordItemStatCriteriaMapper")
public class WorkItemStockRecordItemStatCriteriaMapper extends AbstractDataTypeMapper<UIWorkItemStockRecordItemStatCriteria,RCWorkItemStockRecordItemStatCriteria> {
  @Autowired
  private IConvertService convertService;
  
  public void copyToEntity(final UIWorkItemStockRecordItemStatCriteria from, final RCWorkItemStockRecordItemStatCriteria to) {
    to.setDateFrom(convertService.toValue(java.util.Date.class,from.getDateFrom()));
    to.setDateTo(convertService.toValue(java.util.Date.class,from.getDateTo()));
    to.setTeam(convertService.toValue(com.fudanmed.platform.core.domain.RCMaintenanceTeam.class,from.getTeam()));
    
  }
  
  public UIWorkItemStockRecordItemStatCriteria copyFromEntity(final UIWorkItemStockRecordItemStatCriteria result, final RCWorkItemStockRecordItemStatCriteria entity) {
    if(entity==null) return null;
    result.setDateFrom(convertService.toValue(java.util.Date.class,entity.getDateFrom()));
    result.setDateTo(convertService.toValue(java.util.Date.class,entity.getDateTo()));
    result.setTeam(convertService.toValue(com.fudanmed.platform.core.domain.proxy.RCMaintenanceTeamProxy.class,entity.getTeam()));
    return result;
    
  }
  
  public UIWorkItemStockRecordItemStatCriteria buildFrom(final RCWorkItemStockRecordItemStatCriteria entity) {
    if(entity==null) return null;
    com.fudanmed.platform.core.web.shared.project.UIWorkItemStockRecordItemStatCriteria result = new com.fudanmed.platform.core.web.shared.project.UIWorkItemStockRecordItemStatCriteria();
    copyFromEntity(result,entity);	
    return result;
    
  }
  
  public Class<?> getUIClass() {
    return UIWorkItemStockRecordItemStatCriteria.class;
  }
  
  public Class<?> getEntityClass() {
    return RCWorkItemStockRecordItemStatCriteria.class;
  }
}
