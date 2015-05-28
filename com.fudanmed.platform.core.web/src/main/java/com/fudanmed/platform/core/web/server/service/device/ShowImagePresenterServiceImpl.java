package com.fudanmed.platform.core.web.server.service.device;

import com.fudanmed.platform.core.web.client.device.ShowImagePresenterService;
import com.uniquesoft.gwt.server.service.common.BaseService;
import com.uniquesoft.gwt.shared.SessionTimeOutException;
import com.uniquesoft.gwt.shared.validation.ValidationException;
import edu.fudan.langlab.domain.document.IDocument;
import edu.fudan.langlab.domain.document.proxy.IDocumentProxy;
import edu.fudan.langlab.uidl.domain.document.server.DocumentDownloader;
import edu.fudan.mylang.pf.IObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("com.fudanmed.platform.core.web.client.device.ShowImagePresenterService")
@Transactional
public class ShowImagePresenterServiceImpl extends BaseService implements ShowImagePresenterService {
  @Autowired
  private IObjectFactory entities;
  
  public String prepareDownload(final IDocumentProxy document) throws SessionTimeOutException, ValidationException {
    IDocument _resolved= null;
    if(document!=null) _resolved=(edu.fudan.langlab.domain.document.IDocument)com.uniquesoft.uidl.extensions.ModelObjects.resolve(document, entities);
    
    String _prepareDownload = DocumentDownloader.prepareDownload(this,  _resolved);
    return _prepareDownload;
  }
}
