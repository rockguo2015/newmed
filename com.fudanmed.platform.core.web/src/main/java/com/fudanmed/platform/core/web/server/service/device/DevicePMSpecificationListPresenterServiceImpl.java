package com.fudanmed.platform.core.web.server.service.device;

import com.fudanmed.platform.core.device.RCDevice;
import com.fudanmed.platform.core.device.pm.RCDevicePMSpecification;
import com.fudanmed.platform.core.device.pm.RCDevicePMSpecificationDAO;
import com.fudanmed.platform.core.device.proxy.RCDeviceProxy;
import com.fudanmed.platform.core.web.client.device.DevicePMSpecificationListPresenterService;
import com.fudanmed.platform.core.web.server.service.device.DevicePMSpecificationMapper;
import com.fudanmed.platform.core.web.shared.device.UIDevicePMSpecification;
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

@Service("com.fudanmed.platform.core.web.client.device.DevicePMSpecificationListPresenterService")
@Transactional
public class DevicePMSpecificationListPresenterServiceImpl extends BaseService implements DevicePMSpecificationListPresenterService {
  @Autowired
  private IObjectFactory entities;
  
  @Autowired
  private DevicePMSpecificationMapper mapper;
  
  @Autowired
  private RCDevicePMSpecificationDAO dao;
  
  public Collection<UIDevicePMSpecification> loadDevicePMSpecificationList(final RCDeviceProxy context) throws SessionTimeOutException, ValidationException {
    RCDevice _resolved= null;
    if(context!=null) _resolved=(com.fudanmed.platform.core.device.RCDevice)com.uniquesoft.uidl.extensions.ModelObjects.resolve(context, entities);
    
    Collection<RCDevicePMSpecification> _findByDevice = this.dao.findByDevice( _resolved);
    final Function1<RCDevicePMSpecification,UIDevicePMSpecification> _function = new Function1<RCDevicePMSpecification,UIDevicePMSpecification>() {
        public UIDevicePMSpecification apply(final RCDevicePMSpecification it) {
          UIDevicePMSpecification _transform = DevicePMSpecificationListPresenterServiceImpl.this.mapper.transform(it);
          return _transform;
        }
      };
    Iterable<UIDevicePMSpecification> _map = IterableExtensions.<RCDevicePMSpecification, UIDevicePMSpecification>map(_findByDevice, _function);
    Collection<UIDevicePMSpecification> _unlazy = IterableExtensions2.<UIDevicePMSpecification>unlazy(_map);
    return _unlazy;
  }
}
