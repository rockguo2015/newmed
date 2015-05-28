package com.fudanmed.platform.core.web.server.service.deliver;

import com.fudanmed.platform.core.deliver.DLCenterlizedDeliverTask;
import com.fudanmed.platform.core.web.server.service.deliver.CenterlizedDeliverTaskValidator;
import com.fudanmed.platform.core.web.shared.deliver.UICenterlizedDeliverTask;
import com.uniquesoft.uidl.transform.AbstractEntityMapper;
import com.uniquesoft.uidl.transform.IConvertService;
import edu.fudan.mylang.pf.IObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("com.fudanmed.platform.core.web.server.service.deliver.CenterlizedDeliverTaskMapper")
public class CenterlizedDeliverTaskMapper extends AbstractEntityMapper<UICenterlizedDeliverTask,DLCenterlizedDeliverTask> {
  @Autowired
  private IConvertService convertService;
  
  @Autowired
  private IObjectFactory entities;
  
  public DLCenterlizedDeliverTask loadEntityById(final Long id) {
    return entities.get(DLCenterlizedDeliverTask.class,id);
  }
  
  public DLCenterlizedDeliverTask create() {
    return entities.create(DLCenterlizedDeliverTask.class);
  }
  
  @Autowired
  private CenterlizedDeliverTaskValidator validator;
  
  public void copyToEntity(final UICenterlizedDeliverTask from, final DLCenterlizedDeliverTask to) {
    java.util.Collection<com.uniquesoft.gwt.shared.validation.ValidationErrorItem> errors = validator.validate(from);
    if(errors.size()!=0)throw new com.uniquesoft.gwt.shared.validation.ValidationException(errors);					
    to.setVersion(from.getVersion());
    to.setSid(convertService.toValue(java.lang.String.class,from.getSid()));
    to.setCreateTime(convertService.toValue(java.util.Date.class,from.getCreateTime()));
    to.setSubject(convertService.toValue(com.fudanmed.platform.core.deliver.DLDeliverSubject.class,from.getSubject()));
    convertService.toProxyEntity(from.getPerformers(),to.getPerformers(),com.fudanmed.platform.core.domain.RCEmployee.class);
    convertService.toProxyEntity(from.getResources(),to.getResources(),com.fudanmed.platform.core.deliver.DLResource.class);
    to.getTaskSource().setType(convertService.toValue(com.fudanmed.platform.core.deliver.DLTaskSourceType.class,from.getTaskSourceType()));
    to.setOperator(convertService.toValue(com.fudanmed.platform.core.domain.RCEmployee.class,from.getOperator()));
    
  }
  
  public UICenterlizedDeliverTask copyFromEntity(final UICenterlizedDeliverTask result, final DLCenterlizedDeliverTask entity) {
    if(entity==null) return null;
    result.setId(entity.getId());
    result.setVersion(entity.getVersion());
    result.setProxy(entity.toProxy());
    result.setClazzName(entity.getClass().getName());
    result.setSid(convertService.toValue(java.lang.String.class,entity.getSid()));
    result.setCreateTime(convertService.toValue(java.util.Date.class,entity.getCreateTime()));
    if(entity. getPlanDateTime()  != null )
    	result.setPlanDate(convertService.toValue(java.util.Date.class,entity.getPlanDateTime().getPlanDate()));
    if(entity. getPlanDateTime()  != null )
    	result.setPlanTime(convertService.toValue(java.util.Date.class,entity.getPlanDateTime().getPlanTime()));
    result.setSubject(convertService.toValue(com.fudanmed.platform.core.deliver.proxy.DLDeliverSubjectProxy.class,entity.getSubject()));
    result.setPerformers(convertService.toCollectionValue(com.fudanmed.platform.core.domain.proxy.RCEmployeeProxy.class,entity.getPerformers()));
    result.setResources(convertService.toCollectionValue(com.fudanmed.platform.core.deliver.proxy.DLResourceProxy.class,entity.getResources()));
    if(entity. getTaskSource()  != null )
    	result.setTaskSourceType(convertService.toValue(com.fudanmed.platform.core.web.shared.deliver.UITaskSourceType.class,entity.getTaskSource().getType()));
    result.setOperator(convertService.toValue(com.fudanmed.platform.core.domain.proxy.RCEmployeeProxy.class,entity.getOperator()));
    result.setStatus(convertService.toValue(com.fudanmed.platform.core.web.shared.deliver.UICenterlizedDeliverTaskStatus.class,entity.getStatus()));
    return result;
    
  }
  
  public UICenterlizedDeliverTask buildFrom(final DLCenterlizedDeliverTask entity) {
    if(entity==null) return null;
    com.fudanmed.platform.core.web.shared.deliver.UICenterlizedDeliverTask result = new com.fudanmed.platform.core.web.shared.deliver.UICenterlizedDeliverTask();
    copyFromEntity(result,entity);	
    return result;
    
  }
  
  public Class<?> getUIClass() {
    return UICenterlizedDeliverTask.class;
  }
  
  public Class<?> getEntityClass() {
    return DLCenterlizedDeliverTask.class;
  }
}
