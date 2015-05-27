package com.fudanmed.platform.core.common;

import com.fudanmed.platform.core.common.impl.RCFaultReportSourceImpl;
import com.fudanmed.platform.core.common.proxy.RCFaultReportSourceProxy;
import edu.fudan.langlab.domain.code.Code;
import edu.fudan.mylang.pf.EntityImplementation;

@EntityImplementation(implementBy = RCFaultReportSourceImpl.class)
public interface RCFaultReportSource extends Code {
  public abstract RCFaultReportSourceProxy toProxy();
}
