package com.fudanmed.platform.core.web.server.service.device;

import com.fudanmed.platform.core.entityextension.RCAttributeSlot;
import com.fudanmed.platform.core.entityextension.RCNumberValue;
import com.fudanmed.platform.core.entityextension.RCNumberWithUnitValue;
import com.fudanmed.platform.core.entityextension.RCValue;
import com.fudanmed.platform.core.entityextension.proxy.RCAttributeSlotProxy;
import com.fudanmed.platform.core.web.client.device.NumberValueEditorPresenterService;
import com.fudanmed.platform.core.web.server.service.device.AttributeSlotMapper;
import com.fudanmed.platform.core.web.server.service.device.NumberValueDataValidator;
import com.fudanmed.platform.core.web.shared.device.NumberValueData;
import com.fudanmed.platform.core.web.shared.device.UIAttributeSlot;
import com.uniquesoft.gwt.server.service.common.BaseService;
import com.uniquesoft.gwt.shared.SessionTimeOutException;
import com.uniquesoft.gwt.shared.validation.ValidationException;
import com.uniquesoft.uidl.validation.Validates;
import edu.fudan.mylang.pf.IObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("com.fudanmed.platform.core.web.client.device.NumberValueEditorPresenterService")
@Transactional
public class NumberValueEditorPresenterServiceImpl extends BaseService implements NumberValueEditorPresenterService {
  @Autowired
  private IObjectFactory entities;
  
  @Autowired
  private NumberValueDataValidator numberValueDataValidator;
  
  @Autowired
  private AttributeSlotMapper attributeSlotMapper;
  
  public UIAttributeSlot updateValue(final RCAttributeSlotProxy slot, final NumberValueData theValue) throws SessionTimeOutException, ValidationException {
    UIAttributeSlot _xblockexpression = null;
    {
      Validates.<NumberValueData>validateWith(theValue, this.numberValueDataValidator);
      RCAttributeSlot _resolved= null;
      if(slot!=null) _resolved=(com.fudanmed.platform.core.entityextension.RCAttributeSlot)com.uniquesoft.uidl.extensions.ModelObjects.resolve(slot, entities);
      
      RCValue _value =  _resolved.getValue();
      Double _theValue = theValue.getTheValue();
      ((RCNumberValue) _value).setValue(_theValue);
      RCAttributeSlot _resolved_1= null;
      if(slot!=null) _resolved_1=(com.fudanmed.platform.core.entityextension.RCAttributeSlot)com.uniquesoft.uidl.extensions.ModelObjects.resolve(slot, entities);
      
      UIAttributeSlot _transform = this.attributeSlotMapper.transform( _resolved_1);
      _xblockexpression = (_transform);
    }
    return _xblockexpression;
  }
  
  public Double loadValue(final RCAttributeSlotProxy slot) throws SessionTimeOutException, ValidationException {
    RCAttributeSlot _resolved= null;
    if(slot!=null) _resolved=(com.fudanmed.platform.core.entityextension.RCAttributeSlot)com.uniquesoft.uidl.extensions.ModelObjects.resolve(slot, entities);
    
    RCValue _value =  _resolved.getValue();
    Double _value_1 = ((RCNumberValue) _value).getValue();
    return _value_1;
  }
  
  public UIAttributeSlot updateNumberWithUnitValue(final RCAttributeSlotProxy slot, final NumberValueData theValue) throws SessionTimeOutException, ValidationException {
    UIAttributeSlot _xblockexpression = null;
    {
      Validates.<NumberValueData>validateWith(theValue, this.numberValueDataValidator);
      RCAttributeSlot _resolved= null;
      if(slot!=null) _resolved=(com.fudanmed.platform.core.entityextension.RCAttributeSlot)com.uniquesoft.uidl.extensions.ModelObjects.resolve(slot, entities);
      
      RCValue _value =  _resolved.getValue();
      Double _theValue = theValue.getTheValue();
      ((RCNumberWithUnitValue) _value).setValue(_theValue);
      RCAttributeSlot _resolved_1= null;
      if(slot!=null) _resolved_1=(com.fudanmed.platform.core.entityextension.RCAttributeSlot)com.uniquesoft.uidl.extensions.ModelObjects.resolve(slot, entities);
      
      UIAttributeSlot _transform = this.attributeSlotMapper.transform( _resolved_1);
      _xblockexpression = (_transform);
    }
    return _xblockexpression;
  }
  
  public Double loadNumberWithUnitValue(final RCAttributeSlotProxy slot) throws SessionTimeOutException, ValidationException {
    RCAttributeSlot _resolved= null;
    if(slot!=null) _resolved=(com.fudanmed.platform.core.entityextension.RCAttributeSlot)com.uniquesoft.uidl.extensions.ModelObjects.resolve(slot, entities);
    
    RCValue _value =  _resolved.getValue();
    Double _value_1 = ((RCNumberWithUnitValue) _value).getValue();
    return _value_1;
  }
}
