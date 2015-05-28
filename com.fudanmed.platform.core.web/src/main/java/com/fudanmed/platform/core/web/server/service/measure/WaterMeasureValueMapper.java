package com.fudanmed.platform.core.web.server.service.measure;

import com.fudanmed.platform.core.measure.RCWaterMeasureValue;
import com.fudanmed.platform.core.web.server.service.measure.WaterMeasureValueValidator;
import com.fudanmed.platform.core.web.shared.measure.UIWaterMeasureValue;
import com.uniquesoft.uidl.transform.AbstractEntityMapper;
import com.uniquesoft.uidl.transform.IConvertService;
import edu.fudan.mylang.pf.IObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("com.fudanmed.platform.core.web.server.service.measure.WaterMeasureValueMapper")
public class WaterMeasureValueMapper extends AbstractEntityMapper<UIWaterMeasureValue,RCWaterMeasureValue> {
  @Autowired
  private IConvertService convertService;
  
  @Autowired
  private IObjectFactory entities;
  
  public RCWaterMeasureValue loadEntityById(final Long id) {
    return entities.get(RCWaterMeasureValue.class,id);
  }
  
  public RCWaterMeasureValue create() {
    return entities.create(RCWaterMeasureValue.class);
  }
  
  @Autowired
  private WaterMeasureValueValidator validator;
  
  public void copyToEntity(final UIWaterMeasureValue from, final RCWaterMeasureValue to) {
    java.util.Collection<com.uniquesoft.gwt.shared.validation.ValidationErrorItem> errors = validator.validate(from);
    if(errors.size()!=0)throw new com.uniquesoft.gwt.shared.validation.ValidationException(errors);					
    to.setVersion(from.getVersion());
    to.setValue(convertService.toValue(java.lang.Double.class,from.getTheValue()));
    to.setMeasureDate(convertService.toValue(java.util.Date.class,from.getMeasureDate()));
    to.setMeasurePerson(convertService.toValue(java.lang.String.class,from.getMeasurePerson()));
    
  }
  
  public UIWaterMeasureValue copyFromEntity(final UIWaterMeasureValue result, final RCWaterMeasureValue entity) {
    if(entity==null) return null;
    result.setId(entity.getId());
    result.setVersion(entity.getVersion());
    result.setProxy(entity.toProxy());
    result.setClazzName(entity.getClass().getName());
    	result.setTheValue(convertService.toValue(java.lang.Double.class,entity.getValue()));
    result.setMeasureDate(convertService.toValue(java.util.Date.class,entity.getMeasureDate()));
    result.setMeasurePerson(convertService.toValue(java.lang.String.class,entity.getMeasurePerson()));
    result.setIncrementalValue(convertService.toValue(java.lang.Double.class,entity.getIncrementalValue()));
    return result;
    
  }
  
  public UIWaterMeasureValue buildFrom(final RCWaterMeasureValue entity) {
    if(entity==null) return null;
    com.fudanmed.platform.core.web.shared.measure.UIWaterMeasureValue result = new com.fudanmed.platform.core.web.shared.measure.UIWaterMeasureValue();
    copyFromEntity(result,entity);	
    return result;
    
  }
  
  public Class<?> getUIClass() {
    return UIWaterMeasureValue.class;
  }
  
  public Class<?> getEntityClass() {
    return RCWaterMeasureValue.class;
  }
}
