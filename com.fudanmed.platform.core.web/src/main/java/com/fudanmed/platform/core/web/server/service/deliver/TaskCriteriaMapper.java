package com.fudanmed.platform.core.web.server.service.deliver;

import com.fudanmed.platform.core.deliver.DLTaskCriteria;
import com.fudanmed.platform.core.web.shared.deliver.UITaskCriteria;
import com.uniquesoft.uidl.transform.AbstractDataTypeMapper;
import com.uniquesoft.uidl.transform.IConvertService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("com.fudanmed.platform.core.web.server.service.deliver.TaskCriteriaMapper")
public class TaskCriteriaMapper extends AbstractDataTypeMapper<UITaskCriteria,DLTaskCriteria> {
  @Autowired
  private IConvertService convertService;
  
  public void copyToEntity(final UITaskCriteria from, final DLTaskCriteria to) {
    to.setSid(convertService.toValue(java.lang.String.class,from.getSid()));
    to.setCreateTimeFrom(convertService.toValue(java.util.Date.class,from.getCreateTimeFrom()));
    to.setCreateTimeTo(convertService.toValue(java.util.Date.class,from.getCreateTimeTo()));
    to.setPerformer(convertService.toValue(com.fudanmed.platform.core.domain.RCEmployee.class,from.getPerformer()));
    to.setTaskSourceType(convertService.toValue(com.fudanmed.platform.core.deliver.DLTaskSourceType.class,from.getTaskSourceType()));
    
  }
  
  public UITaskCriteria copyFromEntity(final UITaskCriteria result, final DLTaskCriteria entity) {
    if(entity==null) return null;
    result.setSid(convertService.toValue(java.lang.String.class,entity.getSid()));
    result.setCreateTimeFrom(convertService.toValue(java.util.Date.class,entity.getCreateTimeFrom()));
    result.setCreateTimeTo(convertService.toValue(java.util.Date.class,entity.getCreateTimeTo()));
    result.setPerformer(convertService.toValue(com.fudanmed.platform.core.domain.proxy.RCEmployeeProxy.class,entity.getPerformer()));
    result.setTaskSourceType(convertService.toValue(com.fudanmed.platform.core.web.shared.deliver.UITaskSourceType.class,entity.getTaskSourceType()));
    return result;
    
  }
  
  public UITaskCriteria buildFrom(final DLTaskCriteria entity) {
    if(entity==null) return null;
    com.fudanmed.platform.core.web.shared.deliver.UITaskCriteria result = new com.fudanmed.platform.core.web.shared.deliver.UITaskCriteria();
    copyFromEntity(result,entity);	
    return result;
    
  }
  
  public Class<?> getUIClass() {
    return UITaskCriteria.class;
  }
  
  public Class<?> getEntityClass() {
    return DLTaskCriteria.class;
  }
}
