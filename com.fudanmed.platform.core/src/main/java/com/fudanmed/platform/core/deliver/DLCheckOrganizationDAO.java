package com.fudanmed.platform.core.deliver;

import com.fudanmed.platform.core.deliver.DLCheckOrganization;
import edu.fudan.mylang.pf.IDAOService;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

public interface DLCheckOrganizationDAO extends IDAOService<DLCheckOrganization> {
  public abstract DLCheckOrganization create(final Procedure1<? super DLCheckOrganization> init);
  
  public abstract void delete(final DLCheckOrganization value);
}
