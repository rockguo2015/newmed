package com.fudanmed.platform.core.web.server.service.project;

import com.fudanmed.platform.core.domain.RCSettlement;
import com.fudanmed.platform.core.web.server.service.project.SettlementValidator;
import com.fudanmed.platform.core.web.shared.project.UISettlement;
import com.uniquesoft.uidl.transform.AbstractEntityMapper;
import com.uniquesoft.uidl.transform.IConvertService;
import edu.fudan.mylang.pf.IObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("com.fudanmed.platform.core.web.server.service.project.SettlementMapper")
public class SettlementMapper extends AbstractEntityMapper<UISettlement,RCSettlement> {
  @Autowired
  private IConvertService convertService;
  
  @Autowired
  private IObjectFactory entities;
  
  public RCSettlement loadEntityById(final Long id) {
    return entities.get(RCSettlement.class,id);
  }
  
  public RCSettlement create() {
    return entities.create(RCSettlement.class);
  }
  
  @Autowired
  private SettlementValidator validator;
  
  public void copyToEntity(final UISettlement from, final RCSettlement to) {
    java.util.Collection<com.uniquesoft.gwt.shared.validation.ValidationErrorItem> errors = validator.validate(from);
    if(errors.size()!=0)throw new com.uniquesoft.gwt.shared.validation.ValidationException(errors);					
    to.setVersion(from.getVersion());
    to.setFromDate(convertService.toValue(java.util.Date.class,from.getFromDate()));
    to.setToDate(convertService.toValue(java.util.Date.class,from.getToDate()));
    to.setDescription(convertService.toValue(java.lang.String.class,from.getDescription()));
    
  }
  
  public UISettlement copyFromEntity(final UISettlement result, final RCSettlement entity) {
    if(entity==null) return null;
    result.setId(entity.getId());
    result.setVersion(entity.getVersion());
    result.setProxy(entity.toProxy());
    result.setClazzName(entity.getClass().getName());
    result.setSid(convertService.toValue(java.lang.String.class,entity.getSid()));
    result.setDate(convertService.toValue(java.util.Date.class,entity.getDate()));
    result.setFromDate(convertService.toValue(java.util.Date.class,entity.getFromDate()));
    result.setToDate(convertService.toValue(java.util.Date.class,entity.getToDate()));
    result.setDescription(convertService.toValue(java.lang.String.class,entity.getDescription()));
    result.setTotalAmount(convertService.toValue(java.lang.Double.class,entity.getTotalAmount()));
    return result;
    
  }
  
  public UISettlement buildFrom(final RCSettlement entity) {
    if(entity==null) return null;
    com.fudanmed.platform.core.web.shared.project.UISettlement result = new com.fudanmed.platform.core.web.shared.project.UISettlement();
    copyFromEntity(result,entity);	
    return result;
    
  }
  
  public Class<?> getUIClass() {
    return UISettlement.class;
  }
  
  public Class<?> getEntityClass() {
    return RCSettlement.class;
  }
}
