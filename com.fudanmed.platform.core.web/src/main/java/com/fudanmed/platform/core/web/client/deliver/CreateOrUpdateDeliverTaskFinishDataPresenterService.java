package com.fudanmed.platform.core.web.client.deliver;

import com.fudanmed.platform.core.deliver.proxy.DLCenterlizedDeliverTaskProxy;
import com.fudanmed.platform.core.web.shared.deliver.UIDeliverTaskFinishData;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import com.uniquesoft.gwt.shared.DataBaseConstraintException;
import com.uniquesoft.gwt.shared.SessionTimeOutException;
import com.uniquesoft.gwt.shared.validation.ValidationException;
import java.util.Collection;

@RemoteServiceRelativePath("service/com.fudanmed.platform.core.web.client.deliver.CreateOrUpdateDeliverTaskFinishDataPresenterService")
public interface CreateOrUpdateDeliverTaskFinishDataPresenterService extends RemoteService {
  public abstract void commit(final Collection<DLCenterlizedDeliverTaskProxy> deliverTasks, final UIDeliverTaskFinishData uivalue) throws SessionTimeOutException, ValidationException, DataBaseConstraintException;
}
