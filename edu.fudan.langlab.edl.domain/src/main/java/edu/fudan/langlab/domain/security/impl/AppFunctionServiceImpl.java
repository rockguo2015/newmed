package edu.fudan.langlab.domain.security.impl;

import edu.fudan.langlab.domain.security.AppFunction;
import edu.fudan.langlab.domain.security.AppFunctionService;
import edu.fudan.langlab.domain.security.RoleFunctionAssignment;
import edu.fudan.mylang.pf.BaseService;
import edu.fudan.mylang.pf.IGenericQuery;
import java.util.Collection;
import java.util.List;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.springframework.stereotype.Service;

@Service("edu.fudan.langlab.domain.security.AppFunctionService")
public class AppFunctionServiceImpl extends BaseService implements AppFunctionService {
  public Collection<AppFunction> loadAllFunctions4Role(final String roleId) {
    IGenericQuery<RoleFunctionAssignment> query=getObjectFactory().createGenericQuery(RoleFunctionAssignment.class,"select fa from edu.fudan.langlab.domain.security.impl.RoleFunctionAssignmentImpl as fa   where (fa.roleId = :roleId) and  fa.active = 1      ").setParameter("roleId",roleId);
    Collection<RoleFunctionAssignment> _list = query.list();
    final Function1<RoleFunctionAssignment,AppFunction> _function = new Function1<RoleFunctionAssignment,AppFunction>() {
        public AppFunction apply(final RoleFunctionAssignment it) {
          AppFunction _function = it.getFunction();
          return _function;
        }
      };
    Iterable<AppFunction> _map = IterableExtensions.<RoleFunctionAssignment, AppFunction>map(_list, _function);
    List<AppFunction> _list_1 = IterableExtensions.<AppFunction>toList(_map);
    return _list_1;
  }
  
  public Collection<RoleFunctionAssignment> loadAllFunctionAssignments4Role(final String roleId) {
    IGenericQuery<RoleFunctionAssignment> query=getObjectFactory().createGenericQuery(RoleFunctionAssignment.class,"select fa from edu.fudan.langlab.domain.security.impl.RoleFunctionAssignmentImpl as fa   where (fa.roleId = :roleId) and  fa.active = 1      ").setParameter("roleId",roleId);
    Collection<RoleFunctionAssignment> _list = query.list();
    return _list;
  }
}
