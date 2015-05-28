package com.fudanmed.platform.core.web.server.service.measure;

import com.fudanmed.platform.core.measure.RCMeasureDevice;
import com.fudanmed.platform.core.measure.RCMeasureDeviceType;
import com.fudanmed.platform.core.measure.proxy.RCMeasureDeviceTypeProxy;
import com.fudanmed.platform.core.web.client.measure.MeasureDeviceListPresenterService;
import com.fudanmed.platform.core.web.server.service.measure.MeasureDeviceMapper;
import com.fudanmed.platform.core.web.shared.measure.UIMeasureDevice;
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

@Service("com.fudanmed.platform.core.web.client.measure.MeasureDeviceListPresenterService")
@Transactional
public class MeasureDeviceListPresenterServiceImpl extends BaseService implements MeasureDeviceListPresenterService {
  @Autowired
  private IObjectFactory entities;
  
  @Autowired
  private MeasureDeviceMapper mapper;
  
  public Collection<UIMeasureDevice> loadMeasureDeviceList(final RCMeasureDeviceTypeProxy context) throws SessionTimeOutException, ValidationException {
    RCMeasureDeviceType _resolved= null;
    if(context!=null) _resolved=(com.fudanmed.platform.core.measure.RCMeasureDeviceType)com.uniquesoft.uidl.extensions.ModelObjects.resolve(context, entities);
    
    Collection<RCMeasureDevice> _measureDevices =  _resolved.getMeasureDevices();
    final Function1<RCMeasureDevice,UIMeasureDevice> _function = new Function1<RCMeasureDevice,UIMeasureDevice>() {
        public UIMeasureDevice apply(final RCMeasureDevice it) {
          UIMeasureDevice _transform = MeasureDeviceListPresenterServiceImpl.this.mapper.transform(it);
          return _transform;
        }
      };
    Iterable<UIMeasureDevice> _map = IterableExtensions.<RCMeasureDevice, UIMeasureDevice>map(_measureDevices, _function);
    Collection<UIMeasureDevice> _unlazy = IterableExtensions2.<UIMeasureDevice>unlazy(_map);
    return _unlazy;
  }
}
