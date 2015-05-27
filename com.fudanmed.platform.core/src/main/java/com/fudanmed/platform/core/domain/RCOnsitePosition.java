package com.fudanmed.platform.core.domain;

import com.fudanmed.platform.core.domain.impl.RCOnsitePositionImpl;
import com.fudanmed.platform.core.domain.proxy.RCOnsitePositionProxy;
import edu.fudan.mylang.pf.EntityImplementation;
import edu.fudan.mylang.pf.IHasSimplePy;
import edu.fudan.mylang.pf.IModelObject;
import java.util.Collection;

@EntityImplementation(implementBy = RCOnsitePositionImpl.class)
public interface RCOnsitePosition extends IModelObject, IHasSimplePy {
  public abstract String getCode();
  
  public abstract RCOnsitePosition setCode(final String code);
  
  public abstract String getName();
  
  public abstract RCOnsitePosition setName(final String name);
  
  public abstract String getPhone();
  
  public abstract RCOnsitePosition setPhone(final String phone);
  
  public abstract RCOnsitePosition getParent();
  
  public abstract RCOnsitePosition setParent(final RCOnsitePosition parent);
  
  public abstract Collection<RCOnsitePosition> getSubPosition();
  
  public abstract RCOnsitePosition createAndAddtoSubPosition();
  
  public abstract RCOnsitePosition removeFromSubPosition(final RCOnsitePosition rCOnsitePosition);
  
  public abstract RCOnsitePosition removeAllSubPosition();
  
  public abstract String getSimplePy();
  
  public abstract RCOnsitePosition setSimplePy(final String simplePy);
  
  public abstract String getPath();
  
  public abstract RCOnsitePosition setPath(final String path);
  
  public abstract String getEntityName();
  
  public abstract String getNameField();
  
  public abstract String toIdBlock();
  
  public abstract String fullIdPath();
  
  public abstract String fullPath();
  
  public abstract RCOnsitePositionProxy toProxy();
}
