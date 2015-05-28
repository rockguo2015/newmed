package com.fudanmed.platform.core.web.server.service.deliver;

import com.fudanmed.platform.core.deliver.DLDeliverPatientCheckType;
import com.fudanmed.platform.core.web.server.service.deliver.DeliverPatientCheckTypeValidator;
import com.fudanmed.platform.core.web.shared.deliver.UIDeliverPatientCheckType;
import com.uniquesoft.uidl.transform.AbstractEntityMapper;
import com.uniquesoft.uidl.transform.IConvertService;
import edu.fudan.mylang.pf.IObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("com.fudanmed.platform.core.web.server.service.deliver.DeliverPatientCheckTypeMapper")
public class DeliverPatientCheckTypeMapper extends AbstractEntityMapper<UIDeliverPatientCheckType,DLDeliverPatientCheckType> {
  @Autowired
  private IConvertService convertService;
  
  @Autowired
  private IObjectFactory entities;
  
  public DLDeliverPatientCheckType loadEntityById(final Long id) {
    return entities.get(DLDeliverPatientCheckType.class,id);
  }
  
  public DLDeliverPatientCheckType create() {
    return entities.create(DLDeliverPatientCheckType.class);
  }
  
  @Autowired
  private DeliverPatientCheckTypeValidator validator;
  
  public void copyToEntity(final UIDeliverPatientCheckType from, final DLDeliverPatientCheckType to) {
    java.util.Collection<com.uniquesoft.gwt.shared.validation.ValidationErrorItem> errors = validator.validate(from);
    if(errors.size()!=0)throw new com.uniquesoft.gwt.shared.validation.ValidationException(errors);					
    to.setVersion(from.getVersion());
    to.setCode(convertService.toValue(java.lang.String.class,from.getCode()));
    to.setName(convertService.toValue(java.lang.String.class,from.getName()));
    to.setPerformence(convertService.toValue(java.lang.Integer.class,from.getPerformence()));
    to.setTimeLimitation(convertService.toValue(java.lang.Integer.class,from.getTimeLimitation()));
    convertService.toProxyEntity(from.getCheckOrganization(),to.getCheckOrganization(),com.fudanmed.platform.core.deliver.DLCheckOrganization.class);
    to.setComment(convertService.toValue(java.lang.String.class,from.getComment()));
    
  }
  
  public UIDeliverPatientCheckType copyFromEntity(final UIDeliverPatientCheckType result, final DLDeliverPatientCheckType entity) {
    if(entity==null) return null;
    result.setId(entity.getId());
    result.setVersion(entity.getVersion());
    result.setProxy(entity.toProxy());
    result.setClazzName(entity.getClass().getName());
    result.setCategory(convertService.toValue(com.fudanmed.platform.core.deliver.proxy.DLDeliverPatientCheckCategoryProxy.class,entity.getCategory()));
    result.setCode(convertService.toValue(java.lang.String.class,entity.getCode()));
    result.setName(convertService.toValue(java.lang.String.class,entity.getName()));
    result.setPerformence(convertService.toValue(java.lang.Integer.class,entity.getPerformence()));
    result.setTimeLimitation(convertService.toValue(java.lang.Integer.class,entity.getTimeLimitation()));
    result.setCheckOrganization(convertService.toCollectionValue(com.fudanmed.platform.core.deliver.proxy.DLCheckOrganizationProxy.class,entity.getCheckOrganization()));
    result.setComment(convertService.toValue(java.lang.String.class,entity.getComment()));
    return result;
    
  }
  
  public UIDeliverPatientCheckType buildFrom(final DLDeliverPatientCheckType entity) {
    if(entity==null) return null;
    com.fudanmed.platform.core.web.shared.deliver.UIDeliverPatientCheckType result = new com.fudanmed.platform.core.web.shared.deliver.UIDeliverPatientCheckType();
    copyFromEntity(result,entity);	
    return result;
    
  }
  
  public Class<?> getUIClass() {
    return UIDeliverPatientCheckType.class;
  }
  
  public Class<?> getEntityClass() {
    return DLDeliverPatientCheckType.class;
  }
}
