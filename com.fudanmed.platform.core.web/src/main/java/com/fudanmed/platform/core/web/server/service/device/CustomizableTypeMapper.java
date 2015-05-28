package com.fudanmed.platform.core.web.server.service.device;

import com.fudanmed.platform.core.entityextension.RCCustomizableType;
import com.fudanmed.platform.core.entityextension.RCNumberWithUnitType;
import com.fudanmed.platform.core.web.shared.device.UICustomizableType;
import com.uniquesoft.uidl.transform.AbstractEntityMapper;
import com.uniquesoft.uidl.transform.IConvertService;
import edu.fudan.mylang.pf.IObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("com.fudanmed.platform.core.web.server.service.device.CustomizableTypeMapper")
public class CustomizableTypeMapper extends AbstractEntityMapper<UICustomizableType,RCCustomizableType> {
  @Autowired
  private IConvertService convertService;
  
  @Autowired
  private IObjectFactory entities;
  
  public RCCustomizableType loadEntityById(final Long id) {
    return entities.get(RCCustomizableType.class,id);
  }
  
  public RCCustomizableType create() {
    return entities.create(RCCustomizableType.class);
  }
  
  public void copyToEntity(final UICustomizableType from, final RCCustomizableType to) {
    to.setVersion(from.getVersion());
    
  }
  
  public UICustomizableType copyFromEntity(final UICustomizableType result, final RCCustomizableType entity) {
    if(entity==null) return null;
    result.setId(entity.getId());
    result.setVersion(entity.getVersion());
    result.setProxy(entity.toProxy());
    result.setClazzName(entity.getClass().getName());
    result.setTypeName(convertService.toValue(java.lang.String.class,entity.getTypeName()));
    result.setAlias(convertService.toValue(java.lang.String.class,entity.getAlias()));
    buildFromCust(result,entity);
    return result;
    
  }
  
  public UICustomizableType buildFrom(final RCCustomizableType entity) {
    if(entity==null) return null;
    com.fudanmed.platform.core.web.shared.device.UICustomizableType result = new com.fudanmed.platform.core.web.shared.device.UICustomizableType();
    copyFromEntity(result,entity);	
    return result;
    
  }
  
  protected void buildFromCust(final UICustomizableType _gwt, final RCCustomizableType _entity) {
    _gwt.setIsPrimary(Boolean.valueOf((_entity instanceof RCNumberWithUnitType)));
  }
  
  public Class<?> getUIClass() {
    return UICustomizableType.class;
  }
  
  public Class<?> getEntityClass() {
    return RCCustomizableType.class;
  }
}
