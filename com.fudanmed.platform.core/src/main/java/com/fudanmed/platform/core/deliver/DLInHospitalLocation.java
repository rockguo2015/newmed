package com.fudanmed.platform.core.deliver;

import com.fudanmed.platform.core.deliver.impl.DLInHospitalLocationImpl;
import com.fudanmed.platform.core.deliver.proxy.DLInHospitalLocationProxy;
import com.fudanmed.platform.core.domain.RCOnsitePosition;
import edu.fudan.mylang.pf.EntityImplementation;
import edu.fudan.mylang.pf.IHasSimplePy;
import edu.fudan.mylang.pf.IModelObject;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

@EntityImplementation(implementBy = DLInHospitalLocationImpl.class)
public interface DLInHospitalLocation extends IModelObject, IHasSimplePy {
  public abstract String getCode();
  
  public abstract DLInHospitalLocation setCode(final String code);
  
  public abstract String getName();
  
  public abstract DLInHospitalLocation setName(final String name);
  
  public abstract RCOnsitePosition getLocation();
  
  public abstract DLInHospitalLocation setLocation(final RCOnsitePosition location);
  
  public abstract String getSimplePy();
  
  public abstract DLInHospitalLocation setSimplePy(final String simplePy);
  
  public abstract String getNameField();
  
  public abstract String getEntityName();
  
  public abstract void update(final Procedure1<? super DLInHospitalLocation> updater);
  
  public abstract void checkValid();
  
  public abstract DLInHospitalLocationProxy toProxy();
}
