package com.fudanmed.platform.core.web.client.warehouse;

import com.fudanmed.platform.core.domain.proxy.RCEmployeeProxy;
import com.fudanmed.platform.core.warehouse.proxy.RCProductSpecificationProxy;
import com.fudanmed.platform.core.warehouse.proxy.RCProductWarehouseStorageSummaryProxy;
import com.fudanmed.platform.core.web.shared.warehouse.UIProductWarehouseStorageSummary;
import com.fudanmed.platform.core.web.shared.warehouse.UIProductWarehouseStorageSummaryCriteria;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.uniquesoft.gwt.shared.common.pager.IPagedResult;

public interface ProductWarehouseStorageSummaryManagementPresenterServiceAsync {
  public abstract void filter(final UIProductWarehouseStorageSummaryCriteria uicriteria, final AsyncCallback<IPagedResult<UIProductWarehouseStorageSummary>> callback);
  
  public abstract void delete(final RCProductWarehouseStorageSummaryProxy value, final AsyncCallback<Void> callback);
  
  public abstract void getProductSpec(final RCProductWarehouseStorageSummaryProxy value, final AsyncCallback<RCProductSpecificationProxy> callback);
  
  public abstract void loadCurrentUser(final AsyncCallback<RCEmployeeProxy> callback);
}
