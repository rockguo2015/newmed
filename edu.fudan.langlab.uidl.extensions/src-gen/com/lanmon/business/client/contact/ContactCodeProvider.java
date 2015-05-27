package com.lanmon.business.client.contact;

import com.google.inject.Inject;
import com.lanmon.business.client.contact.ContactCodeProviderServiceAsync;
import com.uniquesoft.gwt.client.common.ServiceCallback;
import com.uniquesoft.gwt.client.common.widgets.contentprovider.AbstractAsyncContentProvider;
import com.uniquesoft.gwt.shared.GWTNamedEntity;
import java.util.Collection;

public class ContactCodeProvider extends AbstractAsyncContentProvider<GWTNamedEntity> {
  @Inject
  private ContactCodeProviderServiceAsync service;
  
  protected void doGetContent(final ServiceCallback<Collection<GWTNamedEntity>> callback) {
    service.load(callback);
  }
}
