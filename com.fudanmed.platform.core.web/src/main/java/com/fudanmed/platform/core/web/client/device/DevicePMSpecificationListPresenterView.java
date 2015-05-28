package com.fudanmed.platform.core.web.client.device;

import com.fudanmed.platform.core.web.client.device.DevicePMSpecificationListView;
import com.fudanmed.platform.core.web.shared.device.UIDevicePMSpecification;
import com.google.inject.ImplementedBy;
import com.uniquesoft.gwt.client.common.Viewer;
import com.uniquesoft.gwt.client.common.action.ActionContext;
import java.util.Collection;

@ImplementedBy(value = DevicePMSpecificationListView.class)
public interface DevicePMSpecificationListPresenterView extends Viewer {
  public abstract void setResults(final Collection<UIDevicePMSpecification> results);
  
  public abstract ActionContext<UIDevicePMSpecification> getActionContext();
}
