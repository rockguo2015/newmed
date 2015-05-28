package com.fudanmed.platform.core.web.server.service.device;

import com.fudanmed.platform.core.device.RCDevice;
import com.fudanmed.platform.core.device.RCDeviceLookupCriteria;
import com.fudanmed.platform.core.web.client.device.AllDeviceContentProviderService;
import com.fudanmed.platform.core.web.server.service.device.DeviceMapper;
import com.fudanmed.platform.core.web.shared.device.AllDeviceContentProviderCriteria;
import com.fudanmed.platform.core.web.shared.device.UIDevice;
import com.google.common.base.Function;
import com.uniquesoft.gwt.server.common.pager.PagedQueries;
import com.uniquesoft.gwt.shared.common.pager.IPagedResult;
import com.uniquesoft.uidl.contentprovider.BaseContentProviderService;
import com.uniquesoft.uidl.transform.IConvertService;
import edu.fudan.mylang.pf.IObjectFactory;
import java.util.Collection;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("com.fudanmed.platform.core.web.client.device.AllDeviceContentProviderService")
@Transactional
public class AllDeviceContentProviderServiceImpl extends BaseContentProviderService implements AllDeviceContentProviderService {
  @Autowired
  private IConvertService convertService;
  
  @Autowired
  private IObjectFactory entities;
  
  @Autowired
  private DeviceMapper mapper;
  
  public Collection<UIDevice> load(final AllDeviceContentProviderCriteria filter) {
    return doLoad(filter);
  }
  
  public Collection<UIDevice> doLoad(final AllDeviceContentProviderCriteria filter) {
    RCDeviceLookupCriteria _createPagedCriteria = PagedQueries.createPagedCriteria(filter, RCDeviceLookupCriteria.class, this.entities);
    final Procedure1<RCDeviceLookupCriteria> _function = new Procedure1<RCDeviceLookupCriteria>() {
        public void apply(final RCDeviceLookupCriteria it) {
          String _name = filter.getName();
          it.setInfo(_name);
        }
      };
    RCDeviceLookupCriteria _doubleArrow = ObjectExtensions.<RCDeviceLookupCriteria>operator_doubleArrow(_createPagedCriteria, _function);
    final Function1<RCDevice,UIDevice> _function_1 = new Function1<RCDevice,UIDevice>() {
        public UIDevice apply(final RCDevice it) {
          UIDevice _transform = AllDeviceContentProviderServiceImpl.this.mapper.transform(it);
          return _transform;
        }
      };
    IPagedResult<UIDevice> _listAndTransform = PagedQueries.<UIDevice, RCDevice>listAndTransform(_doubleArrow, new Function<RCDevice,UIDevice>() {
        public UIDevice apply(RCDevice input) {
          return _function_1.apply(input);
        }
    });
    return _listAndTransform;
  }
}
