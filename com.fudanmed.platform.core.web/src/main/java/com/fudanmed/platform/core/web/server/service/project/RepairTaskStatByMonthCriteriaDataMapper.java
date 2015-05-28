package com.fudanmed.platform.core.web.server.service.project;

import com.fudanmed.platform.core.domain.RCRepairTaskStatByMonthCriteriaData;
import com.fudanmed.platform.core.web.shared.project.UIRepairTaskStatByMonthCriteriaData;
import com.uniquesoft.uidl.transform.AbstractDataTypeMapper;
import com.uniquesoft.uidl.transform.IConvertService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("com.fudanmed.platform.core.web.server.service.project.RepairTaskStatByMonthCriteriaDataMapper")
public class RepairTaskStatByMonthCriteriaDataMapper extends AbstractDataTypeMapper<UIRepairTaskStatByMonthCriteriaData,RCRepairTaskStatByMonthCriteriaData> {
  @Autowired
  private IConvertService convertService;
  
  public void copyToEntity(final UIRepairTaskStatByMonthCriteriaData from, final RCRepairTaskStatByMonthCriteriaData to) {
    
  }
  
  public UIRepairTaskStatByMonthCriteriaData copyFromEntity(final UIRepairTaskStatByMonthCriteriaData result, final RCRepairTaskStatByMonthCriteriaData entity) {
    if(entity==null) return null;
    result.setCnt(convertService.toValue(java.lang.Long.class,entity.getCnt()));
    result.setMonth(convertService.toValue(java.lang.String.class,entity.getMonth()));
    return result;
    
  }
  
  public UIRepairTaskStatByMonthCriteriaData buildFrom(final RCRepairTaskStatByMonthCriteriaData entity) {
    if(entity==null) return null;
    com.fudanmed.platform.core.web.shared.project.UIRepairTaskStatByMonthCriteriaData result = new com.fudanmed.platform.core.web.shared.project.UIRepairTaskStatByMonthCriteriaData();
    copyFromEntity(result,entity);	
    return result;
    
  }
  
  public Class<?> getUIClass() {
    return UIRepairTaskStatByMonthCriteriaData.class;
  }
  
  public Class<?> getEntityClass() {
    return RCRepairTaskStatByMonthCriteriaData.class;
  }
}
