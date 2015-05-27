package edu.fudan.langlab.uidl.domain.code.client.web;

import com.google.gwt.user.client.rpc.AsyncCallback;
import edu.fudan.langlab.domain.code.proxy.CodeProxy;
import edu.fudan.langlab.uidl.domain.code.shared.web.UICode;
import edu.fudan.langlab.uidl.domain.code.shared.web.UICodeType;

public interface CreateOrUpdateCodePresenterServiceAsync {
  public abstract void loadValue(final CodeProxy pvalue, final AsyncCallback<UICode> callback);
  
  public abstract void updateValue(final UICode uivalue, final AsyncCallback<Void> callback);
  
  public abstract void createValue(final UICodeType uiCodeType, final UICode uivalue, final AsyncCallback<Void> callback);
}
