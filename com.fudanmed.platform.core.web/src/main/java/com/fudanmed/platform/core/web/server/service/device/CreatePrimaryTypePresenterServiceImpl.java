package com.fudanmed.platform.core.web.server.service.device;

import com.fudanmed.platform.core.entityextension.RCAttribute;
import com.fudanmed.platform.core.entityextension.RCAttributeSlot;
import com.fudanmed.platform.core.entityextension.RCCompositeValue;
import com.fudanmed.platform.core.entityextension.RCExtensiableEntity;
import com.fudanmed.platform.core.entityextension.RCPrimaryType;
import com.fudanmed.platform.core.entityextension.RCValue;
import com.fudanmed.platform.core.entityextension.proxy.RCAttributeSlotProxy;
import com.fudanmed.platform.core.entityextension.proxy.RCExtensiableEntityProxy;
import com.fudanmed.platform.core.entityextension.proxy.RCPrimaryTypeProxy;
import com.fudanmed.platform.core.web.client.device.CreatePrimaryTypePresenterService;
import com.fudanmed.platform.core.web.server.service.device.AttributeSlotMapper;
import com.fudanmed.platform.core.web.server.service.device.PrimaryAttributeValidator;
import com.fudanmed.platform.core.web.shared.device.UIAttributeSlot;
import com.fudanmed.platform.core.web.shared.device.UIPrimaryAttribute;
import com.uniquesoft.gwt.server.service.common.BaseService;
import com.uniquesoft.gwt.shared.SessionTimeOutException;
import com.uniquesoft.gwt.shared.validation.ValidationException;
import com.uniquesoft.uidl.validation.Validates;
import edu.fudan.mylang.pf.IObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("com.fudanmed.platform.core.web.client.device.CreatePrimaryTypePresenterService")
@Transactional
public class CreatePrimaryTypePresenterServiceImpl extends BaseService implements CreatePrimaryTypePresenterService {
  @Autowired
  private IObjectFactory entities;
  
  @Autowired
  private PrimaryAttributeValidator primaryAttributeValidator;
  
  @Autowired
  private AttributeSlotMapper slotMapper;
  
  public String loadSlotName(final RCAttributeSlotProxy slot) throws SessionTimeOutException, ValidationException {
    RCAttributeSlot _resolved= null;
    if(slot!=null) _resolved=(com.fudanmed.platform.core.entityextension.RCAttributeSlot)com.uniquesoft.uidl.extensions.ModelObjects.resolve(slot, entities);
    
    RCAttribute _attr =  _resolved.getAttr();
    String _name = _attr.getName();
    return _name;
  }
  
  public UIAttributeSlot createExtensiableEntityAttribute(final RCExtensiableEntityProxy ee, final UIPrimaryAttribute attribute) throws SessionTimeOutException, ValidationException {
    UIAttributeSlot _xblockexpression = null;
    {
      Validates.<UIPrimaryAttribute>validateWith(attribute, this.primaryAttributeValidator);
      RCExtensiableEntity _resolved= null;
      if(ee!=null) _resolved=(com.fudanmed.platform.core.entityextension.RCExtensiableEntity)com.uniquesoft.uidl.extensions.ModelObjects.resolve(ee, entities);
      
      RCCompositeValue _value =  _resolved.getValue();
      String _attributeName = attribute.getAttributeName();
      RCPrimaryTypeProxy _type = attribute.getType();
      RCPrimaryType _resolved_1= null;
      if(_type!=null) _resolved_1=(com.fudanmed.platform.core.entityextension.RCPrimaryType)com.uniquesoft.uidl.extensions.ModelObjects.resolve(_type, entities);
      
      RCAttributeSlot _createAttribute = _value.createAttribute(_attributeName,  _resolved_1);
      UIAttributeSlot _transform = this.slotMapper.transform(_createAttribute);
      _xblockexpression = (_transform);
    }
    return _xblockexpression;
  }
  
  public UIAttributeSlot createCompositeSlotAttribute(final RCAttributeSlotProxy slot, final UIPrimaryAttribute attribute) throws SessionTimeOutException, ValidationException {
    UIAttributeSlot _xblockexpression = null;
    {
      Validates.<UIPrimaryAttribute>validateWith(attribute, this.primaryAttributeValidator);
      RCAttributeSlot _resolved= null;
      if(slot!=null) _resolved=(com.fudanmed.platform.core.entityextension.RCAttributeSlot)com.uniquesoft.uidl.extensions.ModelObjects.resolve(slot, entities);
      
      RCValue _value =  _resolved.getValue();
      String _attributeName = attribute.getAttributeName();
      RCPrimaryTypeProxy _type = attribute.getType();
      RCPrimaryType _resolved_1= null;
      if(_type!=null) _resolved_1=(com.fudanmed.platform.core.entityextension.RCPrimaryType)com.uniquesoft.uidl.extensions.ModelObjects.resolve(_type, entities);
      
      RCAttributeSlot _createAttribute = ((RCCompositeValue) _value).createAttribute(_attributeName,  _resolved_1);
      UIAttributeSlot _transform = this.slotMapper.transform(_createAttribute);
      _xblockexpression = (_transform);
    }
    return _xblockexpression;
  }
}
