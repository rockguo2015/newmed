package edu.fudan.langlab.uidl.domain.app.client.workbench;

import com.google.gwt.event.shared.EventBus;
import com.uniquesoft.gwt.client.common.Presenter;
import edu.fudan.langlab.uidl.domain.app.client.workbench.PopActivatedPresenterEvent;

@SuppressWarnings("all")
public class Workbenchs {
  public static void popup(final Presenter<? extends Object> window, final EventBus eventBus) {
    PopActivatedPresenterEvent _popActivatedPresenterEvent = new PopActivatedPresenterEvent(window);
    eventBus.fireEvent(_popActivatedPresenterEvent);
  }
}
