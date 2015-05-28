package com.fudanmed.platform.core.web.server.service.deliver;

import com.fudanmed.platform.core.deliver.DLPatientCheckDeliverTaskEvent;
import com.fudanmed.platform.core.web.shared.deliver.UIPatientCheckDeliverTaskEvent;
import com.uniquesoft.uidl.transform.AbstractEntityMapper;
import com.uniquesoft.uidl.transform.IConvertService;
import edu.fudan.mylang.pf.IObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("com.fudanmed.platform.core.web.server.service.deliver.PatientCheckDeliverTaskEventMapper")
public class PatientCheckDeliverTaskEventMapper extends AbstractEntityMapper<UIPatientCheckDeliverTaskEvent,DLPatientCheckDeliverTaskEvent> {
  @Autowired
  private IConvertService convertService;
  
  @Autowired
  private IObjectFactory entities;
  
  public DLPatientCheckDeliverTaskEvent loadEntityById(final Long id) {
    return entities.get(DLPatientCheckDeliverTaskEvent.class,id);
  }
  
  public DLPatientCheckDeliverTaskEvent create() {
    return entities.create(DLPatientCheckDeliverTaskEvent.class);
  }
  
  public void copyToEntity(final UIPatientCheckDeliverTaskEvent from, final DLPatientCheckDeliverTaskEvent to) {
    to.setVersion(from.getVersion());
    
  }
  
  public UIPatientCheckDeliverTaskEvent copyFromEntity(final UIPatientCheckDeliverTaskEvent result, final DLPatientCheckDeliverTaskEvent entity) {
    if(entity==null) return null;
    result.setId(entity.getId());
    result.setVersion(entity.getVersion());
    result.setProxy(entity.toProxy());
    result.setClazzName(entity.getClass().getName());
    result.setEventType(convertService.toValue(com.fudanmed.platform.core.web.shared.deliver.UIPatientCheckDeliverTaskEventType.class,entity.getEventType()));
    result.setCreateTime(convertService.toValue(java.util.Date.class,entity.getCreateTime()));
    result.setOperator(convertService.toValue(com.fudanmed.platform.core.domain.proxy.RCEmployeeProxy.class,entity.getOperator()));
    result.setDescription(convertService.toValue(java.lang.String.class,entity.getDescription()));
    return result;
    
  }
  
  public UIPatientCheckDeliverTaskEvent buildFrom(final DLPatientCheckDeliverTaskEvent entity) {
    if(entity==null) return null;
    com.fudanmed.platform.core.web.shared.deliver.UIPatientCheckDeliverTaskEvent result = new com.fudanmed.platform.core.web.shared.deliver.UIPatientCheckDeliverTaskEvent();
    copyFromEntity(result,entity);	
    return result;
    
  }
  
  public Class<?> getUIClass() {
    return UIPatientCheckDeliverTaskEvent.class;
  }
  
  public Class<?> getEntityClass() {
    return DLPatientCheckDeliverTaskEvent.class;
  }
}
