package com.fudanmed.platform.core.web.client.deliver;

import com.fudanmed.platform.core.deliver.proxy.DLDeliverMaterialCategoryProxy;
import com.fudanmed.platform.core.web.shared.deliver.UIDeliverMaterialCategory;
import com.google.gwt.user.client.rpc.AsyncCallback;

public interface CreateOrUpdateDeliverMaterialCategoryPresenterServiceAsync {
  public abstract void loadValue(final DLDeliverMaterialCategoryProxy pvalue, final AsyncCallback<UIDeliverMaterialCategory> callback);
  
  public abstract void updateValue(final UIDeliverMaterialCategory uivalue, final AsyncCallback<Void> callback);
  
  public abstract void createValue(final DLDeliverMaterialCategoryProxy parent, final UIDeliverMaterialCategory uivalue, final AsyncCallback<Void> callback);
}
