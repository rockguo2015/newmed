package com.fudanmed.platform.core.web.server.service.workbench;

import com.fudanmed.platform.core.common.RCSystemParameter;
import com.fudanmed.platform.core.web.server.service.workbench.SystemParameterValidator;
import com.fudanmed.platform.core.web.shared.workbench.UISystemParameter;
import com.uniquesoft.uidl.transform.AbstractEntityMapper;
import com.uniquesoft.uidl.transform.IConvertService;
import edu.fudan.mylang.pf.IObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("com.fudanmed.platform.core.web.server.service.workbench.SystemParameterMapper")
public class SystemParameterMapper extends AbstractEntityMapper<UISystemParameter,RCSystemParameter> {
  @Autowired
  private IConvertService convertService;
  
  @Autowired
  private IObjectFactory entities;
  
  public RCSystemParameter loadEntityById(final Long id) {
    return entities.get(RCSystemParameter.class,id);
  }
  
  public RCSystemParameter create() {
    return entities.create(RCSystemParameter.class);
  }
  
  @Autowired
  private SystemParameterValidator validator;
  
  public void copyToEntity(final UISystemParameter from, final RCSystemParameter to) {
    java.util.Collection<com.uniquesoft.gwt.shared.validation.ValidationErrorItem> errors = validator.validate(from);
    if(errors.size()!=0)throw new com.uniquesoft.gwt.shared.validation.ValidationException(errors);					
    to.setVersion(from.getVersion());
    to.setApplicationTitle(convertService.toValue(java.lang.String.class,from.getApplicationTitle()));
    to.setRefreshInterval(convertService.toValue(java.lang.Integer.class,from.getRefreshInterval()));
    to.setCustomerEvalCommitInterval(convertService.toValue(java.lang.Integer.class,from.getCustomerEvalCommitInterval()));
    to.setOrgName(convertService.toValue(java.lang.String.class,from.getOrgName()));
    to.setEboardRefreshInterval(convertService.toValue(java.lang.Integer.class,from.getEboardRefreshInterval()));
    
  }
  
  public UISystemParameter copyFromEntity(final UISystemParameter result, final RCSystemParameter entity) {
    if(entity==null) return null;
    result.setId(entity.getId());
    result.setVersion(entity.getVersion());
    result.setProxy(entity.toProxy());
    result.setClazzName(entity.getClass().getName());
    result.setApplicationTitle(convertService.toValue(java.lang.String.class,entity.getApplicationTitle()));
    result.setRefreshInterval(convertService.toValue(java.lang.Integer.class,entity.getRefreshInterval()));
    result.setCustomerEvalCommitInterval(convertService.toValue(java.lang.Integer.class,entity.getCustomerEvalCommitInterval()));
    result.setOrgName(convertService.toValue(java.lang.String.class,entity.getOrgName()));
    result.setEboardRefreshInterval(convertService.toValue(java.lang.Integer.class,entity.getEboardRefreshInterval()));
    return result;
    
  }
  
  public UISystemParameter buildFrom(final RCSystemParameter entity) {
    if(entity==null) return null;
    com.fudanmed.platform.core.web.shared.workbench.UISystemParameter result = new com.fudanmed.platform.core.web.shared.workbench.UISystemParameter();
    copyFromEntity(result,entity);	
    return result;
    
  }
  
  public Class<?> getUIClass() {
    return UISystemParameter.class;
  }
  
  public Class<?> getEntityClass() {
    return RCSystemParameter.class;
  }
}
