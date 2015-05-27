package com.fudanmed.platform.core.device.pm;

import com.fudanmed.platform.core.device.RCDevice;
import com.fudanmed.platform.core.device.pm.RCWorkItemPlanAssignment;
import edu.fudan.mylang.pf.IDAOService;
import java.util.Collection;

public interface RCWorkItemPlanAssignmentDAO extends IDAOService<RCWorkItemPlanAssignment> {
  public abstract Collection<RCWorkItemPlanAssignment> findByDevice(final RCDevice device);
}
