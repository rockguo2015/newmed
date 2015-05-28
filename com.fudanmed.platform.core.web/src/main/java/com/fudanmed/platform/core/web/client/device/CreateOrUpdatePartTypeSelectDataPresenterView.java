package com.fudanmed.platform.core.web.client.device;

import com.fudanmed.platform.core.web.client.device.CreateOrUpdatePartTypeSelectDataView;
import com.fudanmed.platform.core.web.shared.device.UIPartTypeSelectData;
import com.google.inject.ImplementedBy;
import com.uniquesoft.gwt.client.common.ViewerWithValidation;

@ImplementedBy(value = CreateOrUpdatePartTypeSelectDataView.class)
public interface CreateOrUpdatePartTypeSelectDataPresenterView extends ViewerWithValidation {
  public abstract UIPartTypeSelectData getValue();
  
  public abstract void setValue(final UIPartTypeSelectData value);
}
