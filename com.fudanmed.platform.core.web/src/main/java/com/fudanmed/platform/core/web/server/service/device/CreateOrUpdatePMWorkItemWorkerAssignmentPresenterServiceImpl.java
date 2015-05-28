package com.fudanmed.platform.core.web.server.service.device;

import com.fudanmed.platform.core.device.pm.RCPMWorkItem;
import com.fudanmed.platform.core.device.pm.RCPMWorkItemWorkerAssignment;
import com.fudanmed.platform.core.device.pm.RCWorkItemPlanAssignment;
import com.fudanmed.platform.core.device.pm.proxy.RCPMWorkItemProxy;
import com.fudanmed.platform.core.device.pm.proxy.RCPMWorkItemWorkerAssignmentProxy;
import com.fudanmed.platform.core.domain.RCMaintenanceTeam;
import com.fudanmed.platform.core.domain.RCOrganization;
import com.fudanmed.platform.core.domain.proxy.RCOrganizationProxy;
import com.fudanmed.platform.core.web.client.device.CreateOrUpdatePMWorkItemWorkerAssignmentPresenterService;
import com.fudanmed.platform.core.web.server.service.device.PMWorkItemWorkerAssignmentMapper;
import com.fudanmed.platform.core.web.shared.device.UIPMWorkItemWorkerAssignment;
import com.fudanmed.platform.core.web.shared.device.UIWorkItemPlanAssignment;
import com.uniquesoft.gwt.server.service.common.BaseService;
import com.uniquesoft.gwt.shared.SessionTimeOutException;
import com.uniquesoft.gwt.shared.validation.ValidationException;
import edu.fudan.mylang.pf.IObjectFactory;
import java.util.Collection;
import java.util.List;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("com.fudanmed.platform.core.web.client.device.CreateOrUpdatePMWorkItemWorkerAssignmentPresenterService")
@Transactional
public class CreateOrUpdatePMWorkItemWorkerAssignmentPresenterServiceImpl extends BaseService implements CreateOrUpdatePMWorkItemWorkerAssignmentPresenterService {
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
    
    this.mapper.transform(uivalue,  _resolved);
  }
  
  public RCPMWorkItemWorkerAssignmentProxy createValue(final Collection<UIWorkItemPlanAssignment> planAssignments, final RCPMWorkItemProxy parent, final UIPMWorkItemWorkerAssignment uivalue) throws SessionTimeOutException, ValidationException {
    RCPMWorkItemWorkerAssignmentProxy _xblockexpression = null;
    {
      final Collection<RCPMWorkItemWorkerAssignment> results = CollectionLiterals.<RCPMWorkItemWorkerAssignment>newArrayList();
      RCPMWorkItem _resolved= null;
      if(parent!=null) _resolved=(com.fudanmed.platform.core.device.pm.RCPMWorkItem)com.uniquesoft.uidl.extensions.ModelObjects.resolve(parent, entities);
      
      final Function1<UIWorkItemPlanAssignment,RCWorkItemPlanAssignment> _function = new Function1<UIWorkItemPlanAssignment,RCWorkItemPlanAssignment>() {
          public RCWorkItemPlanAssignment apply(final UIWorkItemPlanAssignment it) {
            RCWorkItemPlanAssignment _resolved= null;
            if(it!=null) _resolved=(com.fudanmed.platform.core.device.pm.RCWorkItemPlanAssignment)com.uniquesoft.uidl.extensions.ModelObjects.resolve(it, entities);
            
            return  _resolved;
          }
        };
      Iterable<RCWorkItemPlanAssignment> _map = IterableExtensions.<UIWorkItemPlanAssignment, RCWorkItemPlanAssignment>map(planAssignments, _function);
      List<RCWorkItemPlanAssignment> _list = IterableExtensions.<RCWorkItemPlanAssignment>toList(_map);
      final Procedure1<RCPMWorkItemWorkerAssignment> _function_1 = new Procedure1<RCPMWorkItemWorkerAssignment>() {
          public void apply(final RCPMWorkItemWorkerAssignment it) {
            CreateOrUpdatePMWorkItemWorkerAssignmentPresenterServiceImpl.this.mapper.transform(uivalue, it);
            results.add(it);
          }
        };
       _resolved.assignWorker(_list, _function_1);
      RCPMWorkItemWorkerAssignment _head = IterableExtensions.<RCPMWorkItemWorkerAssignment>head(results);
      RCPMWorkItemWorkerAssignmentProxy _proxy = _head.toProxy();
      _xblockexpression = (_proxy);
    }
    return _xblockexpression;
  }
  
  public RCOrganizationProxy loadTeamOrg4WorkItem(final RCPMWorkItemProxy value) throws SessionTimeOutException, ValidationException {
    RCPMWorkItem _resolved= null;
    if(value!=null) _resolved=(com.fudanmed.platform.core.device.pm.RCPMWorkItem)com.uniquesoft.uidl.extensions.ModelObjects.resolve(value, entities);
    
    RCMaintenanceTeam _team =  _resolved.getTeam();
    RCOrganization _organization = _team.getOrganization();
    RCOrganizationProxy _proxy = _organization.toProxy();
    return _proxy;
  }
  
  public RCOrganizationProxy loadTeamOrg4Assignment(final RCPMWorkItemWorkerAssignmentProxy value) throws SessionTimeOutException, ValidationException {
    RCPMWorkItemWorkerAssignment _resolved= null;
    if(value!=null) _resolved=(com.fudanmed.platform.core.device.pm.RCPMWorkItemWorkerAssignment)com.uniquesoft.uidl.extensions.ModelObjects.resolve(value, entities);
    
    RCPMWorkItem _workitem =  _resolved.getWorkitem();
    RCMaintenanceTeam _team = _workitem.getTeam();
    RCOrganization _organization = _team.getOrganization();
    RCOrganizationProxy _proxy = _organization.toProxy();
    return _proxy;
  }
}
