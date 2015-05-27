package com.lanmon.business.server.service.code;

import com.lanmon.business.shared.code.GWTCode;
import com.lanmon.workflow.business.Code;
import com.uniquesoft.uidl.transform.AbstractEntityMapper;
import com.uniquesoft.uidl.transform.IConvertService;
import edu.fudan.mylang.pf.IObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("com.lanmon.business.server.service.code.CodeMapper")
public class CodeMapper extends AbstractEntityMapper<GWTCode,Code> {
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
  
  public void copyToEntity(final GWTCode from, final Code to) {
    to.setName(convertService.toValue(java.lang.String.class,from.getName()));
    
  }
  
  public GWTCode copyFromEntity(final GWTCode result, final Code entity) {
    if(entity==null) return null;
    result.setId(entity.getId());
    result.setName(convertService.toValue(java.lang.String.class,entity.getName()));
    return result;
    
  }
  
  public GWTCode buildFrom(final Code entity) {
    if(entity==null) return null;
    com.lanmon.business.shared.code.GWTCode result = new com.lanmon.business.shared.code.GWTCode();
    copyFromEntity(result,entity);	
    return result;
    
  }
  
  public Class<?> getUIClass() {
    return GWTCode.class;
  }
  
  public Class<?> getEntityClass() {
    return Code.class;
  }
}
