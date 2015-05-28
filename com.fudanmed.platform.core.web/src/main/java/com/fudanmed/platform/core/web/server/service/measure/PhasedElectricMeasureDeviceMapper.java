package com.fudanmed.platform.core.web.server.service.measure;

import com.fudanmed.platform.core.measure.RCPhasedElectricMeasureDevice;
import com.fudanmed.platform.core.web.server.service.measure.PhasedElectricMeasureDeviceValidator;
import com.fudanmed.platform.core.web.shared.measure.UIPhasedElectricMeasureDevice;
import com.uniquesoft.uidl.transform.AbstractEntityMapper;
import com.uniquesoft.uidl.transform.IConvertService;
import edu.fudan.mylang.pf.IObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("com.fudanmed.platform.core.web.server.service.measure.PhasedElectricMeasureDeviceMapper")
public class PhasedElectricMeasureDeviceMapper extends AbstractEntityMapper<UIPhasedElectricMeasureDevice,RCPhasedElectricMeasureDevice> {
  @Autowired
  private IConvertService convertService;
  
  @Autowired
  private IObjectFactory entities;
  
  public RCPhasedElectricMeasureDevice loadEntityById(final Long id) {
    return entities.get(RCPhasedElectricMeasureDevice.class,id);
  }
  
  public RCPhasedElectricMeasureDevice create() {
    return entities.create(RCPhasedElectricMeasureDevice.class);
  }
  
  @Autowired
  private PhasedElectricMeasureDeviceValidator validator;
  
  public void copyToEntity(final UIPhasedElectricMeasureDevice from, final RCPhasedElectricMeasureDevice to) {
    java.util.Collection<com.uniquesoft.gwt.shared.validation.ValidationErrorItem> errors = validator.validate(from);
    if(errors.size()!=0)throw new com.uniquesoft.gwt.shared.validation.ValidationException(errors);					
    to.setVersion(from.getVersion());
    to.setSid(convertService.toValue(java.lang.String.class,from.getSid()));
    to.setName(convertService.toValue(java.lang.String.class,from.getName()));
    to.setLocation(convertService.toValue(java.lang.String.class,from.getLocation()));
    to.setFactor(convertService.toValue(java.lang.Double.class,from.getFactor()));
    
  }
  
  public UIPhasedElectricMeasureDevice copyFromEntity(final UIPhasedElectricMeasureDevice result, final RCPhasedElectricMeasureDevice entity) {
    if(entity==null) return null;
    result.setId(entity.getId());
    result.setVersion(entity.getVersion());
    result.setProxy(entity.toProxy());
    result.setClazzName(entity.getClass().getName());
    result.setSid(convertService.toValue(java.lang.String.class,entity.getSid()));
    result.setName(convertService.toValue(java.lang.String.class,entity.getName()));
    result.setLocation(convertService.toValue(java.lang.String.class,entity.getLocation()));
    result.setFactor(convertService.toValue(java.lang.Double.class,entity.getFactor()));
    return result;
    
  }
  
  public UIPhasedElectricMeasureDevice buildFrom(final RCPhasedElectricMeasureDevice entity) {
    if(entity==null) return null;
    com.fudanmed.platform.core.web.shared.measure.UIPhasedElectricMeasureDevice result = new com.fudanmed.platform.core.web.shared.measure.UIPhasedElectricMeasureDevice();
    copyFromEntity(result,entity);	
    return result;
    
  }
  
  public Class<?> getUIClass() {
    return UIPhasedElectricMeasureDevice.class;
  }
  
  public Class<?> getEntityClass() {
    return RCPhasedElectricMeasureDevice.class;
  }
}
