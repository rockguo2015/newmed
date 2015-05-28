package com.fudanmed.platform.core.web.server.service.organization;

import com.fudanmed.platform.core.domain.RCEmployee;
import com.fudanmed.platform.core.web.server.service.organization.EmployeeValidator;
import com.fudanmed.platform.core.web.shared.organization.UIEmployee;
import com.uniquesoft.uidl.transform.AbstractEntityMapper;
import com.uniquesoft.uidl.transform.IConvertService;
import edu.fudan.mylang.pf.IObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("com.fudanmed.platform.core.web.server.service.organization.SimpleEmployeeMapper")
public class SimpleEmployeeMapper extends AbstractEntityMapper<UIEmployee,RCEmployee> {
  @Autowired
  private IConvertService convertService;
  
  @Autowired
  private IObjectFactory entities;
  
  public RCEmployee loadEntityById(final Long id) {
    return entities.get(RCEmployee.class,id);
  }
  
  public RCEmployee create() {
    return entities.create(RCEmployee.class);
  }
  
  @Autowired
  private EmployeeValidator validator;
  
  public void copyToEntity(final UIEmployee from, final RCEmployee to) {
    java.util.Collection<com.uniquesoft.gwt.shared.validation.ValidationErrorItem> errors = validator.validate(from);
    if(errors.size()!=0)throw new com.uniquesoft.gwt.shared.validation.ValidationException(errors);					
    to.setVersion(from.getVersion());
    to.setEid(convertService.toValue(java.lang.String.class,from.getEid()));
    to.setCardNumber(convertService.toValue(java.lang.String.class,from.getCardNumber()));
    to.setName(convertService.toValue(java.lang.String.class,from.getName()));
    to.setMobil(convertService.toValue(java.lang.String.class,from.getMobil()));
    to.setTel(convertService.toValue(java.lang.String.class,from.getTel()));
    to.setWorkTel(convertService.toValue(java.lang.String.class,from.getWorkTel()));
    to.setEmail(convertService.toValue(java.lang.String.class,from.getEmail()));
    to.setAddress(convertService.toValue(java.lang.String.class,from.getAddress()));
    
  }
  
  public UIEmployee copyFromEntity(final UIEmployee result, final RCEmployee entity) {
    if(entity==null) return null;
    result.setId(entity.getId());
    result.setVersion(entity.getVersion());
    result.setProxy(entity.toProxy());
    result.setClazzName(entity.getClass().getName());
    result.setEid(convertService.toValue(java.lang.String.class,entity.getEid()));
    result.setCardNumber(convertService.toValue(java.lang.String.class,entity.getCardNumber()));
    result.setName(convertService.toValue(java.lang.String.class,entity.getName()));
    result.setMobil(convertService.toValue(java.lang.String.class,entity.getMobil()));
    result.setTel(convertService.toValue(java.lang.String.class,entity.getTel()));
    result.setWorkTel(convertService.toValue(java.lang.String.class,entity.getWorkTel()));
    result.setEmail(convertService.toValue(java.lang.String.class,entity.getEmail()));
    result.setAddress(convertService.toValue(java.lang.String.class,entity.getAddress()));
    return result;
    
  }
  
  public UIEmployee buildFrom(final RCEmployee entity) {
    if(entity==null) return null;
    com.fudanmed.platform.core.web.shared.organization.UIEmployee result = new com.fudanmed.platform.core.web.shared.organization.UIEmployee();
    copyFromEntity(result,entity);	
    return result;
    
  }
  
  public Class<?> getUIClass() {
    return UIEmployee.class;
  }
  
  public Class<?> getEntityClass() {
    return RCEmployee.class;
  }
}
