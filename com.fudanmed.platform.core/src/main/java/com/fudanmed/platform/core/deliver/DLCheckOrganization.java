package com.fudanmed.platform.core.deliver;

import com.fudanmed.platform.core.deliver.impl.DLCheckOrganizationImpl;
import com.fudanmed.platform.core.deliver.proxy.DLCheckOrganizationProxy;
import com.fudanmed.platform.core.domain.RCOrganization;
import edu.fudan.mylang.pf.EntityImplementation;
import edu.fudan.mylang.pf.IHasSimplePy;
import edu.fudan.mylang.pf.IModelObject;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

@EntityImplementation(implementBy = DLCheckOrganizationImpl.class)
public interface DLCheckOrganization extends IModelObject, IHasSimplePy {
  public abstract String getCode();
  
  public abstract DLCheckOrganization setCode(final String code);
  
  public abstract String getName();
  
  public abstract DLCheckOrganization setName(final String name);
  
  public abstract RCOrganization getOrganization();
  
  public abstract DLCheckOrganization setOrganization(final RCOrganization organization);
  
  public abstract String getSimplePy();
  
  public abstract DLCheckOrganization setSimplePy(final String simplePy);
  
  public abstract String getNameField();
  
  public abstract String getEntityName();
  
  public abstract void update(final Procedure1<? super DLCheckOrganization> updater);
  
  public abstract void checkValid();
  
  public abstract DLCheckOrganizationProxy toProxy();
}
