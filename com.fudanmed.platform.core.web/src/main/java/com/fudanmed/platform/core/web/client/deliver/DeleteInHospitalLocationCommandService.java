package com.fudanmed.platform.core.web.client.deliver;

import com.fudanmed.platform.core.deliver.proxy.DLInHospitalLocationProxy;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import com.uniquesoft.gwt.shared.DataBaseConstraintException;
import com.uniquesoft.gwt.shared.SessionTimeOutException;
import com.uniquesoft.gwt.shared.validation.ValidationException;

@RemoteServiceRelativePath("service/com.fudanmed.platform.core.web.client.deliver.DeleteInHospitalLocationCommandService")
public interface DeleteInHospitalLocationCommandService extends RemoteService {
  public abstract void delete(final DLInHospitalLocationProxy value) throws SessionTimeOutException, ValidationException, DataBaseConstraintException;
}
