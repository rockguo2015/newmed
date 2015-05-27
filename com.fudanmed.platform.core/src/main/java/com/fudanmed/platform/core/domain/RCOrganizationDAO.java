package com.fudanmed.platform.core.domain;

import com.fudanmed.platform.core.domain.RCOrganization;
import edu.fudan.mylang.pf.IBaseService;
import org.eclipse.xtext.xbase.lib.Functions.Function1;

public interface RCOrganizationDAO extends IBaseService {
  public abstract RCOrganization findByCode(final String code);
  
  public abstract RCOrganization createOrganization(final RCOrganization parent, final Function1<? super RCOrganization,? extends RCOrganization> preinit);
  
  public abstract void deleteOrganization(final RCOrganization organization);
}
