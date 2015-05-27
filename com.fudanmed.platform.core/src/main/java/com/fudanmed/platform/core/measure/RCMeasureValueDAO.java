package com.fudanmed.platform.core.measure;

import com.fudanmed.platform.core.measure.RCMeasureValue;
import edu.fudan.mylang.pf.IDAOService;

public interface RCMeasureValueDAO extends IDAOService<RCMeasureValue> {
  public abstract void delete(final RCMeasureValue value);
}
