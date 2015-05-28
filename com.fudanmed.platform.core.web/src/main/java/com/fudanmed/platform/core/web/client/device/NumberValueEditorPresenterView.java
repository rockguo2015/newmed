package com.fudanmed.platform.core.web.client.device;

import com.fudanmed.platform.core.web.client.device.NumberValueEditorView;
import com.fudanmed.platform.core.web.shared.device.NumberValueData;
import com.google.inject.ImplementedBy;
import com.uniquesoft.gwt.client.common.ViewerWithValidation;

@ImplementedBy(value = NumberValueEditorView.class)
public interface NumberValueEditorPresenterView extends ViewerWithValidation {
  public abstract NumberValueData getValue();
  
  public abstract void setValue(final Double value);
}
