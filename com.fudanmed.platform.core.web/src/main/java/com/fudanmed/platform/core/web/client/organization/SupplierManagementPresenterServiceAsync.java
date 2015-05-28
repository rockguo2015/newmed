package com.fudanmed.platform.core.web.client.organization;

import com.fudanmed.platform.core.domain.proxy.RCSupplierProxy;
import com.fudanmed.platform.core.web.shared.organization.UISupplier;
import com.fudanmed.platform.core.web.shared.organization.UISupplierCriteria;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.uniquesoft.gwt.shared.common.pager.IPagedResult;

public interface SupplierManagementPresenterServiceAsync {
  public abstract void filter(final UISupplierCriteria uicriteria, final AsyncCallback<IPagedResult<UISupplier>> callback);
  
  public abstract void delete(final RCSupplierProxy value, final AsyncCallback<Void> callback);
}
