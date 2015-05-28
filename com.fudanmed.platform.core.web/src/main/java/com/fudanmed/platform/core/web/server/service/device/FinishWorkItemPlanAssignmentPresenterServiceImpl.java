package com.fudanmed.platform.core.web.server.service.device;

import com.fudanmed.platform.core.device.pm.RCDevicePMPlan;
import com.fudanmed.platform.core.device.pm.RCWorkItemPlanAssignment;
import com.fudanmed.platform.core.device.pm.proxy.RCWorkItemPlanAssignmentProxy;
import com.fudanmed.platform.core.web.client.device.FinishWorkItemPlanAssignmentPresenterService;
import com.fudanmed.platform.core.web.shared.device.UIWorkItemPlanAssignmentFinishData;
import com.uniquesoft.gwt.server.service.common.BaseService;
import com.uniquesoft.gwt.shared.SessionTimeOutException;
import com.uniquesoft.gwt.shared.validation.ValidationException;
import edu.fudan.mylang.pf.IObjectFactory;
import java.util.Collection;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("com.fudanmed.platform.core.web.client.device.FinishWorkItemPlanAssignmentPresenterService")
@Transactional
public class FinishWorkItemPlanAssignmentPresenterServiceImpl extends BaseService implements FinishWorkItemPlanAssignmentPresenterService {
  @Autowired
  private IObjectFactory entities;
  
  public void createValue(final UIWorkItemPlanAssignmentFinishData uivalue, final Collection<RCWorkItemPlanAssignmentProxy> parents) throws SessionTimeOutException, ValidationException {
    final Procedure1<RCWorkItemPlanAssignmentProxy> _function = new Procedure1<RCWorkItemPlanAssignmentProxy>() {
        public void apply(final RCWorkItemPlanAssignmentProxy parent) {
          Boolean _finished = uivalue.getFinished();
          if ((_finished).booleanValue()) {
            RCWorkItemPlanAssignment _resolved= null;
            if(parent!=null) _resolved=(com.fudanmed.platform.core.device.pm.RCWorkItemPlanAssignment)com.uniquesoft.uidl.extensions.ModelObjects.resolve(parent, entities);
            
            RCDevicePMPlan _plan =  _resolved.getPlan();
            String _comment = uivalue.getComment();
            _plan.finish(_comment);
          } else {
            RCWorkItemPlanAssignment _resolved_1= null;
            if(parent!=null) _resolved_1=(com.fudanmed.platform.core.device.pm.RCWorkItemPlanAssignment)com.uniquesoft.uidl.extensions.ModelObjects.resolve(parent, entities);
            
            RCDevicePMPlan _plan_1 =  _resolved_1.getPlan();
            String _comment_1 = uivalue.getComment();
            _plan_1.reportInfo(_comment_1);
          }
        }
      };
    IterableExtensions.<RCWorkItemPlanAssignmentProxy>forEach(parents, _function);
  }
}
