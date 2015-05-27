package com.fudanmed.platform.core.deliver;

import com.fudanmed.platform.core.deliver.impl.DLResourceTypeImpl;
import com.fudanmed.platform.core.deliver.proxy.DLResourceTypeProxy;
import edu.fudan.langlab.domain.code.Code;
import edu.fudan.mylang.pf.EntityImplementation;

@EntityImplementation(implementBy = DLResourceTypeImpl.class)
public interface DLResourceType extends Code {
  public abstract DLResourceTypeProxy toProxy();
}
