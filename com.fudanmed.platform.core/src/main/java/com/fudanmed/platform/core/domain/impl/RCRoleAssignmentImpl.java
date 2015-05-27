package com.fudanmed.platform.core.domain.impl;

import com.fudanmed.platform.core.domain.RCEmployee;
import com.fudanmed.platform.core.domain.RCRoleAssignment;
import com.fudanmed.platform.core.domain.impl.RCEmployeeImpl;
import com.fudanmed.platform.core.domain.proxy.RCRoleAssignmentProxy;
import edu.fudan.mylang.pf.BaseModelObject;
import edu.fudan.mylang.pf.IObjectFactory;
import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import org.hibernate.annotations.DiscriminatorOptions;

@Entity
@DiscriminatorValue("RCROLEASSIGNMENT_TYPE")
@DiscriminatorOptions(force = true)
@DiscriminatorColumn(length = 64)
@Table(name = "rcroleassignment")
public class RCRoleAssignmentImpl extends BaseModelObject implements RCRoleAssignment {
  public RCRoleAssignmentImpl() {
    super();
  }
  
  private String roleType;
  
  public String getRoleType() {
    return this.roleType;
  }
  
  public RCRoleAssignment setRoleType(final String roleType) {
    this.roleType = roleType;
    return this;			
    
  }
  
  @JoinColumn(name = "employee_id")
  @ManyToOne(targetEntity = RCEmployeeImpl.class, cascade = { CascadeType.MERGE, CascadeType.PERSIST })
  private RCEmployee employee;
  
  public RCEmployee getEmployee() {
    return this.employee;
  }
  
  public RCRoleAssignment setEmployee(final RCEmployee employee) {
    this.employee = employee;
    return this;			
    
  }
  
  private Date startDate;
  
  public Date getStartDate() {
    return this.startDate;
  }
  
  public RCRoleAssignment setStartDate(final Date startDate) {
    this.startDate = startDate;
    return this;			
    
  }
  
  public static RCRoleAssignment create(final IObjectFactory objectFactory) {
    com.fudanmed.platform.core.domain.RCRoleAssignment rCRoleAssignment = new com.fudanmed.platform.core.domain.impl.RCRoleAssignmentImpl(
    );
    objectFactory.create(rCRoleAssignment);
    return rCRoleAssignment;			
    
  }
  
  public RCRoleAssignmentProxy toProxy() {
    com.fudanmed.platform.core.domain.proxy.RCRoleAssignmentProxy proxy = new com.fudanmed.platform.core.domain.proxy.RCRoleAssignmentProxy();
    proxy.setId(this.getId());
    if(this instanceof edu.fudan.mylang.pf.INamedModelObject){
    	proxy.setName(((edu.fudan.mylang.pf.INamedModelObject)this).getEntityName());
    }
    return proxy;
    
  }
}
