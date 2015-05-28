package com.fudanmed.platform.core.web.server.service.organization;

import com.fudanmed.platform.core.domain.RCOrganization;
import com.fudanmed.platform.core.web.server.service.organization.OnsitePositionMapper;
import com.fudanmed.platform.core.web.server.service.organization.OrganizationValidator;
import com.fudanmed.platform.core.web.shared.organization.UIOrganization;
import com.uniquesoft.uidl.transform.AbstractEntityMapper;
import com.uniquesoft.uidl.transform.IConvertService;
import edu.fudan.mylang.pf.IObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("com.fudanmed.platform.core.web.server.service.organization.OrganizationMapper")
public class OrganizationMapper extends AbstractEntityMapper<UIOrganization,RCOrganization> {
  @Autowired
  private IConvertService convertService;
  
  @Autowired
  private IObjectFactory entities;
  
  public RCOrganization loadEntityById(final Long id) {
    return entities.get(RCOrganization.class,id);
  }
  
  public RCOrganization create() {
    return entities.create(RCOrganization.class);
  }
  
  @Autowired
  private OnsitePositionMapper __OnsitePositionMapper__;
  
  @Autowired
  private OrganizationValidator validator;
  
  public void copyToEntity(final UIOrganization from, final RCOrganization to) {
    java.util.Collection<com.uniquesoft.gwt.shared.validation.ValidationErrorItem> errors = validator.validate(from);
    if(errors.size()!=0)throw new com.uniquesoft.gwt.shared.validation.ValidationException(errors);					
    to.setVersion(from.getVersion());
    to.setCode(convertService.toValue(java.lang.String.class,from.getCode()));
    to.setName(convertService.toValue(java.lang.String.class,from.getName()));
    to.setSimplePy(convertService.toValue(java.lang.String.class,from.getSimplePy()));
    to.setParent(convertService.toValue(com.fudanmed.platform.core.domain.RCOrganization.class,from.getParent()));
    convertService.toRefEntity(from.getPositions(),to.getPositions(),__OnsitePositionMapper__);
    
  }
  
  public UIOrganization copyFromEntity(final UIOrganization result, final RCOrganization entity) {
    if(entity==null) return null;
    result.setId(entity.getId());
    result.setVersion(entity.getVersion());
    result.setProxy(entity.toProxy());
    result.setClazzName(entity.getClass().getName());
    result.setCode(convertService.toValue(java.lang.String.class,entity.getCode()));
    result.setName(convertService.toValue(java.lang.String.class,entity.getName()));
    result.setSimplePy(convertService.toValue(java.lang.String.class,entity.getSimplePy()));
    result.setParent(convertService.toValue(com.fudanmed.platform.core.domain.proxy.RCOrganizationProxy.class,entity.getParent()));
    result.setPositions(convertService.toGwtEntity(entity.getPositions(),__OnsitePositionMapper__));
    	result.setPositionsProxy(convertService.toCollectionValue(com.fudanmed.platform.core.domain.proxy.RCOnsitePositionProxy.class,entity.getPositions()));
    buildFromCust(result,entity);
    return result;
    
  }
  
  public UIOrganization buildFrom(final RCOrganization entity) {
    if(entity==null) return null;
    com.fudanmed.platform.core.web.shared.organization.UIOrganization result = new com.fudanmed.platform.core.web.shared.organization.UIOrganization();
    copyFromEntity(result,entity);	
    return result;
    
  }
  
  protected void buildFromCust(final UIOrganization _gwt, final RCOrganization _entity) {
    String _fullPath = _entity.fullPath();
    _gwt.setFullPath(_fullPath);
  }
  
  public Class<?> getUIClass() {
    return UIOrganization.class;
  }
  
  public Class<?> getEntityClass() {
    return RCOrganization.class;
  }
}
