package com.fudanmed.platform.core.web.server.service.project;

import com.fudanmed.platform.core.domain.RCGroupTaskStatByTeamCriteriaData;
import com.fudanmed.platform.core.web.shared.project.UIGroupTaskStatByTeamCriteriaData;
import com.uniquesoft.uidl.transform.AbstractDataTypeMapper;
import com.uniquesoft.uidl.transform.IConvertService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("com.fudanmed.platform.core.web.server.service.project.GroupTaskStatByTeamCriteriaDataMapper")
public class GroupTaskStatByTeamCriteriaDataMapper extends AbstractDataTypeMapper<UIGroupTaskStatByTeamCriteriaData,RCGroupTaskStatByTeamCriteriaData> {
  @Autowired
  private IConvertService convertService;
  
  public void copyToEntity(final UIGroupTaskStatByTeamCriteriaData from, final RCGroupTaskStatByTeamCriteriaData to) {
    
  }
  
  public UIGroupTaskStatByTeamCriteriaData copyFromEntity(final UIGroupTaskStatByTeamCriteriaData result, final RCGroupTaskStatByTeamCriteriaData entity) {
    if(entity==null) return null;
    result.setCnt(convertService.toValue(java.lang.Long.class,entity.getCnt()));
    result.setTeam(convertService.toValue(com.fudanmed.platform.core.domain.proxy.RCMaintenanceTeamProxy.class,entity.getTeam()));
    return result;
    
  }
  
  public UIGroupTaskStatByTeamCriteriaData buildFrom(final RCGroupTaskStatByTeamCriteriaData entity) {
    if(entity==null) return null;
    com.fudanmed.platform.core.web.shared.project.UIGroupTaskStatByTeamCriteriaData result = new com.fudanmed.platform.core.web.shared.project.UIGroupTaskStatByTeamCriteriaData();
    copyFromEntity(result,entity);	
    return result;
    
  }
  
  public Class<?> getUIClass() {
    return UIGroupTaskStatByTeamCriteriaData.class;
  }
  
  public Class<?> getEntityClass() {
    return RCGroupTaskStatByTeamCriteriaData.class;
  }
}
