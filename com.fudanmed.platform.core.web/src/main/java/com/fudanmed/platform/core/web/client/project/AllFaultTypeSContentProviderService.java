package com.fudanmed.platform.core.web.client.project;

import com.fudanmed.platform.core.web.shared.project.AllFaultTypeSContentProviderCriteria;
import com.fudanmed.platform.core.web.shared.project.UIFaultType;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import java.util.Collection;

@RemoteServiceRelativePath("service/com.fudanmed.platform.core.web.client.project.AllFaultTypeSContentProviderService")
public interface AllFaultTypeSContentProviderService extends RemoteService {
  public abstract Collection<UIFaultType> load(final AllFaultTypeSContentProviderCriteria criteria);
}
