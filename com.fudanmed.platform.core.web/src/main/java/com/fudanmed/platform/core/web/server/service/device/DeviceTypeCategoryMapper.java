package com.fudanmed.platform.core.web.server.service.device;

import com.fudanmed.platform.core.device.RCDeviceTypeCategory;
import com.fudanmed.platform.core.web.server.service.device.DeviceTypeCategoryValidator;
import com.fudanmed.platform.core.web.shared.device.UIDeviceTypeCategory;
import com.uniquesoft.uidl.transform.AbstractEntityMapper;
import com.uniquesoft.uidl.transform.IConvertService;
import edu.fudan.mylang.pf.IObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("com.fudanmed.platform.core.web.server.service.device.DeviceTypeCategoryMapper")
public class DeviceTypeCategoryMapper extends AbstractEntityMapper<UIDeviceTypeCategory,RCDeviceTypeCategory> {
  @Autowired
  private IConvertService convertService;
  
  @Autowired
  private IObjectFactory entities;
  
  public RCDeviceTypeCategory loadEntityById(final Long id) {
    return entities.get(RCDeviceTypeCategory.class,id);
  }
  
  public RCDeviceTypeCategory create() {
    return entities.create(RCDeviceTypeCategory.class);
  }
  
  @Autowired
  private DeviceTypeCategoryValidator validator;
  
  public void copyToEntity(final UIDeviceTypeCategory from, final RCDeviceTypeCategory to) {
    java.util.Collection<com.uniquesoft.gwt.shared.validation.ValidationErrorItem> errors = validator.validate(from);
    if(errors.size()!=0)throw new com.uniquesoft.gwt.shared.validation.ValidationException(errors);					
    to.setVersion(from.getVersion());
    to.setName(convertService.toValue(java.lang.String.class,from.getName()));
    to.setCode(convertService.toValue(java.lang.String.class,from.getCode()));
    to.setParent(convertService.toValue(com.fudanmed.platform.core.device.RCDeviceTypeCategory.class,from.getParent()));
    
  }
  
  public UIDeviceTypeCategory copyFromEntity(final UIDeviceTypeCategory result, final RCDeviceTypeCategory entity) {
    if(entity==null) return null;
    result.setId(entity.getId());
    result.setVersion(entity.getVersion());
    result.setProxy(entity.toProxy());
    result.setClazzName(entity.getClass().getName());
    result.setName(convertService.toValue(java.lang.String.class,entity.getName()));
    result.setCode(convertService.toValue(java.lang.String.class,entity.getCode()));
    result.setParent(convertService.toValue(com.fudanmed.platform.core.device.proxy.RCDeviceTypeCategoryProxy.class,entity.getParent()));
    result.setSimplePy(convertService.toValue(java.lang.String.class,entity.getSimplePy()));
    return result;
    
  }
  
  public UIDeviceTypeCategory buildFrom(final RCDeviceTypeCategory entity) {
    if(entity==null) return null;
    com.fudanmed.platform.core.web.shared.device.UIDeviceTypeCategory result = new com.fudanmed.platform.core.web.shared.device.UIDeviceTypeCategory();
    copyFromEntity(result,entity);	
    return result;
    
  }
  
  public Class<?> getUIClass() {
    return UIDeviceTypeCategory.class;
  }
  
  public Class<?> getEntityClass() {
    return RCDeviceTypeCategory.class;
  }
}
