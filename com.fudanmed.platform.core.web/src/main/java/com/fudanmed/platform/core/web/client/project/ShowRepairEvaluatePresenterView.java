package com.fudanmed.platform.core.web.client.project;

import com.fudanmed.platform.core.web.client.project.ShowRepairEvaluateView;
import com.fudanmed.platform.core.web.shared.project.UIRepairEvaluate;
import com.google.inject.ImplementedBy;
import com.uniquesoft.gwt.client.common.Viewer;

@ImplementedBy(value = ShowRepairEvaluateView.class)
public interface ShowRepairEvaluatePresenterView extends Viewer {
  public abstract void setValue(final UIRepairEvaluate value);
}
