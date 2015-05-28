package com.fudanmed.platform.core.web.server.service.device;

import com.fudanmed.platform.core.web.client.device.PictureListPresenterService;
import com.fudanmed.platform.core.web.server.service.device.DocumentStorageMapper;
import com.fudanmed.platform.core.web.shared.device.UIDocumentStorage;
import com.uniquesoft.gwt.server.service.common.BaseService;
import com.uniquesoft.gwt.shared.SessionTimeOutException;
import com.uniquesoft.gwt.shared.extensions.IterableExtensions2;
import com.uniquesoft.gwt.shared.validation.ValidationException;
import edu.fudan.langlab.domain.document.DocumentStorage;
import edu.fudan.langlab.domain.document.IDocument;
import edu.fudan.langlab.domain.document.IHasDocuments;
import edu.fudan.langlab.domain.document.proxy.DocumentStorageProxy;
import edu.fudan.langlab.domain.document.proxy.IHasDocumentsProxy;
import edu.fudan.langlab.uidl.domain.document.server.DocumentDownloader;
import edu.fudan.mylang.pf.IObjectFactory;
import java.util.Collection;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("com.fudanmed.platform.core.web.client.device.PictureListPresenterService")
@Transactional
public class PictureListPresenterServiceImpl extends BaseService implements PictureListPresenterService {
  @Autowired
  private IObjectFactory entities;
  
  @Autowired
  private DocumentStorageMapper mapper;
  
  public Collection<UIDocumentStorage> loadDocumentStorageList(final IHasDocumentsProxy context) throws SessionTimeOutException, ValidationException {
    IHasDocuments _resolved= null;
    if(context!=null) _resolved=(edu.fudan.langlab.domain.document.IHasDocuments)com.uniquesoft.uidl.extensions.ModelObjects.resolve(context, entities);
    
    Collection<? extends IDocument> _documents =  _resolved.getDocuments();
    final Function1<IDocument,UIDocumentStorage> _function = new Function1<IDocument,UIDocumentStorage>() {
        public UIDocumentStorage apply(final IDocument it) {
          UIDocumentStorage _transform = PictureListPresenterServiceImpl.this.mapper.transform(((DocumentStorage) it));
          return _transform;
        }
      };
    Iterable<UIDocumentStorage> _map = IterableExtensions.map(_documents, _function);
    Collection<UIDocumentStorage> _unlazy = IterableExtensions2.<UIDocumentStorage>unlazy(_map);
    return _unlazy;
  }
  
  public String prepareDownload(final DocumentStorageProxy document) throws SessionTimeOutException, ValidationException {
    DocumentStorage _resolved= null;
    if(document!=null) _resolved=(edu.fudan.langlab.domain.document.DocumentStorage)com.uniquesoft.uidl.extensions.ModelObjects.resolve(document, entities);
    
    String _prepareDownload = DocumentDownloader.prepareDownload(this,  _resolved);
    return _prepareDownload;
  }
}
