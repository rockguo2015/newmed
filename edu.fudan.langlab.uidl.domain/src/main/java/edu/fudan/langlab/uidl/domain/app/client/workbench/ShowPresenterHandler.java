package edu.fudan.langlab.uidl.domain.app.client.workbench;

import com.google.gwt.event.shared.EventHandler;
import com.uniquesoft.gwt.client.common.Presenter;

public interface ShowPresenterHandler extends EventHandler {
  public abstract void ShowPresenter(final Presenter presenter);
}
