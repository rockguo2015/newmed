package com.fudanmed.platform.core.deliver;

import com.fudanmed.platform.core.deliver.impl.DLPatientDeliverMethodImpl;
import com.fudanmed.platform.core.deliver.proxy.DLPatientDeliverMethodProxy;
import edu.fudan.langlab.domain.code.Code;
import edu.fudan.mylang.pf.EntityImplementation;

@EntityImplementation(implementBy = DLPatientDeliverMethodImpl.class)
public interface DLPatientDeliverMethod extends Code {
  public abstract DLPatientDeliverMethodProxy toProxy();
}
