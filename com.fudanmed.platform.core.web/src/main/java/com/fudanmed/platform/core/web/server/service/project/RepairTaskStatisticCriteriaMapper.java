package com.fudanmed.platform.core.web.server.service.project;

import com.fudanmed.platform.core.domain.RCRepairTaskStatisticCriteria;
import com.fudanmed.platform.core.web.shared.project.UIRepairTaskStatisticCriteria;
import com.uniquesoft.gwt.shared.datatype.UIDateRange;
import com.uniquesoft.uidl.transform.AbstractDataTypeMapper;
import com.uniquesoft.uidl.transform.IConvertService;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("com.fudanmed.platform.core.web.server.service.project.RepairTaskStatisticCriteriaMapper")
public class RepairTaskStatisticCriteriaMapper extends AbstractDataTypeMapper<UIRepairTaskStatisticCriteria,RCRepairTaskStatisticCriteria> {
  @Autowired
  private IConvertService convertService;
  
  public void copyToEntity(final UIRepairTaskStatisticCriteria from, final RCRepairTaskStatisticCriteria to) {
    to.setReportOrg(convertService.toValue(com.fudanmed.platform.core.domain.RCOrganization.class,from.getReportOrg()));
    to.setTeam(convertService.toValue(com.fudanmed.platform.core.domain.RCMaintenanceTeam.class,from.getTeam()));
    to.setWorker(convertService.toValue(com.fudanmed.platform.core.domain.RCEmployee.class,from.getWorker()));
    to.setComment(convertService.toValue(java.lang.String.class,from.getComment()));
    to.setStatus(convertService.toValue(com.fudanmed.platform.core.domain.RCRepairTaskStatus.class,from.getStatus()));
    copyToCust(from,to);
    
  }
  
  protected void copyToCust(final UIRepairTaskStatisticCriteria _gwt, final RCRepairTaskStatisticCriteria _entity) {
    UIDateRange _reportDateRange = _gwt.getReportDateRange();
    Date _from = _reportDateRange.getFrom();
    _entity.setReportDateFrom(_from);
    UIDateRange _reportDateRange_1 = _gwt.getReportDateRange();
    Date _to = _reportDateRange_1.getTo();
    _entity.setReportDateTo(_to);
  }
  
  public UIRepairTaskStatisticCriteria copyFromEntity(final UIRepairTaskStatisticCriteria result, final RCRepairTaskStatisticCriteria entity) {
    if(entity==null) return null;
    result.setReportOrg(convertService.toValue(com.fudanmed.platform.core.domain.proxy.RCOrganizationProxy.class,entity.getReportOrg()));
    result.setTeam(convertService.toValue(com.fudanmed.platform.core.domain.proxy.RCMaintenanceTeamProxy.class,entity.getTeam()));
    result.setWorker(convertService.toValue(com.fudanmed.platform.core.domain.proxy.RCEmployeeProxy.class,entity.getWorker()));
    result.setComment(convertService.toValue(java.lang.String.class,entity.getComment()));
    result.setStatus(convertService.toValue(com.fudanmed.platform.core.web.shared.project.UIRepairTaskStatus.class,entity.getStatus()));
    return result;
    
  }
  
  public UIRepairTaskStatisticCriteria buildFrom(final RCRepairTaskStatisticCriteria entity) {
    if(entity==null) return null;
    com.fudanmed.platform.core.web.shared.project.UIRepairTaskStatisticCriteria result = new com.fudanmed.platform.core.web.shared.project.UIRepairTaskStatisticCriteria();
    copyFromEntity(result,entity);	
    return result;
    
  }
  
  public Class<?> getUIClass() {
    return UIRepairTaskStatisticCriteria.class;
  }
  
  public Class<?> getEntityClass() {
    return RCRepairTaskStatisticCriteria.class;
  }
}
