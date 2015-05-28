package com.fudanmed.platform.core.web.client.deliver;

import com.fudanmed.platform.core.deliver.proxy.DLCenterlizedDeliverTaskProxy;
import com.fudanmed.platform.core.deliver.proxy.DLInHospitalPatientProxy;
import com.fudanmed.platform.core.web.shared.deliver.UICenterlizedDeliverTask4Patient;
import com.fudanmed.platform.core.web.shared.deliver.UIInHospitalPatient;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import com.uniquesoft.gwt.shared.DataBaseConstraintException;
import com.uniquesoft.gwt.shared.SessionTimeOutException;
import com.uniquesoft.gwt.shared.validation.ValidationException;
import java.util.Collection;

@RemoteServiceRelativePath("service/com.fudanmed.platform.core.web.client.deliver.CreateOrUpdateCenterlizedDeliverTask4PatientPresenterService")
public interface CreateOrUpdateCenterlizedDeliverTask4PatientPresenterService extends RemoteService {
  public abstract UICenterlizedDeliverTask4Patient loadValue(final DLCenterlizedDeliverTaskProxy pvalue) throws SessionTimeOutException, ValidationException, DataBaseConstraintException;
  
  public abstract void updateValue(final UICenterlizedDeliverTask4Patient uivalue) throws SessionTimeOutException, ValidationException, DataBaseConstraintException;
  
  public abstract void createValue(final UICenterlizedDeliverTask4Patient uivalue, final Collection<UICenterlizedDeliverTask4Patient> patients) throws SessionTimeOutException, ValidationException, DataBaseConstraintException;
  
  public abstract UIInHospitalPatient loadPatientDetail(final DLInHospitalPatientProxy newPatient) throws SessionTimeOutException, ValidationException, DataBaseConstraintException;
}
