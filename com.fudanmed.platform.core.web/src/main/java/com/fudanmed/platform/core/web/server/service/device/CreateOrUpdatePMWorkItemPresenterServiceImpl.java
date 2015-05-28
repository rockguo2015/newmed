package com.fudanmed.platform.core.web.server.service.device;

import com.fudanmed.platform.core.device.pm.RCDevicePMPlan;
import com.fudanmed.platform.core.device.pm.RCPMWorkItem;
import com.fudanmed.platform.core.device.pm.RCPMWorkItemDAO;
import com.fudanmed.platform.core.device.pm.RCWorkItemPlanAssignment;
import com.fudanmed.platform.core.device.pm.proxy.RCDevicePMPlanProxy;
import com.fudanmed.platform.core.device.pm.proxy.RCPMWorkItemProxy;
import com.fudanmed.platform.core.domain.RCMaintenanceTeam;
import com.fudanmed.platform.core.web.client.device.CreateOrUpdatePMWorkItemPresenterService;
import com.fudanmed.platform.core.web.server.service.device.DevicePMPlanMapper;
import com.fudanmed.platform.core.web.server.service.device.PMWorkItemMapper;
import com.fudanmed.platform.core.web.shared.device.UIDevicePMPlan;
import com.fudanmed.platform.core.web.shared.device.UIPMWorkItem;
import com.google.common.base.Objects;
import com.uniquesoft.gwt.server.service.common.BaseService;
import com.uniquesoft.gwt.shared.SessionTimeOutException;
import com.uniquesoft.gwt.shared.extensions.IterableExtensions2;
import com.uniquesoft.gwt.shared.validation.ValidationException;
import com.uniquesoft.uidl.extensions.ModelObjects;
import edu.fudan.mylang.pf.IObjectFactory;
import java.util.Collection;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("com.fudanmed.platform.core.web.client.device.CreateOrUpdatePMWorkItemPresenterService")
@Transactional
public class CreateOrUpdatePMWorkItemPresenterServiceImpl extends BaseService implements CreateOrUpdatePMWorkItemPresenterService {
  @Autowired
  private IObjectFactory entities;
  
  @Autowired
  private PMWorkItemMapper mapper;
  
  @Autowired
  private DevicePMPlanMapper devicePMPlanMapper;
  
  @Autowired
  private RCPMWorkItemDAO dao;
  
  public UIPMWorkItem loadValue(final RCPMWorkItemProxy pvalue) throws SessionTimeOutException, ValidationException {
    RCPMWorkItem _resolved= null;
    if(pvalue!=null) _resolved=(com.fudanmed.platform.core.device.pm.RCPMWorkItem)com.uniquesoft.uidl.extensions.ModelObjects.resolve(pvalue, entities);
    
    UIPMWorkItem _transform = this.mapper.transform( _resolved);
    return _transform;
  }
  
  public void updateValue(final UIPMWorkItem uivalue) throws SessionTimeOutException, ValidationException {
    RCPMWorkItem _resolved= null;
    if(uivalue!=null) _resolved=(com.fudanmed.platform.core.device.pm.RCPMWorkItem)com.uniquesoft.uidl.extensions.ModelObjects.resolve(uivalue, entities);
    
    final Procedure1<RCPMWorkItem> _function = new Procedure1<RCPMWorkItem>() {
        public void apply(final RCPMWorkItem it) {
          CreateOrUpdatePMWorkItemPresenterServiceImpl.this.mapper.transform(uivalue, it);
          RCMaintenanceTeam _team = it.getTeam();
          boolean _notEquals = (!Objects.equal(_team, null));
          if (_notEquals) {
            it.assignTeam();
          }
        }
      };
    this.dao.update( _resolved, _function);
  }
  
