package com.fudanmed.platform.core.web.server.service.measure;

import com.fudanmed.platform.core.measure.RCMeasureDevice;
import com.fudanmed.platform.core.measure.RCPhasedElectricMeasureDevice;
import com.fudanmed.platform.core.measure.RCPhasedElectricMeasureDeviceType;
import com.fudanmed.platform.core.measure.proxy.RCPhasedElectricMeasureDeviceTypeProxy;
import com.fudanmed.platform.core.web.client.measure.PhasedElectricMeasureDeviceListPresenterService;
import com.fudanmed.platform.core.web.server.service.measure.PhasedElectricMeasureDeviceMapper;
import com.fudanmed.platform.core.web.shared.measure.UIPhasedElectricMeasureDevice;
import com.google.common.collect.Iterables;
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

@Service("com.fudanmed.platform.core.web.client.measure.PhasedElectricMeasureDeviceListPresenterService")
@Transactional
public class PhasedElectricMeasureDeviceListPresenterServiceImpl extends BaseService implements PhasedElectricMeasureDeviceListPresenterService {
  @Autowired
  private IObjectFactory entities;
  
  @Autowired
  private PhasedElectricMeasureDeviceMapper mapper;
  
  public Collection<UIPhasedElectricMeasureDevice> loadPhasedElectricMeasureDeviceList(final RCPhasedElectricMeasureDeviceTypeProxy context) throws SessionTimeOutException, ValidationException {
    RCPhasedElectricMeasureDeviceType _resolved= null;
    if(context!=null) _resolved=(com.fudanmed.platform.core.measure.RCPhasedElectricMeasureDeviceType)com.uniquesoft.uidl.extensions.ModelObjects.resolve(context, entities);
    
    Collection<RCMeasureDevice> _measureDevices =  _resolved.getMeasureDevices();
    Iterable<RCPhasedElectricMeasureDevice> _filter = Iterables.<RCPhasedElectricMeasureDevice>filter(_measureDevices, RCPhasedElectricMeasureDevice.class);
    final Function1<RCPhasedElectricMeasureDevice,UIPhasedElectricMeasureDevice> _function = new Function1<RCPhasedElectricMeasureDevice,UIPhasedElectricMeasureDevice>() {
        public UIPhasedElectricMeasureDevice apply(final RCPhasedElectricMeasureDevice it) {
          UIPhasedElectricMeasureDevice _transform = PhasedElectricMeasureDeviceListPresenterServiceImpl.this.mapper.transform(it);
          return _transform;
        }
      };
    Iterable<UIPhasedElectricMeasureDevice> _map = IterableExtensions.<RCPhasedElectricMeasureDevice, UIPhasedElectricMeasureDevice>map(_filter, _function);
    Collection<UIPhasedElectricMeasureDevice> _unlazy = IterableExtensions2.<UIPhasedElectricMeasureDevice>unlazy(_map);
    return _unlazy;
  }
}
