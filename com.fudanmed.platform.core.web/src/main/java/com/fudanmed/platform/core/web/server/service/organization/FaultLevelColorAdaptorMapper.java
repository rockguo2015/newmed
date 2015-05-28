package com.fudanmed.platform.core.web.server.service.organization;

import com.fudanmed.platform.core.common.RCFaultLevelColorAdaptor;
import com.fudanmed.platform.core.web.shared.organization.UIFaultLevelColorAdaptor;
import com.uniquesoft.uidl.transform.AbstractEntityMapper;
import com.uniquesoft.uidl.transform.IConvertService;
import edu.fudan.mylang.pf.IObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("com.fudanmed.platform.core.web.server.service.organization.FaultLevelColorAdaptorMapper")
public class FaultLevelColorAdaptorMapper extends AbstractEntityMapper<UIFaultLevelColorAdaptor,RCFaultLevelColorAdaptor> {
  @Autowired
  private IConvertService convertService;
  
  @Autowired
  private IObjectFactory entities;
  
  public RCFaultLevelColorAdaptor loadEntityById(final Long id) {
    return entities.get(RCFaultLevelColorAdaptor.class,id);
  }
  
  public RCFaultLevelColorAdaptor create() {
    return entities.create(RCFaultLevelColorAdaptor.class);
  }
  
  public void copyToEntity(final UIFaultLevelColorAdaptor from, final RCFaultLevelColorAdaptor to) {
    to.setVersion(from.getVersion());
    to.setColor(convertService.toValue(com.fudanmed.platform.core.common.RCStandardColor.class,from.getColor()));
    to.setFaultLevel(convertService.toValue(com.fudanmed.platform.core.common.RCFaultLevel.class,from.getFaultLevel()));
    
  }
  
  public UIFaultLevelColorAdaptor copyFromEntity(final UIFaultLevelColorAdaptor result, final RCFaultLevelColorAdaptor entity) {
    if(entity==null) return null;
    result.setId(entity.getId());
    result.setVersion(entity.getVersion());
    result.setProxy(entity.toProxy());
    result.setClazzName(entity.getClass().getName());
    result.setColor(convertService.toValue(com.fudanmed.platform.core.web.shared.organization.UIStandardColor.class,entity.getColor()));
    result.setFaultLevel(convertService.toValue(com.fudanmed.platform.core.common.proxy.RCFaultLevelProxy.class,entity.getFaultLevel()));
    return result;
    
  }
  
  public UIFaultLevelColorAdaptor buildFrom(final RCFaultLevelColorAdaptor entity) {
    if(entity==null) return null;
    com.fudanmed.platform.core.web.shared.organization.UIFaultLevelColorAdaptor result = new com.fudanmed.platform.core.web.shared.organization.UIFaultLevelColorAdaptor();
    copyFromEntity(result,entity);	
    return result;
    
  }
  
  public Class<?> getUIClass() {
    return UIFaultLevelColorAdaptor.class;
  }
  
  public Class<?> getEntityClass() {
    return RCFaultLevelColorAdaptor.class;
  }
}
