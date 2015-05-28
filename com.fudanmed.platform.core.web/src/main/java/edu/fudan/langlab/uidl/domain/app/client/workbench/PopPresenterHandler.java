package edu.fudan.langlab.uidl.domain.app.client.workbench;

import com.google.gwt.event.shared.EventHandler;
import com.uniquesoft.gwt.client.common.Presenter;

public interface PopPresenterHandler extends EventHandler {
  public abstract void PopPresenter(final Presenter presenter);
}
