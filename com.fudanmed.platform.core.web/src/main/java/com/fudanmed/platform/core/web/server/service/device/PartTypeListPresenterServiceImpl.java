package com.fudanmed.platform.core.web.server.service.device;

import com.fudanmed.platform.core.device.RCDeviceType;
import com.fudanmed.platform.core.device.proxy.RCDeviceTypeProxy;
import com.fudanmed.platform.core.warehouse.RCProductSpecification;
import com.fudanmed.platform.core.warehouse.proxy.RCProductSpecificationProxy;
import com.fudanmed.platform.core.web.client.device.PartTypeListPresenterService;
import com.fudanmed.platform.core.web.server.service.warehouse.ProductSpecificationMapper;
import com.fudanmed.platform.core.web.shared.warehouse.UIProductSpecification;
import com.uniquesoft.gwt.server.service.common.BaseService;
import com.uniquesoft.gwt.shared.SessionTimeOutException;
import com.uniquesoft.gwt.shared.extensions.IterableExtensions2;
import com.uniquesoft.gwt.shared.validation.ValidationException;
import edu.fudan.mylang.pf.IObjectFactory;
import java.util.Collection;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("com.fudanmed.platform.core.web.client.device.PartTypeListPresenterService")
@Transactional
public class PartTypeListPresenterServiceImpl extends BaseService implements PartTypeListPresenterService {
  @Autowired
  private IObjectFactory entities;
  
  @Autowired
  private ProductSpecificationMapper mapper;
  
  public Collection<UIProductSpecification> loadProductSpecificationList(final RCDeviceTypeProxy context) throws SessionTimeOutException, ValidationException {
    RCDeviceType _resolved= null;
    if(context!=null) _resolved=(com.fudanmed.platform.core.device.RCDeviceType)com.uniquesoft.uidl.extensions.ModelObjects.resolve(context, entities);
    
    Collection<RCProductSpecification> _partTypes =  _resolved.getPartTypes();
    final Function1<RCProductSpecification,UIProductSpecification> _function = new Function1<RCProductSpecification,UIProductSpecification>() {
        public UIProductSpecification apply(final RCProductSpecification it) {
          UIProductSpecification _transform = PartTypeListPresenterServiceImpl.this.mapper.transform(it);
          return _transform;
        }
      };
    Iterable<UIProductSpecification> _map = IterableExtensions.<RCProductSpecification, UIProductSpecification>map(_partTypes, _function);
    Collection<UIProductSpecification> _unlazy = IterableExtensions2.<UIProductSpecification>unlazy(_map);
    return _unlazy;
  }
  
  public void delete(final RCDeviceTypeProxy context, final RCProductSpecificationProxy value) throws SessionTimeOutException, ValidationException {
    RCDeviceType _resolved= null;
    if(context!=null) _resolved=(com.fudanmed.platform.core.device.RCDeviceType)com.uniquesoft.uidl.extensions.ModelObjects.resolve(context, entities);
    
    RCProductSpecification _resolved_1= null;
    if(value!=null) _resolved_1=(com.fudanmed.platform.core.warehouse.RCProductSpecification)com.uniquesoft.uidl.extensions.ModelObjects.resolve(value, entities);
    
     _resolved.removeFromPartTypes( _resolved_1);
  }
}
