package com.fudanmed.platform.core.web.server.service.device;

import com.fudanmed.platform.core.device.RCDeviceType;
import com.fudanmed.platform.core.device.RCDeviceTypeCategory;
import com.fudanmed.platform.core.device.RCDeviceTypeCriteria;
import com.fudanmed.platform.core.device.proxy.RCDeviceTypeProxy;
import com.fudanmed.platform.core.entityextension.RCAttribute;
import com.fudanmed.platform.core.entityextension.RCAttributeSlot;
import com.fudanmed.platform.core.entityextension.RCCompositeValue;
import com.fudanmed.platform.core.entityextension.RCExtensiableEntity;
import com.fudanmed.platform.core.entityextension.proxy.RCAttributeSlotProxy;
import com.fudanmed.platform.core.entityextension.proxy.RCExtensiableEntityProxy;
import com.fudanmed.platform.core.web.client.device.DeviceTypeManagementPresenterService;
import com.fudanmed.platform.core.web.server.service.device.DeviceTypeCriteriaMapper;
import com.fudanmed.platform.core.web.server.service.device.DeviceTypeMapper;
import com.fudanmed.platform.core.web.shared.device.UIDeviceType;
import com.fudanmed.platform.core.web.shared.device.UIDeviceTypeCriteria;
import com.google.common.base.Function;
import com.uniquesoft.gwt.server.common.pager.PagedQueries;
import com.uniquesoft.gwt.server.service.common.BaseService;
import com.uniquesoft.gwt.shared.SessionTimeOutException;
import com.uniquesoft.gwt.shared.common.pager.IPagedResult;
import com.uniquesoft.gwt.shared.validation.ValidationException;
import edu.fudan.mylang.pf.IObjectFactory;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("com.fudanmed.platform.core.web.client.device.DeviceTypeManagementPresenterService")
@Transactional
public class DeviceTypeManagementPresenterServiceImpl extends BaseService implements DeviceTypeManagementPresenterService {
  @Autowired
  private IObjectFactory entities;
  
  @Autowired
  private DeviceTypeCriteriaMapper criteriaMapper;
  
  @Autowired
  private DeviceTypeMapper mapper;
  
  public IPagedResult<UIDeviceType> filter(final UIDeviceTypeCriteria uicriteria) throws SessionTimeOutException, ValidationException {
    IPagedResult<UIDeviceType> _xblockexpression = null;
    {
      RCDeviceTypeCriteria c = PagedQueries.createPagedCriteria(uicriteria, RCDeviceTypeCriteria.class, this.criteriaMapper, this.entities);
      final Function1<RCDeviceType,UIDeviceType> _function = new Function1<RCDeviceType,UIDeviceType>() {
          public UIDeviceType apply(final RCDeviceType it) {
            UIDeviceType _apply = DeviceTypeManagementPresenterServiceImpl.this.mapper.apply(it);
            return _apply;
          }
        };
      IPagedResult<UIDeviceType> _listAndTransform = PagedQueries.<UIDeviceType, RCDeviceType>listAndTransform(c, new Function<RCDeviceType,UIDeviceType>() {
          public UIDeviceType apply(RCDeviceType input) {
            return _function.apply(input);
          }
      });
      _xblockexpression = (_listAndTransform);
    }
    return _xblockexpression;
  }
  
  public RCExtensiableEntityProxy loadEntityExtension(final RCDeviceTypeProxy value) throws SessionTimeOutException, ValidationException {
    RCDeviceType _resolved= null;
    if(value!=null) _resolved=(com.fudanmed.platform.core.device.RCDeviceType)com.uniquesoft.uidl.extensions.ModelObjects.resolve(value, entities);
    
    RCExtensiableEntity _defaultValue =  _resolved.getDefaultValue();
    RCExtensiableEntityProxy _proxy = _defaultValue.toProxy();
    return _proxy;
  }
  
  public void deleteSlotAttribute(final RCAttributeSlotProxy slot) throws SessionTimeOutException, ValidationException {
    RCAttributeSlot _resolved= null;
    if(slot!=null) _resolved=(com.fudanmed.platform.core.entityextension.RCAttributeSlot)com.uniquesoft.uidl.extensions.ModelObjects.resolve(slot, entities);
    
    final RCAttributeSlot s =  _resolved;
    RCCompositeValue _attrValue = s.getAttrValue();
    RCAttribute _attr = s.getAttr();
    _attrValue.removeAttribute(_attr);
  }
  
  public void deleteChild(final RCDeviceTypeProxy child) throws SessionTimeOutException, ValidationException {
    RCDeviceType _resolved= null;
    if(child!=null) _resolved=(com.fudanmed.platform.core.device.RCDeviceType)com.uniquesoft.uidl.extensions.ModelObjects.resolve(child, entities);
    
    RCDeviceTypeCategory _category =  _resolved.getCategory();
    RCDeviceType _resolved_1= null;
    if(child!=null) _resolved_1=(com.fudanmed.platform.core.device.RCDeviceType)com.uniquesoft.uidl.extensions.ModelObjects.resolve(child, entities);
    
    _category.deleteDeviceType( _resolved_1);
  }
}
