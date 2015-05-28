package com.fudanmed.platform.core.web.client.device;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import com.uniquesoft.gwt.shared.DataBaseConstraintException;
import com.uniquesoft.gwt.shared.SessionTimeOutException;
import com.uniquesoft.gwt.shared.validation.ValidationException;
import edu.fudan.langlab.domain.document.proxy.DocumentStorageProxy;

@RemoteServiceRelativePath("service/com.fudanmed.platform.core.web.client.device.DeletePictureCommandService")
public interface DeletePictureCommandService extends RemoteService {
  public abstract void delete(final DocumentStorageProxy value) throws SessionTimeOutException, ValidationException, DataBaseConstraintException;
}
