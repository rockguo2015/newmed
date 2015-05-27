package edu.fudan.langlab.uidl.domain.code.client.web;

import com.google.gwt.event.shared.GwtEvent;
import com.google.gwt.event.shared.GwtEvent.Type;
import edu.fudan.langlab.uidl.domain.code.client.web.CodesChangedHandler;

public class CodesChangedEvent extends GwtEvent<CodesChangedHandler> {
  public static Type<CodesChangedHandler> __type__ = new Type<CodesChangedHandler>();
  
  public Type<CodesChangedHandler> getAssociatedType() {
    return __type__;
  }
  
  public void dispatch(final CodesChangedHandler handler) {
    handler.CodesChanged();
  }
  
  public CodesChangedEvent() {
    
  }
}
