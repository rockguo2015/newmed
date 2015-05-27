package edu.fudan.langlab.domain.security.impl;

import edu.fudan.langlab.domain.security.AppFunction;
import edu.fudan.langlab.domain.security.RoleFunctionAssignment;
import edu.fudan.langlab.domain.security.impl.AppFunctionImpl;
import edu.fudan.langlab.domain.security.proxy.RoleFunctionAssignmentProxy;
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
@DiscriminatorValue("ROLEFUNCTIONASSIGNMENT_TYPE")
@DiscriminatorOptions(force = true)
@DiscriminatorColumn(length = 64)
@Table(name = "rolefunctionassignment")
public class RoleFunctionAssignmentImpl extends BaseModelObject implements RoleFunctionAssignment {
  public RoleFunctionAssignmentImpl() {
    super();
  }
  
  private String roleId;
  
  public String getRoleId() {
    return this.roleId;
  }
  
  public RoleFunctionAssignment setRoleId(final String roleId) {
    this.roleId = roleId;
    return this;			
    
  }
  
  @JoinColumn(name = "function_id")
  @ManyToOne(targetEntity = AppFunctionImpl.class, cascade = { CascadeType.MERGE, CascadeType.PERSIST })
  private AppFunction function;
  
  public AppFunction getFunction() {
    return this.function;
  }
  
  public RoleFunctionAssignment setFunction(final AppFunction function) {
    this.function = function;
    return this;			
    
  }
  
  public static RoleFunctionAssignment create(final IObjectFactory objectFactory) {
    edu.fudan.langlab.domain.security.RoleFunctionAssignment roleFunctionAssignment = new edu.fudan.langlab.domain.security.impl.RoleFunctionAssignmentImpl(
    );
    objectFactory.create(roleFunctionAssignment);
    return roleFunctionAssignment;			
    
  }
  
  public RoleFunctionAssignmentProxy toProxy() {
    edu.fudan.langlab.domain.security.proxy.RoleFunctionAssignmentProxy proxy = new edu.fudan.langlab.domain.security.proxy.RoleFunctionAssignmentProxy();
    proxy.setId(this.getId());
    if(this instanceof edu.fudan.mylang.pf.INamedModelObject){
    	proxy.setName(((edu.fudan.mylang.pf.INamedModelObject)this).getEntityName());
    }
    return proxy;
    
  }
}
