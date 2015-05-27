package com.lanmon.business.server.service.message;

import com.lanmon.business.shared.message.GWTMessageTrigger;
import com.lanmon.business.shared.message.TriggerType;
import com.lanmon.workflow.business.ContractDateTrigger;
import com.lanmon.workflow.business.MessageTrigger;
import com.lanmon.workflow.business.OneTimeTrigger;
import com.lanmon.workflow.business.OutsourceDateTrigger;
import com.lanmon.workflow.business.PeriodicCustomerTrigger;
import com.uniquesoft.uidl.transform.AbstractEntityMapper;
import com.uniquesoft.uidl.transform.IConvertService;
import edu.fudan.mylang.pf.IObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("com.lanmon.business.server.service.message.MessageTriggerMapper")
public class MessageTriggerMapper extends AbstractEntityMapper<GWTMessageTrigger,MessageTrigger> {
  @Autowired
  private IConvertService convertService;
  
  @Autowired
  private IObjectFactory entities;
  
  public MessageTrigger loadEntityById(final Long id) {
    return entities.get(MessageTrigger.class,id);
  }
  
  public MessageTrigger create() {
    return entities.create(MessageTrigger.class);
  }
  
  public void copyToEntity(final GWTMessageTrigger from, final MessageTrigger to) {
    to.setState(convertService.toValue(com.lanmon.workflow.business.TriggerState.class,from.getState()));
    to.setNextTriggleDate(convertService.toValue(java.util.Date.class,from.getTriggerDate()));
    
  }
  
  public GWTMessageTrigger copyFromEntity(final GWTMessageTrigger result, final MessageTrigger entity) {
    if(entity==null) return null;
    result.setId(entity.getId());
    result.setSummary(convertService.toValue(java.lang.String.class,entity.getSummary()));
    result.setState(convertService.toValue(com.lanmon.business.shared.message.GWTTriggerState.class,entity.getState()));
    	result.setTriggerDate(convertService.toValue(java.util.Date.class,entity.getNextTriggleDate()));
    buildFromCust(result,entity);
    return result;
    
  }
  
  public GWTMessageTrigger buildFrom(final MessageTrigger entity) {
    if(entity==null) return null;
    com.lanmon.business.shared.message.GWTMessageTrigger result = new com.lanmon.business.shared.message.GWTMessageTrigger();
    copyFromEntity(result,entity);	
    return result;
    
  }
  
  protected void buildFromCust(final GWTMessageTrigger _gwt, final MessageTrigger _entity) {
    TriggerType _switchResult = null;
    final MessageTrigger _switchValue = _entity;
    boolean _matched = false;
    if (!_matched) {
      if (_switchValue instanceof OneTimeTrigger) {
        final OneTimeTrigger _oneTimeTrigger = (OneTimeTrigger)_switchValue;
        _matched=true;
        _switchResult = TriggerType.OneTime;
      }
    }
    if (!_matched) {
      if (_switchValue instanceof PeriodicCustomerTrigger) {
        final PeriodicCustomerTrigger _periodicCustomerTrigger = (PeriodicCustomerTrigger)_switchValue;
        _matched=true;
        _switchResult = TriggerType.Periodic;
      }
    }
    if (!_matched) {
      if (_switchValue instanceof ContractDateTrigger) {
        final ContractDateTrigger _contractDateTrigger = (ContractDateTrigger)_switchValue;
        _matched=true;
        _switchResult = TriggerType.ContractDate;
      }
    }
    if (!_matched) {
      if (_switchValue instanceof OutsourceDateTrigger) {
        final OutsourceDateTrigger _outsourceDateTrigger = (OutsourceDateTrigger)_switchValue;
        _matched=true;
        _switchResult = TriggerType.OutSourceDate;
      }
    }
    _gwt.setTriggerType(_switchResult);
  }
  
  public Class<?> getUIClass() {
    return GWTMessageTrigger.class;
  }
  
  public Class<?> getEntityClass() {
    return MessageTrigger.class;
  }
}
