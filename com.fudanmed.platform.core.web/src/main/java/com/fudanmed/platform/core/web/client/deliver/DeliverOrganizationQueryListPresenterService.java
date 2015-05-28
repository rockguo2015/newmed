package com.fudanmed.platform.core.web.client.deliver;

import com.fudanmed.platform.core.web.shared.deliver.UIDeliverOrganization;
import com.fudanmed.platform.core.web.shared.deliver.UIDeliverOrganizationCriteria;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import com.uniquesoft.gwt.shared.DataBaseConstraintException;
import com.uniquesoft.gwt.shared.SessionTimeOutException;
import com.uniquesoft.gwt.shared.common.pager.IPagedResult;
import com.uniquesoft.gwt.shared.validation.ValidationException;

@RemoteServiceRelativePath("service/com.fudanmed.platform.core.web.client.deliver.DeliverOrganizationQueryListPresenterService")
public interface DeliverOrganizationQueryListPresenterService extends RemoteService {
  public abstract IPagedResult<UIDeliverOrganization> filter(final UIDeliverOrganizationCriteria uicriteria) throws SessionTimeOutException, ValidationException, DataBaseConstraintException;
}
