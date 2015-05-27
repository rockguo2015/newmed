package com.fudanmed.platform.core.common;

import com.fudanmed.platform.core.common.impl.RCSystemParameterImpl;
import com.fudanmed.platform.core.common.proxy.RCSystemParameterProxy;
import edu.fudan.mylang.pf.EntityImplementation;
import edu.fudan.mylang.pf.IModelObject;

@EntityImplementation(implementBy = RCSystemParameterImpl.class)
public interface RCSystemParameter extends IModelObject {
  public abstract String getApplicationTitle();
  
  public abstract RCSystemParameter setApplicationTitle(final String applicationTitle);
  
  public abstract String getOrgName();
  
  public abstract RCSystemParameter setOrgName(final String orgName);
  
  public abstract Integer getRefreshInterval();
  
  public abstract RCSystemParameter setRefreshInterval(final Integer refreshInterval);
  
  public abstract Integer getCustomerEvalCommitInterval();
  
  public abstract RCSystemParameter setCustomerEvalCommitInterval(final Integer customerEvalCommitInterval);
  
  public abstract Integer getEboardRefreshInterval();
  
  public abstract RCSystemParameter setEboardRefreshInterval(final Integer eboardRefreshInterval);
  
  public abstract RCSystemParameterProxy toProxy();
}
