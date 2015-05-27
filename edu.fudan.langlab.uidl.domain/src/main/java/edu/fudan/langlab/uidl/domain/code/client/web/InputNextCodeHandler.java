package edu.fudan.langlab.uidl.domain.code.client.web;

import com.google.gwt.event.shared.EventHandler;
import edu.fudan.langlab.uidl.domain.code.shared.web.UICodeType;

public interface InputNextCodeHandler extends EventHandler {
  public abstract void InputNextCode(final UICodeType codeType);
}
