package edu.fudan.langlab.uidl.domain.code.client.web;

import com.google.gwt.event.shared.GwtEvent;
import com.google.gwt.event.shared.GwtEvent.Type;
import edu.fudan.langlab.uidl.domain.code.client.web.InputNextCodeHandler;
import edu.fudan.langlab.uidl.domain.code.shared.web.UICodeType;

public class InputNextCodeEvent extends GwtEvent<InputNextCodeHandler> {
  public static Type<InputNextCodeHandler> __type__ = new Type<InputNextCodeHandler>();
  
  public Type<InputNextCodeHandler> getAssociatedType() {
    return __type__;
  }
  
  public void dispatch(final InputNextCodeHandler handler) {
    handler.InputNextCode(codeType);
  }
  
  private UICodeType codeType;
  
  public InputNextCodeEvent(final UICodeType codeType) {
    this.codeType=codeType;
    
  }
}
