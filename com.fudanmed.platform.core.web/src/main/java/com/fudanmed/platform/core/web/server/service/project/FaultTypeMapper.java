package com.fudanmed.platform.core.web.server.service.project;

import com.fudanmed.platform.core.domain.RCFaultType;
import com.fudanmed.platform.core.domain.RCMaintenanceTeam;
import com.fudanmed.platform.core.web.server.service.project.FaultTypeValidator;
import com.fudanmed.platform.core.web.shared.project.UIFaultType;
import com.uniquesoft.gwt.shared.extensions.StringExtensions;
import com.uniquesoft.uidl.transform.AbstractEntityMapper;
import com.uniquesoft.uidl.transform.IConvertService;
import edu.fudan.mylang.pf.IObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("com.fudanmed.platform.core.web.server.service.project.FaultTypeMapper")
public class FaultTypeMapper extends AbstractEntityMapper<UIFaultType,RCFaultType> {
  @Autowired
  private IConvertService convertService;
  
  @Autowired
  private IObjectFactory entities;
  
  public RCFaultType loadEntityById(final Long id) {
    return entities.get(RCFaultType.class,id);
  }
  
  public RCFaultType create() {
    return entities.create(RCFaultType.class);
  }
  
  @Autowired
  private FaultTypeValidator validator;
  
  public void copyToEntity(final UIFaultType from, final RCFaultType to) {
    java.util.Collection<com.uniquesoft.gwt.shared.validation.ValidationErrorItem> errors = validator.validate(from);
    if(errors.size()!=0)throw new com.uniquesoft.gwt.shared.validation.ValidationException(errors);					
    to.setVersion(from.getVersion());
    to.setName(convertService.toValue(java.lang.String.class,from.getName()));
    to.setStandardCostTime(convertService.toValue(java.lang.Double.class,from.getStandardCostTime()));
    to.setPerformanceWeight(convertService.toValue(java.lang.Double.class,from.getPerformanceWeight()));
    to.setFaultRiskLevel(convertService.toValue(com.fudanmed.platform.core.common.RCFaultLevel.class,from.getFaultRiskLevel()));
    to.setTeam(convertService.toValue(com.fudanmed.platform.core.domain.RCMaintenanceTeam.class,from.getTeam()));
    to.setWorkType(convertService.toValue(com.fudanmed.platform.core.common.RCWorkType.class,from.getWorkType()));
    to.setNeedAudit(convertService.toValue(java.lang.Boolean.class,from.getNeedAudit()));
    copyToCust(from,to);
    
  }
  
  protected void copyToCust(final UIFaultType _gwt, final RCFaultType _entity) {
    _entity.buildPath();
  }
  
  public UIFaultType copyFromEntity(final UIFaultType result, final RCFaultType entity) {
    if(entity==null) return null;
    result.setId(entity.getId());
    result.setVersion(entity.getVersion());
    result.setProxy(entity.toProxy());
    result.setClazzName(entity.getClass().getName());
    result.setName(convertService.toValue(java.lang.String.class,entity.getName()));
    result.setStandardCostTime(convertService.toValue(java.lang.Double.class,entity.getStandardCostTime()));
    result.setPerformanceWeight(convertService.toValue(java.lang.Double.class,entity.getPerformanceWeight()));
    result.setFaultRiskLevel(convertService.toValue(com.fudanmed.platform.core.common.proxy.RCFaultLevelProxy.class,entity.getFaultRiskLevel()));
    result.setTeam(convertService.toValue(com.fudanmed.platform.core.domain.proxy.RCMaintenanceTeamProxy.class,entity.getTeam()));
    result.setMtype(convertService.toValue(com.fudanmed.platform.core.domain.proxy.RCMaintenamceTypeProxy.class,entity.getMtype()));
    result.setWorkType(convertService.toValue(com.fudanmed.platform.core.common.proxy.RCWorkTypeProxy.class,entity.getWorkType()));
    result.setNeedAudit(convertService.toValue(java.lang.Boolean.class,entity.getNeedAudit()));
    buildFromCust(result,entity);
    return result;
    
  }
  
  public UIFaultType buildFrom(final RCFaultType entity) {
    if(entity==null) return null;
    com.fudanmed.platform.core.web.shared.project.UIFaultType result = new com.fudanmed.platform.core.web.shared.project.UIFaultType();
    copyFromEntity(result,entity);	
    return result;
    
  }
  
  protected void buildFromCust(final UIFaultType _gwt, final RCFaultType _entity) {
    RCMaintenanceTeam _team = _entity.getTeam();
    String _entityName = _team==null?(String)null:_team.getEntityName();
    String _nullsafe = StringExtensions.nullsafe(_entityName);
    _gwt.setTeamName(_nullsafe);
  }
  
  public Class<?> getUIClass() {
    return UIFaultType.class;
  }
  
  public Class<?> getEntityClass() {
    return RCFaultType.class;
  }
}
