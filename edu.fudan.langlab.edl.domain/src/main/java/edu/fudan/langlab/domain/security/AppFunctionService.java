package edu.fudan.langlab.domain.security;

import edu.fudan.langlab.domain.security.AppFunction;
import edu.fudan.langlab.domain.security.RoleFunctionAssignment;
import edu.fudan.mylang.pf.IBaseService;
import java.util.Collection;

public interface AppFunctionService extends IBaseService {
  public abstract Collection<AppFunction> loadAllFunctions4Role(final String roleId);
  
  public abstract Collection<RoleFunctionAssignment> loadAllFunctionAssignments4Role(final String roleId);
}
