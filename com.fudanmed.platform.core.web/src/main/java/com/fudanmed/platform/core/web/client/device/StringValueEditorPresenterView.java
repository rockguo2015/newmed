package com.fudanmed.platform.core.web.client.device;

import com.fudanmed.platform.core.web.client.device.StringValueEditorView;
import com.fudanmed.platform.core.web.shared.device.StringValueData;
import com.google.inject.ImplementedBy;
import com.uniquesoft.gwt.client.common.ViewerWithValidation;

@ImplementedBy(value = StringValueEditorView.class)
public interface StringValueEditorPresenterView extends ViewerWithValidation {
  public abstract StringValueData getValue();
  
  public abstract void setValue(final String value);
}
