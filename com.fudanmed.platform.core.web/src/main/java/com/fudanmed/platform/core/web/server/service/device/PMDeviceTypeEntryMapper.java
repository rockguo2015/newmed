package com.fudanmed.platform.core.web.server.service.device;

import com.fudanmed.platform.core.device.pm.RCPMDeviceTypeEntry;
import com.fudanmed.platform.core.web.server.service.device.PMDefaultIntervalAssociationMapper;
import com.fudanmed.platform.core.web.server.service.device.PMDeviceTypeEntryValidator;
import com.fudanmed.platform.core.web.shared.device.UIPMDeviceTypeEntry;
import com.uniquesoft.uidl.transform.AbstractEntityMapper;
import com.uniquesoft.uidl.transform.IConvertService;
import edu.fudan.mylang.pf.IObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("com.fudanmed.platform.core.web.server.service.device.PMDeviceTypeEntryMapper")
public class PMDeviceTypeEntryMapper extends AbstractEntityMapper<UIPMDeviceTypeEntry,RCPMDeviceTypeEntry> {
  @Autowired
  private IConvertService convertService;
  
  @Autowired
  private IObjectFactory entities;
  
  public RCPMDeviceTypeEntry loadEntityById(final Long id) {
    return entities.get(RCPMDeviceTypeEntry.class,id);
  }
  
  public RCPMDeviceTypeEntry create() {
    return entities.create(RCPMDeviceTypeEntry.class);
  }
  
  @Autowired
  private PMDefaultIntervalAssociationMapper __PMDefaultIntervalAssociationMapper__;
  
  @Autowired
  private PMDeviceTypeEntryValidator validator;
  
  public void copyToEntity(final UIPMDeviceTypeEntry from, final RCPMDeviceTypeEntry to) {
    java.util.Collection<com.uniquesoft.gwt.shared.validation.ValidationErrorItem> errors = validator.validate(from);
    if(errors.size()!=0)throw new com.uniquesoft.gwt.shared.validation.ValidationException(errors);					
    to.setVersion(from.getVersion());
    convertService.toPartEntity(from.getIntervals(),to.getIntervals(),__PMDefaultIntervalAssociationMapper__,to);
    
  }
  
  public UIPMDeviceTypeEntry copyFromEntity(final UIPMDeviceTypeEntry result, final RCPMDeviceTypeEntry entity) {
    if(entity==null) return null;
    result.setId(entity.getId());
    result.setVersion(entity.getVersion());
    result.setProxy(entity.toProxy());
    result.setClazzName(entity.getClass().getName());
    result.setIntervals(convertService.toGwtEntity(entity.getIntervals(),__PMDefaultIntervalAssociationMapper__));
    return result;
    
  }
  
  public UIPMDeviceTypeEntry buildFrom(final RCPMDeviceTypeEntry entity) {
    if(entity==null) return null;
    com.fudanmed.platform.core.web.shared.device.UIPMDeviceTypeEntry result = new com.fudanmed.platform.core.web.shared.device.UIPMDeviceTypeEntry();
    copyFromEntity(result,entity);	
    return result;
    
  }
  
  public Class<?> getUIClass() {
    return UIPMDeviceTypeEntry.class;
  }
  
  public Class<?> getEntityClass() {
    return RCPMDeviceTypeEntry.class;
  }
}
