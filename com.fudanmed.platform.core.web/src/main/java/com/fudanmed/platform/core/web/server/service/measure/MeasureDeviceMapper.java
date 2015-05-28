package com.fudanmed.platform.core.web.server.service.measure;

import com.fudanmed.platform.core.measure.RCMeasureDevice;
import com.fudanmed.platform.core.web.server.service.measure.MeasureDeviceValidator;
import com.fudanmed.platform.core.web.shared.measure.UIMeasureDevice;
import com.uniquesoft.uidl.transform.AbstractEntityMapper;
import com.uniquesoft.uidl.transform.IConvertService;
import edu.fudan.mylang.pf.IObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("com.fudanmed.platform.core.web.server.service.measure.MeasureDeviceMapper")
public class MeasureDeviceMapper extends AbstractEntityMapper<UIMeasureDevice,RCMeasureDevice> {
  @Autowired
  private IConvertService convertService;
  
  @Autowired
  private IObjectFactory entities;
  
  public RCMeasureDevice loadEntityById(final Long id) {
    return entities.get(RCMeasureDevice.class,id);
  }
  
  public RCMeasureDevice create() {
    return entities.create(RCMeasureDevice.class);
  }
  
  @Autowired
  private MeasureDeviceValidator validator;
  
  public void copyToEntity(final UIMeasureDevice from, final RCMeasureDevice to) {
    java.util.Collection<com.uniquesoft.gwt.shared.validation.ValidationErrorItem> errors = validator.validate(from);
    if(errors.size()!=0)throw new com.uniquesoft.gwt.shared.validation.ValidationException(errors);					
    to.setVersion(from.getVersion());
    to.setSid(convertService.toValue(java.lang.String.class,from.getSid()));
    to.setName(convertService.toValue(java.lang.String.class,from.getName()));
    to.setLocation(convertService.toValue(java.lang.String.class,from.getLocation()));
    
  }
  
  public UIMeasureDevice copyFromEntity(final UIMeasureDevice result, final RCMeasureDevice entity) {
    if(entity==null) return null;
    result.setId(entity.getId());
    result.setVersion(entity.getVersion());
    result.setProxy(entity.toProxy());
    result.setClazzName(entity.getClass().getName());
    result.setSid(convertService.toValue(java.lang.String.class,entity.getSid()));
    result.setName(convertService.toValue(java.lang.String.class,entity.getName()));
    result.setLocation(convertService.toValue(java.lang.String.class,entity.getLocation()));
    return result;
    
  }
  
  public UIMeasureDevice buildFrom(final RCMeasureDevice entity) {
    if(entity==null) return null;
    com.fudanmed.platform.core.web.shared.measure.UIMeasureDevice result = new com.fudanmed.platform.core.web.shared.measure.UIMeasureDevice();
    copyFromEntity(result,entity);	
    return result;
    
  }
  
  public Class<?> getUIClass() {
    return UIMeasureDevice.class;
  }
  
  public Class<?> getEntityClass() {
    return RCMeasureDevice.class;
  }
}
