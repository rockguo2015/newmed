package com.fudanmed.platform.core.web.server.service.common;

import com.fudanmed.platform.core.common.RCDocument;
import com.fudanmed.platform.core.web.shared.common.UIDocument;
import com.uniquesoft.uidl.transform.AbstractEntityMapper;
import com.uniquesoft.uidl.transform.IConvertService;
import edu.fudan.mylang.pf.IObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("com.fudanmed.platform.core.web.server.service.common.DocumentMapper")
public class DocumentMapper extends AbstractEntityMapper<UIDocument,RCDocument> {
  @Autowired
  private IConvertService convertService;
  
  @Autowired
  private IObjectFactory entities;
  
  public RCDocument loadEntityById(final Long id) {
    return entities.get(RCDocument.class,id);
  }
  
  public RCDocument create() {
    return entities.create(RCDocument.class);
  }
  
  public void copyToEntity(final UIDocument from, final RCDocument to) {
    to.setVersion(from.getVersion());
    to.setDescription(convertService.toValue(java.lang.String.class,from.getDescription()));
    
  }
  
  public UIDocument copyFromEntity(final UIDocument result, final RCDocument entity) {
    if(entity==null) return null;
    result.setId(entity.getId());
    result.setVersion(entity.getVersion());
    result.setProxy(entity.toProxy());
    result.setClazzName(entity.getClass().getName());
    result.setDescription(convertService.toValue(java.lang.String.class,entity.getDescription()));
    result.setFile(convertService.toValue(com.uniquesoft.gwt.shared.datatype.File.class,entity.getFile()));
    return result;
    
  }
  
  public UIDocument buildFrom(final RCDocument entity) {
    if(entity==null) return null;
    com.fudanmed.platform.core.web.shared.common.UIDocument result = new com.fudanmed.platform.core.web.shared.common.UIDocument();
    copyFromEntity(result,entity);	
    return result;
    
  }
  
  public Class<?> getUIClass() {
    return UIDocument.class;
  }
  
  public Class<?> getEntityClass() {
    return RCDocument.class;
  }
}
