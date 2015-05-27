package com.fudanmed.platform.core.measure;

import com.fudanmed.platform.core.measure.RCMeasureDevice;
import edu.fudan.mylang.pf.IDAOService;

public interface RCMeasureDeviceDAO extends IDAOService<RCMeasureDevice> {
  public abstract void delete(final RCMeasureDevice device);
}
