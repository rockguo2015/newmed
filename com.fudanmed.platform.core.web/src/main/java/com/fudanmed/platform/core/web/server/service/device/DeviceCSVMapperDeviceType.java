package com.fudanmed.platform.core.web.server.service.device;

import com.fudanmed.platform.core.device.RCDeviceType;
import com.fudanmed.platform.core.device.RCDeviceTypeDAO;
import com.fudanmed.platform.core.device.proxy.RCDeviceTypeProxy;
import com.fudanmed.platform.core.web.shared.device.UIDevice;
import com.google.common.base.Objects;
import edu.fudan.langlab.csv.server.mapper.BaseCSVCustomItemMapper;
import edu.fudan.langlab.csv.server.mapper.IMapperFactory;
import edu.fudan.langlab.csv.shared.IFieldValidationResultAcceptor;
import edu.fudan.mylang.pf.IObjectFactory;
import org.eclipse.xtext.xbase.lib.StringExtensions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("com.fudanmed.platform.core.web.server.service.device.DeviceCSVMapperDeviceType")
public class DeviceCSVMapperDeviceType extends BaseCSVCustomItemMapper<RCDeviceTypeProxy,UIDevice> {
  @Autowired
  private IMapperFactory mapperFactory;
  
  @Autowired
  private IObjectFactory entities;
  
  @Autowired
  private RCDeviceTypeDAO dao;
  
  protected RCDeviceTypeProxy doFromString(final String value, final UIDevice context, final IFieldValidationResultAcceptor acceptor) {
    boolean _isNullOrEmpty = StringExtensions.isNullOrEmpty(value);
    if (_isNullOrEmpty) {
      return null;
    }
    RCDeviceType _findByCode = this.dao.findByCode(value);
    final RCDeviceTypeProxy result = _findByCode==null?(RCDeviceTypeProxy)null:_findByCode.toProxy();
    boolean _equals = Objects.equal(result, null);
    if (_equals) {
      acceptor.accept("\u65E0\u6548\u8BBE\u5907\u7C7B\u578B");
    }
    return result;
  }
  
  public String toString(final RCDeviceTypeProxy value, final UIDevice context) {
    return mapperFactory.getNamedEntityMapper().toString(value);
    
  }
}
