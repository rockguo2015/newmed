package com.fudanmed.platform.core.web.server.service.project;

import com.fudanmed.platform.core.domain.RCRepairTaskStatByFaultTypeCriteriaData;
import com.fudanmed.platform.core.web.shared.project.UIRepairTaskStatByFaultTypeCriteriaData;
import com.uniquesoft.uidl.transform.AbstractDataTypeMapper;
import com.uniquesoft.uidl.transform.IConvertService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("com.fudanmed.platform.core.web.server.service.project.RepairTaskStatByFaultTypeCriteriaDataMapper")
public class RepairTaskStatByFaultTypeCriteriaDataMapper extends AbstractDataTypeMapper<UIRepairTaskStatByFaultTypeCriteriaData,RCRepairTaskStatByFaultTypeCriteriaData> {
  @Autowired
  private IConvertService convertService;
  
  public void copyToEntity(final UIRepairTaskStatByFaultTypeCriteriaData from, final RCRepairTaskStatByFaultTypeCriteriaData to) {
    
  }
  
  public UIRepairTaskStatByFaultTypeCriteriaData copyFromEntity(final UIRepairTaskStatByFaultTypeCriteriaData result, final RCRepairTaskStatByFaultTypeCriteriaData entity) {
    if(entity==null) return null;
    result.setCnt(convertService.toValue(java.lang.Long.class,entity.getCnt()));
    result.setFaultType(convertService.toValue(com.fudanmed.platform.core.domain.proxy.RCFaultTypeProxy.class,entity.getFaultType()));
    return result;
    
  }
  
  public UIRepairTaskStatByFaultTypeCriteriaData buildFrom(final RCRepairTaskStatByFaultTypeCriteriaData entity) {
    if(entity==null) return null;
    com.fudanmed.platform.core.web.shared.project.UIRepairTaskStatByFaultTypeCriteriaData result = new com.fudanmed.platform.core.web.shared.project.UIRepairTaskStatByFaultTypeCriteriaData();
    copyFromEntity(result,entity);	
    return result;
    
  }
  
  public Class<?> getUIClass() {
    return UIRepairTaskStatByFaultTypeCriteriaData.class;
  }
  
  public Class<?> getEntityClass() {
    return RCRepairTaskStatByFaultTypeCriteriaData.class;
  }
}
