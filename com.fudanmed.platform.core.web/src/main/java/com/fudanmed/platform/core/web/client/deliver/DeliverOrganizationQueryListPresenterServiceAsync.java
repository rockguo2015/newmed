package com.fudanmed.platform.core.web.client.deliver;

import com.fudanmed.platform.core.web.shared.deliver.UIDeliverOrganization;
import com.fudanmed.platform.core.web.shared.deliver.UIDeliverOrganizationCriteria;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.uniquesoft.gwt.shared.common.pager.IPagedResult;

public interface DeliverOrganizationQueryListPresenterServiceAsync {
  public abstract void filter(final UIDeliverOrganizationCriteria uicriteria, final AsyncCallback<IPagedResult<UIDeliverOrganization>> callback);
}
