package com.fudanmed.platform.core.web.server.service.measure;

import com.fudanmed.platform.core.measure.RCWaterMeasureDevice;
import com.fudanmed.platform.core.web.server.service.measure.WaterMeasureDeviceValidator;
import com.fudanmed.platform.core.web.shared.measure.UIWaterMeasureDevice;
import com.uniquesoft.uidl.transform.AbstractEntityMapper;
import com.uniquesoft.uidl.transform.IConvertService;
import edu.fudan.mylang.pf.IObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("com.fudanmed.platform.core.web.server.service.measure.WaterMeasureDeviceMapper")
public class WaterMeasureDeviceMapper extends AbstractEntityMapper<UIWaterMeasureDevice,RCWaterMeasureDevice> {
  @Autowired
  private IConvertService convertService;
  
  @Autowired
  private IObjectFactory entities;
  
  public RCWaterMeasureDevice loadEntityById(final Long id) {
    return entities.get(RCWaterMeasureDevice.class,id);
  }
  
  public RCWaterMeasureDevice create() {
    return entities.create(RCWaterMeasureDevice.class);
  }
  
  @Autowired
  private WaterMeasureDeviceValidator validator;
  
  public void copyToEntity(final UIWaterMeasureDevice from, final RCWaterMeasureDevice to) {
    java.util.Collection<com.uniquesoft.gwt.shared.validation.ValidationErrorItem> errors = validator.validate(from);
    if(errors.size()!=0)throw new com.uniquesoft.gwt.shared.validation.ValidationException(errors);					
    to.setVersion(from.getVersion());
    to.setSid(convertService.toValue(java.lang.String.class,from.getSid()));
    to.setName(convertService.toValue(java.lang.String.class,from.getName()));
    to.setLocation(convertService.toValue(java.lang.String.class,from.getLocation()));
    
  }
  
  public UIWaterMeasureDevice copyFromEntity(final UIWaterMeasureDevice result, final RCWaterMeasureDevice entity) {
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
  
  public UIWaterMeasureDevice buildFrom(final RCWaterMeasureDevice entity) {
    if(entity==null) return null;
    com.fudanmed.platform.core.web.shared.measure.UIWaterMeasureDevice result = new com.fudanmed.platform.core.web.shared.measure.UIWaterMeasureDevice();
    copyFromEntity(result,entity);	
    return result;
    
  }
  
  public Class<?> getUIClass() {
    return UIWaterMeasureDevice.class;
  }
  
  public Class<?> getEntityClass() {
    return RCWaterMeasureDevice.class;
  }
}
