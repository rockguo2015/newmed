package edu.fudan.langlab.uidl.domain.app.client.security;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import edu.fudan.langlab.uidl.domain.app.shared.security.UIAppFunction;
import java.util.Collection;

@RemoteServiceRelativePath("service/edu.fudan.langlab.uidl.domain.app.client.security.AllAppFunctionContentProviderService")
public interface AllAppFunctionContentProviderService extends RemoteService {
  public abstract Collection<UIAppFunction> load();
}
