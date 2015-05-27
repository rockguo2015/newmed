package com.fudanmed.platform.core.deliver;

import com.fudanmed.platform.core.deliver.DLDeliverEmergency;
import com.fudanmed.platform.core.deliver.impl.DLDeliverSubjectImpl;
import com.fudanmed.platform.core.deliver.proxy.DLDeliverSubjectProxy;
import edu.fudan.mylang.pf.EntityImplementation;
import edu.fudan.mylang.pf.IModelObject;
import edu.fudan.mylang.pf.INamedModelObject;

@EntityImplementation(implementBy = DLDeliverSubjectImpl.class)
public interface DLDeliverSubject extends IModelObject, INamedModelObject {
  public abstract DLDeliverEmergency getEmergency();
  
  public abstract DLDeliverSubject setEmergency(final DLDeliverEmergency emergency);
  
  public abstract String getEntityName();
  
  public abstract DLDeliverSubjectProxy toProxy();
}
