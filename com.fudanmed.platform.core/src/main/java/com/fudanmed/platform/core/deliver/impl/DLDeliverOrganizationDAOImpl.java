package com.fudanmed.platform.core.deliver.impl;

import com.fudanmed.platform.core.deliver.DLDeliverOrganization;
import com.fudanmed.platform.core.deliver.DLDeliverOrganizationDAO;
import com.fudanmed.platform.core.deliver.events.DLDeliverOrganizationEventsManager;
import com.fudanmed.platform.core.deliver.impl.DLDeliverOrganizationImpl;
import edu.fudan.mylang.pf.BaseDAOService;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("com.fudanmed.platform.core.deliver.DLDeliverOrganizationDAO")
public class DLDeliverOrganizationDAOImpl extends BaseDAOService<DLDeliverOrganization> implements DLDeliverOrganizationDAO {
  @Autowired
  private DLDeliverOrganizationEventsManager eventsManager;
  
  public DLDeliverOrganization create(final Procedure1<? super DLDeliverOrganization> init) {DLDeliverOrganization dLDeliverOrganization=DLDeliverOrganizationImpl.create(getObjectFactory());
    final Procedure1<DLDeliverOrganization> _function = new Procedure1<DLDeliverOrganization>() {
        public void apply(final DLDeliverOrganization it) {
          init.apply(it);
          DLDeliverOrganizationDAOImpl.this.eventsManager.fireCreated(it);
        }
      };
    DLDeliverOrganization _doubleArrow = ObjectExtensions.<DLDeliverOrganization>operator_doubleArrow(dLDeliverOrganization, _function);
    return _doubleArrow;
  }
  
  public void delete(final DLDeliverOrganization value) {getObjectFactory().delete(value);
    
    this.eventsManager.fireDeleted(value);
  }
}
