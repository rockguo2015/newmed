package com.fudanmed.platform.core.web.client.measure;

import com.fudanmed.platform.core.web.shared.measure.UIElectricMeasureValue;
import com.fudanmed.platform.core.web.shared.measure.UIMeasureValueCriteria;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.uniquesoft.gwt.shared.common.pager.IPagedResult;

public interface ElectricMeasureValueQueryListPresenterServiceAsync {
  public abstract void filter(final UIMeasureValueCriteria uicriteria, final AsyncCallback<IPagedResult<UIElectricMeasureValue>> callback);
}
