package edu.fudan.langlab.uidl.domain.app.client.workbench;

import com.google.gwt.event.shared.EventHandler;
import com.uniquesoft.gwt.client.common.Presenter;

public interface PopActivatedPresenterHandler extends EventHandler {
  public abstract void PopActivatedPresenter(final Presenter presenter);
}
