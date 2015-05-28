package com.fudanmed.platform.core.web.server.service.device;

import com.fudanmed.platform.core.entityextension.RCAttributeSlot;
import com.fudanmed.platform.core.entityextension.RCDateType;
import com.fudanmed.platform.core.entityextension.RCNumberType;
import com.fudanmed.platform.core.entityextension.RCNumberWithUnitType;
import com.fudanmed.platform.core.entityextension.RCPrimaryType;
import com.fudanmed.platform.core.entityextension.RCRangeType;
import com.fudanmed.platform.core.entityextension.RCStringType;
import com.fudanmed.platform.core.entityextension.RCType;
import com.fudanmed.platform.core.web.shared.device.UIAttributeSlot;
import com.fudanmed.platform.core.web.shared.device.UIPrimaryTypeEnum;
import com.uniquesoft.uidl.transform.AbstractEntityMapper;
import com.uniquesoft.uidl.transform.IConvertService;
import edu.fudan.mylang.pf.IObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("com.fudanmed.platform.core.web.server.service.device.AttributeSlotMapper")
public class AttributeSlotMapper extends AbstractEntityMapper<UIAttributeSlot,RCAttributeSlot> {
  @Autowired
  private IConvertService convertService;
  
  @Autowired
  private IObjectFactory entities;
  
  public RCAttributeSlot loadEntityById(final Long id) {
    return entities.get(RCAttributeSlot.class,id);
  }
  
  public RCAttributeSlot create() {
    return entities.create(RCAttributeSlot.class);
  }
  
  public void copyToEntity(final UIAttributeSlot from, final RCAttributeSlot to) {
    to.setVersion(from.getVersion());
    
  }
  
  public UIAttributeSlot copyFromEntity(final UIAttributeSlot result, final RCAttributeSlot entity) {
    if(entity==null) return null;
    result.setId(entity.getId());
    result.setVersion(entity.getVersion());
    result.setProxy(entity.toProxy());
    result.setClazzName(entity.getClass().getName());
    if(entity. getAttr()  != null )
    	result.setSlotName(convertService.toValue(java.lang.String.class,entity.getAttr().getName()));
    	result.setType(convertService.toValue(com.fudanmed.platform.core.entityextension.proxy.RCTypeProxy.class,entity.getValueType()));
    	result.setSlotValue(convertService.toValue(com.fudanmed.platform.core.entityextension.proxy.RCValueProxy.class,entity.getValue()));
    buildFromCust(result,entity);
    return result;
    
  }
  
  public UIAttributeSlot buildFrom(final RCAttributeSlot entity) {
    if(entity==null) return null;
    com.fudanmed.platform.core.web.shared.device.UIAttributeSlot result = new com.fudanmed.platform.core.web.shared.device.UIAttributeSlot();
    copyFromEntity(result,entity);	
    return result;
    
  }
  
  protected void buildFromCust(final UIAttributeSlot _gwt, final RCAttributeSlot _entity) {
    RCType _valueType = _entity.getValueType();
    _gwt.setIsPrimary(Boolean.valueOf((_valueType instanceof RCPrimaryType)));
    RCType _valueType_1 = _entity.getValueType();
    final RCType _switchValue = _valueType_1;
    boolean _matched = false;
    if (!_matched) {
      if (_switchValue instanceof RCNumberType) {
        final RCNumberType _rCNumberType = (RCNumberType)_switchValue;
        _matched=true;
        _gwt.setTypeEnum(UIPrimaryTypeEnum.number);
      }
    }
    if (!_matched) {
      if (_switchValue instanceof RCNumberWithUnitType) {
        final RCNumberWithUnitType _rCNumberWithUnitType = (RCNumberWithUnitType)_switchValue;
        _matched=true;
        _gwt.setTypeEnum(UIPrimaryTypeEnum.numberWithUnit);
      }
    }
    if (!_matched) {
      if (_switchValue instanceof RCRangeType) {
        final RCRangeType _rCRangeType = (RCRangeType)_switchValue;
        _matched=true;
        _gwt.setTypeEnum(UIPrimaryTypeEnum.range);
      }
    }
    if (!_matched) {
      if (_switchValue instanceof RCStringType) {
        final RCStringType _rCStringType = (RCStringType)_switchValue;
        _matched=true;
        _gwt.setTypeEnum(UIPrimaryTypeEnum.string);
      }
    }
    if (!_matched) {
      if (_switchValue instanceof RCDateType) {
        final RCDateType _rCDateType = (RCDateType)_switchValue;
        _matched=true;
        _gwt.setTypeEnum(UIPrimaryTypeEnum.date);
      }
    }
  }
  
  public Class<?> getUIClass() {
    return UIAttributeSlot.class;
  }
  
  public Class<?> getEntityClass() {
    return RCAttributeSlot.class;
  }
}
