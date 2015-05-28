package com.fudanmed.platform.core.web.server.service.device;

import com.fudanmed.platform.core.device.pm.RCPMWorkItem;
import com.fudanmed.platform.core.device.pm.RCPMWorkItemWorkerAssignment;
import com.fudanmed.platform.core.device.pm.proxy.RCPMWorkItemProxy;
import com.fudanmed.platform.core.web.client.device.PMWorkItemWorkerAssignmentListPresenterService;
import com.fudanmed.platform.core.web.server.service.device.PMWorkItemWorkerAssignmentMapper;
import com.fudanmed.platform.core.web.shared.device.UIPMWorkItemWorkerAssignment;
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

@Service("com.fudanmed.platform.core.web.client.device.PMWorkItemWorkerAssignmentListPresenterService")
@Transactional
public class PMWorkItemWorkerAssignmentListPresenterServiceImpl extends BaseService implements PMWorkItemWorkerAssignmentListPresenterService {
  @Autowired
  private IObjectFactory entities;
  
  @Autowired
  private PMWorkItemWorkerAssignmentMapper mapper;
  
  public Collection<UIPMWorkItemWorkerAssignment> loadPMWorkItemWorkerAssignmentList(final RCPMWorkItemProxy context) throws SessionTimeOutException, ValidationException {
    RCPMWorkItem _resolved= null;
    if(context!=null) _resolved=(com.fudanmed.platform.core.device.pm.RCPMWorkItem)com.uniquesoft.uidl.extensions.ModelObjects.resolve(context, entities);
    
    Collection<RCPMWorkItemWorkerAssignment> _workerAssignment =  _resolved.getWorkerAssignment();
    final Function1<RCPMWorkItemWorkerAssignment,UIPMWorkItemWorkerAssignment> _function = new Function1<RCPMWorkItemWorkerAssignment,UIPMWorkItemWorkerAssignment>() {
        public UIPMWorkItemWorkerAssignment apply(final RCPMWorkItemWorkerAssignment it) {
          UIPMWorkItemWorkerAssignment _transform = PMWorkItemWorkerAssignmentListPresenterServiceImpl.this.mapper.transform(it);
          return _transform;
        }
      };
    Iterable<UIPMWorkItemWorkerAssignment> _map = IterableExtensions.<RCPMWorkItemWorkerAssignment, UIPMWorkItemWorkerAssignment>map(_workerAssignment, _function);
    Collection<UIPMWorkItemWorkerAssignment> _unlazy = IterableExtensions2.<UIPMWorkItemWorkerAssignment>unlazy(_map);
    return _unlazy;
  }
}
