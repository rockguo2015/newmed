package com.fudanmed.platform.core.web.server.service.measure;

import com.fudanmed.platform.core.measure.proxy.RCElectricMeasureDeviceProxy;
import com.fudanmed.platform.core.web.client.measure.DeleteElectricMeasureDeviceCommandService;
import com.uniquesoft.gwt.server.service.common.BaseService;
import com.uniquesoft.gwt.shared.SessionTimeOutException;
import com.uniquesoft.gwt.shared.validation.ValidationException;
import edu.fudan.mylang.pf.IObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("com.fudanmed.platform.core.web.client.measure.DeleteElectricMeasureDeviceCommandService")
@Transactional
public class DeleteElectricMeasureDeviceCommandServiceImpl extends BaseService implements DeleteElectricMeasureDeviceCommandService {
  @Autowired
  private IObjectFactory entities;
  
  public void delete(final RCElectricMeasureDeviceProxy value) throws SessionTimeOutException, ValidationException {
  }
}
