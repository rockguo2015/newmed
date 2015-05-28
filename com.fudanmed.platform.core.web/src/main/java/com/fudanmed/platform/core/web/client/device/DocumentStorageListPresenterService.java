package com.fudanmed.platform.core.web.client.device;

import com.fudanmed.platform.core.web.shared.device.UIDocumentStorage;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import com.uniquesoft.gwt.shared.DataBaseConstraintException;
import com.uniquesoft.gwt.shared.SessionTimeOutException;
import com.uniquesoft.gwt.shared.validation.ValidationException;
import edu.fudan.langlab.domain.document.proxy.DocumentStorageProxy;
import edu.fudan.langlab.domain.document.proxy.IDocumentContainerProxy;
import java.util.Collection;

@RemoteServiceRelativePath("service/com.fudanmed.platform.core.web.client.device.DocumentStorageListPresenterService")
public interface DocumentStorageListPresenterService extends RemoteService {
  public abstract Collection<UIDocumentStorage> loadDocumentStorageList(final IDocumentContainerProxy context) throws SessionTimeOutException, ValidationException, DataBaseConstraintException;
  
  public abstract String prepareDownload(final DocumentStorageProxy document) throws SessionTimeOutException, ValidationException, DataBaseConstraintException;
}
