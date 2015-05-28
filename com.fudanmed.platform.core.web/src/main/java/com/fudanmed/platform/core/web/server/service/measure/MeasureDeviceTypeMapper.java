package com.fudanmed.platform.core.web.server.service.measure;

import com.fudanmed.platform.core.measure.RCMeasureDeviceType;
import com.fudanmed.platform.core.web.shared.measure.UIMeasureDeviceType;
import com.uniquesoft.uidl.transform.AbstractEntityMapper;
import com.uniquesoft.uidl.transform.IConvertService;
import edu.fudan.mylang.pf.IObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("com.fudanmed.platform.core.web.server.service.measure.MeasureDeviceTypeMapper")
public class MeasureDeviceTypeMapper extends AbstractEntityMapper<UIMeasureDeviceType,RCMeasureDeviceType> {
  @Autowired
  private IConvertService convertService;
  
  @Autowired
  private IObjectFactory entities;
  
  public RCMeasureDeviceType loadEntityById(final Long id) {
    return entities.get(RCMeasureDeviceType.class,id);
  }
  
  public RCMeasureDeviceType create() {
    return entities.create(RCMeasureDeviceType.class);
  }
  
  public void copyToEntity(final UIMeasureDeviceType from, final RCMeasureDeviceType to) {
    to.setVersion(from.getVersion());
    to.setName(convertService.toValue(java.lang.String.class,from.getName()));
    
  }
  
  public UIMeasureDeviceType copyFromEntity(final UIMeasureDeviceType result, final RCMeasureDeviceType entity) {
    if(entity==null) return null;
    result.setId(entity.getId());
    result.setVersion(entity.getVersion());
    result.setProxy(entity.toProxy());
    result.setClazzName(entity.getClass().getName());
    result.setName(convertService.toValue(java.lang.String.class,entity.getName()));
    return result;
    
  }
  
  public UIMeasureDeviceType buildFrom(final RCMeasureDeviceType entity) {
    if(entity==null) return null;
    com.fudanmed.platform.core.web.shared.measure.UIMeasureDeviceType result = new com.fudanmed.platform.core.web.shared.measure.UIMeasureDeviceType();
    copyFromEntity(result,entity);	
    return result;
    
  }
  
  public Class<?> getUIClass() {
    return UIMeasureDeviceType.class;
  }
  
  public Class<?> getEntityClass() {
    return RCMeasureDeviceType.class;
  }
}
