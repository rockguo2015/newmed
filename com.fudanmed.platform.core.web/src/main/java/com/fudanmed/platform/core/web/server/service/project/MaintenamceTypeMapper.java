package com.fudanmed.platform.core.web.server.service.project;

import com.fudanmed.platform.core.domain.RCMaintenamceType;
import com.fudanmed.platform.core.web.server.service.project.MaintenamceTypeValidator;
import com.fudanmed.platform.core.web.shared.project.UIMaintenamceType;
import com.uniquesoft.uidl.transform.AbstractEntityMapper;
import com.uniquesoft.uidl.transform.IConvertService;
import edu.fudan.mylang.pf.IObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("com.fudanmed.platform.core.web.server.service.project.MaintenamceTypeMapper")
public class MaintenamceTypeMapper extends AbstractEntityMapper<UIMaintenamceType,RCMaintenamceType> {
  @Autowired
  private IConvertService convertService;
  
  @Autowired
  private IObjectFactory entities;
  
  public RCMaintenamceType loadEntityById(final Long id) {
    return entities.get(RCMaintenamceType.class,id);
  }
  
  public RCMaintenamceType create() {
    return entities.create(RCMaintenamceType.class);
  }
  
  @Autowired
  private MaintenamceTypeValidator validator;
  
  public void copyToEntity(final UIMaintenamceType from, final RCMaintenamceType to) {
    java.util.Collection<com.uniquesoft.gwt.shared.validation.ValidationErrorItem> errors = validator.validate(from);
    if(errors.size()!=0)throw new com.uniquesoft.gwt.shared.validation.ValidationException(errors);					
    to.setVersion(from.getVersion());
    to.setName(convertService.toValue(java.lang.String.class,from.getName()));
    to.setCode(convertService.toValue(java.lang.String.class,from.getCode()));
    to.setParent(convertService.toValue(com.fudanmed.platform.core.domain.RCMaintenamceType.class,from.getParent()));
    
  }
  
  public UIMaintenamceType copyFromEntity(final UIMaintenamceType result, final RCMaintenamceType entity) {
    if(entity==null) return null;
    result.setId(entity.getId());
    result.setVersion(entity.getVersion());
    result.setProxy(entity.toProxy());
    result.setClazzName(entity.getClass().getName());
    result.setName(convertService.toValue(java.lang.String.class,entity.getName()));
    result.setCode(convertService.toValue(java.lang.String.class,entity.getCode()));
    result.setParent(convertService.toValue(com.fudanmed.platform.core.domain.proxy.RCMaintenamceTypeProxy.class,entity.getParent()));
    result.setSimplePy(convertService.toValue(java.lang.String.class,entity.getSimplePy()));
    return result;
    
  }
  
  public UIMaintenamceType buildFrom(final RCMaintenamceType entity) {
    if(entity==null) return null;
    com.fudanmed.platform.core.web.shared.project.UIMaintenamceType result = new com.fudanmed.platform.core.web.shared.project.UIMaintenamceType();
    copyFromEntity(result,entity);	
    return result;
    
  }
  
  public Class<?> getUIClass() {
    return UIMaintenamceType.class;
  }
  
  public Class<?> getEntityClass() {
    return RCMaintenamceType.class;
  }
}
