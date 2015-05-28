package com.fudanmed.platform.core.web.server.service.organization;

import com.fudanmed.platform.core.domain.RCSupplier;
import com.fudanmed.platform.core.web.server.service.organization.SupplierValidator;
import com.fudanmed.platform.core.web.shared.organization.UISupplier;
import com.uniquesoft.uidl.transform.AbstractEntityMapper;
import com.uniquesoft.uidl.transform.IConvertService;
import edu.fudan.mylang.pf.IObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("com.fudanmed.platform.core.web.server.service.organization.SupplierMapper")
public class SupplierMapper extends AbstractEntityMapper<UISupplier,RCSupplier> {
  @Autowired
  private IConvertService convertService;
  
  @Autowired
  private IObjectFactory entities;
  
  public RCSupplier loadEntityById(final Long id) {
    return entities.get(RCSupplier.class,id);
  }
  
  public RCSupplier create() {
    return entities.create(RCSupplier.class);
  }
  
  @Autowired
  private SupplierValidator validator;
  
  public void copyToEntity(final UISupplier from, final RCSupplier to) {
    java.util.Collection<com.uniquesoft.gwt.shared.validation.ValidationErrorItem> errors = validator.validate(from);
    if(errors.size()!=0)throw new com.uniquesoft.gwt.shared.validation.ValidationException(errors);					
    to.setVersion(from.getVersion());
    to.setCode(convertService.toValue(java.lang.String.class,from.getCode()));
    to.setName(convertService.toValue(java.lang.String.class,from.getName()));
    to.setPhone(convertService.toValue(java.lang.String.class,from.getPhone()));
    to.setEmail(convertService.toValue(java.lang.String.class,from.getEmail()));
    to.setAddress(convertService.toValue(java.lang.String.class,from.getAddress()));
    to.setType(convertService.toValue(com.fudanmed.platform.core.domain.RCSupplierType.class,from.getType()));
    to.setShortName(convertService.toValue(java.lang.String.class,from.getShortName()));
    to.setEname(convertService.toValue(java.lang.String.class,from.getEname()));
    to.setSpell(convertService.toValue(java.lang.String.class,from.getSpell()));
    to.setHelpCode(convertService.toValue(java.lang.String.class,from.getHelpCode()));
    to.setEnterpriseEnrolNum(convertService.toValue(java.lang.String.class,from.getEnterpriseEnrolNum()));
    to.setWorkNo(convertService.toValue(java.lang.String.class,from.getWorkNo()));
    to.setRegCapital(convertService.toValue(java.lang.Double.class,from.getRegCapital()));
    to.setLegalPerson(convertService.toValue(java.lang.String.class,from.getLegalPerson()));
    to.setAptitudeName(convertService.toValue(java.lang.String.class,from.getAptitudeName()));
    to.setAptitudeNo(convertService.toValue(java.lang.String.class,from.getAptitudeNo()));
    
  }
  
  public UISupplier copyFromEntity(final UISupplier result, final RCSupplier entity) {
    if(entity==null) return null;
    result.setId(entity.getId());
    result.setVersion(entity.getVersion());
    result.setProxy(entity.toProxy());
    result.setClazzName(entity.getClass().getName());
    result.setCode(convertService.toValue(java.lang.String.class,entity.getCode()));
    result.setName(convertService.toValue(java.lang.String.class,entity.getName()));
    result.setPhone(convertService.toValue(java.lang.String.class,entity.getPhone()));
    result.setEmail(convertService.toValue(java.lang.String.class,entity.getEmail()));
    result.setAddress(convertService.toValue(java.lang.String.class,entity.getAddress()));
    result.setType(convertService.toValue(com.fudanmed.platform.core.web.shared.organization.UISupplierType.class,entity.getType()));
    result.setShortName(convertService.toValue(java.lang.String.class,entity.getShortName()));
    result.setEname(convertService.toValue(java.lang.String.class,entity.getEname()));
    result.setSpell(convertService.toValue(java.lang.String.class,entity.getSpell()));
    result.setHelpCode(convertService.toValue(java.lang.String.class,entity.getHelpCode()));
    result.setEnterpriseEnrolNum(convertService.toValue(java.lang.String.class,entity.getEnterpriseEnrolNum()));
    result.setWorkNo(convertService.toValue(java.lang.String.class,entity.getWorkNo()));
    result.setRegCapital(convertService.toValue(java.lang.Double.class,entity.getRegCapital()));
    result.setLegalPerson(convertService.toValue(java.lang.String.class,entity.getLegalPerson()));
    result.setAptitudeName(convertService.toValue(java.lang.String.class,entity.getAptitudeName()));
    result.setAptitudeNo(convertService.toValue(java.lang.String.class,entity.getAptitudeNo()));
    return result;
    
  }
  
  public UISupplier buildFrom(final RCSupplier entity) {
    if(entity==null) return null;
    com.fudanmed.platform.core.web.shared.organization.UISupplier result = new com.fudanmed.platform.core.web.shared.organization.UISupplier();
    copyFromEntity(result,entity);	
    return result;
    
  }
  
  public Class<?> getUIClass() {
    return UISupplier.class;
  }
  
  public Class<?> getEntityClass() {
    return RCSupplier.class;
  }
}
