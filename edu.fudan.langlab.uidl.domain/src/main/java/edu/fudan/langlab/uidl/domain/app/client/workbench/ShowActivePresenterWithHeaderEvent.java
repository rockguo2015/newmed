package edu.fudan.langlab.uidl.domain.app.client.workbench;

import com.google.gwt.event.shared.GwtEvent;
import com.google.gwt.event.shared.GwtEvent.Type;
import com.uniquesoft.gwt.client.common.Presenter;
import edu.fudan.langlab.uidl.domain.app.client.workbench.ShowActivePresenterWithHeaderHandler;

public class ShowActivePresenterWithHeaderEvent extends GwtEvent<ShowActivePresenterWithHeaderHandler> {
  public static Type<ShowActivePresenterWithHeaderHandler> __type__ = new Type<ShowActivePresenterWithHeaderHandler>();
  
  public Type<ShowActivePresenterWithHeaderHandler> getAssociatedType() {
    return __type__;
  }
  
  public void dispatch(final ShowActivePresenterWithHeaderHandler handler) {
    handler.ShowActivePresenterWithHeader(presenter,header);
  }
  
  private Presenter presenter;
  
  private String header;
  
  public ShowActivePresenterWithHeaderEvent(final Presenter presenter, final String header) {
    this.presenter=presenter;
    this.header=header;
    
  }
}
