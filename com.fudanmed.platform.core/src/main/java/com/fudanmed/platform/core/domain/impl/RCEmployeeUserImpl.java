package com.fudanmed.platform.core.domain.impl;

import com.fudanmed.platform.core.domain.RCEmployee;
import com.fudanmed.platform.core.domain.RCEmployeeUser;
import com.fudanmed.platform.core.domain.impl.RCEmployeeImpl;
import com.fudanmed.platform.core.domain.proxy.RCEmployeeUserProxy;
import edu.fudan.langlab.domain.security.impl.UserImpl;
import edu.fudan.mylang.pf.IObjectFactory;
import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
@DiscriminatorValue("RCEMPLOYEEUSER_TYPE")
public class RCEmployeeUserImpl extends UserImpl implements RCEmployeeUser {
  public RCEmployeeUserImpl() {
    super();
  }
  
  @JoinColumn(name = "employee_id")
  @ManyToOne(targetEntity = RCEmployeeImpl.class, cascade = { CascadeType.MERGE, CascadeType.PERSIST })
  private RCEmployee employee;
  
  public RCEmployee getEmployee() {
    return this.employee;
  }
  
  public RCEmployeeUser setEmployee(final RCEmployee employee) {
    this.employee = employee;
    return this;			
    
  }
  
  public String getEntityName() {
    String _name = this.employee.getName();
    return _name;
  }
  
  public static RCEmployeeUser create(final IObjectFactory objectFactory) {
    com.fudanmed.platform.core.domain.RCEmployeeUser rCEmployeeUser = new com.fudanmed.platform.core.domain.impl.RCEmployeeUserImpl(
    );
    objectFactory.create(rCEmployeeUser);
    return rCEmployeeUser;			
    
  }
  
  public RCEmployeeUserProxy toProxy() {
    com.fudanmed.platform.core.domain.proxy.RCEmployeeUserProxy proxy = new com.fudanmed.platform.core.domain.proxy.RCEmployeeUserProxy();
    proxy.setId(this.getId());
    if(this instanceof edu.fudan.mylang.pf.INamedModelObject){
    	proxy.setName(((edu.fudan.mylang.pf.INamedModelObject)this).getEntityName());
    }
    return proxy;
    
  }
}
