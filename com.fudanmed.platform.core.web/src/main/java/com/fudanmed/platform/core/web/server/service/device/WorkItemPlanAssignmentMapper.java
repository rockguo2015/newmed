package com.fudanmed.platform.core.web.server.service.device;

import com.fudanmed.platform.core.device.pm.RCPMWorkItemWorkerAssignment;
import com.fudanmed.platform.core.device.pm.RCWorkItemPlanAssignment;
import com.fudanmed.platform.core.domain.RCEmployee;
import com.fudanmed.platform.core.domain.proxy.RCEmployeeProxy;
import com.fudanmed.platform.core.web.shared.device.UIWorkItemPlanAssignment;
import com.google.common.base.Objects;
import com.uniquesoft.uidl.transform.AbstractEntityMapper;
import com.uniquesoft.uidl.transform.IConvertService;
import edu.fudan.mylang.pf.IObjectFactory;
import java.util.Collection;
import java.util.List;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("com.fudanmed.platform.core.web.server.service.device.WorkItemPlanAssignmentMapper")
public class WorkItemPlanAssignmentMapper extends AbstractEntityMapper<UIWorkItemPlanAssignment,RCWorkItemPlanAssignment> {
  @Autowired
  private IConvertService convertService;
  
  @Autowired
  private IObjectFactory entities;
  
  public RCWorkItemPlanAssignment loadEntityById(final Long id) {
    return entities.get(RCWorkItemPlanAssignment.class,id);
  }
  
  public RCWorkItemPlanAssignment create() {
    return entities.create(RCWorkItemPlanAssignment.class);
  }
  
  public void copyToEntity(final UIWorkItemPlanAssignment from, final RCWorkItemPlanAssignment to) {
    to.setVersion(from.getVersion());
    to.getPlan().setComment(convertService.toValue(java.lang.String.class,from.getComment()));
    
  }
  
  public UIWorkItemPlanAssignment copyFromEntity(final UIWorkItemPlanAssignment result, final RCWorkItemPlanAssignment entity) {
    if(entity==null) return null;
    result.setId(entity.getId());
    result.setVersion(entity.getVersion());
    result.setProxy(entity.toProxy());
    result.setClazzName(entity.getClass().getName());
    if(entity. getPlan()  != null &&entity. getPlan().getSpec()  != null &&entity. getPlan().getSpec().getDevice()  != null )
    	result.setSid(convertService.toValue(java.lang.String.class,entity.getPlan().getSpec().getDevice().getSid()));
    if(entity. getPlan()  != null &&entity. getPlan().getSpec()  != null &&entity. getPlan().getSpec().getDevice()  != null )
    	result.setName(convertService.toValue(java.lang.String.class,entity.getPlan().getSpec().getDevice().getName()));
    if(entity. getPlan()  != null &&entity. getPlan().getSpec()  != null &&entity. getPlan().getSpec().getDevice()  != null )
    	result.setSpecification(convertService.toValue(java.lang.String.class,entity.getPlan().getSpec().getDevice().getSpecification()));
    if(entity. getPlan()  != null &&entity. getPlan().getSpec()  != null &&entity. getPlan().getSpec().getDevice()  != null )
    	result.setLocation(convertService.toValue(com.fudanmed.platform.core.domain.proxy.RCOnsitePositionProxy.class,entity.getPlan().getSpec().getDevice().getLocation()));
    if(entity. getPlan()  != null &&entity. getPlan().getSpec()  != null &&entity. getPlan().getSpec().getDevice()  != null )
    	result.setDeviceType(convertService.toValue(com.fudanmed.platform.core.device.proxy.RCDeviceTypeProxy.class,entity.getPlan().getSpec().getDevice().getDeviceType()));
    if(entity. getPlan()  != null &&entity. getPlan().getSpec()  != null )
    	result.setPmType(convertService.toValue(com.fudanmed.platform.core.device.pm.proxy.RCDevicePMTypeProxy.class,entity.getPlan().getSpec().getPmType()));
    if(entity. getPlan()  != null &&entity. getPlan().getSpec()  != null )
    	result.setIntervalInDays(convertService.toValue(java.lang.Integer.class,entity.getPlan().getSpec().getIntervalInDays()));
    if(entity. getPlan()  != null )
    	result.setPlanDate(convertService.toValue(java.util.Date.class,entity.getPlan().getPlanDate()));
    if(entity. getPlan()  != null )
    	result.setFinishDate(convertService.toValue(java.util.Date.class,entity.getPlan().getFinishDate()));
    if(entity. getPlan()  != null &&entity. getPlan().getSpec()  != null )
    	result.setPmComment(convertService.toValue(java.lang.String.class,entity.getPlan().getSpec().getDescription()));
    if(entity. getPlan()  != null )
    	result.setSmstatus(convertService.toValue(com.fudanmed.platform.core.web.shared.device.UIDevicePMPlanStatus.class,entity.getPlan().getStatus()));
    if(entity. getWorkitem()  != null )
    	result.setTeam(convertService.toValue(com.fudanmed.platform.core.domain.proxy.RCMaintenanceTeamProxy.class,entity.getWorkitem().getTeam()));
    if(entity. getPlan()  != null )
    	result.setComment(convertService.toValue(java.lang.String.class,entity.getPlan().getComment()));
    buildFromCust(result,entity);
    return result;
    
  }
  
  public UIWorkItemPlanAssignment buildFrom(final RCWorkItemPlanAssignment entity) {
    if(entity==null) return null;
    com.fudanmed.platform.core.web.shared.device.UIWorkItemPlanAssignment result = new com.fudanmed.platform.core.web.shared.device.UIWorkItemPlanAssignment();
    copyFromEntity(result,entity);	
    return result;
    
  }
  
  protected void buildFromCust(final UIWorkItemPlanAssignment _gwt, final RCWorkItemPlanAssignment _entity) {
    RCPMWorkItemWorkerAssignment _workerAssignment = _entity.getWorkerAssignment();
    boolean _notEquals = (!Objects.equal(_workerAssignment, null));
    if (_notEquals) {
      RCPMWorkItemWorkerAssignment _workerAssignment_1 = _entity.getWorkerAssignment();
      Collection<RCEmployee> _workers = _workerAssignment_1.getWorkers();
      final Function1<RCEmployee,RCEmployeeProxy> _function = new Function1<RCEmployee,RCEmployeeProxy>() {
          public RCEmployeeProxy apply(final RCEmployee it) {
            RCEmployeeProxy _proxy = it.toProxy();
            return _proxy;
          }
        };
      Iterable<RCEmployeeProxy> _map = IterableExtensions.<RCEmployee, RCEmployeeProxy>map(_workers, _function);
      List<RCEmployeeProxy> _list = IterableExtensions.<RCEmployeeProxy>toList(_map);
      _gwt.setWorkers(_list);
    }
  }
  
  public Class<?> getUIClass() {
    return UIWorkItemPlanAssignment.class;
  }
  
  public Class<?> getEntityClass() {
    return RCWorkItemPlanAssignment.class;
  }
}
