package com.fudanmed.platform.core.web.client.deliver;

import com.fudanmed.platform.core.deliver.proxy.DLDeliverMaterialCategoryProxy;
import com.fudanmed.platform.core.deliver.proxy.DLDeliverMaterialTypeProxy;
import com.fudanmed.platform.core.web.shared.deliver.UIDeliverMaterialType;
import com.google.gwt.user.client.rpc.AsyncCallback;

public interface CreateOrUpdateDeliverMaterialTypePresenterServiceAsync {
  public abstract void loadValue(final DLDeliverMaterialTypeProxy pvalue, final AsyncCallback<UIDeliverMaterialType> callback);
  
  public abstract void updateValue(final UIDeliverMaterialType uivalue, final AsyncCallback<Void> callback);
  
  public abstract void createValue(final UIDeliverMaterialType uivalue, final DLDeliverMaterialCategoryProxy parent, final AsyncCallback<Void> callback);
}
