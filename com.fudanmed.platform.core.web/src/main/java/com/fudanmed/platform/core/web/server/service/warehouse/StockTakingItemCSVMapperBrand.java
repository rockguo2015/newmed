package com.fudanmed.platform.core.web.server.service.warehouse;

import com.fudanmed.platform.core.common.proxy.RCMaterialBrandProxy;
import com.fudanmed.platform.core.web.shared.warehouse.UIStockTakingItem;
import edu.fudan.langlab.csv.server.mapper.BaseCSVCustomItemMapper;
import edu.fudan.langlab.csv.server.mapper.IMapperFactory;
import edu.fudan.langlab.csv.shared.IFieldValidationResultAcceptor;
import edu.fudan.mylang.pf.IObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("com.fudanmed.platform.core.web.server.service.warehouse.StockTakingItemCSVMapperBrand")
public class StockTakingItemCSVMapperBrand extends BaseCSVCustomItemMapper<RCMaterialBrandProxy,UIStockTakingItem> {
  @Autowired
  private IMapperFactory mapperFactory;
  
  @Autowired
  private IObjectFactory entities;
  
  public String toString(final RCMaterialBrandProxy value, final UIStockTakingItem context) {
    String _name = value.getName();
    return _name;
  }
  
  protected RCMaterialBrandProxy doFromString(final String value, final UIStockTakingItem context, final IFieldValidationResultAcceptor acceptor) {
    return null;
  }
}
