package com.fudanmed.platform.core.web.client.warehouse;

import com.fudanmed.platform.core.web.shared.warehouse.AllProductSpecificationContentProviderCriteria;
import com.fudanmed.platform.core.web.shared.warehouse.UIProductSpecification;
import com.google.gwt.user.client.rpc.AsyncCallback;
import java.util.Collection;

public interface AllProductSpecificationContentProviderServiceAsync {
  public abstract void load(final AllProductSpecificationContentProviderCriteria criteria, final AsyncCallback<Collection<UIProductSpecification>> callback);
}
