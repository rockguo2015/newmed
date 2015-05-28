package com.fudanmed.platform.core.web.server.service.deliver;

import com.fudanmed.platform.core.deliver.DLInHospitalPatient;
import com.fudanmed.platform.core.web.server.service.deliver.InHospitalPatientValidator;
import com.fudanmed.platform.core.web.shared.deliver.UIInHospitalPatient;
import com.uniquesoft.uidl.transform.AbstractEntityMapper;
import com.uniquesoft.uidl.transform.IConvertService;
import edu.fudan.mylang.pf.IObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("com.fudanmed.platform.core.web.server.service.deliver.InHospitalPatientMapper")
public class InHospitalPatientMapper extends AbstractEntityMapper<UIInHospitalPatient,DLInHospitalPatient> {
  @Autowired
  private IConvertService convertService;
  
  @Autowired
  private IObjectFactory entities;
  
  public DLInHospitalPatient loadEntityById(final Long id) {
    return entities.get(DLInHospitalPatient.class,id);
  }
  
  public DLInHospitalPatient create() {
    return entities.create(DLInHospitalPatient.class);
  }
  
  @Autowired
  private InHospitalPatientValidator validator;
  
  public void copyToEntity(final UIInHospitalPatient from, final DLInHospitalPatient to) {
    java.util.Collection<com.uniquesoft.gwt.shared.validation.ValidationErrorItem> errors = validator.validate(from);
    if(errors.size()!=0)throw new com.uniquesoft.gwt.shared.validation.ValidationException(errors);					
    to.setVersion(from.getVersion());
    to.setName(convertService.toValue(java.lang.String.class,from.getName()));
    to.setSid(convertService.toValue(java.lang.String.class,from.getSid()));
    to.setAge(convertService.toValue(java.lang.Integer.class,from.getAge()));
    to.setGender(convertService.toValue(com.fudanmed.platform.core.deliver.DLGender.class,from.getGender()));
    to.setLocation(convertService.toValue(com.fudanmed.platform.core.deliver.DLInHospitalLocation.class,from.getLocation()));
    to.setBedNumber(convertService.toValue(java.lang.String.class,from.getBedNumber()));
    
  }
  
  public UIInHospitalPatient copyFromEntity(final UIInHospitalPatient result, final DLInHospitalPatient entity) {
    if(entity==null) return null;
    result.setId(entity.getId());
    result.setVersion(entity.getVersion());
    result.setProxy(entity.toProxy());
    result.setClazzName(entity.getClass().getName());
    result.setName(convertService.toValue(java.lang.String.class,entity.getName()));
    result.setSid(convertService.toValue(java.lang.String.class,entity.getSid()));
    result.setAge(convertService.toValue(java.lang.Integer.class,entity.getAge()));
    result.setGender(convertService.toValue(com.fudanmed.platform.core.web.shared.deliver.UIGender.class,entity.getGender()));
    result.setLocation(convertService.toValue(com.fudanmed.platform.core.deliver.proxy.DLInHospitalLocationProxy.class,entity.getLocation()));
    result.setBedNumber(convertService.toValue(java.lang.String.class,entity.getBedNumber()));
    return result;
    
  }
  
  public UIInHospitalPatient buildFrom(final DLInHospitalPatient entity) {
    if(entity==null) return null;
    com.fudanmed.platform.core.web.shared.deliver.UIInHospitalPatient result = new com.fudanmed.platform.core.web.shared.deliver.UIInHospitalPatient();
    copyFromEntity(result,entity);	
    return result;
    
  }
  
  public Class<?> getUIClass() {
    return UIInHospitalPatient.class;
  }
  
  public Class<?> getEntityClass() {
    return DLInHospitalPatient.class;
  }
}
