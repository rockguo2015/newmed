package com.lanmon.business.server.service.message;

import com.lanmon.business.shared.message.GWTPeriodicTrigger;
import com.lanmon.workflow.business.PeriodicCustomerTrigger;
import com.uniquesoft.uidl.transform.AbstractEntityMapper;
import com.uniquesoft.uidl.transform.IConvertService;
import edu.fudan.mylang.pf.IObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("com.lanmon.business.server.service.message.PeriodicTriggerMapper")
public class PeriodicTriggerMapper extends AbstractEntityMapper<GWTPeriodicTrigger,PeriodicCustomerTrigger> {
  @Autowired
  private IConvertService convertService;
  
  @Autowired
  private IObjectFactory entities;
  
  public PeriodicCustomerTrigger loadEntityById(final Long id) {
    return entities.get(PeriodicCustomerTrigger.class,id);
  }
  
  public PeriodicCustomerTrigger create() {
    return entities.create(PeriodicCustomerTrigger.class);
  }
  
  public void copyToEntity(final GWTPeriodicTrigger from, final PeriodicCustomerTrigger to) {
    to.setMessage(convertService.toValue(java.lang.String.class,from.getMessage()));
    to.setTimeInterval(convertService.toValue(java.lang.Integer.class,from.getTimeInterval()));
    to.setUnit(convertService.toValue(com.lanmon.workflow.business.PeriodicUnit.class,from.getUnit()));
    to.setNextTriggleDate(convertService.toValue(java.util.Date.class,from.getTriggerDate()));
    
  }
  
  public GWTPeriodicTrigger copyFromEntity(final GWTPeriodicTrigger result, final PeriodicCustomerTrigger entity) {
    if(entity==null) return null;
    result.setId(entity.getId());
    result.setMessage(convertService.toValue(java.lang.String.class,entity.getMessage()));
    result.setTimeInterval(convertService.toValue(java.lang.Integer.class,entity.getTimeInterval()));
    result.setUnit(convertService.toValue(com.lanmon.business.shared.message.GWTPeriodicUnit.class,entity.getUnit()));
    	result.setTriggerDate(convertService.toValue(java.util.Date.class,entity.getNextTriggleDate()));
    return result;
    
  }
  
  public GWTPeriodicTrigger buildFrom(final PeriodicCustomerTrigger entity) {
    if(entity==null) return null;
    com.lanmon.business.shared.message.GWTPeriodicTrigger result = new com.lanmon.business.shared.message.GWTPeriodicTrigger();
    copyFromEntity(result,entity);	
    return result;
    
  }
  
  public Class<?> getUIClass() {
    return GWTPeriodicTrigger.class;
  }
  
  public Class<?> getEntityClass() {
    return PeriodicCustomerTrigger.class;
  }
}
