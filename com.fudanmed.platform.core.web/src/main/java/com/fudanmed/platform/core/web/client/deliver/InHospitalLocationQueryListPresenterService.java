package com.fudanmed.platform.core.web.client.deliver;

import com.fudanmed.platform.core.web.shared.deliver.UIInHospitalLocation;
import com.fudanmed.platform.core.web.shared.deliver.UIInHospitalLocationCriteria;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import com.uniquesoft.gwt.shared.DataBaseConstraintException;
import com.uniquesoft.gwt.shared.SessionTimeOutException;
import com.uniquesoft.gwt.shared.common.pager.IPagedResult;
import com.uniquesoft.gwt.shared.validation.ValidationException;

@RemoteServiceRelativePath("service/com.fudanmed.platform.core.web.client.deliver.InHospitalLocationQueryListPresenterService")
public interface InHospitalLocationQueryListPresenterService extends RemoteService {
  public abstract IPagedResult<UIInHospitalLocation> filter(final UIInHospitalLocationCriteria uicriteria) throws SessionTimeOutException, ValidationException, DataBaseConstraintException;
}
