package com.fudanmed.platform.core.domain;

import com.fudanmed.platform.core.domain.RCEmployeeUser;
import edu.fudan.langlab.domain.security.User;
import edu.fudan.mylang.pf.IBaseService;

public interface RCSecurityService extends IBaseService {
  public abstract RCEmployeeUser employeeUserLogin(final String userid, final String passwd);
  
  public abstract User userLogin(final String userid, final String passwd);
  
  public abstract RCEmployeeUser asEmployeeUser(final String userid);
}
