package com.fudanmed.platform.core.web.client.device;

import com.fudanmed.platform.core.entityextension.proxy.RCAttributeSlotProxy;
import com.fudanmed.platform.core.entityextension.proxy.RCExtensiableEntityProxy;
import com.fudanmed.platform.core.web.shared.device.UIAttributeSlot;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import com.uniquesoft.gwt.shared.DataBaseConstraintException;
import com.uniquesoft.gwt.shared.SessionTimeOutException;
import com.uniquesoft.gwt.shared.validation.ValidationException;
import java.util.Collection;

@RemoteServiceRelativePath("service/com.fudanmed.platform.core.web.client.device.AttributeSlotTreeListPresenterService")
public interface AttributeSlotTreeListPresenterService extends RemoteService {
  public abstract UIAttributeSlot getParentSlot(final RCAttributeSlotProxy slot) throws SessionTimeOutException, ValidationException, DataBaseConstraintException;
  
  public abstract Collection<UIAttributeSlot> loadAttributeSlotList(final RCExtensiableEntityProxy context) throws SessionTimeOutException, ValidationException, DataBaseConstraintException;
  
  public abstract void loadAttributeSlotListFromSlot(final UIAttributeSlot slot, final Collection<UIAttributeSlot> result) throws SessionTimeOutException, ValidationException, DataBaseConstraintException;
}
