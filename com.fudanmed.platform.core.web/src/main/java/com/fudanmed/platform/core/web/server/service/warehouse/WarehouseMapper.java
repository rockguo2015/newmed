package com.fudanmed.platform.core.web.server.service.warehouse;

import com.fudanmed.platform.core.warehouse.RCWarehouse;
import com.fudanmed.platform.core.web.server.service.warehouse.WarehouseValidator;
import com.fudanmed.platform.core.web.shared.warehouse.UIWarehouse;
import com.uniquesoft.uidl.transform.AbstractEntityMapper;
import com.uniquesoft.uidl.transform.IConvertService;
import edu.fudan.mylang.pf.IObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("com.fudanmed.platform.core.web.server.service.warehouse.WarehouseMapper")
public class WarehouseMapper extends AbstractEntityMapper<UIWarehouse,RCWarehouse> {
  @Autowired
  private IConvertService convertService;
  
  @Autowired
  private IObjectFactory entities;
  
  public RCWarehouse loadEntityById(final Long id) {
    return entities.get(RCWarehouse.class,id);
  }
  
  public RCWarehouse create() {
    return entities.create(RCWarehouse.class);
  }
  
  @Autowired
  private WarehouseValidator validator;
  
  public void copyToEntity(final UIWarehouse from, final RCWarehouse to) {
    java.util.Collection<com.uniquesoft.gwt.shared.validation.ValidationErrorItem> errors = validator.validate(from);
    if(errors.size()!=0)throw new com.uniquesoft.gwt.shared.validation.ValidationException(errors);					
    to.setVersion(from.getVersion());
    to.setName(convertService.toValue(java.lang.String.class,from.getName()));
    to.setLocation(convertService.toValue(java.lang.String.class,from.getLocation()));
    to.setIsMajor(convertService.toValue(java.lang.Boolean.class,from.getIsMajor()));
    convertService.toProxyEntity(from.getStoreManager(),to.getStoreManager(),com.fudanmed.platform.core.domain.RCEmployee.class);
    convertService.toProxyEntity(from.getRelatedTeams(),to.getRelatedTeams(),com.fudanmed.platform.core.domain.RCMaintenanceTeam.class);
    
  }
  
  public UIWarehouse copyFromEntity(final UIWarehouse result, final RCWarehouse entity) {
    if(entity==null) return null;
    result.setId(entity.getId());
    result.setVersion(entity.getVersion());
    result.setProxy(entity.toProxy());
    result.setClazzName(entity.getClass().getName());
    result.setName(convertService.toValue(java.lang.String.class,entity.getName()));
    result.setLocation(convertService.toValue(java.lang.String.class,entity.getLocation()));
    result.setIsMajor(convertService.toValue(java.lang.Boolean.class,entity.getIsMajor()));
    result.setStoreManager(convertService.toCollectionValue(com.fudanmed.platform.core.domain.proxy.RCEmployeeProxy.class,entity.getStoreManager()));
    result.setRelatedTeams(convertService.toCollectionValue(com.fudanmed.platform.core.domain.proxy.RCMaintenanceTeamProxy.class,entity.getRelatedTeams()));
    return result;
    
  }
  
  public UIWarehouse buildFrom(final RCWarehouse entity) {
    if(entity==null) return null;
    com.fudanmed.platform.core.web.shared.warehouse.UIWarehouse result = new com.fudanmed.platform.core.web.shared.warehouse.UIWarehouse();
    copyFromEntity(result,entity);	
    return result;
    
  }
  
  public Class<?> getUIClass() {
    return UIWarehouse.class;
  }
  
  public Class<?> getEntityClass() {
    return RCWarehouse.class;
  }
}
