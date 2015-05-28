package com.fudanmed.platform.core.web.server.service.device;

import com.fudanmed.platform.core.device.pm.RCDevicePMSpecification;
import com.fudanmed.platform.core.device.pm.proxy.RCDevicePMSpecificationProxy;
import com.fudanmed.platform.core.web.client.device.InitializePMPlanPresenterService;
import com.fudanmed.platform.core.web.server.service.device.InitializePMPlanDataValidator;
import com.fudanmed.platform.core.web.shared.device.InitializePMPlanData;
import com.google.common.base.Objects;
import com.uniquesoft.gwt.server.service.common.BaseService;
import com.uniquesoft.gwt.shared.DateUtil;
import com.uniquesoft.gwt.shared.SessionTimeOutException;
import com.uniquesoft.gwt.shared.validation.ValidationException;
import com.uniquesoft.uidl.validation.Validates;
import edu.fudan.mylang.pf.IObjectFactory;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("com.fudanmed.platform.core.web.client.device.InitializePMPlanPresenterService")
@Transactional
public class InitializePMPlanPresenterServiceImpl extends BaseService implements InitializePMPlanPresenterService {
  @Autowired
  private IObjectFactory entities;
  
  @Autowired
  private InitializePMPlanDataValidator validator;
  
  public void init4Device(final InitializePMPlanData data, final RCDevicePMSpecificationProxy devicePMSpec) throws SessionTimeOutException, ValidationException {
    Validates.<InitializePMPlanData>validateWith(data, this.validator);
    RCDevicePMSpecification _resolved= null;
    if(devicePMSpec!=null) _resolved=(com.fudanmed.platform.core.device.pm.RCDevicePMSpecification)com.uniquesoft.uidl.extensions.ModelObjects.resolve(devicePMSpec, entities);
    
    Date _fromDate = data.getFromDate();
    Integer _year = data.getYear();
     _resolved.initializePMPlanUptoYear(_fromDate, _year);
  }
  
  public Date loadDefaultFromDate(final RCDevicePMSpecificationProxy devicePMSpec) throws SessionTimeOutException, ValidationException {
    Date _xblockexpression = null;
    {
      RCDevicePMSpecification _resolved= null;
      if(devicePMSpec!=null) _resolved=(com.fudanmed.platform.core.device.pm.RCDevicePMSpecification)com.uniquesoft.uidl.extensions.ModelObjects.resolve(devicePMSpec, entities);
      
      final Date lastPMPlanDate =  _resolved.getLastPMPlanDate();
      Date _xifexpression = null;
      boolean _equals = Objects.equal(lastPMPlanDate, null);
      if (_equals) {
        Date _day = DateUtil.today();
        _xifexpression = _day;
      } else {
        _xifexpression = lastPMPlanDate;
      }
      _xblockexpression = (_xifexpression);
    }
    return _xblockexpression;
  }
}
