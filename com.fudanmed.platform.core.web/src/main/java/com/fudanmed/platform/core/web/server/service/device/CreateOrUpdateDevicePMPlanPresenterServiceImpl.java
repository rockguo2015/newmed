package com.fudanmed.platform.core.web.server.service.device;

import com.fudanmed.platform.core.device.pm.RCDevicePMPlan;
import com.fudanmed.platform.core.device.pm.RCDevicePMSpecification;
import com.fudanmed.platform.core.device.pm.proxy.RCDevicePMPlanProxy;
import com.fudanmed.platform.core.device.pm.proxy.RCDevicePMSpecificationProxy;
import com.fudanmed.platform.core.web.client.device.CreateOrUpdateDevicePMPlanPresenterService;
import com.fudanmed.platform.core.web.server.service.device.DevicePMPlanMapper;
import com.fudanmed.platform.core.web.shared.device.UIDevicePMPlan;
import com.uniquesoft.gwt.server.service.common.BaseService;
import com.uniquesoft.gwt.shared.SessionTimeOutException;
import com.uniquesoft.gwt.shared.validation.ValidationException;
import edu.fudan.mylang.pf.IObjectFactory;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("com.fudanmed.platform.core.web.client.device.CreateOrUpdateDevicePMPlanPresenterService")
@Transactional
public class CreateOrUpdateDevicePMPlanPresenterServiceImpl extends BaseService implements CreateOrUpdateDevicePMPlanPresenterService {
  @Autowired
  private IObjectFactory entities;
  
  @Autowired
  private DevicePMPlanMapper mapper;
  
  public UIDevicePMPlan loadValue(final RCDevicePMPlanProxy pvalue) throws SessionTimeOutException, ValidationException {
    RCDevicePMPlan _resolved= null;
    if(pvalue!=null) _resolved=(com.fudanmed.platform.core.device.pm.RCDevicePMPlan)com.uniquesoft.uidl.extensions.ModelObjects.resolve(pvalue, entities);
    
    UIDevicePMPlan _transform = this.mapper.transform( _resolved);
    return _transform;
  }
  
  public void updateValue(final UIDevicePMPlan uivalue) throws SessionTimeOutException, ValidationException {
    RCDevicePMPlan _resolved= null;
    if(uivalue!=null) _resolved=(com.fudanmed.platform.core.device.pm.RCDevicePMPlan)com.uniquesoft.uidl.extensions.ModelObjects.resolve(uivalue, entities);
    
    this.mapper.transform(uivalue,  _resolved);
  }
  
  public void createValue(final UIDevicePMPlan uivalue, final RCDevicePMSpecificationProxy parent) throws SessionTimeOutException, ValidationException {
    RCDevicePMSpecification _resolved= null;
    if(parent!=null) _resolved=(com.fudanmed.platform.core.device.pm.RCDevicePMSpecification)com.uniquesoft.uidl.extensions.ModelObjects.resolve(parent, entities);
    
    final Procedure1<RCDevicePMPlan> _function = new Procedure1<RCDevicePMPlan>() {
        public void apply(final RCDevicePMPlan it) {
          CreateOrUpdateDevicePMPlanPresenterServiceImpl.this.mapper.transform(uivalue, it);
        }
      };
     _resolved.createPlan(_function);
  }
}
