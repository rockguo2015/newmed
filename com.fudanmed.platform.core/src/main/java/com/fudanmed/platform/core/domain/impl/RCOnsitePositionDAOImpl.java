package com.fudanmed.platform.core.domain.impl;

import com.fudanmed.platform.core.domain.RCOnsitePosition;
import com.fudanmed.platform.core.domain.RCOnsitePositionDAO;
import edu.fudan.mylang.pf.BaseService;
import edu.fudan.mylang.pf.IGenericQuery;
import org.springframework.stereotype.Service;

@Service("com.fudanmed.platform.core.domain.RCOnsitePositionDAO")
public class RCOnsitePositionDAOImpl extends BaseService implements RCOnsitePositionDAO {
  public RCOnsitePosition findByCode(final String code) {
    IGenericQuery<RCOnsitePosition> query=getObjectFactory().createGenericQuery(RCOnsitePosition.class,"select p from com.fudanmed.platform.core.domain.impl.RCOnsitePositionImpl as p   where (p.code = :code) and  p.active = 1      ").setParameter("code",code);
    RCOnsitePosition _uniqueResult = query.uniqueResult();
    return _uniqueResult;
  }
}
