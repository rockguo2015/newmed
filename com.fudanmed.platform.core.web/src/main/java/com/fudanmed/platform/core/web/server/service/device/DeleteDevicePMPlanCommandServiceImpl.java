package com.fudanmed.platform.core.web.server.service.device;

import com.fudanmed.platform.core.device.pm.RCDevicePMPlan;
import com.fudanmed.platform.core.device.pm.RCDevicePMSpecification;
import com.fudanmed.platform.core.device.pm.proxy.RCDevicePMPlanProxy;
import com.fudanmed.platform.core.web.client.device.DeleteDevicePMPlanCommandService;
import com.uniquesoft.gwt.server.service.common.BaseService;
import com.uniquesoft.gwt.shared.SessionTimeOutException;
import com.uniquesoft.gwt.shared.validation.ValidationException;
import edu.fudan.mylang.pf.IObjectFactory;
import java.util.Collection;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("com.fudanmed.platform.core.web.client.device.DeleteDevicePMPlanCommandService")
@Transactional
public class DeleteDevicePMPlanCommandServiceImpl extends BaseService implements DeleteDevicePMPlanCommandService {
  @Autowired
  private IObjectFactory entities;
  
  public void doDelete(final Collection<RCDevicePMPlanProxy> plans) throws SessionTimeOutException, ValidationException {
    boolean _isEmpty = plans.isEmpty();
    boolean _not = (!_isEmpty);
    if (_not) {
      RCDevicePMPlanProxy _head = IterableExtensions.<RCDevicePMPlanProxy>head(plans);
      RCDevicePMPlan _resolved= null;
      if(_head!=null) _resolved=(com.fudanmed.platform.core.device.pm.RCDevicePMPlan)com.uniquesoft.uidl.extensions.ModelObjects.resolve(_head, entities);
      
      final RCDevicePMSpecification spec =  _resolved.getSpec();
      final Procedure1<RCDevicePMPlanProxy> _function = new Procedure1<RCDevicePMPlanProxy>() {
          public void apply(final RCDevicePMPlanProxy it) {
            RCDevicePMPlan _resolved= null;
            if(it!=null) _resolved=(com.fudanmed.platform.core.device.pm.RCDevicePMPlan)com.uniquesoft.uidl.extensions.ModelObjects.resolve(it, entities);
            
            spec.removePlan( _resolved);
          }
        };
      IterableExtensions.<RCDevicePMPlanProxy>forEach(plans, _function);
    }
  }
}
