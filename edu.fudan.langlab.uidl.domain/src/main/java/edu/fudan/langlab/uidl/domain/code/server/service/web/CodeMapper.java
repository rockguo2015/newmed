package edu.fudan.langlab.uidl.domain.code.server.service.web;

import com.uniquesoft.uidl.transform.AbstractEntityMapper;
import com.uniquesoft.uidl.transform.IConvertService;
import edu.fudan.langlab.domain.code.Code;
import edu.fudan.langlab.uidl.domain.code.server.service.web.CodeValidator;
import edu.fudan.langlab.uidl.domain.code.shared.web.UICode;
import edu.fudan.mylang.pf.IObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("edu.fudan.langlab.uidl.domain.code.server.service.web.CodeMapper")
public class CodeMapper extends AbstractEntityMapper<UICode,Code> {
  @Autowired
  private IConvertService convertService;
  
  @Autowired
  private IObjectFactory entities;
  
  public Code loadEntityById(final Long id) {
    return entities.get(Code.class,id);
  }
  
  public Code create() {
    return entities.create(Code.class);
  }
  
  @Autowired
  private CodeValidator validator;
  
  public void copyToEntity(final UICode from, final Code to) {
    java.util.Collection<com.uniquesoft.gwt.shared.validation.ValidationErrorItem> errors = validator.validate(from);
    if(errors.size()!=0)throw new com.uniquesoft.gwt.shared.validation.ValidationException(errors);					
    to.setVersion(from.getVersion());
    to.setCodeid(convertService.toValue(java.lang.String.class,from.getCodeid()));
    to.setName(convertService.toValue(java.lang.String.class,from.getName()));
    
  }
  
  public UICode copyFromEntity(final UICode result, final Code entity) {
    if(entity==null) return null;
    result.setId(entity.getId());
    result.setVersion(entity.getVersion());
    result.setProxy(entity.toProxy());
    result.setClazzName(entity.getClass().getName());
    result.setCodeid(convertService.toValue(java.lang.String.class,entity.getCodeid()));
    result.setName(convertService.toValue(java.lang.String.class,entity.getName()));
    return result;
    
  }
  
  public UICode buildFrom(final Code entity) {
    if(entity==null) return null;
    edu.fudan.langlab.uidl.domain.code.shared.web.UICode result = new edu.fudan.langlab.uidl.domain.code.shared.web.UICode();
    copyFromEntity(result,entity);	
    return result;
    
  }
  
  public Class<?> getUIClass() {
    return UICode.class;
  }
  
  public Class<?> getEntityClass() {
    return Code.class;
  }
}
