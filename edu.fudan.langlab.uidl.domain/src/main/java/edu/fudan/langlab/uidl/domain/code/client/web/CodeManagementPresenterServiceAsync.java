package edu.fudan.langlab.uidl.domain.code.client.web;

import com.google.gwt.user.client.rpc.AsyncCallback;
import edu.fudan.langlab.domain.code.proxy.CodeProxy;
import edu.fudan.langlab.uidl.domain.code.shared.web.UICode;
import edu.fudan.langlab.uidl.domain.code.shared.web.UICodeCriteria;
import java.util.Collection;

public interface CodeManagementPresenterServiceAsync {
  public abstract void filter(final UICodeCriteria uicriteria, final AsyncCallback<Collection<UICode>> callback);
  
  public abstract void delete(final CodeProxy value, final AsyncCallback<Void> callback);
}
