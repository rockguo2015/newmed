package com.fudanmed.platform.core.domain.rest;

import edu.fudan.mylang.pf.BaseDataType;

public class LoginResult extends BaseDataType {
  public LoginResult() {
    super();
  }
  
  private String userName;
  
  public String getUserName() {
    return this.userName;
  }
  
  public LoginResult setUserName(final String userName) {
    this.userName = userName;
    return this;			
    
  }
  
  private String hospitalName;
  
  public String getHospitalName() {
    return this.hospitalName;
  }
  
  public LoginResult setHospitalName(final String hospitalName) {
    this.hospitalName = hospitalName;
    return this;			
    
  }
  
  private String department;
  
  public String getDepartment() {
    return this.department;
  }
  
  public LoginResult setDepartment(final String department) {
    this.department = department;
    return this;			
    
  }
  
  private String roles;
  
  public String getRoles() {
    return this.roles;
  }
  
  public LoginResult setRoles(final String roles) {
    this.roles = roles;
    return this;			
    
  }
  
  public static LoginResult create() {
    return new LoginResult();
    
    
  }
}
