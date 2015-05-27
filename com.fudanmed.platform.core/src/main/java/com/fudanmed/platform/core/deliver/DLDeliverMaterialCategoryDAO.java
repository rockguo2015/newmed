package com.fudanmed.platform.core.deliver;

import com.fudanmed.platform.core.deliver.DLDeliverMaterialCategory;
import edu.fudan.mylang.pf.IDAOService;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

public interface DLDeliverMaterialCategoryDAO extends IDAOService<DLDeliverMaterialCategory> {
  public abstract DLDeliverMaterialCategory create(final DLDeliverMaterialCategory parent, final Procedure1<? super DLDeliverMaterialCategory> init);
  
  public abstract void delete(final DLDeliverMaterialCategory value);
}
