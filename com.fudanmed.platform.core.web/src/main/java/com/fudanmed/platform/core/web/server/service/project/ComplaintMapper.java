package com.fudanmed.platform.core.web.server.service.project;

import com.fudanmed.platform.core.domain.RCComplaint;
import com.fudanmed.platform.core.web.server.service.project.ComplaintValidator;
import com.fudanmed.platform.core.web.shared.project.UIComplaint;
import com.uniquesoft.uidl.transform.AbstractEntityMapper;
import com.uniquesoft.uidl.transform.IConvertService;
import edu.fudan.mylang.pf.IObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("com.fudanmed.platform.core.web.server.service.project.ComplaintMapper")
public class ComplaintMapper extends AbstractEntityMapper<UIComplaint,RCComplaint> {
  @Autowired
  private IConvertService convertService;
  
  @Autowired
  private IObjectFactory entities;
  
  public RCComplaint loadEntityById(final Long id) {
    return entities.get(RCComplaint.class,id);
  }
  
  public RCComplaint create() {
    return entities.create(RCComplaint.class);
  }
  
  @Autowired
  private ComplaintValidator validator;
  
  public void copyToEntity(final UIComplaint from, final RCComplaint to) {
    java.util.Collection<com.uniquesoft.gwt.shared.validation.ValidationErrorItem> errors = validator.validate(from);
    if(errors.size()!=0)throw new com.uniquesoft.gwt.shared.validation.ValidationException(errors);					
    to.setVersion(from.getVersion());
    to.setDate(convertService.toValue(java.util.Date.class,from.getDate()));
    to.setContents(convertService.toValue(java.lang.String.class,from.getContents()));
    to.setOwner(convertService.toValue(com.fudanmed.platform.core.domain.RCEmployee.class,from.getOwner()));
    
  }
  
  public UIComplaint copyFromEntity(final UIComplaint result, final RCComplaint entity) {
    if(entity==null) return null;
    result.setId(entity.getId());
    result.setVersion(entity.getVersion());
    result.setProxy(entity.toProxy());
    result.setClazzName(entity.getClass().getName());
    result.setDate(convertService.toValue(java.util.Date.class,entity.getDate()));
    result.setContents(convertService.toValue(java.lang.String.class,entity.getContents()));
    result.setOwner(convertService.toValue(com.fudanmed.platform.core.domain.proxy.RCEmployeeProxy.class,entity.getOwner()));
    return result;
    
  }
  
  public UIComplaint buildFrom(final RCComplaint entity) {
    if(entity==null) return null;
    com.fudanmed.platform.core.web.shared.project.UIComplaint result = new com.fudanmed.platform.core.web.shared.project.UIComplaint();
    copyFromEntity(result,entity);	
    return result;
    
  }
  
  public Class<?> getUIClass() {
    return UIComplaint.class;
  }
  
  public Class<?> getEntityClass() {
    return RCComplaint.class;
  }
}
