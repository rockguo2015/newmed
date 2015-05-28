package edu.fudan.langlab.uidl.domain.app.client.workbench;

import com.google.gwt.event.shared.GwtEvent;
import com.google.gwt.event.shared.GwtEvent.Type;
import com.uniquesoft.gwt.client.common.Presenter;
import edu.fudan.langlab.uidl.domain.app.client.workbench.ShowActivePresenterHandler;

public class ShowActivePresenterEvent extends GwtEvent<ShowActivePresenterHandler> {
  public static Type<ShowActivePresenterHandler> __type__ = new Type<ShowActivePresenterHandler>();
  
  public Type<ShowActivePresenterHandler> getAssociatedType() {
    return __type__;
  }
  
  public void dispatch(final ShowActivePresenterHandler handler) {
    handler.ShowActivePresenter(presenter);
  }
  
  private Presenter presenter;
  
  public ShowActivePresenterEvent(final Presenter presenter) {
    this.presenter=presenter;
    
  }
}
