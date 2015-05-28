package com.fudanmed.platform.core.web.server.service.measure;

import com.fudanmed.platform.core.measure.RCPhasedElectricMeasureValue;
import com.fudanmed.platform.core.web.server.service.measure.PhasedElectricMeasureValueValidator;
import com.fudanmed.platform.core.web.shared.measure.UIPhasedElectricMeasureValue;
import com.uniquesoft.uidl.transform.AbstractEntityMapper;
import com.uniquesoft.uidl.transform.IConvertService;
import edu.fudan.mylang.pf.IObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("com.fudanmed.platform.core.web.server.service.measure.PhasedElectricMeasureValueMapper")
public class PhasedElectricMeasureValueMapper extends AbstractEntityMapper<UIPhasedElectricMeasureValue,RCPhasedElectricMeasureValue> {
  @Autowired
  private IConvertService convertService;
  
  @Autowired
  private IObjectFactory entities;
  
  public RCPhasedElectricMeasureValue loadEntityById(final Long id) {
    return entities.get(RCPhasedElectricMeasureValue.class,id);
  }
  
  public RCPhasedElectricMeasureValue create() {
    return entities.create(RCPhasedElectricMeasureValue.class);
  }
  
  @Autowired
  private PhasedElectricMeasureValueValidator validator;
  
  public void copyToEntity(final UIPhasedElectricMeasureValue from, final RCPhasedElectricMeasureValue to) {
    java.util.Collection<com.uniquesoft.gwt.shared.validation.ValidationErrorItem> errors = validator.validate(from);
    if(errors.size()!=0)throw new com.uniquesoft.gwt.shared.validation.ValidationException(errors);					
    to.setVersion(from.getVersion());
    to.setHighValue(convertService.toValue(java.lang.Double.class,from.getHighValue()));
    to.setAverageValue(convertService.toValue(java.lang.Double.class,from.getAverageValue()));
    to.setPeekValue(convertService.toValue(java.lang.Double.class,from.getPeekValue()));
    to.setLowValue(convertService.toValue(java.lang.Double.class,from.getLowValue()));
    to.setMaxRequiredValue(convertService.toValue(java.lang.Double.class,from.getMaxRequiredValue()));
    to.setMeasureDate(convertService.toValue(java.util.Date.class,from.getMeasureDate()));
    to.setNoPowerValue(convertService.toValue(java.lang.Double.class,from.getNoPowerValue()));
    to.setMeasurePerson(convertService.toValue(java.lang.String.class,from.getMeasurePerson()));
    
  }
  
  public UIPhasedElectricMeasureValue copyFromEntity(final UIPhasedElectricMeasureValue result, final RCPhasedElectricMeasureValue entity) {
    if(entity==null) return null;
    result.setId(entity.getId());
    result.setVersion(entity.getVersion());
    result.setProxy(entity.toProxy());
    result.setClazzName(entity.getClass().getName());
    result.setTotalEfficentPower(convertService.toValue(java.lang.Double.class,entity.getTotalEfficentPower()));
    result.setConsumedPower(convertService.toValue(java.lang.Double.class,entity.getConsumedPower()));
    result.setHighValue(convertService.toValue(java.lang.Double.class,entity.getHighValue()));
    result.setAverageValue(convertService.toValue(java.lang.Double.class,entity.getAverageValue()));
    result.setPeekValue(convertService.toValue(java.lang.Double.class,entity.getPeekValue()));
    result.setLowValue(convertService.toValue(java.lang.Double.class,entity.getLowValue()));
    result.setMaxRequiredValue(convertService.toValue(java.lang.Double.class,entity.getMaxRequiredValue()));
    result.setMeasureDate(convertService.toValue(java.util.Date.class,entity.getMeasureDate()));
    result.setNoPowerValue(convertService.toValue(java.lang.Double.class,entity.getNoPowerValue()));
    result.setMeasurePerson(convertService.toValue(java.lang.String.class,entity.getMeasurePerson()));
    return result;
    
  }
  
  public UIPhasedElectricMeasureValue buildFrom(final RCPhasedElectricMeasureValue entity) {
    if(entity==null) return null;
    com.fudanmed.platform.core.web.shared.measure.UIPhasedElectricMeasureValue result = new com.fudanmed.platform.core.web.shared.measure.UIPhasedElectricMeasureValue();
    copyFromEntity(result,entity);	
    return result;
    
  }
  
  public Class<?> getUIClass() {
    return UIPhasedElectricMeasureValue.class;
  }
  
  public Class<?> getEntityClass() {
    return RCPhasedElectricMeasureValue.class;
  }
}
