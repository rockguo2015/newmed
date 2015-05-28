package com.fudanmed.platform.core.web.server.service.project;

import com.fudanmed.platform.core.domain.RCMaintenanceTeam;
import com.fudanmed.platform.core.web.shared.project.UIMaintenanceTeam;
import com.uniquesoft.uidl.transform.AbstractEntityMapper;
import com.uniquesoft.uidl.transform.IConvertService;
import edu.fudan.mylang.pf.IObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("com.fudanmed.platform.core.web.server.service.project.MaintenanceTeamMapper")
public class MaintenanceTeamMapper extends AbstractEntityMapper<UIMaintenanceTeam,RCMaintenanceTeam> {
  @Autowired
  private IConvertService convertService;
  
  @Autowired
  private IObjectFactory entities;
  
  public RCMaintenanceTeam loadEntityById(final Long id) {
    return entities.get(RCMaintenanceTeam.class,id);
  }
  
  public RCMaintenanceTeam create() {
    return entities.create(RCMaintenanceTeam.class);
  }
  
  public void copyToEntity(final UIMaintenanceTeam from, final RCMaintenanceTeam to) {
    to.setVersion(from.getVersion());
    to.setOrganization(convertService.toValue(com.fudanmed.platform.core.domain.RCOrganization.class,from.getOrganization()));
    
  }
  
  public UIMaintenanceTeam copyFromEntity(final UIMaintenanceTeam result, final RCMaintenanceTeam entity) {
    if(entity==null) return null;
    result.setId(entity.getId());
    result.setVersion(entity.getVersion());
    result.setProxy(entity.toProxy());
    result.setClazzName(entity.getClass().getName());
    result.setOrganization(convertService.toValue(com.fudanmed.platform.core.domain.proxy.RCOrganizationProxy.class,entity.getOrganization()));
    return result;
    
  }
  
  public UIMaintenanceTeam buildFrom(final RCMaintenanceTeam entity) {
    if(entity==null) return null;
    com.fudanmed.platform.core.web.shared.project.UIMaintenanceTeam result = new com.fudanmed.platform.core.web.shared.project.UIMaintenanceTeam();
    copyFromEntity(result,entity);	
    return result;
    
  }
  
  public Class<?> getUIClass() {
    return UIMaintenanceTeam.class;
  }
  
  public Class<?> getEntityClass() {
    return RCMaintenanceTeam.class;
  }
}
