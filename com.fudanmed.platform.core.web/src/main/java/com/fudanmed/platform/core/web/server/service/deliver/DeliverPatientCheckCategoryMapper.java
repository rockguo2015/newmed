package com.fudanmed.platform.core.web.server.service.deliver;

import com.fudanmed.platform.core.deliver.DLDeliverPatientCheckCategory;
import com.fudanmed.platform.core.web.server.service.deliver.DeliverPatientCheckCategoryValidator;
import com.fudanmed.platform.core.web.shared.deliver.UIDeliverPatientCheckCategory;
import com.uniquesoft.uidl.transform.AbstractEntityMapper;
import com.uniquesoft.uidl.transform.IConvertService;
import edu.fudan.mylang.pf.IObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("com.fudanmed.platform.core.web.server.service.deliver.DeliverPatientCheckCategoryMapper")
public class DeliverPatientCheckCategoryMapper extends AbstractEntityMapper<UIDeliverPatientCheckCategory,DLDeliverPatientCheckCategory> {
  @Autowired
  private IConvertService convertService;
  
  @Autowired
  private IObjectFactory entities;
  
  public DLDeliverPatientCheckCategory loadEntityById(final Long id) {
    return entities.get(DLDeliverPatientCheckCategory.class,id);
  }
  
  public DLDeliverPatientCheckCategory create() {
    return entities.create(DLDeliverPatientCheckCategory.class);
  }
  
  @Autowired
  private DeliverPatientCheckCategoryValidator validator;
  
  public void copyToEntity(final UIDeliverPatientCheckCategory from, final DLDeliverPatientCheckCategory to) {
    java.util.Collection<com.uniquesoft.gwt.shared.validation.ValidationErrorItem> errors = validator.validate(from);
    if(errors.size()!=0)throw new com.uniquesoft.gwt.shared.validation.ValidationException(errors);					
    to.setVersion(from.getVersion());
    to.setCode(convertService.toValue(java.lang.String.class,from.getCode()));
    to.setName(convertService.toValue(java.lang.String.class,from.getName()));
    
  }
  
  public UIDeliverPatientCheckCategory copyFromEntity(final UIDeliverPatientCheckCategory result, final DLDeliverPatientCheckCategory entity) {
    if(entity==null) return null;
    result.setId(entity.getId());
    result.setVersion(entity.getVersion());
    result.setProxy(entity.toProxy());
    result.setClazzName(entity.getClass().getName());
    result.setCode(convertService.toValue(java.lang.String.class,entity.getCode()));
    result.setName(convertService.toValue(java.lang.String.class,entity.getName()));
    result.setParentCategory(convertService.toValue(com.fudanmed.platform.core.deliver.proxy.DLDeliverPatientCheckCategoryProxy.class,entity.getParentCategory()));
    return result;
    
  }
  
  public UIDeliverPatientCheckCategory buildFrom(final DLDeliverPatientCheckCategory entity) {
    if(entity==null) return null;
    com.fudanmed.platform.core.web.shared.deliver.UIDeliverPatientCheckCategory result = new com.fudanmed.platform.core.web.shared.deliver.UIDeliverPatientCheckCategory();
    copyFromEntity(result,entity);	
    return result;
    
  }
  
  public Class<?> getUIClass() {
    return UIDeliverPatientCheckCategory.class;
  }
  
  public Class<?> getEntityClass() {
    return DLDeliverPatientCheckCategory.class;
  }
}