  public Collection<UIDevicePMPlan> resolveDevicePMPlans(final Collection<RCDevicePMPlanProxy> selectedPlans) throws SessionTimeOutException, ValidationException {
    final Function1<RCDevicePMPlanProxy,UIDevicePMPlan> _function = new Function1<RCDevicePMPlanProxy,UIDevicePMPlan>() {
        public UIDevicePMPlan apply(final RCDevicePMPlanProxy it) {
          RCDevicePMPlan _resolve = ModelObjects.<RCDevicePMPlan>resolve(CreateOrUpdatePMWorkItemPresenterServiceImpl.this.entities, it, RCDevicePMPlan.class);
          UIDevicePMPlan _transform = CreateOrUpdatePMWorkItemPresenterServiceImpl.this.devicePMPlanMapper.transform(_resolve);
          return _transform;
        }
      };
    Iterable<UIDevicePMPlan> _map = IterableExtensions.<RCDevicePMPlanProxy, UIDevicePMPlan>map(selectedPlans, _function);
    Collection<UIDevicePMPlan> _unlazy = IterableExtensions2.<UIDevicePMPlan>unlazy(_map);
    return _unlazy;
  }
  
  public Collection<UIDevicePMPlan> loadAssignedDevicePlans(final RCPMWorkItemProxy workItem) throws SessionTimeOutException, ValidationException {
    RCPMWorkItem _resolved= null;
    if(workItem!=null) _resolved=(com.fudanmed.platform.core.device.pm.RCPMWorkItem)com.uniquesoft.uidl.extensions.ModelObjects.resolve(workItem, entities);
    
    Collection<RCWorkItemPlanAssignment> _assignments =  _resolved.getAssignments();
    final Function1<RCWorkItemPlanAssignment,UIDevicePMPlan> _function = new Function1<RCWorkItemPlanAssignment,UIDevicePMPlan>() {
        public UIDevicePMPlan apply(final RCWorkItemPlanAssignment it) {
          RCDevicePMPlan _plan = it.getPlan();
          UIDevicePMPlan _transform = CreateOrUpdatePMWorkItemPresenterServiceImpl.this.devicePMPlanMapper.transform(_plan);
          return _transform;
        }
      };
    Iterable<UIDevicePMPlan> _map = IterableExtensions.<RCWorkItemPlanAssignment, UIDevicePMPlan>map(_assignments, _function);
    Collection<UIDevicePMPlan> _unlazy = IterableExtensions2.<UIDevicePMPlan>unlazy(_map);
    return _unlazy;
  }
  
  public void createValue(final Collection<RCDevicePMPlanProxy> selectedPlans, final UIPMWorkItem uivalue) throws SessionTimeOutException, ValidationException {
    final Procedure1<RCPMWorkItem> _function = new Procedure1<RCPMWorkItem>() {
        public void apply(final RCPMWorkItem workItem) {
          CreateOrUpdatePMWorkItemPresenterServiceImpl.this.mapper.transform(uivalue, workItem);
        }
      };
    RCPMWorkItem _create = this.dao.create(_function);
    final Procedure1<RCPMWorkItem> _function_1 = new Procedure1<RCPMWorkItem>() {
        public void apply(final RCPMWorkItem workItem) {
          final Procedure1<RCDevicePMPlanProxy> _function = new Procedure1<RCDevicePMPlanProxy>() {
              public void apply(final RCDevicePMPlanProxy it) {
                RCDevicePMPlan _resolve = ModelObjects.<RCDevicePMPlan>resolve(CreateOrUpdatePMWorkItemPresenterServiceImpl.this.entities, it, RCDevicePMPlan.class);
                workItem.assignPlan(_resolve);
              }
            };
          IterableExtensions.<RCDevicePMPlanProxy>forEach(selectedPlans, _function);
          RCMaintenanceTeam _team = workItem.getTeam();
          boolean _notEquals = (!Objects.equal(_team, null));
          if (_notEquals) {
            workItem.assignTeam();
          }
        }
      };
    ObjectExtensions.<RCPMWorkItem>operator_doubleArrow(_create, _function_1);
  }
}
