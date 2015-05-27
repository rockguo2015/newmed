package com.fudanmed.platform.core.device.impl;

import com.fudanmed.platform.core.device.RCDeviceTypeCategory;
import com.fudanmed.platform.core.device.RCDeviceTypeCategoryDAO;
import edu.fudan.mylang.pf.BaseService;
import edu.fudan.mylang.pf.IGenericQuery;
import java.util.Collection;
import org.springframework.stereotype.Service;

@Service("com.fudanmed.platform.core.device.RCDeviceTypeCategoryDAO")
public class RCDeviceTypeCategoryDAOImpl extends BaseService implements RCDeviceTypeCategoryDAO {
  public RCDeviceTypeCategory findByCode(final String code) {
    IGenericQuery<RCDeviceTypeCategory> query=getObjectFactory().createGenericQuery(RCDeviceTypeCategory.class,"select e from com.fudanmed.platform.core.device.impl.RCDeviceTypeCategoryImpl as e   where (e.code = :code) and  e.active = 1      ").setParameter("code",code);
    RCDeviceTypeCategory _uniqueResult = query.uniqueResult();
    return _uniqueResult;
  }
  
  public Collection<RCDeviceTypeCategory> allRootCategories() {
    IGenericQuery<RCDeviceTypeCategory> query=getObjectFactory().createGenericQuery(RCDeviceTypeCategory.class,"select e from com.fudanmed.platform.core.device.impl.RCDeviceTypeCategoryImpl as e   where (e.parent IS   NULL ) and  e.active = 1      ");
    Collection<RCDeviceTypeCategory> _list = query.list();
    return _list;
  }
}
