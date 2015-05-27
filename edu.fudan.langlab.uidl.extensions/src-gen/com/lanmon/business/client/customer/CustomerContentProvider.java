package com.lanmon.business.client.customer;

import com.google.inject.Inject;
import com.lanmon.business.client.customer.CustomerContentProviderServiceAsync;
import com.lanmon.business.shared.customer.CustomerContentProviderCriteria;
import com.uniquesoft.gwt.client.common.ServiceCallback;
import com.uniquesoft.gwt.client.common.widgets.contentprovider.AbstractAsyncContentProviderWithFilter;
import com.uniquesoft.gwt.shared.GWTNamedEntity;
import java.util.Collection;

public class CustomerContentProvider extends AbstractAsyncContentProviderWithFilter<GWTNamedEntity,CustomerContentProviderCriteria> {
  public CustomerContentProviderCriteria createCriteria() {
    return new com.lanmon.business.shared.customer.CustomerContentProviderCriteria();
  }
  
  @Inject
  private CustomerContentProviderServiceAsync service;
  
  protected void doGetContent(final CustomerContentProviderCriteria context, final ServiceCallback<Collection<GWTNamedEntity>> callback) {
    service.load(context, callback);
  }
}
