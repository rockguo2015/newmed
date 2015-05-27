package com.fudanmed.platform.core.common.impl;

import com.fudanmed.platform.core.common.RCSystemParameter;
import com.fudanmed.platform.core.common.RCSystemParameterService;
import com.fudanmed.platform.core.common.impl.RCSystemParameterImpl;
import com.google.common.base.Objects;
import edu.fudan.mylang.pf.BaseService;
import edu.fudan.mylang.pf.IGenericQuery;
import org.springframework.stereotype.Service;

@Service("com.fudanmed.platform.core.common.RCSystemParameterService")
public class RCSystemParameterServiceImpl extends BaseService implements RCSystemParameterService {
  public RCSystemParameter getSystemParameter() {
    RCSystemParameter _xblockexpression = null;
    {IGenericQuery<RCSystemParameter> query=getObjectFactory().createGenericQuery(RCSystemParameter.class,"select p from com.fudanmed.platform.core.common.impl.RCSystemParameterImpl as p   where  p.active = 1      ");
      RCSystemParameter result = query.uniqueResult();
      boolean _equals = Objects.equal(result, null);
      if (_equals) {RCSystemParameter rCSystemParameter=RCSystemParameterImpl.create(getObjectFactory());
        result = rCSystemParameter;
      }
      _xblockexpression = (result);
    }
    return _xblockexpression;
  }
}
