package com.fudanmed.platform.core.deliver;

import com.fudanmed.platform.core.deliver.DLDeliverSubject;
import com.fudanmed.platform.core.deliver.DLMaterialDeliverDetail;
import com.fudanmed.platform.core.deliver.impl.DLMaterialDeliverImpl;
import com.fudanmed.platform.core.deliver.proxy.DLMaterialDeliverProxy;
import com.fudanmed.platform.core.domain.RCOnsitePosition;
import edu.fudan.mylang.pf.EntityImplementation;
import java.util.Collection;

@EntityImplementation(implementBy = DLMaterialDeliverImpl.class)
public interface DLMaterialDeliver extends DLDeliverSubject {
  public abstract Collection<DLMaterialDeliverDetail> getMaterialDetails();
  
  public abstract DLMaterialDeliverDetail createAndAddtoMaterialDetails();
  
  public abstract DLMaterialDeliver removeFromMaterialDetails(final DLMaterialDeliverDetail dLMaterialDeliverDetail);
  
  public abstract DLMaterialDeliver removeAllMaterialDetails();
  
  public abstract RCOnsitePosition getFromLocation();
  
  public abstract DLMaterialDeliver setFromLocation(final RCOnsitePosition fromLocation);
  
  public abstract RCOnsitePosition getToLocation();
  
  public abstract DLMaterialDeliver setToLocation(final RCOnsitePosition toLocation);
  
  public abstract void checkValid();
  
  public abstract String getEntityName();
  
  public abstract DLMaterialDeliverProxy toProxy();
}
