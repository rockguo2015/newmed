package com.fudanmed.platform.core.web.server.service.device;

import com.fudanmed.platform.core.device.pm.RCDevicePMPlan;
import com.fudanmed.platform.core.device.pm.RCPMWorkItem;
import com.fudanmed.platform.core.device.pm.RCPMWorkItemWorkerAssignment;
import com.fudanmed.platform.core.device.pm.RCWorkItemPlanAssignment;
import com.fudanmed.platform.core.device.pm.proxy.RCPMWorkItemProxy;
import com.fudanmed.platform.core.device.pm.proxy.RCPMWorkItemWorkerAssignmentProxy;
import com.fudanmed.platform.core.web.client.device.WorkItemPlanAssignmentListPresenterService;
import com.fudanmed.platform.core.web.server.service.device.WorkItemPlanAssignmentMapper;
import com.fudanmed.platform.core.web.shared.device.UIWorkItemPlanAssignment;
import com.google.common.base.Objects;
import com.uniquesoft.gwt.server.service.common.BaseService;
import com.uniquesoft.gwt.shared.SessionTimeOutException;
import com.uniquesoft.gwt.shared.extensions.IterableExtensions2;
import com.uniquesoft.gwt.shared.validation.ValidationException;
import edu.fudan.mylang.pf.IObjectFactory;
import java.util.Collection;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("com.fudanmed.platform.core.web.client.device.WorkItemPlanAssignmentListPresenterService")
@Transactional
public class WorkItemPlanAssignmentListPresenterServiceImpl extends BaseService implements WorkItemPlanAssignmentListPresenterService {
  @Autowired
  private IObjectFactory entities;
  
  @Autowired
  private WorkItemPlanAssignmentMapper mapper;
  
  public Collection<UIWorkItemPlanAssignment> loadWorkItemPlanAssignmentList(final RCPMWorkItemProxy context) throws SessionTimeOutException, ValidationException {
    RCPMWorkItem _resolved= null;
    if(context!=null) _resolved=(com.fudanmed.platform.core.device.pm.RCPMWorkItem)com.uniquesoft.uidl.extensions.ModelObjects.resolve(context, entities);
    
    Collection<RCWorkItemPlanAssignment> _assignments =  _resolved.getAssignments();
    final Function1<RCWorkItemPlanAssignment,UIWorkItemPlanAssignment> _function = new Function1<RCWorkItemPlanAssignment,UIWorkItemPlanAssignment>() {
        public UIWorkItemPlanAssignment apply(final RCWorkItemPlanAssignment it) {
          UIWorkItemPlanAssignment _transform = WorkItemPlanAssignmentListPresenterServiceImpl.this.mapper.transform(it);
          return _transform;
        }
      };
    Iterable<UIWorkItemPlanAssignment> _map = IterableExtensions.<RCWorkItemPlanAssignment, UIWorkItemPlanAssignment>map(_assignments, _function);
    Collection<UIWorkItemPlanAssignment> _unlazy = IterableExtensions2.<UIWorkItemPlanAssignment>unlazy(_map);
    return _unlazy;
  }
  
  public Collection<UIWorkItemPlanAssignment> loadUnassignedWorkItemPlanAssignmentList(final RCPMWorkItemProxy context) throws SessionTimeOutException, ValidationException {
    RCPMWorkItem _resolved= null;
    if(context!=null) _resolved=(com.fudanmed.platform.core.device.pm.RCPMWorkItem)com.uniquesoft.uidl.extensions.ModelObjects.resolve(context, entities);
    
    Collection<RCWorkItemPlanAssignment> _assignments =  _resolved.getAssignments();
    final Function1<RCWorkItemPlanAssignment,Boolean> _function = new Function1<RCWorkItemPlanAssignment,Boolean>() {
        public Boolean apply(final RCWorkItemPlanAssignment it) {
          RCPMWorkItemWorkerAssignment _workerAssignment = it.getWorkerAssignment();
          boolean _equals = Objects.equal(_workerAssignment, null);
          return Boolean.valueOf(_equals);
        }
      };
    Iterable<RCWorkItemPlanAssignment> _filter = IterableExtensions.<RCWorkItemPlanAssignment>filter(_assignments, _function);
    final Function1<RCWorkItemPlanAssignment,UIWorkItemPlanAssignment> _function_1 = new Function1<RCWorkItemPlanAssignment,UIWorkItemPlanAssignment>() {
        public UIWorkItemPlanAssignment apply(final RCWorkItemPlanAssignment it) {
          UIWorkItemPlanAssignment _transform = WorkItemPlanAssignmentListPresenterServiceImpl.this.mapper.transform(it);
          return _transform;
        }
      };
    Iterable<UIWorkItemPlanAssignment> _map = IterableExtensions.<RCWorkItemPlanAssignment, UIWorkItemPlanAssignment>map(_filter, _function_1);
    Collection<UIWorkItemPlanAssignment> _unlazy = IterableExtensions2.<UIWorkItemPlanAssignment>unlazy(_map);
    return _unlazy;
  }
  
  public Collection<UIWorkItemPlanAssignment> loadWorkItemPlanAssignment4WorkerList(final RCPMWorkItemWorkerAssignmentProxy context) throws SessionTimeOutException, ValidationException {
    Collection<UIWorkItemPlanAssignment> _xblockexpression = null;
    {
      RCPMWorkItemWorkerAssignment _resolved= null;
      if(context!=null) _resolved=(com.fudanmed.platform.core.device.pm.RCPMWorkItemWorkerAssignment)com.uniquesoft.uidl.extensions.ModelObjects.resolve(context, entities);
      
      final RCPMWorkItemWorkerAssignment workterssignment =  _resolved;
      RCPMWorkItem _workitem = workterssignment.getWorkitem();
      Collection<RCWorkItemPlanAssignment> _assignments = _workitem.getAssignments();
      final Function1<RCWorkItemPlanAssignment,Boolean> _function = new Function1<RCWorkItemPlanAssignment,Boolean>() {
          public Boolean apply(final RCWorkItemPlanAssignment it) {
            boolean _and = false;
            RCPMWorkItemWorkerAssignment _workerAssignment = it.getWorkerAssignment();
            boolean _equals = Objects.equal(_workerAssignment, workterssignment);
            if (!_equals) {
              _and = false;
            } else {
              RCDevicePMPlan _plan = it.getPlan();
              Boolean _isFinished = _plan.isFinished();
              boolean _not = (!_isFinished);
              _and = (_equals && _not);
            }
            return Boolean.valueOf(_and);
          }
        };
      Iterable<RCWorkItemPlanAssignment> _filter = IterableExtensions.<RCWorkItemPlanAssignment>filter(_assignments, _function);
      final Function1<RCWorkItemPlanAssignment,UIWorkItemPlanAssignment> _function_1 = new Function1<RCWorkItemPlanAssignment,UIWorkItemPlanAssignment>() {
          public UIWorkItemPlanAssignment apply(final RCWorkItemPlanAssignment it) {
            UIWorkItemPlanAssignment _transform = WorkItemPlanAssignmentListPresenterServiceImpl.this.mapper.transform(it);
            return _transform;
          }
        };
      Iterable<UIWorkItemPlanAssignment> _map = IterableExtensions.<RCWorkItemPlanAssignment, UIWorkItemPlanAssignment>map(_filter, _function_1);
      Collection<UIWorkItemPlanAssignment> _unlazy = IterableExtensions2.<UIWorkItemPlanAssignment>unlazy(_map);
      _xblockexpression = (_unlazy);
    }
    return _xblockexpression;
  }
}
