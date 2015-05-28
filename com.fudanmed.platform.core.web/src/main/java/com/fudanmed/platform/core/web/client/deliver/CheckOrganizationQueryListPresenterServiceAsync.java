package com.fudanmed.platform.core.web.client.deliver;

import com.fudanmed.platform.core.web.shared.deliver.UICheckOrganization;
import com.fudanmed.platform.core.web.shared.deliver.UICheckOrganizationCriteria;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.uniquesoft.gwt.shared.common.pager.IPagedResult;

public interface CheckOrganizationQueryListPresenterServiceAsync {
  public abstract void filter(final UICheckOrganizationCriteria uicriteria, final AsyncCallback<IPagedResult<UICheckOrganization>> callback);
}
