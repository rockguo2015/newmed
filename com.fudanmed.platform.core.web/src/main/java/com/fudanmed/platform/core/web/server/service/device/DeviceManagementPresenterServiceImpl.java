package com.fudanmed.platform.core.web.server.service.device;

import com.fudanmed.platform.core.device.RCDevice;
import com.fudanmed.platform.core.device.RCDeviceCriteria;
import com.fudanmed.platform.core.device.RCDeviceDAO;
import com.fudanmed.platform.core.device.RCDeviceTypeCategoryDAO;
import com.fudanmed.platform.core.device.proxy.RCDeviceProxy;
import com.fudanmed.platform.core.entityextension.RCExtensiableEntity;
import com.fudanmed.platform.core.entityextension.proxy.RCExtensiableEntityProxy;
import com.fudanmed.platform.core.web.client.device.DeviceManagementPresenterService;
import com.fudanmed.platform.core.web.server.service.device.DeviceCriteriaMapper;
import com.fudanmed.platform.core.web.server.service.device.DeviceMapper;
import com.fudanmed.platform.core.web.shared.device.UIDevice;
import com.fudanmed.platform.core.web.shared.device.UIDeviceCriteria;
import com.google.common.base.Function;
import com.uniquesoft.gwt.server.common.pager.PagedQueries;
import com.uniquesoft.gwt.server.service.common.BaseService;
import com.uniquesoft.gwt.shared.SessionTimeOutException;
import com.uniquesoft.gwt.shared.common.pager.IPagedResult;
import com.uniquesoft.gwt.shared.validation.ValidationException;
import edu.fudan.mylang.pf.IObjectFactory;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("com.fudanmed.platform.core.web.client.device.DeviceManagementPresenterService")
@Transactional
public class DeviceManagementPresenterServiceImpl extends BaseService implements DeviceManagementPresenterService {
  @Autowired
  private IObjectFactory entities;
  
  @Autowired
  private DeviceCriteriaMapper criteriaMapper;
  
  @Autowired
  private DeviceMapper mapper;
  
  @Autowired
  private RCDeviceTypeCategoryDAO categoryDao;
  
  @Autowired
  private RCDeviceDAO deviceDao;
  
  public IPagedResult<UIDevice> filter(final UIDeviceCriteria uicriteria) throws SessionTimeOutException, ValidationException {
    IPagedResult<UIDevice> _xblockexpression = null;
    {
      RCDeviceCriteria c = PagedQueries.createPagedCriteria(uicriteria, RCDeviceCriteria.class, this.criteriaMapper, this.entities);
      final Function1<RCDevice,UIDevice> _function = new Function1<RCDevice,UIDevice>() {
          public UIDevice apply(final RCDevice it) {
            UIDevice _apply = DeviceManagementPresenterServiceImpl.this.mapper.apply(it);
            return _apply;
          }
        };
      IPagedResult<UIDevice> _listAndTransform = PagedQueries.<UIDevice, RCDevice>listAndTransform(c, new Function<RCDevice,UIDevice>() {
          public UIDevice apply(RCDevice input) {
            return _function.apply(input);
          }
      });
      _xblockexpression = (_listAndTransform);
    }
    return _xblockexpression;
  }
  
  public void delete(final RCDeviceProxy value) throws SessionTimeOutException, ValidationException {
    RCDevice _resolved= null;
    if(value!=null) _resolved=(com.fudanmed.platform.core.device.RCDevice)com.uniquesoft.uidl.extensions.ModelObjects.resolve(value, entities);
    
    final Procedure1<RCDevice> _function = new Procedure1<RCDevice>() {
        public void apply(final RCDevice it) {
        }
      };
    this.deviceDao.delete( _resolved, _function);
  }
  
  public RCExtensiableEntityProxy loadEntityExtension(final RCDeviceProxy device) throws SessionTimeOutException, ValidationException {
    RCDevice _resolved= null;
    if(device!=null) _resolved=(com.fudanmed.platform.core.device.RCDevice)com.uniquesoft.uidl.extensions.ModelObjects.resolve(device, entities);
    
    RCExtensiableEntity _extension =  _resolved.getExtension();
    RCExtensiableEntityProxy _proxy = _extension.toProxy();
    return _proxy;
  }
}
