package com.fudanmed.platform.core.web.client.device;

import com.fudanmed.platform.core.device.proxy.RCDeviceTypeCategoryProxy;
import com.fudanmed.platform.core.web.shared.device.UIDeviceCategoryAndType;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.uniquesoft.gwt.shared.GWTNamedEntity;
import java.util.Collection;

public interface DeviceCategoryAndTypeListPresenterServiceAsync {
  public abstract void loadCategories(final AsyncCallback<Collection<UIDeviceCategoryAndType>> callback);
  
  public abstract void loadCategoryOrType(final UIDeviceCategoryAndType categoryOrType, final AsyncCallback<GWTNamedEntity> callback);
  
  public abstract void loadCategories(final UIDeviceCategoryAndType parent, final RCDeviceTypeCategoryProxy pcategory, final Collection<UIDeviceCategoryAndType> results, final AsyncCallback<Void> callback);
}
