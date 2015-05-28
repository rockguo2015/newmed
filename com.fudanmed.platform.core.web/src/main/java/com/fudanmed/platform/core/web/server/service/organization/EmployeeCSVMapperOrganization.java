package com.fudanmed.platform.core.web.server.service.organization;

import com.fudanmed.platform.core.domain.RCOrganization;
import com.fudanmed.platform.core.domain.RCOrganizationDAO;
import com.fudanmed.platform.core.domain.proxy.RCOrganizationProxy;
import com.fudanmed.platform.core.web.shared.organization.UIEmployee;
import com.google.common.base.Objects;
import edu.fudan.langlab.csv.server.mapper.BaseCSVCustomItemMapper;
import edu.fudan.langlab.csv.server.mapper.IMapperFactory;
import edu.fudan.langlab.csv.shared.IFieldValidationResultAcceptor;
import edu.fudan.mylang.pf.IObjectFactory;
import org.eclipse.xtext.xbase.lib.StringExtensions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("com.fudanmed.platform.core.web.server.service.organization.EmployeeCSVMapperOrganization")
public class EmployeeCSVMapperOrganization extends BaseCSVCustomItemMapper<RCOrganizationProxy,UIEmployee> {
  @Autowired
  private IMapperFactory mapperFactory;
  
  @Autowired
  private IObjectFactory entities;
  
  @Autowired
  private RCOrganizationDAO organizationDAO;
  
  protected RCOrganizationProxy doFromString(final String value, final UIEmployee context, final IFieldValidationResultAcceptor acceptor) {
    RCOrganizationProxy _xifexpression = null;
    boolean _isNullOrEmpty = StringExtensions.isNullOrEmpty(value);
    if (_isNullOrEmpty) {
      _xifexpression = null;
    } else {
      RCOrganizationProxy _xblockexpression = null;
      {
        final RCOrganization result = this.organizationDAO.findByCode(value);
        boolean _equals = Objects.equal(result, null);
        if (_equals) {
          String _plus = ("\u65E0\u6548\u6240\u5C5E\u673A\u6784\u4EE3\u7801:" + value);
          acceptor.accept(_plus);
        }
        RCOrganizationProxy _proxy = result.toProxy();
        _xblockexpression = (_proxy);
      }
      _xifexpression = _xblockexpression;
    }
    return _xifexpression;
  }
  
  public String toString(final RCOrganizationProxy value, final UIEmployee context) {
    return mapperFactory.getNamedEntityMapper().toString(value);
    
  }
}
