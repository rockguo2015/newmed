package com.fudanmed.platform.core.web.client.deliver;

import com.fudanmed.platform.core.web.shared.deliver.UIDeliverPatientCheckType;
import com.fudanmed.platform.core.web.shared.deliver.UIDeliverPatientCheckTypeCriteria;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.uniquesoft.gwt.shared.common.pager.IPagedResult;

public interface DeliverPatientCheckTypeQueryListPresenterServiceAsync {
  public abstract void filter(final UIDeliverPatientCheckTypeCriteria uicriteria, final AsyncCallback<IPagedResult<UIDeliverPatientCheckType>> callback);
}
