package com.fudanmed.platform.core.web.server.service.device;

import com.fudanmed.platform.core.device.RCAcquireType;
import com.fudanmed.platform.core.device.proxy.RCAcquireTypeProxy;
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

@Component("com.fudanmed.platform.core.web.server.service.device.DeviceCSVMapperAcquireType")
public class DeviceCSVMapperAcquireType extends BaseCSVCustomItemMapper<RCAcquireTypeProxy,UIDevice> {
  @Autowired
  private IMapperFactory mapperFactory;
  
  @Autowired
  private IObjectFactory entities;
  
  @Autowired
  private CodeService codeService;
  
  protected RCAcquireTypeProxy doFromString(final String value, final UIDevice context, final IFieldValidationResultAcceptor acceptor) {
    boolean _isNullOrEmpty = StringExtensions.isNullOrEmpty(value);
    if (_isNullOrEmpty) {
      return null;
    }
    final RCAcquireType result = this.codeService.<RCAcquireType>getCodeByName(RCAcquireType.class, value);
    boolean _equals = Objects.equal(result, null);
    if (_equals) {
      acceptor.accept("\u65E0\u6548\u589E\u7F6E\u65B9\u5F0F");
    }
    return result.toProxy();
  }
  
  public String toString(final RCAcquireTypeProxy value, final UIDevice context) {
    return mapperFactory.getNamedEntityMapper().toString(value);
    
  }
}
