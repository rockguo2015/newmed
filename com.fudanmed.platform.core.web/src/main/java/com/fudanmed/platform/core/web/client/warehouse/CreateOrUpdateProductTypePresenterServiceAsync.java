package com.fudanmed.platform.core.web.client.warehouse;

import com.fudanmed.platform.core.warehouse.proxy.RCProductCategoryProxy;
import com.fudanmed.platform.core.warehouse.proxy.RCProductTypeProxy;
import com.fudanmed.platform.core.web.shared.warehouse.UIProductType;
import com.google.gwt.user.client.rpc.AsyncCallback;

public interface CreateOrUpdateProductTypePresenterServiceAsync {
  public abstract void loadValue(final RCProductTypeProxy pvalue, final AsyncCallback<UIProductType> callback);
  
  public abstract void updateValue(final UIProductType uivalue, final AsyncCallback<Void> callback);
  
  public abstract void createValue(final RCProductCategoryProxy parent, final UIProductType uivalue, final AsyncCallback<Void> callback);
}
