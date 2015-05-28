package com.fudanmed.platform.core.web.server.service.project;

import com.fudanmed.platform.core.warehouse.proxy.RCProduceSpecificationUnitProxy;
import com.fudanmed.platform.core.web.shared.project.UIWorkItemStorage4Settlement;
import edu.fudan.langlab.csv.server.mapper.BaseCSVCustomItemMapper;
import edu.fudan.langlab.csv.server.mapper.IMapperFactory;
import edu.fudan.langlab.csv.shared.IFieldValidationResultAcceptor;
import edu.fudan.mylang.pf.IObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("com.fudanmed.platform.core.web.server.service.project.WorkItemStorage4SettlementCSVMapperUnit")
public class WorkItemStorage4SettlementCSVMapperUnit extends BaseCSVCustomItemMapper<RCProduceSpecificationUnitProxy,UIWorkItemStorage4Settlement> {
  @Autowired
  private IMapperFactory mapperFactory;
  
  @Autowired
  private IObjectFactory entities;
  
  public String toString(final RCProduceSpecificationUnitProxy value, final UIWorkItemStorage4Settlement context) {
    String _name = value.getName();
    return _name;
  }
  
  protected RCProduceSpecificationUnitProxy doFromString(final String value, final UIWorkItemStorage4Settlement context, final IFieldValidationResultAcceptor acceptor) {
    return null;
  }
}
