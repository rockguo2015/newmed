package com.fudanmed.platform.core.web.server.service.device;

import com.fudanmed.platform.core.device.RCDeviceType;
import com.fudanmed.platform.core.device.pm.RCPMDefaultIntervalAssociation;
import com.fudanmed.platform.core.device.pm.RCPMDeviceTypeEntry;
import com.fudanmed.platform.core.device.pm.RCPMDeviceTypeEntryDAO;
import com.fudanmed.platform.core.device.proxy.RCDeviceTypeProxy;
import com.fudanmed.platform.core.web.client.device.PMDefaultIntervalAssociationListPresenterService;
import com.fudanmed.platform.core.web.server.service.device.PMDefaultIntervalAssociationMapper;
import com.fudanmed.platform.core.web.shared.device.UIPMDefaultIntervalAssociation;
import com.uniquesoft.gwt.server.service.common.BaseService;
import com.uniquesoft.gwt.shared.SessionTimeOutException;
import com.uniquesoft.gwt.shared.extensions.IterableExtensions2;
import com.uniquesoft.gwt.shared.validation.ValidationException;
import edu.fudan.mylang.pf.IObjectFactory;
import java.util.Collection;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("com.fudanmed.platform.core.web.client.device.PMDefaultIntervalAssociationListPresenterService")
@Transactional
public class PMDefaultIntervalAssociationListPresenterServiceImpl extends BaseService implements PMDefaultIntervalAssociationListPresenterService {
  @Autowired
  private IObjectFactory entities;
  
  @Autowired
  private PMDefaultIntervalAssociationMapper mapper;
  
  @Autowired
  private RCPMDeviceTypeEntryDAO dao;
  
  public Collection<UIPMDefaultIntervalAssociation> loadPMDefaultIntervalAssociationList(final RCDeviceTypeProxy context) throws SessionTimeOutException, ValidationException {
    RCDeviceType _resolved= null;
    if(context!=null) _resolved=(com.fudanmed.platform.core.device.RCDeviceType)com.uniquesoft.uidl.extensions.ModelObjects.resolve(context, entities);
    
    RCPMDeviceTypeEntry _findByDeviceType = this.dao.findByDeviceType( _resolved);
    Collection<RCPMDefaultIntervalAssociation> _intervals = _findByDeviceType.getIntervals();
    final Function1<RCPMDefaultIntervalAssociation,UIPMDefaultIntervalAssociation> _function = new Function1<RCPMDefaultIntervalAssociation,UIPMDefaultIntervalAssociation>() {
        public UIPMDefaultIntervalAssociation apply(final RCPMDefaultIntervalAssociation it) {
          UIPMDefaultIntervalAssociation _transform = PMDefaultIntervalAssociationListPresenterServiceImpl.this.mapper.transform(it);
          return _transform;
        }
      };
    Iterable<UIPMDefaultIntervalAssociation> _map = IterableExtensions.<RCPMDefaultIntervalAssociation, UIPMDefaultIntervalAssociation>map(_intervals, _function);
    Collection<UIPMDefaultIntervalAssociation> _unlazy = IterableExtensions2.<UIPMDefaultIntervalAssociation>unlazy(_map);
    return _unlazy;
  }
}
