package com.fudanmed.platform.core.web.client.device;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import com.uniquesoft.gwt.shared.DataBaseConstraintException;
import com.uniquesoft.gwt.shared.SessionTimeOutException;
import com.uniquesoft.gwt.shared.validation.ValidationException;
import edu.fudan.langlab.domain.document.proxy.IDocumentProxy;

@RemoteServiceRelativePath("service/com.fudanmed.platform.core.web.client.device.ShowImagePresenterService")
public interface ShowImagePresenterService extends RemoteService {
  public abstract String prepareDownload(final IDocumentProxy document) throws SessionTimeOutException, ValidationException, DataBaseConstraintException;
}
