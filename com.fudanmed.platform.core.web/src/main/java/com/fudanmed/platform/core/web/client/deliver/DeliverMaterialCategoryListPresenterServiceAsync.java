package com.fudanmed.platform.core.web.client.deliver;

import com.fudanmed.platform.core.web.shared.deliver.UIDeliverMaterialCategory;
import com.google.gwt.user.client.rpc.AsyncCallback;
import java.util.Collection;

public interface DeliverMaterialCategoryListPresenterServiceAsync {
  public abstract void loadDeliverMaterialCategoryList(final AsyncCallback<Collection<UIDeliverMaterialCategory>> callback);
}
