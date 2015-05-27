package com.fudanmed.platform.core.web.server.service.login.impl;

import com.fudanmed.platform.core.domain.RCEmployee;
import com.fudanmed.platform.core.domain.RCEmployeeUser;
import com.fudanmed.platform.core.domain.RCOrganization;
import com.fudanmed.platform.core.domain.RCRepairReportUser;
import com.uniquesoft.gwt.server.service.common.HttpRequestThreadLocal;
import edu.fudan.langlab.domain.organization.Party;
import edu.fudan.langlab.domain.security.ISystemUserService;
import edu.fudan.langlab.domain.security.User;
import edu.fudan.mylang.pf.BaseService;
import edu.fudan.mylang.pf.IObjectFactory;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("com.fudanmed.platform.core.web.server.service.login.SystemUserService")
public class SystemUserServiceImpl extends BaseService implements ISystemUserService {
  @Autowired
  private IObjectFactory objectFactory;
  
  public User getCurrentUser() {
    User _xblockexpression = null;
    {
      HttpServletRequest req = HttpRequestThreadLocal.get();
      HttpSession _session = req.getSession();
      Object _attribute = _session.getAttribute("__userid__");
      Long userid = ((Long) _attribute);
      User _get = this.objectFactory.<User>get(User.class, userid);
      _xblockexpression = (_get);
    }
    return _xblockexpression;
  }
  
  public void setCurrentUser(final User user) {
    HttpServletRequest req = HttpRequestThreadLocal.get();
    HttpSession _session = req.getSession();
    Long _id = user.getId();
    _session.setAttribute("__userid__", _id);
  }
  
  public Party getCurrentUserAsParty() {
    Party _xblockexpression = null;
    {
      HttpServletRequest req = HttpRequestThreadLocal.get();
      HttpSession _session = req.getSession();
      Object _attribute = _session.getAttribute("__userid__");
      Long userid = ((Long) _attribute);
      User user = this.objectFactory.<User>get(User.class, userid);
      Party _switchResult = null;
      boolean _matched = false;
      if (!_matched) {
        if (user instanceof RCEmployeeUser) {
          final RCEmployeeUser _rCEmployeeUser = (RCEmployeeUser)user;
          _matched=true;
          RCEmployee _employee = _rCEmployeeUser.getEmployee();
          _switchResult = _employee;
        }
      }
      if (!_matched) {
        if (user instanceof RCRepairReportUser) {
          final RCRepairReportUser _rCRepairReportUser = (RCRepairReportUser)user;
          _matched=true;
          RCOrganization _organization = _rCRepairReportUser.getOrganization();
          _switchResult = _organization;
        }
      }
      _xblockexpression = (_switchResult);
    }
    return _xblockexpression;
  }
}
