package com.lanmon.business.server.service.message;

import com.lanmon.business.shared.message.GWTOutsourceDateTrigger;
import com.lanmon.workflow.business.OutsourceDateTrigger;
import com.uniquesoft.uidl.transform.AbstractEntityMapper;
import com.uniquesoft.uidl.transform.IConvertService;
import edu.fudan.mylang.pf.IObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("com.lanmon.business.server.service.message.OutsourceDateTriggerMapper")
public class OutsourceDateTriggerMapper extends AbstractEntityMapper<GWTOutsourceDateTrigger,OutsourceDateTrigger> {
  @Autowired
  private IConvertService convertService;
  
  @Autowired
  private IObjectFactory entities;
  
  public OutsourceDateTrigger loadEntityById(final Long id) {
    return entities.get(OutsourceDateTrigger.class,id);
  }
  
  public OutsourceDateTrigger create() {
    return entities.create(OutsourceDateTrigger.class);
  }
  
  public void copyToEntity(final GWTOutsourceDateTrigger from, final OutsourceDateTrigger to) {
    to.setNextTriggleDate(convertService.toValue(java.util.Date.class,from.getNextTriggleDate()));
    
  }
  
  public GWTOutsourceDateTrigger copyFromEntity(final GWTOutsourceDateTrigger result, final OutsourceDateTrigger entity) {
    if(entity==null) return null;
    result.setId(entity.getId());
    result.setCustomer(convertService.toValue(com.uniquesoft.gwt.shared.GWTNamedEntity.class,entity.getCustomer()));
    result.setNextTriggleDate(convertService.toValue(java.util.Date.class,entity.getNextTriggleDate()));
    return result;
    
  }
  
  public GWTOutsourceDateTrigger buildFrom(final OutsourceDateTrigger entity) {
    if(entity==null) return null;
    com.lanmon.business.shared.message.GWTOutsourceDateTrigger result = new com.lanmon.business.shared.message.GWTOutsourceDateTrigger();
    copyFromEntity(result,entity);	
    return result;
    
  }
  
  public Class<?> getUIClass() {
    return GWTOutsourceDateTrigger.class;
  }
  
  public Class<?> getEntityClass() {
    return OutsourceDateTrigger.class;
  }
}
