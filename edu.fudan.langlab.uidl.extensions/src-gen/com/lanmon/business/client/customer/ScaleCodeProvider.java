package com.lanmon.business.client.customer;

import com.google.inject.Inject;
import com.lanmon.business.client.customer.ScaleCodeProviderServiceAsync;
import com.uniquesoft.gwt.client.common.ServiceCallback;
import com.uniquesoft.gwt.client.common.widgets.contentprovider.AbstractAsyncContentProvider;
import com.uniquesoft.gwt.shared.GWTNamedEntity;
import java.util.Collection;

public class ScaleCodeProvider extends AbstractAsyncContentProvider<GWTNamedEntity> {
  @Inject
  private ScaleCodeProviderServiceAsync service;
  
  protected void doGetContent(final ServiceCallback<Collection<GWTNamedEntity>> callback) {
    service.load(callback);
  }
}
