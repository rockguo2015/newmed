package com.fudanmed.platform.core.warehouse.impl;

import com.fudanmed.platform.core.warehouse.RCProductType;
import com.fudanmed.platform.core.warehouse.RCProductTypeDAO;
import edu.fudan.mylang.pf.BaseService;
import edu.fudan.mylang.pf.IGenericQuery;
import org.springframework.stereotype.Service;

@Service("com.fudanmed.platform.core.warehouse.RCProductTypeDAO")
public class RCProductTypeDAOImpl extends BaseService implements RCProductTypeDAO {
  public RCProductType findByCode(final String code) {
    IGenericQuery<RCProductType> query=getObjectFactory().createGenericQuery(RCProductType.class,"select t from com.fudanmed.platform.core.warehouse.impl.RCProductTypeImpl as t   where (t.code = :code) and  t.active = 1      ").setParameter("code",code);
    RCProductType _uniqueResult = query.uniqueResult();
    return _uniqueResult;
  }
}
