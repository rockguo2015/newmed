package com.fudanmed.platform.core.web.server.service.measure;

import com.fudanmed.platform.core.measure.RCElectricMeasureDevice;
import com.fudanmed.platform.core.measure.RCElectricMeasureDeviceType;
import com.fudanmed.platform.core.measure.RCMeasureDevice;
import com.fudanmed.platform.core.measure.proxy.RCElectricMeasureDeviceTypeProxy;
import com.fudanmed.platform.core.web.client.measure.ElectricMeasureDeviceListPresenterService;
import com.fudanmed.platform.core.web.server.service.measure.ElectricMeasureDeviceMapper;
import com.fudanmed.platform.core.web.shared.measure.UIElectricMeasureDevice;
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

@Service("com.fudanmed.platform.core.web.client.measure.ElectricMeasureDeviceListPresenterService")
@Transactional
public class ElectricMeasureDeviceListPresenterServiceImpl extends BaseService implements ElectricMeasureDeviceListPresenterService {
  @Autowired
  private IObjectFactory entities;
  
  @Autowired
  private ElectricMeasureDeviceMapper mapper;
  
  public Collection<UIElectricMeasureDevice> loadElectricMeasureDeviceList(final RCElectricMeasureDeviceTypeProxy context) throws SessionTimeOutException, ValidationException {
    RCElectricMeasureDeviceType _resolved= null;
    if(context!=null) _resolved=(com.fudanmed.platform.core.measure.RCElectricMeasureDeviceType)com.uniquesoft.uidl.extensions.ModelObjects.resolve(context, entities);
    
    Collection<RCMeasureDevice> _measureDevices =  _resolved.getMeasureDevices();
    Iterable<RCElectricMeasureDevice> _filter = Iterables.<RCElectricMeasureDevice>filter(_measureDevices, RCElectricMeasureDevice.class);
    final Function1<RCElectricMeasureDevice,UIElectricMeasureDevice> _function = new Function1<RCElectricMeasureDevice,UIElectricMeasureDevice>() {
        public UIElectricMeasureDevice apply(final RCElectricMeasureDevice it) {
          UIElectricMeasureDevice _transform = ElectricMeasureDeviceListPresenterServiceImpl.this.mapper.transform(it);
          return _transform;
        }
      };
    Iterable<UIElectricMeasureDevice> _map = IterableExtensions.<RCElectricMeasureDevice, UIElectricMeasureDevice>map(_filter, _function);
    Collection<UIElectricMeasureDevice> _unlazy = IterableExtensions2.<UIElectricMeasureDevice>unlazy(_map);
    return _unlazy;
  }
}
