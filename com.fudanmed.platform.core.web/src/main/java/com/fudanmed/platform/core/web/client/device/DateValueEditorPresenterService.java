package com.fudanmed.platform.core.web.client.device;

import com.fudanmed.platform.core.entityextension.proxy.RCAttributeSlotProxy;
import com.fudanmed.platform.core.web.shared.device.DateValueData;
import com.fudanmed.platform.core.web.shared.device.UIAttributeSlot;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import com.uniquesoft.gwt.shared.DataBaseConstraintException;
import com.uniquesoft.gwt.shared.SessionTimeOutException;
import com.uniquesoft.gwt.shared.validation.ValidationException;
import java.util.Date;

@RemoteServiceRelativePath("service/com.fudanmed.platform.core.web.client.device.DateValueEditorPresenterService")
public interface DateValueEditorPresenterService extends RemoteService {
  public abstract UIAttributeSlot updateValue(final RCAttributeSlotProxy slot, final DateValueData theValue) throws SessionTimeOutException, ValidationException, DataBaseConstraintException;
  
  public abstract Date loadValue(final RCAttributeSlotProxy slot) throws SessionTimeOutException, ValidationException, DataBaseConstraintException;
}
