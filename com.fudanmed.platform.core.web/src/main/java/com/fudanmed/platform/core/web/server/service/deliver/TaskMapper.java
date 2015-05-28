package com.fudanmed.platform.core.web.server.service.deliver;

import com.fudanmed.platform.core.deliver.DLTask;
import com.fudanmed.platform.core.web.shared.deliver.UITask;
import com.uniquesoft.uidl.transform.AbstractEntityMapper;
import com.uniquesoft.uidl.transform.IConvertService;
import edu.fudan.mylang.pf.IObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("com.fudanmed.platform.core.web.server.service.deliver.TaskMapper")
public class TaskMapper extends AbstractEntityMapper<UITask,DLTask> {
  @Autowired
  private IConvertService convertService;
  
  @Autowired
  private IObjectFactory entities;
  
  public DLTask loadEntityById(final Long id) {
    return entities.get(DLTask.class,id);
  }
  
  public DLTask create() {
    return entities.create(DLTask.class);
  }
  
  public void copyToEntity(final UITask from, final DLTask to) {
    to.setVersion(from.getVersion());
    
  }
  
  public UITask copyFromEntity(final UITask result, final DLTask entity) {
    if(entity==null) return null;
    result.setId(entity.getId());
    result.setVersion(entity.getVersion());
    result.setProxy(entity.toProxy());
    result.setClazzName(entity.getClass().getName());
    result.setSid(convertService.toValue(java.lang.String.class,entity.getSid()));
    result.setCreateTime(convertService.toValue(java.util.Date.class,entity.getCreateTime()));
    result.setPerformers(convertService.toCollectionValue(com.fudanmed.platform.core.domain.proxy.RCEmployeeProxy.class,entity.getPerformers()));
    result.setOperator(convertService.toValue(com.fudanmed.platform.core.domain.proxy.RCEmployeeProxy.class,entity.getOperator()));
    if(entity. getTaskSource()  != null )
    	result.setTaskSource(convertService.toValue(com.fudanmed.platform.core.web.shared.deliver.UITaskSourceType.class,entity.getTaskSource().getType()));
    return result;
    
  }
  
  public UITask buildFrom(final DLTask entity) {
    if(entity==null) return null;
    com.fudanmed.platform.core.web.shared.deliver.UITask result = new com.fudanmed.platform.core.web.shared.deliver.UITask();
    copyFromEntity(result,entity);	
    return result;
    
  }
  
  public Class<?> getUIClass() {
    return UITask.class;
  }
  
  public Class<?> getEntityClass() {
    return DLTask.class;
  }
}
