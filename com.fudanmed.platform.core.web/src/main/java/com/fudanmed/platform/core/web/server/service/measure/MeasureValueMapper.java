package com.fudanmed.platform.core.web.server.service.measure;

import com.fudanmed.platform.core.measure.RCMeasureValue;
import com.fudanmed.platform.core.web.shared.measure.UIMeasureValue;
import com.uniquesoft.uidl.transform.AbstractEntityMapper;
import com.uniquesoft.uidl.transform.IConvertService;
import edu.fudan.mylang.pf.IObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("com.fudanmed.platform.core.web.server.service.measure.MeasureValueMapper")
public class MeasureValueMapper extends AbstractEntityMapper<UIMeasureValue,RCMeasureValue> {
  @Autowired
  private IConvertService convertService;
  
  @Autowired
  private IObjectFactory entities;
  
  public RCMeasureValue loadEntityById(final Long id) {
    return entities.get(RCMeasureValue.class,id);
  }
  
  public RCMeasureValue create() {
    return entities.create(RCMeasureValue.class);
  }
  
  public void copyToEntity(final UIMeasureValue from, final RCMeasureValue to) {
    to.setVersion(from.getVersion());
    
  }
  
  public UIMeasureValue copyFromEntity(final UIMeasureValue result, final RCMeasureValue entity) {
    if(entity==null) return null;
    result.setId(entity.getId());
    result.setVersion(entity.getVersion());
    result.setProxy(entity.toProxy());
    result.setClazzName(entity.getClass().getName());
    result.setMeasureDate(convertService.toValue(java.util.Date.class,entity.getMeasureDate()));
    result.setMeasurePerson(convertService.toValue(java.lang.String.class,entity.getMeasurePerson()));
    buildFromCust(result,entity);
    return result;
    
  }
  
  public UIMeasureValue buildFrom(final RCMeasureValue entity) {
    if(entity==null) return null;
    com.fudanmed.platform.core.web.shared.measure.UIMeasureValue result = new com.fudanmed.platform.core.web.shared.measure.UIMeasureValue();
    copyFromEntity(result,entity);	
    return result;
    
  }
  
  protected void buildFromCust(final UIMeasureValue _gwt, final RCMeasureValue _entity) {
    String _valueString = _entity.toValueString();
    _gwt.setValueString(_valueString);
  }
  
  public Class<?> getUIClass() {
    return UIMeasureValue.class;
  }
  
  public Class<?> getEntityClass() {
    return RCMeasureValue.class;
  }
}
