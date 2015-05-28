package com.fudanmed.platform.core.web.server.service.device;

import com.fudanmed.platform.core.entityextension.RCAttribute;
import com.fudanmed.platform.core.entityextension.RCAttributeSlot;
import com.fudanmed.platform.core.entityextension.RCCompositeValue;
import com.fudanmed.platform.core.entityextension.RCExtensiableEntity;
import com.fudanmed.platform.core.entityextension.RCValue;
import com.fudanmed.platform.core.entityextension.proxy.RCAttributeSlotProxy;
import com.fudanmed.platform.core.entityextension.proxy.RCExtensiableEntityProxy;
import com.fudanmed.platform.core.web.client.device.CreateCompositeTypePresenterService;
import com.fudanmed.platform.core.web.server.service.device.AttributeSlotMapper;
import com.fudanmed.platform.core.web.server.service.device.CompositeAttributeValidator;
import com.fudanmed.platform.core.web.shared.device.UIAttributeSlot;
import com.fudanmed.platform.core.web.shared.device.UICompositeAttribute;
import com.uniquesoft.gwt.server.service.common.BaseService;
import com.uniquesoft.gwt.shared.SessionTimeOutException;
import com.uniquesoft.gwt.shared.validation.ValidationException;
import com.uniquesoft.uidl.validation.Validates;
import edu.fudan.mylang.pf.IObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("com.fudanmed.platform.core.web.client.device.CreateCompositeTypePresenterService")
@Transactional
public class CreateCompositeTypePresenterServiceImpl extends BaseService implements CreateCompositeTypePresenterService {
  @Autowired
  private IObjectFactory entities;
  
  @Autowired
  private AttributeSlotMapper slotMapper;
  
  @Autowired
  private CompositeAttributeValidator compositeAttributeValidator;
  
  public String loadSlotName(final RCAttributeSlotProxy slot) throws SessionTimeOutException, ValidationException {
    RCAttributeSlot _resolved= null;
    if(slot!=null) _resolved=(com.fudanmed.platform.core.entityextension.RCAttributeSlot)com.uniquesoft.uidl.extensions.ModelObjects.resolve(slot, entities);
    
    RCAttribute _attr =  _resolved.getAttr();
    String _name = _attr.getName();
    return _name;
  }
  
  public UIAttributeSlot createExtensiableEntityAttribute(final RCExtensiableEntityProxy ee, final UICompositeAttribute attribute) throws SessionTimeOutException, ValidationException {
    UIAttributeSlot _xblockexpression = null;
    {
      Validates.<UICompositeAttribute>validateWith(attribute, this.compositeAttributeValidator);
      RCExtensiableEntity _resolved= null;
      if(ee!=null) _resolved=(com.fudanmed.platform.core.entityextension.RCExtensiableEntity)com.uniquesoft.uidl.extensions.ModelObjects.resolve(ee, entities);
      
      RCCompositeValue _value =  _resolved.getValue();
      String _attributeName = attribute.getAttributeName();
      String _attributeName_1 = attribute.getAttributeName();
      RCAttributeSlot _createAttribute = _value.createAttribute(_attributeName, _attributeName_1);
      UIAttributeSlot _transform = this.slotMapper.transform(_createAttribute);
      _xblockexpression = (_transform);
    }
    return _xblockexpression;
  }
  
  public UIAttributeSlot createCompositeSlotAttribute(final RCAttributeSlotProxy slot, final UICompositeAttribute attribute) throws SessionTimeOutException, ValidationException {
    UIAttributeSlot _xblockexpression = null;
    {
      Validates.<UICompositeAttribute>validateWith(attribute, this.compositeAttributeValidator);
      RCAttributeSlot _resolved= null;
      if(slot!=null) _resolved=(com.fudanmed.platform.core.entityextension.RCAttributeSlot)com.uniquesoft.uidl.extensions.ModelObjects.resolve(slot, entities);
      
      RCValue _value =  _resolved.getValue();
      String _attributeName = attribute.getAttributeName();
      String _attributeName_1 = attribute.getAttributeName();
      RCAttributeSlot _createAttribute = ((RCCompositeValue) _value).createAttribute(_attributeName, _attributeName_1);
      UIAttributeSlot _transform = this.slotMapper.transform(_createAttribute);
      _xblockexpression = (_transform);
    }
    return _xblockexpression;
  }
}
