package com.fudanmed.platform.core.web.server.service.deliver;

import com.fudanmed.platform.core.deliver.DLInHospitalLocation;
import com.fudanmed.platform.core.web.server.service.deliver.InHospitalLocationValidator;
import com.fudanmed.platform.core.web.shared.deliver.UIInHospitalLocation;
import com.uniquesoft.uidl.transform.AbstractEntityMapper;
import com.uniquesoft.uidl.transform.IConvertService;
import edu.fudan.mylang.pf.IObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("com.fudanmed.platform.core.web.server.service.deliver.InHospitalLocationMapper")
public class InHospitalLocationMapper extends AbstractEntityMapper<UIInHospitalLocation,DLInHospitalLocation> {
  @Autowired
  private IConvertService convertService;
  
  @Autowired
  private IObjectFactory entities;
  
  public DLInHospitalLocation loadEntityById(final Long id) {
    return entities.get(DLInHospitalLocation.class,id);
  }
  
  public DLInHospitalLocation create() {
    return entities.create(DLInHospitalLocation.class);
  }
  
  @Autowired
  private InHospitalLocationValidator validator;
  
  public void copyToEntity(final UIInHospitalLocation from, final DLInHospitalLocation to) {
    java.util.Collection<com.uniquesoft.gwt.shared.validation.ValidationErrorItem> errors = validator.validate(from);
    if(errors.size()!=0)throw new com.uniquesoft.gwt.shared.validation.ValidationException(errors);					
    to.setVersion(from.getVersion());
    to.setCode(convertService.toValue(java.lang.String.class,from.getCode()));
    to.setName(convertService.toValue(java.lang.String.class,from.getName()));
    to.setLocation(convertService.toValue(com.fudanmed.platform.core.domain.RCOnsitePosition.class,from.getLocation()));
    
  }
  
  public UIInHospitalLocation copyFromEntity(final UIInHospitalLocation result, final DLInHospitalLocation entity) {
    if(entity==null) return null;
    result.setId(entity.getId());
    result.setVersion(entity.getVersion());
    result.setProxy(entity.toProxy());
    result.setClazzName(entity.getClass().getName());
    result.setCode(convertService.toValue(java.lang.String.class,entity.getCode()));
    result.setName(convertService.toValue(java.lang.String.class,entity.getName()));
    result.setLocation(convertService.toValue(com.fudanmed.platform.core.domain.proxy.RCOnsitePositionProxy.class,entity.getLocation()));
    return result;
    
  }
  
  public UIInHospitalLocation buildFrom(final DLInHospitalLocation entity) {
    if(entity==null) return null;
    com.fudanmed.platform.core.web.shared.deliver.UIInHospitalLocation result = new com.fudanmed.platform.core.web.shared.deliver.UIInHospitalLocation();
    copyFromEntity(result,entity);	
    return result;
    
  }
  
  public Class<?> getUIClass() {
    return UIInHospitalLocation.class;
  }
  
  public Class<?> getEntityClass() {
    return DLInHospitalLocation.class;
  }
}
