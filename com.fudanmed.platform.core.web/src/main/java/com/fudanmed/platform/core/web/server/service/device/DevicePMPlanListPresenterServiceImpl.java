package com.fudanmed.platform.core.web.server.service.device;

import com.fudanmed.platform.core.device.RCDevice;
import com.fudanmed.platform.core.device.pm.RCDevicePMPlan;
import com.fudanmed.platform.core.device.pm.RCDevicePMPlanDAO;
import com.fudanmed.platform.core.device.pm.RCDevicePMSpecification;
import com.fudanmed.platform.core.device.pm.proxy.RCDevicePMSpecificationProxy;
import com.fudanmed.platform.core.device.proxy.RCDeviceProxy;
import com.fudanmed.platform.core.web.client.device.DevicePMPlanListPresenterService;
import com.fudanmed.platform.core.web.server.service.device.DevicePMPlanMapper;
import com.fudanmed.platform.core.web.shared.device.UIDevicePMPlan;
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

@Service("com.fudanmed.platform.core.web.client.device.DevicePMPlanListPresenterService")
@Transactional
public class DevicePMPlanListPresenterServiceImpl extends BaseService implements DevicePMPlanListPresenterService {
  @Autowired
  private IObjectFactory entities;
  
  @Autowired
  private DevicePMPlanMapper mapper;
  
  @Autowired
  private RCDevicePMPlanDAO dao;
  
  public Collection<UIDevicePMPlan> loadDevicePMPlanList(final RCDevicePMSpecificationProxy context) throws SessionTimeOutException, ValidationException {
    RCDevicePMSpecification _resolved= null;
    if(context!=null) _resolved=(com.fudanmed.platform.core.device.pm.RCDevicePMSpecification)com.uniquesoft.uidl.extensions.ModelObjects.resolve(context, entities);
    
    Collection<RCDevicePMPlan> _plans =  _resolved.getPlans();
    final Function1<RCDevicePMPlan,UIDevicePMPlan> _function = new Function1<RCDevicePMPlan,UIDevicePMPlan>() {
        public UIDevicePMPlan apply(final RCDevicePMPlan it) {
          UIDevicePMPlan _transform = DevicePMPlanListPresenterServiceImpl.this.mapper.transform(it);
          return _transform;
        }
      };
    Iterable<UIDevicePMPlan> _map = IterableExtensions.<RCDevicePMPlan, UIDevicePMPlan>map(_plans, _function);
    Collection<UIDevicePMPlan> _unlazy = IterableExtensions2.<UIDevicePMPlan>unlazy(_map);
    return _unlazy;
  }
  
  public Collection<UIDevicePMPlan> loadDevicePMPlanList4Device(final RCDeviceProxy context) throws SessionTimeOutException, ValidationException {
    RCDevice _resolved= null;
    if(context!=null) _resolved=(com.fudanmed.platform.core.device.RCDevice)com.uniquesoft.uidl.extensions.ModelObjects.resolve(context, entities);
    
    Collection<RCDevicePMPlan> _findByDevice = this.dao.findByDevice( _resolved);
    final Function1<RCDevicePMPlan,UIDevicePMPlan> _function = new Function1<RCDevicePMPlan,UIDevicePMPlan>() {
        public UIDevicePMPlan apply(final RCDevicePMPlan it) {
          UIDevicePMPlan _transform = DevicePMPlanListPresenterServiceImpl.this.mapper.transform(it);
          return _transform;
        }
      };
    Iterable<UIDevicePMPlan> _map = IterableExtensions.<RCDevicePMPlan, UIDevicePMPlan>map(_findByDevice, _function);
    Collection<UIDevicePMPlan> _unlazy = IterableExtensions2.<UIDevicePMPlan>unlazy(_map);
    return _unlazy;
  }
}
