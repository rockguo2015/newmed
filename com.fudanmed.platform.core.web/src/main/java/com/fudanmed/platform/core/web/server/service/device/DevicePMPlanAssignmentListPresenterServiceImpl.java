package com.fudanmed.platform.core.web.server.service.device;

import com.fudanmed.platform.core.device.RCDevice;
import com.fudanmed.platform.core.device.pm.RCWorkItemPlanAssignment;
import com.fudanmed.platform.core.device.pm.RCWorkItemPlanAssignmentDAO;
import com.fudanmed.platform.core.device.proxy.RCDeviceProxy;
import com.fudanmed.platform.core.web.client.device.DevicePMPlanAssignmentListPresenterService;
import com.fudanmed.platform.core.web.server.service.device.WorkItemPlanAssignmentMapper;
import com.fudanmed.platform.core.web.shared.device.UIWorkItemPlanAssignment;
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

@Service("com.fudanmed.platform.core.web.client.device.DevicePMPlanAssignmentListPresenterService")
@Transactional
public class DevicePMPlanAssignmentListPresenterServiceImpl extends BaseService implements DevicePMPlanAssignmentListPresenterService {
  @Autowired
  private IObjectFactory entities;
  
  @Autowired
  private WorkItemPlanAssignmentMapper mapper;
  
  @Autowired
  private RCWorkItemPlanAssignmentDAO dao;
  
  public Collection<UIWorkItemPlanAssignment> loadDevicePlanAssignmentList(final RCDeviceProxy context) throws SessionTimeOutException, ValidationException {
    RCDevice _resolved= null;
    if(context!=null) _resolved=(com.fudanmed.platform.core.device.RCDevice)com.uniquesoft.uidl.extensions.ModelObjects.resolve(context, entities);
    
    Collection<RCWorkItemPlanAssignment> _findByDevice = this.dao.findByDevice( _resolved);
    final Function1<RCWorkItemPlanAssignment,UIWorkItemPlanAssignment> _function = new Function1<RCWorkItemPlanAssignment,UIWorkItemPlanAssignment>() {
        public UIWorkItemPlanAssignment apply(final RCWorkItemPlanAssignment it) {
          UIWorkItemPlanAssignment _transform = DevicePMPlanAssignmentListPresenterServiceImpl.this.mapper.transform(it);
          return _transform;
        }
      };
    Iterable<UIWorkItemPlanAssignment> _map = IterableExtensions.<RCWorkItemPlanAssignment, UIWorkItemPlanAssignment>map(_findByDevice, _function);
    Collection<UIWorkItemPlanAssignment> _unlazy = IterableExtensions2.<UIWorkItemPlanAssignment>unlazy(_map);
    return _unlazy;
  }
}
