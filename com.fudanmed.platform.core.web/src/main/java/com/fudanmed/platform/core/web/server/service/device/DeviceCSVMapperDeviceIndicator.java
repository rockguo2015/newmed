package com.fudanmed.platform.core.web.server.service.device;

import com.fudanmed.platform.core.device.RCDeviceIndicator;
import com.fudanmed.platform.core.device.proxy.RCDeviceIndicatorProxy;
import com.fudanmed.platform.core.web.shared.device.UIDevice;
import com.google.common.base.Objects;
import edu.fudan.langlab.csv.server.mapper.BaseCSVCustomItemMapper;
import edu.fudan.langlab.csv.server.mapper.IMapperFactory;
import edu.fudan.langlab.csv.shared.IFieldValidationResultAcceptor;
import edu.fudan.langlab.domain.code.CodeService;
import edu.fudan.mylang.pf.IObjectFactory;
import org.eclipse.xtext.xbase.lib.StringExtensions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("com.fudanmed.platform.core.web.server.service.device.DeviceCSVMapperDeviceIndicator")
public class DeviceCSVMapperDeviceIndicator extends BaseCSVCustomItemMapper<RCDeviceIndicatorProxy,UIDevice> {
  @Autowired
  private IMapperFactory mapperFactory;
  
  @Autowired
  private IObjectFactory entities;
  
  @Autowired
  private CodeService codeService;
  
  protected RCDeviceIndicatorProxy doFromString(final String value, final UIDevice context, final IFieldValidationResultAcceptor acceptor) {
    boolean _isNullOrEmpty = StringExtensions.isNullOrEmpty(value);
    if (_isNullOrEmpty) {
      return null;
    }
    final RCDeviceIndicator result = this.codeService.<RCDeviceIndicator>getCodeByName(RCDeviceIndicator.class, value);
    boolean _equals = Objects.equal(result, null);
    if (_equals) {
      acceptor.accept("\u65E0\u6548\u8BBE\u5907\u6807\u8BC6");
    }
    return result.toProxy();
  }
  
  public String toString(final RCDeviceIndicatorProxy value, final UIDevice context) {
    return mapperFactory.getNamedEntityMapper().toString(value);
    
  }
}
