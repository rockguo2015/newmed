package com.fudanmed.platform.core.web.client.warehouse;

import com.fudanmed.platform.core.warehouse.proxy.RCProductSpecificationProxy;
import com.fudanmed.platform.core.web.shared.warehouse.UIProductSpecification;
import com.google.gwt.user.client.rpc.AsyncCallback;

public interface ProductSpecificationDetailPresenterServiceAsync {
  public abstract void loadDetail(final RCProductSpecificationProxy detail, final AsyncCallback<UIProductSpecification> callback);
}
