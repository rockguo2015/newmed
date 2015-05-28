package com.fudanmed.platform.core.web.client.deliver;

import com.fudanmed.platform.core.web.shared.deliver.UIDeliverMaterialCategory;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import com.uniquesoft.gwt.shared.DataBaseConstraintException;
import com.uniquesoft.gwt.shared.SessionTimeOutException;
import com.uniquesoft.gwt.shared.validation.ValidationException;
import java.util.Collection;

@RemoteServiceRelativePath("service/com.fudanmed.platform.core.web.client.deliver.DeliverMaterialCategoryListPresenterService")
public interface DeliverMaterialCategoryListPresenterService extends RemoteService {
  public abstract Collection<UIDeliverMaterialCategory> loadDeliverMaterialCategoryList() throws SessionTimeOutException, ValidationException, DataBaseConstraintException;
}
