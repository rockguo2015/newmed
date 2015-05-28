package com.fudanmed.platform.core.web.server.service.measure;

import com.fudanmed.platform.core.measure.RCGasMeasureDevice;
import com.fudanmed.platform.core.measure.RCGasMeasureDeviceType;
import com.fudanmed.platform.core.measure.RCMeasureDevice;
import com.fudanmed.platform.core.measure.proxy.RCGasMeasureDeviceTypeProxy;
import com.fudanmed.platform.core.web.client.measure.GasMeasureDeviceListPresenterService;
import com.fudanmed.platform.core.web.server.service.measure.GasMeasureDeviceMapper;
import com.fudanmed.platform.core.web.shared.measure.UIGasMeasureDevice;
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

@Service("com.fudanmed.platform.core.web.client.measure.GasMeasureDeviceListPresenterService")
@Transactional
public class GasMeasureDeviceListPresenterServiceImpl extends BaseService implements GasMeasureDeviceListPresenterService {
  @Autowired
  private IObjectFactory entities;
  
  @Autowired
  private GasMeasureDeviceMapper mapper;
  
  public Collection<UIGasMeasureDevice> loadGasMeasureDeviceList(final RCGasMeasureDeviceTypeProxy context) throws SessionTimeOutException, ValidationException {
    RCGasMeasureDeviceType _resolved= null;
    if(context!=null) _resolved=(com.fudanmed.platform.core.measure.RCGasMeasureDeviceType)com.uniquesoft.uidl.extensions.ModelObjects.resolve(context, entities);
    
    Collection<RCMeasureDevice> _measureDevices =  _resolved.getMeasureDevices();
    Iterable<RCGasMeasureDevice> _filter = Iterables.<RCGasMeasureDevice>filter(_measureDevices, RCGasMeasureDevice.class);
    final Function1<RCGasMeasureDevice,UIGasMeasureDevice> _function = new Function1<RCGasMeasureDevice,UIGasMeasureDevice>() {
        public UIGasMeasureDevice apply(final RCGasMeasureDevice it) {
          UIGasMeasureDevice _transform = GasMeasureDeviceListPresenterServiceImpl.this.mapper.transform(it);
          return _transform;
        }
      };
    Iterable<UIGasMeasureDevice> _map = IterableExtensions.<RCGasMeasureDevice, UIGasMeasureDevice>map(_filter, _function);
    Collection<UIGasMeasureDevice> _unlazy = IterableExtensions2.<UIGasMeasureDevice>unlazy(_map);
    return _unlazy;
  }
}
