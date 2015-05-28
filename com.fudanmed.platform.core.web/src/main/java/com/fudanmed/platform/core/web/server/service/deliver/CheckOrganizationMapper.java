package com.fudanmed.platform.core.web.server.service.deliver;

import com.fudanmed.platform.core.deliver.DLCheckOrganization;
import com.fudanmed.platform.core.web.server.service.deliver.CheckOrganizationValidator;
import com.fudanmed.platform.core.web.shared.deliver.UICheckOrganization;
import com.uniquesoft.uidl.transform.AbstractEntityMapper;
import com.uniquesoft.uidl.transform.IConvertService;
import edu.fudan.mylang.pf.IObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("com.fudanmed.platform.core.web.server.service.deliver.CheckOrganizationMapper")
public class CheckOrganizationMapper extends AbstractEntityMapper<UICheckOrganization,DLCheckOrganization> {
  @Autowired
  private IConvertService convertService;
  
  @Autowired
  private IObjectFactory entities;
  
  public DLCheckOrganization loadEntityById(final Long id) {
    return entities.get(DLCheckOrganization.class,id);
  }
  
  public DLCheckOrganization create() {
    return entities.create(DLCheckOrganization.class);
  }
  
  @Autowired
  private CheckOrganizationValidator validator;
  
  public void copyToEntity(final UICheckOrganization from, final DLCheckOrganization to) {
    java.util.Collection<com.uniquesoft.gwt.shared.validation.ValidationErrorItem> errors = validator.validate(from);
    if(errors.size()!=0)throw new com.uniquesoft.gwt.shared.validation.ValidationException(errors);					
    to.setVersion(from.getVersion());
    to.setCode(convertService.toValue(java.lang.String.class,from.getCode()));
    to.setName(convertService.toValue(java.lang.String.class,from.getName()));
    to.setOrganization(convertService.toValue(com.fudanmed.platform.core.domain.RCOrganization.class,from.getOrganization()));
    
  }
  
  public UICheckOrganization copyFromEntity(final UICheckOrganization result, final DLCheckOrganization entity) {
    if(entity==null) return null;
    result.setId(entity.getId());
    result.setVersion(entity.getVersion());
    result.setProxy(entity.toProxy());
    result.setClazzName(entity.getClass().getName());
    result.setCode(convertService.toValue(java.lang.String.class,entity.getCode()));
    result.setName(convertService.toValue(java.lang.String.class,entity.getName()));
    result.setOrganization(convertService.toValue(com.fudanmed.platform.core.domain.proxy.RCOrganizationProxy.class,entity.getOrganization()));
    return result;
    
  }
  
  public UICheckOrganization buildFrom(final DLCheckOrganization entity) {
    if(entity==null) return null;
    com.fudanmed.platform.core.web.shared.deliver.UICheckOrganization result = new com.fudanmed.platform.core.web.shared.deliver.UICheckOrganization();
    copyFromEntity(result,entity);	
    return result;
    
  }
  
  public Class<?> getUIClass() {
    return UICheckOrganization.class;
  }
  
  public Class<?> getEntityClass() {
    return DLCheckOrganization.class;
  }
}
