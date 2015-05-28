package com.fudanmed.platform.core.web.server.service.measure;

import com.fudanmed.platform.core.measure.RCMeasureValueCriteria;
import com.fudanmed.platform.core.web.shared.measure.UIMeasureValueCriteria;
import com.uniquesoft.uidl.transform.AbstractDataTypeMapper;
import com.uniquesoft.uidl.transform.IConvertService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("com.fudanmed.platform.core.web.server.service.measure.MeasureValueCriteriaMapper")
public class MeasureValueCriteriaMapper extends AbstractDataTypeMapper<UIMeasureValueCriteria,RCMeasureValueCriteria> {
  @Autowired
  private IConvertService convertService;
  
  public void copyToEntity(final UIMeasureValueCriteria from, final RCMeasureValueCriteria to) {
    to.setDeviceType(convertService.toValue(com.fudanmed.platform.core.measure.RCMeasureDeviceType.class,from.getDeviceType()));
    to.setDevice(convertService.toValue(com.fudanmed.platform.core.measure.RCMeasureDevice.class,from.getDevice()));
    to.setMeasureDateFrom(convertService.toValue(java.util.Date.class,from.getMeasureDateFrom()));
    to.setMeasureDateTo(convertService.toValue(java.util.Date.class,from.getMeasureDateTo()));
    
  }
  
  public UIMeasureValueCriteria copyFromEntity(final UIMeasureValueCriteria result, final RCMeasureValueCriteria entity) {
    if(entity==null) return null;
    result.setDeviceType(convertService.toValue(com.fudanmed.platform.core.measure.proxy.RCMeasureDeviceTypeProxy.class,entity.getDeviceType()));
    result.setDevice(convertService.toValue(com.fudanmed.platform.core.measure.proxy.RCMeasureDeviceProxy.class,entity.getDevice()));
    result.setMeasureDateFrom(convertService.toValue(java.util.Date.class,entity.getMeasureDateFrom()));
    result.setMeasureDateTo(convertService.toValue(java.util.Date.class,entity.getMeasureDateTo()));
    return result;
    
  }
  
  public UIMeasureValueCriteria buildFrom(final RCMeasureValueCriteria entity) {
    if(entity==null) return null;
    com.fudanmed.platform.core.web.shared.measure.UIMeasureValueCriteria result = new com.fudanmed.platform.core.web.shared.measure.UIMeasureValueCriteria();
    copyFromEntity(result,entity);	
    return result;
    
  }
  
  public Class<?> getUIClass() {
    return UIMeasureValueCriteria.class;
  }
  
  public Class<?> getEntityClass() {
    return RCMeasureValueCriteria.class;
  }
}
