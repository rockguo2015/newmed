package com.fudanmed.platform.core.device.impl;

import com.fudanmed.platform.core.device.RCDeviceType;
import com.fudanmed.platform.core.device.RCDeviceTypeDAO;
import edu.fudan.mylang.pf.BaseDAOService;
import edu.fudan.mylang.pf.IGenericQuery;
import org.springframework.stereotype.Service;

@Service("com.fudanmed.platform.core.device.RCDeviceTypeDAO")
public class RCDeviceTypeDAOImpl extends BaseDAOService<RCDeviceType> implements RCDeviceTypeDAO {
  public RCDeviceType findByCode(final String code) {
    IGenericQuery<RCDeviceType> query=getObjectFactory().createGenericQuery(RCDeviceType.class,"select e from com.fudanmed.platform.core.device.impl.RCDeviceTypeImpl as e   where (e.code = :code) and  e.active = 1      ").setParameter("code",code);
    RCDeviceType _uniqueResult = query.uniqueResult();
    return _uniqueResult;
  }
}
