package com.fudanmed.platform.core.web.client.measure;

import com.fudanmed.platform.core.web.shared.measure.UIMeasureValueCriteria;
import com.fudanmed.platform.core.web.shared.measure.UIWaterMeasureValue;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.uniquesoft.gwt.shared.common.pager.IPagedResult;

public interface WaterMeasureValueQueryListPresenterServiceAsync {
  public abstract void filter(final UIMeasureValueCriteria uicriteria, final AsyncCallback<IPagedResult<UIWaterMeasureValue>> callback);
}
