package com.fudanmed.platform.core.domain.impl;

import com.fudanmed.platform.core.domain.RCEmployee;
import com.fudanmed.platform.core.domain.RCEmployeeDAO;
import com.fudanmed.platform.core.domain.RCEmployeeUser;
import com.fudanmed.platform.core.domain.impl.RCEmployeeImpl;
import com.fudanmed.platform.core.domain.impl.RCEmployeeUserImpl;
import edu.fudan.langlab.domain.security.User;
import edu.fudan.mylang.pf.BaseService;
import edu.fudan.mylang.pf.IGenericQuery;
import java.util.Collection;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.springframework.stereotype.Service;

@Service("com.fudanmed.platform.core.domain.RCEmployeeDAO")
public class RCEmployeeDAOImpl extends BaseService implements RCEmployeeDAO {
  public RCEmployee findByEid(final String eid) {
    IGenericQuery<RCEmployee> query=getObjectFactory().createGenericQuery(RCEmployee.class,"select e from com.fudanmed.platform.core.domain.impl.RCEmployeeImpl as e   where (e.eid = :eid) and  e.active = 1      ").setParameter("eid",eid);
    RCEmployee _uniqueResult = query.uniqueResult();
    return _uniqueResult;
  }
  
  public Collection<RCEmployee> findByName(final String name) {
    IGenericQuery<RCEmployee> query=getObjectFactory().createGenericQuery(RCEmployee.class,"select e from com.fudanmed.platform.core.domain.impl.RCEmployeeImpl as e   where (e.name = :name) and  e.active = 1      ").setParameter("name",name);
    Collection<RCEmployee> _list = query.list();
    return _list;
  }
  
  public Collection<RCEmployee> allOnJobEmployees() {
    Collection<RCEmployee> _xblockexpression = null;
    {
      final boolean isLeaveJob = false;
      IGenericQuery<RCEmployee> query=getObjectFactory().createGenericQuery(RCEmployee.class,"select e from com.fudanmed.platform.core.domain.impl.RCEmployeeImpl as e   where (e.isLeaveJob = :isLeaveJob) and  e.active = 1      ").setParameter("isLeaveJob",isLeaveJob);
      Collection<RCEmployee> _list = query.list();
      _xblockexpression = (_list);
    }
    return _xblockexpression;
  }
  
  public RCEmployee create(final String eid, final Procedure1<? super RCEmployee> preInit) {RCEmployee rCEmployee=RCEmployeeImpl.create(getObjectFactory());
    final Procedure1<RCEmployee> _function = new Procedure1<RCEmployee>() {
        public void apply(final RCEmployee employee) {
          preInit.apply(employee);
          employee.start();RCEmployeeUser rCEmployeeUser=RCEmployeeUserImpl.create(getObjectFactory());
          final Procedure1<RCEmployeeUser> _function = new Procedure1<RCEmployeeUser>() {
              public void apply(final RCEmployeeUser it) {
                it.setUserid(eid);
                it.setPasswd(eid);
                it.setEmployee(employee);
              }
            };
          ObjectExtensions.<RCEmployeeUser>operator_doubleArrow(rCEmployeeUser, _function);
        }
      };
    RCEmployee _doubleArrow = ObjectExtensions.<RCEmployee>operator_doubleArrow(rCEmployee, _function);
    return _doubleArrow;
  }
  
  public void delete(final RCEmployee employee) {
    User _asUser = employee.asUser();getObjectFactory().delete(_asUser);
    getObjectFactory().delete(employee);
    
  }
}
