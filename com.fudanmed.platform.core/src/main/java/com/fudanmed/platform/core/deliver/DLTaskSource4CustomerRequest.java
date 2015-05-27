package com.fudanmed.platform.core.deliver;

import com.fudanmed.platform.core.deliver.DLTaskSource;
import com.fudanmed.platform.core.deliver.impl.DLTaskSource4CustomerRequestImpl;
import com.fudanmed.platform.core.deliver.proxy.DLTaskSource4CustomerRequestProxy;
import com.fudanmed.platform.core.domain.RCOrganization;
import edu.fudan.mylang.pf.EntityImplementation;

@EntityImplementation(implementBy = DLTaskSource4CustomerRequestImpl.class)
public interface DLTaskSource4CustomerRequest extends DLTaskSource {
  public abstract RCOrganization getOrganization();
  
  public abstract DLTaskSource4CustomerRequest setOrganization(final RCOrganization organization);
  
  public abstract String getReporter();
  
  public abstract DLTaskSource4CustomerRequest setReporter(final String reporter);
  
  public abstract String getEntityName();
  
  public abstract DLTaskSource4CustomerRequestProxy toProxy();
}
