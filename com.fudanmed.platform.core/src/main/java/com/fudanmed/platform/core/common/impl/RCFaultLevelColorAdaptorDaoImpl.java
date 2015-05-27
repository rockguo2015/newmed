package com.fudanmed.platform.core.common.impl;

import com.fudanmed.platform.core.common.RCFaultLevel;
import com.fudanmed.platform.core.common.RCFaultLevelColorAdaptor;
import com.fudanmed.platform.core.common.RCFaultLevelColorAdaptorDao;
import com.fudanmed.platform.core.common.RCStandardColor;
import com.google.common.base.Objects;
import edu.fudan.mylang.pf.BaseDAOService;
import edu.fudan.mylang.pf.IGenericQuery;
import java.util.Collection;
import org.springframework.stereotype.Service;

@Service("com.fudanmed.platform.core.common.RCFaultLevelColorAdaptorDao")
public class RCFaultLevelColorAdaptorDaoImpl extends BaseDAOService<RCFaultLevelColorAdaptor> implements RCFaultLevelColorAdaptorDao {
  public Collection<RCFaultLevelColorAdaptor> findAll() {IGenericQuery<RCFaultLevelColorAdaptor> query=getObjectFactory().createGenericQuery(RCFaultLevelColorAdaptor.class,"select e from com.fudanmed.platform.core.common.impl.RCFaultLevelColorAdaptorImpl as e   where  e.active = 1  order by e.faultLevel.codeid ASC    ");
    Collection<RCFaultLevelColorAdaptor> _list = query.list();
    return _list;
  }
  
  public String getColor(final RCFaultLevel faultLevel) {
    String _xblockexpression = null;
    {
      boolean _equals = Objects.equal(faultLevel, null);
      if (_equals) {
        return "";
      }
      IGenericQuery<RCFaultLevelColorAdaptor> query=getObjectFactory().createGenericQuery(RCFaultLevelColorAdaptor.class,"select e from com.fudanmed.platform.core.common.impl.RCFaultLevelColorAdaptorImpl as e   where (e.faultLevel = :faultLevel) and  e.active = 1      ").setParameter("faultLevel",faultLevel);
      RCFaultLevelColorAdaptor _uniqueResult = query.uniqueResult();
      RCStandardColor _color = _uniqueResult.getColor();
      String _name = _color.name();
      _xblockexpression = (_name);
    }
    return _xblockexpression;
  }
}
