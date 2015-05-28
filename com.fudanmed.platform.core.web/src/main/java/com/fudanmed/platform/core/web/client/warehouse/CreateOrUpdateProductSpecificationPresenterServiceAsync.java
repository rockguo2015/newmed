package com.fudanmed.platform.core.web.client.warehouse;

import com.fudanmed.platform.core.warehouse.proxy.RCProductSpecificationProxy;
import com.fudanmed.platform.core.web.shared.warehouse.UIProductSpecification;
import com.google.gwt.user.client.rpc.AsyncCallback;

public interface CreateOrUpdateProductSpecificationPresenterServiceAsync {
  public abstract void loadValue(final RCProductSpecificationProxy pvalue, final AsyncCallback<UIProductSpecification> callback);
  
  public abstract void updateValue(final UIProductSpecification uivalue, final AsyncCallback<Void> callback);
  
  public abstract void createValue(final UIProductSpecification uivalue, final AsyncCallback<Void> callback);
}
