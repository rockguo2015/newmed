package com.fudanmed.platform.core.web.client.deliver;

import com.fudanmed.platform.core.web.shared.deliver.UIDeliverMaterialType;
import com.fudanmed.platform.core.web.shared.deliver.UIDeliverMaterialTypeCriteria;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.uniquesoft.gwt.shared.common.pager.IPagedResult;

public interface DeliverMaterialTypeQueryListPresenterServiceAsync {
  public abstract void filter(final UIDeliverMaterialTypeCriteria uicriteria, final AsyncCallback<IPagedResult<UIDeliverMaterialType>> callback);
}
