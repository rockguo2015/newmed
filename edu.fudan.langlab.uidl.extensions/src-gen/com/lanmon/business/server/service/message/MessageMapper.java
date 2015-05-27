package com.lanmon.business.server.service.message;

import com.lanmon.business.shared.message.GWTMessage;
import com.lanmon.workflow.business.Message;
import com.uniquesoft.uidl.transform.AbstractEntityMapper;
import com.uniquesoft.uidl.transform.IConvertService;
import edu.fudan.mylang.pf.IObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("com.lanmon.business.server.service.message.MessageMapper")
public class MessageMapper extends AbstractEntityMapper<GWTMessage,Message> {
  @Autowired
  private IConvertService convertService;
  
  @Autowired
  private IObjectFactory entities;
  
  public Message loadEntityById(final Long id) {
    return entities.get(Message.class,id);
  }
  
  public Message create() {
    return entities.create(Message.class);
  }
  
  public void copyToEntity(final GWTMessage from, final Message to) {
    
  }
  
  public GWTMessage copyFromEntity(final GWTMessage result, final Message entity) {
    if(entity==null) return null;
    result.setId(entity.getId());
    result.setTitle(convertService.toValue(java.lang.String.class,entity.getTitle()));
    result.setTriggerDate(convertService.toValue(java.util.Date.class,entity.getTriggerDate()));
    if(entity. getMessageTrigger()  != null )
    	result.setCustomer(convertService.toValue(com.uniquesoft.gwt.shared.GWTNamedEntity.class,entity.getMessageTrigger().getCustomer()));
    return result;
    
  }
  
  public GWTMessage buildFrom(final Message entity) {
    if(entity==null) return null;
    com.lanmon.business.shared.message.GWTMessage result = new com.lanmon.business.shared.message.GWTMessage();
    copyFromEntity(result,entity);	
    return result;
    
  }
  
  public Class<?> getUIClass() {
    return GWTMessage.class;
  }
  
  public Class<?> getEntityClass() {
    return Message.class;
  }
}
