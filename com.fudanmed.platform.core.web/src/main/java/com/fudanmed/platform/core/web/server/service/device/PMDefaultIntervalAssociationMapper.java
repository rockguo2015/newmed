package com.fudanmed.platform.core.web.server.service.device;

import com.fudanmed.platform.core.device.pm.RCPMDefaultIntervalAssociation;
import com.fudanmed.platform.core.device.pm.RCPMDeviceTypeEntry;
import com.fudanmed.platform.core.web.server.service.device.PMDefaultIntervalAssociationValidator;
import com.fudanmed.platform.core.web.shared.device.UIPMDefaultIntervalAssociation;
import com.uniquesoft.uidl.transform.AbstractEntityMapper;
import com.uniquesoft.uidl.transform.IConvertService;
import edu.fudan.mylang.pf.IObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("com.fudanmed.platform.core.web.server.service.device.PMDefaultIntervalAssociationMapper")
public class PMDefaultIntervalAssociationMapper extends AbstractEntityMapper<UIPMDefaultIntervalAssociation,RCPMDefaultIntervalAssociation> {
  @Autowired
  private IConvertService convertService;
  
  public RCPMDefaultIntervalAssociation create(final UIPMDefaultIntervalAssociation assignment, final Object context) {
    RCPMDefaultIntervalAssociation _createAndAddtoIntervals = ((RCPMDeviceTypeEntry) context).createAndAddtoIntervals();
    return _createAndAddtoIntervals;
  }
  
  @Autowired
  private IObjectFactory entities;
  
  public RCPMDefaultIntervalAssociation loadEntityById(final Long id) {
    return entities.get(RCPMDefaultIntervalAssociation.class,id);
  }
  
  public RCPMDefaultIntervalAssociation create() {
    return entities.create(RCPMDefaultIntervalAssociation.class);
  }
  
  @Autowired
  private PMDefaultIntervalAssociationValidator validator;
  
  public void copyToEntity(final UIPMDefaultIntervalAssociation from, final RCPMDefaultIntervalAssociation to) {
    java.util.Collection<com.uniquesoft.gwt.shared.validation.ValidationErrorItem> errors = validator.validate(from);
    if(errors.size()!=0)throw new com.uniquesoft.gwt.shared.validation.ValidationException(errors);					
    to.setVersion(from.getVersion());
    to.setType(convertService.toValue(com.fudanmed.platform.core.device.pm.RCDevicePMType.class,from.getType()));
    to.setIntervalInDays(convertService.toValue(java.lang.Integer.class,from.getIntervalInDays()));
    to.setDescription(convertService.toValue(java.lang.String.class,from.getDescription()));
    
  }
  
  public UIPMDefaultIntervalAssociation copyFromEntity(final UIPMDefaultIntervalAssociation result, final RCPMDefaultIntervalAssociation entity) {
    if(entity==null) return null;
    result.setId(entity.getId());
    result.setVersion(entity.getVersion());
    result.setProxy(entity.toProxy());
    result.setClazzName(entity.getClass().getName());
    result.setType(convertService.toValue(com.fudanmed.platform.core.device.pm.proxy.RCDevicePMTypeProxy.class,entity.getType()));
    result.setIntervalInDays(convertService.toValue(java.lang.Integer.class,entity.getIntervalInDays()));
    result.setDescription(convertService.toValue(java.lang.String.class,entity.getDescription()));
    return result;
    
  }
  
  public UIPMDefaultIntervalAssociation buildFrom(final RCPMDefaultIntervalAssociation entity) {
    if(entity==null) return null;
    com.fudanmed.platform.core.web.shared.device.UIPMDefaultIntervalAssociation result = new com.fudanmed.platform.core.web.shared.device.UIPMDefaultIntervalAssociation();
    copyFromEntity(result,entity);	
    return result;
    
  }
  
  public Class<?> getUIClass() {
    return UIPMDefaultIntervalAssociation.class;
  }
  
  public Class<?> getEntityClass() {
    return RCPMDefaultIntervalAssociation.class;
  }
}
