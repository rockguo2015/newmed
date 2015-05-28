package com.fudanmed.platform.core.web.server.service.device;

import com.fudanmed.platform.core.device.RCDevice;
import com.fudanmed.platform.core.device.RCDeviceDAO;
import com.fudanmed.platform.core.device.RCDeviceType;
import com.fudanmed.platform.core.device.pm.RCDevicePMSpecification;
import com.fudanmed.platform.core.device.pm.RCPMDeviceTypeEntry;
import com.fudanmed.platform.core.web.client.device.PopulatePMPlantoAllDeviceCommandService;
import com.uniquesoft.gwt.server.service.common.BaseService;
import com.uniquesoft.gwt.shared.SessionTimeOutException;
import com.uniquesoft.gwt.shared.validation.ValidationException;
import edu.fudan.mylang.pf.IObjectFactory;
import java.util.Collection;
import java.util.List;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("com.fudanmed.platform.core.web.client.device.PopulatePMPlantoAllDeviceCommandService")
@Transactional
public class PopulatePMPlantoAllDeviceCommandServiceImpl extends BaseService implements PopulatePMPlantoAllDeviceCommandService {
  @Autowired
  private IObjectFactory entities;
  
  @Autowired
  private RCDeviceDAO deviceTypeDAO;
  
  public void populateAll() throws SessionTimeOutException, ValidationException {
    Collection<RCDevicePMSpecification> _all = this.entities.<RCDevicePMSpecification>all(RCDevicePMSpecification.class);
    final Function1<RCDevicePMSpecification,RCDevice> _function = new Function1<RCDevicePMSpecification,RCDevice>() {
        public RCDevice apply(final RCDevicePMSpecification it) {
          RCDevice _device = it.getDevice();
          return _device;
        }
      };
    Iterable<RCDevice> _map = IterableExtensions.<RCDevicePMSpecification, RCDevice>map(_all, _function);
    final List<RCDevice> devicesHasPmSpec = IterableExtensions.<RCDevice>toList(_map);
    Collection<RCPMDeviceTypeEntry> _all_1 = this.entities.<RCPMDeviceTypeEntry>all(RCPMDeviceTypeEntry.class);
    final Procedure1<RCPMDeviceTypeEntry> _function_1 = new Procedure1<RCPMDeviceTypeEntry>() {
        public void apply(final RCPMDeviceTypeEntry pmentry) {
          RCDeviceType _deviceType = pmentry.getDeviceType();
          Collection<RCDevice> _findDevicesByType = PopulatePMPlantoAllDeviceCommandServiceImpl.this.deviceTypeDAO.findDevicesByType(_deviceType);
          final Procedure1<RCDevice> _function = new Procedure1<RCDevice>() {
              public void apply(final RCDevice device) {
                boolean _contains = devicesHasPmSpec.contains(device);
                boolean _not = (!_contains);
                if (_not) {
                  pmentry.populateToDevice(device);
                }
              }
            };
          IterableExtensions.<RCDevice>forEach(_findDevicesByType, _function);
        }
      };
    IterableExtensions.<RCPMDeviceTypeEntry>forEach(_all_1, _function_1);
  }
}
