package com.fudanmed.platform.core.measure.impl;

import com.fudanmed.platform.core.measure.RCMeasureDevice;
import com.fudanmed.platform.core.measure.RCMeasureDeviceDAO;
import edu.fudan.mylang.pf.BaseDAOService;
import org.springframework.stereotype.Service;

@Service("com.fudanmed.platform.core.measure.RCMeasureDeviceDAO")
public class RCMeasureDeviceDAOImpl extends BaseDAOService<RCMeasureDevice> implements RCMeasureDeviceDAO {
  public void delete(final RCMeasureDevice device) {getObjectFactory().delete(device);
    
  }
}
