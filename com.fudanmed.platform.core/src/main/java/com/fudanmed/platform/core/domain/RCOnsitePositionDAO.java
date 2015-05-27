package com.fudanmed.platform.core.domain;

import com.fudanmed.platform.core.domain.RCOnsitePosition;
import edu.fudan.mylang.pf.IBaseService;

public interface RCOnsitePositionDAO extends IBaseService {
  public abstract RCOnsitePosition findByCode(final String code);
}
