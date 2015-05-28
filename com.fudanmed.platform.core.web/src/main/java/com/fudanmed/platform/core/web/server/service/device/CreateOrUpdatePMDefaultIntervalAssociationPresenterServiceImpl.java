package com.fudanmed.platform.core.web.server.service.device;

import com.fudanmed.platform.core.device.pm.RCPMDefaultIntervalAssociation;
import com.fudanmed.platform.core.device.pm.RCPMDeviceTypeEntry;
import com.fudanmed.platform.core.device.pm.proxy.RCPMDefaultIntervalAssociationProxy;
import com.fudanmed.platform.core.device.pm.proxy.RCPMDeviceTypeEntryProxy;
import com.fudanmed.platform.core.web.client.device.CreateOrUpdatePMDefaultIntervalAssociationPresenterService;
import com.fudanmed.platform.core.web.server.service.device.PMDefaultIntervalAssociationMapper;
import com.fudanmed.platform.core.web.shared.device.UIPMDefaultIntervalAssociation;
import com.uniquesoft.gwt.server.service.common.BaseService;
import com.uniquesoft.gwt.shared.SessionTimeOutException;
import com.uniquesoft.gwt.shared.validation.ValidationException;
import edu.fudan.mylang.pf.IObjectFactory;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("com.fudanmed.platform.core.web.client.device.CreateOrUpdatePMDefaultIntervalAssociationPresenterService")
@Transactional
public class CreateOrUpdatePMDefaultIntervalAssociationPresenterServiceImpl extends BaseService implements CreateOrUpdatePMDefaultIntervalAssociationPresenterService {
  @Autowired
  private IObjectFactory entities;
  
  @Autowired
  private PMDefaultIntervalAssociationMapper mapper;
  
  public UIPMDefaultIntervalAssociation loadValue(final RCPMDefaultIntervalAssociationProxy pvalue) throws SessionTimeOutException, ValidationException {
    RCPMDefaultIntervalAssociation _resolved= null;
    if(pvalue!=null) _resolved=(com.fudanmed.platform.core.device.pm.RCPMDefaultIntervalAssociation)com.uniquesoft.uidl.extensions.ModelObjects.resolve(pvalue, entities);
    
    UIPMDefaultIntervalAssociation _transform = this.mapper.transform( _resolved);
    return _transform;
  }
  
  public void updateValue(final UIPMDefaultIntervalAssociation uivalue) throws SessionTimeOutException, ValidationException {
    RCPMDefaultIntervalAssociation _resolved= null;
    if(uivalue!=null) _resolved=(com.fudanmed.platform.core.device.pm.RCPMDefaultIntervalAssociation)com.uniquesoft.uidl.extensions.ModelObjects.resolve(uivalue, entities);
    
    final Procedure1<RCPMDefaultIntervalAssociation> _function = new Procedure1<RCPMDefaultIntervalAssociation>() {
        public void apply(final RCPMDefaultIntervalAssociation it) {
          CreateOrUpdatePMDefaultIntervalAssociationPresenterServiceImpl.this.mapper.transform(uivalue, it);
        }
      };
     _resolved.update(_function);
  }
  
  public void createValue(final UIPMDefaultIntervalAssociation uivalue, final RCPMDeviceTypeEntryProxy parent) throws SessionTimeOutException, ValidationException {
    RCPMDeviceTypeEntry _resolved= null;
    if(parent!=null) _resolved=(com.fudanmed.platform.core.device.pm.RCPMDeviceTypeEntry)com.uniquesoft.uidl.extensions.ModelObjects.resolve(parent, entities);
    
    final Procedure1<RCPMDefaultIntervalAssociation> _function = new Procedure1<RCPMDefaultIntervalAssociation>() {
        public void apply(final RCPMDefaultIntervalAssociation it) {
          CreateOrUpdatePMDefaultIntervalAssociationPresenterServiceImpl.this.mapper.transform(uivalue, it);
        }
      };
     _resolved.createInterval(_function);
  }
}
