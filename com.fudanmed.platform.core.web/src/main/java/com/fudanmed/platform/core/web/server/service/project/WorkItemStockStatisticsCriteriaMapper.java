package com.fudanmed.platform.core.web.server.service.project;

import com.fudanmed.platform.core.warehouse.RCWorkItemStockStatisticsCriteria;
import com.fudanmed.platform.core.web.shared.project.UIWorkItemStockStatisticsCriteria;
import com.uniquesoft.uidl.transform.AbstractDataTypeMapper;
import com.uniquesoft.uidl.transform.IConvertService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("com.fudanmed.platform.core.web.server.service.project.WorkItemStockStatisticsCriteriaMapper")
public class WorkItemStockStatisticsCriteriaMapper extends AbstractDataTypeMapper<UIWorkItemStockStatisticsCriteria,RCWorkItemStockStatisticsCriteria> {
  @Autowired
  private IConvertService convertService;
  
  public void copyToEntity(final UIWorkItemStockStatisticsCriteria from, final RCWorkItemStockStatisticsCriteria to) {
    to.setReportDateFrom(convertService.toValue(java.util.Date.class,from.getReportDateFrom()));
    to.setReportDateTo(convertService.toValue(java.util.Date.class,from.getReportDateTo()));
    to.setTeam(convertService.toValue(com.fudanmed.platform.core.domain.RCMaintenanceTeam.class,from.getTeam()));
    to.setReportOrg(convertService.toValue(com.fudanmed.platform.core.domain.RCOrganization.class,from.getReportOrg()));
    
  }
  
  public UIWorkItemStockStatisticsCriteria copyFromEntity(final UIWorkItemStockStatisticsCriteria result, final RCWorkItemStockStatisticsCriteria entity) {
    if(entity==null) return null;
    result.setReportDateFrom(convertService.toValue(java.util.Date.class,entity.getReportDateFrom()));
    result.setReportDateTo(convertService.toValue(java.util.Date.class,entity.getReportDateTo()));
    result.setTeam(convertService.toValue(com.fudanmed.platform.core.domain.proxy.RCMaintenanceTeamProxy.class,entity.getTeam()));
    result.setReportOrg(convertService.toValue(com.fudanmed.platform.core.domain.proxy.RCOrganizationProxy.class,entity.getReportOrg()));
    return result;
    
  }
  
  public UIWorkItemStockStatisticsCriteria buildFrom(final RCWorkItemStockStatisticsCriteria entity) {
    if(entity==null) return null;
    com.fudanmed.platform.core.web.shared.project.UIWorkItemStockStatisticsCriteria result = new com.fudanmed.platform.core.web.shared.project.UIWorkItemStockStatisticsCriteria();
    copyFromEntity(result,entity);	
    return result;
    
  }
  
  public Class<?> getUIClass() {
    return UIWorkItemStockStatisticsCriteria.class;
  }
  
  public Class<?> getEntityClass() {
    return RCWorkItemStockStatisticsCriteria.class;
  }
}
