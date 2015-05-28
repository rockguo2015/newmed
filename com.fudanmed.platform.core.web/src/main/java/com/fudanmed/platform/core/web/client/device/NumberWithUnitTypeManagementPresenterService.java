package com.fudanmed.platform.core.web.client.device;

import com.fudanmed.platform.core.entityextension.proxy.RCCustomizableTypeProxy;
import com.fudanmed.platform.core.entityextension.proxy.RCNumberWithUnitTypeProxy;
import com.fudanmed.platform.core.web.shared.device.UICustomizableType;
import com.fudanmed.platform.core.web.shared.device.UICustomizableTypeCriteria;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import com.uniquesoft.gwt.shared.DataBaseConstraintException;
import com.uniquesoft.gwt.shared.SessionTimeOutException;
import com.uniquesoft.gwt.shared.common.pager.IPagedResult;
import com.uniquesoft.gwt.shared.validation.ValidationException;

@RemoteServiceRelativePath("service/com.fudanmed.platform.core.web.client.device.NumberWithUnitTypeManagementPresenterService")
public interface NumberWithUnitTypeManagementPresenterService extends RemoteService {
  public abstract IPagedResult<UICustomizableType> filter(final UICustomizableTypeCriteria uicriteria) throws SessionTimeOutException, ValidationException, DataBaseConstraintException;
  
  public abstract Boolean rangeTypeCreated(final RCNumberWithUnitTypeProxy baseType) throws SessionTimeOutException, ValidationException, DataBaseConstraintException;
  
  public abstract void createRangeType(final RCNumberWithUnitTypeProxy baseType) throws SessionTimeOutException, ValidationException, DataBaseConstraintException;
  
  public abstract void delete(final RCCustomizableTypeProxy value) throws SessionTimeOutException, ValidationException, DataBaseConstraintException;
}
