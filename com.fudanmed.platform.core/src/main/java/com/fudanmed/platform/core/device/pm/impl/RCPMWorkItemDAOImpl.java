package com.fudanmed.platform.core.device.pm.impl;

import com.fudanmed.platform.core.device.RCDevice;
import com.fudanmed.platform.core.device.pm.RCDevicePMPlan;
import com.fudanmed.platform.core.device.pm.RCPMWorkItem;
import com.fudanmed.platform.core.device.pm.RCPMWorkItemDAO;
import com.fudanmed.platform.core.device.pm.RCWorkItemPlanAssignment;
import com.fudanmed.platform.core.device.pm.events.RCPMWorkItemEventsManager;
import com.fudanmed.platform.core.device.pm.impl.RCPMWorkItemImpl;
import edu.fudan.mylang.pf.BaseDAOService;
import edu.fudan.mylang.pf.IGenericQuery;
import java.util.Collection;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("com.fudanmed.platform.core.device.pm.RCPMWorkItemDAO")
public class RCPMWorkItemDAOImpl extends BaseDAOService<RCPMWorkItem> implements RCPMWorkItemDAO {
  @Autowired
  private RCPMWorkItemEventsManager eventsManager;
  
  public RCPMWorkItem create(final Procedure1<? super RCPMWorkItem> preInit) {RCPMWorkItem rCPMWorkItem=RCPMWorkItemImpl.create(getObjectFactory());
    final Procedure1<RCPMWorkItem> _function = new Procedure1<RCPMWorkItem>() {
        public void apply(final RCPMWorkItem it) {
          preInit.apply(it);
          it.start();
          RCPMWorkItemDAOImpl.this.eventsManager.fireCreated(it);
        }
      };
    RCPMWorkItem _doubleArrow = ObjectExtensions.<RCPMWorkItem>operator_doubleArrow(rCPMWorkItem, _function);
    return _doubleArrow;
  }
  
  public void delete(final RCPMWorkItem e, final Procedure1<? super RCPMWorkItem> postAction) {
    Collection<RCWorkItemPlanAssignment> _assignments = e.getAssignments();
    final Procedure1<RCWorkItemPlanAssignment> _function = new Procedure1<RCWorkItemPlanAssignment>() {
        public void apply(final RCWorkItemPlanAssignment it) {
          RCDevicePMPlan _plan = it.getPlan();
          _plan.cancelAssign();
        }
      };
    IterableExtensions.<RCWorkItemPlanAssignment>forEach(_assignments, _function);getObjectFactory().delete(e);
    
    postAction.apply(e);
    this.eventsManager.fireDeleted(e);
  }
  
  public void update(final RCPMWorkItem e, final Procedure1<? super RCPMWorkItem> updator) {
    updator.apply(e);
    this.eventsManager.fireUpdateded(e);
  }
  
  public Collection<RCPMWorkItem> findWorkItem4Device(final RCDevice device) {
    IGenericQuery<RCPMWorkItem> query=getObjectFactory().createGenericQuery(RCPMWorkItem.class,"select  distinct e from com.fudanmed.platform.core.device.pm.impl.RCPMWorkItemImpl as e left join  e.assignments as assignment   where (assignment.plan.spec.device = :device) and  e.active = 1  order by e.assignDate ASC    ").setParameter("device",device);
    Collection<RCPMWorkItem> _list = query.list();
    return _list;
  }
}
