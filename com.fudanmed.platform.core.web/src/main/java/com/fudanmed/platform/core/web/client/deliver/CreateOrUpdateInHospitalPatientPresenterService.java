package com.fudanmed.platform.core.web.client.deliver;

import com.fudanmed.platform.core.deliver.proxy.DLInHospitalPatientProxy;
import com.fudanmed.platform.core.web.shared.deliver.UIInHospitalPatient;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import com.uniquesoft.gwt.shared.DataBaseConstraintException;
import com.uniquesoft.gwt.shared.SessionTimeOutException;
import com.uniquesoft.gwt.shared.validation.ValidationException;

@RemoteServiceRelativePath("service/com.fudanmed.platform.core.web.client.deliver.CreateOrUpdateInHospitalPatientPresenterService")
public interface CreateOrUpdateInHospitalPatientPresenterService extends RemoteService {
  public abstract UIInHospitalPatient loadValue(final DLInHospitalPatientProxy pvalue) throws SessionTimeOutException, ValidationException, DataBaseConstraintException;
  
  public abstract void updateValue(final UIInHospitalPatient uivalue) throws SessionTimeOutException, ValidationException, DataBaseConstraintException;
  
  public abstract DLInHospitalPatientProxy createValue(final UIInHospitalPatient uivalue) throws SessionTimeOutException, ValidationException, DataBaseConstraintException;
}
