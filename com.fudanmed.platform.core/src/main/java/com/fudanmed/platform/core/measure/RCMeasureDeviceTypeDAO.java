package com.fudanmed.platform.core.measure;

import com.fudanmed.platform.core.measure.RCMeasureDeviceType;
import edu.fudan.mylang.pf.IDAOService;
import java.util.Collection;

public interface RCMeasureDeviceTypeDAO extends IDAOService<RCMeasureDeviceType> {
  public abstract Collection<RCMeasureDeviceType> getAllMeasureDeviceTypes();
  
  public abstract RCMeasureDeviceType findByName(final String name);
}
