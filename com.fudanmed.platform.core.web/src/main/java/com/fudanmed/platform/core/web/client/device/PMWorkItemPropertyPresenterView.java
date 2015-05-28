package com.fudanmed.platform.core.web.client.device;

import com.fudanmed.platform.core.web.client.device.PMWorkItemPropertyView;
import com.fudanmed.platform.core.web.shared.device.UIPMWorkItem;
import com.google.inject.ImplementedBy;
import com.uniquesoft.gwt.client.common.Viewer;

@ImplementedBy(value = PMWorkItemPropertyView.class)
public interface PMWorkItemPropertyPresenterView extends Viewer {
  public abstract void setValue(final UIPMWorkItem value);
  
  public abstract void clear();
}
