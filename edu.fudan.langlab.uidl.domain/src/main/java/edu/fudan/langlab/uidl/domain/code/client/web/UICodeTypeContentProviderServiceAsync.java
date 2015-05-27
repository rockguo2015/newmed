package edu.fudan.langlab.uidl.domain.code.client.web;

import com.google.gwt.user.client.rpc.AsyncCallback;
import edu.fudan.langlab.uidl.domain.code.shared.web.UICodeType;
import java.util.Collection;

public interface UICodeTypeContentProviderServiceAsync {
  public abstract void load(final AsyncCallback<Collection<UICodeType>> callback);
}
