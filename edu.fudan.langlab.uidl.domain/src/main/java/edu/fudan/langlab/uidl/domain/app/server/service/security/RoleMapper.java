package edu.fudan.langlab.uidl.domain.app.server.service.security;

import com.uniquesoft.uidl.transform.AbstractEntityMapper;
import com.uniquesoft.uidl.transform.IConvertService;
import edu.fudan.langlab.domain.security.Role;
import edu.fudan.langlab.uidl.domain.app.server.service.security.RoleValidator;
import edu.fudan.langlab.uidl.domain.app.shared.security.UIRole;
import edu.fudan.mylang.pf.IObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("edu.fudan.langlab.uidl.domain.app.server.service.security.RoleMapper")
public class RoleMapper extends AbstractEntityMapper<UIRole,Role> {
  @Autowired
  private IConvertService convertService;
  
  @Autowired
  private IObjectFactory entities;
  
  public Role loadEntityById(final Long id) {
    return entities.get(Role.class,id);
  }
  
  public Role create() {
    return entities.create(Role.class);
  }
  
  @Autowired
  private RoleValidator validator;
  
  public void copyToEntity(final UIRole from, final Role to) {
    java.util.Collection<com.uniquesoft.gwt.shared.validation.ValidationErrorItem> errors = validator.validate(from);
    if(errors.size()!=0)throw new com.uniquesoft.gwt.shared.validation.ValidationException(errors);					
    to.setVersion(from.getVersion());
    to.setRoleId(convertService.toValue(java.lang.String.class,from.getRoleId()));
    to.setName(convertService.toValue(java.lang.String.class,from.getName()));
    
  }
  
  public UIRole copyFromEntity(final UIRole result, final Role entity) {
    if(entity==null) return null;
    result.setId(entity.getId());
    result.setVersion(entity.getVersion());
    result.setProxy(entity.toProxy());
    result.setClazzName(entity.getClass().getName());
    result.setRoleId(convertService.toValue(java.lang.String.class,entity.getRoleId()));
    result.setName(convertService.toValue(java.lang.String.class,entity.getName()));
    result.setIsBuildin(convertService.toValue(java.lang.Boolean.class,entity.getIsBuildin()));
    return result;
    
  }
  
  public UIRole buildFrom(final Role entity) {
    if(entity==null) return null;
    edu.fudan.langlab.uidl.domain.app.shared.security.UIRole result = new edu.fudan.langlab.uidl.domain.app.shared.security.UIRole();
    copyFromEntity(result,entity);	
    return result;
    
  }
  
  public Class<?> getUIClass() {
    return UIRole.class;
  }
  
  public Class<?> getEntityClass() {
    return Role.class;
  }
}
