package com.fudanmed.platform.core.web.client.warehouse;

import com.fudanmed.platform.core.warehouse.proxy.RCProductSpecificationProxy;
import com.fudanmed.platform.core.web.shared.warehouse.UIProductSpecification;
import com.fudanmed.platform.core.web.shared.warehouse.UIProductSpecificationCriteria;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.uniquesoft.gwt.shared.common.pager.IPagedResult;

public interface ProductSpecificationManagementPresenterServiceAsync {
  public abstract void filter(final UIProductSpecificationCriteria uicriteria, final AsyncCallback<IPagedResult<UIProductSpecification>> callback);
  
  public abstract void delete(final RCProductSpecificationProxy value, final AsyncCallback<Void> callback);
}
