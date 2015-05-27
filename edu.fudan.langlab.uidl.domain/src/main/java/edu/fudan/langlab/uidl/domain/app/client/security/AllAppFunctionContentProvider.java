package edu.fudan.langlab.uidl.domain.app.client.security;

import com.google.inject.Inject;
import com.uniquesoft.gwt.client.common.ServiceCallback;
import com.uniquesoft.gwt.client.common.widgets.contentprovider.AbstractAsyncContentProvider;
import edu.fudan.langlab.uidl.domain.app.client.security.AllAppFunctionContentProviderServiceAsync;
import edu.fudan.langlab.uidl.domain.app.shared.security.UIAppFunction;
import java.util.Collection;

public class AllAppFunctionContentProvider extends AbstractAsyncContentProvider<UIAppFunction> {
  @Inject
  private AllAppFunctionContentProviderServiceAsync service;
  
  protected void doGetContent(final ServiceCallback<Collection<UIAppFunction>> callback) {
    service.load(callback);
  }
}
