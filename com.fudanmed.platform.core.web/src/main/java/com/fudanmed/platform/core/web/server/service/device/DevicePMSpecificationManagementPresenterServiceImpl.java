package com.fudanmed.platform.core.web.server.service.device;

import com.fudanmed.platform.core.device.RCDevice;
import com.fudanmed.platform.core.device.RCDeviceCriteria;
import com.fudanmed.platform.core.device.pm.RCDevicePMSpecification;
import com.fudanmed.platform.core.device.pm.proxy.RCDevicePMSpecificationProxy;
import com.fudanmed.platform.core.web.client.device.DevicePMSpecificationManagementPresenterService;
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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("com.fudanmed.platform.core.web.client.device.DevicePMSpecificationManagementPresenterService")
@Transactional
public class DevicePMSpecificationManagementPresenterServiceImpl extends BaseService implements DevicePMSpecificationManagementPresenterService {
  @Autowired
  private IObjectFactory entities;
  
  @Autowired
  private DeviceCriteriaMapper criteriaMapper;
  
  @Autowired
  private DeviceMapper mapper;
  
  public IPagedResult<UIDevice> filter(final UIDeviceCriteria uicriteria) throws SessionTimeOutException, ValidationException {
    IPagedResult<UIDevice> _xblockexpression = null;
    {
      RCDeviceCriteria c = PagedQueries.createPagedCriteria(uicriteria, RCDeviceCriteria.class, this.criteriaMapper, this.entities);
      final Function1<RCDevice,UIDevice> _function = new Function1<RCDevice,UIDevice>() {
          public UIDevice apply(final RCDevice it) {
            UIDevice _apply = DevicePMSpecificationManagementPresenterServiceImpl.this.mapper.apply(it);
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
  
  public void delete(final RCDevicePMSpecificationProxy value) throws SessionTimeOutException, ValidationException {
    RCDevicePMSpecification _resolved= null;
    if(value!=null) _resolved=(com.fudanmed.platform.core.device.pm.RCDevicePMSpecification)com.uniquesoft.uidl.extensions.ModelObjects.resolve(value, entities);
    
    this.entities.delete( _resolved);
  }
}
