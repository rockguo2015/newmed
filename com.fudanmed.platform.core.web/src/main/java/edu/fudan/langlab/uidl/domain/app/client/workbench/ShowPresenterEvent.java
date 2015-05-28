package edu.fudan.langlab.uidl.domain.app.client.workbench;

import com.google.gwt.event.shared.GwtEvent;
import com.google.gwt.event.shared.GwtEvent.Type;
import com.uniquesoft.gwt.client.common.Presenter;
import edu.fudan.langlab.uidl.domain.app.client.workbench.ShowPresenterHandler;

public class ShowPresenterEvent extends GwtEvent<ShowPresenterHandler> {
  public static Type<ShowPresenterHandler> __type__ = new Type<ShowPresenterHandler>();
  
  public Type<ShowPresenterHandler> getAssociatedType() {
    return __type__;
  }
  
  public void dispatch(final ShowPresenterHandler handler) {
    handler.ShowPresenter(presenter);
  }
  
  private Presenter presenter;
  
  public ShowPresenterEvent(final Presenter presenter) {
    this.presenter=presenter;
    
  }
}
