package com.fudanmed.platform.core.web.client.measure;

import com.fudanmed.platform.core.measure.proxy.RCMeasureDeviceProxy;
import com.fudanmed.platform.core.web.client.measure.WaterMeasureValueQueryListView;
import com.fudanmed.platform.core.web.shared.measure.UIMeasureValueCriteria;
import com.fudanmed.platform.core.web.shared.measure.UIWaterMeasureValue;
import com.google.inject.ImplementedBy;
import com.uniquesoft.gwt.client.common.RequestHandler1;
import com.uniquesoft.gwt.client.common.Viewer;
import com.uniquesoft.gwt.client.common.action.ActionContext;
import com.uniquesoft.gwt.shared.command.IContextProvider;
import com.uniquesoft.gwt.shared.common.pager.IPagedResult;

@ImplementedBy(value = WaterMeasureValueQueryListView.class)
public interface WaterMeasureValueQueryListPresenterView extends Viewer, IContextProvider<UIWaterMeasureValue> {
  public abstract void showResults(final IPagedResult<UIWaterMeasureValue> results);
  
  public abstract void refresh();
  
  public abstract void setMeasureDevice(final RCMeasureDeviceProxy device);
  
  public abstract void filterRequest(final RequestHandler1<UIMeasureValueCriteria> requestHandler);
  
  public abstract ActionContext<UIWaterMeasureValue> getActionContext();
}
