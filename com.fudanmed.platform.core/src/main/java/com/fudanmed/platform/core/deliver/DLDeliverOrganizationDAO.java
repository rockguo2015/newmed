package com.fudanmed.platform.core.deliver;

import com.fudanmed.platform.core.deliver.DLDeliverOrganization;
import edu.fudan.mylang.pf.IDAOService;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

public interface DLDeliverOrganizationDAO extends IDAOService<DLDeliverOrganization> {
  public abstract DLDeliverOrganization create(final Procedure1<? super DLDeliverOrganization> init);
  
  public abstract void delete(final DLDeliverOrganization value);
}
