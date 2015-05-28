package com.fudanmed.platform.core.web.client.device;

import com.fudanmed.platform.core.web.client.device.DocumentStorageListView;
import com.fudanmed.platform.core.web.shared.device.UIDocumentStorage;
import com.google.inject.ImplementedBy;
import com.uniquesoft.gwt.client.common.RequestHandler1;
import com.uniquesoft.gwt.client.common.Viewer;
import com.uniquesoft.gwt.client.common.action.ActionContext;
import com.uniquesoft.gwt.shared.command.IContextProvider;
import edu.fudan.langlab.domain.document.proxy.DocumentStorageProxy;
import java.util.Collection;

@ImplementedBy(value = DocumentStorageListView.class)
public interface DocumentStorageListPresenterView extends Viewer, IContextProvider<UIDocumentStorage> {
  public abstract void viewDocument(final RequestHandler1<DocumentStorageProxy> requestHandler);
  
  public abstract void setResults(final Collection<UIDocumentStorage> results);
  
  public abstract ActionContext<UIDocumentStorage> getActionContext();
  
  public abstract void clear();
}
