package edu.fudan.langlab.domain.security.impl;

import edu.fudan.langlab.domain.security.Role;
import edu.fudan.langlab.domain.security.proxy.RoleProxy;
import edu.fudan.mylang.pf.BaseModelObject;
import edu.fudan.mylang.pf.IObjectFactory;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;
import org.hibernate.annotations.DiscriminatorOptions;

@Entity
@DiscriminatorValue("ROLE_TYPE")
@DiscriminatorOptions(force = true)
@DiscriminatorColumn(length = 64)
@Table(name = "role")
public class RoleImpl extends BaseModelObject implements Role {
  public RoleImpl() {
    super();
  }
  
  private String roleId;
  
  public String getRoleId() {
    return this.roleId;
  }
  
  public Role setRoleId(final String roleId) {
    this.roleId = roleId;
    return this;			
    
  }
  
  private Boolean isBuildin = Boolean.valueOf(false);
  
  public Boolean getIsBuildin() {
    return this.isBuildin;
  }
  
  public Role setIsBuildin(final Boolean isBuildin) {
    this.isBuildin = isBuildin;
    return this;			
    
  }
  
  private String name;
  
  public String getName() {
    return this.name;
  }
  
  public Role setName(final String name) {
    this.name = name;
    return this;			
    
  }
  
  public String getEntityName() {
    return this.name;
  }
  
  public static Role create(final IObjectFactory objectFactory) {
    edu.fudan.langlab.domain.security.Role role = new edu.fudan.langlab.domain.security.impl.RoleImpl(
    );
    objectFactory.create(role);
    return role;			
    
  }
  
  public RoleProxy toProxy() {
    edu.fudan.langlab.domain.security.proxy.RoleProxy proxy = new edu.fudan.langlab.domain.security.proxy.RoleProxy();
    proxy.setId(this.getId());
    if(this instanceof edu.fudan.mylang.pf.INamedModelObject){
    	proxy.setName(((edu.fudan.mylang.pf.INamedModelObject)this).getEntityName());
    }
    return proxy;
    
  }
}
