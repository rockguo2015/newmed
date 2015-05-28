package com.fudanmed.platform.core.web.client.warehouse;

import com.fudanmed.platform.core.warehouse.proxy.RCProductCategoryProxy;
import com.fudanmed.platform.core.warehouse.proxy.RCProductTypeProxy;
import com.fudanmed.platform.core.web.shared.warehouse.UIProductCategory;
import com.fudanmed.platform.core.web.shared.warehouse.UIProductType;
import com.google.gwt.user.client.rpc.AsyncCallback;
import java.util.Collection;

public interface ProductCategoryManagementPresenterServiceAsync {
  public abstract void loadAllProductCategory(final AsyncCallback<Collection<UIProductCategory>> callback);
  
  public abstract void delete(final RCProductCategoryProxy value, final AsyncCallback<Void> callback);
  
  public abstract void getValue(final RCProductCategoryProxy org, final AsyncCallback<UIProductCategory> callback);
  
  public abstract void loadItems(final RCProductCategoryProxy value, final AsyncCallback<Collection<UIProductType>> callback);
  
  public abstract void deleteChild(final RCProductTypeProxy child, final AsyncCallback<Void> callback);
}
