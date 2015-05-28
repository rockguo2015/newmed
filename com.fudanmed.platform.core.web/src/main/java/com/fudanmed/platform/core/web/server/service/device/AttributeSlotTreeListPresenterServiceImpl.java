package com.fudanmed.platform.core.web.server.service.device;

import com.fudanmed.platform.core.entityextension.RCAttributeSlot;
import com.fudanmed.platform.core.entityextension.RCCompositeValue;
import com.fudanmed.platform.core.entityextension.RCExtensiableEntity;
import com.fudanmed.platform.core.entityextension.RCValue;
import com.fudanmed.platform.core.entityextension.proxy.RCAttributeSlotProxy;
import com.fudanmed.platform.core.entityextension.proxy.RCExtensiableEntityProxy;
import com.fudanmed.platform.core.web.client.device.AttributeSlotTreeListPresenterService;
import com.fudanmed.platform.core.web.server.service.device.AttributeSlotMapper;
import com.fudanmed.platform.core.web.shared.device.UIAttributeSlot;
import com.uniquesoft.gwt.server.service.common.BaseService;
import com.uniquesoft.gwt.shared.SessionTimeOutException;
import com.uniquesoft.gwt.shared.validation.ValidationException;
import edu.fudan.mylang.pf.IObjectFactory;
import java.util.ArrayList;
import java.util.Collection;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("com.fudanmed.platform.core.web.client.device.AttributeSlotTreeListPresenterService")
@Transactional
public class AttributeSlotTreeListPresenterServiceImpl extends BaseService implements AttributeSlotTreeListPresenterService {
  @Autowired
  private IObjectFactory entities;
  
  @Autowired
  private AttributeSlotMapper mapper;
  
  public UIAttributeSlot getParentSlot(final RCAttributeSlotProxy slot) throws SessionTimeOutException, ValidationException {
    RCAttributeSlot _resolved= null;
    if(slot!=null) _resolved=(com.fudanmed.platform.core.entityextension.RCAttributeSlot)com.uniquesoft.uidl.extensions.ModelObjects.resolve(slot, entities);
    
    RCValue _value =  _resolved.getValue();
    RCAttributeSlot _slotOwner = _value.getSlotOwner();
    UIAttributeSlot _transform = this.mapper.transform(_slotOwner);
    return _transform;
  }
  
  public Collection<UIAttributeSlot> loadAttributeSlotList(final RCExtensiableEntityProxy context) throws SessionTimeOutException, ValidationException {
    ArrayList<UIAttributeSlot> _xblockexpression = null;
    {
      final ArrayList<UIAttributeSlot> result = CollectionLiterals.<UIAttributeSlot>newArrayList();
      RCExtensiableEntity _resolved= null;
      if(context!=null) _resolved=(com.fudanmed.platform.core.entityextension.RCExtensiableEntity)com.uniquesoft.uidl.extensions.ModelObjects.resolve(context, entities);
      
      RCCompositeValue _value =  _resolved.getValue();
      Collection<RCAttributeSlot> _slots = _value.getSlots();
      final Procedure1<RCAttributeSlot> _function = new Procedure1<RCAttributeSlot>() {
          public void apply(final RCAttributeSlot it) {
            final UIAttributeSlot uislot = AttributeSlotTreeListPresenterServiceImpl.this.mapper.transform(it);
            result.add(uislot);
            AttributeSlotTreeListPresenterServiceImpl.this.loadAttributeSlotListFromSlot(uislot, result);
          }
        };
      IterableExtensions.<RCAttributeSlot>forEach(_slots, _function);
      _xblockexpression = (result);
    }
    return _xblockexpression;
  }
  
  public void loadAttributeSlotListFromSlot(final UIAttributeSlot slot, final Collection<UIAttributeSlot> result) throws SessionTimeOutException, ValidationException {
    RCAttributeSlot _resolved= null;
    if(slot!=null) _resolved=(com.fudanmed.platform.core.entityextension.RCAttributeSlot)com.uniquesoft.uidl.extensions.ModelObjects.resolve(slot, entities);
    
    final RCValue slotValue =  _resolved.getValue();
    if ((slotValue instanceof RCCompositeValue)) {
      Collection<RCAttributeSlot> _slots = ((RCCompositeValue) slotValue).getSlots();
      final Procedure1<RCAttributeSlot> _function = new Procedure1<RCAttributeSlot>() {
          public void apply(final RCAttributeSlot it) {
            final UIAttributeSlot uislot = AttributeSlotTreeListPresenterServiceImpl.this.mapper.transform(it);
            uislot.setParentSlot(slot);
            result.add(uislot);
            AttributeSlotTreeListPresenterServiceImpl.this.loadAttributeSlotListFromSlot(uislot, result);
          }
        };
      IterableExtensions.<RCAttributeSlot>forEach(_slots, _function);
    }
  }
}
