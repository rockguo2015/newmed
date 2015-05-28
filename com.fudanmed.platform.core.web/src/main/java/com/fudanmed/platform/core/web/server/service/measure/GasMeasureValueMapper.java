package com.fudanmed.platform.core.web.server.service.measure;

import com.fudanmed.platform.core.measure.RCGasMeasureValue;
import com.fudanmed.platform.core.web.server.service.measure.GasMeasureValueValidator;
import com.fudanmed.platform.core.web.shared.measure.UIGasMeasureValue;
import com.uniquesoft.uidl.transform.AbstractEntityMapper;
import com.uniquesoft.uidl.transform.IConvertService;
import edu.fudan.mylang.pf.IObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("com.fudanmed.platform.core.web.server.service.measure.GasMeasureValueMapper")
public class GasMeasureValueMapper extends AbstractEntityMapper<UIGasMeasureValue,RCGasMeasureValue> {
  @Autowired
  private IConvertService convertService;
  
  @Autowired
  private IObjectFactory entities;
  
  public RCGasMeasureValue loadEntityById(final Long id) {
    return entities.get(RCGasMeasureValue.class,id);
  }
  
  public RCGasMeasureValue create() {
    return entities.create(RCGasMeasureValue.class);
  }
  
  @Autowired
  private GasMeasureValueValidator validator;
  
  public void copyToEntity(final UIGasMeasureValue from, final RCGasMeasureValue to) {
    java.util.Collection<com.uniquesoft.gwt.shared.validation.ValidationErrorItem> errors = validator.validate(from);
    if(errors.size()!=0)throw new com.uniquesoft.gwt.shared.validation.ValidationException(errors);					
    to.setVersion(from.getVersion());
    to.setValue(convertService.toValue(java.lang.Double.class,from.getTheValue()));
    to.setMeasureDate(convertService.toValue(java.util.Date.class,from.getMeasureDate()));
    to.setMeasurePerson(convertService.toValue(java.lang.String.class,from.getMeasurePerson()));
    
  }
  
  public UIGasMeasureValue copyFromEntity(final UIGasMeasureValue result, final RCGasMeasureValue entity) {
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
  
  public UIGasMeasureValue buildFrom(final RCGasMeasureValue entity) {
    if(entity==null) return null;
    com.fudanmed.platform.core.web.shared.measure.UIGasMeasureValue result = new com.fudanmed.platform.core.web.shared.measure.UIGasMeasureValue();
    copyFromEntity(result,entity);	
    return result;
    
  }
  
  public Class<?> getUIClass() {
    return UIGasMeasureValue.class;
  }
  
  public Class<?> getEntityClass() {
    return RCGasMeasureValue.class;
  }
}
