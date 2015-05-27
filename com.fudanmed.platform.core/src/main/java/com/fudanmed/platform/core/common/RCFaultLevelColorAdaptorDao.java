package com.fudanmed.platform.core.common;

import com.fudanmed.platform.core.common.RCFaultLevel;
import com.fudanmed.platform.core.common.RCFaultLevelColorAdaptor;
import edu.fudan.mylang.pf.IDAOService;
import java.util.Collection;

public interface RCFaultLevelColorAdaptorDao extends IDAOService<RCFaultLevelColorAdaptor> {
  public abstract Collection<RCFaultLevelColorAdaptor> findAll();
  
  public abstract String getColor(final RCFaultLevel faultLevel);
}
