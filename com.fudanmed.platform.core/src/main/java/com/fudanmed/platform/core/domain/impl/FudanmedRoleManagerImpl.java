package com.fudanmed.platform.core.domain.impl;

import edu.fudan.langlab.domain.organization.RoleManager;
import edu.fudan.langlab.domain.security.AppRole;
import edu.fudan.langlab.domain.security.SecurityService;
import edu.fudan.mylang.pf.BaseService;
import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("com.fudanmed.platform.core.domain.FudanmedRoleManager")
public class FudanmedRoleManagerImpl extends BaseService implements RoleManager {
  @Autowired
  private SecurityService securityService;
  
  public Collection<AppRole> getAllRoles() {
    Collection<AppRole> _allRoles = this.securityService.getAllRoles();
    return _allRoles;
  }
}
