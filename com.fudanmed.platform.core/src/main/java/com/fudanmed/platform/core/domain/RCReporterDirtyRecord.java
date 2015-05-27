package com.fudanmed.platform.core.domain;

import com.fudanmed.platform.core.domain.impl.RCReporterDirtyRecordImpl;
import com.fudanmed.platform.core.domain.proxy.RCReporterDirtyRecordProxy;
import edu.fudan.mylang.pf.EntityImplementation;
import edu.fudan.mylang.pf.IModelObject;

@EntityImplementation(implementBy = RCReporterDirtyRecordImpl.class)
public interface RCReporterDirtyRecord extends IModelObject {
  public abstract Boolean getIsDirty();
  
  public abstract RCReporterDirtyRecord setIsDirty(final Boolean isDirty);
  
  public abstract RCReporterDirtyRecordProxy toProxy();
}
