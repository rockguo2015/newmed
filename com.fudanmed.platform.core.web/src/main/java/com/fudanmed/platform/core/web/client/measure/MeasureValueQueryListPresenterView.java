package com.fudanmed.platform.core.web.client.measure;

import com.fudanmed.platform.core.measure.proxy.RCMeasureDeviceProxy;
import com.fudanmed.platform.core.measure.proxy.RCMeasureDeviceTypeProxy;
import com.fudanmed.platform.core.web.client.measure.MeasureValueQueryListView;
import com.fudanmed.platform.core.web.shared.measure.UIMeasureValue;
import com.fudanmed.platform.core.web.shared.measure.UIMeasureValueCriteria;
import com.google.inject.ImplementedBy;
import com.uniquesoft.gwt.client.common.RequestHandler1;
import com.uniquesoft.gwt.client.common.Viewer;
import com.uniquesoft.gwt.client.common.action.ActionContext;
import com.uniquesoft.gwt.shared.command.IContextProvider;
import com.uniquesoft.gwt.shared.common.pager.IPagedResult;

@ImplementedBy(value = MeasureValueQueryListView.class)
public interface MeasureValueQueryListPresenterView extends Viewer, IContextProvider<UIMeasureValue> {
  public abstract void showResults(final IPagedResult<UIMeasureValue> results);
  
  public abstract void refresh();
  
  public abstract void setMeasureDevice(final RCMeasureDeviceProxy device);
  
  public abstract void setMeasureDeviceType(final RCMeasureDeviceTypeProxy deviceType);
  
  public abstract void filterRequest(final RequestHandler1<UIMeasureValueCriteria> requestHandler);
  
  public abstract ActionContext<UIMeasureValue> getActionContext();
}
