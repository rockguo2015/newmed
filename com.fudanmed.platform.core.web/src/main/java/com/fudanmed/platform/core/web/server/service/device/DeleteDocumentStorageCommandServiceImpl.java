package com.fudanmed.platform.core.web.server.service.device;

import com.fudanmed.platform.core.web.client.device.DeleteDocumentStorageCommandService;
import com.uniquesoft.gwt.server.service.common.BaseService;
import com.uniquesoft.gwt.shared.SessionTimeOutException;
import com.uniquesoft.gwt.shared.validation.ValidationException;
import edu.fudan.langlab.domain.document.DocumentStorage;
import edu.fudan.langlab.domain.document.IDocumentContainer;
import edu.fudan.langlab.domain.document.proxy.DocumentStorageProxy;
import edu.fudan.mylang.pf.IObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("com.fudanmed.platform.core.web.client.device.DeleteDocumentStorageCommandService")
@Transactional
public class DeleteDocumentStorageCommandServiceImpl extends BaseService implements DeleteDocumentStorageCommandService {
  @Autowired
  private IObjectFactory entities;
  
  public void delete(final DocumentStorageProxy value) throws SessionTimeOutException, ValidationException {
    DocumentStorage _resolved= null;
    if(value!=null) _resolved=(edu.fudan.langlab.domain.document.DocumentStorage)com.uniquesoft.uidl.extensions.ModelObjects.resolve(value, entities);
    
    IDocumentContainer _container =  _resolved.getContainer();
    DocumentStorage _resolved_1= null;
    if(value!=null) _resolved_1=(edu.fudan.langlab.domain.document.DocumentStorage)com.uniquesoft.uidl.extensions.ModelObjects.resolve(value, entities);
    
    _container.removeDocument( _resolved_1);
  }
}
