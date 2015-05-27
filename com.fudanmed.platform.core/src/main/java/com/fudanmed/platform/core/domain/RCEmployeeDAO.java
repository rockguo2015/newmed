package com.fudanmed.platform.core.domain;

import com.fudanmed.platform.core.domain.RCEmployee;
import edu.fudan.mylang.pf.IBaseService;
import java.util.Collection;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

public interface RCEmployeeDAO extends IBaseService {
  public abstract RCEmployee findByEid(final String eid);
  
  public abstract Collection<RCEmployee> findByName(final String name);
  
  public abstract Collection<RCEmployee> allOnJobEmployees();
  
  public abstract RCEmployee create(final String eid, final Procedure1<? super RCEmployee> preInit);
  
  public abstract void delete(final RCEmployee employee);
}
