package com.fudanmed.platform.core.web.client.device;

import com.fudanmed.platform.core.web.shared.device.UIDocumentStorage;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import com.uniquesoft.gwt.shared.DataBaseConstraintException;
import com.uniquesoft.gwt.shared.SessionTimeOutException;
import com.uniquesoft.gwt.shared.validation.ValidationException;
import edu.fudan.langlab.domain.document.proxy.DocumentStorageProxy;
import edu.fudan.langlab.domain.document.proxy.IDocumentContainerProxy;

@RemoteServiceRelativePath("service/com.fudanmed.platform.core.web.client.device.CreateOrUpdateDocumentStoragePresenterService")
public interface CreateOrUpdateDocumentStoragePresenterService extends RemoteService {
  public abstract UIDocumentStorage loadValue(final DocumentStorageProxy pvalue) throws SessionTimeOutException, ValidationException, DataBaseConstraintException;
  
  public abstract void updateValue(final UIDocumentStorage uivalue) throws SessionTimeOutException, ValidationException, DataBaseConstraintException;
  
  public abstract void create(final IDocumentContainerProxy documentContainer, final UIDocumentStorage uivalue) throws SessionTimeOutException, ValidationException, DataBaseConstraintException;
}
