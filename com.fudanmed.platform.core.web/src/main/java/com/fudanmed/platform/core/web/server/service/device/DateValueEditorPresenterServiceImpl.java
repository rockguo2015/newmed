package com.fudanmed.platform.core.web.server.service.device;

import com.fudanmed.platform.core.entityextension.RCAttributeSlot;
import com.fudanmed.platform.core.entityextension.RCDateValue;
import com.fudanmed.platform.core.entityextension.RCValue;
import com.fudanmed.platform.core.entityextension.proxy.RCAttributeSlotProxy;
import com.fudanmed.platform.core.web.client.device.DateValueEditorPresenterService;
import com.fudanmed.platform.core.web.server.service.device.AttributeSlotMapper;
import com.fudanmed.platform.core.web.server.service.device.DateValueDataValidator;
import com.fudanmed.platform.core.web.shared.device.DateValueData;
import com.fudanmed.platform.core.web.shared.device.UIAttributeSlot;
import com.uniquesoft.gwt.server.service.common.BaseService;
import com.uniquesoft.gwt.shared.SessionTimeOutException;
import com.uniquesoft.gwt.shared.validation.ValidationException;
import com.uniquesoft.uidl.validation.Validates;
import edu.fudan.mylang.pf.IObjectFactory;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("com.fudanmed.platform.core.web.client.device.DateValueEditorPresenterService")
@Transactional
public class DateValueEditorPresenterServiceImpl extends BaseService implements DateValueEditorPresenterService {
  @Autowired
  private IObjectFactory entities;
  
  @Autowired
  private DateValueDataValidator dateValueDataValidator;
  
  @Autowired
  private AttributeSlotMapper attributeSlotMapper;
  
  public UIAttributeSlot updateValue(final RCAttributeSlotProxy slot, final DateValueData theValue) throws SessionTimeOutException, ValidationException {
    UIAttributeSlot _xblockexpression = null;
    {
      Validates.<DateValueData>validateWith(theValue, this.dateValueDataValidator);
      RCAttributeSlot _resolved= null;
      if(slot!=null) _resolved=(com.fudanmed.platform.core.entityextension.RCAttributeSlot)com.uniquesoft.uidl.extensions.ModelObjects.resolve(slot, entities);
      
      RCValue _value =  _resolved.getValue();
      Date _theValue = theValue.getTheValue();
      ((RCDateValue) _value).setValue(_theValue);
      RCAttributeSlot _resolved_1= null;
      if(slot!=null) _resolved_1=(com.fudanmed.platform.core.entityextension.RCAttributeSlot)com.uniquesoft.uidl.extensions.ModelObjects.resolve(slot, entities);
      
      UIAttributeSlot _transform = this.attributeSlotMapper.transform( _resolved_1);
      _xblockexpression = (_transform);
    }
    return _xblockexpression;
  }
  
  public Date loadValue(final RCAttributeSlotProxy slot) throws SessionTimeOutException, ValidationException {
    RCAttributeSlot _resolved= null;
    if(slot!=null) _resolved=(com.fudanmed.platform.core.entityextension.RCAttributeSlot)com.uniquesoft.uidl.extensions.ModelObjects.resolve(slot, entities);
    
    RCValue _value =  _resolved.getValue();
    Date _date = ((RCDateValue) _value).getDate();
    return _date;
  }
}
