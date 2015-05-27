package com.fudanmed.platform.core.common.impl;

import com.fudanmed.platform.core.common.RCSystemParameter;
import com.fudanmed.platform.core.common.proxy.RCSystemParameterProxy;
import edu.fudan.mylang.pf.BaseModelObject;
import edu.fudan.mylang.pf.IObjectFactory;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;
import org.hibernate.annotations.DiscriminatorOptions;

@Entity
@DiscriminatorValue("RCSYSTEMPARAMETER_TYPE")
@DiscriminatorOptions(force = true)
@DiscriminatorColumn(length = 64)
@Table(name = "rcsystemparameter")
public class RCSystemParameterImpl extends BaseModelObject implements RCSystemParameter {
  public RCSystemParameterImpl() {
    super();
  }
  
  private String applicationTitle = "\u533B\u9662\u540E\u52E4\u7EFC\u5408\u7BA1\u7406\u5E73\u53F0";
  
  public String getApplicationTitle() {
    return this.applicationTitle;
  }
  
  public RCSystemParameter setApplicationTitle(final String applicationTitle) {
    this.applicationTitle = applicationTitle;
    return this;			
    
  }
  
  private String orgName;
  
  public String getOrgName() {
    return this.orgName;
  }
  
  public RCSystemParameter setOrgName(final String orgName) {
    this.orgName = orgName;
    return this;			
    
  }
  
  private Integer refreshInterval = Integer.valueOf(30);
  
  public Integer getRefreshInterval() {
    return this.refreshInterval;
  }
  
  public RCSystemParameter setRefreshInterval(final Integer refreshInterval) {
    this.refreshInterval = refreshInterval;
    return this;			
    
  }
  
  private Integer customerEvalCommitInterval = Integer.valueOf(7);
  
  public Integer getCustomerEvalCommitInterval() {
    return this.customerEvalCommitInterval;
  }
  
  public RCSystemParameter setCustomerEvalCommitInterval(final Integer customerEvalCommitInterval) {
    this.customerEvalCommitInterval = customerEvalCommitInterval;
    return this;			
    
  }
  
  private Integer eboardRefreshInterval = Integer.valueOf(10);
  
  public Integer getEboardRefreshInterval() {
    return this.eboardRefreshInterval;
  }
  
  public RCSystemParameter setEboardRefreshInterval(final Integer eboardRefreshInterval) {
    this.eboardRefreshInterval = eboardRefreshInterval;
    return this;			
    
  }
  
  public static RCSystemParameter create(final IObjectFactory objectFactory) {
    com.fudanmed.platform.core.common.RCSystemParameter rCSystemParameter = new com.fudanmed.platform.core.common.impl.RCSystemParameterImpl(
    );
    objectFactory.create(rCSystemParameter);
    return rCSystemParameter;			
    
  }
  
  public RCSystemParameterProxy toProxy() {
    com.fudanmed.platform.core.common.proxy.RCSystemParameterProxy proxy = new com.fudanmed.platform.core.common.proxy.RCSystemParameterProxy();
    proxy.setId(this.getId());
    if(this instanceof edu.fudan.mylang.pf.INamedModelObject){
    	proxy.setName(((edu.fudan.mylang.pf.INamedModelObject)this).getEntityName());
    }
    return proxy;
    
  }
}
