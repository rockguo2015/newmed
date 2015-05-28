package com.fudanmed.platform.core.web.server.service.project;

import com.fudanmed.platform.core.domain.RCWorkItemTask4WorkersStatCriteriaData;
import com.fudanmed.platform.core.web.shared.project.UIWorkItemTask4WorkersStatCriteriaData;
import com.uniquesoft.uidl.transform.AbstractDataTypeMapper;
import com.uniquesoft.uidl.transform.IConvertService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("com.fudanmed.platform.core.web.server.service.project.WorkItemTask4WorkersStatCriteriaDataMapper")
public class WorkItemTask4WorkersStatCriteriaDataMapper extends AbstractDataTypeMapper<UIWorkItemTask4WorkersStatCriteriaData,RCWorkItemTask4WorkersStatCriteriaData> {
  @Autowired
  private IConvertService convertService;
  
  public void copyToEntity(final UIWorkItemTask4WorkersStatCriteriaData from, final RCWorkItemTask4WorkersStatCriteriaData to) {
    
  }
  
  public UIWorkItemTask4WorkersStatCriteriaData copyFromEntity(final UIWorkItemTask4WorkersStatCriteriaData result, final RCWorkItemTask4WorkersStatCriteriaData entity) {
    if(entity==null) return null;
    result.setCnt(convertService.toValue(java.lang.Long.class,entity.getCnt()));
    result.setWorker(convertService.toValue(com.fudanmed.platform.core.domain.proxy.RCEmployeeProxy.class,entity.getWorker()));
    return result;
    
  }
  
  public UIWorkItemTask4WorkersStatCriteriaData buildFrom(final RCWorkItemTask4WorkersStatCriteriaData entity) {
    if(entity==null) return null;
    com.fudanmed.platform.core.web.shared.project.UIWorkItemTask4WorkersStatCriteriaData result = new com.fudanmed.platform.core.web.shared.project.UIWorkItemTask4WorkersStatCriteriaData();
    copyFromEntity(result,entity);	
    return result;
    
  }
  
  public Class<?> getUIClass() {
    return UIWorkItemTask4WorkersStatCriteriaData.class;
  }
  
  public Class<?> getEntityClass() {
    return RCWorkItemTask4WorkersStatCriteriaData.class;
  }
}
