package com.fudanmed.platform.core.web.server.service.device;

import com.fudanmed.platform.core.device.RCDeviceType;
import com.fudanmed.platform.core.device.proxy.RCDeviceTypeProxy;
import com.fudanmed.platform.core.warehouse.RCProductSpecification;
import com.fudanmed.platform.core.warehouse.proxy.RCProductSpecificationProxy;
import com.fudanmed.platform.core.web.client.device.CreateOrUpdatePartTypeSelectDataPresenterService;
import com.fudanmed.platform.core.web.server.service.device.PartTypeSelectDataValidator;
import com.fudanmed.platform.core.web.shared.device.UIPartTypeSelectData;
import com.fudanmed.platform.core.web.shared.warehouse.UIProductSpecification;
import com.uniquesoft.gwt.server.service.common.BaseService;
import com.uniquesoft.gwt.shared.SessionTimeOutException;
import com.uniquesoft.gwt.shared.validation.ValidationException;
import com.uniquesoft.uidl.validation.Validates;
import edu.fudan.mylang.pf.IObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("com.fudanmed.platform.core.web.client.device.CreateOrUpdatePartTypeSelectDataPresenterService")
@Transactional
public class CreateOrUpdatePartTypeSelectDataPresenterServiceImpl extends BaseService implements CreateOrUpdatePartTypeSelectDataPresenterService {
  @Autowired
  private IObjectFactory entities;
  
  @Autowired
  private PartTypeSelectDataValidator validator;
  
  public void createValue(final RCDeviceTypeProxy parent, final UIPartTypeSelectData uivalue) throws SessionTimeOutException, ValidationException {
    Validates.<UIPartTypeSelectData>validateWith(uivalue, this.validator);
    RCDeviceType _resolved= null;
    if(parent!=null) _resolved=(com.fudanmed.platform.core.device.RCDeviceType)com.uniquesoft.uidl.extensions.ModelObjects.resolve(parent, entities);
    
    UIProductSpecification _productSpec = uivalue.getProductSpec();
    RCProductSpecificationProxy _proxy = _productSpec.toProxy();
    RCProductSpecification _resolved_1= null;
    if(_proxy!=null) _resolved_1=(com.fudanmed.platform.core.warehouse.RCProductSpecification)com.uniquesoft.uidl.extensions.ModelObjects.resolve(_proxy, entities);
    
     _resolved.addtoPartTypes( _resolved_1);
  }
}
