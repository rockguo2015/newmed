package com.fudanmed.platform.core.web.client.device;

import com.fudanmed.platform.core.entityextension.proxy.RCCustomizableTypeProxy;
import com.fudanmed.platform.core.entityextension.proxy.RCNumberWithUnitTypeProxy;
import com.fudanmed.platform.core.web.shared.device.UICustomizableType;
import com.fudanmed.platform.core.web.shared.device.UICustomizableTypeCriteria;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.uniquesoft.gwt.shared.common.pager.IPagedResult;

public interface NumberWithUnitTypeManagementPresenterServiceAsync {
  public abstract void filter(final UICustomizableTypeCriteria uicriteria, final AsyncCallback<IPagedResult<UICustomizableType>> callback);
  
  public abstract void rangeTypeCreated(final RCNumberWithUnitTypeProxy baseType, final AsyncCallback<Boolean> callback);
  
  public abstract void createRangeType(final RCNumberWithUnitTypeProxy baseType, final AsyncCallback<Void> callback);
  
  public abstract void delete(final RCCustomizableTypeProxy value, final AsyncCallback<Void> callback);
}
