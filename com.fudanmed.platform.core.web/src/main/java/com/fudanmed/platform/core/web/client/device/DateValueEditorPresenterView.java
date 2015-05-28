package com.fudanmed.platform.core.web.client.device;

import com.fudanmed.platform.core.web.client.device.DateValueEditorView;
import com.fudanmed.platform.core.web.shared.device.DateValueData;
import com.google.inject.ImplementedBy;
import com.uniquesoft.gwt.client.common.ViewerWithValidation;
import java.util.Date;

@ImplementedBy(value = DateValueEditorView.class)
public interface DateValueEditorPresenterView extends ViewerWithValidation {
  public abstract DateValueData getValue();
  
  public abstract void setValue(final Date value);
}
