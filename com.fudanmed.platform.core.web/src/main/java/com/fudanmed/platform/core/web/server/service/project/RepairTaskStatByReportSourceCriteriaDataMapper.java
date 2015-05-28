package com.fudanmed.platform.core.web.server.service.project;

import com.fudanmed.platform.core.domain.RCRepairTaskStatByReportSourceCriteriaData;
import com.fudanmed.platform.core.web.shared.project.UIRepairTaskStatByReportSourceCriteriaData;
import com.uniquesoft.uidl.transform.AbstractDataTypeMapper;
import com.uniquesoft.uidl.transform.IConvertService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("com.fudanmed.platform.core.web.server.service.project.RepairTaskStatByReportSourceCriteriaDataMapper")
public class RepairTaskStatByReportSourceCriteriaDataMapper extends AbstractDataTypeMapper<UIRepairTaskStatByReportSourceCriteriaData,RCRepairTaskStatByReportSourceCriteriaData> {
  @Autowired
  private IConvertService convertService;
  
  public void copyToEntity(final UIRepairTaskStatByReportSourceCriteriaData from, final RCRepairTaskStatByReportSourceCriteriaData to) {
    
  }
  
  public UIRepairTaskStatByReportSourceCriteriaData copyFromEntity(final UIRepairTaskStatByReportSourceCriteriaData result, final RCRepairTaskStatByReportSourceCriteriaData entity) {
    if(entity==null) return null;
    result.setCnt(convertService.toValue(java.lang.Long.class,entity.getCnt()));
    result.setFaultReportSource(convertService.toValue(com.fudanmed.platform.core.common.proxy.RCFaultReportSourceProxy.class,entity.getFaultReportSource()));
    return result;
    
  }
  
  public UIRepairTaskStatByReportSourceCriteriaData buildFrom(final RCRepairTaskStatByReportSourceCriteriaData entity) {
    if(entity==null) return null;
    com.fudanmed.platform.core.web.shared.project.UIRepairTaskStatByReportSourceCriteriaData result = new com.fudanmed.platform.core.web.shared.project.UIRepairTaskStatByReportSourceCriteriaData();
    copyFromEntity(result,entity);	
    return result;
    
  }
  
  public Class<?> getUIClass() {
    return UIRepairTaskStatByReportSourceCriteriaData.class;
  }
  
  public Class<?> getEntityClass() {
    return RCRepairTaskStatByReportSourceCriteriaData.class;
  }
}
