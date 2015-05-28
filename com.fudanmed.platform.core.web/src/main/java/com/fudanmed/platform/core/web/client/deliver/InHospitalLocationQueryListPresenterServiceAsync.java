package com.fudanmed.platform.core.web.client.deliver;

import com.fudanmed.platform.core.web.shared.deliver.UIInHospitalLocation;
import com.fudanmed.platform.core.web.shared.deliver.UIInHospitalLocationCriteria;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.uniquesoft.gwt.shared.common.pager.IPagedResult;

public interface InHospitalLocationQueryListPresenterServiceAsync {
  public abstract void filter(final UIInHospitalLocationCriteria uicriteria, final AsyncCallback<IPagedResult<UIInHospitalLocation>> callback);
}
