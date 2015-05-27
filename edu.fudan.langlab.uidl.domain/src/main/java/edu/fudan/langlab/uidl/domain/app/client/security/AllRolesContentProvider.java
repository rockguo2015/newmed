package edu.fudan.langlab.uidl.domain.app.client.security;

import com.google.inject.Inject;
import com.uniquesoft.gwt.client.common.ServiceCallback;
import com.uniquesoft.gwt.client.common.widgets.contentprovider.AbstractAsyncContentProvider;
import edu.fudan.langlab.domain.security.proxy.RoleProxy;
import edu.fudan.langlab.uidl.domain.app.client.security.AllRolesContentProviderServiceAsync;
import java.util.Collection;

public class AllRolesContentProvider extends AbstractAsyncContentProvider<RoleProxy> {
  @Inject
  private AllRolesContentProviderServiceAsync service;
  
  protected void doGetContent(final ServiceCallback<Collection<RoleProxy>> callback) {
    service.load(callback);
  }
}
