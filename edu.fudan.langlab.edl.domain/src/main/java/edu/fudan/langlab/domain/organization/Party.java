package edu.fudan.langlab.domain.organization;

import edu.fudan.langlab.domain.organization.impl.PartyImpl;
import edu.fudan.langlab.domain.organization.proxy.PartyProxy;
import edu.fudan.mylang.pf.EntityImplementation;
import edu.fudan.mylang.pf.IHasSimplePy;
import edu.fudan.mylang.pf.IModelObject;

@EntityImplementation(implementBy = PartyImpl.class)
public interface Party extends IModelObject, IHasSimplePy {
  public abstract String getName();
  
  public abstract Party setName(final String name);
  
  public abstract String getPhone();
  
  public abstract Party setPhone(final String phone);
  
  public abstract String getEmail();
  
  public abstract Party setEmail(final String email);
  
  public abstract String getAddress();
  
  public abstract Party setAddress(final String address);
  
  public abstract String getSimplePy();
  
  public abstract Party setSimplePy(final String simplePy);
  
  public abstract String getEntityName();
  
  public abstract String getNameField();
  
  public abstract PartyProxy toProxy();
}
