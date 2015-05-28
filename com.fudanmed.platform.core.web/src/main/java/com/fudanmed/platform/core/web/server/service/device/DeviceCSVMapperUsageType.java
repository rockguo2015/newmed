package com.fudanmed.platform.core.web.server.service.device;

import com.fudanmed.platform.core.device.RCDeviceUsageType;
import com.fudanmed.platform.core.device.proxy.RCDeviceUsageTypeProxy;
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

@Component("com.fudanmed.platform.core.web.server.service.device.DeviceCSVMapperUsageType")
public class DeviceCSVMapperUsageType extends BaseCSVCustomItemMapper<RCDeviceUsageTypeProxy,UIDevice> {
  @Autowired
  private IMapperFactory mapperFactory;
  
  @Autowired
  private IObjectFactory entities;
  
  @Autowired
  private CodeService codeService;
  
  protected RCDeviceUsageTypeProxy doFromString(final String value, final UIDevice context, final IFieldValidationResultAcceptor acceptor) {
    boolean _isNullOrEmpty = StringExtensions.isNullOrEmpty(value);
    if (_isNullOrEmpty) {
      return null;
    }
    final RCDeviceUsageType result = this.codeService.<RCDeviceUsageType>getCodeByName(RCDeviceUsageType.class, value);
    boolean _equals = Objects.equal(result, null);
    if (_equals) {
      acceptor.accept("\u65E0\u6548\u4F7F\u7528\u60C5\u51B5");
    }
    return result.toProxy();
  }
  
  public String toString(final RCDeviceUsageTypeProxy value, final UIDevice context) {
    return mapperFactory.getNamedEntityMapper().toString(value);
    
  }
}
