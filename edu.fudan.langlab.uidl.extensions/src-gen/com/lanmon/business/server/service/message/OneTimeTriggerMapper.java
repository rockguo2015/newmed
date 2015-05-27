package com.lanmon.business.server.service.message;

import com.lanmon.business.shared.message.GWTOneTimeTrigger;
import com.lanmon.workflow.business.OneTimeTrigger;
import com.uniquesoft.uidl.transform.AbstractEntityMapper;
import com.uniquesoft.uidl.transform.IConvertService;
import edu.fudan.mylang.pf.IObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("com.lanmon.business.server.service.message.OneTimeTriggerMapper")
public class OneTimeTriggerMapper extends AbstractEntityMapper<GWTOneTimeTrigger,OneTimeTrigger> {
  @Autowired
  private IConvertService convertService;
  
  @Autowired
  private IObjectFactory entities;
  
  public OneTimeTrigger loadEntityById(final Long id) {
    return entities.get(OneTimeTrigger.class,id);
  }
  
  public OneTimeTrigger create() {
    return entities.create(OneTimeTrigger.class);
  }
  
  public void copyToEntity(final GWTOneTimeTrigger from, final OneTimeTrigger to) {
    to.setMessage(convertService.toValue(java.lang.String.class,from.getMessage()));
    to.setNextTriggleDate(convertService.toValue(java.util.Date.class,from.getTriggerDate()));
    
  }
  
  public GWTOneTimeTrigger copyFromEntity(final GWTOneTimeTrigger result, final OneTimeTrigger entity) {
    if(entity==null) return null;
    result.setId(entity.getId());
    result.setMessage(convertService.toValue(java.lang.String.class,entity.getMessage()));
    	result.setTriggerDate(convertService.toValue(java.util.Date.class,entity.getNextTriggleDate()));
    return result;
    
  }
  
  public GWTOneTimeTrigger buildFrom(final OneTimeTrigger entity) {
    if(entity==null) return null;
    com.lanmon.business.shared.message.GWTOneTimeTrigger result = new com.lanmon.business.shared.message.GWTOneTimeTrigger();
    copyFromEntity(result,entity);	
    return result;
    
  }
  
  public Class<?> getUIClass() {
    return GWTOneTimeTrigger.class;
  }
  
  public Class<?> getEntityClass() {
    return OneTimeTrigger.class;
  }
}
