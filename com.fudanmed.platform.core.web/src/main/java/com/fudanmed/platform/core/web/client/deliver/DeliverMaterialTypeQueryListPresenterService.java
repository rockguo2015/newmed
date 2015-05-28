package com.fudanmed.platform.core.web.client.deliver;

import com.fudanmed.platform.core.web.shared.deliver.UIDeliverMaterialType;
import com.fudanmed.platform.core.web.shared.deliver.UIDeliverMaterialTypeCriteria;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import com.uniquesoft.gwt.shared.DataBaseConstraintException;
import com.uniquesoft.gwt.shared.SessionTimeOutException;
import com.uniquesoft.gwt.shared.common.pager.IPagedResult;
import com.uniquesoft.gwt.shared.validation.ValidationException;

@RemoteServiceRelativePath("service/com.fudanmed.platform.core.web.client.deliver.DeliverMaterialTypeQueryListPresenterService")
public interface DeliverMaterialTypeQueryListPresenterService extends RemoteService {
  public abstract IPagedResult<UIDeliverMaterialType> filter(final UIDeliverMaterialTypeCriteria uicriteria) throws SessionTimeOutException, ValidationException, DataBaseConstraintException;
}
