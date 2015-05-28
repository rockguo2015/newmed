package com.fudanmed.platform.core.web.client.workbench;

import com.fudanmed.platform.core.web.client.workbench.CreateOrUpdateSystemParameterView;
import com.fudanmed.platform.core.web.shared.workbench.UISystemParameter;
import com.google.inject.ImplementedBy;
import com.uniquesoft.gwt.client.common.ViewerWithValidation;

@ImplementedBy(value = CreateOrUpdateSystemParameterView.class)
public interface CreateOrUpdateSystemParameterPresenterView extends ViewerWithValidation {
  public abstract UISystemParameter getValue();
  
  public abstract void setValue(final UISystemParameter value);
}
