package com.fudanmed.platform.core.device.pm.impl;

import com.fudanmed.platform.core.device.RCDevice;
import com.fudanmed.platform.core.device.pm.RCWorkItemPlanAssignment;
import com.fudanmed.platform.core.device.pm.RCWorkItemPlanAssignmentDAO;
import edu.fudan.mylang.pf.BaseDAOService;
import edu.fudan.mylang.pf.IGenericQuery;
import java.util.Collection;
import java.util.List;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.springframework.stereotype.Service;

@Service("com.fudanmed.platform.core.device.pm.RCWorkItemPlanAssignmentDAO")
public class RCWorkItemPlanAssignmentDAOImpl extends BaseDAOService<RCWorkItemPlanAssignment> implements RCWorkItemPlanAssignmentDAO {
  public Collection<RCWorkItemPlanAssignment> findByDevice(final RCDevice device) {
    IGenericQuery<RCWorkItemPlanAssignment> query=getObjectFactory().createGenericQuery(RCWorkItemPlanAssignment.class,"select e from com.fudanmed.platform.core.device.pm.impl.RCWorkItemPlanAssignmentImpl as e   where (e.plan.spec.device = :device) and  e.active = 1      ").setParameter("device",device);
    Collection<RCWorkItemPlanAssignment> _list = query.list();
    List<RCWorkItemPlanAssignment> _list_1 = IterableExtensions.<RCWorkItemPlanAssignment>toList(_list);
    return _list_1;
  }
}
