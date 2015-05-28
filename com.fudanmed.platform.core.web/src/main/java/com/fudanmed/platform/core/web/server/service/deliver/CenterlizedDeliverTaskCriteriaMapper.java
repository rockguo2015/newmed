package com.fudanmed.platform.core.web.server.service.deliver;

import com.fudanmed.platform.core.deliver.DLCenterlizedDeliverTaskCriteria;
import com.fudanmed.platform.core.web.shared.deliver.UICenterlizedDeliverTaskCriteria;
import com.uniquesoft.uidl.transform.AbstractDataTypeMapper;
import com.uniquesoft.uidl.transform.IConvertService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("com.fudanmed.platform.core.web.server.service.deliver.CenterlizedDeliverTaskCriteriaMapper")
public class CenterlizedDeliverTaskCriteriaMapper extends AbstractDataTypeMapper<UICenterlizedDeliverTaskCriteria,DLCenterlizedDeliverTaskCriteria> {
  @Autowired
  private IConvertService convertService;
  
  public void copyToEntity(final UICenterlizedDeliverTaskCriteria from, final DLCenterlizedDeliverTaskCriteria to) {
    to.setSid(convertService.toValue(java.lang.String.class,from.getSid()));
    to.setCreateTimeFrom(convertService.toValue(java.util.Date.class,from.getCreateTimeFrom()));
    to.setCreateTimeTo(convertService.toValue(java.util.Date.class,from.getCreateTimeTo()));
    to.setPerformer(convertService.toValue(com.fudanmed.platform.core.domain.RCEmployee.class,from.getPerformer()));
    to.setTaskSourceType(convertService.toValue(com.fudanmed.platform.core.deliver.DLTaskSourceType.class,from.getTaskSourceType()));
    
  }
  
  public UICenterlizedDeliverTaskCriteria copyFromEntity(final UICenterlizedDeliverTaskCriteria result, final DLCenterlizedDeliverTaskCriteria entity) {
    if(entity==null) return null;
    result.setSid(convertService.toValue(java.lang.String.class,entity.getSid()));
    result.setCreateTimeFrom(convertService.toValue(java.util.Date.class,entity.getCreateTimeFrom()));
    result.setCreateTimeTo(convertService.toValue(java.util.Date.class,entity.getCreateTimeTo()));
    result.setPerformer(convertService.toValue(com.fudanmed.platform.core.domain.proxy.RCEmployeeProxy.class,entity.getPerformer()));
    result.setTaskSourceType(convertService.toValue(com.fudanmed.platform.core.web.shared.deliver.UITaskSourceType.class,entity.getTaskSourceType()));
    return result;
    
  }
  
  public UICenterlizedDeliverTaskCriteria buildFrom(final DLCenterlizedDeliverTaskCriteria entity) {
    if(entity==null) return null;
    com.fudanmed.platform.core.web.shared.deliver.UICenterlizedDeliverTaskCriteria result = new com.fudanmed.platform.core.web.shared.deliver.UICenterlizedDeliverTaskCriteria();
    copyFromEntity(result,entity);	
    return result;
    
  }
  
  public Class<?> getUIClass() {
    return UICenterlizedDeliverTaskCriteria.class;
  }
  
  public Class<?> getEntityClass() {
    return DLCenterlizedDeliverTaskCriteria.class;
  }
}
