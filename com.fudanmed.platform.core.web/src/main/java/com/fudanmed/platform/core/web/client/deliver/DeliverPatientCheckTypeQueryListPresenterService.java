package com.fudanmed.platform.core.web.client.deliver;

import com.fudanmed.platform.core.web.shared.deliver.UIDeliverPatientCheckType;
import com.fudanmed.platform.core.web.shared.deliver.UIDeliverPatientCheckTypeCriteria;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import com.uniquesoft.gwt.shared.DataBaseConstraintException;
import com.uniquesoft.gwt.shared.SessionTimeOutException;
import com.uniquesoft.gwt.shared.common.pager.IPagedResult;
import com.uniquesoft.gwt.shared.validation.ValidationException;

@RemoteServiceRelativePath("service/com.fudanmed.platform.core.web.client.deliver.DeliverPatientCheckTypeQueryListPresenterService")
public interface DeliverPatientCheckTypeQueryListPresenterService extends RemoteService {
  public abstract IPagedResult<UIDeliverPatientCheckType> filter(final UIDeliverPatientCheckTypeCriteria uicriteria) throws SessionTimeOutException, ValidationException, DataBaseConstraintException;
}
