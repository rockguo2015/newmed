package com.lanmon.business.server.service.message;

import com.lanmon.business.server.service.message.ContractDateTriggerValidator;
import com.lanmon.business.shared.message.GWTContractDateTrigger;
import com.lanmon.workflow.business.ContractDateTrigger;
import com.uniquesoft.uidl.transform.AbstractEntityMapper;
import com.uniquesoft.uidl.transform.IConvertService;
import edu.fudan.mylang.pf.IObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("com.lanmon.business.server.service.message.ContractDateTriggerMapper")
public class ContractDateTriggerMapper extends AbstractEntityMapper<GWTContractDateTrigger,ContractDateTrigger> {
  @Autowired
  private IConvertService convertService;
  
  @Autowired
  private IObjectFactory entities;
  
  public ContractDateTrigger loadEntityById(final Long id) {
    return entities.get(ContractDateTrigger.class,id);
  }
  
  public ContractDateTrigger create() {
    return entities.create(ContractDateTrigger.class);
  }
  
  @Autowired
  private ContractDateTriggerValidator validator;
  
  public void copyToEntity(final GWTContractDateTrigger from, final ContractDateTrigger to) {
    java.util.Collection<com.uniquesoft.gwt.shared.validation.ValidationErrorItem> errors = validator.validate(from);
    if(errors.size()!=0)throw new com.uniquesoft.gwt.shared.validation.ValidationException(errors);					
    to.setType(convertService.toValue(com.lanmon.workflow.business.ContractDateTriggerType.class,from.getType()));
    to.setNextTriggleDate(convertService.toValue(java.util.Date.class,from.getTriggerDate()));
    
  }
  
  public GWTContractDateTrigger copyFromEntity(final GWTContractDateTrigger result, final ContractDateTrigger entity) {
    if(entity==null) return null;
    result.setId(entity.getId());
    result.setType(convertService.toValue(com.lanmon.business.shared.message.GWTContractDateTriggerType.class,entity.getType()));
    	result.setTriggerDate(convertService.toValue(java.util.Date.class,entity.getNextTriggleDate()));
    result.setCustomer(convertService.toValue(com.uniquesoft.gwt.shared.GWTNamedEntity.class,entity.getCustomer()));
    return result;
    
  }
  
  public GWTContractDateTrigger buildFrom(final ContractDateTrigger entity) {
    if(entity==null) return null;
    com.lanmon.business.shared.message.GWTContractDateTrigger result = new com.lanmon.business.shared.message.GWTContractDateTrigger();
    copyFromEntity(result,entity);	
    return result;
    
  }
  
  public Class<?> getUIClass() {
    return GWTContractDateTrigger.class;
  }
  
  public Class<?> getEntityClass() {
    return ContractDateTrigger.class;
  }
}
