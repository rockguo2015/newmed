package com.fudanmed.platform.core.web.server.service.device;

import com.fudanmed.platform.core.web.server.service.device.DocumentStorageValidator;
import com.fudanmed.platform.core.web.shared.device.UIDocumentStorage;
import com.uniquesoft.gwt.shared.datatype.File;
import com.uniquesoft.uidl.transform.AbstractEntityMapper;
import com.uniquesoft.uidl.transform.IConvertService;
import edu.fudan.langlab.domain.document.DocumentStorage;
import edu.fudan.mylang.pf.IObjectFactory;
import edu.fudan.mylang.utils.DateUtil;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("com.fudanmed.platform.core.web.server.service.device.DocumentStorageMapper")
public class DocumentStorageMapper extends AbstractEntityMapper<UIDocumentStorage,DocumentStorage> {
  @Autowired
  private IConvertService convertService;
  
  @Autowired
  private IObjectFactory entities;
  
  public DocumentStorage loadEntityById(final Long id) {
    return entities.get(DocumentStorage.class,id);
  }
  
  public DocumentStorage create() {
    return entities.create(DocumentStorage.class);
  }
  
  @Autowired
  private DocumentStorageValidator validator;
  
  public void copyToEntity(final UIDocumentStorage from, final DocumentStorage to) {
    java.util.Collection<com.uniquesoft.gwt.shared.validation.ValidationErrorItem> errors = validator.validate(from);
    if(errors.size()!=0)throw new com.uniquesoft.gwt.shared.validation.ValidationException(errors);					
    to.setVersion(from.getVersion());
    to.setName(convertService.toValue(java.lang.String.class,from.getName()));
    to.setContent(convertService.toValue(java.sql.Blob.class,from.getContent()));
    copyToCust(from,to);
    
  }
  
  protected void copyToCust(final UIDocumentStorage _gwt, final DocumentStorage _entity) {
    Date _now = DateUtil.now();
    _entity.setUploadTime(_now);
    File _content = _gwt.getContent();
    String _contentType = _content.getContentType();
    _entity.setContentType(_contentType);
    File _content_1 = _gwt.getContent();
    String _fileName = _content_1.getFileName();
    _entity.setFileName(_fileName);
  }
  
  public UIDocumentStorage copyFromEntity(final UIDocumentStorage result, final DocumentStorage entity) {
    if(entity==null) return null;
    result.setId(entity.getId());
    result.setVersion(entity.getVersion());
    result.setProxy(entity.toProxy());
    result.setClazzName(entity.getClass().getName());
    result.setName(convertService.toValue(java.lang.String.class,entity.getName()));
    result.setUploadTime(convertService.toValue(java.util.Date.class,entity.getUploadTime()));
    result.setFileName(convertService.toValue(java.lang.String.class,entity.getFileName()));
    result.setContentType(convertService.toValue(java.lang.String.class,entity.getContentType()));
    return result;
    
  }
  
  public UIDocumentStorage buildFrom(final DocumentStorage entity) {
    if(entity==null) return null;
    com.fudanmed.platform.core.web.shared.device.UIDocumentStorage result = new com.fudanmed.platform.core.web.shared.device.UIDocumentStorage();
    copyFromEntity(result,entity);	
    return result;
    
  }
  
  public Class<?> getUIClass() {
    return UIDocumentStorage.class;
  }
  
  public Class<?> getEntityClass() {
    return DocumentStorage.class;
  }
}
