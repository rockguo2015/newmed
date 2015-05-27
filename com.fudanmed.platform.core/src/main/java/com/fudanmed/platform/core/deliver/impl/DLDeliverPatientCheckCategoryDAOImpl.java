package com.fudanmed.platform.core.deliver.impl;

import com.fudanmed.platform.core.deliver.DLDeliverPatientCheckCategory;
import com.fudanmed.platform.core.deliver.DLDeliverPatientCheckCategoryDAO;
import com.fudanmed.platform.core.deliver.events.DLDeliverPatientCheckCategoryEventsManager;
import com.fudanmed.platform.core.deliver.impl.DLDeliverPatientCheckCategoryImpl;
import edu.fudan.mylang.common.HierarchyExtensions;
import edu.fudan.mylang.pf.BaseDAOService;
import edu.fudan.mylang.pf.IGenericQuery;
import java.util.Collection;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("com.fudanmed.platform.core.deliver.DLDeliverPatientCheckCategoryDAO")
public class DLDeliverPatientCheckCategoryDAOImpl extends BaseDAOService<DLDeliverPatientCheckCategory> implements DLDeliverPatientCheckCategoryDAO {
  @Autowired
  private DLDeliverPatientCheckCategoryEventsManager eventsManager;
  
  public DLDeliverPatientCheckCategory create(final DLDeliverPatientCheckCategory parent, final Procedure1<? super DLDeliverPatientCheckCategory> init) {DLDeliverPatientCheckCategory dLDeliverPatientCheckCategory=DLDeliverPatientCheckCategoryImpl.create(parent,getObjectFactory());
    final Procedure1<DLDeliverPatientCheckCategory> _function = new Procedure1<DLDeliverPatientCheckCategory>() {
        public void apply(final DLDeliverPatientCheckCategory it) {
          init.apply(it);
          HierarchyExtensions.updateFullIdPath(it);
          it.checkValid();
          DLDeliverPatientCheckCategoryDAOImpl.this.eventsManager.fireCreated(it);
        }
      };
    DLDeliverPatientCheckCategory _doubleArrow = ObjectExtensions.<DLDeliverPatientCheckCategory>operator_doubleArrow(dLDeliverPatientCheckCategory, _function);
    return _doubleArrow;
  }
  
  public void delete(final DLDeliverPatientCheckCategory value) {getObjectFactory().delete(value);
    
    this.eventsManager.fireDeleted(value);
  }
  
  public Collection<DLDeliverPatientCheckCategory> findAll() {IGenericQuery<DLDeliverPatientCheckCategory> query=getObjectFactory().createGenericQuery(DLDeliverPatientCheckCategory.class,"select e from com.fudanmed.platform.core.deliver.impl.DLDeliverPatientCheckCategoryImpl as e   where  e.active = 1  order by e.code ASC    ");
    Collection<DLDeliverPatientCheckCategory> _list = query.list();
    return _list;
  }
}
