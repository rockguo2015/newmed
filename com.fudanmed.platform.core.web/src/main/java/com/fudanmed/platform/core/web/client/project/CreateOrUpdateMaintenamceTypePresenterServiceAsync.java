package com.fudanmed.platform.core.web.client.project;

import com.fudanmed.platform.core.domain.proxy.RCMaintenamceTypeProxy;
import com.fudanmed.platform.core.web.shared.project.UIMaintenamceType;
import com.google.gwt.user.client.rpc.AsyncCallback;

public interface CreateOrUpdateMaintenamceTypePresenterServiceAsync {
  public abstract void loadValue(final RCMaintenamceTypeProxy pvalue, final AsyncCallback<UIMaintenamceType> callback);
  
  public abstract void updateValue(final UIMaintenamceType uivalue, final AsyncCallback<Void> callback);
  
  public abstract void createValue(final UIMaintenamceType uivalue, final AsyncCallback<RCMaintenamceTypeProxy> callback);
}
