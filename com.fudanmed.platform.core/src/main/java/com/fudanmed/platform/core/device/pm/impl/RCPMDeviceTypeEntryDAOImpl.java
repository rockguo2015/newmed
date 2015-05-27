package com.fudanmed.platform.core.device.pm.impl;

import com.fudanmed.platform.core.device.RCDeviceType;
import com.fudanmed.platform.core.device.pm.RCPMDeviceTypeEntry;
import com.fudanmed.platform.core.device.pm.RCPMDeviceTypeEntryDAO;
import edu.fudan.mylang.pf.BaseDAOService;
import edu.fudan.mylang.pf.IGenericQuery;
import org.springframework.stereotype.Service;

@Service("com.fudanmed.platform.core.device.pm.RCPMDeviceTypeEntryDAO")
public class RCPMDeviceTypeEntryDAOImpl extends BaseDAOService<RCPMDeviceTypeEntry> implements RCPMDeviceTypeEntryDAO {
  public RCPMDeviceTypeEntry findByDeviceType(final RCDeviceType deviceType) {
    IGenericQuery<RCPMDeviceTypeEntry> query=getObjectFactory().createGenericQuery(RCPMDeviceTypeEntry.class,"select e from com.fudanmed.platform.core.device.pm.impl.RCPMDeviceTypeEntryImpl as e   where (e.deviceType = :deviceType) and  e.active = 1      ").setParameter("deviceType",deviceType);
    RCPMDeviceTypeEntry _uniqueResult = query.uniqueResult();
    return _uniqueResult;
  }
}
