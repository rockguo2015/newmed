package com.fudanmed.platform.core.web.server.service.measure;

import com.fudanmed.platform.core.measure.RCElectricMeasureDevice;
import com.fudanmed.platform.core.web.server.service.measure.ElectricMeasureDeviceValidator;
import com.fudanmed.platform.core.web.shared.measure.UIElectricMeasureDevice;
import com.uniquesoft.uidl.transform.AbstractEntityMapper;
import com.uniquesoft.uidl.transform.IConvertService;
import edu.fudan.mylang.pf.IObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("com.fudanmed.platform.core.web.server.service.measure.ElectricMeasureDeviceMapper")
public class ElectricMeasureDeviceMapper extends AbstractEntityMapper<UIElectricMeasureDevice,RCElectricMeasureDevice> {
  @Autowired
  private IConvertService convertService;
  
  @Autowired
  private IObjectFactory entities;
  
  public RCElectricMeasureDevice loadEntityById(final Long id) {
    return entities.get(RCElectricMeasureDevice.class,id);
  }
  
  public RCElectricMeasureDevice create() {
    return entities.create(RCElectricMeasureDevice.class);
  }
  
  @Autowired
  private ElectricMeasureDeviceValidator validator;
  
  public void copyToEntity(final UIElectricMeasureDevice from, final RCElectricMeasureDevice to) {
    java.util.Collection<com.uniquesoft.gwt.shared.validation.ValidationErrorItem> errors = validator.validate(from);
    if(errors.size()!=0)throw new com.uniquesoft.gwt.shared.validation.ValidationException(errors);					
    to.setVersion(from.getVersion());
    to.setSid(convertService.toValue(java.lang.String.class,from.getSid()));
    to.setName(convertService.toValue(java.lang.String.class,from.getName()));
    to.setLocation(convertService.toValue(java.lang.String.class,from.getLocation()));
    
  }
  
  public UIElectricMeasureDevice copyFromEntity(final UIElectricMeasureDevice result, final RCElectricMeasureDevice entity) {
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
  
  public UIElectricMeasureDevice buildFrom(final RCElectricMeasureDevice entity) {
    if(entity==null) return null;
    com.fudanmed.platform.core.web.shared.measure.UIElectricMeasureDevice result = new com.fudanmed.platform.core.web.shared.measure.UIElectricMeasureDevice();
    copyFromEntity(result,entity);	
    return result;
    
  }
  
  public Class<?> getUIClass() {
    return UIElectricMeasureDevice.class;
  }
  
  public Class<?> getEntityClass() {
    return RCElectricMeasureDevice.class;
  }
}
