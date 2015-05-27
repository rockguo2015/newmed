package com.fudanmed.platform.core.device.pm;

import com.fudanmed.platform.core.device.RCDevice;
import com.fudanmed.platform.core.device.pm.RCDevicePMPlan;
import edu.fudan.mylang.pf.IDAOService;
import java.util.Collection;

public interface RCDevicePMPlanDAO extends IDAOService<RCDevicePMPlan> {
  public abstract Collection<RCDevicePMPlan> findByDevice(final RCDevice device);
}
