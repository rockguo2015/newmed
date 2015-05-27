package com.fudanmed.platform.core.deliver.impl;

import com.fudanmed.platform.core.deliver.DLCheckOrganization;
import com.fudanmed.platform.core.deliver.DLCheckOrganizationDAO;
import com.fudanmed.platform.core.deliver.events.DLCheckOrganizationEventsManager;
import com.fudanmed.platform.core.deliver.impl.DLCheckOrganizationImpl;
import edu.fudan.mylang.pf.BaseDAOService;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("com.fudanmed.platform.core.deliver.DLCheckOrganizationDAO")
public class DLCheckOrganizationDAOImpl extends BaseDAOService<DLCheckOrganization> implements DLCheckOrganizationDAO {
  @Autowired
  private DLCheckOrganizationEventsManager eventsManager;
  
  public DLCheckOrganization create(final Procedure1<? super DLCheckOrganization> init) {DLCheckOrganization dLCheckOrganization=DLCheckOrganizationImpl.create(getObjectFactory());
    final Procedure1<DLCheckOrganization> _function = new Procedure1<DLCheckOrganization>() {
        public void apply(final DLCheckOrganization it) {
          init.apply(it);
          it.checkValid();
          DLCheckOrganizationDAOImpl.this.eventsManager.fireCreated(it);
        }
      };
    DLCheckOrganization _doubleArrow = ObjectExtensions.<DLCheckOrganization>operator_doubleArrow(dLCheckOrganization, _function);
    return _doubleArrow;
  }
  
  public void delete(final DLCheckOrganization value) {getObjectFactory().delete(value);
    
    this.eventsManager.fireDeleted(value);
  }
}
