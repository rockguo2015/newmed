package com.fudanmed.platform.core.web.server.service.device;

import com.fudanmed.platform.core.device.pm.RCPMWorkItem;
import com.fudanmed.platform.core.device.pm.RCPMWorkItemEvaluate;
import com.fudanmed.platform.core.device.pm.RCPMWorkItemStatue;
import com.fudanmed.platform.core.device.pm.RCPMWorkItemWorkerAssignment;
import com.fudanmed.platform.core.device.pm.RCPMWorkItemWorkerAssignmentStatus;
import com.fudanmed.platform.core.device.pm.proxy.RCPMWorkItemWorkerAssignmentProxy;
import com.fudanmed.platform.core.web.client.device.CreateOrUpdatePMWorkItemWorkerAssignmentReportPresenterService;
import com.fudanmed.platform.core.web.server.service.device.PMWorkItemEvaluateMapper;
import com.fudanmed.platform.core.web.server.service.device.PMWorkItemWorkerAssignmentMapper;
import com.fudanmed.platform.core.web.shared.device.UIPMWorkItemEvaluate;
import com.fudanmed.platform.core.web.shared.device.UIPMWorkItemWorkerAssignment;
import com.google.common.base.Objects;
import com.uniquesoft.gwt.server.service.common.BaseService;
import com.uniquesoft.gwt.shared.SessionTimeOutException;
import com.uniquesoft.gwt.shared.validation.ValidationException;
import edu.fudan.mylang.pf.IObjectFactory;
import java.util.Collection;
import java.util.Date;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("com.fudanmed.platform.core.web.client.device.CreateOrUpdatePMWorkItemWorkerAssignmentReportPresenterService")
@Transactional
public class CreateOrUpdatePMWorkItemWorkerAssignmentReportPresenterServiceImpl extends BaseService implements CreateOrUpdatePMWorkItemWorkerAssignmentReportPresenterService {
  @Autowired
  private IObjectFactory entities;
  
  @Autowired
  private PMWorkItemWorkerAssignmentMapper mapper;
  
  @Autowired
  private PMWorkItemEvaluateMapper evaluateMapper;
  
  public UIPMWorkItemWorkerAssignment loadValue(final RCPMWorkItemWorkerAssignmentProxy pvalue) throws SessionTimeOutException, ValidationException {
    RCPMWorkItemWorkerAssignment _resolved= null;
    if(pvalue!=null) _resolved=(com.fudanmed.platform.core.device.pm.RCPMWorkItemWorkerAssignment)com.uniquesoft.uidl.extensions.ModelObjects.resolve(pvalue, entities);
    
    UIPMWorkItemWorkerAssignment _transform = this.mapper.transform( _resolved);
    return _transform;
  }
  
  public void updateValue(final UIPMWorkItemWorkerAssignment uivalue) throws SessionTimeOutException, ValidationException {
    RCPMWorkItemWorkerAssignment _resolved= null;
    if(uivalue!=null) _resolved=(com.fudanmed.platform.core.device.pm.RCPMWorkItemWorkerAssignment)com.uniquesoft.uidl.extensions.ModelObjects.resolve(uivalue, entities);
    
     _resolved.finish();
    RCPMWorkItemWorkerAssignment _resolved_1= null;
    if(uivalue!=null) _resolved_1=(com.fudanmed.platform.core.device.pm.RCPMWorkItemWorkerAssignment)com.uniquesoft.uidl.extensions.ModelObjects.resolve(uivalue, entities);
    
    this.mapper.transform(uivalue,  _resolved_1);
    Boolean _reportWorkItemFinish = uivalue.getReportWorkItemFinish();
    if ((_reportWorkItemFinish).booleanValue()) {
      RCPMWorkItemWorkerAssignment _resolved_2= null;
      if(uivalue!=null) _resolved_2=(com.fudanmed.platform.core.device.pm.RCPMWorkItemWorkerAssignment)com.uniquesoft.uidl.extensions.ModelObjects.resolve(uivalue, entities);
      
      RCPMWorkItem _workitem =  _resolved_2.getWorkitem();
      Date _finishDate = uivalue.getFinishDate();
      String _workItemFinishComment = uivalue.getWorkItemFinishComment();
      _workitem.teamFinish(_finishDate, _workItemFinishComment);
      UIPMWorkItemEvaluate _evaluate = uivalue.getEvaluate();
      RCPMWorkItemWorkerAssignment _resolved_3= null;
      if(uivalue!=null) _resolved_3=(com.fudanmed.platform.core.device.pm.RCPMWorkItemWorkerAssignment)com.uniquesoft.uidl.extensions.ModelObjects.resolve(uivalue, entities);
      
      RCPMWorkItem _workitem_1 =  _resolved_3.getWorkitem();
      RCPMWorkItemEvaluate _evaluate_1 = _workitem_1.getEvaluate();
      this.evaluateMapper.transform(_evaluate, _evaluate_1);
    }
  }
  
  public Boolean allWorkFinishedExceptThis(final RCPMWorkItemWorkerAssignmentProxy uivalue) throws SessionTimeOutException, ValidationException {
    boolean _xblockexpression = false;
    {
      RCPMWorkItemWorkerAssignment _resolved= null;
      if(uivalue!=null) _resolved=(com.fudanmed.platform.core.device.pm.RCPMWorkItemWorkerAssignment)com.uniquesoft.uidl.extensions.ModelObjects.resolve(uivalue, entities);
      
      final RCPMWorkItemWorkerAssignment workerAssignment =  _resolved;
      boolean _and = false;
      RCPMWorkItem _workitem = workerAssignment.getWorkitem();
      RCPMWorkItemStatue _status = _workitem.getStatus();
      boolean _equals = Objects.equal(_status, RCPMWorkItemStatue.executing);
      if (!_equals) {
        _and = false;
      } else {
        RCPMWorkItem _workitem_1 = workerAssignment.getWorkitem();
        Collection<RCPMWorkItemWorkerAssignment> _workerAssignment = _workitem_1.getWorkerAssignment();
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
        _and = (_equals && _forall);
      }
      _xblockexpression = (_and);
    }
    return Boolean.valueOf(_xblockexpression);
  }
}
