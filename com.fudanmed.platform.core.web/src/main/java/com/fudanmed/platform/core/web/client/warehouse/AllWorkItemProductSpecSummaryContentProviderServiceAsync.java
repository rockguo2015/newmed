package com.fudanmed.platform.core.web.client.warehouse;

import com.fudanmed.platform.core.web.shared.warehouse.AllWorkItemProductSpecSummaryContentProviderCriteria;
import com.fudanmed.platform.core.web.shared.warehouse.UIProductSpecificationSummary;
import com.google.gwt.user.client.rpc.AsyncCallback;
import java.util.Collection;

public interface AllWorkItemProductSpecSummaryContentProviderServiceAsync {
  public abstract void load(final AllWorkItemProductSpecSummaryContentProviderCriteria criteria, final AsyncCallback<Collection<UIProductSpecificationSummary>> callback);
}
