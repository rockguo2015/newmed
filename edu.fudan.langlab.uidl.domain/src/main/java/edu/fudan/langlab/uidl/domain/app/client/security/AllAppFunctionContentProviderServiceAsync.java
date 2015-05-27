package edu.fudan.langlab.uidl.domain.app.client.security;

import com.google.gwt.user.client.rpc.AsyncCallback;
import edu.fudan.langlab.uidl.domain.app.shared.security.UIAppFunction;
import java.util.Collection;

public interface AllAppFunctionContentProviderServiceAsync {
  public abstract void load(final AsyncCallback<Collection<UIAppFunction>> callback);
}
