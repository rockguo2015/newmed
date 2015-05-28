package com.fudanmed.platform.core.web.server.service.device;

import com.fudanmed.platform.core.device.RCDevice;
import com.fudanmed.platform.core.device.RCDeviceCriteria;
import com.fudanmed.platform.core.web.client.device.ExportDeviceCommandService;
import com.fudanmed.platform.core.web.server.service.device.DeviceCSVMapper;
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
import edu.fudan.langlab.csv.server.CSVExtensions;
import edu.fudan.mylang.pf.IObjectFactory;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("com.fudanmed.platform.core.web.client.device.ExportDeviceCommandService")
@Transactional
public class ExportDeviceCommandServiceImpl extends BaseService implements ExportDeviceCommandService {
  @Autowired
  private IObjectFactory entities;
  
  @Autowired
  private DeviceMapper mapper;
  
  @Autowired
  private DeviceCriteriaMapper criteriaMapper;
  
  public String prepareExport(final UIDeviceCriteria pagedCriteria) throws SessionTimeOutException, ValidationException {
    String _xblockexpression = null;
    {
      RCDeviceCriteria c = PagedQueries.createCriteria4All(pagedCriteria, RCDeviceCriteria.class, this.criteriaMapper, this.entities);
      final Function1<RCDevice,UIDevice> _function = new Function1<RCDevice,UIDevice>() {
          public UIDevice apply(final RCDevice it) {
            UIDevice _apply = ExportDeviceCommandServiceImpl.this.mapper.apply(it);
            return _apply;
          }
        };
      IPagedResult<UIDevice> _listAndTransform = PagedQueries.<UIDevice, RCDevice>listAndTransform(c, new Function<RCDevice,UIDevice>() {
          public UIDevice apply(RCDevice input) {
            return _function.apply(input);
          }
      });
      String _csvPrepare = CSVExtensions.<UIDevice>csvPrepare(this, "Device", DeviceCSVMapper.class, _listAndTransform);
      _xblockexpression = (_csvPrepare);
    }
    return _xblockexpression;
  }
}
