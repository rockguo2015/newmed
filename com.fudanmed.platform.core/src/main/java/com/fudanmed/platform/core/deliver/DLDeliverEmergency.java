package com.fudanmed.platform.core.deliver;

import com.fudanmed.platform.core.deliver.impl.DLDeliverEmergencyImpl;
import com.fudanmed.platform.core.deliver.proxy.DLDeliverEmergencyProxy;
import edu.fudan.langlab.domain.code.Code;
import edu.fudan.mylang.pf.EntityImplementation;

@EntityImplementation(implementBy = DLDeliverEmergencyImpl.class)
public interface DLDeliverEmergency extends Code {
  public abstract DLDeliverEmergencyProxy toProxy();
}
