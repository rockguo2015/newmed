package com.fudanmed.platform.core.web.server.service.measure;

import com.fudanmed.platform.core.measure.RCMeasureDevice;
import com.fudanmed.platform.core.measure.RCWaterMeasureDevice;
import com.fudanmed.platform.core.measure.RCWaterMeasureDeviceType;
import com.fudanmed.platform.core.measure.proxy.RCWaterMeasureDeviceTypeProxy;
import com.fudanmed.platform.core.web.client.measure.WaterMeasureDeviceListPresenterService;
import com.fudanmed.platform.core.web.server.service.measure.WaterMeasureDeviceMapper;
import com.fudanmed.platform.core.web.shared.measure.UIWaterMeasureDevice;
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

@Service("com.fudanmed.platform.core.web.client.measure.WaterMeasureDeviceListPresenterService")
@Transactional
public class WaterMeasureDeviceListPresenterServiceImpl extends BaseService implements WaterMeasureDeviceListPresenterService {
  @Autowired
  private IObjectFactory entities;
  
  @Autowired
  private WaterMeasureDeviceMapper mapper;
  
  public Collection<UIWaterMeasureDevice> loadWaterMeasureDeviceList(final RCWaterMeasureDeviceTypeProxy context) throws SessionTimeOutException, ValidationException {
    RCWaterMeasureDeviceType _resolved= null;
    if(context!=null) _resolved=(com.fudanmed.platform.core.measure.RCWaterMeasureDeviceType)com.uniquesoft.uidl.extensions.ModelObjects.resolve(context, entities);
    
    Collection<RCMeasureDevice> _measureDevices =  _resolved.getMeasureDevices();
    Iterable<RCWaterMeasureDevice> _filter = Iterables.<RCWaterMeasureDevice>filter(_measureDevices, RCWaterMeasureDevice.class);
    final Function1<RCWaterMeasureDevice,UIWaterMeasureDevice> _function = new Function1<RCWaterMeasureDevice,UIWaterMeasureDevice>() {
        public UIWaterMeasureDevice apply(final RCWaterMeasureDevice it) {
          UIWaterMeasureDevice _transform = WaterMeasureDeviceListPresenterServiceImpl.this.mapper.transform(it);
          return _transform;
        }
      };
    Iterable<UIWaterMeasureDevice> _map = IterableExtensions.<RCWaterMeasureDevice, UIWaterMeasureDevice>map(_filter, _function);
    Collection<UIWaterMeasureDevice> _unlazy = IterableExtensions2.<UIWaterMeasureDevice>unlazy(_map);
    return _unlazy;
  }
}
