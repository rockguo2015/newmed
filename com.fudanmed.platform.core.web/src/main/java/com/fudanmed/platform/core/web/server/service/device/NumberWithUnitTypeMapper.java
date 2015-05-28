package com.fudanmed.platform.core.web.server.service.device;

import com.fudanmed.platform.core.entityextension.RCNumberWithUnitType;
import com.fudanmed.platform.core.web.server.service.device.NumberWithUnitTypeValidator;
import com.fudanmed.platform.core.web.shared.device.UINumberWithUnitType;
import com.uniquesoft.uidl.transform.AbstractEntityMapper;
import com.uniquesoft.uidl.transform.IConvertService;
import edu.fudan.mylang.pf.IObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("com.fudanmed.platform.core.web.server.service.device.NumberWithUnitTypeMapper")
public class NumberWithUnitTypeMapper extends AbstractEntityMapper<UINumberWithUnitType,RCNumberWithUnitType> {
  @Autowired
  private IConvertService convertService;
  
  @Autowired
  private IObjectFactory entities;
  
  public RCNumberWithUnitType loadEntityById(final Long id) {
    return entities.get(RCNumberWithUnitType.class,id);
  }
  
  public RCNumberWithUnitType create() {
    return entities.create(RCNumberWithUnitType.class);
  }
  
  @Autowired
  private NumberWithUnitTypeValidator validator;
  
  public void copyToEntity(final UINumberWithUnitType from, final RCNumberWithUnitType to) {
    java.util.Collection<com.uniquesoft.gwt.shared.validation.ValidationErrorItem> errors = validator.validate(from);
    if(errors.size()!=0)throw new com.uniquesoft.gwt.shared.validation.ValidationException(errors);					
    to.setVersion(from.getVersion());
    to.setUnit(convertService.toValue(java.lang.String.class,from.getUnit()));
    to.setAlias(convertService.toValue(java.lang.String.class,from.getAlias()));
    
  }
  
  public UINumberWithUnitType copyFromEntity(final UINumberWithUnitType result, final RCNumberWithUnitType entity) {
    if(entity==null) return null;
    result.setId(entity.getId());
    result.setVersion(entity.getVersion());
    result.setProxy(entity.toProxy());
    result.setClazzName(entity.getClass().getName());
    result.setUnit(convertService.toValue(java.lang.String.class,entity.getUnit()));
    result.setAlias(convertService.toValue(java.lang.String.class,entity.getAlias()));
    return result;
    
  }
  
  public UINumberWithUnitType buildFrom(final RCNumberWithUnitType entity) {
    if(entity==null) return null;
    com.fudanmed.platform.core.web.shared.device.UINumberWithUnitType result = new com.fudanmed.platform.core.web.shared.device.UINumberWithUnitType();
    copyFromEntity(result,entity);	
    return result;
    
  }
  
  public Class<?> getUIClass() {
    return UINumberWithUnitType.class;
  }
  
  public Class<?> getEntityClass() {
    return RCNumberWithUnitType.class;
  }
}
