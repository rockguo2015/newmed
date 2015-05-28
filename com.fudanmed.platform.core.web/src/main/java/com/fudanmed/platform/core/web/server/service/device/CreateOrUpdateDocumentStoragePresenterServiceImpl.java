package com.fudanmed.platform.core.web.server.service.device;

import com.fudanmed.platform.core.web.client.device.CreateOrUpdateDocumentStoragePresenterService;
import com.fudanmed.platform.core.web.server.service.device.DocumentStorageMapper;
import com.fudanmed.platform.core.web.shared.device.UIDocumentStorage;
import com.uniquesoft.gwt.server.service.common.BaseService;
import com.uniquesoft.gwt.shared.SessionTimeOutException;
import com.uniquesoft.gwt.shared.validation.ValidationException;
import edu.fudan.langlab.domain.document.DocumentStorage;
import edu.fudan.langlab.domain.document.IDocument;
import edu.fudan.langlab.domain.document.IDocumentContainer;
import edu.fudan.langlab.domain.document.proxy.DocumentStorageProxy;
import edu.fudan.langlab.domain.document.proxy.IDocumentContainerProxy;
import edu.fudan.mylang.pf.IObjectFactory;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("com.fudanmed.platform.core.web.client.device.CreateOrUpdateDocumentStoragePresenterService")
@Transactional
public class CreateOrUpdateDocumentStoragePresenterServiceImpl extends BaseService implements CreateOrUpdateDocumentStoragePresenterService {
  @Autowired
  private IObjectFactory entities;
  
  @Autowired
  private DocumentStorageMapper mapper;
  
  public UIDocumentStorage loadValue(final DocumentStorageProxy pvalue) throws SessionTimeOutException, ValidationException {
    DocumentStorage _resolved= null;
    if(pvalue!=null) _resolved=(edu.fudan.langlab.domain.document.DocumentStorage)com.uniquesoft.uidl.extensions.ModelObjects.resolve(pvalue, entities);
    
    UIDocumentStorage _transform = this.mapper.transform( _resolved);
    return _transform;
  }
  
  public void updateValue(final UIDocumentStorage uivalue) throws SessionTimeOutException, ValidationException {
    DocumentStorage _resolved= null;
    if(uivalue!=null) _resolved=(edu.fudan.langlab.domain.document.DocumentStorage)com.uniquesoft.uidl.extensions.ModelObjects.resolve(uivalue, entities);
    
    this.mapper.transform(uivalue,  _resolved);
  }
  
  public void create(final IDocumentContainerProxy documentContainer, final UIDocumentStorage uivalue) throws SessionTimeOutException, ValidationException {
    IDocumentContainer _resolved= null;
    if(documentContainer!=null) _resolved=(edu.fudan.langlab.domain.document.IDocumentContainer)com.uniquesoft.uidl.extensions.ModelObjects.resolve(documentContainer, entities);
    
    final Procedure1<IDocument> _function = new Procedure1<IDocument>() {
        public void apply(final IDocument it) {
          CreateOrUpdateDocumentStoragePresenterServiceImpl.this.mapper.transform(uivalue, ((DocumentStorage) it));
        }
      };
     _resolved.createDocument(_function);
  }
}
