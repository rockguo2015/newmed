package com.fudanmed.platform.core.web.server.service.warehouse;

import com.fudanmed.platform.core.warehouse.proxy.RCProduceSpecificationUnitProxy;
import com.fudanmed.platform.core.web.shared.warehouse.UIStockTakingItem;
import edu.fudan.langlab.csv.server.mapper.BaseCSVCustomItemMapper;
import edu.fudan.langlab.csv.server.mapper.IMapperFactory;
import edu.fudan.langlab.csv.shared.IFieldValidationResultAcceptor;
import edu.fudan.mylang.pf.IObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("com.fudanmed.platform.core.web.server.service.warehouse.StockTakingItemCSVMapperUnit")
public class StockTakingItemCSVMapperUnit extends BaseCSVCustomItemMapper<RCProduceSpecificationUnitProxy,UIStockTakingItem> {
  @Autowired
  private IMapperFactory mapperFactory;
  
  @Autowired
  private IObjectFactory entities;
  
  public String toString(final RCProduceSpecificationUnitProxy value, final UIStockTakingItem context) {
    String _name = value.getName();
    return _name;
  }
  
  protected RCProduceSpecificationUnitProxy doFromString(final String value, final UIStockTakingItem context, final IFieldValidationResultAcceptor acceptor) {
    return null;
  }
}
