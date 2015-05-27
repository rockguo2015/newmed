package com.fudanmed.platform.core.device.pm;

import com.fudanmed.platform.core.device.RCDeviceType;
import com.fudanmed.platform.core.device.pm.RCPMDeviceTypeEntry;
import edu.fudan.mylang.pf.IDAOService;

public interface RCPMDeviceTypeEntryDAO extends IDAOService<RCPMDeviceTypeEntry> {
  public abstract RCPMDeviceTypeEntry findByDeviceType(final RCDeviceType deviceType);
}
