package com.fudanmed.platform.core.web.client.device;

import com.fudanmed.platform.core.web.client.device.DeviceCategoryAndTypeListView;
import com.fudanmed.platform.core.web.shared.device.UIDeviceCategoryAndType;
import com.google.inject.ImplementedBy;
import com.uniquesoft.gwt.client.common.RequestHandler1;
import com.uniquesoft.gwt.client.common.Viewer;
import com.uniquesoft.gwt.client.common.action.ActionContext;
import java.util.Collection;

@ImplementedBy(value = DeviceCategoryAndTypeListView.class)
public interface DeviceCategoryAndTypeListPresenterView extends Viewer {
  public abstract void showCategories(final Collection<UIDeviceCategoryAndType> results);
  
  public abstract void deviceCategoryOrTypeSelected(final RequestHandler1<UIDeviceCategoryAndType> requestHandler);
  
  public abstract ActionContext<UIDeviceCategoryAndType> getActionContext();
}
