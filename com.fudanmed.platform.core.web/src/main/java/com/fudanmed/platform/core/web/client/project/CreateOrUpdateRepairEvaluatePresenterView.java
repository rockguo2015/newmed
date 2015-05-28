package com.fudanmed.platform.core.web.client.project;

import com.fudanmed.platform.core.web.client.project.CreateOrUpdateRepairEvaluateView;
import com.fudanmed.platform.core.web.shared.project.UIRepairEvaluate;
import com.google.inject.ImplementedBy;
import com.uniquesoft.gwt.client.common.ViewerWithValidation;

@ImplementedBy(value = CreateOrUpdateRepairEvaluateView.class)
public interface CreateOrUpdateRepairEvaluatePresenterView extends ViewerWithValidation {
  public abstract UIRepairEvaluate getValue();
  
  public abstract void setValue(final UIRepairEvaluate value);
}
