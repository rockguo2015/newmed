package com.fudanmed.platform.core.domain.impl;

import com.fudanmed.platform.core.domain.RCOrganization;
import com.fudanmed.platform.core.domain.RCRepairReportUser;
import com.fudanmed.platform.core.domain.impl.RCOrganizationImpl;
import com.fudanmed.platform.core.domain.proxy.RCRepairReportUserProxy;
import edu.fudan.langlab.domain.security.impl.UserImpl;
import edu.fudan.mylang.pf.IObjectFactory;
import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
@DiscriminatorValue("RCREPAIRREPORTUSER_TYPE")
public class RCRepairReportUserImpl extends UserImpl implements RCRepairReportUser {
  public RCRepairReportUserImpl() {
    super();
  }
  
  @JoinColumn(name = "organization_id")
  @ManyToOne(targetEntity = RCOrganizationImpl.class, cascade = { CascadeType.MERGE, CascadeType.PERSIST })
  private RCOrganization organization;
  
  public RCOrganization getOrganization() {
    return this.organization;
  }
  
  public RCRepairReportUser setOrganization(final RCOrganization organization) {
    this.organization = organization;
    return this;			
    
  }
  
  public String getEntityName() {
    String _name = this.organization.getName();
    return _name;
  }
  
  public static RCRepairReportUser create(final IObjectFactory objectFactory) {
    com.fudanmed.platform.core.domain.RCRepairReportUser rCRepairReportUser = new com.fudanmed.platform.core.domain.impl.RCRepairReportUserImpl(
    );
    objectFactory.create(rCRepairReportUser);
    return rCRepairReportUser;			
    
  }
  
  public RCRepairReportUserProxy toProxy() {
    com.fudanmed.platform.core.domain.proxy.RCRepairReportUserProxy proxy = new com.fudanmed.platform.core.domain.proxy.RCRepairReportUserProxy();
    proxy.setId(this.getId());
    if(this instanceof edu.fudan.mylang.pf.INamedModelObject){
    	proxy.setName(((edu.fudan.mylang.pf.INamedModelObject)this).getEntityName());
    }
    return proxy;
    
  }
}
