package com.fudanmed.platform.core.web.server.service.warehouse;

import com.fudanmed.platform.core.warehouse.RCProduceSpecificationUnit;
import com.fudanmed.platform.core.warehouse.proxy.RCProduceSpecificationUnitProxy;
import com.fudanmed.platform.core.web.shared.warehouse.UIProductSpecification;
import com.google.common.base.Objects;
import edu.fudan.langlab.csv.server.mapper.BaseCSVCustomItemMapper;
import edu.fudan.langlab.csv.server.mapper.IMapperFactory;
import edu.fudan.langlab.csv.shared.IFieldValidationResultAcceptor;
import edu.fudan.mylang.pf.IObjectFactory;
import java.util.Collection;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.StringExtensions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("com.fudanmed.platform.core.web.server.service.warehouse.ProductSpecificationCSVMapperUnit")
public class ProductSpecificationCSVMapperUnit extends BaseCSVCustomItemMapper<RCProduceSpecificationUnitProxy,UIProductSpecification> {
  @Autowired
  private IMapperFactory mapperFactory;
  
  @Autowired
  private IObjectFactory entities;
  
  protected RCProduceSpecificationUnitProxy doFromString(final String value, final UIProductSpecification context, final IFieldValidationResultAcceptor acceptor) {
    RCProduceSpecificationUnitProxy _xblockexpression = null;
    {
      Collection<RCProduceSpecificationUnit> _all = this.entities.<RCProduceSpecificationUnit>all(RCProduceSpecificationUnit.class);
      final Function1<RCProduceSpecificationUnit,Boolean> _function = new Function1<RCProduceSpecificationUnit,Boolean>() {
          public Boolean apply(final RCProduceSpecificationUnit it) {
            String _name = it.getName();
            boolean _equals = Objects.equal(_name, value);
            return Boolean.valueOf(_equals);
          }
        };
      RCProduceSpecificationUnit _findFirst = IterableExtensions.<RCProduceSpecificationUnit>findFirst(_all, _function);
      final RCProduceSpecificationUnitProxy result = _findFirst.toProxy();
      boolean _and = false;
      boolean _isNullOrEmpty = StringExtensions.isNullOrEmpty(value);
      boolean _not = (!_isNullOrEmpty);
      if (!_not) {
        _and = false;
      } else {
        boolean _equals = Objects.equal(result, null);
        _and = (_not && _equals);
      }
      if (_and) {
        acceptor.accept("\u65E0\u6548\u5355\u4F4D\u540D\u79F0");
      }
      _xblockexpression = (result);
    }
    return _xblockexpression;
  }
  
  public String toString(final RCProduceSpecificationUnitProxy value, final UIProductSpecification context) {
    return mapperFactory.getNamedEntityMapper().toString(value);
    
  }
}
