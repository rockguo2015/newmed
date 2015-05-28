package com.fudanmed.platform.core.web.server.service.device;

import com.fudanmed.platform.core.device.RCDevice;
import com.fudanmed.platform.core.device.pm.RCPMWorkItem;
import com.fudanmed.platform.core.device.pm.RCPMWorkItemDAO;
import com.fudanmed.platform.core.device.proxy.RCDeviceProxy;
import com.fudanmed.platform.core.web.client.device.PMWorkItemListPresenterService;
import com.fudanmed.platform.core.web.server.service.device.PMWorkItemMapper;
import com.fudanmed.platform.core.web.shared.device.UIPMWorkItem;
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

@Service("com.fudanmed.platform.core.web.client.device.PMWorkItemListPresenterService")
@Transactional
public class PMWorkItemListPresenterServiceImpl extends BaseService implements PMWorkItemListPresenterService {
  @Autowired
  private IObjectFactory entities;
  
  @Autowired
  private PMWorkItemMapper mapper;
  
  @Autowired
  private RCPMWorkItemDAO workItemDAO;
  
  public Collection<UIPMWorkItem> loadPMWorkItemList(final RCDeviceProxy device) throws SessionTimeOutException, ValidationException {
    RCDevice _resolved= null;
    if(device!=null) _resolved=(com.fudanmed.platform.core.device.RCDevice)com.uniquesoft.uidl.extensions.ModelObjects.resolve(device, entities);
    
    Collection<RCPMWorkItem> _findWorkItem4Device = this.workItemDAO.findWorkItem4Device( _resolved);
    final Function1<RCPMWorkItem,UIPMWorkItem> _function = new Function1<RCPMWorkItem,UIPMWorkItem>() {
        public UIPMWorkItem apply(final RCPMWorkItem it) {
          UIPMWorkItem _transform = PMWorkItemListPresenterServiceImpl.this.mapper.transform(it);
          return _transform;
        }
      };
    Iterable<UIPMWorkItem> _map = IterableExtensions.<RCPMWorkItem, UIPMWorkItem>map(_findWorkItem4Device, _function);
    Collection<UIPMWorkItem> _unlazy = IterableExtensions2.<UIPMWorkItem>unlazy(_map);
    return _unlazy;
  }
}
