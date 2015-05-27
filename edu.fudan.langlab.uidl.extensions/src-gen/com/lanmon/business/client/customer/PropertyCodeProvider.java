package com.lanmon.business.client.customer;

import com.google.inject.Inject;
import com.lanmon.business.client.customer.PropertyCodeProviderServiceAsync;
import com.uniquesoft.gwt.client.common.ServiceCallback;
import com.uniquesoft.gwt.client.common.widgets.contentprovider.AbstractAsyncContentProvider;
import com.uniquesoft.gwt.shared.GWTNamedEntity;
import java.util.Collection;

public class PropertyCodeProvider extends AbstractAsyncContentProvider<GWTNamedEntity> {
  @Inject
  private PropertyCodeProviderServiceAsync service;
  
  protected void doGetContent(final ServiceCallback<Collection<GWTNamedEntity>> callback) {
    service.load(callback);
  }
}
