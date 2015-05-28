package com.fudanmed.platform.core.web.client.workbench;

import com.fudanmed.platform.core.web.client.workbench.SystemParameterView;
import com.fudanmed.platform.core.web.shared.workbench.UISystemParameter;
import com.google.inject.ImplementedBy;
import com.uniquesoft.gwt.client.common.RequestHandler;
import com.uniquesoft.gwt.client.common.Viewer;

@ImplementedBy(value = SystemParameterView.class)
public interface SystemParameterPresenterView extends Viewer {
  public abstract void showParameter(final UISystemParameter value);
  
  public abstract void modifyParameterRequest(final RequestHandler requestHandler);
}
