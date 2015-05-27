package com.fudanmed.platform.core.measure.impl;

import com.fudanmed.platform.core.measure.RCMeasureDeviceType;
import com.fudanmed.platform.core.measure.RCMeasureDeviceTypeDAO;
import edu.fudan.mylang.pf.BaseDAOService;
import edu.fudan.mylang.pf.IGenericQuery;
import java.util.Collection;
import org.springframework.stereotype.Service;

@Service("com.fudanmed.platform.core.measure.RCMeasureDeviceTypeDAO")
public class RCMeasureDeviceTypeDAOImpl extends BaseDAOService<RCMeasureDeviceType> implements RCMeasureDeviceTypeDAO {
  public Collection<RCMeasureDeviceType> getAllMeasureDeviceTypes() {IGenericQuery<RCMeasureDeviceType> query=getObjectFactory().createGenericQuery(RCMeasureDeviceType.class,"select e from com.fudanmed.platform.core.measure.impl.RCMeasureDeviceTypeImpl as e   where  e.active = 1      ");
    Collection<RCMeasureDeviceType> _list = query.list();
    return _list;
  }
  
  public RCMeasureDeviceType findByName(final String name) {
    IGenericQuery<RCMeasureDeviceType> query=getObjectFactory().createGenericQuery(RCMeasureDeviceType.class,"select e from com.fudanmed.platform.core.measure.impl.RCMeasureDeviceTypeImpl as e   where (e.name = :name) and  e.active = 1      ").setParameter("name",name);
    RCMeasureDeviceType _uniqueResult = query.uniqueResult();
    return _uniqueResult;
  }
}
