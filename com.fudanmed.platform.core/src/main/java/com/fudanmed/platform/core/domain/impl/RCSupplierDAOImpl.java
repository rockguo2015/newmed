package com.fudanmed.platform.core.domain.impl;

import com.fudanmed.platform.core.domain.RCSupplier;
import com.fudanmed.platform.core.domain.RCSupplierDAO;
import edu.fudan.mylang.pf.BaseService;
import edu.fudan.mylang.pf.IGenericQuery;
import org.eclipse.xtext.xbase.lib.InputOutput;
import org.springframework.stereotype.Service;

@Service("com.fudanmed.platform.core.domain.RCSupplierDAO")
public class RCSupplierDAOImpl extends BaseService implements RCSupplierDAO {
  public RCSupplier findByName(final String name) {
    RCSupplier _xblockexpression = null;
    {
      String _plus = ("findByName:" + name);
      InputOutput.<String>println(_plus);
      IGenericQuery<RCSupplier> query=getObjectFactory().createGenericQuery(RCSupplier.class,"select s from com.fudanmed.platform.core.domain.impl.RCSupplierImpl as s   where (s.name = :name) and  s.active = 1      ").setParameter("name",name);
      RCSupplier _uniqueResult = query.uniqueResult();
      _xblockexpression = (_uniqueResult);
    }
    return _xblockexpression;
  }
}
