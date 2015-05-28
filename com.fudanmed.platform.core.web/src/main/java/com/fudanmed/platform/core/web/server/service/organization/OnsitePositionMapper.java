package com.fudanmed.platform.core.web.server.service.organization;

import com.fudanmed.platform.core.domain.RCOnsitePosition;
import com.fudanmed.platform.core.web.server.service.organization.OnsitePositionValidator;
import com.fudanmed.platform.core.web.shared.organization.UIOnsitePosition;
import com.uniquesoft.uidl.transform.AbstractEntityMapper;
import com.uniquesoft.uidl.transform.IConvertService;
import edu.fudan.mylang.pf.IObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("com.fudanmed.platform.core.web.server.service.organization.OnsitePositionMapper")
public class OnsitePositionMapper extends AbstractEntityMapper<UIOnsitePosition,RCOnsitePosition> {
  @Autowired
  private IConvertService convertService;
  
  @Autowired
  private IObjectFactory entities;
  
  public RCOnsitePosition loadEntityById(final Long id) {
    return entities.get(RCOnsitePosition.class,id);
  }
  
  public RCOnsitePosition create() {
    return entities.create(RCOnsitePosition.class);
  }
  
  @Autowired
  private OnsitePositionValidator validator;
  
  public void copyToEntity(final UIOnsitePosition from, final RCOnsitePosition to) {
    java.util.Collection<com.uniquesoft.gwt.shared.validation.ValidationErrorItem> errors = validator.validate(from);
    if(errors.size()!=0)throw new com.uniquesoft.gwt.shared.validation.ValidationException(errors);					
    to.setVersion(from.getVersion());
    to.setCode(convertService.toValue(java.lang.String.class,from.getCode()));
    to.setName(convertService.toValue(java.lang.String.class,from.getName()));
    to.setPhone(convertService.toValue(java.lang.String.class,from.getPhone()));
    to.setParent(convertService.toValue(com.fudanmed.platform.core.domain.RCOnsitePosition.class,from.getParent()));
    to.setSimplePy(convertService.toValue(java.lang.String.class,from.getSimplePy()));
    copyToCust(from,to);
    
  }
  
  protected void copyToCust(final UIOnsitePosition _gwt, final RCOnsitePosition _entity) {
    String _fullIdPath = _entity.fullIdPath();
    _entity.setPath(_fullIdPath);
  }
  
  public UIOnsitePosition copyFromEntity(final UIOnsitePosition result, final RCOnsitePosition entity) {
    if(entity==null) return null;
    result.setId(entity.getId());
    result.setVersion(entity.getVersion());
    result.setProxy(entity.toProxy());
    result.setClazzName(entity.getClass().getName());
    result.setCode(convertService.toValue(java.lang.String.class,entity.getCode()));
    result.setName(convertService.toValue(java.lang.String.class,entity.getName()));
    result.setPhone(convertService.toValue(java.lang.String.class,entity.getPhone()));
    result.setParent(convertService.toValue(com.fudanmed.platform.core.domain.proxy.RCOnsitePositionProxy.class,entity.getParent()));
    result.setSimplePy(convertService.toValue(java.lang.String.class,entity.getSimplePy()));
    buildFromCust(result,entity);
    return result;
    
  }
  
  public UIOnsitePosition buildFrom(final RCOnsitePosition entity) {
    if(entity==null) return null;
    com.fudanmed.platform.core.web.shared.organization.UIOnsitePosition result = new com.fudanmed.platform.core.web.shared.organization.UIOnsitePosition();
    copyFromEntity(result,entity);	
    return result;
    
  }
  
  protected void buildFromCust(final UIOnsitePosition _gwt, final RCOnsitePosition _entity) {
    String _fullPath = _entity.fullPath();
    _gwt.setFullPath(_fullPath);
  }
  
  public Class<?> getUIClass() {
    return UIOnsitePosition.class;
  }
  
  public Class<?> getEntityClass() {
    return RCOnsitePosition.class;
  }
}
