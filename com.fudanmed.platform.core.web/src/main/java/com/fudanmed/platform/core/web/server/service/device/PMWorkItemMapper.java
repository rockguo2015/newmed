package com.fudanmed.platform.core.web.server.service.device;

import com.fudanmed.platform.core.device.pm.RCPMWorkItem;
import com.fudanmed.platform.core.web.server.service.device.PMWorkItemEvaluateMapper;
import com.fudanmed.platform.core.web.server.service.device.PMWorkItemValidator;
import com.fudanmed.platform.core.web.shared.device.UIPMWorkItem;
import com.uniquesoft.uidl.transform.AbstractEntityMapper;
import com.uniquesoft.uidl.transform.IConvertService;
import edu.fudan.mylang.pf.IObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("com.fudanmed.platform.core.web.server.service.device.PMWorkItemMapper")
public class PMWorkItemMapper extends AbstractEntityMapper<UIPMWorkItem,RCPMWorkItem> {
  @Autowired
  private IConvertService convertService;
  
  @Autowired
  private IObjectFactory entities;
  
  public RCPMWorkItem loadEntityById(final Long id) {
    return entities.get(RCPMWorkItem.class,id);
  }
  
  public RCPMWorkItem create() {
    return entities.create(RCPMWorkItem.class);
  }
  
  @Autowired
  private PMWorkItemEvaluateMapper __PMWorkItemEvaluateMapper__;
  
  @Autowired
  private PMWorkItemValidator validator;
  
  public void copyToEntity(final UIPMWorkItem from, final RCPMWorkItem to) {
    java.util.Collection<com.uniquesoft.gwt.shared.validation.ValidationErrorItem> errors = validator.validate(from);
    if(errors.size()!=0)throw new com.uniquesoft.gwt.shared.validation.ValidationException(errors);					
    to.setVersion(from.getVersion());
    to.setTitle(convertService.toValue(java.lang.String.class,from.getTitle()));
    to.setDescription(convertService.toValue(java.lang.String.class,from.getDescription()));
    to.setAssignDate(convertService.toValue(java.util.Date.class,from.getAssignDate()));
    to.setSupplier(convertService.toValue(com.fudanmed.platform.core.domain.RCSupplier.class,from.getSupplier()));
    convertService.toProxyEntity(from.getAssignments(),to.getAssignments(),com.fudanmed.platform.core.device.pm.RCWorkItemPlanAssignment.class);
    to.setTeam(convertService.toValue(com.fudanmed.platform.core.domain.RCMaintenanceTeam.class,from.getTeam()));
    to.setFinishDate(convertService.toValue(java.util.Date.class,from.getFinishDate()));
    to.setTeamComment(convertService.toValue(java.lang.String.class,from.getTeamComment()));
    convertService.toEntity(from.getEvaluate(),to.getEvaluate(),__PMWorkItemEvaluateMapper__);
    
  }
  
  public UIPMWorkItem copyFromEntity(final UIPMWorkItem result, final RCPMWorkItem entity) {
    if(entity==null) return null;
    result.setId(entity.getId());
    result.setVersion(entity.getVersion());
    result.setProxy(entity.toProxy());
    result.setClazzName(entity.getClass().getName());
    result.setTitle(convertService.toValue(java.lang.String.class,entity.getTitle()));
    result.setDescription(convertService.toValue(java.lang.String.class,entity.getDescription()));
    result.setSid(convertService.toValue(java.lang.String.class,entity.getSid()));
    result.setAssignDate(convertService.toValue(java.util.Date.class,entity.getAssignDate()));
    result.setDispatchDate(convertService.toValue(java.util.Date.class,entity.getDispatchDate()));
    result.setSupplier(convertService.toValue(com.fudanmed.platform.core.domain.proxy.RCSupplierProxy.class,entity.getSupplier()));
    result.setAssignments(convertService.toCollectionValue(com.fudanmed.platform.core.device.pm.proxy.RCWorkItemPlanAssignmentProxy.class,entity.getAssignments()));
    result.setStatus(convertService.toValue(com.fudanmed.platform.core.web.shared.device.UIPMWorkItemStatue.class,entity.getStatus()));
    result.setTeam(convertService.toValue(com.fudanmed.platform.core.domain.proxy.RCMaintenanceTeamProxy.class,entity.getTeam()));
    result.setFinishDate(convertService.toValue(java.util.Date.class,entity.getFinishDate()));
    result.setTeamComment(convertService.toValue(java.lang.String.class,entity.getTeamComment()));
    result.setEvaluate(__PMWorkItemEvaluateMapper__.apply(entity.getEvaluate()));
    buildFromCust(result,entity);
    return result;
    
  }
  
  public UIPMWorkItem buildFrom(final RCPMWorkItem entity) {
    if(entity==null) return null;
    com.fudanmed.platform.core.web.shared.device.UIPMWorkItem result = new com.fudanmed.platform.core.web.shared.device.UIPMWorkItem();
    copyFromEntity(result,entity);	
    return result;
    
  }
  
  protected void buildFromCust(final UIPMWorkItem _gwt, final RCPMWorkItem _entity) {
    Boolean _allWorkerTaskFinished = _entity.allWorkerTaskFinished();
    _gwt.setAllWorkerTaskFinished(_allWorkerTaskFinished);
  }
  
  public Class<?> getUIClass() {
    return UIPMWorkItem.class;
  }
  
  public Class<?> getEntityClass() {
    return RCPMWorkItem.class;
  }
}
