package com.fudanmed.platform.core.web.server.service.warehouse;

import com.fudanmed.platform.core.domain.RCSupplier;
import com.fudanmed.platform.core.domain.RCSupplierDAO;
import com.fudanmed.platform.core.domain.proxy.RCSupplierProxy;
import com.fudanmed.platform.core.web.shared.warehouse.UIProductSpecification;
import com.google.common.base.Objects;
import edu.fudan.langlab.csv.server.mapper.BaseCSVCustomItemMapper;
import edu.fudan.langlab.csv.server.mapper.IMapperFactory;
import edu.fudan.langlab.csv.shared.IFieldValidationResultAcceptor;
import edu.fudan.mylang.pf.IObjectFactory;
import org.eclipse.xtext.xbase.lib.StringExtensions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("com.fudanmed.platform.core.web.server.service.warehouse.ProductSpecificationCSVMapperDefaultSupplier")
public class ProductSpecificationCSVMapperDefaultSupplier extends BaseCSVCustomItemMapper<RCSupplierProxy,UIProductSpecification> {
  @Autowired
  private IMapperFactory mapperFactory;
  
  @Autowired
  private IObjectFactory entities;
  
  @Autowired
  private RCSupplierDAO supplierDAO;
  
  protected RCSupplierProxy doFromString(final String value, final UIProductSpecification context, final IFieldValidationResultAcceptor acceptor) {
    RCSupplierProxy _xblockexpression = null;
    {
      RCSupplier _findByName = this.supplierDAO.findByName(value);
      final RCSupplierProxy result = _findByName.toProxy();
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
        acceptor.accept("\u65E0\u6548\u4F9B\u5E94\u5546\u540D\u79F0");
      }
      _xblockexpression = (result);
    }
    return _xblockexpression;
  }
  
  public String toString(final RCSupplierProxy value, final UIProductSpecification context) {
    return mapperFactory.getNamedEntityMapper().toString(value);
    
  }
}
