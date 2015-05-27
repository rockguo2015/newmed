package edu.fudan.langlab.uidl.domain.app.server.service.security;

import com.uniquesoft.uidl.transform.AbstractEntityMapper;
import com.uniquesoft.uidl.transform.IConvertService;
import edu.fudan.langlab.domain.security.AppFunction;
import edu.fudan.langlab.uidl.domain.app.shared.security.UIAppFunction;
import edu.fudan.mylang.pf.IObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("edu.fudan.langlab.uidl.domain.app.server.service.security.AppFunctionMapper")
public class AppFunctionMapper extends AbstractEntityMapper<UIAppFunction,AppFunction> {
  @Autowired
  private IConvertService convertService;
  
  @Autowired
  private IObjectFactory entities;
  
  public AppFunction loadEntityById(final Long id) {
    return entities.get(AppFunction.class,id);
  }
  
  public AppFunction create() {
    return entities.create(AppFunction.class);
  }
  
  public void copyToEntity(final UIAppFunction from, final AppFunction to) {
    to.setVersion(from.getVersion());
    to.setParentFunctionId(convertService.toValue(java.lang.String.class,from.getParentFunctionId()));
    to.setFunctionId(convertService.toValue(java.lang.String.class,from.getFunctionId()));
    to.setName(convertService.toValue(java.lang.String.class,from.getName()));
    
  }
  
  public UIAppFunction copyFromEntity(final UIAppFunction result, final AppFunction entity) {
    if(entity==null) return null;
    result.setId(entity.getId());
    result.setVersion(entity.getVersion());
    result.setProxy(entity.toProxy());
    result.setClazzName(entity.getClass().getName());
    result.setParentFunctionId(convertService.toValue(java.lang.String.class,entity.getParentFunctionId()));
    result.setFunctionId(convertService.toValue(java.lang.String.class,entity.getFunctionId()));
    result.setName(convertService.toValue(java.lang.String.class,entity.getName()));
    return result;
    
  }
  
  public UIAppFunction buildFrom(final AppFunction entity) {
    if(entity==null) return null;
    edu.fudan.langlab.uidl.domain.app.shared.security.UIAppFunction result = new edu.fudan.langlab.uidl.domain.app.shared.security.UIAppFunction();
    copyFromEntity(result,entity);	
    return result;
    
  }
  
  public Class<?> getUIClass() {
    return UIAppFunction.class;
  }
  
  public Class<?> getEntityClass() {
    return AppFunction.class;
  }
}
