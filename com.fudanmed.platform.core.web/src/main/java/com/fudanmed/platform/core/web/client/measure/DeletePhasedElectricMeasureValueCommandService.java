package com.fudanmed.platform.core.web.client.measure;

import com.fudanmed.platform.core.measure.proxy.RCPhasedElectricMeasureValueProxy;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import com.uniquesoft.gwt.shared.DataBaseConstraintException;
import com.uniquesoft.gwt.shared.SessionTimeOutException;
import com.uniquesoft.gwt.shared.validation.ValidationException;

@RemoteServiceRelativePath("service/com.fudanmed.platform.core.web.client.measure.DeletePhasedElectricMeasureValueCommandService")
public interface DeletePhasedElectricMeasureValueCommandService extends RemoteService {
  public abstract void delete(final RCPhasedElectricMeasureValueProxy value) throws SessionTimeOutException, ValidationException, DataBaseConstraintException;
}
