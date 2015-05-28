package com.fudanmed.platform.core.web.client.measure;

import com.fudanmed.platform.core.web.shared.measure.UIElectricMeasureValue;
import com.fudanmed.platform.core.web.shared.measure.UIMeasureValueCriteria;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import com.uniquesoft.gwt.shared.DataBaseConstraintException;
import com.uniquesoft.gwt.shared.SessionTimeOutException;
import com.uniquesoft.gwt.shared.common.pager.IPagedResult;
import com.uniquesoft.gwt.shared.validation.ValidationException;

@RemoteServiceRelativePath("service/com.fudanmed.platform.core.web.client.measure.ElectricMeasureValueQueryListPresenterService")
public interface ElectricMeasureValueQueryListPresenterService extends RemoteService {
  public abstract IPagedResult<UIElectricMeasureValue> filter(final UIMeasureValueCriteria uicriteria) throws SessionTimeOutException, ValidationException, DataBaseConstraintException;
}
