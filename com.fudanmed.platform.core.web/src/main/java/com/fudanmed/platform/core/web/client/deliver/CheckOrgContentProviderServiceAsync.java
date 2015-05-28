package com.fudanmed.platform.core.web.client.deliver;

import com.fudanmed.platform.core.deliver.proxy.DLCheckOrganizationProxy;
import com.fudanmed.platform.core.web.shared.deliver.CheckOrgContentProviderCriteria;
import com.google.gwt.user.client.rpc.AsyncCallback;
import java.util.Collection;

public interface CheckOrgContentProviderServiceAsync {
  public abstract void load(final CheckOrgContentProviderCriteria criteria, final AsyncCallback<Collection<DLCheckOrganizationProxy>> callback);
}
