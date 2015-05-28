package com.fudanmed.platform.core.web.client.project;

import com.fudanmed.platform.core.web.client.project.EBoardView;
import com.google.inject.ImplementedBy;
import com.uniquesoft.gwt.client.common.Viewer;

@ImplementedBy(value = EBoardView.class)
public interface EBoardPresenterView extends Viewer {
  public abstract void showResults(final String html);
}
