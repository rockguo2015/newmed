package com.fudanmed.platform.core.domain.impl;

import com.fudanmed.platform.core.domain.RCEmployee;
import com.fudanmed.platform.core.domain.RCEmployeeUser;
import com.fudanmed.platform.core.domain.RCSecurityService;
import com.google.common.base.Objects;
import edu.fudan.langlab.domain.security.User;
import edu.fudan.mylang.pf.BaseService;
import edu.fudan.mylang.pf.IGenericQuery;
import org.springframework.stereotype.Service;

@Service("com.fudanmed.platform.core.domain.RCSecurityService")
public class RCSecurityServiceImpl extends BaseService implements RCSecurityService {
  public RCEmployeeUser employeeUserLogin(final String userid, final String passwd) {
    RCEmployeeUser _xblockexpression = null;
    {
      IGenericQuery<RCEmployeeUser> query=getObjectFactory().createGenericQuery(RCEmployeeUser.class,"select u from com.fudanmed.platform.core.domain.impl.RCEmployeeUserImpl as u   where ((u.userid = :userid) and (u.passwd = :passwd)) and  u.active = 1      ").setParameter("userid",userid).setParameter("passwd",passwd);
      final RCEmployeeUser u = query.uniqueResult();
      RCEmployeeUser _xifexpression = null;
      boolean _and = false;
      boolean _notEquals = (!Objects.equal(u, null));
      if (!_notEquals) {
        _and = false;
      } else {
        RCEmployee _employee = u.getEmployee();
        Boolean _isLeaveJob = _employee.isLeaveJob();
        boolean _not = (!_isLeaveJob);
        _and = (_notEquals && _not);
      }
      if (_and) {
        _xifexpression = u;
      } else {
        _xifexpression = null;
      }
      _xblockexpression = (_xifexpression);
    }
    return _xblockexpression;
  }
  
  public User userLogin(final String userid, final String passwd) {
    RCEmployeeUser _employeeUserLogin = this.employeeUserLogin(userid, passwd);
    return _employeeUserLogin;
  }
  
  public RCEmployeeUser asEmployeeUser(final String userid) {
    IGenericQuery<RCEmployeeUser> query=getObjectFactory().createGenericQuery(RCEmployeeUser.class,"select u from com.fudanmed.platform.core.domain.impl.RCEmployeeUserImpl as u   where (u.userid = :userid) and  u.active = 1      ").setParameter("userid",userid);
    RCEmployeeUser _uniqueResult = query.uniqueResult();
    return _uniqueResult;
  }
}
