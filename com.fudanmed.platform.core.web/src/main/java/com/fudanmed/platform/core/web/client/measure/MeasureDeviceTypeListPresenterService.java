package com.fudanmed.platform.core.web.client.measure;

import com.fudanmed.platform.core.web.shared.measure.UIMeasureDeviceType;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import com.uniquesoft.gwt.shared.DataBaseConstraintException;
import com.uniquesoft.gwt.shared.SessionTimeOutException;
import com.uniquesoft.gwt.shared.validation.ValidationException;
import java.util.Collection;

@RemoteServiceRelativePath("service/com.fudanmed.platform.core.web.client.measure.MeasureDeviceTypeListPresenterService")
public interface MeasureDeviceTypeListPresenterService extends RemoteService {
  public abstract Collection<UIMeasureDeviceType> loadMeasureDeviceTypeList() throws SessionTimeOutException, ValidationException, DataBaseConstraintException;
}
