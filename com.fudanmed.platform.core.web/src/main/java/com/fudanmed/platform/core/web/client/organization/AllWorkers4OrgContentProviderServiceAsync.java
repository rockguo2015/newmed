package com.fudanmed.platform.core.web.client.organization;

import com.fudanmed.platform.core.web.shared.organization.AllWorkers4OrgContentProviderCriteria;
import com.fudanmed.platform.core.web.shared.project.UIWorker;
import com.google.gwt.user.client.rpc.AsyncCallback;
import java.util.Collection;

public interface AllWorkers4OrgContentProviderServiceAsync {
  public abstract void load(final AllWorkers4OrgContentProviderCriteria criteria, final AsyncCallback<Collection<UIWorker>> callback);
}
