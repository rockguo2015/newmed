package edu.fudan.langlab.uidl.domain.code.client.web;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import edu.fudan.langlab.uidl.domain.code.shared.web.UICodeType;
import java.util.Collection;

@RemoteServiceRelativePath("service/edu.fudan.langlab.uidl.domain.code.client.web.UICodeTypeContentProviderService")
public interface UICodeTypeContentProviderService extends RemoteService {
  public abstract Collection<UICodeType> load();
}
