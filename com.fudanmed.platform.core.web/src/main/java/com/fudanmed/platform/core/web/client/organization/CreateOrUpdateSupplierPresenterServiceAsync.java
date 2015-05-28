package com.fudanmed.platform.core.web.client.organization;

import com.fudanmed.platform.core.domain.proxy.RCSupplierProxy;
import com.fudanmed.platform.core.web.shared.organization.UISupplier;
import com.google.gwt.user.client.rpc.AsyncCallback;

public interface CreateOrUpdateSupplierPresenterServiceAsync {
  public abstract void loadValue(final RCSupplierProxy pvalue, final AsyncCallback<UISupplier> callback);
  
  public abstract void updateValue(final UISupplier uivalue, final AsyncCallback<Void> callback);
  
  public abstract void createValue(final UISupplier uivalue, final AsyncCallback<RCSupplierProxy> callback);
}
