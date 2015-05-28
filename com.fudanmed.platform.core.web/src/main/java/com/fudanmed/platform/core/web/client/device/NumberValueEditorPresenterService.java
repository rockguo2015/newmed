package com.fudanmed.platform.core.web.client.device;

import com.fudanmed.platform.core.entityextension.proxy.RCAttributeSlotProxy;
import com.fudanmed.platform.core.web.shared.device.NumberValueData;
import com.fudanmed.platform.core.web.shared.device.UIAttributeSlot;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import com.uniquesoft.gwt.shared.DataBaseConstraintException;
import com.uniquesoft.gwt.shared.SessionTimeOutException;
import com.uniquesoft.gwt.shared.validation.ValidationException;

@RemoteServiceRelativePath("service/com.fudanmed.platform.core.web.client.device.NumberValueEditorPresenterService")
public interface NumberValueEditorPresenterService extends RemoteService {
  public abstract UIAttributeSlot updateValue(final RCAttributeSlotProxy slot, final NumberValueData theValue) throws SessionTimeOutException, ValidationException, DataBaseConstraintException;
  
  public abstract Double loadValue(final RCAttributeSlotProxy slot) throws SessionTimeOutException, ValidationException, DataBaseConstraintException;
  
  public abstract UIAttributeSlot updateNumberWithUnitValue(final RCAttributeSlotProxy slot, final NumberValueData theValue) throws SessionTimeOutException, ValidationException, DataBaseConstraintException;
  
  public abstract Double loadNumberWithUnitValue(final RCAttributeSlotProxy slot) throws SessionTimeOutException, ValidationException, DataBaseConstraintException;
}
