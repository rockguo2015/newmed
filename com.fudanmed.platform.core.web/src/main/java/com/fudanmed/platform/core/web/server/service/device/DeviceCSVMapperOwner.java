package com.fudanmed.platform.core.web.server.service.device;

import com.fudanmed.platform.core.domain.RCEmployee;
import com.fudanmed.platform.core.domain.RCEmployeeDAO;
import com.fudanmed.platform.core.domain.proxy.RCEmployeeProxy;
import com.fudanmed.platform.core.web.shared.device.UIDevice;
import edu.fudan.langlab.csv.server.mapper.BaseCSVCustomItemMapper;
import edu.fudan.langlab.csv.server.mapper.IMapperFactory;
import edu.fudan.langlab.csv.shared.IFieldValidationResultAcceptor;
import edu.fudan.mylang.pf.IObjectFactory;
import java.util.Collection;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.StringExtensions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("com.fudanmed.platform.core.web.server.service.device.DeviceCSVMapperOwner")
public class DeviceCSVMapperOwner extends BaseCSVCustomItemMapper<RCEmployeeProxy,UIDevice> {
  @Autowired
  private IMapperFactory mapperFactory;
  
  @Autowired
  private IObjectFactory entities;
  
  @Autowired
  private RCEmployeeDAO employeeDAO;
  
  protected RCEmployeeProxy doFromString(final String value, final UIDevice context, final IFieldValidationResultAcceptor acceptor) {
    boolean _isNullOrEmpty = StringExtensions.isNullOrEmpty(value);
    if (_isNullOrEmpty) {
      return null;
    }
    final Collection<RCEmployee> result = this.employeeDAO.findByName(value);
    boolean _isEmpty = result.isEmpty();
    if (_isEmpty) {
      acceptor.accept("\u65E0\u6548\u4FDD\u7BA1\u4EBA");
    }
    RCEmployee _head = IterableExtensions.<RCEmployee>head(result);
    return _head.toProxy();
  }
  
  public String toString(final RCEmployeeProxy value, final UIDevice context) {
    return mapperFactory.getNamedEntityMapper().toString(value);
    
  }
}
