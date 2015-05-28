package com.fudanmed.platform.core.web.server.service.device;

import com.fudanmed.platform.core.entityextension.RCAttribute;
import com.fudanmed.platform.core.entityextension.RCAttributeSlot;
import com.fudanmed.platform.core.entityextension.RCCompositeValue;
import com.fudanmed.platform.core.entityextension.proxy.RCAttributeSlotProxy;
import com.fudanmed.platform.core.web.client.device.AttributeSlotEditPresenterService;
import com.uniquesoft.gwt.server.service.common.BaseService;
import com.uniquesoft.gwt.shared.SessionTimeOutException;
import com.uniquesoft.gwt.shared.validation.ValidationException;
import edu.fudan.mylang.pf.IObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("com.fudanmed.platform.core.web.client.device.AttributeSlotEditPresenterService")
@Transactional
public class AttributeSlotEditPresenterServiceImpl extends BaseService implements AttributeSlotEditPresenterService {
  @Autowired
  private IObjectFactory entities;
  
  public void deleteSlotAttribute(final RCAttributeSlotProxy slot) throws SessionTimeOutException, ValidationException {
    RCAttributeSlot _resolved= null;
    if(slot!=null) _resolved=(com.fudanmed.platform.core.entityextension.RCAttributeSlot)com.uniquesoft.uidl.extensions.ModelObjects.resolve(slot, entities);
    
    final RCAttributeSlot s =  _resolved;
    RCCompositeValue _attrValue = s.getAttrValue();
    RCAttribute _attr = s.getAttr();
    _attrValue.removeAttribute(_attr);
  }
}
