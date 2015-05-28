package com.fudanmed.platform.core.web.server.service.warehouse;

import com.fudanmed.platform.core.common.RCMaterialBrand;
import com.fudanmed.platform.core.common.proxy.RCMaterialBrandProxy;
import com.fudanmed.platform.core.web.shared.warehouse.UIProductSpecification;
import com.google.common.base.Objects;
import edu.fudan.langlab.csv.server.mapper.BaseCSVCustomItemMapper;
import edu.fudan.langlab.csv.server.mapper.IMapperFactory;
import edu.fudan.langlab.csv.shared.IFieldValidationResultAcceptor;
import edu.fudan.mylang.pf.IObjectFactory;
import java.util.Collection;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("com.fudanmed.platform.core.web.server.service.warehouse.ProductSpecificationCSVMapperBrandType")
public class ProductSpecificationCSVMapperBrandType extends BaseCSVCustomItemMapper<RCMaterialBrandProxy,UIProductSpecification> {
  @Autowired
  private IMapperFactory mapperFactory;
  
  @Autowired
  private IObjectFactory entities;
  
  protected RCMaterialBrandProxy doFromString(final String value, final UIProductSpecification context, final IFieldValidationResultAcceptor acceptor) {
    RCMaterialBrandProxy _xblockexpression = null;
    {
      Collection<RCMaterialBrand> _all = this.entities.<RCMaterialBrand>all(RCMaterialBrand.class);
      final Function1<RCMaterialBrand,Boolean> _function = new Function1<RCMaterialBrand,Boolean>() {
          public Boolean apply(final RCMaterialBrand it) {
            String _name = it.getName();
            boolean _equals = Objects.equal(_name, value);
            return Boolean.valueOf(_equals);
          }
        };
      RCMaterialBrand _findFirst = IterableExtensions.<RCMaterialBrand>findFirst(_all, _function);
      final RCMaterialBrandProxy result = _findFirst.toProxy();
      boolean _and = false;
      boolean _notEquals = (!Objects.equal(value, null));
      if (!_notEquals) {
        _and = false;
      } else {
        boolean _equals = Objects.equal(result, null);
        _and = (_notEquals && _equals);
      }
      if (_and) {
        acceptor.accept("\u65E0\u6548\u54C1\u724C\u540D\u79F0");
      }
      _xblockexpression = (result);
    }
    return _xblockexpression;
  }
  
  public String toString(final RCMaterialBrandProxy value, final UIProductSpecification context) {
    return mapperFactory.getNamedEntityMapper().toString(value);
    
  }
}
