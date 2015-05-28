package com.fudanmed.platform.core.web.client.device;

import com.fudanmed.platform.core.web.client.device.RangeValueEditorView;
import com.fudanmed.platform.core.web.shared.device.RangeValueData;
import com.google.inject.ImplementedBy;
import com.uniquesoft.gwt.client.common.ViewerWithValidation;

@ImplementedBy(value = RangeValueEditorView.class)
public interface RangeValueEditorPresenterView extends ViewerWithValidation {
  public abstract RangeValueData getValue();
  
  public abstract void setValue(final RangeValueData value);
}
