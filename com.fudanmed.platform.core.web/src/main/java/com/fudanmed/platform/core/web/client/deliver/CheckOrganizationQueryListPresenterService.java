package com.fudanmed.platform.core.web.client.deliver;

import com.fudanmed.platform.core.web.shared.deliver.UICheckOrganization;
import com.fudanmed.platform.core.web.shared.deliver.UICheckOrganizationCriteria;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import com.uniquesoft.gwt.shared.DataBaseConstraintException;
import com.uniquesoft.gwt.shared.SessionTimeOutException;
import com.uniquesoft.gwt.shared.common.pager.IPagedResult;
import com.uniquesoft.gwt.shared.validation.ValidationException;

@RemoteServiceRelativePath("service/com.fudanmed.platform.core.web.client.deliver.CheckOrganizationQueryListPresenterService")
public interface CheckOrganizationQueryListPresenterService extends RemoteService {
  public abstract IPagedResult<UICheckOrganization> filter(final UICheckOrganizationCriteria uicriteria) throws SessionTimeOutException, ValidationException, DataBaseConstraintException;
}
