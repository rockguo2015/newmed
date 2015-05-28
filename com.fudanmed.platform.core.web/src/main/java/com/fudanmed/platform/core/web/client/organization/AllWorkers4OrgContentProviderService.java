package com.fudanmed.platform.core.web.client.organization;

import com.fudanmed.platform.core.web.shared.organization.AllWorkers4OrgContentProviderCriteria;
import com.fudanmed.platform.core.web.shared.project.UIWorker;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import java.util.Collection;

@RemoteServiceRelativePath("service/com.fudanmed.platform.core.web.client.organization.AllWorkers4OrgContentProviderService")
public interface AllWorkers4OrgContentProviderService extends RemoteService {
  public abstract Collection<UIWorker> load(final AllWorkers4OrgContentProviderCriteria criteria);
}
