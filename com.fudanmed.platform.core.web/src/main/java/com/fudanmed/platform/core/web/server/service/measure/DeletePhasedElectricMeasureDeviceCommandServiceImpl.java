package com.fudanmed.platform.core.web.server.service.measure;

import com.fudanmed.platform.core.measure.proxy.RCPhasedElectricMeasureDeviceProxy;
import com.fudanmed.platform.core.web.client.measure.DeletePhasedElectricMeasureDeviceCommandService;
import com.uniquesoft.gwt.server.service.common.BaseService;
import com.uniquesoft.gwt.shared.SessionTimeOutException;
import com.uniquesoft.gwt.shared.validation.ValidationException;
import edu.fudan.mylang.pf.IObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("com.fudanmed.platform.core.web.client.measure.DeletePhasedElectricMeasureDeviceCommandService")
@Transactional
public class DeletePhasedElectricMeasureDeviceCommandServiceImpl extends BaseService implements DeletePhasedElectricMeasureDeviceCommandService {
  @Autowired
  private IObjectFactory entities;
  
  public void delete(final RCPhasedElectricMeasureDeviceProxy value) throws SessionTimeOutException, ValidationException {
  }
}
