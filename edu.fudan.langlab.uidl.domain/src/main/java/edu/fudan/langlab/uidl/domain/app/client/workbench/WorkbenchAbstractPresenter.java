package edu.fudan.langlab.uidl.domain.app.client.workbench;

import com.google.gwt.event.shared.EventBus;
import com.uniquesoft.gwt.client.common.AbstractPresenter;
import com.uniquesoft.gwt.client.common.Presenter;
import com.uniquesoft.gwt.client.common.Viewer;
import edu.fudan.langlab.uidl.domain.app.client.workbench.PopActivatedPresenterEvent;

@SuppressWarnings("all")
public abstract class WorkbenchAbstractPresenter<V extends Viewer> extends AbstractPresenter<V> {
  public WorkbenchAbstractPresenter(final V display, final EventBus eventBus) {
    super(display, eventBus);
  }
  
  public void popup(final Presenter<? extends Object> window) {
    PopActivatedPresenterEvent _popActivatedPresenterEvent = new PopActivatedPresenterEvent(window);
    this.eventBus.fireEvent(_popActivatedPresenterEvent);
  }
}
