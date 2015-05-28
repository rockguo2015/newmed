package com.fudanmed.platform.core.web.client.deliver;

import com.fudanmed.platform.core.deliver.proxy.DLCenterlizedDeliverTaskProxy;
import com.fudanmed.platform.core.web.shared.deliver.DeliverTaskDispatchData;
import com.fudanmed.platform.core.web.shared.deliver.UICenterlizedDeliverTask;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import com.uniquesoft.gwt.shared.DataBaseConstraintException;
import com.uniquesoft.gwt.shared.SessionTimeOutException;
import com.uniquesoft.gwt.shared.validation.ValidationException;
import java.util.Collection;

@RemoteServiceRelativePath("service/com.fudanmed.platform.core.web.client.deliver.DeliverTaskDispatchPresenterService")
public interface DeliverTaskDispatchPresenterService extends RemoteService {
  public abstract void commit(final Collection<DLCenterlizedDeliverTaskProxy> context, final DeliverTaskDispatchData data) throws SessionTimeOutException, ValidationException, DataBaseConstraintException;
  
  public abstract Collection<UICenterlizedDeliverTask> resolveTasks(final Collection<DLCenterlizedDeliverTaskProxy> tasks) throws SessionTimeOutException, ValidationException, DataBaseConstraintException;
}
