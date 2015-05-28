package com.fudanmed.platform.core.web.client.workbench;

import com.fudanmed.platform.core.web.client.workbench.HeaderView;
import com.google.inject.ImplementedBy;
import com.uniquesoft.gwt.client.common.Viewer;

@ImplementedBy(value = HeaderView.class)
public interface HeaderPresenterView extends Viewer {
  public abstract void setApplicationTitle(final String appTitle);
}
