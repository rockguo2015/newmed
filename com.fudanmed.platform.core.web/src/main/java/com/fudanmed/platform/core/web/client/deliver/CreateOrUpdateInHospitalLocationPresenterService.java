package com.fudanmed.platform.core.web.client.deliver;

import com.fudanmed.platform.core.deliver.proxy.DLInHospitalLocationProxy;
import com.fudanmed.platform.core.web.shared.deliver.UIInHospitalLocation;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import com.uniquesoft.gwt.shared.DataBaseConstraintException;
import com.uniquesoft.gwt.shared.SessionTimeOutException;
import com.uniquesoft.gwt.shared.validation.ValidationException;

@RemoteServiceRelativePath("service/com.fudanmed.platform.core.web.client.deliver.CreateOrUpdateInHospitalLocationPresenterService")
public interface CreateOrUpdateInHospitalLocationPresenterService extends RemoteService {
  public abstract UIInHospitalLocation loadValue(final DLInHospitalLocationProxy pvalue) throws SessionTimeOutException, ValidationException, DataBaseConstraintException;
  
  public abstract void updateValue(final UIInHospitalLocation uivalue) throws SessionTimeOutException, ValidationException, DataBaseConstraintException;
  
  public abstract void createValue(final UIInHospitalLocation uivalue) throws SessionTimeOutException, ValidationException, DataBaseConstraintException;
}
