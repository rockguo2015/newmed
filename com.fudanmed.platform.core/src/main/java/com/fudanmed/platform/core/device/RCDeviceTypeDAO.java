package com.fudanmed.platform.core.device;

import com.fudanmed.platform.core.device.RCDeviceType;
import edu.fudan.mylang.pf.IDAOService;

public interface RCDeviceTypeDAO extends IDAOService<RCDeviceType> {
  public abstract RCDeviceType findByCode(final String code);
}
