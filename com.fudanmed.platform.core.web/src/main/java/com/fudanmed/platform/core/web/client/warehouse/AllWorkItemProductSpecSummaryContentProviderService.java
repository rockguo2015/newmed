package com.fudanmed.platform.core.web.client.warehouse;

import com.fudanmed.platform.core.web.shared.warehouse.AllWorkItemProductSpecSummaryContentProviderCriteria;
import com.fudanmed.platform.core.web.shared.warehouse.UIProductSpecificationSummary;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import java.util.Collection;

@RemoteServiceRelativePath("service/com.fudanmed.platform.core.web.client.warehouse.AllWorkItemProductSpecSummaryContentProviderService")
public interface AllWorkItemProductSpecSummaryContentProviderService extends RemoteService {
  public abstract Collection<UIProductSpecificationSummary> load(final AllWorkItemProductSpecSummaryContentProviderCriteria criteria);
}
