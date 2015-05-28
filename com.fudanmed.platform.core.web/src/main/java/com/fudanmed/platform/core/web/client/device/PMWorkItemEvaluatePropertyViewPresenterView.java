package com.fudanmed.platform.core.web.client.device;

import com.fudanmed.platform.core.web.client.device.PMWorkItemEvaluatePropertyViewView;
import com.fudanmed.platform.core.web.shared.device.UIPMWorkItemEvaluate;
import com.google.inject.ImplementedBy;
import com.uniquesoft.gwt.client.common.Viewer;

@ImplementedBy(value = PMWorkItemEvaluatePropertyViewView.class)
public interface PMWorkItemEvaluatePropertyViewPresenterView extends Viewer {
  public abstract void setValue(final UIPMWorkItemEvaluate value);
}
