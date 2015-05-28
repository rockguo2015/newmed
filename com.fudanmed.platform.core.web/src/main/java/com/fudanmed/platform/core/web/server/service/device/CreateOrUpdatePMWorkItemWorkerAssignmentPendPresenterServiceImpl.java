package com.fudanmed.platform.core.web.server.service.device;

import com.fudanmed.platform.core.device.pm.RCPMWorkItem;
import com.fudanmed.platform.core.device.pm.RCPMWorkItemWorkerAssignment;
import com.fudanmed.platform.core.device.pm.RCPMWorkItemWorkerAssignmentStatus;
import com.fudanmed.platform.core.device.pm.proxy.RCPMWorkItemWorkerAssignmentProxy;
import com.fudanmed.platform.core.web.client.device.CreateOrUpdatePMWorkItemWorkerAssignmentPendPresenterService;
import com.fudanmed.platform.core.web.server.service.device.PMWorkItemWorkerAssignmentMapper;
import com.fudanmed.platform.core.web.shared.device.UIPMWorkItemWorkerAssignment;
import com.google.common.base.Objects;
import com.uniquesoft.gwt.server.service.common.BaseService;
import com.uniquesoft.gwt.shared.SessionTimeOutException;
import com.uniquesoft.gwt.shared.validation.ValidationException;
import edu.fudan.mylang.pf.IObjectFactory;
import java.util.Collection;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("com.fudanmed.platform.core.web.client.device.CreateOrUpdatePMWorkItemWorkerAssignmentPendPresenterService")
@Transactional
public class CreateOrUpdatePMWorkItemWorkerAssignmentPendPresenterServiceImpl extends BaseService implements CreateOrUpdatePMWorkItemWorkerAssignmentPendPresenterService {
  @Autowired
  private IObjectFactory entities;
  
  @Autowired
  private PMWorkItemWorkerAssignmentMapper mapper;
  
  public UIPMWorkItemWorkerAssignment loadValue(final RCPMWorkItemWorkerAssignmentProxy pvalue) throws SessionTimeOutException, ValidationException {
    RCPMWorkItemWorkerAssignment _resolved= null;
    if(pvalue!=null) _resolved=(com.fudanmed.platform.core.device.pm.RCPMWorkItemWorkerAssignment)com.uniquesoft.uidl.extensions.ModelObjects.resolve(pvalue, entities);
    
    UIPMWorkItemWorkerAssignment _transform = this.mapper.transform( _resolved);
    return _transform;
  }
  
  public void updateValue(final UIPMWorkItemWorkerAssignment uivalue) throws SessionTimeOutException, ValidationException {
    RCPMWorkItemWorkerAssignment _resolved= null;
    if(uivalue!=null) _resolved=(com.fudanmed.platform.core.device.pm.RCPMWorkItemWorkerAssignment)com.uniquesoft.uidl.extensions.ModelObjects.resolve(uivalue, entities);
    
     _resolved.pend();
    RCPMWorkItemWorkerAssignment _resolved_1= null;
    if(uivalue!=null) _resolved_1=(com.fudanmed.platform.core.device.pm.RCPMWorkItemWorkerAssignment)com.uniquesoft.uidl.extensions.ModelObjects.resolve(uivalue, entities);
    
    this.mapper.transform(uivalue,  _resolved_1);
  }
  
  public Boolean allWorkFinishedExceptThis(final RCPMWorkItemWorkerAssignmentProxy uivalue) throws SessionTimeOutException, ValidationException {
    boolean _xblockexpression = false;
    {
      RCPMWorkItemWorkerAssignment _resolved= null;
      if(uivalue!=null) _resolved=(com.fudanmed.platform.core.device.pm.RCPMWorkItemWorkerAssignment)com.uniquesoft.uidl.extensions.ModelObjects.resolve(uivalue, entities);
      
      final RCPMWorkItemWorkerAssignment workerAssignment =  _resolved;
      RCPMWorkItem _workitem = workerAssignment.getWorkitem();
      Collection<RCPMWorkItemWorkerAssignment> _workerAssignment = _workitem.getWorkerAssignment();
      final Function1<RCPMWorkItemWorkerAssignment,Boolean> _function = new Function1<RCPMWorkItemWorkerAssignment,Boolean>() {
          public Boolean apply(final RCPMWorkItemWorkerAssignment it) {
            boolean _notEquals = (!Objects.equal(it, workerAssignment));
            return Boolean.valueOf(_notEquals);
          }
        };
      Iterable<RCPMWorkItemWorkerAssignment> _filter = IterableExtensions.<RCPMWorkItemWorkerAssignment>filter(_workerAssignment, _function);
      final Function1<RCPMWorkItemWorkerAssignment,Boolean> _function_1 = new Function1<RCPMWorkItemWorkerAssignment,Boolean>() {
          public Boolean apply(final RCPMWorkItemWorkerAssignment it) {
            RCPMWorkItemWorkerAssignmentStatus _status = it.getStatus();
            boolean _equals = Objects.equal(_status, RCPMWorkItemWorkerAssignmentStatus.finished);
            return Boolean.valueOf(_equals);
          }
        };
      boolean _forall = IterableExtensions.<RCPMWorkItemWorkerAssignment>forall(_filter, _function_1);
      _xblockexpression = (_forall);
    }
    return Boolean.valueOf(_xblockexpression);
  }
}
