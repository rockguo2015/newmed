package com.fudanmed.platform.core.web.server.service.deliver;

import com.fudanmed.platform.core.deliver.DLDeliverOrganization;
import com.fudanmed.platform.core.web.server.service.deliver.DeliverOrganizationValidator;
import com.fudanmed.platform.core.web.shared.deliver.UIDeliverOrganization;
import com.uniquesoft.uidl.transform.AbstractEntityMapper;
import com.uniquesoft.uidl.transform.IConvertService;
import edu.fudan.mylang.pf.IObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("com.fudanmed.platform.core.web.server.service.deliver.DeliverOrganizationMapper")
public class DeliverOrganizationMapper extends AbstractEntityMapper<UIDeliverOrganization,DLDeliverOrganization> {
  @Autowired
  private IConvertService convertService;
  
  @Autowired
  private IObjectFactory entities;
  
  public DLDeliverOrganization loadEntityById(final Long id) {
    return entities.get(DLDeliverOrganization.class,id);
  }
  
  public DLDeliverOrganization create() {
    return entities.create(DLDeliverOrganization.class);
  }
  
  @Autowired
  private DeliverOrganizationValidator validator;
  
  public void copyToEntity(final UIDeliverOrganization from, final DLDeliverOrganization to) {
    java.util.Collection<com.uniquesoft.gwt.shared.validation.ValidationErrorItem> errors = validator.validate(from);
    if(errors.size()!=0)throw new com.uniquesoft.gwt.shared.validation.ValidationException(errors);					
    to.setVersion(from.getVersion());
    to.setOrganization(convertService.toValue(com.fudanmed.platform.core.domain.RCOrganization.class,from.getOrganization()));
    to.setCode(convertService.toValue(java.lang.String.class,from.getCode()));
    to.setName(convertService.toValue(java.lang.String.class,from.getName()));
    
  }
  
  public UIDeliverOrganization copyFromEntity(final UIDeliverOrganization result, final DLDeliverOrganization entity) {
    if(entity==null) return null;
    result.setId(entity.getId());
    result.setVersion(entity.getVersion());
    result.setProxy(entity.toProxy());
    result.setClazzName(entity.getClass().getName());
    result.setOrganization(convertService.toValue(com.fudanmed.platform.core.domain.proxy.RCOrganizationProxy.class,entity.getOrganization()));
    result.setCode(convertService.toValue(java.lang.String.class,entity.getCode()));
    result.setName(convertService.toValue(java.lang.String.class,entity.getName()));
    return result;
    
  }
  
  public UIDeliverOrganization buildFrom(final DLDeliverOrganization entity) {
    if(entity==null) return null;
    com.fudanmed.platform.core.web.shared.deliver.UIDeliverOrganization result = new com.fudanmed.platform.core.web.shared.deliver.UIDeliverOrganization();
    copyFromEntity(result,entity);	
    return result;
    
  }
  
  public Class<?> getUIClass() {
    return UIDeliverOrganization.class;
  }
  
  public Class<?> getEntityClass() {
    return DLDeliverOrganization.class;
  }
}
