package com.fudanmed.platform.core.web.server.service.device;

import com.fudanmed.platform.core.entityextension.RCAttributeSlot;
import com.fudanmed.platform.core.entityextension.RCRangeValue;
import com.fudanmed.platform.core.entityextension.RCValue;
import com.fudanmed.platform.core.entityextension.proxy.RCAttributeSlotProxy;
import com.fudanmed.platform.core.web.client.device.RangeValueEditorPresenterService;
import com.fudanmed.platform.core.web.server.service.device.AttributeSlotMapper;
import com.fudanmed.platform.core.web.server.service.device.RangeValueDataValidator;
import com.fudanmed.platform.core.web.shared.device.RangeValueData;
import com.fudanmed.platform.core.web.shared.device.UIAttributeSlot;
import com.uniquesoft.gwt.server.service.common.BaseService;
import com.uniquesoft.gwt.shared.SessionTimeOutException;
import com.uniquesoft.gwt.shared.validation.ValidationException;
import com.uniquesoft.uidl.validation.Validates;
import edu.fudan.mylang.pf.IObjectFactory;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("com.fudanmed.platform.core.web.client.device.RangeValueEditorPresenterService")
@Transactional
public class RangeValueEditorPresenterServiceImpl extends BaseService implements RangeValueEditorPresenterService {
  @Autowired
  private IObjectFactory entities;
  
  @Autowired
  private RangeValueDataValidator rangeValueDataValidator;
  
  @Autowired
  private AttributeSlotMapper attributeSlotMapper;
  
  public UIAttributeSlot updateValue(final RCAttributeSlotProxy slot, final RangeValueData theValue) throws SessionTimeOutException, ValidationException {
    UIAttributeSlot _xblockexpression = null;
    {
      Validates.<RangeValueData>validateWith(theValue, this.rangeValueDataValidator);
      RCAttributeSlot _resolved= null;
      if(slot!=null) _resolved=(com.fudanmed.platform.core.entityextension.RCAttributeSlot)com.uniquesoft.uidl.extensions.ModelObjects.resolve(slot, entities);
      
      RCValue _value =  _resolved.getValue();
      Double _lower = theValue.getLower();
      Double _upper = theValue.getUpper();
      ((RCRangeValue) _value).setValue(_lower, _upper);
      RCAttributeSlot _resolved_1= null;
      if(slot!=null) _resolved_1=(com.fudanmed.platform.core.entityextension.RCAttributeSlot)com.uniquesoft.uidl.extensions.ModelObjects.resolve(slot, entities);
      
      UIAttributeSlot _transform = this.attributeSlotMapper.transform( _resolved_1);
      _xblockexpression = (_transform);
    }
    return _xblockexpression;
  }
  
  public RangeValueData loadValue(final RCAttributeSlotProxy slot) throws SessionTimeOutException, ValidationException {
    RangeValueData _xblockexpression = null;
    {
      RCAttributeSlot _resolved= null;
      if(slot!=null) _resolved=(com.fudanmed.platform.core.entityextension.RCAttributeSlot)com.uniquesoft.uidl.extensions.ModelObjects.resolve(slot, entities);
      
      RCValue _value =  _resolved.getValue();
      final RCRangeValue value = ((RCRangeValue) _value);
      RangeValueData _rangeValueData = new RangeValueData();
      final Procedure1<RangeValueData> _function = new Procedure1<RangeValueData>() {
          public void apply(final RangeValueData it) {
            Double _lowerBound = value.getLowerBound();
            it.setLower(_lowerBound);
            Double _upperBound = value.getUpperBound();
            it.setUpper(_upperBound);
          }
        };
      RangeValueData _doubleArrow = ObjectExtensions.<RangeValueData>operator_doubleArrow(_rangeValueData, _function);
      _xblockexpression = (_doubleArrow);
    }
    return _xblockexpression;
  }
}
