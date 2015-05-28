package com.fudanmed.platform.core.web.server.service.project;

import com.fudanmed.platform.core.common.proxy.RCMaterialBrandProxy;
import com.fudanmed.platform.core.web.shared.project.UIWorkItemStorage4Settlement;
import edu.fudan.langlab.csv.server.mapper.BaseCSVCustomItemMapper;
import edu.fudan.langlab.csv.server.mapper.IMapperFactory;
import edu.fudan.langlab.csv.shared.IFieldValidationResultAcceptor;
import edu.fudan.mylang.pf.IObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("com.fudanmed.platform.core.web.server.service.project.WorkItemStorage4SettlementCSVMapperBrand")
public class WorkItemStorage4SettlementCSVMapperBrand extends BaseCSVCustomItemMapper<RCMaterialBrandProxy,UIWorkItemStorage4Settlement> {
  @Autowired
  private IMapperFactory mapperFactory;
  
  @Autowired
  private IObjectFactory entities;
  
  public String toString(final RCMaterialBrandProxy value, final UIWorkItemStorage4Settlement context) {
    String _name = value.getName();
    return _name;
  }
  
  protected RCMaterialBrandProxy doFromString(final String value, final UIWorkItemStorage4Settlement context, final IFieldValidationResultAcceptor acceptor) {
    return null;
  }
}
