package edu.fudan.langlab.domain.security.impl;

import edu.fudan.langlab.domain.security.User;
import edu.fudan.langlab.domain.security.UserRoleAssignment;
import edu.fudan.langlab.domain.security.impl.UserImpl;
import edu.fudan.langlab.domain.security.proxy.UserRoleAssignmentProxy;
import edu.fudan.mylang.pf.BaseModelObject;
import edu.fudan.mylang.pf.IObjectFactory;
import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import org.hibernate.annotations.DiscriminatorOptions;

@Entity
@DiscriminatorValue("USERROLEASSIGNMENT_TYPE")
@DiscriminatorOptions(force = true)
@DiscriminatorColumn(length = 64)
@Table(name = "userroleassignment")
public class UserRoleAssignmentImpl extends BaseModelObject implements UserRoleAssignment {
  public UserRoleAssignmentImpl() {
    super();
  }
  
  private String roleId;
  
  public String getRoleId() {
    return this.roleId;
  }
  
  public UserRoleAssignment setRoleId(final String roleId) {
    this.roleId = roleId;
    return this;			
    
  }
  
  @JoinColumn(name = "user_id")
  @ManyToOne(targetEntity = UserImpl.class, cascade = { CascadeType.MERGE, CascadeType.PERSIST })
  private User user;
  
  public User getUser() {
    return this.user;
  }
  
  public UserRoleAssignment setUser(final User user) {
    this.user = user;
    return this;			
    
  }
  
  public static UserRoleAssignment create(final IObjectFactory objectFactory) {
    edu.fudan.langlab.domain.security.UserRoleAssignment userRoleAssignment = new edu.fudan.langlab.domain.security.impl.UserRoleAssignmentImpl(
    );
    objectFactory.create(userRoleAssignment);
    return userRoleAssignment;			
    
  }
  
  public UserRoleAssignmentProxy toProxy() {
    edu.fudan.langlab.domain.security.proxy.UserRoleAssignmentProxy proxy = new edu.fudan.langlab.domain.security.proxy.UserRoleAssignmentProxy();
    proxy.setId(this.getId());
    if(this instanceof edu.fudan.mylang.pf.INamedModelObject){
    	proxy.setName(((edu.fudan.mylang.pf.INamedModelObject)this).getEntityName());
    }
    return proxy;
    
  }
}
