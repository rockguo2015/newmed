package com.fudanmed.platform.core.web.client.deliver;

import com.fudanmed.platform.core.web.shared.deliver.UIDeliverPatientCheckCategory;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import com.uniquesoft.gwt.shared.DataBaseConstraintException;
import com.uniquesoft.gwt.shared.SessionTimeOutException;
import com.uniquesoft.gwt.shared.validation.ValidationException;
import java.util.Collection;

@RemoteServiceRelativePath("service/com.fudanmed.platform.core.web.client.deliver.DeliverPatientCheckCategoryListPresenterService")
public interface DeliverPatientCheckCategoryListPresenterService extends RemoteService {
  public abstract Collection<UIDeliverPatientCheckCategory> loadDeliverPatientCheckCategoryList() throws SessionTimeOutException, ValidationException, DataBaseConstraintException;
}
