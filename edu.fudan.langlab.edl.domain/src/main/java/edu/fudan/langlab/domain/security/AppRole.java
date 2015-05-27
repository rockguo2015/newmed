package edu.fudan.langlab.domain.security;

import edu.fudan.mylang.pf.BaseDataType;

public class AppRole extends BaseDataType {
  public AppRole() {
    super();
  }
  
  private String roleId;
  
  public String getRoleId() {
    return this.roleId;
  }
  
  public AppRole setRoleId(final String roleId) {
    this.roleId = roleId;
    return this;			
    
  }
  
  private String name;
  
  public String getName() {
    return this.name;
  }
  
  public AppRole setName(final String name) {
    this.name = name;
    return this;			
    
  }
  
  public static AppRole create() {
    return new AppRole();
    
    
  }
}
