package com.fudanmed.platform.core.web.server.service.device;

import com.fudanmed.platform.core.device.pm.RCDevicePMPlan;
import com.fudanmed.platform.core.device.pm.RCPMWorkItem;
import com.fudanmed.platform.core.device.pm.RCPMWorkItemSMState;
import com.fudanmed.platform.core.device.pm.RCWorkItemPlanAssignment;
import com.fudanmed.platform.core.device.pm.proxy.RCWorkItemPlanAssignmentProxy;
import com.fudanmed.platform.core.web.client.device.RemoveWorkItemPlanAssignmentCommandService;
import com.google.common.base.Objects;
import com.uniquesoft.gwt.server.service.common.BaseService;
import com.uniquesoft.gwt.shared.SessionTimeOutException;
import com.uniquesoft.gwt.shared.validation.ValidationException;
import com.uniquesoft.uidl.validation.Validates;
import edu.fudan.mylang.pf.IObjectFactory;
import java.util.Collection;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("com.fudanmed.platform.core.web.client.device.RemoveWorkItemPlanAssignmentCommandService")
@Transactional
public class RemoveWorkItemPlanAssignmentCommandServiceImpl extends BaseService implements RemoveWorkItemPlanAssignmentCommandService {
  @Autowired
  private IObjectFactory entities;
  
  public void removeAssignment(final Collection<RCWorkItemPlanAssignmentProxy> assignments) throws SessionTimeOutException, ValidationException {
    RCWorkItemPlanAssignmentProxy _head = IterableExtensions.<RCWorkItemPlanAssignmentProxy>head(assignments);
    RCWorkItemPlanAssignment _resolved= null;
    if(_head!=null) _resolved=(com.fudanmed.platform.core.device.pm.RCWorkItemPlanAssignment)com.uniquesoft.uidl.extensions.ModelObjects.resolve(_head, entities);
    
    final RCPMWorkItem workitem =  _resolved.getWorkitem();
    RCPMWorkItemSMState _sMState = workitem.getSMState();
    boolean _equals = Objects.equal(_sMState, RCPMWorkItemSMState.planed);
    Validates.Assert(_equals, "PM\u4EFB\u52A1\u6D3E\u53D1\u540E\u4E0D\u80FD\u4FEE\u6539");
    final Procedure1<RCWorkItemPlanAssignmentProxy> _function = new Procedure1<RCWorkItemPlanAssignmentProxy>() {
        public void apply(final RCWorkItemPlanAssignmentProxy assignment) {
          RCWorkItemPlanAssignment _resolved= null;
          if(assignment!=null) _resolved=(com.fudanmed.platform.core.device.pm.RCWorkItemPlanAssignment)com.uniquesoft.uidl.extensions.ModelObjects.resolve(assignment, entities);
          
          RCPMWorkItem _workitem =  _resolved.getWorkitem();
          RCWorkItemPlanAssignment _resolved_1= null;
          if(assignment!=null) _resolved_1=(com.fudanmed.platform.core.device.pm.RCWorkItemPlanAssignment)com.uniquesoft.uidl.extensions.ModelObjects.resolve(assignment, entities);
          
          RCDevicePMPlan _plan =  _resolved_1.getPlan();
          _workitem.deassignPlan(_plan);
        }
      };
    IterableExtensions.<RCWorkItemPlanAssignmentProxy>forEach(assignments, _function);
  }
}
