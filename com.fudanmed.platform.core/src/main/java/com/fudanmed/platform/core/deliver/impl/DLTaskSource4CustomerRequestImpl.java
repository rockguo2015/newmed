package com.fudanmed.platform.core.deliver.impl;

import com.fudanmed.platform.core.deliver.DLTaskSource4CustomerRequest;
import com.fudanmed.platform.core.deliver.impl.DLTaskSourceImpl;
import com.fudanmed.platform.core.deliver.proxy.DLTaskSource4CustomerRequestProxy;
import com.fudanmed.platform.core.domain.RCOrganization;
import com.fudanmed.platform.core.domain.impl.RCOrganizationImpl;
import edu.fudan.mylang.pf.IObjectFactory;
import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
@DiscriminatorValue("DLTASKSOURCE4CUSTOMERREQUEST_TYPE")
public class DLTaskSource4CustomerRequestImpl extends DLTaskSourceImpl implements DLTaskSource4CustomerRequest {
  public DLTaskSource4CustomerRequestImpl() {
    super();
  }
  
  @JoinColumn(name = "organization_id")
  @ManyToOne(targetEntity = RCOrganizationImpl.class, cascade = { CascadeType.MERGE, CascadeType.PERSIST })
  private RCOrganization organization;
  
  public RCOrganization getOrganization() {
    return this.organization;
  }
  
  public DLTaskSource4CustomerRequest setOrganization(final RCOrganization organization) {
    this.organization = organization;
    return this;			
    
  }
  
  private String reporter;
  
  public String getReporter() {
    return this.reporter;
  }
  
  public DLTaskSource4CustomerRequest setReporter(final String reporter) {
    this.reporter = reporter;
    return this;			
    
  }
  
  public String getEntityName() {
    return "\u79D1\u5BA4\u8BF7\u6C42";
  }
  
  public static DLTaskSource4CustomerRequest create(final IObjectFactory objectFactory) {
    com.fudanmed.platform.core.deliver.DLTaskSource4CustomerRequest dLTaskSource4CustomerRequest = new com.fudanmed.platform.core.deliver.impl.DLTaskSource4CustomerRequestImpl(
    );
    objectFactory.create(dLTaskSource4CustomerRequest);
    return dLTaskSource4CustomerRequest;			
    
  }
  
  public DLTaskSource4CustomerRequestProxy toProxy() {
    com.fudanmed.platform.core.deliver.proxy.DLTaskSource4CustomerRequestProxy proxy = new com.fudanmed.platform.core.deliver.proxy.DLTaskSource4CustomerRequestProxy();
    proxy.setId(this.getId());
    if(this instanceof edu.fudan.mylang.pf.INamedModelObject){
    	proxy.setName(((edu.fudan.mylang.pf.INamedModelObject)this).getEntityName());
    }
    return proxy;
    
  }
}
