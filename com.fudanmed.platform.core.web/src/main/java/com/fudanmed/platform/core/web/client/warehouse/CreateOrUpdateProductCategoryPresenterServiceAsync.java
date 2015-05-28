package com.fudanmed.platform.core.web.client.warehouse;

import com.fudanmed.platform.core.warehouse.proxy.RCProductCategoryProxy;
import com.fudanmed.platform.core.web.shared.warehouse.UIProductCategory;
import com.google.gwt.user.client.rpc.AsyncCallback;

public interface CreateOrUpdateProductCategoryPresenterServiceAsync {
  public abstract void loadValue(final RCProductCategoryProxy pvalue, final AsyncCallback<UIProductCategory> callback);
  
  public abstract void updateValue(final UIProductCategory uivalue, final AsyncCallback<Void> callback);
  
  public abstract void createValue(final UIProductCategory uivalue, final AsyncCallback<RCProductCategoryProxy> callback);
}
