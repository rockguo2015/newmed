package com.fudanmed.platform.core.entityextension;

import com.fudanmed.platform.core.entityextension.RCNumberWithUnitType;
import com.fudanmed.platform.core.entityextension.RCRangeType;
import edu.fudan.mylang.pf.IBaseService;

public interface RCRangeTypeDAO extends IBaseService {
  public abstract RCRangeType create(final RCNumberWithUnitType baseType);
  
  public abstract Boolean rangeTypeCreated(final RCNumberWithUnitType baseType);
}
