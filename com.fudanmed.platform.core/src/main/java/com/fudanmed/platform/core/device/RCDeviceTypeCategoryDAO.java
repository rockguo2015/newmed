package com.fudanmed.platform.core.device;

import com.fudanmed.platform.core.device.RCDeviceTypeCategory;
import edu.fudan.mylang.pf.IBaseService;
import java.util.Collection;

public interface RCDeviceTypeCategoryDAO extends IBaseService {
  public abstract RCDeviceTypeCategory findByCode(final String code);
  
  public abstract Collection<RCDeviceTypeCategory> allRootCategories();
}
