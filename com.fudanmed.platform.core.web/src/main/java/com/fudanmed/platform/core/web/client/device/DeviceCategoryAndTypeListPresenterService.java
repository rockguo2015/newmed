package com.fudanmed.platform.core.web.client.device;

import com.fudanmed.platform.core.device.proxy.RCDeviceTypeCategoryProxy;
import com.fudanmed.platform.core.web.shared.device.UIDeviceCategoryAndType;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import com.uniquesoft.gwt.shared.DataBaseConstraintException;
import com.uniquesoft.gwt.shared.GWTNamedEntity;
import com.uniquesoft.gwt.shared.SessionTimeOutException;
import com.uniquesoft.gwt.shared.validation.ValidationException;
import java.util.Collection;

@RemoteServiceRelativePath("service/com.fudanmed.platform.core.web.client.device.DeviceCategoryAndTypeListPresenterService")
public interface DeviceCategoryAndTypeListPresenterService extends RemoteService {
  public abstract Collection<UIDeviceCategoryAndType> loadCategories() throws SessionTimeOutException, ValidationException, DataBaseConstraintException;
  
  public abstract GWTNamedEntity loadCategoryOrType(final UIDeviceCategoryAndType categoryOrType) throws SessionTimeOutException, ValidationException, DataBaseConstraintException;
  
  public abstract void loadCategories(final UIDeviceCategoryAndType parent, final RCDeviceTypeCategoryProxy pcategory, final Collection<UIDeviceCategoryAndType> results) throws SessionTimeOutException, ValidationException, DataBaseConstraintException;
}
