package com.fudanmed.platform.core.web.server.service.warehouse;

import com.fudanmed.platform.core.warehouse.RCProductType;
import com.fudanmed.platform.core.warehouse.RCProductTypeDAO;
import com.fudanmed.platform.core.warehouse.proxy.RCProductTypeProxy;
import com.fudanmed.platform.core.web.shared.warehouse.UIProductSpecification;
import com.google.common.base.Objects;
import edu.fudan.langlab.csv.server.mapper.BaseCSVCustomItemMapper;
import edu.fudan.langlab.csv.server.mapper.IMapperFactory;
import edu.fudan.langlab.csv.shared.IFieldValidationResultAcceptor;
import edu.fudan.mylang.pf.IObjectFactory;
import org.eclipse.xtext.xbase.lib.StringExtensions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("com.fudanmed.platform.core.web.server.service.warehouse.ProductSpecificationCSVMapperProductType")
public class ProductSpecificationCSVMapperProductType extends BaseCSVCustomItemMapper<RCProductTypeProxy,UIProductSpecification> {
  @Autowired
  private IMapperFactory mapperFactory;
  
  @Autowired
  private IObjectFactory entities;
  
  @Autowired
  private RCProductTypeDAO productTypeDAO;
  
  protected RCProductTypeProxy doFromString(final String value, final UIProductSpecification context, final IFieldValidationResultAcceptor acceptor) {
    RCProductTypeProxy _xblockexpression = null;
    {
      RCProductType _findByCode = this.productTypeDAO.findByCode(value);
      final RCProductTypeProxy result = _findByCode.toProxy();
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
        acceptor.accept("\u65E0\u6548\u7269\u54C1\u7C7B\u522B\u7F16\u53F7");
      }
      _xblockexpression = (result);
    }
    return _xblockexpression;
  }
  
  public String toString(final RCProductTypeProxy value, final UIProductSpecification context) {
    return mapperFactory.getNamedEntityMapper().toString(value);
    
  }
}
