package com.fudanmed.platform.core.web.server.service.project;

import com.fudanmed.platform.core.domain.RCOrganization;
import com.fudanmed.platform.core.domain.RCRepairTaskStatByOrganizationTypeCriteriaData;
import com.fudanmed.platform.core.web.shared.project.UIRepairTaskStatByOrganizationTypeCriteriaData;
import com.uniquesoft.uidl.transform.AbstractDataTypeMapper;
import com.uniquesoft.uidl.transform.IConvertService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("com.fudanmed.platform.core.web.server.service.project.RepairTaskStatByOrganizationTypeCriteriaDataMapper")
public class RepairTaskStatByOrganizationTypeCriteriaDataMapper extends AbstractDataTypeMapper<UIRepairTaskStatByOrganizationTypeCriteriaData,RCRepairTaskStatByOrganizationTypeCriteriaData> {
  @Autowired
  private IConvertService convertService;
  
  public void copyToEntity(final UIRepairTaskStatByOrganizationTypeCriteriaData from, final RCRepairTaskStatByOrganizationTypeCriteriaData to) {
    
  }
  
  public UIRepairTaskStatByOrganizationTypeCriteriaData copyFromEntity(final UIRepairTaskStatByOrganizationTypeCriteriaData result, final RCRepairTaskStatByOrganizationTypeCriteriaData entity) {
    if(entity==null) return null;
    result.setCnt(convertService.toValue(java.lang.Long.class,entity.getCnt()));
    result.setReportOrg(convertService.toValue(com.fudanmed.platform.core.domain.proxy.RCOrganizationProxy.class,entity.getReportOrg()));
    buildFromCust(result,entity);
    return result;
    
  }
  
  public UIRepairTaskStatByOrganizationTypeCriteriaData buildFrom(final RCRepairTaskStatByOrganizationTypeCriteriaData entity) {
    if(entity==null) return null;
    com.fudanmed.platform.core.web.shared.project.UIRepairTaskStatByOrganizationTypeCriteriaData result = new com.fudanmed.platform.core.web.shared.project.UIRepairTaskStatByOrganizationTypeCriteriaData();
    copyFromEntity(result,entity);	
    return result;
    
  }
  
  protected void buildFromCust(final UIRepairTaskStatByOrganizationTypeCriteriaData _gwt, final RCRepairTaskStatByOrganizationTypeCriteriaData _entity) {
    RCOrganization _reportOrg = _entity.getReportOrg();
    String _fullPath = _reportOrg.fullPath();
    _gwt.setFullPathReportOrg(_fullPath);
  }
  
  public Class<?> getUIClass() {
    return UIRepairTaskStatByOrganizationTypeCriteriaData.class;
  }
  
  public Class<?> getEntityClass() {
    return RCRepairTaskStatByOrganizationTypeCriteriaData.class;
  }
}
