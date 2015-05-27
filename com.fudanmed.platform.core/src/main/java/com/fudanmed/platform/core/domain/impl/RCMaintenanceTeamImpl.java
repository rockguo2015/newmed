package com.fudanmed.platform.core.domain.impl;

import com.fudanmed.platform.core.domain.RCMaintenanceTeam;
import com.fudanmed.platform.core.domain.RCOrganization;
import com.fudanmed.platform.core.domain.impl.RCOrganizationImpl;
import com.fudanmed.platform.core.domain.proxy.RCMaintenanceTeamProxy;
import edu.fudan.langlab.domain.security.Role;
import edu.fudan.langlab.domain.security.impl.RoleImpl;
import edu.fudan.mylang.pf.BaseModelObject;
import edu.fudan.mylang.pf.IObjectFactory;
import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import org.eclipse.xtext.xbase.lib.StringExtensions;
import org.hibernate.annotations.DiscriminatorOptions;

@Entity
@DiscriminatorValue("RCMAINTENANCETEAM_TYPE")
@DiscriminatorOptions(force = true)
@DiscriminatorColumn(length = 64)
@Table(name = "rcmaintenanceteam")
public class RCMaintenanceTeamImpl extends BaseModelObject implements RCMaintenanceTeam {
  public RCMaintenanceTeamImpl() {
    super();
  }
  
  private String aliasName;
  
  public String getAliasName() {
    return this.aliasName;
  }
  
  public RCMaintenanceTeam setAliasName(final String aliasName) {
    this.aliasName = aliasName;
    return this;			
    
  }
  
  @JoinColumn(name = "organization_id")
  @ManyToOne(targetEntity = RCOrganizationImpl.class, cascade = { CascadeType.MERGE, CascadeType.PERSIST })
  private RCOrganization organization;
  
  public RCOrganization getOrganization() {
    return this.organization;
  }
  
  public RCMaintenanceTeam setOrganization(final RCOrganization organization) {
    this.organization = organization;
    return this;			
    
  }
  
  @JoinColumn(name = "role_id")
  @ManyToOne(targetEntity = RoleImpl.class, cascade = { CascadeType.MERGE, CascadeType.PERSIST })
  private Role role;
  
  public Role getRole() {
    return this.role;
  }
  
  public RCMaintenanceTeam setRole(final Role role) {
    this.role = role;
    return this;			
    
  }
  
  public String getEntityName() {
    String _xifexpression = null;
    boolean _isNullOrEmpty = StringExtensions.isNullOrEmpty(this.aliasName);
    if (_isNullOrEmpty) {
      String _entityName = this.organization.getEntityName();
      _xifexpression = _entityName;
    } else {
      _xifexpression = this.aliasName;
    }
    return _xifexpression;
  }
  
  public static RCMaintenanceTeam create(final IObjectFactory objectFactory) {
    com.fudanmed.platform.core.domain.RCMaintenanceTeam rCMaintenanceTeam = new com.fudanmed.platform.core.domain.impl.RCMaintenanceTeamImpl(
    );
    objectFactory.create(rCMaintenanceTeam);
    return rCMaintenanceTeam;			
    
  }
  
  public RCMaintenanceTeamProxy toProxy() {
    com.fudanmed.platform.core.domain.proxy.RCMaintenanceTeamProxy proxy = new com.fudanmed.platform.core.domain.proxy.RCMaintenanceTeamProxy();
    proxy.setId(this.getId());
    if(this instanceof edu.fudan.mylang.pf.INamedModelObject){
    	proxy.setName(((edu.fudan.mylang.pf.INamedModelObject)this).getEntityName());
    }
    return proxy;
    
  }
}
