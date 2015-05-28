package com.fudanmed.platform.core.web.server.service.project;

import com.fudanmed.platform.core.domain.RCRepairTask4SettlementCriteria;
import com.fudanmed.platform.core.web.shared.project.UIRepairTask4SettlementCriteria;
import com.uniquesoft.uidl.transform.AbstractDataTypeMapper;
import com.uniquesoft.uidl.transform.IConvertService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("com.fudanmed.platform.core.web.server.service.project.RepairTask4SettlementCriteriaMapper")
public class RepairTask4SettlementCriteriaMapper extends AbstractDataTypeMapper<UIRepairTask4SettlementCriteria,RCRepairTask4SettlementCriteria> {
  @Autowired
  private IConvertService convertService;
  
  public void copyToEntity(final UIRepairTask4SettlementCriteria from, final RCRepairTask4SettlementCriteria to) {
    to.setFinishDateFrom(convertService.toValue(java.util.Date.class,from.getFinishDateFrom()));
    to.setFinishDateTo(convertService.toValue(java.util.Date.class,from.getFinishDateTo()));
    to.setTeam(convertService.toValue(com.fudanmed.platform.core.domain.RCMaintenanceTeam.class,from.getTeam()));
    to.setReportOrg(convertService.toValue(com.fudanmed.platform.core.domain.RCOrganization.class,from.getReportOrg()));
    copyToCust(from,to);
    
  }
  
  protected void copyToCust(final UIRepairTask4SettlementCriteria _gwt, final RCRepairTask4SettlementCriteria _entity) {
    _gwt.setHasMadeSettlement(Boolean.valueOf(false));
  }
  
  public UIRepairTask4SettlementCriteria copyFromEntity(final UIRepairTask4SettlementCriteria result, final RCRepairTask4SettlementCriteria entity) {
    if(entity==null) return null;
    result.setFinishDateFrom(convertService.toValue(java.util.Date.class,entity.getFinishDateFrom()));
    result.setFinishDateTo(convertService.toValue(java.util.Date.class,entity.getFinishDateTo()));
    result.setTeam(convertService.toValue(com.fudanmed.platform.core.domain.proxy.RCMaintenanceTeamProxy.class,entity.getTeam()));
    result.setReportOrg(convertService.toValue(com.fudanmed.platform.core.domain.proxy.RCOrganizationProxy.class,entity.getReportOrg()));
    return result;
    
  }
  
  public UIRepairTask4SettlementCriteria buildFrom(final RCRepairTask4SettlementCriteria entity) {
    if(entity==null) return null;
    com.fudanmed.platform.core.web.shared.project.UIRepairTask4SettlementCriteria result = new com.fudanmed.platform.core.web.shared.project.UIRepairTask4SettlementCriteria();
    copyFromEntity(result,entity);	
    return result;
    
  }
  
  public Class<?> getUIClass() {
    return UIRepairTask4SettlementCriteria.class;
  }
  
  public Class<?> getEntityClass() {
    return RCRepairTask4SettlementCriteria.class;
  }
}
