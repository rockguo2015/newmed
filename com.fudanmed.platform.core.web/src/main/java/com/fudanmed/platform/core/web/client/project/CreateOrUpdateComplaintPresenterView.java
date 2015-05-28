package com.fudanmed.platform.core.web.client.project;

import com.fudanmed.platform.core.web.client.project.CreateOrUpdateComplaintView;
import com.fudanmed.platform.core.web.shared.project.UIComplaint;
import com.google.inject.ImplementedBy;
import com.uniquesoft.gwt.client.common.ViewerWithValidation;

@ImplementedBy(value = CreateOrUpdateComplaintView.class)
public interface CreateOrUpdateComplaintPresenterView extends ViewerWithValidation {
  public abstract UIComplaint getValue();
  
  public abstract void setValue(final UIComplaint value);
}
