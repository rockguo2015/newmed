package com.fudanmed.platform.core.web.server.service.measure;

import com.fudanmed.platform.core.measure.RCGasMeasureDevice;
import com.fudanmed.platform.core.web.server.service.measure.GasMeasureDeviceValidator;
import com.fudanmed.platform.core.web.shared.measure.UIGasMeasureDevice;
import com.uniquesoft.uidl.transform.AbstractEntityMapper;
import com.uniquesoft.uidl.transform.IConvertService;
import edu.fudan.mylang.pf.IObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("com.fudanmed.platform.core.web.server.service.measure.GasMeasureDeviceMapper")
public class GasMeasureDeviceMapper extends AbstractEntityMapper<UIGasMeasureDevice,RCGasMeasureDevice> {
  @Autowired
  private IConvertService convertService;
  
  @Autowired
  private IObjectFactory entities;
  
  public RCGasMeasureDevice loadEntityById(final Long id) {
    return entities.get(RCGasMeasureDevice.class,id);
  }
  
  public RCGasMeasureDevice create() {
    return entities.create(RCGasMeasureDevice.class);
  }
  
  @Autowired
  private GasMeasureDeviceValidator validator;
  
  public void copyToEntity(final UIGasMeasureDevice from, final RCGasMeasureDevice to) {
    java.util.Collection<com.uniquesoft.gwt.shared.validation.ValidationErrorItem> errors = validator.validate(from);
    if(errors.size()!=0)throw new com.uniquesoft.gwt.shared.validation.ValidationException(errors);					
    to.setVersion(from.getVersion());
    to.setSid(convertService.toValue(java.lang.String.class,from.getSid()));
    to.setName(convertService.toValue(java.lang.String.class,from.getName()));
    to.setLocation(convertService.toValue(java.lang.String.class,from.getLocation()));
    
  }
  
  public UIGasMeasureDevice copyFromEntity(final UIGasMeasureDevice result, final RCGasMeasureDevice entity) {
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
  
  public UIGasMeasureDevice buildFrom(final RCGasMeasureDevice entity) {
    if(entity==null) return null;
    com.fudanmed.platform.core.web.shared.measure.UIGasMeasureDevice result = new com.fudanmed.platform.core.web.shared.measure.UIGasMeasureDevice();
    copyFromEntity(result,entity);	
    return result;
    
  }
  
  public Class<?> getUIClass() {
    return UIGasMeasureDevice.class;
  }
  
  public Class<?> getEntityClass() {
    return RCGasMeasureDevice.class;
  }
}
