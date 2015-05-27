package com.fudanmed.platform.core.warehouse.impl;

import com.fudanmed.platform.core.warehouse.RCProductSpecification;
import com.fudanmed.platform.core.warehouse.RCProductSpecificationDAO;
import edu.fudan.mylang.pf.BaseService;
import edu.fudan.mylang.pf.IGenericQuery;
import org.springframework.stereotype.Service;

@Service("com.fudanmed.platform.core.warehouse.RCProductSpecificationDAO")
public class RCProductSpecificationDAOImpl extends BaseService implements RCProductSpecificationDAO {
  public RCProductSpecification findBySid(final String sid) {
    IGenericQuery<RCProductSpecification> query=getObjectFactory().createGenericQuery(RCProductSpecification.class,"select s from com.fudanmed.platform.core.warehouse.impl.RCProductSpecificationImpl as s   where (s.sid = :sid) and  s.active = 1      ").setParameter("sid",sid);
    RCProductSpecification _uniqueResult = query.uniqueResult();
    return _uniqueResult;
  }
  
  public RCProductSpecification findByMaterialId(final String materialId) {
    IGenericQuery<RCProductSpecification> query=getObjectFactory().createGenericQuery(RCProductSpecification.class,"select s from com.fudanmed.platform.core.warehouse.impl.RCProductSpecificationImpl as s   where (s.materialId = :materialId) and  s.active = 1      ").setParameter("materialId",materialId);
    RCProductSpecification _uniqueResult = query.uniqueResult();
    return _uniqueResult;
  }
}
