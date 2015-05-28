package edu.fudan.langlab.uidl.domain.app.client.workbench;

import com.google.gwt.event.shared.GwtEvent;
import com.google.gwt.event.shared.GwtEvent.Type;
import com.uniquesoft.gwt.client.common.Presenter;
import edu.fudan.langlab.uidl.domain.app.client.workbench.PopPresenterHandler;

public class PopPresenterEvent extends GwtEvent<PopPresenterHandler> {
  public static Type<PopPresenterHandler> __type__ = new Type<PopPresenterHandler>();
  
  public Type<PopPresenterHandler> getAssociatedType() {
    return __type__;
  }
  
  public void dispatch(final PopPresenterHandler handler) {
    handler.PopPresenter(presenter);
  }
  
  private Presenter presenter;
  
  public PopPresenterEvent(final Presenter presenter) {
    this.presenter=presenter;
    
  }
}
