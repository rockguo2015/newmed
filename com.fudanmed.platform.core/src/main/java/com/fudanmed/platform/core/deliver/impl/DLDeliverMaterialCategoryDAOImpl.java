package com.fudanmed.platform.core.deliver.impl;

import com.fudanmed.platform.core.deliver.DLDeliverMaterialCategory;
import com.fudanmed.platform.core.deliver.DLDeliverMaterialCategoryDAO;
import com.fudanmed.platform.core.deliver.events.DLDeliverMaterialCategoryEventsManager;
import com.fudanmed.platform.core.deliver.impl.DLDeliverMaterialCategoryImpl;
import edu.fudan.mylang.common.HierarchyExtensions;
import edu.fudan.mylang.pf.BaseDAOService;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("com.fudanmed.platform.core.deliver.DLDeliverMaterialCategoryDAO")
public class DLDeliverMaterialCategoryDAOImpl extends BaseDAOService<DLDeliverMaterialCategory> implements DLDeliverMaterialCategoryDAO {
  @Autowired
  private DLDeliverMaterialCategoryEventsManager eventsManager;
  
  public DLDeliverMaterialCategory create(final DLDeliverMaterialCategory parent, final Procedure1<? super DLDeliverMaterialCategory> init) {DLDeliverMaterialCategory dLDeliverMaterialCategory=DLDeliverMaterialCategoryImpl.create(parent,getObjectFactory());
    final Procedure1<DLDeliverMaterialCategory> _function = new Procedure1<DLDeliverMaterialCategory>() {
        public void apply(final DLDeliverMaterialCategory it) {
          init.apply(it);
          HierarchyExtensions.updateFullIdPath(it);
          it.checkValid();
          DLDeliverMaterialCategoryDAOImpl.this.eventsManager.fireCreated(it);
        }
      };
    DLDeliverMaterialCategory _doubleArrow = ObjectExtensions.<DLDeliverMaterialCategory>operator_doubleArrow(dLDeliverMaterialCategory, _function);
    return _doubleArrow;
  }
  
  public void delete(final DLDeliverMaterialCategory value) {getObjectFactory().delete(value);
    
    this.eventsManager.fireDeleted(value);
  }
}
