package com.fudanmed.platform.core.web.server.service.device;

import com.fudanmed.platform.core.device.pm.RCPMWorkItemWorkerAssignment;
import com.fudanmed.platform.core.web.server.service.device.PMWorkItemWorkerAssignmentValidator;
import com.fudanmed.platform.core.web.shared.device.UIPMWorkItemWorkerAssignment;
import com.uniquesoft.uidl.transform.AbstractEntityMapper;
import com.uniquesoft.uidl.transform.IConvertService;
import edu.fudan.mylang.pf.IObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("com.fudanmed.platform.core.web.server.service.device.PMWorkItemWorkerAssignmentMapper")
public class PMWorkItemWorkerAssignmentMapper extends AbstractEntityMapper<UIPMWorkItemWorkerAssignment,RCPMWorkItemWorkerAssignment> {
  @Autowired
  private IConvertService convertService;
  
  @Autowired
  private IObjectFactory entities;
  
  public RCPMWorkItemWorkerAssignment loadEntityById(final Long id) {
    return entities.get(RCPMWorkItemWorkerAssignment.class,id);
  }
  
  public RCPMWorkItemWorkerAssignment create() {
    return entities.create(RCPMWorkItemWorkerAssignment.class);
  }
  
  @Autowired
  private PMWorkItemWorkerAssignmentValidator validator;
  
  public void copyToEntity(final UIPMWorkItemWorkerAssignment from, final RCPMWorkItemWorkerAssignment to) {
    java.util.Collection<com.uniquesoft.gwt.shared.validation.ValidationErrorItem> errors = validator.validate(from);
    if(errors.size()!=0)throw new com.uniquesoft.gwt.shared.validation.ValidationException(errors);					
    to.setVersion(from.getVersion());
    convertService.toProxyEntity(from.getWorkers(),to.getWorkers(),com.fudanmed.platform.core.domain.RCEmployee.class);
    to.setAssignDate(convertService.toValue(java.util.Date.class,from.getAssignDate()));
    to.setFinishDate(convertService.toValue(java.util.Date.class,from.getFinishDate()));
    to.setComment(convertService.toValue(java.lang.String.class,from.getComment()));
    to.setFinalComment(convertService.toValue(java.lang.String.class,from.getFinalComment()));
    
  }
  
  public UIPMWorkItemWorkerAssignment copyFromEntity(final UIPMWorkItemWorkerAssignment result, final RCPMWorkItemWorkerAssignment entity) {
    if(entity==null) return null;
    result.setId(entity.getId());
    result.setVersion(entity.getVersion());
    result.setProxy(entity.toProxy());
    result.setClazzName(entity.getClass().getName());
    result.setWorkers(convertService.toCollectionValue(com.fudanmed.platform.core.domain.proxy.RCEmployeeProxy.class,entity.getWorkers()));
    result.setAssignDate(convertService.toValue(java.util.Date.class,entity.getAssignDate()));
    result.setFinishDate(convertService.toValue(java.util.Date.class,entity.getFinishDate()));
    result.setComment(convertService.toValue(java.lang.String.class,entity.getComment()));
    result.setFinalComment(convertService.toValue(java.lang.String.class,entity.getFinalComment()));
    result.setStatus(convertService.toValue(com.fudanmed.platform.core.web.shared.device.UIPMWorkItemWorkerAssignmentStatus.class,entity.getStatus()));
    result.setAllTaskFinished(convertService.toValue(java.lang.Boolean.class,entity.getAllTaskFinished()));
    return result;
    
  }
  
  public UIPMWorkItemWorkerAssignment buildFrom(final RCPMWorkItemWorkerAssignment entity) {
    if(entity==null) return null;
    com.fudanmed.platform.core.web.shared.device.UIPMWorkItemWorkerAssignment result = new com.fudanmed.platform.core.web.shared.device.UIPMWorkItemWorkerAssignment();
    copyFromEntity(result,entity);	
    return result;
    
  }
  
  public Class<?> getUIClass() {
    return UIPMWorkItemWorkerAssignment.class;
  }
  
  public Class<?> getEntityClass() {
    return RCPMWorkItemWorkerAssignment.class;
  }
}
