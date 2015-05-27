package edu.fudan.langlab.uidl.domain.code.client.web;

import com.google.inject.Inject;
import com.uniquesoft.gwt.client.common.ServiceCallback;
import com.uniquesoft.gwt.client.common.widgets.contentprovider.AbstractAsyncContentProvider;
import edu.fudan.langlab.uidl.domain.code.client.web.UICodeTypeContentProviderServiceAsync;
import edu.fudan.langlab.uidl.domain.code.shared.web.UICodeType;
import java.util.Collection;

public class UICodeTypeContentProvider extends AbstractAsyncContentProvider<UICodeType> {
  @Inject
  private UICodeTypeContentProviderServiceAsync service;
  
  protected void doGetContent(final ServiceCallback<Collection<UICodeType>> callback) {
    service.load(callback);
  }
}
