package com.fudanmed.platform.core.deliver;

import com.fudanmed.platform.core.deliver.impl.DLDeliverOrganizationImpl;
import com.fudanmed.platform.core.deliver.proxy.DLDeliverOrganizationProxy;
import com.fudanmed.platform.core.domain.RCOrganization;
import edu.fudan.mylang.pf.EntityImplementation;
import edu.fudan.mylang.pf.IModelObject;
import edu.fudan.mylang.pf.INamedModelObject;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

@EntityImplementation(implementBy = DLDeliverOrganizationImpl.class)
public interface DLDeliverOrganization extends IModelObject, INamedModelObject {
  public abstract String getCode();
  
  public abstract DLDeliverOrganization setCode(final String code);
  
  public abstract String getName();
  
  public abstract DLDeliverOrganization setName(final String name);
  
  public abstract RCOrganization getOrganization();
  
  public abstract DLDeliverOrganization setOrganization(final RCOrganization organization);
  
  public abstract String getEntityName();
  
  public abstract void update(final Procedure1<? super DLDeliverOrganization> updater);
  
  public abstract void checkValid();
  
  public abstract DLDeliverOrganizationProxy toProxy();
}
