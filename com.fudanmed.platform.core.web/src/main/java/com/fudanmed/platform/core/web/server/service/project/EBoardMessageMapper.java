package com.fudanmed.platform.core.web.server.service.project;

import com.fudanmed.platform.core.common.RCEBoardMessage;
import com.fudanmed.platform.core.web.server.service.project.EBoardMessageValidator;
import com.fudanmed.platform.core.web.shared.project.UIEBoardMessage;
import com.uniquesoft.uidl.transform.AbstractEntityMapper;
import com.uniquesoft.uidl.transform.IConvertService;
import edu.fudan.mylang.pf.IObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("com.fudanmed.platform.core.web.server.service.project.EBoardMessageMapper")
public class EBoardMessageMapper extends AbstractEntityMapper<UIEBoardMessage,RCEBoardMessage> {
  @Autowired
  private IConvertService convertService;
  
  @Autowired
  private IObjectFactory entities;
  
  public RCEBoardMessage loadEntityById(final Long id) {
    return entities.get(RCEBoardMessage.class,id);
  }
  
  public RCEBoardMessage create() {
    return entities.create(RCEBoardMessage.class);
  }
  
  @Autowired
  private EBoardMessageValidator validator;
  
  public void copyToEntity(final UIEBoardMessage from, final RCEBoardMessage to) {
    java.util.Collection<com.uniquesoft.gwt.shared.validation.ValidationErrorItem> errors = validator.validate(from);
    if(errors.size()!=0)throw new com.uniquesoft.gwt.shared.validation.ValidationException(errors);					
    to.setVersion(from.getVersion());
    to.setMessage(convertService.toValue(java.lang.String.class,from.getMessage()));
    
  }
  
  public UIEBoardMessage copyFromEntity(final UIEBoardMessage result, final RCEBoardMessage entity) {
    if(entity==null) return null;
    result.setId(entity.getId());
    result.setVersion(entity.getVersion());
    result.setProxy(entity.toProxy());
    result.setClazzName(entity.getClass().getName());
    result.setMessage(convertService.toValue(java.lang.String.class,entity.getMessage()));
    return result;
    
  }
  
  public UIEBoardMessage buildFrom(final RCEBoardMessage entity) {
    if(entity==null) return null;
    com.fudanmed.platform.core.web.shared.project.UIEBoardMessage result = new com.fudanmed.platform.core.web.shared.project.UIEBoardMessage();
    copyFromEntity(result,entity);	
    return result;
    
  }
  
  public Class<?> getUIClass() {
    return UIEBoardMessage.class;
  }
  
  public Class<?> getEntityClass() {
    return RCEBoardMessage.class;
  }
}
