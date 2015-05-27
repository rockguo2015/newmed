package edu.fudan.langlab.uidl.domain.app.client.workbench;

import com.google.gwt.event.shared.GwtEvent;
import com.google.gwt.event.shared.GwtEvent.Type;
import com.uniquesoft.gwt.client.common.Presenter;
import edu.fudan.langlab.uidl.domain.app.client.workbench.PopActivatedPresenterHandler;

public class PopActivatedPresenterEvent extends GwtEvent<PopActivatedPresenterHandler> {
  public static Type<PopActivatedPresenterHandler> __type__ = new Type<PopActivatedPresenterHandler>();
  
  public Type<PopActivatedPresenterHandler> getAssociatedType() {
    return __type__;
  }
  
  public void dispatch(final PopActivatedPresenterHandler handler) {
    handler.PopActivatedPresenter(presenter);
  }
  
  private Presenter presenter;
  
  public PopActivatedPresenterEvent(final Presenter presenter) {
    this.presenter=presenter;
    
  }
}
