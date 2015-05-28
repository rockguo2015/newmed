package com.fudanmed.platform.core.web.client.device;

import com.fudanmed.platform.core.entityextension.proxy.RCAttributeSlotProxy;
import com.fudanmed.platform.core.entityextension.proxy.RCExtensiableEntityProxy;
import com.fudanmed.platform.core.web.shared.device.UIAttributeSlot;
import com.fudanmed.platform.core.web.shared.device.UIPrimaryAttribute;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import com.uniquesoft.gwt.shared.DataBaseConstraintException;
import com.uniquesoft.gwt.shared.SessionTimeOutException;
import com.uniquesoft.gwt.shared.validation.ValidationException;

@RemoteServiceRelativePath("service/com.fudanmed.platform.core.web.client.device.CreatePrimaryTypePresenterService")
public interface CreatePrimaryTypePresenterService extends RemoteService {
  public abstract String loadSlotName(final RCAttributeSlotProxy slot) throws SessionTimeOutException, ValidationException, DataBaseConstraintException;
  
  public abstract UIAttributeSlot createExtensiableEntityAttribute(final RCExtensiableEntityProxy ee, final UIPrimaryAttribute attribute) throws SessionTimeOutException, ValidationException, DataBaseConstraintException;
  
  public abstract UIAttributeSlot createCompositeSlotAttribute(final RCAttributeSlotProxy slot, final UIPrimaryAttribute attribute) throws SessionTimeOutException, ValidationException, DataBaseConstraintException;
}
