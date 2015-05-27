package com.fudanmed.platform.core.entityextension.impl;

import com.fudanmed.platform.core.entityextension.RCNumberWithUnitType;
import com.fudanmed.platform.core.entityextension.RCRangeType;
import com.fudanmed.platform.core.entityextension.RCRangeTypeDAO;
import com.fudanmed.platform.core.entityextension.impl.RCRangeTypeImpl;
import com.google.common.base.Objects;
import com.uniquesoft.uidl.validation.Validates;
import edu.fudan.mylang.pf.BaseService;
import edu.fudan.mylang.pf.IGenericQuery;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.springframework.stereotype.Service;

@Service("com.fudanmed.platform.core.entityextension.RCRangeTypeDAO")
public class RCRangeTypeDAOImpl extends BaseService implements RCRangeTypeDAO {
  public RCRangeType create(final RCNumberWithUnitType baseType) {
    RCRangeType _xblockexpression = null;
    {
      Boolean _rangeTypeCreated = this.rangeTypeCreated(baseType);
      boolean _not = (!_rangeTypeCreated);
      Validates.Assert(_not, "\u8BE5\u7C7B\u578B\u7684\u8303\u56F4\u7C7B\u578B\u5DF2\u5B9A\u4E49");RCRangeType rCRangeType=RCRangeTypeImpl.create(getObjectFactory());
      final Procedure1<RCRangeType> _function = new Procedure1<RCRangeType>() {
          public void apply(final RCRangeType it) {
            it.setNumberType(baseType);
          }
        };
      RCRangeType _doubleArrow = ObjectExtensions.<RCRangeType>operator_doubleArrow(rCRangeType, _function);
      _xblockexpression = (_doubleArrow);
    }
    return _xblockexpression;
  }
  
  public Boolean rangeTypeCreated(final RCNumberWithUnitType baseType) {
    IGenericQuery<RCRangeType> query=getObjectFactory().createGenericQuery(RCRangeType.class,"select e from com.fudanmed.platform.core.entityextension.impl.RCRangeTypeImpl as e   where (e.numberType = :baseType) and  e.active = 1      ").setParameter("baseType",baseType);
    RCRangeType _uniqueResult = query.uniqueResult();
    boolean _notEquals = (!Objects.equal(_uniqueResult, null));
    return Boolean.valueOf(_notEquals);
  }
}
