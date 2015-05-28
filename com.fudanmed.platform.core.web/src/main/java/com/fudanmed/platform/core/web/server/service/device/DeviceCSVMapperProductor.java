package com.fudanmed.platform.core.web.server.service.device;

import com.fudanmed.platform.core.domain.RCSupplier;
import com.fudanmed.platform.core.domain.RCSupplierDAO;
import com.fudanmed.platform.core.domain.proxy.RCSupplierProxy;
import com.fudanmed.platform.core.web.shared.device.UIDevice;
import com.google.common.base.Objects;
import edu.fudan.langlab.csv.server.mapper.BaseCSVCustomItemMapper;
import edu.fudan.langlab.csv.server.mapper.IMapperFactory;
import edu.fudan.langlab.csv.shared.IFieldValidationResultAcceptor;
import edu.fudan.mylang.pf.IObjectFactory;
import org.eclipse.xtext.xbase.lib.StringExtensions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("com.fudanmed.platform.core.web.server.service.device.DeviceCSVMapperProductor")
public class DeviceCSVMapperProductor extends BaseCSVCustomItemMapper<RCSupplierProxy,UIDevice> {
  @Autowired
  private IMapperFactory mapperFactory;
  
  @Autowired
  private IObjectFactory entities;
  
  @Autowired
  private RCSupplierDAO supplierDAO;
  
  protected RCSupplierProxy doFromString(final String value, final UIDevice context, final IFieldValidationResultAcceptor acceptor) {
    boolean _isNullOrEmpty = StringExtensions.isNullOrEmpty(value);
    if (_isNullOrEmpty) {
      return null;
    }
    RCSupplier _findByName = this.supplierDAO.findByName(value);
    final RCSupplierProxy result = _findByName==null?(RCSupplierProxy)null:_findByName.toProxy();
    boolean _equals = Objects.equal(result, null);
    if (_equals) {
      String _plus = ("\u65E0\u6548\u751F\u4EA7\u5382\u5546:" + value);
      acceptor.accept(_plus);
    }
    return result;
  }
  
  public String toString(final RCSupplierProxy value, final UIDevice context) {
    return mapperFactory.getNamedEntityMapper().toString(value);
    
  }
}
